package com.baidu.wallet.lightapp.base;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.NoProguard;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILightappInvoker;
import com.baidu.wallet.api.ILightappInvokerCallback;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes13.dex */
public class LightappJsBusinessClientPluginProxy implements NoProguard, ILightappInvoker {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = ";";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f51360b;

    /* renamed from: c  reason: collision with root package name */
    public Context f51361c;

    /* renamed from: d  reason: collision with root package name */
    public Method f51362d;

    /* renamed from: e  reason: collision with root package name */
    public Object f51363e;

    /* renamed from: f  reason: collision with root package name */
    public Class<?> f51364f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1121859999, "Lcom/baidu/wallet/lightapp/base/LightappJsBusinessClientPluginProxy;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1121859999, "Lcom/baidu/wallet/lightapp/base/LightappJsBusinessClientPluginProxy;");
        }
    }

    public LightappJsBusinessClientPluginProxy(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51360b = LightappJsBusinessClientPluginProxy.class.getSimpleName();
        this.f51361c = context;
        try {
            Class<?> cls = Class.forName("com.baidu.apollon.xplugin.XPluginInvoker");
            this.f51363e = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            Class<?> cls2 = Class.forName("com.baidu.apollon.xplugin.XPluginServiceCallback");
            this.f51364f = cls2;
            this.f51362d = cls.getMethod("invokePluginService", Context.class, String.class, String.class, String[].class, cls2);
        } catch (Exception e2) {
            throw new RuntimeException("plugin interface failde", e2);
        }
    }

    @Override // com.baidu.wallet.api.ILightappInvoker
    public Set<String> getMethodList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashSet hashSet = new HashSet();
            try {
                this.f51362d.invoke(this.f51363e, this.f51361c, "com.baidu.wallet.plugin", "getMethodList", null, Proxy.newProxyInstance(LightappJsBusinessClientPluginProxy.class.getClassLoader(), new Class[]{this.f51364f}, new a(this, new ILightappInvokerCallback(this, hashSet) { // from class: com.baidu.wallet.lightapp.base.LightappJsBusinessClientPluginProxy.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Set a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ LightappJsBusinessClientPluginProxy f51365b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, hashSet};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f51365b = this;
                        this.a = hashSet;
                    }

                    @Override // com.baidu.wallet.api.ILightappInvokerCallback
                    public void onResult(int i2, String str) {
                        String[] split;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) || TextUtils.isEmpty(str) || (split = str.split(LightappJsBusinessClientPluginProxy.a)) == null || split.length <= 0) {
                            return;
                        }
                        for (String str2 : split) {
                            if (!TextUtils.isEmpty(str2)) {
                                this.a.add(str2);
                            }
                        }
                    }
                })));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return hashSet;
        }
        return (Set) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.ILightappInvoker
    public void lightappInvoke(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, iLightappInvokerCallback) == null) {
            try {
                this.f51362d.invoke(this.f51363e, context, "com.baidu.wallet.plugin", "lightappInvoke", new String[]{str}, Proxy.newProxyInstance(LightappJsBusinessClientPluginProxy.class.getClassLoader(), new Class[]{this.f51364f}, new a(this, iLightappInvokerCallback)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class a implements NoProguard, InvocationHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LightappJsBusinessClientPluginProxy a;

        /* renamed from: b  reason: collision with root package name */
        public ILightappInvokerCallback f51366b;

        public a(LightappJsBusinessClientPluginProxy lightappJsBusinessClientPluginProxy, ILightappInvokerCallback iLightappInvokerCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lightappJsBusinessClientPluginProxy, iLightappInvokerCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lightappJsBusinessClientPluginProxy;
            this.f51366b = iLightappInvokerCallback;
        }

        public void a(String str, String str2) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                try {
                    i2 = Integer.parseInt(str);
                } catch (Throwable unused) {
                    i2 = 1;
                }
                ILightappInvokerCallback iLightappInvokerCallback = this.f51366b;
                if (iLightappInvokerCallback != null) {
                    iLightappInvokerCallback.onResult(i2, str2);
                }
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, obj, method, objArr)) == null) {
                String name = method.getName();
                if ("onCallbackSuccess".equals(name)) {
                    a((String) objArr[0], (String) objArr[1]);
                    return null;
                } else if ("onCallbackFailed".equals(name)) {
                    a((String) objArr[0], ((Integer) objArr[1]).intValue(), (String) objArr[2]);
                    return null;
                } else {
                    return null;
                }
            }
            return invokeLLL.objValue;
        }

        public void a(String str, int i2, String str2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
                try {
                    i3 = Integer.parseInt(str);
                } catch (Throwable unused) {
                    i3 = 1;
                }
                ILightappInvokerCallback iLightappInvokerCallback = this.f51366b;
                if (iLightappInvokerCallback != null) {
                    iLightappInvokerCallback.onResult(i3, str2);
                }
            }
        }
    }
}
