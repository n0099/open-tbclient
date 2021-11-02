package com.baidu.wallet.lightapp.ability.a;

import android.app.Activity;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityErrorModel;
import com.baidu.wallet.lightapp.base.LightAppWrapper;
import com.baidu.wallet.lightapp.base.LightappConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Set;
/* loaded from: classes10.dex */
public class d extends com.baidu.wallet.lightapp.ability.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f58612a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f58613b;

    /* renamed from: c  reason: collision with root package name */
    public Method f58614c;

    /* renamed from: d  reason: collision with root package name */
    public Class<?> f58615d;

    /* loaded from: classes10.dex */
    public static class a implements InvocationHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ILightappInvokerCallback f58616a;

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
            this.f58616a = iLightappInvokerCallback;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                if (this.f58616a != null) {
                    if ("onResult".equals(method.getName())) {
                        if (objArr != null && objArr.length >= 2) {
                            this.f58616a.onResult(((Integer) objArr[0]).intValue(), (String) objArr[1]);
                        }
                        return null;
                    }
                    return method.invoke(this.f58616a, objArr);
                }
                return null;
            }
            return invokeLLL.objValue;
        }
    }

    public d() {
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
        this.f58612a = false;
    }

    @Override // com.baidu.wallet.lightapp.ability.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "callNativeVoice" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IPUT, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, CONST_STR, INVOKE, IPUT, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION, IPUT, MOVE_EXCEPTION, CONST_STR, CONST_STR, INVOKE, CONST_STR, INVOKE, IPUT, MOVE_EXCEPTION, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION, IPUT, MOVE_EXCEPTION, CONST_STR, INVOKE, CONSTRUCTOR, IPUT, MOVE_EXCEPTION] complete} */
    @Override // com.baidu.wallet.lightapp.ability.a
    public void a(Activity activity, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, iLightappInvokerCallback, str2) == null) {
            Set<String> methodList = LightAppWrapper.getInstance().getMethodList();
            if (methodList != null && methodList.contains("callNativeVoice")) {
                LightAppWrapper.getInstance().lightappInvoke(activity, str, iLightappInvokerCallback);
                return;
            }
            if (!this.f58612a) {
                try {
                    this.f58613b = Class.forName("com.baidu.walletfacesdk.LightInvokerImpl");
                    Class<?> cls = Class.forName("com.baidu.walletfacesdk.LightInvokerCallback");
                    this.f58615d = cls;
                    this.f58614c = this.f58613b.getDeclaredMethod(LightappConstants.METHOD_INVOKE_BD_WALLET_NATIVE, Context.class, String.class, Boolean.TYPE, cls);
                } finally {
                    try {
                    } finally {
                    }
                }
            }
            if (this.f58613b != null && this.f58615d != null && this.f58614c != null) {
                try {
                    this.f58614c.invoke(null, activity, str, Boolean.valueOf("ONLINE".equals(DebugConfig.getInstance().getEnvironment())), Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{this.f58615d}, new a(iLightappInvokerCallback)));
                    return;
                } catch (Throwable unused) {
                    a(iLightappInvokerCallback, str2, LightappConstants.ERRCODE_INNER_ERROR, "reflect callNativeVoice fail!", "#callNativeVoiceFail");
                    return;
                }
            }
            NativeAbilityErrorModel nativeAbilityErrorModel = new NativeAbilityErrorModel(1);
            NativeAbilityErrorModel.Data data = nativeAbilityErrorModel.cnt;
            data.errCode = "10004";
            data.des = "没有找到对应的方法";
            iLightappInvokerCallback.onResult(1, nativeAbilityErrorModel.toJson());
        }
    }
}
