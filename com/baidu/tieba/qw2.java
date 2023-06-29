package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class qw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final rw2[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948106173, "Lcom/baidu/tieba/qw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948106173, "Lcom/baidu/tieba/qw2;");
                return;
            }
        }
        a = new rw2[]{new ow2(), new pw2()};
    }

    public static String a() {
        InterceptResult invokeV;
        rw2[] rw2VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            StringBuilder sb = new StringBuilder();
            for (rw2 rw2Var : a) {
                sb.append(rw2Var.b());
                sb.append(rw2Var.enable() ? 1 : 0);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static List<rw2> b() {
        InterceptResult invokeV;
        rw2[] rw2VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ArrayList arrayList = new ArrayList();
            for (rw2 rw2Var : a) {
                if (rw2Var.enable()) {
                    arrayList.add(rw2Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
