package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class rl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static i2a a(dm6 dm6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dm6Var)) == null) {
            i2a i2aVar = new i2a();
            if (dm6Var != null) {
                i2aVar.b = dm6Var.c;
                i2aVar.e = dm6Var.g;
                i2aVar.f = dm6Var.i;
                i2aVar.c = dm6Var.d;
                if (!mn6.a(dm6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    i2aVar.a = arrayList;
                    arrayList.addAll(dm6Var.b);
                }
                if (!mn6.a(dm6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    i2aVar.d = arrayList2;
                    arrayList2.addAll(dm6Var.f);
                }
            }
            return i2aVar;
        }
        return (i2a) invokeL.objValue;
    }

    public static void b(yl6 yl6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, yl6Var, str) == null) {
            try {
                if (yl6Var != null) {
                    g2a.n().z(str, yl6Var.b());
                    g2a.n().x();
                    if (!mn6.b(yl6Var.a())) {
                        HashMap<String, i2a> hashMap = new HashMap<>();
                        for (Map.Entry<String, dm6> entry : yl6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        h2a.a().l(str, hashMap);
                    }
                    h2a.a().h(true, str);
                    return;
                }
                g2a.n().h(str);
                g2a.n().x();
                h2a.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
