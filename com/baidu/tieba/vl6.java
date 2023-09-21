package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class vl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static g4a a(hm6 hm6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, hm6Var)) == null) {
            g4a g4aVar = new g4a();
            if (hm6Var != null) {
                g4aVar.b = hm6Var.c;
                g4aVar.e = hm6Var.g;
                g4aVar.f = hm6Var.i;
                g4aVar.c = hm6Var.d;
                if (!qn6.a(hm6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    g4aVar.a = arrayList;
                    arrayList.addAll(hm6Var.b);
                }
                if (!qn6.a(hm6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    g4aVar.d = arrayList2;
                    arrayList2.addAll(hm6Var.f);
                }
            }
            return g4aVar;
        }
        return (g4a) invokeL.objValue;
    }

    public static void b(cm6 cm6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, cm6Var, str) == null) {
            try {
                if (cm6Var != null) {
                    e4a.n().z(str, cm6Var.b());
                    e4a.n().x();
                    if (!qn6.b(cm6Var.a())) {
                        HashMap<String, g4a> hashMap = new HashMap<>();
                        for (Map.Entry<String, hm6> entry : cm6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        f4a.a().l(str, hashMap);
                    }
                    f4a.a().h(true, str);
                    return;
                }
                e4a.n().h(str);
                e4a.n().x();
                f4a.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
