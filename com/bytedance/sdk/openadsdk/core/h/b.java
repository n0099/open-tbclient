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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import com.bytedance.sdk.openadsdk.AppLogHelper;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ae;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import com.bytedance.sdk.openadsdk.utils.y;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import d.c.c.b.d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends com.bytedance.sdk.openadsdk.l.g {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f28090a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f28091b;

    /* renamed from: c  reason: collision with root package name */
    public final a f28092c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f28093d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28094e;

    /* renamed from: f  reason: collision with root package name */
    public Comparator<JSONObject> f28095f;

    /* renamed from: com.bytedance.sdk.openadsdk.core.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0313b {
        public static String a(String str) {
            byte[] bytes = str.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] - 3);
            }
            return new String(bytes);
        }
    }

    public b() {
        super("ApplistHelper");
        this.f28093d = new AtomicBoolean(false);
        this.f28094e = false;
        this.f28095f = new Comparator<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.h.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                return jSONObject.optString("package_name").compareTo(jSONObject2.optString("package_name"));
            }
        };
        Context a2 = p.a();
        this.f28091b = a2;
        this.f28092c = new a(a2);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!x.a(this.f28091b)) {
            this.f28093d.set(false);
            return;
        }
        try {
            boolean c2 = this.f28092c.c();
            if (c2) {
                long currentTimeMillis = System.currentTimeMillis();
                List<JSONObject> b2 = b(this.f28091b);
                u.b("ApplistHelper", "get duration: " + (System.currentTimeMillis() - currentTimeMillis));
                a(b2, c2);
            } else {
                this.f28093d.set(false);
            }
        } catch (Throwable th) {
            this.f28093d.set(false);
            u.c("ApplistHelper", "upload sdk runnable error: ", th);
        }
    }

    public static b a() {
        if (f28090a == null) {
            synchronized (b.class) {
                if (f28090a == null) {
                    f28090a = new b();
                }
            }
        }
        return f28090a;
    }

    public void b() {
        this.f28094e = p.h().D() && com.bytedance.sdk.openadsdk.core.i.d().e().alist();
        if (f.d()) {
            if ((!ae.r() || Build.VERSION.SDK_INT < 29) && !this.f28093d.get()) {
                this.f28093d.set(true);
                try {
                    com.bytedance.sdk.openadsdk.l.e.a(this, 1);
                } catch (Throwable th) {
                    u.a("ApplistHelper", "upload sdk applist error: ", th);
                    this.f28093d.set(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public final SharedPreferences f28101b;

        public a(Context context) {
            this.f28101b = context.getSharedPreferences("tt_sp_app_list", 0);
        }

        public void a(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_list", "old_app_list", str);
            } else {
                this.f28101b.edit().putString("old_app_list", str).apply();
            }
        }

        public String b() {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sp_app_list", "old_app_list", "");
            }
            return this.f28101b.getString("old_app_list", "");
        }

        public boolean c() {
            long j;
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                j = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_list", "day_update_time", 0L);
            } else {
                j = this.f28101b.getLong("day_update_time", 0L);
            }
            return !ak.a(j, System.currentTimeMillis());
        }

        public void a() {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_list", "day_update_time", Long.valueOf(System.currentTimeMillis()));
            } else {
                this.f28101b.edit().putLong("day_update_time", System.currentTimeMillis()).apply();
            }
        }
    }

    public List<String> a(Context context) {
        List list;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(com.bytedance.sdk.openadsdk.core.a.b(C0313b.a("utS\\Ijx.:}oJEviZ;q9Yx;wrpHEDSop\\7hSMzh6Ww}yffH}{<I[VmvQLVf\\G4pp8gdyJdndq7YtZ.lHJft<wemwVu[L|5Sg].Z]Zr3X}{:DwWYWiwl7|iYnxfxpE]ri<3f\\.t;T2}6h7H;.4hE7{x7fKdq[4KsvWYqP4DKE3WQLEx<7HjkQqwUXR}QVW2Wjf"), com.bytedance.sdk.openadsdk.core.b.a()));
            Object invoke = ai.a(jSONObject.optString(AdvanceSetting.CLEAR_NOTIFICATION), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]);
            String optString = jSONObject.optString(Config.PACKAGE_NAME);
            Object invoke2 = ai.a(optString, jSONObject.optString("m2"), Integer.TYPE).invoke(invoke, Integer.valueOf(jSONObject.optInt("f")));
            if ((invoke2 instanceof List) && (list = (List) invoke2) != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof PackageInfo) {
                        PackageInfo packageInfo = (PackageInfo) obj;
                        String str = "unknown";
                        if (packageInfo.applicationInfo != null) {
                            try {
                                CharSequence charSequence = (CharSequence) ai.a(optString, "getApplicationLabel", ApplicationInfo.class).invoke(invoke, packageInfo.applicationInfo);
                                if (!TextUtils.isEmpty(charSequence)) {
                                    str = charSequence.toString();
                                }
                            } catch (Throwable unused) {
                            }
                        }
                        if (a(packageInfo) != 1) {
                            arrayList.add(str + ":" + packageInfo.packageName);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            u.a("ApplistHelper", "loadApps error2: ", th);
        }
        return arrayList;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:17|18|19|(3:31|32|(6:34|22|23|(1:25)|26|27))|21|22|23|(0)|26|27) */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d3 A[Catch: all -> 0x00d5, TRY_LEAVE, TryCatch #0 {all -> 0x00d5, blocks: (B:26:0x00ae, B:28:0x00d3), top: B:36:0x00ae }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<JSONObject> b(Context context) {
        List list;
        CharSequence charSequence;
        String charSequence2;
        ApplicationInfo applicationInfo;
        ArrayList arrayList = new ArrayList();
        if (context != null && this.f28094e) {
            try {
                JSONObject jSONObject = new JSONObject(com.bytedance.sdk.openadsdk.core.a.b(C0313b.a("utS\\Ijx.:}oJEviZ;q9Yx;wrpHEDSop\\7hSMzh6Ww}yffH}{<I[VmvQLVf\\G4pp8gdyJdndq7YtZ.lHJft<wemwVu[L|5Sg].Z]Zr3X}{:DwWYWiwl7|iYnxfxpE]ri<3f\\.t;T2}6h7H;.4hE7{x7fKdq[4KsvWYqP4DKE3WQLEx<7HjkQqwUXR}QVW2Wjf"), com.bytedance.sdk.openadsdk.core.b.a()));
                Object invoke = ai.a(jSONObject.optString(AdvanceSetting.CLEAR_NOTIFICATION), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]);
                String optString = jSONObject.optString(Config.PACKAGE_NAME);
                Object invoke2 = ai.a(optString, jSONObject.optString("m2"), Integer.TYPE).invoke(invoke, Integer.valueOf(jSONObject.optInt("f")));
                if ((invoke2 instanceof List) && (list = (List) invoke2) != null && !list.isEmpty()) {
                    for (Object obj : list) {
                        if (obj instanceof PackageInfo) {
                            PackageInfo packageInfo = (PackageInfo) obj;
                            String str = "unknown";
                            if (packageInfo.applicationInfo != null) {
                                try {
                                    charSequence = (CharSequence) ai.a(optString, "getApplicationLabel", ApplicationInfo.class).invoke(invoke, packageInfo.applicationInfo);
                                } catch (Throwable unused) {
                                }
                                if (!TextUtils.isEmpty(charSequence)) {
                                    charSequence2 = charSequence.toString();
                                    applicationInfo = (ApplicationInfo) ai.a(optString, "getApplicationInfo", String.class, Integer.TYPE).invoke(invoke, packageInfo.packageName, 0);
                                    if (applicationInfo != null) {
                                        str = applicationInfo.sourceDir;
                                    }
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("package_name", packageInfo.packageName);
                                    jSONObject2.put("first_install_time", packageInfo.firstInstallTime);
                                    jSONObject2.put(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, packageInfo.lastUpdateTime);
                                    jSONObject2.put("version_name", packageInfo.versionName);
                                    jSONObject2.put("version_code", packageInfo.versionCode);
                                    jSONObject2.put(DpStatConstants.KEY_APP_NAME, charSequence2);
                                    jSONObject2.put("app_type", a(packageInfo));
                                    jSONObject2.put("apk_dir", str);
                                    arrayList.add(jSONObject2);
                                }
                            }
                            charSequence2 = "unknown";
                            applicationInfo = (ApplicationInfo) ai.a(optString, "getApplicationInfo", String.class, Integer.TYPE).invoke(invoke, packageInfo.packageName, 0);
                            if (applicationInfo != null) {
                            }
                            JSONObject jSONObject22 = new JSONObject();
                            jSONObject22.put("package_name", packageInfo.packageName);
                            jSONObject22.put("first_install_time", packageInfo.firstInstallTime);
                            jSONObject22.put(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, packageInfo.lastUpdateTime);
                            jSONObject22.put("version_name", packageInfo.versionName);
                            jSONObject22.put("version_code", packageInfo.versionCode);
                            jSONObject22.put(DpStatConstants.KEY_APP_NAME, charSequence2);
                            jSONObject22.put("app_type", a(packageInfo));
                            jSONObject22.put("apk_dir", str);
                            arrayList.add(jSONObject22);
                        }
                    }
                }
            } catch (Throwable th) {
                u.a("ApplistHelper", "get install apps error: ", th);
            }
        }
        return arrayList;
    }

    private int a(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null || (applicationInfo.flags & 1) == 1) {
            return 1;
        }
        if (String.valueOf(packageInfo.firstInstallTime).endsWith("000")) {
            return 2;
        }
        return 1 & packageInfo.applicationInfo.flags;
    }

    private boolean a(List<JSONObject> list) {
        int i;
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, this.f28095f);
            String b2 = com.bytedance.sdk.openadsdk.core.a.b(this.f28092c.b(), com.bytedance.sdk.openadsdk.core.b.a());
            if (TextUtils.isEmpty(b2)) {
                u.b("ApplistHelper", "is app change true2");
                return true;
            }
            try {
                JSONArray jSONArray = new JSONArray(b2);
                int length = jSONArray.length();
                if (length == list.size()) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < length; i2++) {
                        arrayList.add(jSONArray.getJSONObject(i2));
                    }
                    Collections.sort(arrayList, this.f28095f);
                    while (i < length) {
                        JSONObject jSONObject = list.get(i);
                        JSONObject jSONObject2 = (JSONObject) arrayList.get(i);
                        String optString = jSONObject.optString("package_name");
                        String optString2 = jSONObject.optString(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
                        i = (optString != null && optString2 != null && optString.equals(jSONObject2.optString("package_name")) && optString2.equals(jSONObject2.optString(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME))) ? i + 1 : 0;
                        u.b("ApplistHelper", "is app change true3");
                        return true;
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
        u.b("ApplistHelper", "is app change true1");
        return false;
    }

    private void a(final List<JSONObject> list, final boolean z) throws JSONException {
        if (k.d(this.f28091b) == null && k.c(this.f28091b) == null && k.a(this.f28091b) == null && y.a() == null) {
            this.f28093d.set(false);
            u.b("ApplistHelper", "real upload error1");
            return;
        }
        boolean a2 = a(list);
        List<String> A = p.h().A();
        List<String> C = p.h().C();
        if (!a2 && ((A == null || A.isEmpty()) && (C == null || C.isEmpty()))) {
            this.f28093d.set(false);
            u.b("ApplistHelper", "real upload error2");
            return;
        }
        JSONObject a3 = ak.a(a(a2 ? list : new ArrayList<>(), A, C));
        StringBuilder sb = new StringBuilder();
        sb.append("param:");
        sb.append(list == null ? 0 : list.size());
        u.b("ApplistHelper", sb.toString());
        new d.c.c.b.b.f(1, ak.l("/api/ad/union/sdk/upload/app_info/"), a3, new o.a<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.h.b.2
            @Override // d.c.c.b.d.o.a
            public void a(o<JSONObject> oVar) {
                u.b("ApplistHelper", "real upload response");
                if (oVar != null && oVar.f()) {
                    JSONObject jSONObject = oVar.f66679a;
                    if (jSONObject != null && "20000".equals(jSONObject.optString("status"))) {
                        if (z) {
                            b.this.f28092c.a();
                        }
                        b.this.f28092c.a(com.bytedance.sdk.openadsdk.core.a.a(new JSONArray((Collection) list).toString(), com.bytedance.sdk.openadsdk.core.b.a()));
                        u.b("ApplistHelper", "APP List upload success ! " + oVar.f66683e);
                    } else {
                        u.b("ApplistHelper", "APP List upload failed !");
                    }
                }
                b.this.f28093d.set(false);
            }

            @Override // d.c.c.b.d.o.a
            public void b(o<JSONObject> oVar) {
                if (oVar != null) {
                    u.c("ApplistHelper", "upload failed: code=" + oVar.f66686h, oVar.f66681c);
                }
                b.this.f28093d.set(false);
            }
        }).setResponseOnMain(false).setShouldCache(false).build(com.bytedance.sdk.openadsdk.i.e.c().e());
    }

    @NonNull
    private JSONObject a(List<JSONObject> list, List<String> list2, List<String> list3) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        int i = -1;
        try {
            if (TextUtils.isEmpty(k.d(this.f28091b))) {
                obj = "";
            } else {
                obj = k.d(this.f28091b);
                i = 1;
            }
            if (i < 0 && !TextUtils.isEmpty(y.a())) {
                i = 4;
                obj = y.a();
            }
            if (i < 0) {
                i = 3;
                obj = k.c(this.f28091b);
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject2 : list) {
                jSONArray.put(jSONObject2.optString("package_name"));
            }
            jSONObject.put("app_list", jSONArray);
            jSONObject.put("app_info", new JSONArray((Collection) list));
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(Constants.KEY_DEVICE_ID, obj);
            jSONObject.put("did", k.a(this.f28091b));
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_platform", "android");
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put(com.xiaomi.mipush.sdk.Constants.APP_ID, com.bytedance.sdk.openadsdk.core.i.d().g());
            jSONObject.put("app_list_type", 1);
            jSONObject.put("sdk_version", "3.4.5.5");
            jSONObject.put("device_id_type", i);
            if (TextUtils.isEmpty(k.d(this.f28091b))) {
                jSONObject.put("imei", "");
            } else {
                jSONObject.put("imei", k.d(this.f28091b));
            }
            if (TextUtils.isEmpty(y.a())) {
                jSONObject.put("oaid", "");
            } else {
                jSONObject.put("oaid", y.a());
            }
            if (TextUtils.isEmpty(d.c.b.a.g())) {
                jSONObject.put("applog_did", "");
            } else {
                jSONObject.put("applog_did", AppLogHelper.getInstance().getAppLogDid());
            }
            if (TextUtils.isEmpty(k.c(this.f28091b))) {
                jSONObject.put(IAdRequestParam.ANDROID_ID, "");
            } else {
                jSONObject.put(IAdRequestParam.ANDROID_ID, k.c(this.f28091b));
            }
            if (list2 != null && !list2.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                for (String str : list2) {
                    if (!TextUtils.isEmpty(str)) {
                        if (ak.c(p.a(), str)) {
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
                        if (ak.a(p.a(), intent)) {
                            jSONArray4.put(str2);
                        } else {
                            jSONArray5.put(str2);
                        }
                    }
                }
                jSONObject.put("scheme_success_list", jSONArray4);
                jSONObject.put("scheme_fail_list", jSONArray5);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
