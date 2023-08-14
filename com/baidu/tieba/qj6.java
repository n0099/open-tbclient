package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class qj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static mw9 a(ak6 ak6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ak6Var)) == null) {
            mw9 mw9Var = new mw9();
            if (ak6Var != null) {
                mw9Var.b = ak6Var.c;
                mw9Var.e = ak6Var.g;
                mw9Var.f = ak6Var.i;
                mw9Var.c = ak6Var.d;
                if (!fl6.a(ak6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    mw9Var.a = arrayList;
                    arrayList.addAll(ak6Var.b);
                }
                if (!fl6.a(ak6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    mw9Var.d = arrayList2;
                    arrayList2.addAll(ak6Var.f);
                }
            }
            return mw9Var;
        }
        return (mw9) invokeL.objValue;
    }

    public static void b(vj6 vj6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, vj6Var, str) == null) {
            try {
                if (vj6Var != null) {
                    kw9.n().z(str, vj6Var.b());
                    kw9.n().x();
                    if (!fl6.b(vj6Var.a())) {
                        HashMap<String, mw9> hashMap = new HashMap<>();
                        for (Map.Entry<String, ak6> entry : vj6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        lw9.a().l(str, hashMap);
                    }
                    lw9.a().h(true, str);
                    return;
                }
                kw9.n().h(str);
                kw9.n().x();
                lw9.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
