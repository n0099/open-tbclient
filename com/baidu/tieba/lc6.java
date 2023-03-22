package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class lc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static f09 a(vc6 vc6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, vc6Var)) == null) {
            f09 f09Var = new f09();
            if (vc6Var != null) {
                f09Var.b = vc6Var.c;
                f09Var.e = vc6Var.g;
                f09Var.f = vc6Var.i;
                f09Var.c = vc6Var.d;
                if (!vd6.a(vc6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    f09Var.a = arrayList;
                    arrayList.addAll(vc6Var.b);
                }
                if (!vd6.a(vc6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    f09Var.d = arrayList2;
                    arrayList2.addAll(vc6Var.f);
                }
            }
            return f09Var;
        }
        return (f09) invokeL.objValue;
    }

    public static void b(uc6 uc6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, uc6Var, str) == null) {
            try {
                if (uc6Var != null) {
                    d09.n().z(str, uc6Var.c);
                    d09.n().x();
                    if (!vd6.b(uc6Var.b)) {
                        HashMap<String, f09> hashMap = new HashMap<>();
                        for (Map.Entry<String, vc6> entry : uc6Var.b.entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        e09.a().l(str, hashMap);
                    }
                    e09.a().h(true, str);
                    return;
                }
                d09.n().h(str);
                d09.n().x();
                e09.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
