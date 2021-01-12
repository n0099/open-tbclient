package com.bytedance.sdk.openadsdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.openadsdk.h.b.c;
import com.bytedance.sdk.openadsdk.utils.s;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class n implements e<c.a> {

    /* renamed from: a  reason: collision with root package name */
    protected final com.bytedance.sdk.openadsdk.core.d f6244a = com.bytedance.sdk.openadsdk.core.d.a(f());

    /* renamed from: b  reason: collision with root package name */
    private final Context f6245b;

    public n(Context context) {
        this.f6245b = context;
    }

    public Context f() {
        return this.f6245b == null ? com.bytedance.sdk.openadsdk.core.p.a() : this.f6245b;
    }

    public String d() {
        return "logstats";
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized List<c.a> a() {
        return a(-1, (String) null);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Override // com.bytedance.sdk.openadsdk.c.e
    public List<c.a> a(int i, String str) {
        String str2 = (i <= 0 || TextUtils.isEmpty(str)) ? null : str + " DESC limit " + i;
        LinkedList linkedList = new LinkedList();
        Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(f(), d(), new String[]{"id", "value"}, null, null, null, null, str2);
        if (a2 != null) {
            while (a2.moveToNext()) {
                try {
                    try {
                        linkedList.add(new c.a(a2.getString(a2.getColumnIndex("id")), new JSONObject(a2.getString(a2.getColumnIndex("value")))));
                    } catch (JSONException e) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(c.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", aVar.f7182a);
        contentValues.put("value", aVar.f7183b != null ? aVar.f7183b.toString() : "");
        contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("retry", (Integer) 0);
        com.bytedance.sdk.openadsdk.multipro.a.a.a(f(), d(), contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(List<c.a> list) {
        if (!s.a(list)) {
            LinkedList linkedList = new LinkedList();
            for (c.a aVar : list) {
                linkedList.add(aVar.f7182a);
            }
            com.bytedance.sdk.openadsdk.multipro.a.a.a(f(), "DELETE FROM " + d() + " WHERE " + a("id", linkedList, 1000, true));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(int i, long j) {
        b(i, j);
    }

    private synchronized void b(int i, long j) {
        com.bytedance.sdk.openadsdk.multipro.a.a.a(f(), d(), "gen_time <? AND retry >?", new String[]{(System.currentTimeMillis() - j) + "", i + ""});
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(List<c.a> list, int i, long j) {
        if (!s.a(list)) {
            try {
                b(list);
                b(i, j);
            } catch (Exception e) {
            }
        }
    }

    @VisibleForTesting
    private synchronized void b(List<c.a> list) {
        LinkedList linkedList = new LinkedList();
        for (c.a aVar : list) {
            linkedList.add(aVar.f7182a);
        }
        com.bytedance.sdk.openadsdk.multipro.a.a.a(f(), "UPDATE " + d() + " SET retry = retry+1 WHERE " + a("id", linkedList, 1000, true));
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public void a(boolean z) {
        this.f6244a.a("stats_serverbusy_flag", z);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public boolean b() {
        return this.f6244a.b("stats_serverbusy_flag", false);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public int c() {
        return this.f6244a.b("stats_serverbusy_retrycount", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public void a(int i) {
        this.f6244a.a("stats_serverbusy_retrycount", i);
    }

    public static String g() {
        return "CREATE TABLE IF NOT EXISTS logstats (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0)";
    }

    private static String a(String str, List<?> list, int i, boolean z) {
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
            sb.append(str).append(str2).append("('").append(a2).append("')");
        }
        return a(sb.toString(), str + str2 + "('')");
    }

    private static String a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
