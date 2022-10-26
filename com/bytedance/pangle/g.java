package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.servermanager.MainServerManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final List b;
    public final List c;
    public final Handler e;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new CopyOnWriteArrayList();
        this.c = new ArrayList();
        this.e = new Handler(Looper.getMainLooper());
    }

    public static g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (d == null) {
                synchronized (g.class) {
                    if (d == null) {
                        d = new g();
                    }
                }
            }
            return d;
        }
        return (g) invokeV.objValue;
    }

    private Object[] c() {
        InterceptResult invokeV;
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            synchronized (this.c) {
                if (!this.c.isEmpty()) {
                    objArr = this.c.toArray();
                } else {
                    objArr = null;
                }
            }
            if (objArr == null) {
                return new Object[0];
            }
            return objArr;
        }
        return (Object[]) invokeV.objValue;
    }

    public static void b() {
        ProviderInfo[] providerInfoArr;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            try {
                for (ProviderInfo providerInfo : Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8).providers) {
                    if (!TextUtils.isEmpty(providerInfo.authority)) {
                        if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ZeusConstants.e)) {
                            if (!TextUtils.isEmpty(providerInfo.processName) && providerInfo.processName.contains(":")) {
                                str = providerInfo.processName.split(":")[1];
                                if (((ProviderInfo) Zeus.getServerManagerHashMap().get(str)) != null || !TextUtils.equals(str, "main") || !TextUtils.equals(providerInfo.name, MainServerManager.class.getName())) {
                                    Zeus.getServerManagerHashMap().put(str, providerInfo);
                                }
                            }
                            str = "main";
                            if (((ProviderInfo) Zeus.getServerManagerHashMap().get(str)) != null) {
                            }
                            Zeus.getServerManagerHashMap().put(str, providerInfo);
                        }
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public final void a(int i, int i2, String str, int i3, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), th}) == null) {
            for (Object obj : c()) {
                this.e.post(new Runnable(this, obj, i, i2, str, i3, th) { // from class: com.bytedance.pangle.g.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Object a;
                    public final /* synthetic */ int b;
                    public final /* synthetic */ int c;
                    public final /* synthetic */ String d;
                    public final /* synthetic */ int e;
                    public final /* synthetic */ Throwable f;
                    public final /* synthetic */ g g;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, obj, Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), th};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.g = this;
                        this.a = obj;
                        this.b = i;
                        this.c = i2;
                        this.d = str;
                        this.e = i3;
                        this.f = th;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                ((ZeusPluginEventCallback) this.a).onPluginEvent(this.b, this.c, this.d, this.e, this.f);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                });
            }
        }
    }

    public final synchronized void a(Application application) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, application) == null) {
            synchronized (this) {
                if (this.a) {
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");
                    return;
                }
                a(3000, 0, null, -1, null);
                Zeus.setAppContext(application);
                GlobalParam globalParam = GlobalParam.getInstance();
                globalParam.init();
                if (application != null) {
                    ZeusLogger.setDebug(globalParam.isDebug());
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + application + ", hParam = " + globalParam);
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
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
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
                                com.bytedance.pangle.log.c.a(str, jSONObject, jSONObject2, jSONObject3);
                            }
                        }
                    };
                    synchronized (a.a) {
                        a.a.add(aVar);
                    }
                    b.a();
                    if (Build.VERSION.SDK_INT == 29) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        com.bytedance.pangle.c.e.a.execute(new Runnable(this) { // from class: com.bytedance.pangle.g.2
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
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
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
                                        MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                        });
                    }
                    if (h.d()) {
                        try {
                            FieldUtils.writeField(com.bytedance.pangle.c.a.a(), "mHiddenApiWarningShown", Boolean.TRUE);
                            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
                        } catch (Exception e) {
                            ZeusLogger.e(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e);
                        }
                    }
                    b();
                    ContentProviderManager.getInstance().initSystemContentProviderInfo();
                    com.bytedance.pangle.receiver.b.a(application);
                    this.a = true;
                    a(3100, 0, null, -1, null);
                    return;
                }
                throw new IllegalArgumentException("context must be not null !!!");
            }
        }
    }
}
