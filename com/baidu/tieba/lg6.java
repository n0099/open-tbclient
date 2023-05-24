package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class lg6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static we9 a(vg6 vg6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, vg6Var)) == null) {
            we9 we9Var = new we9();
            if (vg6Var != null) {
                we9Var.b = vg6Var.c;
                we9Var.e = vg6Var.g;
                we9Var.f = vg6Var.i;
                we9Var.c = vg6Var.d;
                if (!zh6.a(vg6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    we9Var.a = arrayList;
                    arrayList.addAll(vg6Var.b);
                }
                if (!zh6.a(vg6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    we9Var.d = arrayList2;
                    arrayList2.addAll(vg6Var.f);
                }
            }
            return we9Var;
        }
        return (we9) invokeL.objValue;
    }

    public static void b(qg6 qg6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, qg6Var, str) == null) {
            try {
                if (qg6Var != null) {
                    ue9.n().z(str, qg6Var.b());
                    ue9.n().x();
                    if (!zh6.b(qg6Var.a())) {
                        HashMap<String, we9> hashMap = new HashMap<>();
                        for (Map.Entry<String, vg6> entry : qg6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        ve9.a().l(str, hashMap);
                    }
                    ve9.a().h(true, str);
                    return;
                }
                ue9.n().h(str);
                ue9.n().x();
                ve9.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
