package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class yh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<zh5> a(gi5 gi5Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gi5Var)) == null) {
            if (gi5Var.c("\u0089PNG") && gi5Var.c("\r\n\u001a\n")) {
                ArrayList arrayList = new ArrayList();
                while (gi5Var.available() > 0) {
                    arrayList.add(b(gi5Var));
                }
                return arrayList;
            }
            throw new IOException("APNG Format error");
        }
        return (List) invokeL.objValue;
    }

    public static zh5 b(gi5 gi5Var) throws IOException {
        InterceptResult invokeL;
        zh5 zh5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, gi5Var)) == null) {
            int position = gi5Var.position();
            int e = gi5Var.e();
            int d = gi5Var.d();
            if (d == vh5.d) {
                zh5Var = new vh5();
            } else if (d == ai5.k) {
                zh5Var = new ai5();
            } else if (d == bi5.c) {
                zh5Var = new bi5();
            } else if (d == ci5.c) {
                zh5Var = new ci5();
            } else if (d == di5.c) {
                zh5Var = new di5();
            } else if (d == ei5.f) {
                zh5Var = new ei5();
            } else {
                zh5Var = new zh5();
            }
            zh5Var.b = position;
            zh5Var.a = e;
            zh5Var.c(gi5Var);
            gi5Var.e();
            return zh5Var;
        }
        return (zh5) invokeL.objValue;
    }
}
