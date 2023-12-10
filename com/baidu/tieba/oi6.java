package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class oi6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static wga a(aj6 aj6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aj6Var)) == null) {
            wga wgaVar = new wga();
            if (aj6Var != null) {
                wgaVar.b = aj6Var.c;
                wgaVar.e = aj6Var.g;
                wgaVar.f = aj6Var.i;
                wgaVar.c = aj6Var.d;
                if (!jk6.a(aj6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    wgaVar.a = arrayList;
                    arrayList.addAll(aj6Var.b);
                }
                if (!jk6.a(aj6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    wgaVar.d = arrayList2;
                    arrayList2.addAll(aj6Var.f);
                }
            }
            return wgaVar;
        }
        return (wga) invokeL.objValue;
    }

    public static void b(vi6 vi6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, vi6Var, str) == null) {
            try {
                if (vi6Var != null) {
                    uga.n().z(str, vi6Var.b());
                    uga.n().x();
                    if (!jk6.b(vi6Var.a())) {
                        HashMap<String, wga> hashMap = new HashMap<>();
                        for (Map.Entry<String, aj6> entry : vi6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        vga.a().l(str, hashMap);
                    }
                    vga.a().h(true, str);
                    return;
                }
                uga.n().h(str);
                uga.n().x();
                vga.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
