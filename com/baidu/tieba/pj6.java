package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class pj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static lw9 a(zj6 zj6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, zj6Var)) == null) {
            lw9 lw9Var = new lw9();
            if (zj6Var != null) {
                lw9Var.b = zj6Var.c;
                lw9Var.e = zj6Var.g;
                lw9Var.f = zj6Var.i;
                lw9Var.c = zj6Var.d;
                if (!el6.a(zj6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    lw9Var.a = arrayList;
                    arrayList.addAll(zj6Var.b);
                }
                if (!el6.a(zj6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    lw9Var.d = arrayList2;
                    arrayList2.addAll(zj6Var.f);
                }
            }
            return lw9Var;
        }
        return (lw9) invokeL.objValue;
    }

    public static void b(uj6 uj6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, uj6Var, str) == null) {
            try {
                if (uj6Var != null) {
                    jw9.n().z(str, uj6Var.b());
                    jw9.n().x();
                    if (!el6.b(uj6Var.a())) {
                        HashMap<String, lw9> hashMap = new HashMap<>();
                        for (Map.Entry<String, zj6> entry : uj6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        kw9.a().l(str, hashMap);
                    }
                    kw9.a().h(true, str);
                    return;
                }
                jw9.n().h(str);
                jw9.n().x();
                kw9.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
