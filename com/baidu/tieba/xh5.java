package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class xh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<yh5> a(fi5 fi5Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, fi5Var)) == null) {
            if (fi5Var.c("\u0089PNG") && fi5Var.c("\r\n\u001a\n")) {
                ArrayList arrayList = new ArrayList();
                while (fi5Var.available() > 0) {
                    arrayList.add(b(fi5Var));
                }
                return arrayList;
            }
            throw new IOException("APNG Format error");
        }
        return (List) invokeL.objValue;
    }

    public static yh5 b(fi5 fi5Var) throws IOException {
        InterceptResult invokeL;
        yh5 yh5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fi5Var)) == null) {
            int position = fi5Var.position();
            int e = fi5Var.e();
            int d = fi5Var.d();
            if (d == uh5.d) {
                yh5Var = new uh5();
            } else if (d == zh5.k) {
                yh5Var = new zh5();
            } else if (d == ai5.c) {
                yh5Var = new ai5();
            } else if (d == bi5.c) {
                yh5Var = new bi5();
            } else if (d == ci5.c) {
                yh5Var = new ci5();
            } else if (d == di5.f) {
                yh5Var = new di5();
            } else {
                yh5Var = new yh5();
            }
            yh5Var.b = position;
            yh5Var.a = e;
            yh5Var.c(fi5Var);
            fi5Var.e();
            return yh5Var;
        }
        return (yh5) invokeL.objValue;
    }
}
