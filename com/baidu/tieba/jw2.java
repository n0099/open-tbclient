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
public class jw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final kw2[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947897636, "Lcom/baidu/tieba/jw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947897636, "Lcom/baidu/tieba/jw2;");
                return;
            }
        }
        a = new kw2[]{new hw2(), new iw2()};
    }

    public static String a() {
        InterceptResult invokeV;
        kw2[] kw2VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            StringBuilder sb = new StringBuilder();
            for (kw2 kw2Var : a) {
                sb.append(kw2Var.b());
                sb.append(kw2Var.enable() ? 1 : 0);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static List<kw2> b() {
        InterceptResult invokeV;
        kw2[] kw2VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ArrayList arrayList = new ArrayList();
            for (kw2 kw2Var : a) {
                if (kw2Var.enable()) {
                    arrayList.add(kw2Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
