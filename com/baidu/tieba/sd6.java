package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class sd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static v99 a(de6 de6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, de6Var)) == null) {
            v99 v99Var = new v99();
            if (de6Var != null) {
                v99Var.b = de6Var.c;
                v99Var.e = de6Var.g;
                v99Var.f = de6Var.i;
                v99Var.c = de6Var.d;
                if (!df6.a(de6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    v99Var.a = arrayList;
                    arrayList.addAll(de6Var.b);
                }
                if (!df6.a(de6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    v99Var.d = arrayList2;
                    arrayList2.addAll(de6Var.f);
                }
            }
            return v99Var;
        }
        return (v99) invokeL.objValue;
    }

    public static void b(yd6 yd6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, yd6Var, str) == null) {
            try {
                if (yd6Var != null) {
                    t99.n().z(str, yd6Var.b());
                    t99.n().x();
                    if (!df6.b(yd6Var.a())) {
                        HashMap<String, v99> hashMap = new HashMap<>();
                        for (Map.Entry<String, de6> entry : yd6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        u99.a().l(str, hashMap);
                    }
                    u99.a().h(true, str);
                    return;
                }
                t99.n().h(str);
                t99.n().x();
                u99.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
