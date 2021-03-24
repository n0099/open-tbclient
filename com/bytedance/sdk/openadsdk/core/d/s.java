package com.bytedance.sdk.openadsdk.core.d;

import com.baidu.searchbox.pms.db.PackageTable;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public String f28226a;

    /* renamed from: b  reason: collision with root package name */
    public String f28227b;

    /* renamed from: c  reason: collision with root package name */
    public String f28228c;

    /* renamed from: d  reason: collision with root package name */
    public String f28229d;

    /* renamed from: e  reason: collision with root package name */
    public List<a> f28230e;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f28231a;

        /* renamed from: b  reason: collision with root package name */
        public String f28232b;

        /* renamed from: c  reason: collision with root package name */
        public int f28233c;

        public String a() {
            return this.f28231a;
        }

        public String b() {
            return this.f28232b;
        }

        public int c() {
            return this.f28233c;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                String str = this.f28231a;
                return str != null && str.equals(((a) obj).a());
            }
            return super.equals(obj);
        }

        public void a(String str) {
            this.f28231a = str;
        }

        public void b(String str) {
            this.f28232b = str;
        }

        public void a(int i) {
            this.f28233c = i;
        }
    }

    public String a() {
        return this.f28226a;
    }

    public String b() {
        return this.f28227b;
    }

    public String c() {
        return this.f28228c;
    }

    public String d() {
        return this.f28229d;
    }

    public List<a> e() {
        if (this.f28230e == null) {
            this.f28230e = new ArrayList();
        }
        return this.f28230e;
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
                jSONObject.putOpt(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT, c());
                jSONObject.putOpt("fallback", d());
                JSONArray jSONArray = new JSONArray();
                if (e() != null) {
                    for (a aVar : e()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("url", aVar.a());
                        jSONObject2.putOpt(PackageTable.MD5, aVar.b());
                        jSONObject2.putOpt("level", Integer.valueOf(aVar.c()));
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.putOpt("resources", jSONArray);
                return jSONObject.toString();
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public void a(String str) {
        this.f28226a = str;
    }

    public void b(String str) {
        this.f28227b = str;
    }

    public void c(String str) {
        this.f28228c = str;
    }

    public void d(String str) {
        this.f28229d = str;
    }

    public void a(List<a> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f28230e = list;
    }

    public static s a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            s sVar = new s();
            try {
                sVar.a(jSONObject.getString("name"));
                sVar.b(jSONObject.getString("version"));
                sVar.c(jSONObject.getString(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT));
                String string = jSONObject.getString("fallback");
                sVar.d(string);
                com.bytedance.sdk.openadsdk.core.dynamic.c.a.a(string);
                JSONArray jSONArray = jSONObject.getJSONArray("resources");
                ArrayList arrayList = new ArrayList();
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        a aVar = new a();
                        aVar.a(jSONObject2.getString("url"));
                        aVar.b(jSONObject2.getString(PackageTable.MD5));
                        aVar.a(jSONObject2.getInt("level"));
                        arrayList.add(aVar);
                    }
                }
                sVar.a(arrayList);
                if (!sVar.f()) {
                    return null;
                }
            } catch (Throwable unused) {
            }
            return sVar;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static s e(String str) {
        if (str == null) {
            return null;
        }
        try {
            return a(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }
}
