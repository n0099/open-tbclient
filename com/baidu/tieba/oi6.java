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

    public static vga a(aj6 aj6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aj6Var)) == null) {
            vga vgaVar = new vga();
            if (aj6Var != null) {
                vgaVar.b = aj6Var.c;
                vgaVar.e = aj6Var.g;
                vgaVar.f = aj6Var.i;
                vgaVar.c = aj6Var.d;
                if (!jk6.a(aj6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    vgaVar.a = arrayList;
                    arrayList.addAll(aj6Var.b);
                }
                if (!jk6.a(aj6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    vgaVar.d = arrayList2;
                    arrayList2.addAll(aj6Var.f);
                }
            }
            return vgaVar;
        }
        return (vga) invokeL.objValue;
    }

    public static void b(vi6 vi6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, vi6Var, str) == null) {
            try {
                if (vi6Var != null) {
                    tga.n().z(str, vi6Var.b());
                    tga.n().x();
                    if (!jk6.b(vi6Var.a())) {
                        HashMap<String, vga> hashMap = new HashMap<>();
                        for (Map.Entry<String, aj6> entry : vi6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        uga.a().l(str, hashMap);
                    }
                    uga.a().h(true, str);
                    return;
                }
                tga.n().h(str);
                tga.n().x();
                uga.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
