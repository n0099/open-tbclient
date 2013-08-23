package com.baidu.tieba.model;

import android.content.SharedPreferences;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.util.DatabaseService;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private h b = null;
    private i c = null;
    private g d = null;
    private int f = 0;
    private int g = 0;

    /* renamed from: a  reason: collision with root package name */
    protected com.baidu.tieba.j f1404a = null;
    private ArrayList e = new ArrayList();

    public int a() {
        if (this.e == null) {
            return 0;
        }
        return this.e.size();
    }

    public int b() {
        return this.g;
    }

    public void a(int i) {
        this.g = i;
    }

    public ArrayList c() {
        return this.e;
    }

    public void a(ArrayList arrayList) {
        this.e = arrayList;
    }

    public void b(ArrayList arrayList) {
        if (this.e != null && arrayList != null) {
            this.e.addAll(arrayList);
        }
    }

    public void a(MarkData markData) {
        this.e.add(markData);
    }

    public int d() {
        if (this.e == null) {
            return 0;
        }
        return this.e.size();
    }

    public int e() {
        return this.f;
    }

    public void f() {
        ArrayList s = DatabaseService.s();
        if (s != null) {
            a(s);
        }
    }

    public String a(int i, int i2) {
        JSONArray jSONArray;
        int i3;
        if (this.e == null) {
            return null;
        }
        if (i >= this.e.size()) {
            i2 -= (i - this.e.size()) - 1;
            i = this.e.size() - 1;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i4 = 0;
        int i5 = i;
        while (true) {
            if (i5 < 0) {
                jSONArray = jSONArray2;
                break;
            } else if (i5 <= i - i2) {
                jSONArray = jSONArray2;
                break;
            } else {
                try {
                    JSONObject json = ((MarkData) this.e.get(i5)).toJson();
                    if (json == null || i4 < 0) {
                        i3 = i4;
                    } else {
                        i3 = i4 + 1;
                        jSONArray2.put(i4, json);
                    }
                    i5--;
                    i4 = i3;
                } catch (Exception e) {
                    com.baidu.tieba.util.aq.b(getClass().getName(), "toJson", e.toString());
                    jSONArray = null;
                }
            }
        }
        if (jSONArray == null) {
            return null;
        }
        return jSONArray.toString();
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList b(String str) {
        JSONObject jSONObject;
        ArrayList arrayList = new ArrayList();
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "parserJson", e.toString());
            arrayList = null;
        }
        if (jSONObject.optJSONObject("error").optString("errno").equals("0")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
            for (int i = 0; i < optJSONArray.length(); i++) {
                MarkData markData = new MarkData();
                markData.paserJson(optJSONArray.getJSONObject(i));
                arrayList.add(markData);
            }
            return arrayList;
        }
        return null;
    }

    public void a(JSONObject jSONObject) {
        try {
            if (jSONObject.optJSONObject("error").optString("errno").equals("0")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    MarkData markData = new MarkData();
                    markData.paserJson(optJSONArray.getJSONObject(i));
                    this.e.add(markData);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(Boolean bool) {
        if (this.b != null) {
            this.b.cancel();
        }
        this.b = new h(this, a());
        this.b.setPriority(3);
        this.b.execute(bool);
    }

    public void g() {
        if (this.c != null) {
            this.c.cancel();
        }
        this.c = new i(this, null);
        this.c.setPriority(2);
        this.c.execute(new f[0]);
    }

    public void b(int i) {
        if (this.d != null) {
            this.d.cancel();
        }
        if (i < this.e.size() && this.e.get(i) != null && ((MarkData) this.e.get(i)).getId() != null) {
            this.d = new g(this, ((MarkData) this.e.get(i)).getId(), i);
            this.d.setPriority(2);
            this.d.execute(new Boolean[0]);
        }
    }

    public int h() {
        return TiebaApplication.g().getSharedPreferences("settings", 0).getInt("uploac_mark_offset", 399);
    }

    public void c(int i) {
        SharedPreferences.Editor edit = TiebaApplication.g().getSharedPreferences("settings", 0).edit();
        edit.putInt("uploac_mark_offset", i);
        edit.commit();
    }

    public void i() {
        if (this.b != null) {
            this.b.cancel();
        }
        if (this.c != null) {
            this.c.cancel();
        }
        if (this.d != null) {
            this.d.cancel();
        }
    }

    public void a(com.baidu.tieba.j jVar) {
        this.f1404a = jVar;
    }
}
