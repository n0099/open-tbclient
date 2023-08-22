package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class tk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static r0a a(fl6 fl6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, fl6Var)) == null) {
            r0a r0aVar = new r0a();
            if (fl6Var != null) {
                r0aVar.b = fl6Var.c;
                r0aVar.e = fl6Var.g;
                r0aVar.f = fl6Var.i;
                r0aVar.c = fl6Var.d;
                if (!km6.a(fl6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    r0aVar.a = arrayList;
                    arrayList.addAll(fl6Var.b);
                }
                if (!km6.a(fl6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    r0aVar.d = arrayList2;
                    arrayList2.addAll(fl6Var.f);
                }
            }
            return r0aVar;
        }
        return (r0a) invokeL.objValue;
    }

    public static void b(al6 al6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, al6Var, str) == null) {
            try {
                if (al6Var != null) {
                    p0a.n().z(str, al6Var.b());
                    p0a.n().x();
                    if (!km6.b(al6Var.a())) {
                        HashMap<String, r0a> hashMap = new HashMap<>();
                        for (Map.Entry<String, fl6> entry : al6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        q0a.a().l(str, hashMap);
                    }
                    q0a.a().h(true, str);
                    return;
                }
                p0a.n().h(str);
                p0a.n().x();
                q0a.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
