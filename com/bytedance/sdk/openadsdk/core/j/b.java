package com.bytedance.sdk.openadsdk.core.j;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.callback.NetCallback;
import com.bytedance.sdk.component.net.executor.NetExecutor;
import com.bytedance.sdk.component.net.executor.PostExecutor;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.AppLogHelper;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.r.j;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.io.IOException;
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
public class b extends com.bytedance.sdk.component.e.g {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f30280a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Context f30281b;

    /* renamed from: c  reason: collision with root package name */
    public final a f30282c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f30283d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30284e;

    /* renamed from: f  reason: collision with root package name */
    public Comparator<JSONObject> f30285f;

    /* renamed from: com.bytedance.sdk.openadsdk.core.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0340b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
                byte[] bytes = str.getBytes();
                for (int i2 = 0; i2 < bytes.length; i2++) {
                    bytes[i2] = (byte) (bytes[i2] - 3);
                }
                return new String(bytes);
            }
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("ApplistHelper");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30283d = new AtomicBoolean(false);
        this.f30284e = false;
        this.f30285f = new Comparator<JSONObject>(this) { // from class: com.bytedance.sdk.openadsdk.core.j.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f30286a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f30286a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, jSONObject, jSONObject2)) == null) ? jSONObject.optString("package_name").compareTo(jSONObject2.optString("package_name")) : invokeLL.intValue;
            }
        };
        Context a2 = o.a();
        this.f30281b = a2;
        this.f30282c = new a(this, a2);
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (f30280a == null) {
                synchronized (b.class) {
                    if (f30280a == null) {
                        f30280a = new b();
                    }
                }
            }
            return f30280a;
        }
        return (b) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f30284e = o.h().E() && com.bytedance.sdk.openadsdk.core.h.d().f().alist();
            if (f.f()) {
                if ((!j.r() || Build.VERSION.SDK_INT < 29) && !this.f30283d.get()) {
                    this.f30283d.set(true);
                    try {
                        com.bytedance.sdk.component.e.e.a(this, 1);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.j.a("ApplistHelper", "upload sdk applist error: ", th);
                        this.f30283d.set(false);
                    }
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!m.a(this.f30281b)) {
                this.f30283d.set(false);
                return;
            }
            try {
                boolean c2 = this.f30282c.c();
                if (c2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    List<JSONObject> b2 = b(this.f30281b);
                    com.bytedance.sdk.component.utils.j.b("ApplistHelper", "get duration: " + (System.currentTimeMillis() - currentTimeMillis));
                    a(b2, c2);
                } else {
                    this.f30283d.set(false);
                }
            } catch (Throwable th) {
                this.f30283d.set(false);
                com.bytedance.sdk.component.utils.j.c("ApplistHelper", "upload sdk runnable error: ", th);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:19|20|21|(3:33|34|(6:36|24|25|(1:27)|28|29))|23|24|25|(0)|28|29) */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d3 A[Catch: all -> 0x00d5, TRY_LEAVE, TryCatch #0 {all -> 0x00d5, blocks: (B:28:0x00ae, B:30:0x00d3), top: B:42:0x00ae }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<JSONObject> b(Context context) {
        InterceptResult invokeL;
        List list;
        CharSequence charSequence;
        String charSequence2;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context != null && this.f30284e) {
                try {
                    JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.a.b(C0340b.a("6;37988e9g6h::3<4f9;g437;iei3:d66i5fd<9dde7;f579fUPZmGK\\lXZ2Szig5dHFs58}Sis:eU4fg3JFRho|eROK9Y8U2tY2yOyLKL7yl7YtV}meo.{v;:Oxm#h|Wyszi:Petp;UwqLh9NQq;XiZe3w9]dTjf|jsp}3X5\\dhKrjlho|4Wh4.\\o;vipTtn5oi[i8<tR#H{T7S.\\u5nNpQJV|7khNsW8iH[iLhey;PfqgLhff")));
                    Object invoke = t.a(jSONObject.optString(AdvanceSetting.CLEAR_NOTIFICATION), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]);
                    String optString = jSONObject.optString(Config.PACKAGE_NAME);
                    Object invoke2 = t.a(optString, jSONObject.optString("m2"), Integer.TYPE).invoke(invoke, Integer.valueOf(jSONObject.optInt("f")));
                    if ((invoke2 instanceof List) && (list = (List) invoke2) != null && !list.isEmpty()) {
                        for (Object obj : list) {
                            if (obj instanceof PackageInfo) {
                                PackageInfo packageInfo = (PackageInfo) obj;
                                String str = "unknown";
                                if (packageInfo.applicationInfo != null) {
                                    try {
                                        charSequence = (CharSequence) t.a(optString, "getApplicationLabel", ApplicationInfo.class).invoke(invoke, packageInfo.applicationInfo);
                                    } catch (Throwable unused) {
                                    }
                                    if (!TextUtils.isEmpty(charSequence)) {
                                        charSequence2 = charSequence.toString();
                                        applicationInfo = (ApplicationInfo) t.a(optString, "getApplicationInfo", String.class, Integer.TYPE).invoke(invoke, packageInfo.packageName, 0);
                                        if (applicationInfo != null) {
                                            str = applicationInfo.sourceDir;
                                        }
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("package_name", packageInfo.packageName);
                                        jSONObject2.put("first_install_time", packageInfo.firstInstallTime);
                                        jSONObject2.put(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, packageInfo.lastUpdateTime);
                                        jSONObject2.put("version_name", packageInfo.versionName);
                                        jSONObject2.put("version_code", packageInfo.versionCode);
                                        jSONObject2.put("app_name", charSequence2);
                                        jSONObject2.put("app_type", a(packageInfo));
                                        jSONObject2.put("apk_dir", str);
                                        arrayList.add(jSONObject2);
                                    }
                                }
                                charSequence2 = "unknown";
                                applicationInfo = (ApplicationInfo) t.a(optString, "getApplicationInfo", String.class, Integer.TYPE).invoke(invoke, packageInfo.packageName, 0);
                                if (applicationInfo != null) {
                                }
                                JSONObject jSONObject22 = new JSONObject();
                                jSONObject22.put("package_name", packageInfo.packageName);
                                jSONObject22.put("first_install_time", packageInfo.firstInstallTime);
                                jSONObject22.put(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, packageInfo.lastUpdateTime);
                                jSONObject22.put("version_name", packageInfo.versionName);
                                jSONObject22.put("version_code", packageInfo.versionCode);
                                jSONObject22.put("app_name", charSequence2);
                                jSONObject22.put("app_type", a(packageInfo));
                                jSONObject22.put("apk_dir", str);
                                arrayList.add(jSONObject22);
                            }
                        }
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.j.a("ApplistHelper", "get install apps error: ", th);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public List<String> a(Context context) {
        InterceptResult invokeL;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.a.b(C0340b.a("6;37988e9g6h::3<4f9;g437;iei3:d66i5fd<9dde7;f579fUPZmGK\\lXZ2Szig5dHFs58}Sis:eU4fg3JFRho|eROK9Y8U2tY2yOyLKL7yl7YtV}meo.{v;:Oxm#h|Wyszi:Petp;UwqLh9NQq;XiZe3w9]dTjf|jsp}3X5\\dhKrjlho|4Wh4.\\o;vipTtn5oi[i8<tR#H{T7S.\\u5nNpQJV|7khNsW8iH[iLhey;PfqgLhff")));
                Object invoke = t.a(jSONObject.optString(AdvanceSetting.CLEAR_NOTIFICATION), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]);
                String optString = jSONObject.optString(Config.PACKAGE_NAME);
                Object invoke2 = t.a(optString, jSONObject.optString("m2"), Integer.TYPE).invoke(invoke, Integer.valueOf(jSONObject.optInt("f")));
                if ((invoke2 instanceof List) && (list = (List) invoke2) != null && !list.isEmpty()) {
                    for (Object obj : list) {
                        if (obj instanceof PackageInfo) {
                            PackageInfo packageInfo = (PackageInfo) obj;
                            String str = "unknown";
                            if (packageInfo.applicationInfo != null) {
                                try {
                                    CharSequence charSequence = (CharSequence) t.a(optString, "getApplicationLabel", ApplicationInfo.class).invoke(invoke, packageInfo.applicationInfo);
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
                com.bytedance.sdk.component.utils.j.a("ApplistHelper", "loadApps error2: ", th);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* loaded from: classes5.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f30290a;

        /* renamed from: b  reason: collision with root package name */
        public final SharedPreferences f30291b;

        public a(b bVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30290a = bVar;
            this.f30291b = context.getSharedPreferences("tt_sp_app_list", 0);
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_list", "old_app_list", str);
            } else {
                this.f30291b.edit().putString("old_app_list", str).apply();
            }
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    return com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sp_app_list", "old_app_list", "");
                }
                return this.f30291b.getString("old_app_list", "");
            }
            return (String) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    j = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_list", "day_update_time", 0L);
                } else {
                    j = this.f30291b.getLong("day_update_time", 0L);
                }
                return !com.bytedance.sdk.openadsdk.r.o.a(j, System.currentTimeMillis());
            }
            return invokeV.booleanValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_list", "day_update_time", Long.valueOf(System.currentTimeMillis()));
                } else {
                    this.f30291b.edit().putLong("day_update_time", System.currentTimeMillis()).apply();
                }
            }
        }
    }

    private int a(PackageInfo packageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, packageInfo)) == null) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null || (applicationInfo.flags & 1) == 1) {
                return 1;
            }
            if (String.valueOf(packageInfo.firstInstallTime).endsWith("000")) {
                return 2;
            }
            return 1 & packageInfo.applicationInfo.flags;
        }
        return invokeL.intValue;
    }

    private boolean a(List<JSONObject> list) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                Collections.sort(list, this.f30285f);
                String b2 = com.bytedance.sdk.component.utils.a.b(this.f30282c.b());
                if (TextUtils.isEmpty(b2)) {
                    com.bytedance.sdk.component.utils.j.b("ApplistHelper", "is app change true2");
                    return true;
                }
                try {
                    JSONArray jSONArray = new JSONArray(b2);
                    int length = jSONArray.length();
                    if (length == list.size()) {
                        ArrayList arrayList = new ArrayList();
                        for (int i3 = 0; i3 < length; i3++) {
                            arrayList.add(jSONArray.getJSONObject(i3));
                        }
                        Collections.sort(arrayList, this.f30285f);
                        while (i2 < length) {
                            JSONObject jSONObject = list.get(i2);
                            JSONObject jSONObject2 = (JSONObject) arrayList.get(i2);
                            String optString = jSONObject.optString("package_name");
                            String optString2 = jSONObject.optString(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
                            i2 = (optString != null && optString2 != null && optString.equals(jSONObject2.optString("package_name")) && optString2.equals(jSONObject2.optString(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME))) ? i2 + 1 : 0;
                            com.bytedance.sdk.component.utils.j.b("ApplistHelper", "is app change true3");
                            return true;
                        }
                        com.bytedance.sdk.component.utils.j.b("ApplistHelper", "is app change false");
                        return false;
                    }
                    com.bytedance.sdk.component.utils.j.b("ApplistHelper", "is app change true4");
                    return true;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.j.c("ApplistHelper", "is app change error: ", th);
                    return true;
                }
            }
            com.bytedance.sdk.component.utils.j.b("ApplistHelper", "is app change true1");
            return false;
        }
        return invokeL.booleanValue;
    }

    private void a(List<JSONObject> list, boolean z) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, list, z) == null) {
            if (com.bytedance.sdk.openadsdk.core.j.d(this.f30281b) == null && com.bytedance.sdk.openadsdk.core.j.c(this.f30281b) == null && com.bytedance.sdk.openadsdk.core.j.a(this.f30281b) == null && com.bytedance.sdk.openadsdk.r.i.a() == null) {
                this.f30283d.set(false);
                com.bytedance.sdk.component.utils.j.b("ApplistHelper", "real upload error1");
                return;
            }
            boolean a2 = a(list);
            List<String> B = o.h().B();
            List<String> D = o.h().D();
            if (!a2 && ((B == null || B.isEmpty()) && (D == null || D.isEmpty()))) {
                this.f30283d.set(false);
                com.bytedance.sdk.component.utils.j.b("ApplistHelper", "real upload error2");
                return;
            }
            JSONObject a3 = com.bytedance.sdk.component.utils.a.a(a(a2 ? list : new ArrayList<>(), B, D));
            StringBuilder sb = new StringBuilder();
            sb.append("param:");
            sb.append(list != null ? list.size() : 0);
            com.bytedance.sdk.component.utils.j.b("ApplistHelper", sb.toString());
            PostExecutor postExecutor = com.bytedance.sdk.openadsdk.l.e.b().c().getPostExecutor();
            postExecutor.setUrl(com.bytedance.sdk.openadsdk.r.o.m("/api/ad/union/sdk/upload/app_info/"));
            postExecutor.setJson(a3.toString());
            postExecutor.enqueue(new NetCallback(this, z, list) { // from class: com.bytedance.sdk.openadsdk.core.j.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f30287a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ List f30288b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f30289c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), list};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f30289c = this;
                    this.f30287a = z;
                    this.f30288b = list;
                }

                @Override // com.bytedance.sdk.component.net.callback.NetCallback
                public void onFailure(NetExecutor netExecutor, IOException iOException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netExecutor, iOException) == null) {
                        this.f30289c.f30283d.set(false);
                    }
                }

                @Override // com.bytedance.sdk.component.net.callback.NetCallback
                public void onResponse(NetExecutor netExecutor, NetResponse netResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netExecutor, netResponse) == null) {
                        com.bytedance.sdk.component.utils.j.b("ApplistHelper", "real upload response");
                        if (netResponse != null && netResponse.isSuccess() && !TextUtils.isEmpty(netResponse.getBody())) {
                            try {
                                if ("20000".equals(new JSONObject(netResponse.getBody()).optString("status"))) {
                                    if (this.f30287a) {
                                        this.f30289c.f30282c.a();
                                    }
                                    this.f30289c.f30282c.a(com.bytedance.sdk.component.utils.a.a(new JSONArray((Collection) this.f30288b).toString()));
                                    com.bytedance.sdk.component.utils.j.b("ApplistHelper", "APP List upload success ! ");
                                } else {
                                    com.bytedance.sdk.component.utils.j.b("ApplistHelper", "APP List upload failed !");
                                }
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                        this.f30289c.f30283d.set(false);
                    }
                }
            });
        }
    }

    @NonNull
    private JSONObject a(List<JSONObject> list, List<String> list2, List<String> list3) {
        InterceptResult invokeLLL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, list, list2, list3)) == null) {
            JSONObject jSONObject = new JSONObject();
            int i2 = -1;
            try {
                if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.j.d(this.f30281b))) {
                    obj = "";
                } else {
                    obj = com.bytedance.sdk.openadsdk.core.j.d(this.f30281b);
                    i2 = 1;
                }
                if (i2 < 0 && !TextUtils.isEmpty(com.bytedance.sdk.openadsdk.r.i.a())) {
                    i2 = 4;
                    obj = com.bytedance.sdk.openadsdk.r.i.a();
                }
                if (i2 < 0) {
                    i2 = 3;
                    obj = com.bytedance.sdk.openadsdk.core.j.c(this.f30281b);
                }
                JSONArray jSONArray = new JSONArray();
                for (JSONObject jSONObject2 : list) {
                    jSONArray.put(jSONObject2.optString("package_name"));
                }
                jSONObject.put("app_list", jSONArray);
                jSONObject.put("app_info", new JSONArray((Collection) list));
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put("device_id", obj);
                jSONObject.put("did", com.bytedance.sdk.openadsdk.core.j.a(this.f30281b));
                jSONObject.put("os_api", Build.VERSION.SDK_INT);
                jSONObject.put(HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
                jSONObject.put("device_platform", "android");
                jSONObject.put("device_model", Build.MODEL);
                jSONObject.put("app_id", com.bytedance.sdk.openadsdk.core.h.d().h());
                jSONObject.put("app_list_type", 1);
                jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, "3.6.1.3");
                jSONObject.put("device_id_type", i2);
                if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.j.d(this.f30281b))) {
                    jSONObject.put("imei", "");
                } else {
                    jSONObject.put("imei", com.bytedance.sdk.openadsdk.core.j.d(this.f30281b));
                }
                if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.r.i.a())) {
                    jSONObject.put("oaid", "");
                } else {
                    jSONObject.put("oaid", com.bytedance.sdk.openadsdk.r.i.a());
                }
                if (TextUtils.isEmpty(AppLogHelper.getInstance().getAppLogDid())) {
                    jSONObject.put("applog_did", "");
                } else {
                    jSONObject.put("applog_did", AppLogHelper.getInstance().getAppLogDid());
                }
                if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.j.c(this.f30281b))) {
                    jSONObject.put(IAdRequestParam.ANDROID_ID, "");
                } else {
                    jSONObject.put(IAdRequestParam.ANDROID_ID, com.bytedance.sdk.openadsdk.core.j.c(this.f30281b));
                }
                if (list2 != null && !list2.isEmpty()) {
                    JSONArray jSONArray2 = new JSONArray();
                    JSONArray jSONArray3 = new JSONArray();
                    for (String str : list2) {
                        if (!TextUtils.isEmpty(str)) {
                            if (com.bytedance.sdk.openadsdk.r.o.c(o.a(), str)) {
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
                            if (com.bytedance.sdk.openadsdk.r.o.a(o.a(), intent)) {
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
        return (JSONObject) invokeLLL.objValue;
    }
}
