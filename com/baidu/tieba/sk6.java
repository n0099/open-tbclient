package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class sk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static dl9 a(cl6 cl6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cl6Var)) == null) {
            dl9 dl9Var = new dl9();
            if (cl6Var != null) {
                dl9Var.b = cl6Var.c;
                dl9Var.e = cl6Var.g;
                dl9Var.f = cl6Var.i;
                dl9Var.c = cl6Var.d;
                if (!hm6.a(cl6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    dl9Var.a = arrayList;
                    arrayList.addAll(cl6Var.b);
                }
                if (!hm6.a(cl6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    dl9Var.d = arrayList2;
                    arrayList2.addAll(cl6Var.f);
                }
            }
            return dl9Var;
        }
        return (dl9) invokeL.objValue;
    }

    public static void b(xk6 xk6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, xk6Var, str) == null) {
            try {
                if (xk6Var != null) {
                    bl9.n().z(str, xk6Var.b());
                    bl9.n().x();
                    if (!hm6.b(xk6Var.a())) {
                        HashMap<String, dl9> hashMap = new HashMap<>();
                        for (Map.Entry<String, cl6> entry : xk6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        cl9.a().l(str, hashMap);
                    }
                    cl9.a().h(true, str);
                    return;
                }
                bl9.n().h(str);
                bl9.n().x();
                cl9.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
