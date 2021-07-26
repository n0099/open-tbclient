package com.bytedance.sdk.openadsdk.core.j;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.callback.NetCallback;
import com.bytedance.sdk.component.net.executor.NetExecutor;
import com.bytedance.sdk.component.net.executor.PostExecutor;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.q.k;
import com.bytedance.sdk.openadsdk.q.q;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f extends com.bytedance.sdk.component.d.g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicLong f30396c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f30397d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f30398e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f30399f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c f30400a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f30401b;

    /* loaded from: classes5.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f30403a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30403a = fVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
                return;
            }
            int intExtra = intent.getIntExtra("b_msg_id", -1);
            if (intExtra == 1) {
                long longExtra = intent.getLongExtra("b_msg_time", -1L);
                if (longExtra > 0) {
                    f.f30396c.set(longExtra);
                }
            } else if (intExtra == 2) {
                try {
                    if (this.f30403a.f30400a != null) {
                        this.f30403a.f30400a.a();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(268267733, "Lcom/bytedance/sdk/openadsdk/core/j/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(268267733, "Lcom/bytedance/sdk/openadsdk/core/j/f;");
                return;
            }
        }
        f30396c = new AtomicLong(0L);
        f30398e = true;
        f30399f = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c cVar) {
        super("SdkSettingsHelper");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30400a = cVar == null ? o.h() : cVar;
        this.f30401b = o.a();
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            try {
                this.f30401b.registerReceiver(new a(), new IntentFilter("com.bytedance.openadsdk.settingReceiver"));
            } catch (Throwable unused) {
            }
        }
    }

    public static f a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cVar)) == null) {
            if (f30397d == null) {
                synchronized (f.class) {
                    try {
                        if (f30397d == null) {
                            f30397d = new f(cVar);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return f30397d;
        }
        return (f) invokeL.objValue;
    }

    private JSONObject a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject)) == null) ? f30398e ? com.bytedance.sdk.component.utils.a.a(jSONObject) : jSONObject : (JSONObject) invokeL.objValue;
    }

    public static void a(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, null, j) == null) || j <= 0 || o.a() == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setPackage(q.d());
            intent.setAction("com.bytedance.openadsdk.settingReceiver");
            intent.putExtra("b_msg_id", 1);
            intent.putExtra("b_msg_time", j);
            Context a2 = o.a();
            a2.sendBroadcast(intent, q.d() + ".openadsdk.permission.TT_PANGOLIN");
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, str, map) == null) {
            int i2 = 1;
            try {
                if (!TextUtils.isEmpty(str) && map != null) {
                    int intValue = Integer.valueOf(map.get("active-control")).intValue();
                    long longValue = Long.valueOf(map.get("ts")).longValue();
                    String str2 = map.get("pst");
                    String a2 = com.bytedance.sdk.openadsdk.n.g.b.a(str + intValue + longValue);
                    if (a2 != null) {
                        if (a2.equalsIgnoreCase(str2)) {
                            i2 = intValue;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            g.a(i2);
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            try {
                Context a2 = o.a();
                File file = new File(Build.VERSION.SDK_INT >= 24 ? new File(a2.getDataDir(), "shared_prefs") : new File(a2.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs"), "tt_sdk_settings.xml");
                if (file.exists() && file.isFile()) {
                    String replace = file.getName().replace(ActivityChooserModel.HISTORY_FILE_EXTENSION, "");
                    if (Build.VERSION.SDK_INT >= 24) {
                        a2.deleteSharedPreferences(replace);
                        return;
                    }
                    a2.getSharedPreferences(replace, 0).edit().clear().apply();
                    com.bytedance.sdk.component.utils.f.c(file);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, null) == null) || o.a() == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setPackage(q.d());
            intent.setAction("com.bytedance.openadsdk.settingReceiver");
            intent.putExtra("b_msg_id", 2);
            Context a2 = o.a();
            a2.sendBroadcast(intent, q.d() + ".openadsdk.permission.TT_PANGOLIN");
        } catch (Throwable unused) {
        }
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f30399f : invokeV.booleanValue;
    }

    private boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.h.d().h()) : invokeV.booleanValue;
    }

    @NonNull
    @Keep
    @JProtect
    private JSONObject j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                int i2 = 1;
                jSONObject.put("ip", com.bytedance.sdk.openadsdk.core.k.c.a(true));
                jSONObject.put("oaid", k.a());
                jSONObject.put("model", Build.MODEL);
                jSONObject.put("conn_type", n.b(this.f30401b));
                jSONObject.put(IAdRequestParam.OS, 1);
                jSONObject.put("oversea_version_type", 0);
                jSONObject.put("os_api", Build.VERSION.SDK_INT);
                jSONObject.put(HttpConstants.OS_VERSION, String.valueOf(Build.VERSION.RELEASE));
                jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, "3.7.0.3");
                jSONObject.put("download_sdk_version", com.bytedance.sdk.openadsdk.downloadnew.a.a());
                jSONObject.put("package_name", q.d());
                if (!q.a()) {
                    i2 = 2;
                }
                jSONObject.put("position", i2);
                jSONObject.put("app_version", q.f());
                jSONObject.put("vendor", Build.MANUFACTURER);
                jSONObject.put("app_id", com.bytedance.sdk.openadsdk.core.h.d().h());
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                jSONObject.put("ts", currentTimeMillis);
                jSONObject.put("req_sign", com.bytedance.sdk.component.utils.e.a(com.bytedance.sdk.openadsdk.core.h.d().h() != null ? com.bytedance.sdk.openadsdk.core.h.d().h().concat(String.valueOf(currentTimeMillis)).concat("3.7.0.3") : ""));
                com.bytedance.sdk.component.utils.k.c("isApplicationForeground", "app_version:" + q.f() + "，vendor:" + Build.MANUFACTURER);
                jSONObject.put("locale_language", com.bytedance.sdk.openadsdk.core.k.c.c());
                jSONObject.put("channel", FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT);
                com.bytedance.sdk.openadsdk.m.a.a(this.f30401b, jSONObject);
                com.bytedance.sdk.openadsdk.m.a.b(this.f30401b, jSONObject);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (i()) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - f30396c.get() < TTAdConstant.AD_MAX_EVENT_TIME) {
                    return;
                }
                f30396c.set(currentTimeMillis);
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    a(currentTimeMillis);
                }
                com.bytedance.sdk.component.d.e.a(this, 10);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.k.a("SdkSettingsHelper", "load sdk settings error: ", th);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!n.a(this.f30401b)) {
                try {
                    this.f30400a.a();
                } catch (Throwable unused) {
                }
            } else if (i()) {
            } else {
                JSONObject j = j();
                PostExecutor postExecutor = com.bytedance.sdk.openadsdk.k.d.b().c().getPostExecutor();
                postExecutor.setUrl(q.l("/api/ad/union/sdk/settings/"));
                postExecutor.addHeader("User-Agent", q.b());
                postExecutor.setJson(a(j).toString());
                postExecutor.enqueue(new NetCallback(this) { // from class: com.bytedance.sdk.openadsdk.core.j.f.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ f f30402a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f30402a = this;
                    }

                    @Override // com.bytedance.sdk.component.net.callback.NetCallback
                    public void onFailure(NetExecutor netExecutor, IOException iOException) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netExecutor, iOException) == null) {
                            try {
                                this.f30402a.f30400a.a();
                                o.h().c();
                            } catch (Throwable unused2) {
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.component.net.callback.NetCallback
                    public void onResponse(NetExecutor netExecutor, NetResponse netResponse) {
                        JSONObject jSONObject;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netExecutor, netResponse) == null) {
                            if (netResponse != null && netResponse.isSuccess() && !TextUtils.isEmpty(netResponse.getBody())) {
                                String str = null;
                                try {
                                    jSONObject = new JSONObject(netResponse.getBody());
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                    jSONObject = null;
                                }
                                if (jSONObject != null) {
                                    if (jSONObject.optInt("cypher", -1) == 3) {
                                        str = com.bytedance.sdk.component.utils.a.b(jSONObject.optString("message"));
                                        if (!TextUtils.isEmpty(str)) {
                                            try {
                                                jSONObject = new JSONObject(str);
                                            } catch (Throwable th) {
                                                com.bytedance.sdk.component.utils.k.a("SdkSettingsHelper", "setting data error2: ", th);
                                            }
                                        }
                                    }
                                    try {
                                        this.f30402a.a(str, netResponse.getHeaders());
                                    } catch (Throwable unused2) {
                                    }
                                    try {
                                        this.f30402a.f30400a.a(jSONObject);
                                        if (!f.f30399f) {
                                            boolean unused3 = f.f30399f = true;
                                            com.bytedance.sdk.openadsdk.m.a.c();
                                        }
                                    } catch (Throwable unused4) {
                                    }
                                    com.bytedance.sdk.openadsdk.j.a.a().b();
                                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                                        f.d();
                                        return;
                                    }
                                    return;
                                }
                            }
                            try {
                                this.f30402a.f30400a.a();
                                o.h().c();
                            } catch (Throwable unused5) {
                            }
                        }
                    }
                });
            }
        }
    }
}
