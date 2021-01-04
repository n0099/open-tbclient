package com.bytedance.sdk.openadsdk.core.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiContext;
import com.bytedance.sdk.adnet.core.p;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import com.bytedance.sdk.openadsdk.utils.y;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements Runnable {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f6870a;
    private AtomicBoolean d = new AtomicBoolean(false);
    private boolean e = false;
    private Comparator<JSONObject> f = new Comparator<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.h.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
            return jSONObject.optString("package_name").compareTo(jSONObject2.optString("package_name"));
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final Context f6871b = p.a();
    private final a c = new a(this.f6871b);

    public static b a() {
        if (f6870a == null) {
            synchronized (b.class) {
                if (f6870a == null) {
                    f6870a = new b();
                }
            }
        }
        return f6870a;
    }

    private b() {
    }

    public void b() {
        this.e = p.h().E() && com.bytedance.sdk.openadsdk.core.i.c().d().alist();
        if (i.d()) {
            if ((!ad.r() || Build.VERSION.SDK_INT < 29) && !this.d.get()) {
                this.d.set(true);
                try {
                    com.bytedance.sdk.openadsdk.k.a.a().d(this, 1);
                } catch (Throwable th) {
                    u.a("ApplistHelper", "upload sdk applist error: ", th);
                    this.d.set(false);
                }
            }
        }
    }

    private List<JSONObject> b(Context context) {
        List list;
        String str;
        String str2;
        String str3;
        ArrayList arrayList = new ArrayList();
        if (context == null || !this.e) {
            return arrayList;
        }
        try {
            JSONObject jSONObject = new JSONObject(com.bytedance.sdk.openadsdk.core.a.b(C0983b.a("utS\\Ijx.:}oJEviZ;q9Yx;wrpHEDSop\\7hSMzh6Ww}yffH}{<I[VmvQLVf\\G4pp8gdyJdndq7YtZ.lHJft<wemwVu[L|5Sg].Z]Zr3X}{:DwWYWiwl7|iYnxfxpE]ri<3f\\.t;T2}6h7H;.4hE7{x7fKdq[4KsvWYqP4DKE3WQLEx<7HjkQqwUXR}QVW2Wjf"), com.bytedance.sdk.openadsdk.core.b.a()));
            Object invoke = ah.a(jSONObject.optString(AdvanceSetting.CLEAR_NOTIFICATION), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]);
            String optString = jSONObject.optString(Config.PACKAGE_NAME);
            Object invoke2 = ah.a(optString, jSONObject.optString("m2"), Integer.TYPE).invoke(invoke, Integer.valueOf(jSONObject.optInt("f")));
            if ((invoke2 instanceof List) && (list = (List) invoke2) != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof PackageInfo) {
                        PackageInfo packageInfo = (PackageInfo) obj;
                        if (packageInfo.applicationInfo == null) {
                            str = "unknown";
                        } else {
                            try {
                                CharSequence charSequence = (CharSequence) ah.a(optString, "getApplicationLabel", ApplicationInfo.class).invoke(invoke, packageInfo.applicationInfo);
                                if (TextUtils.isEmpty(charSequence)) {
                                    str2 = "unknown";
                                } else {
                                    str2 = charSequence.toString();
                                }
                                str = str2;
                            } catch (Throwable th) {
                                str = "unknown";
                            }
                        }
                        try {
                            ApplicationInfo applicationInfo = (ApplicationInfo) ah.a(optString, "getApplicationInfo", String.class, Integer.TYPE).invoke(invoke, packageInfo.packageName, 0);
                            str3 = applicationInfo != null ? applicationInfo.sourceDir : "unknown";
                        } catch (Throwable th2) {
                            str3 = "unknown";
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("package_name", packageInfo.packageName);
                        jSONObject2.put("first_install_time", packageInfo.firstInstallTime);
                        jSONObject2.put(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, packageInfo.lastUpdateTime);
                        jSONObject2.put(SharedPrefConfig.VERSION_NAME, packageInfo.versionName);
                        jSONObject2.put("version_code", packageInfo.versionCode);
                        jSONObject2.put("app_name", str);
                        jSONObject2.put("app_type", a(packageInfo));
                        jSONObject2.put("apk_dir", str3);
                        arrayList.add(jSONObject2);
                    }
                }
            }
        } catch (Throwable th3) {
            u.a("ApplistHelper", "get install apps error: ", th3);
        }
        return arrayList;
    }

    public List<String> a(Context context) {
        List list;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(com.bytedance.sdk.openadsdk.core.a.b(C0983b.a("utS\\Ijx.:}oJEviZ;q9Yx;wrpHEDSop\\7hSMzh6Ww}yffH}{<I[VmvQLVf\\G4pp8gdyJdndq7YtZ.lHJft<wemwVu[L|5Sg].Z]Zr3X}{:DwWYWiwl7|iYnxfxpE]ri<3f\\.t;T2}6h7H;.4hE7{x7fKdq[4KsvWYqP4DKE3WQLEx<7HjkQqwUXR}QVW2Wjf"), com.bytedance.sdk.openadsdk.core.b.a()));
            Object invoke = ah.a(jSONObject.optString(AdvanceSetting.CLEAR_NOTIFICATION), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]);
            String optString = jSONObject.optString(Config.PACKAGE_NAME);
            Object invoke2 = ah.a(optString, jSONObject.optString("m2"), Integer.TYPE).invoke(invoke, Integer.valueOf(jSONObject.optInt("f")));
            if ((invoke2 instanceof List) && (list = (List) invoke2) != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof PackageInfo) {
                        PackageInfo packageInfo = (PackageInfo) obj;
                        String str2 = "unknown";
                        if (packageInfo.applicationInfo != null) {
                            try {
                                CharSequence charSequence = (CharSequence) ah.a(optString, "getApplicationLabel", ApplicationInfo.class).invoke(invoke, packageInfo.applicationInfo);
                                if (TextUtils.isEmpty(charSequence)) {
                                    str = "unknown";
                                } else {
                                    str = charSequence.toString();
                                }
                                str2 = str;
                            } catch (Throwable th) {
                            }
                        }
                        if (a(packageInfo) != 1) {
                            arrayList.add(str2 + ":" + packageInfo.packageName);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            u.a("ApplistHelper", "loadApps error2: ", th2);
        }
        return arrayList;
    }

    private int a(PackageInfo packageInfo) {
        if (packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 1) == 1) {
            return 1;
        }
        if (String.valueOf(packageInfo.firstInstallTime).endsWith("000")) {
            return 2;
        }
        return packageInfo.applicationInfo.flags & 1;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!x.a(this.f6871b)) {
            this.d.set(false);
            return;
        }
        try {
            boolean c = this.c.c();
            if (c) {
                long currentTimeMillis = System.currentTimeMillis();
                List<JSONObject> b2 = b(this.f6871b);
                u.b("ApplistHelper", "get duration: " + (System.currentTimeMillis() - currentTimeMillis));
                a(b2, c);
            } else {
                this.d.set(false);
            }
        } catch (Throwable th) {
            this.d.set(false);
            u.c("ApplistHelper", "upload sdk runnable error: ", th);
        }
    }

    private boolean a(List<JSONObject> list) {
        if (list == null || list.isEmpty()) {
            u.b("ApplistHelper", "is app change true1");
            return false;
        }
        Collections.sort(list, this.f);
        String b2 = com.bytedance.sdk.openadsdk.core.a.b(this.c.b(), com.bytedance.sdk.openadsdk.core.b.a());
        if (TextUtils.isEmpty(b2)) {
            u.b("ApplistHelper", "is app change true2");
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(b2);
            int length = jSONArray.length();
            if (length == list.size()) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    arrayList.add(jSONArray.getJSONObject(i));
                }
                Collections.sort(arrayList, this.f);
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = list.get(i2);
                    JSONObject jSONObject2 = (JSONObject) arrayList.get(i2);
                    String optString = jSONObject.optString("package_name");
                    String optString2 = jSONObject.optString(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
                    if (optString == null || optString2 == null || !optString.equals(jSONObject2.optString("package_name")) || !optString2.equals(jSONObject2.optString(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME))) {
                        u.b("ApplistHelper", "is app change true3");
                        return true;
                    }
                }
                u.b("ApplistHelper", "is app change false");
                return false;
            }
            u.b("ApplistHelper", "is app change true4");
            return true;
        } catch (Throwable th) {
            u.c("ApplistHelper", "is app change error: ", th);
            return true;
        }
    }

    private void a(final List<JSONObject> list, final boolean z) throws JSONException {
        if (com.bytedance.sdk.openadsdk.core.k.d(this.f6871b) == null && com.bytedance.sdk.openadsdk.core.k.c(this.f6871b) == null && com.bytedance.sdk.openadsdk.core.k.a(this.f6871b) == null && y.a() == null) {
            this.d.set(false);
            u.b("ApplistHelper", "real upload error1");
            return;
        }
        boolean a2 = a(list);
        List<String> B = p.h().B();
        List<String> D = p.h().D();
        if (!a2 && ((B == null || B.isEmpty()) && (D == null || D.isEmpty()))) {
            this.d.set(false);
            u.b("ApplistHelper", "real upload error2");
            return;
        }
        JSONObject a3 = aj.a(a(a2 ? list : new ArrayList<>(), B, D));
        u.b("ApplistHelper", "param:" + (list == null ? 0 : list.size()));
        new com.bytedance.sdk.adnet.b.f(1, aj.q("/api/ad/union/sdk/upload/app_info/"), a3, new p.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.h.b.2
            @Override // com.bytedance.sdk.adnet.core.p.a
            public void a(com.bytedance.sdk.adnet.core.p<JSONObject> pVar) {
                u.b("ApplistHelper", "real upload response");
                if (pVar != null && pVar.a()) {
                    if (pVar.f6344a != null && "20000".equals(pVar.f6344a.optString("status"))) {
                        if (z) {
                            b.this.c.a();
                        }
                        b.this.c.a(com.bytedance.sdk.openadsdk.core.a.a(new JSONArray((Collection) list).toString(), com.bytedance.sdk.openadsdk.core.b.a()));
                        u.b("ApplistHelper", "APP List upload success ! " + pVar.e);
                    } else {
                        u.b("ApplistHelper", "APP List upload failed !");
                    }
                }
                b.this.d.set(false);
            }

            @Override // com.bytedance.sdk.adnet.core.p.a
            public void b(com.bytedance.sdk.adnet.core.p<JSONObject> pVar) {
                if (pVar != null) {
                    u.c("ApplistHelper", "upload failed: code=" + pVar.h, pVar.ppF);
                }
                b.this.d.set(false);
            }
        }).setResponseOnMain(false).setShouldCache(false).build(com.bytedance.sdk.openadsdk.i.e.a(this.f6871b).d());
    }

    @NonNull
    private JSONObject a(List<JSONObject> list, List<String> list2, List<String> list3) {
        Object obj;
        int i = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            Object obj2 = "";
            if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.k.d(this.f6871b))) {
                i = -1;
            } else {
                obj2 = com.bytedance.sdk.openadsdk.core.k.d(this.f6871b);
            }
            if (i < 0 && !TextUtils.isEmpty(y.a())) {
                i = 4;
                obj2 = y.a();
            }
            if (i < 0) {
                i = 3;
                obj = com.bytedance.sdk.openadsdk.core.k.c(this.f6871b);
            } else {
                obj = obj2;
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject2 : list) {
                jSONArray.put(jSONObject2.optString("package_name"));
            }
            jSONObject.put("app_list", jSONArray);
            jSONObject.put("app_info", new JSONArray((Collection) list));
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("device_id", obj);
            jSONObject.put("did", com.bytedance.sdk.openadsdk.core.k.a(this.f6871b));
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_platform", HttpConstants.OS_TYPE_VALUE);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("app_id", com.bytedance.sdk.openadsdk.core.i.c().e());
            jSONObject.put("app_list_type", 1);
            jSONObject.put(SapiContext.KEY_SDK_VERSION, "3.2.5.1");
            jSONObject.put("device_id_type", i);
            if (list2 != null && !list2.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                for (String str : list2) {
                    if (!TextUtils.isEmpty(str)) {
                        if (aj.b(com.bytedance.sdk.openadsdk.core.p.a(), str)) {
                            jSONArray2.put(str);
                        } else {
                            jSONArray3.put(str);
                        }
                    }
                }
                jSONObject.put("have_applist", jSONArray2);
                jSONObject.put("no_applist", jSONArray3);
            }
            if (list3 != null && !list3.isEmpty()) {
                JSONArray jSONArray4 = new JSONArray();
                JSONArray jSONArray5 = new JSONArray();
                for (String str2 : list3) {
                    if (!TextUtils.isEmpty(str2)) {
                        Uri parse = Uri.parse(str2);
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(parse);
                        if (aj.a(com.bytedance.sdk.openadsdk.core.p.a(), intent)) {
                            jSONArray4.put(str2);
                        } else {
                            jSONArray5.put(str2);
                        }
                    }
                }
                jSONObject.put("scheme_success_list", jSONArray4);
                jSONObject.put("scheme_fail_list", jSONArray5);
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        private final SharedPreferences f6876b;

        a(Context context) {
            this.f6876b = context.getSharedPreferences("tt_sp_app_list", 0);
        }

        void a(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_list", "old_app_list", str);
                } else {
                    this.f6876b.edit().putString("old_app_list", str).apply();
                }
            }
        }

        void a() {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_list", "day_update_time", Long.valueOf(System.currentTimeMillis()));
            } else {
                this.f6876b.edit().putLong("day_update_time", System.currentTimeMillis()).apply();
            }
        }

        String b() {
            return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sp_app_list", "old_app_list", "") : this.f6876b.getString("old_app_list", "");
        }

        boolean c() {
            long j;
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                j = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_list", "day_update_time", 0L);
            } else {
                j = this.f6876b.getLong("day_update_time", 0L);
            }
            return !a(j, System.currentTimeMillis());
        }

        private boolean a(long j, long j2) {
            long j3 = j2 - j;
            return j3 < 86400000 && j3 > -86400000 && a(j) == a(j2);
        }

        private long a(long j) {
            return (TimeZone.getDefault().getOffset(j) + j) / 86400000;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0983b {
        static String a(String str) {
            byte[] bytes = str.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] - 3);
            }
            return new String(bytes);
        }
    }
}
