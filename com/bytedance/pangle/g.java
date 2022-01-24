package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.ProviderInfo;
import android.text.TextUtils;
import com.android.server.SystemConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.ZeusParam;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.util.FieldUtils;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static volatile g f53125d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public ZeusParam f53126b;

    /* renamed from: c  reason: collision with root package name */
    public List<ZeusPluginStateListener> f53127c;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53127c = Collections.emptyList();
    }

    public static g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f53125d == null) {
                synchronized (g.class) {
                    if (f53125d == null) {
                        f53125d = new g();
                    }
                }
            }
            return f53125d;
        }
        return (g) invokeV.objValue;
    }

    public static void b() {
        ProviderInfo[] providerInfoArr;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            try {
                for (ProviderInfo providerInfo : Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8).providers) {
                    if (!TextUtils.isEmpty(providerInfo.authority)) {
                        if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ZeusConstants.a)) {
                            if (!TextUtils.isEmpty(providerInfo.processName) && providerInfo.processName.contains(":")) {
                                str = providerInfo.processName.split(":")[1];
                                Zeus.getServerManagerHashMap().put(str, providerInfo);
                            }
                            str = "main";
                            Zeus.getServerManagerHashMap().put(str, providerInfo);
                        }
                    }
                }
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public final synchronized void a(Application application, ZeusParam zeusParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, application, zeusParam) == null) {
            synchronized (this) {
                if (this.a) {
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");
                } else if (application != null) {
                    if (zeusParam == null) {
                        zeusParam = new ZeusParam.Builder().build();
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, use default ZeusParam");
                    }
                    this.f53126b = zeusParam;
                    ZeusLogger.setDebug(zeusParam.isDebug());
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + application + ", hParam = " + this.f53126b);
                    if (!this.f53126b.isCloseDefaultReport()) {
                        com.bytedance.pangle.helper.d.a(application, String.valueOf(zeusParam.getAppId()), zeusParam.getChannel(), String.valueOf(zeusParam.getDid().get()));
                    }
                    com.bytedance.pangle.b.b a = com.bytedance.pangle.b.b.a();
                    com.bytedance.pangle.b.a aVar = new com.bytedance.pangle.b.a(this) { // from class: com.bytedance.pangle.g.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ g a;

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
                            this.a = this;
                        }

                        @Override // com.bytedance.pangle.b.a
                        public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLLLL(1048576, this, str, jSONObject, jSONObject2, jSONObject3) == null) {
                                com.bytedance.pangle.log.d.a(str, jSONObject, jSONObject2, jSONObject3);
                            }
                        }
                    };
                    synchronized (a.a) {
                        a.a.add(aVar);
                    }
                    if (this.f53126b.isEnable()) {
                        b.a();
                        if (com.bytedance.pangle.util.g.e()) {
                            com.bytedance.pangle.helper.e.a.execute(new Runnable(this) { // from class: com.bytedance.pangle.g.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ g a;

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
                                    this.a = this;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        try {
                                            SystemConfig.getInstance();
                                        } catch (Throwable unused) {
                                        }
                                    }
                                }
                            });
                        }
                        if (com.bytedance.pangle.util.g.d()) {
                            try {
                                FieldUtils.writeField(com.bytedance.pangle.helper.a.a(), "mHiddenApiWarningShown", Boolean.TRUE);
                                ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
                            } catch (Exception e2) {
                                ZeusLogger.e(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e2);
                            }
                        }
                        b();
                        ContentProviderManager.getInstance().initSystemContentProviderInfo();
                        if (com.bytedance.pangle.helper.c.b(application)) {
                            if (this.f53126b.autoFetch()) {
                                com.bytedance.pangle.download.f.a();
                                com.bytedance.pangle.download.f.b();
                            }
                            PluginManager.getInstance().installFromDownloadDir();
                        }
                        com.bytedance.pangle.receiver.b.a(application);
                    }
                    this.a = true;
                } else {
                    throw new IllegalArgumentException("context must be not null !!!");
                }
            }
        }
    }
}
