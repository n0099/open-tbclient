package com.baidu.wallet.api;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.utils.MtjCrashHandler;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.ShortCompanionObject;
/* loaded from: classes10.dex */
public class WalletFacadeAOP implements NoProguard, InvocationHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "WalletFacadeAOP";

    /* renamed from: b  reason: collision with root package name */
    public static final List<String> f57245b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final IWalletFacade f57246a;

    /* renamed from: com.baidu.wallet.api.WalletFacadeAOP$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57247a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-660972388, "Lcom/baidu/wallet/api/WalletFacadeAOP$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-660972388, "Lcom/baidu/wallet/api/WalletFacadeAOP$1;");
                    return;
                }
            }
            int[] iArr = new int[EntranceService.values().length];
            f57247a = iArr;
            try {
                iArr[EntranceService.PAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f57247a[EntranceService.CREDIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f57247a[EntranceService.SHARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class EntranceService {
        public static final /* synthetic */ EntranceService[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final EntranceService CREDIT;
        public static final EntranceService PAY;
        public static final EntranceService SHARE;
        public transient /* synthetic */ FieldHolder $fh;
        public int val;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1510190066, "Lcom/baidu/wallet/api/WalletFacadeAOP$EntranceService;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1510190066, "Lcom/baidu/wallet/api/WalletFacadeAOP$EntranceService;");
                    return;
                }
            }
            PAY = new EntranceService("PAY", 0, 0);
            CREDIT = new EntranceService("CREDIT", 1, 1);
            EntranceService entranceService = new EntranceService("SHARE", 2, 2);
            SHARE = entranceService;
            $VALUES = new EntranceService[]{PAY, CREDIT, entranceService};
        }

        public EntranceService(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.val = i3;
        }

        public static EntranceService valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EntranceService) Enum.valueOf(EntranceService.class, str) : (EntranceService) invokeL.objValue;
        }

        public static EntranceService[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EntranceService[]) $VALUES.clone() : (EntranceService[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1010742519, "Lcom/baidu/wallet/api/WalletFacadeAOP;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1010742519, "Lcom/baidu/wallet/api/WalletFacadeAOP;");
                return;
            }
        }
        f57245b = new ArrayList(Arrays.asList("doPay", "doBind", "doRNAuth", "doCheckPwd", "doBindCardIndependent", "checkPwd", StatServiceEvent.GET_WALLET_OUTER_INTERFACE, "accessWalletEntry", "preOrderPay", "getPayMethod", "changePayMethod", "gotoWalletService"));
    }

    public WalletFacadeAOP(IWalletFacade iWalletFacade) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iWalletFacade};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57246a = iWalletFacade;
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? BaiduWalletDelegate.getInstance().getAppContext() == null : invokeV.booleanValue;
    }

    private EntranceService b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
            List<String> list = f57245b;
            if (list != null && list.contains(str)) {
                if ("gotoWalletService".equals(str)) {
                    return EntranceService.SHARE;
                }
                return EntranceService.PAY;
            }
            return EntranceService.CREDIT;
        }
        return (EntranceService) invokeL.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
        }
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            try {
                MtjCrashHandler.init(BaiduWalletDelegate.getInstance().getAppContext());
            } catch (Throwable unused) {
                DXMSdkSAUtils.onEvent("#initMTJLiteFailed");
            }
            EntranceService b2 = b(str);
            LogUtil.d(TAG, "AOP method = " + str);
            int i2 = AnonymousClass1.f57247a[b2.ordinal()];
            if (i2 == 1) {
                com.dxmpay.wallet.api.WalletLoginHelper.getInstance().clearOpenBduss();
            } else if (i2 != 2) {
            } else {
                WalletLoginHelper.getInstance().clearOpenBduss();
                com.dxmpay.wallet.api.WalletLoginHelper.getInstance().clearOpenBduss();
            }
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, method, objArr)) == null) {
            if (method != null && a(method.getName())) {
                LogUtil.d(TAG, "crab aop init before method: " + method.getName());
                try {
                    if (a()) {
                        return a(method.getReturnType());
                    }
                    c(method.getName());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            Object invoke = method.invoke(this.f57246a, objArr);
            if (method != null && a(method.getName())) {
                try {
                    b();
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, cls)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            if ("initWallet".equals(str) || "setDebugOn".equals(str) || "getBindUrl".equals(str)) {
                LogUtil.d(TAG, "crab aop init skip method: " + str);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
