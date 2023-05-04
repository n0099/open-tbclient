package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class ye6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static zc9 a(if6 if6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, if6Var)) == null) {
            zc9 zc9Var = new zc9();
            if (if6Var != null) {
                zc9Var.b = if6Var.c;
                zc9Var.e = if6Var.g;
                zc9Var.f = if6Var.i;
                zc9Var.c = if6Var.d;
                if (!mg6.a(if6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    zc9Var.a = arrayList;
                    arrayList.addAll(if6Var.b);
                }
                if (!mg6.a(if6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    zc9Var.d = arrayList2;
                    arrayList2.addAll(if6Var.f);
                }
            }
            return zc9Var;
        }
        return (zc9) invokeL.objValue;
    }

    public static void b(df6 df6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, df6Var, str) == null) {
            try {
                if (df6Var != null) {
                    xc9.n().z(str, df6Var.b());
                    xc9.n().x();
                    if (!mg6.b(df6Var.a())) {
                        HashMap<String, zc9> hashMap = new HashMap<>();
                        for (Map.Entry<String, if6> entry : df6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        yc9.a().l(str, hashMap);
                    }
                    yc9.a().h(true, str);
                    return;
                }
                xc9.n().h(str);
                xc9.n().x();
                yc9.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
