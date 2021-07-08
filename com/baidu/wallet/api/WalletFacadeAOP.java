package com.baidu.wallet.api;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.ShortCompanionObject;
/* loaded from: classes5.dex */
public class WalletFacadeAOP implements NoProguard, InvocationHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final IWalletFacade f23898a;

    public WalletFacadeAOP(IWalletFacade iWalletFacade) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iWalletFacade};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23898a = iWalletFacade;
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? BaiduWalletDelegate.getInstance().getAppContext() == null : invokeV.booleanValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            CrabHelper.initCrab(BaiduWalletDelegate.getInstance().getAppContext());
            WalletLoginHelper.getInstance().clearOpenBduss();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, method, objArr)) == null) {
            if (method != null && a(method.getName())) {
                LogUtil.d(CrabHelper.CRAB_TAG, "crab aop init before method: " + method.getName());
                try {
                    if (a()) {
                        return a(method.getReturnType());
                    }
                    b();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            Object invoke = method.invoke(this.f23898a, objArr);
            if (method != null && a(method.getName())) {
                try {
                    c();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            return invoke;
        }
        return invokeLLL.objValue;
    }

    private Object a(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, cls)) == null) {
            try {
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            }
            if (cls.isPrimitive()) {
                if (cls == Boolean.TYPE) {
                    return Boolean.FALSE;
                }
                if (cls == Character.TYPE) {
                    return (char) 0;
                }
                if (cls == Byte.TYPE) {
                    return Byte.valueOf((byte) ByteCompanionObject.MIN_VALUE);
                }
                if (cls == Short.TYPE) {
                    return Short.valueOf((short) ShortCompanionObject.MIN_VALUE);
                }
                if (cls == Integer.TYPE) {
                    return Integer.MIN_VALUE;
                }
                if (cls == Long.TYPE) {
                    return Long.MIN_VALUE;
                }
                if (cls == Float.TYPE) {
                    return Float.valueOf(Float.MIN_VALUE);
                }
                if (cls == Double.TYPE) {
                    return Double.valueOf(Double.MIN_VALUE);
                }
                if (cls == Void.TYPE) {
                    return null;
                }
                return new Object();
            }
            return cls.newInstance();
        }
        return invokeL.objValue;
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            if ("initWallet".equals(str) || "setDebugOn".equals(str) || "getBindUrl".equals(str)) {
                LogUtil.d(CrabHelper.CRAB_TAG, "crab aop init skip method: " + str);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
