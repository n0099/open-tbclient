package com.bytedance.sdk.openadsdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bytedance.sdk.openadsdk.utils.s;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f implements e<a> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f27543a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.d f27544b = com.bytedance.sdk.openadsdk.core.d.a(c());

    public f(Context context) {
        this.f27543a = context;
    }

    private synchronized void b(int i, long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        Context c2 = c();
        com.bytedance.sdk.openadsdk.multipro.a.a.a(c2, "adevent", "gen_time <? AND retry >?", new String[]{currentTimeMillis + "", i + ""});
    }

    public static String d() {
        return "CREATE TABLE IF NOT EXISTS adevent (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , " + HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM + " INTEGER default 0" + SmallTailInfo.EMOTION_SUFFIX;
    }

    public Context c() {
        Context context = this.f27543a;
        return context == null ? com.bytedance.sdk.openadsdk.core.p.a() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public List<a> a(int i, String str) {
        String str2;
        if (i <= 0 || TextUtils.isEmpty(str)) {
            str2 = null;
        } else {
            str2 = str + " DESC limit " + i;
        }
        String str3 = str2;
        LinkedList linkedList = new LinkedList();
        Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(c(), "adevent", new String[]{"id", "value"}, null, null, null, null, str3);
        if (a2 != null) {
            while (a2.moveToNext()) {
                try {
                    try {
                        linkedList.add(new a(a2.getString(a2.getColumnIndex("id")), new JSONObject(a2.getString(a2.getColumnIndex("value")))));
                    } catch (JSONException unused) {
                    }
                } finally {
                    if (a2 != null) {
                        a2.close();
                    }
                }
            }
        }
        return linkedList;
    }

    @VisibleForTesting
    private synchronized void b(List<a> list) {
        LinkedList linkedList = new LinkedList();
        for (a aVar : list) {
            linkedList.add(aVar.f27535a);
        }
        com.bytedance.sdk.openadsdk.multipro.a.a.a(c(), "UPDATE adevent SET " + HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM + " = " + HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM + "+1 WHERE " + a("id", linkedList, 1000, true));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", aVar.f27535a);
        contentValues.put("value", aVar.f27536b != null ? aVar.f27536b.toString() : "");
        contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, (Integer) 0);
        com.bytedance.sdk.openadsdk.multipro.a.a.a(c(), "adevent", contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(List<a> list) {
        if (s.a(list)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (a aVar : list) {
            linkedList.add(aVar.f27535a);
        }
        com.bytedance.sdk.openadsdk.multipro.a.a.a(c(), "DELETE FROM adevent WHERE " + a("id", linkedList, 1000, true));
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public int b() {
        return this.f27544b.b("serverbusy_retrycount", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(int i, long j) {
        b(i, j);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(List<a> list, int i, long j) {
        if (s.a(list)) {
            return;
        }
        try {
            b(list);
            b(i, j);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public void a(boolean z) {
        this.f27544b.a("serverbusy_flag", z);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public boolean a() {
        return this.f27544b.b("serverbusy_flag", false);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public void a(int i) {
        this.f27544b.a("serverbusy_retrycount", i);
    }

    public static String a(String str, List<?> list, int i, boolean z) {
        int i2;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int min = Math.min(i, 1000);
        int size = list.size();
        if (size % min == 0) {
            i2 = size / min;
        } else {
            i2 = (size / min) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * min;
            String a2 = a(TextUtils.join("','", list.subList(i4, Math.min(i4 + min, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            sb.append(str);
            sb.append(str2);
            sb.append("('");
            sb.append(a2);
            sb.append("')");
        }
        String sb2 = sb.toString();
        return a(sb2, str + str2 + "('')");
    }

    public static String a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
