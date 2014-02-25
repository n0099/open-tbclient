package com.baidu.tieba.util;

import android.content.IntentFilter;
import com.baidu.gson.JsonArray;
import com.baidu.gson.JsonObject;
import com.baidu.tieba.TiebaApplication;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bg {
    private static final String[] a = {"/c/s/pv", "/c/f/pb/page", "/c/s/msg", "/c/f/pb/floor", "/c/m/getmsg", "/c/u/feed/replyme", "/c/f/forum/search", "/c/f/frs/page", "/c/f/forum/favocommend", "/c/u/user/profile"};
    private static List<Integer> b = new LinkedList();
    private static bg c;
    private static bh d;

    private bg() {
        d = new bh(this, null);
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            TiebaApplication.g().b().registerReceiver(d, intentFilter);
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b(th.getMessage());
        }
    }

    private static synchronized void e() {
        synchronized (bg.class) {
            if (c == null) {
                c = new bg();
            }
        }
    }

    public static bg a() {
        if (c == null) {
            e();
        }
        return c;
    }

    public static int a(String str) {
        if (bs.c(str)) {
            return -1;
        }
        for (int i = 0; i < a.length; i++) {
            if (str.contains(a[i])) {
                return i + 1;
            }
        }
        return -1;
    }

    public synchronized void a(int i, int i2) {
        List<bi> list;
        int i3;
        if (i > 0 && i2 > 0) {
            String a2 = com.baidu.tieba.sharedPref.b.a().a("network_error_record", "");
            if (bs.c(a2)) {
                list = new LinkedList<>();
                bi biVar = new bi(this, null);
                biVar.a = i;
                biVar.b = i2;
                biVar.c = 1;
                list.add(biVar);
            } else {
                List<bi> d2 = d(a2);
                int i4 = -1;
                int i5 = 0;
                while (i5 < d2.size()) {
                    if (d2.get(i5).a == i && d2.get(i5).b == i2) {
                        d2.get(i5).c++;
                        i3 = i5;
                    } else {
                        i3 = i4;
                    }
                    i5++;
                    i4 = i3;
                }
                if (i4 < 0) {
                    bi biVar2 = new bi(this, null);
                    biVar2.a = i;
                    biVar2.b = i2;
                    biVar2.c = 1;
                    d2.add(biVar2);
                }
                list = d2;
            }
            String a3 = a(list);
            if (!bs.c(a3)) {
                com.baidu.tieba.sharedPref.b.a().b("network_error_record", a3);
            }
        }
    }

    public synchronized void b(String str) {
        if (!bs.c(str)) {
            for (bi biVar : d(str)) {
                if (biVar != null) {
                    a(biVar.a, biVar.b);
                }
            }
        }
    }

    public synchronized void b() {
        for (Integer num : b) {
            a(num.intValue(), 2);
        }
    }

    public synchronized void a(int i) {
        if (i > 0) {
            b.add(Integer.valueOf(i));
        }
    }

    public synchronized void b(int i) {
        if (i > 0) {
            b.remove(Integer.valueOf(i));
        }
    }

    public synchronized void c() {
        com.baidu.tieba.sharedPref.b.a().a("network_error_record");
    }

    public static void c(String str) {
        try {
            int a2 = a(str);
            if (a2 > 0) {
                a().b(a2);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
        }
    }

    public synchronized String d() {
        return com.baidu.tieba.sharedPref.b.a().a("network_error_record", "");
    }

    private String a(List<bi> list) {
        JsonArray jsonArray = new JsonArray();
        try {
            for (bi biVar : list) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("port", Integer.valueOf(biVar.a));
                jsonObject.addProperty("action", Integer.valueOf(biVar.b));
                jsonObject.addProperty("count", Integer.valueOf(biVar.c));
                jsonArray.add(jsonObject);
            }
            return jsonArray.toString();
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b(th.getMessage());
            return null;
        }
    }

    private List<bi> d(String str) {
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                bi biVar = new bi(this, null);
                biVar.a = optJSONObject.getInt("port");
                biVar.b = optJSONObject.getInt("action");
                biVar.c = optJSONObject.getInt("count");
                linkedList.add(biVar);
            }
        } catch (JSONException e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
        }
        return linkedList;
    }
}
