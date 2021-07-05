package com.baidu.wallet.statistics.impl;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.UAFilterUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final List<String> f27215b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Pattern f27216a;

    /* renamed from: com.baidu.wallet.statistics.impl.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0300a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f27217a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1939784632, "Lcom/baidu/wallet/statistics/impl/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1939784632, "Lcom/baidu/wallet/statistics/impl/a$a;");
                    return;
                }
            }
            f27217a = new a();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-739447835, "Lcom/baidu/wallet/statistics/impl/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-739447835, "Lcom/baidu/wallet/statistics/impl/a;");
                return;
            }
        }
        f27215b = new ArrayList<String>() { // from class: com.baidu.wallet.statistics.impl.HeaderService$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                add("9774d56d682e549c");
                add("0123456789abcdef");
            }
        };
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C0300a.f27217a : (a) invokeV.objValue;
    }

    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            try {
            } catch (Exception e2) {
                e = e2;
            }
            try {
                return this.f27216a.matcher(PhoneUtils.getCUID2(context)).replaceAll("");
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            try {
                return UAFilterUtil.getInstance().getTrueUA(context);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            try {
                return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27216a = Pattern.compile("\\s*|\t|\r|\n");
    }

    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            try {
            } catch (Exception e2) {
                e = e2;
            }
            try {
                return this.f27216a.matcher(PhoneUtils.getCUID(context)).replaceAll("");
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
