package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class yl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<zl5> a(gm5 gm5Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gm5Var)) == null) {
            if (gm5Var.c("\u0089PNG") && gm5Var.c("\r\n\u001a\n")) {
                ArrayList arrayList = new ArrayList();
                while (gm5Var.available() > 0) {
                    arrayList.add(b(gm5Var));
                }
                return arrayList;
            }
            throw new IOException("APNG Format error");
        }
        return (List) invokeL.objValue;
    }

    public static zl5 b(gm5 gm5Var) throws IOException {
        InterceptResult invokeL;
        zl5 zl5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, gm5Var)) == null) {
            int position = gm5Var.position();
            int e = gm5Var.e();
            int d = gm5Var.d();
            if (d == vl5.d) {
                zl5Var = new vl5();
            } else if (d == am5.k) {
                zl5Var = new am5();
            } else if (d == bm5.c) {
                zl5Var = new bm5();
            } else if (d == cm5.c) {
                zl5Var = new cm5();
            } else if (d == dm5.c) {
                zl5Var = new dm5();
            } else if (d == em5.f) {
                zl5Var = new em5();
            } else {
                zl5Var = new zl5();
            }
            zl5Var.b = position;
            zl5Var.a = e;
            zl5Var.c(gm5Var);
            gm5Var.e();
            return zl5Var;
        }
        return (zl5) invokeL.objValue;
    }
}
