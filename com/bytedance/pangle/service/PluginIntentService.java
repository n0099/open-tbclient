package com.bytedance.pangle.service;

import android.app.IntentService;
import android.content.ComponentName;
import androidx.annotation.Keep;
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
@Keep
/* loaded from: classes3.dex */
public abstract class PluginIntentService extends IntentService implements a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PluginService";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginIntentService(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
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
    }

    @Override // com.bytedance.pangle.service.a
    public void attach(Plugin plugin2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, plugin2) == null) {
            attachBaseContext(ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin2.mPkgName));
            try {
                FieldUtils.writeField(this, "mActivityManager", createActivityManagerProxy());
                FieldUtils.writeField(this, "mClassName", getClass().getName());
                FieldUtils.writeField(this, "mApplication", Zeus.getAppApplication());
                FieldUtils.writeField(this, "mStartCompatibility", Boolean.valueOf(getApplicationInfo().targetSdkVersion < 5));
            } catch (Exception e2) {
                ZeusLogger.e(ZeusLogger.TAG_SERVICE, "hook activityManager failed!", e2);
            }
        }
    }

    public Object createActivityManagerProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Proxy.newProxyInstance(getClassLoader(), new Class[]{Class.forName("android.app.IActivityManager")}, new InvocationHandler(this) { // from class: com.bytedance.pangle.service.PluginIntentService.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PluginIntentService a;

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

            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                InterceptResult invokeLLL;
                char c2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                    String name = method.getName();
                    int hashCode = name.hashCode();
                    if (hashCode == 39551382) {
                        if (name.equals("setServiceForeground")) {
                            c2 = 1;
                        }
                        c2 = 65535;
                    } else if (hashCode != 690954390) {
                        if (hashCode == 1930712422 && name.equals("stopServiceToken")) {
                            c2 = 0;
                        }
                        c2 = 65535;
                    } else {
                        if (name.equals("getForegroundServiceType")) {
                            c2 = 2;
                        }
                        c2 = 65535;
                    }
                    if (c2 != 0) {
                        return c2 != 2 ? null : 0;
                    }
                    com.bytedance.pangle.service.a.a b2 = com.bytedance.pangle.service.a.a.b();
                    PluginIntentService pluginIntentService = this.a;
                    return Boolean.valueOf(b2.a(new ComponentName(pluginIntentService, pluginIntentService.getClass().getName())));
                }
                return invokeLLL.objValue;
            }
        }) : invokeV.objValue;
    }
}
