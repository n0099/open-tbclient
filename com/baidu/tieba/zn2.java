package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class zn2 {
    public static /* synthetic */ Interceptable $ic;
    public static final ao2[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948365643, "Lcom/baidu/tieba/zn2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948365643, "Lcom/baidu/tieba/zn2;");
                return;
            }
        }
        a = new ao2[]{new xn2(), new yn2()};
    }

    public static String a() {
        InterceptResult invokeV;
        ao2[] ao2VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            StringBuilder sb = new StringBuilder();
            for (ao2 ao2Var : a) {
                sb.append(ao2Var.b());
                sb.append(ao2Var.enable() ? 1 : 0);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static List<ao2> b() {
        InterceptResult invokeV;
        ao2[] ao2VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ArrayList arrayList = new ArrayList();
            for (ao2 ao2Var : a) {
                if (ao2Var.enable()) {
                    arrayList.add(ao2Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
