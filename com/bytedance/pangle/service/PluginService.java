package com.bytedance.pangle.service;

import android.app.Service;
import android.content.ComponentName;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes7.dex */
public abstract class PluginService extends Service implements a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PluginService";
    public transient /* synthetic */ FieldHolder $fh;

    public PluginService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public Object createActivityManagerProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return Proxy.newProxyInstance(getClassLoader(), new Class[]{Class.forName("android.app.IActivityManager")}, new InvocationHandler(this) { // from class: com.bytedance.pangle.service.PluginService.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PluginService a;

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

                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method, Object[] objArr) {
                    InterceptResult invokeLLL;
                    char c;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                        String name = method.getName();
                        int hashCode = name.hashCode();
                        if (hashCode != 39551382) {
                            if (hashCode != 690954390) {
                                if (hashCode == 1930712422 && name.equals("stopServiceToken")) {
                                    c = 0;
                                }
                                c = 65535;
                            } else {
                                if (name.equals("getForegroundServiceType")) {
                                    c = 2;
                                }
                                c = 65535;
                            }
                        } else {
                            if (name.equals("setServiceForeground")) {
                                c = 1;
                            }
                            c = 65535;
                        }
                        if (c != 0) {
                            if (c != 2) {
                                return null;
                            }
                            return 0;
                        }
                        com.bytedance.pangle.service.a.a b = com.bytedance.pangle.service.a.a.b();
                        PluginService pluginService = this.a;
                        return Boolean.valueOf(b.a(new ComponentName(pluginService, pluginService.getClass().getName())));
                    }
                    return invokeLLL.objValue;
                }
            });
        }
        return invokeV.objValue;
    }

    @Override // com.bytedance.pangle.service.a
    public void attach(Plugin plugin) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, plugin) == null) {
            attachBaseContext(ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName));
            try {
                FieldUtils.writeField(this, "mActivityManager", createActivityManagerProxy());
                FieldUtils.writeField(this, "mClassName", getClass().getName());
                FieldUtils.writeField(this, "mApplication", Zeus.getAppApplication());
                if (getApplicationInfo().targetSdkVersion < 5) {
                    z = true;
                } else {
                    z = false;
                }
                FieldUtils.writeField(this, "mStartCompatibility", Boolean.valueOf(z));
            } catch (Exception e) {
                ZeusLogger.e(ZeusLogger.TAG_SERVICE, "hook activityManager failed!", e);
            }
        }
    }
}
