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
public class bh {
    private static final String[] a = {"/c/s/pv", "/c/f/pb/page", "/c/s/msg", "/c/f/pb/floor", "/c/m/getmsg", "/c/u/feed/replyme", "/c/f/forum/search", "/c/f/frs/page", "/c/f/forum/favocommend", "/c/u/user/profile"};
    private static List<Integer> b = new LinkedList();
    private static bh c;
    private static bj d;

    private bh() {
        d = new bj(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        TiebaApplication.h().registerReceiver(d, intentFilter);
    }

    private static synchronized void e() {
        synchronized (bh.class) {
            if (c == null) {
                c = new bh();
            }
        }
    }

    public static bh a() {
        if (c == null) {
            e();
        }
        return c;
    }

    public static int a(String str) {
        if (bu.c(str)) {
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
        List<bk> list;
        int i3;
        if (i > 0 && i2 > 0) {
            String a2 = com.baidu.tieba.sharedPref.b.a().a("network_error_record", "");
            if (bu.c(a2)) {
                list = new LinkedList<>();
                bk bkVar = new bk(this);
                bkVar.a = i;
                bkVar.b = i2;
                bkVar.c = 1;
                list.add(bkVar);
            } else {
                List<bk> d2 = d(a2);
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
                    bk bkVar2 = new bk(this);
                    bkVar2.a = i;
                    bkVar2.b = i2;
                    bkVar2.c = 1;
                    d2.add(bkVar2);
                }
                list = d2;
            }
            String a3 = a(list);
            if (!bu.c(a3)) {
                com.baidu.tieba.sharedPref.b.a().b("network_error_record", a3);
            }
        }
    }

    public synchronized void b(String str) {
        if (!bu.c(str)) {
            for (bk bkVar : d(str)) {
                if (bkVar != null) {
                    a(bkVar.a, bkVar.b);
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
            com.baidu.adp.lib.g.e.a(e.getMessage());
        }
    }

    public synchronized String d() {
        return com.baidu.tieba.sharedPref.b.a().a("network_error_record", "");
    }

    private String a(List<bk> list) {
        JsonArray jsonArray = new JsonArray();
        try {
            for (bk bkVar : list) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("port", Integer.valueOf(bkVar.a));
                jsonObject.addProperty("action", Integer.valueOf(bkVar.b));
                jsonObject.addProperty("count", Integer.valueOf(bkVar.c));
                jsonArray.add(jsonObject);
            }
            return jsonArray.toString();
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.a(e.getMessage());
            return null;
        }
    }

    private List<bk> d(String str) {
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                bk bkVar = new bk(this);
                bkVar.a = optJSONObject.getInt("port");
                bkVar.b = optJSONObject.getInt("action");
                bkVar.c = optJSONObject.getInt("count");
                linkedList.add(bkVar);
            }
        } catch (JSONException e) {
            com.baidu.adp.lib.g.e.a(e.getMessage());
        }
        return linkedList;
    }
}
