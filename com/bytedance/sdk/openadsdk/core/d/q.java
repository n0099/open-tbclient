package com.bytedance.sdk.openadsdk.core.d;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private String f4404a;
    private String b;
    private String c;
    private String d;
    private List<a> e;

    public String a() {
        return this.f4404a;
    }

    public void a(String str) {
        this.f4404a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public List<a> e() {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        return this.e;
    }

    public void a(List<a> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.e = list;
    }

    public boolean f() {
        return (c() == null || b() == null || a() == null) ? false : true;
    }

    public String g() {
        if (f()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("name", a());
                jSONObject.putOpt("version", b());
                jSONObject.putOpt("main", c());
                jSONObject.putOpt("fallback", d());
                JSONArray jSONArray = new JSONArray();
                if (e() != null) {
                    for (a aVar : e()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("url", aVar.a());
                        jSONObject2.putOpt("md5", aVar.b());
                        jSONObject2.putOpt("level", Integer.valueOf(aVar.c()));
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.putOpt(BdStatsConstant.OpSubType.RESOURCES_ERROR, jSONArray);
                return jSONObject.toString();
            } catch (Throwable th) {
            }
        }
        return null;
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f4405a;
        private String b;
        private int c;

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return this.f4405a != null && this.f4405a.equals(((a) obj).a());
            }
            return super.equals(obj);
        }

        public String a() {
            return this.f4405a;
        }

        public void a(String str) {
            this.f4405a = str;
        }

        public String b() {
            return this.b;
        }

        public void b(String str) {
            this.b = str;
        }

        public int c() {
            return this.c;
        }

        public void a(int i) {
            this.c = i;
        }
    }

    public static q e(String str) {
        if (str == null) {
            return null;
        }
        try {
            return a(new JSONObject(str));
        } catch (Exception e) {
            return null;
        }
    }

    public static q a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            q qVar = new q();
            try {
                qVar.a(jSONObject.getString("name"));
                qVar.b(jSONObject.getString("version"));
                qVar.c(jSONObject.getString("main"));
                String string = jSONObject.getString("fallback");
                qVar.d(string);
                com.bytedance.sdk.openadsdk.core.dynamic.c.a.a(string);
                JSONArray jSONArray = jSONObject.getJSONArray(BdStatsConstant.OpSubType.RESOURCES_ERROR);
                ArrayList arrayList = new ArrayList();
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        a aVar = new a();
                        aVar.a(jSONObject2.getString("url"));
                        aVar.b(jSONObject2.getString("md5"));
                        aVar.a(jSONObject2.getInt("level"));
                        arrayList.add(aVar);
                    }
                }
                qVar.a(arrayList);
                if (qVar.f()) {
                    return qVar;
                }
                return null;
            } catch (Throwable th) {
                return qVar;
            }
        } catch (Throwable th2) {
            return null;
        }
    }
}
