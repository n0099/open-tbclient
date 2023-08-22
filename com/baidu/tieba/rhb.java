package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.validation.js.BaseInterpreter;
import com.baidu.validation.utils.ValidationLog;
/* loaded from: classes7.dex */
public class rhb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final rhb a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-459521505, "Lcom/baidu/tieba/rhb$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-459521505, "Lcom/baidu/tieba/rhb$b;");
                    return;
                }
            }
            a = new rhb(null);
        }
    }

    public rhb() {
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

    public /* synthetic */ rhb(a aVar) {
        this();
    }

    public static rhb b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (rhb) invokeV.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            String[] split = str.split("_");
            StringBuilder sb = new StringBuilder();
            sb.append("com.baidu.validation.js.interpreter.");
            for (String str2 : split) {
                char[] charArray = str2.toCharArray();
                if (charArray[0] >= 'a' && charArray[0] <= 'z') {
                    charArray[0] = (char) (charArray[0] - ' ');
                }
                sb.append(new String(charArray));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public BaseInterpreter a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? c(str) : (BaseInterpreter) invokeL.objValue;
    }

    public final BaseInterpreter c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                BaseInterpreter baseInterpreter = (BaseInterpreter) Class.forName(d(str)).newInstance();
                baseInterpreter.setName(str);
                return baseInterpreter;
            } catch (Exception e) {
                ValidationLog.e(e);
                return null;
            }
        }
        return (BaseInterpreter) invokeL.objValue;
    }
}
