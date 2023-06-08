package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class uk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static il9 a(el6 el6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, el6Var)) == null) {
            il9 il9Var = new il9();
            if (el6Var != null) {
                il9Var.b = el6Var.c;
                il9Var.e = el6Var.g;
                il9Var.f = el6Var.i;
                il9Var.c = el6Var.d;
                if (!jm6.a(el6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    il9Var.a = arrayList;
                    arrayList.addAll(el6Var.b);
                }
                if (!jm6.a(el6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    il9Var.d = arrayList2;
                    arrayList2.addAll(el6Var.f);
                }
            }
            return il9Var;
        }
        return (il9) invokeL.objValue;
    }

    public static void b(zk6 zk6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, zk6Var, str) == null) {
            try {
                if (zk6Var != null) {
                    gl9.n().z(str, zk6Var.b());
                    gl9.n().x();
                    if (!jm6.b(zk6Var.a())) {
                        HashMap<String, il9> hashMap = new HashMap<>();
                        for (Map.Entry<String, el6> entry : zk6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        hl9.a().l(str, hashMap);
                    }
                    hl9.a().h(true, str);
                    return;
                }
                gl9.n().h(str);
                gl9.n().x();
                hl9.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
