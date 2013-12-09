package com.baidu.tieba.model;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.util.DatabaseService;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o {
    private r b = null;
    private s c = null;
    private q d = null;
    private int f = 0;
    private int g = 0;

    /* renamed from: a  reason: collision with root package name */
    protected com.baidu.tieba.m f2042a = null;
    private ArrayList<MarkData> e = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int b(o oVar) {
        int i = oVar.g;
        oVar.g = i - 1;
        return i;
    }

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

    public ArrayList<MarkData> c() {
        return this.e;
    }

    public void a(ArrayList<MarkData> arrayList) {
        this.e = arrayList;
    }

    public void b(ArrayList<MarkData> arrayList) {
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
        ArrayList<MarkData> s = DatabaseService.s();
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
        while (i5 >= 0 && i5 > i - i2) {
            try {
                JSONObject json = this.e.get(i5).toJson();
                if (json == null || i4 < 0) {
                    i3 = i4;
                } else {
                    i3 = i4 + 1;
                    jSONArray2.put(i4, json);
                }
                i5--;
                i4 = i3;
            } catch (Exception e) {
                com.baidu.tieba.util.bd.b(getClass().getName(), "toJson", e.toString());
                jSONArray = null;
            }
        }
        jSONArray = jSONArray2;
        if (jSONArray == null) {
            return null;
        }
        return jSONArray.toString();
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<MarkData> b(String str) {
        JSONObject jSONObject;
        ArrayList<MarkData> arrayList = new ArrayList<>();
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "parserJson", e.toString());
            arrayList = null;
        }
        if (jSONObject.optJSONObject("error").optString("errno").equals(SocialConstants.FALSE)) {
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
            if (jSONObject.optJSONObject("error").optString("errno").equals(SocialConstants.FALSE)) {
                JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    MarkData markData = new MarkData();
                    markData.paserJson(optJSONArray.getJSONObject(i));
                    this.e.add(markData);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(Boolean bool) {
        if (this.b != null) {
            this.b.cancel();
        }
        this.b = new r(this, a());
        this.b.setPriority(3);
        this.b.execute(bool);
    }

    public void g() {
        if (this.c != null) {
            this.c.cancel();
        }
        this.c = new s(this);
        this.c.setPriority(2);
        this.c.execute(new o[0]);
    }

    public void b(int i) {
        if (this.d != null) {
            this.d.cancel();
        }
        if (i < this.e.size() && this.e.get(i) != null && this.e.get(i).getId() != null) {
            this.d = new q(this, this.e.get(i).getId(), i);
            this.d.setPriority(2);
            this.d.execute(new Boolean[0]);
        }
    }

    public int h() {
        return com.baidu.tieba.sharedPref.b.a().a("uploac_mark_offset", 399);
    }

    public void c(int i) {
        com.baidu.tieba.sharedPref.b.a().b("uploac_mark_offset", i);
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

    public void a(com.baidu.tieba.m mVar) {
        this.f2042a = mVar;
    }
}
