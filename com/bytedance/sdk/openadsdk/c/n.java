package com.bytedance.sdk.openadsdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bytedance.sdk.openadsdk.h.c.c;
import com.bytedance.sdk.openadsdk.utils.s;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class n implements e<c.a> {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.d f28109a = com.bytedance.sdk.openadsdk.core.d.a(e());

    /* renamed from: b  reason: collision with root package name */
    public final Context f28110b;

    public n(Context context) {
        this.f28110b = context;
    }

    private synchronized void b(int i2, long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        Context e2 = e();
        String c2 = c();
        com.bytedance.sdk.openadsdk.multipro.a.a.a(e2, c2, "gen_time <? AND retry >?", new String[]{currentTimeMillis + "", i2 + ""});
    }

    public static String f() {
        return "CREATE TABLE IF NOT EXISTS logstats (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , " + HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM + " INTEGER default 0" + SmallTailInfo.EMOTION_SUFFIX;
    }

    public String c() {
        return "logstats";
    }

    public Context e() {
        Context context = this.f28110b;
        return context == null ? com.bytedance.sdk.openadsdk.core.p.a() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public List<c.a> a(int i2, String str) {
        String str2;
        if (i2 <= 0 || TextUtils.isEmpty(str)) {
            str2 = null;
        } else {
            str2 = str + " DESC limit " + i2;
        }
        String str3 = str2;
        LinkedList linkedList = new LinkedList();
        Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(e(), c(), new String[]{"id", "value"}, null, null, null, null, str3);
        if (a2 != null) {
            while (a2.moveToNext()) {
                try {
                    String string = a2.getString(a2.getColumnIndex("id"));
                    String string2 = a2.getString(a2.getColumnIndex("value"));
                    try {
                        if (string2 == null) {
                            string2 = "";
                        }
                        linkedList.add(new c.a(string, new JSONObject(string2)));
                    } catch (Throwable unused) {
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
    private synchronized void b(List<c.a> list) {
        LinkedList linkedList = new LinkedList();
        for (c.a aVar : list) {
            linkedList.add(aVar.f30020a);
        }
        com.bytedance.sdk.openadsdk.multipro.a.a.a(e(), "UPDATE " + c() + " SET " + HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM + " = " + HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM + "+1 WHERE " + a("id", linkedList, 1000, true));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(c.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", aVar.f30020a);
        contentValues.put("value", aVar.f30021b != null ? aVar.f30021b.toString() : "");
        contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, (Integer) 0);
        com.bytedance.sdk.openadsdk.multipro.a.a.a(e(), c(), contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(List<c.a> list) {
        if (s.a(list)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (c.a aVar : list) {
            linkedList.add(aVar.f30020a);
        }
        com.bytedance.sdk.openadsdk.multipro.a.a.a(e(), "DELETE FROM " + c() + " WHERE " + a("id", linkedList, 1000, true));
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public int b() {
        return this.f28109a.b("stats_serverbusy_retrycount", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(int i2, long j) {
        b(i2, j);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(List<c.a> list, int i2, long j) {
        if (s.a(list)) {
            return;
        }
        try {
            b(list);
            b(i2, j);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public void a(boolean z) {
        this.f28109a.a("stats_serverbusy_flag", z);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public boolean a() {
        return this.f28109a.b("stats_serverbusy_flag", false);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public void a(int i2) {
        this.f28109a.a("stats_serverbusy_retrycount", i2);
    }

    public static String a(String str, List<?> list, int i2, boolean z) {
        int i3;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int min = Math.min(i2, 1000);
        int size = list.size();
        if (size % min == 0) {
            i3 = size / min;
        } else {
            i3 = (size / min) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 * min;
            String a2 = a(TextUtils.join("','", list.subList(i5, Math.min(i5 + min, size))), "");
            if (i4 != 0) {
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
