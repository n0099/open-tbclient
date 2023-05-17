package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class kg6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ve9 a(ug6 ug6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ug6Var)) == null) {
            ve9 ve9Var = new ve9();
            if (ug6Var != null) {
                ve9Var.b = ug6Var.c;
                ve9Var.e = ug6Var.g;
                ve9Var.f = ug6Var.i;
                ve9Var.c = ug6Var.d;
                if (!yh6.a(ug6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ve9Var.a = arrayList;
                    arrayList.addAll(ug6Var.b);
                }
                if (!yh6.a(ug6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ve9Var.d = arrayList2;
                    arrayList2.addAll(ug6Var.f);
                }
            }
            return ve9Var;
        }
        return (ve9) invokeL.objValue;
    }

    public static void b(pg6 pg6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, pg6Var, str) == null) {
            try {
                if (pg6Var != null) {
                    te9.n().z(str, pg6Var.b());
                    te9.n().x();
                    if (!yh6.b(pg6Var.a())) {
                        HashMap<String, ve9> hashMap = new HashMap<>();
                        for (Map.Entry<String, ug6> entry : pg6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        ue9.a().l(str, hashMap);
                    }
                    ue9.a().h(true, str);
                    return;
                }
                te9.n().h(str);
                te9.n().x();
                ue9.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
