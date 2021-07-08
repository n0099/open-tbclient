package com.baidu.wallet.paysdk;

import android.content.Context;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f25894a;

    /* renamed from: b  reason: collision with root package name */
    public String f25895b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25896c;

    /* renamed from: d  reason: collision with root package name */
    public Class<?> f25897d;

    /* renamed from: e  reason: collision with root package name */
    public Method f25898e;

    /* renamed from: f  reason: collision with root package name */
    public Class<?> f25899f;

    /* loaded from: classes5.dex */
    public static class a implements InvocationHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ILightappInvokerCallback f25905a;

        public a(ILightappInvokerCallback iLightappInvokerCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iLightappInvokerCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25905a = iLightappInvokerCallback;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                if (this.f25905a != null) {
                    if ("onResult".equals(method.getName())) {
                        if (objArr != null && objArr.length >= 2) {
                            this.f25905a.onResult(((Integer) objArr[0]).intValue(), (String) objArr[1]);
                        }
                        return null;
                    }
                    return method.invoke(this.f25905a, objArr);
                }
                return null;
            }
            return invokeLLL.objValue;
        }
    }

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25894a = "";
        this.f25895b = b.class.getSimpleName();
        this.f25896c = false;
        this.f25894a = str;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IPUT, MOVE_EXCEPTION, IGET, CONST_STR, INVOKE, IPUT, MOVE_EXCEPTION] complete} */
    public void a(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, str, iLightappInvokerCallback) == null) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_getMethodList"), new RouterCallback(this, context, str, iLightappInvokerCallback) { // from class: com.baidu.wallet.paysdk.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f25900a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f25901b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ ILightappInvokerCallback f25902c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ b f25903d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, str, iLightappInvokerCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25903d = this;
                    this.f25900a = context;
                    this.f25901b = str;
                    this.f25902c = iLightappInvokerCallback;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Set set;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) && i2 == 0 && hashMap != null && (set = (Set) hashMap.get("data")) != null && set.contains("callNativeVoice")) {
                        LocalRouter.getInstance(this.f25900a).route(this.f25900a, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_invoke").data("options", this.f25901b).data("invoke_callback", this.f25902c), new RouterCallback(this) { // from class: com.baidu.wallet.paysdk.b.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f25904a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f25904a = this;
                            }

                            @Override // com.baidu.wallet.router.RouterCallback
                            public void onResult(int i3, HashMap hashMap2) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i3, hashMap2) == null) {
                                }
                            }
                        });
                        PayStatisticsUtil.onEvent("callNativeVoiceByHostApp");
                    }
                }
            });
            if (!this.f25896c) {
                try {
                    this.f25897d = Class.forName("com.baidu.walletfacesdk.LightInvokerImpl");
                    Class<?> cls = Class.forName("com.baidu.walletfacesdk.LightInvokerCallback");
                    this.f25899f = cls;
                    this.f25898e = this.f25897d.getDeclaredMethod(LightappConstants.METHOD_INVOKE_BD_WALLET_NATIVE, Context.class, String.class, Boolean.TYPE, cls);
                } finally {
                    try {
                    } finally {
                    }
                }
            }
            if (this.f25897d != null && this.f25899f != null && this.f25898e != null) {
                try {
                    this.f25898e.invoke(null, context, str, Boolean.valueOf("ONLINE".equals(DebugConfig.getInstance().getEnvironment())), Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{this.f25899f}, new a(iLightappInvokerCallback)));
                    return;
                } catch (Throwable th) {
                    LogUtil.e(this.f25895b, "reflect callNativeVoice fail!", th);
                    String a2 = a(iLightappInvokerCallback, "reflect callNativeVoice fail!");
                    iLightappInvokerCallback.onResult(1, a2);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(a2);
                    PayStatisticsUtil.onEventWithValues(this.f25894a, arrayList);
                    return;
                }
            }
            String a3 = a(iLightappInvokerCallback, "reflect callNativeVoice fail!");
            iLightappInvokerCallback.onResult(1, a3);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(a3);
            PayStatisticsUtil.onEventWithValues(this.f25894a, arrayList2);
        }
    }

    private String a(ILightappInvokerCallback iLightappInvokerCallback, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, iLightappInvokerCallback, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(RouterCallback.KEY_ERROR_CODE, 10003);
                jSONObject2.put("des", str);
                jSONObject.put("result", 10003);
                jSONObject.put("cnt", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }
}
