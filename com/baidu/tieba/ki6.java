package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class ki6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static rga a(wi6 wi6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, wi6Var)) == null) {
            rga rgaVar = new rga();
            if (wi6Var != null) {
                rgaVar.b = wi6Var.c;
                rgaVar.e = wi6Var.g;
                rgaVar.f = wi6Var.i;
                rgaVar.c = wi6Var.d;
                if (!fk6.a(wi6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    rgaVar.a = arrayList;
                    arrayList.addAll(wi6Var.b);
                }
                if (!fk6.a(wi6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    rgaVar.d = arrayList2;
                    arrayList2.addAll(wi6Var.f);
                }
            }
            return rgaVar;
        }
        return (rga) invokeL.objValue;
    }

    public static void b(ri6 ri6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, ri6Var, str) == null) {
            try {
                if (ri6Var != null) {
                    pga.n().z(str, ri6Var.b());
                    pga.n().x();
                    if (!fk6.b(ri6Var.a())) {
                        HashMap<String, rga> hashMap = new HashMap<>();
                        for (Map.Entry<String, wi6> entry : ri6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        qga.a().l(str, hashMap);
                    }
                    qga.a().h(true, str);
                    return;
                }
                pga.n().h(str);
                pga.n().x();
                qga.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
