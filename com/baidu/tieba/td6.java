package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class td6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static da9 a(ee6 ee6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ee6Var)) == null) {
            da9 da9Var = new da9();
            if (ee6Var != null) {
                da9Var.b = ee6Var.c;
                da9Var.e = ee6Var.g;
                da9Var.f = ee6Var.i;
                da9Var.c = ee6Var.d;
                if (!ef6.a(ee6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    da9Var.a = arrayList;
                    arrayList.addAll(ee6Var.b);
                }
                if (!ef6.a(ee6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    da9Var.d = arrayList2;
                    arrayList2.addAll(ee6Var.f);
                }
            }
            return da9Var;
        }
        return (da9) invokeL.objValue;
    }

    public static void b(zd6 zd6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, zd6Var, str) == null) {
            try {
                if (zd6Var != null) {
                    ba9.n().z(str, zd6Var.b());
                    ba9.n().x();
                    if (!ef6.b(zd6Var.a())) {
                        HashMap<String, da9> hashMap = new HashMap<>();
                        for (Map.Entry<String, ee6> entry : zd6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        ca9.a().l(str, hashMap);
                    }
                    ca9.a().h(true, str);
                    return;
                }
                ba9.n().h(str);
                ba9.n().x();
                ca9.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
