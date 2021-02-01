package com.bytedance.sdk.openadsdk.core.d;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private String f6521a;

    /* renamed from: b  reason: collision with root package name */
    private String f6522b;
    private String c;
    private List<a> d;

    public String a() {
        return this.f6521a;
    }

    public void a(String str) {
        this.f6521a = str;
    }

    public String b() {
        return this.f6522b;
    }

    public void b(String str) {
        this.f6522b = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public List<a> d() {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        return this.d;
    }

    public void a(List<a> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.d = list;
    }

    public boolean e() {
        return (c() == null || b() == null || a() == null) ? false : true;
    }

    public String f() {
        if (e()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("name", a());
                jSONObject.putOpt("version", b());
                jSONObject.putOpt("main", c());
                JSONArray jSONArray = new JSONArray();
                if (d() != null) {
                    for (a aVar : d()) {
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
        private String f6523a;

        /* renamed from: b  reason: collision with root package name */
        private String f6524b;
        private int c;

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return this.f6523a != null && this.f6523a.equals(((a) obj).a());
            }
            return super.equals(obj);
        }

        public String a() {
            return this.f6523a;
        }

        public void a(String str) {
            this.f6523a = str;
        }

        public String b() {
            return this.f6524b;
        }

        public void b(String str) {
            this.f6524b = str;
        }

        public int c() {
            return this.c;
        }

        public void a(int i) {
            this.c = i;
        }
    }

    public static p d(String str) {
        if (str == null) {
            return null;
        }
        try {
            return a(new JSONObject(str));
        } catch (Exception e) {
            return null;
        }
    }

    public static p a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            p pVar = new p();
            try {
                pVar.a(jSONObject.getString("name"));
                pVar.b(jSONObject.getString("version"));
                pVar.c(jSONObject.getString("main"));
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
                pVar.a(arrayList);
                if (pVar.e()) {
                    return pVar;
                }
                return null;
            } catch (Throwable th) {
                return pVar;
            }
        } catch (Throwable th2) {
            return null;
        }
    }
}
