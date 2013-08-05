package com.baidu.tieba.model;

import com.baidu.android.pushservice.PushConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.a.c {
    private String g;

    /* renamed from: a  reason: collision with root package name */
    private List f1366a = null;
    private String b = null;
    private String c = null;
    private String d = "1";
    private String e = "20";
    private int f = -1;
    private boolean h = false;
    private e i = null;
    private d j = null;

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        return false;
    }

    public void a(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            this.b = str;
            this.d = str2;
            if (this.i == null) {
                this.i = new e(this, null);
                this.i.setPriority(2);
                this.i.execute(new Object[0]);
            }
        }
    }

    public void a(String str) {
        if (str != null && str.length() > 0) {
            this.c = str;
            if (this.j == null) {
                this.j = new d(this, null);
                this.j.setPriority(2);
                this.j.execute(new Object[0]);
            }
        }
    }

    public List a() {
        return this.f1366a;
    }

    public void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("error");
                if (optJSONObject != null) {
                    a(optJSONObject.optInt("errno"));
                    d(optJSONObject.optString("errmsg"));
                }
                this.h = jSONObject.optInt("has_more") != 0;
                JSONArray optJSONArray = jSONObject.optJSONArray("record");
                long currentTimeMillis = System.currentTimeMillis();
                this.f1366a = new ArrayList();
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        com.baidu.tieba.data.a.g gVar = new com.baidu.tieba.data.a.g();
                        gVar.a(this.b);
                        gVar.b(optJSONObject2.optString(PushConstants.EXTRA_USER_ID));
                        gVar.e(optJSONObject2.optString("user_name"));
                        gVar.a(1);
                        gVar.b(optJSONObject2.optLong("time") * 1000);
                        gVar.b(optJSONObject2.optInt("unread_count"));
                        gVar.c(optJSONObject2.optString("portrait"));
                        gVar.a(currentTimeMillis);
                        String optString = optJSONObject2.optString("abstract");
                        if (optString != null && optString.length() >= 1) {
                            gVar.d(optString);
                        }
                        this.f1366a.add(gVar);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public List c(String str) {
        this.f1366a = com.baidu.tieba.data.a.f.a().a(str);
        for (com.baidu.tieba.data.a.g gVar : this.f1366a) {
            gVar.b(0);
        }
        return this.f1366a;
    }

    public boolean b() {
        return this.h;
    }

    public void a(int i) {
        this.f = i;
    }

    public int c() {
        return this.f;
    }

    public void d(String str) {
        this.g = str;
    }

    public String d() {
        return this.g;
    }
}
