package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class zk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static an9 a(jl6 jl6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jl6Var)) == null) {
            an9 an9Var = new an9();
            if (jl6Var != null) {
                an9Var.b = jl6Var.c;
                an9Var.e = jl6Var.g;
                an9Var.f = jl6Var.i;
                an9Var.c = jl6Var.d;
                if (!om6.a(jl6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    an9Var.a = arrayList;
                    arrayList.addAll(jl6Var.b);
                }
                if (!om6.a(jl6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    an9Var.d = arrayList2;
                    arrayList2.addAll(jl6Var.f);
                }
            }
            return an9Var;
        }
        return (an9) invokeL.objValue;
    }

    public static void b(el6 el6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, el6Var, str) == null) {
            try {
                if (el6Var != null) {
                    ym9.n().z(str, el6Var.b());
                    ym9.n().x();
                    if (!om6.b(el6Var.a())) {
                        HashMap<String, an9> hashMap = new HashMap<>();
                        for (Map.Entry<String, jl6> entry : el6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        zm9.a().l(str, hashMap);
                    }
                    zm9.a().h(true, str);
                    return;
                }
                ym9.n().h(str);
                ym9.n().x();
                zm9.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
