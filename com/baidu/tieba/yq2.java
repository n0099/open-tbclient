package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class yq2 {
    public static /* synthetic */ Interceptable $ic;
    public static final zq2[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948338735, "Lcom/baidu/tieba/yq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948338735, "Lcom/baidu/tieba/yq2;");
                return;
            }
        }
        a = new zq2[]{new wq2(), new xq2()};
    }

    public static String a() {
        InterceptResult invokeV;
        zq2[] zq2VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            StringBuilder sb = new StringBuilder();
            for (zq2 zq2Var : a) {
                sb.append(zq2Var.b());
                sb.append(zq2Var.enable() ? 1 : 0);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static List<zq2> b() {
        InterceptResult invokeV;
        zq2[] zq2VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ArrayList arrayList = new ArrayList();
            for (zq2 zq2Var : a) {
                if (zq2Var.enable()) {
                    arrayList.add(zq2Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
