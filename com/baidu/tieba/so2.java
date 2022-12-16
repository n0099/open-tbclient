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
public class so2 {
    public static /* synthetic */ Interceptable $ic;
    public static final to2[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948158067, "Lcom/baidu/tieba/so2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948158067, "Lcom/baidu/tieba/so2;");
                return;
            }
        }
        a = new to2[]{new qo2(), new ro2()};
    }

    public static String a() {
        InterceptResult invokeV;
        to2[] to2VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            StringBuilder sb = new StringBuilder();
            for (to2 to2Var : a) {
                sb.append(to2Var.b());
                sb.append(to2Var.enable() ? 1 : 0);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static List<to2> b() {
        InterceptResult invokeV;
        to2[] to2VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ArrayList arrayList = new ArrayList();
            for (to2 to2Var : a) {
                if (to2Var.enable()) {
                    arrayList.add(to2Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
