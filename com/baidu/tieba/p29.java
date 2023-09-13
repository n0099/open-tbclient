package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class p29 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, lv4> a;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final p29 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-567871372, "Lcom/baidu/tieba/p29$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-567871372, "Lcom/baidu/tieba/p29$b;");
                    return;
                }
            }
            a = new p29(null);
        }
    }

    public p29() {
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
        this.a = new HashMap<>();
    }

    public static p29 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (p29) invokeV.objValue;
    }

    public /* synthetic */ p29(a aVar) {
        this();
    }

    public void b(lv4 lv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
            c(lv4Var.a(), lv4Var);
        }
    }

    public final void c(String str, lv4 lv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, lv4Var) == null) {
            this.a.put(str, lv4Var);
        }
    }

    public void d(String str, HashMap<String, String> hashMap, mv4 mv4Var) {
        lv4 lv4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, hashMap, mv4Var) != null) || str == null || hashMap == null || hashMap.isEmpty() || mv4Var == null || (lv4Var = this.a.get(str)) == null) {
            return;
        }
        lv4Var.b(hashMap, mv4Var);
    }
}
