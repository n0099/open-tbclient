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
public class bd {
    private static final String[] a = {"/c/s/pv", "/c/f/pb/page", "/c/s/msg", "/c/f/pb/floor", "/c/m/getmsg", "/c/u/feed/replyme", "/c/f/forum/search", "/c/f/frs/page", "/c/f/forum/favocommend", "/c/u/user/profile"};
    private static List<Integer> b = new LinkedList();
    private static bd c;
    private static bf d;

    private bd() {
        d = new bf(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        TiebaApplication.g().registerReceiver(d, intentFilter);
    }

    private static synchronized void e() {
        synchronized (bd.class) {
            if (c == null) {
                c = new bd();
            }
        }
    }

    public static bd a() {
        if (c == null) {
            e();
        }
        return c;
    }

    public static int a(String str) {
        if (bm.c(str)) {
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
        List<bg> list;
        int i3;
        if (i > 0 && i2 > 0) {
            String a2 = com.baidu.tieba.sharedPref.b.a().a("network_error_record", "");
            if (bm.c(a2)) {
                list = new LinkedList<>();
                bg bgVar = new bg(this);
                bgVar.a = i;
                bgVar.b = i2;
                bgVar.c = 1;
                list.add(bgVar);
            } else {
                List<bg> d2 = d(a2);
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
                    bg bgVar2 = new bg(this);
                    bgVar2.a = i;
                    bgVar2.b = i2;
                    bgVar2.c = 1;
                    d2.add(bgVar2);
                }
                list = d2;
            }
            String a3 = a(list);
            if (!bm.c(a3)) {
                com.baidu.tieba.sharedPref.b.a().b("network_error_record", a3);
            }
        }
    }

    public synchronized void b(String str) {
        if (!bm.c(str)) {
            for (bg bgVar : d(str)) {
                if (bgVar != null) {
                    a(bgVar.a, bgVar.b);
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
            bo.a(e.getMessage());
        }
    }

    public synchronized String d() {
        return com.baidu.tieba.sharedPref.b.a().a("network_error_record", "");
    }

    private String a(List<bg> list) {
        JsonArray jsonArray = new JsonArray();
        for (bg bgVar : list) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("port", Integer.valueOf(bgVar.a));
            jsonObject.addProperty("action", Integer.valueOf(bgVar.b));
            jsonObject.addProperty("count", Integer.valueOf(bgVar.c));
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }

    private List<bg> d(String str) {
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                bg bgVar = new bg(this);
                bgVar.a = optJSONObject.getInt("port");
                bgVar.b = optJSONObject.getInt("action");
                bgVar.c = optJSONObject.getInt("count");
                linkedList.add(bgVar);
            }
        } catch (JSONException e) {
            bo.a(e.getMessage());
        }
        return linkedList;
    }
}
