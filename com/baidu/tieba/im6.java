package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class im6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static tx9 a(sm6 sm6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, sm6Var)) == null) {
            tx9 tx9Var = new tx9();
            if (sm6Var != null) {
                tx9Var.b = sm6Var.c;
                tx9Var.e = sm6Var.g;
                tx9Var.f = sm6Var.i;
                tx9Var.c = sm6Var.d;
                if (!xn6.a(sm6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    tx9Var.a = arrayList;
                    arrayList.addAll(sm6Var.b);
                }
                if (!xn6.a(sm6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    tx9Var.d = arrayList2;
                    arrayList2.addAll(sm6Var.f);
                }
            }
            return tx9Var;
        }
        return (tx9) invokeL.objValue;
    }

    public static void b(nm6 nm6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, nm6Var, str) == null) {
            try {
                if (nm6Var != null) {
                    rx9.n().z(str, nm6Var.b());
                    rx9.n().x();
                    if (!xn6.b(nm6Var.a())) {
                        HashMap<String, tx9> hashMap = new HashMap<>();
                        for (Map.Entry<String, sm6> entry : nm6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        sx9.a().l(str, hashMap);
                    }
                    sx9.a().h(true, str);
                    return;
                }
                rx9.n().h(str);
                rx9.n().x();
                sx9.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
