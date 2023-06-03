package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class wk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<xk5> a(el5 el5Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, el5Var)) == null) {
            if (el5Var.c("\u0089PNG") && el5Var.c("\r\n\u001a\n")) {
                ArrayList arrayList = new ArrayList();
                while (el5Var.available() > 0) {
                    arrayList.add(b(el5Var));
                }
                return arrayList;
            }
            throw new IOException("APNG Format error");
        }
        return (List) invokeL.objValue;
    }

    public static xk5 b(el5 el5Var) throws IOException {
        InterceptResult invokeL;
        xk5 xk5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, el5Var)) == null) {
            int position = el5Var.position();
            int e = el5Var.e();
            int d = el5Var.d();
            if (d == tk5.d) {
                xk5Var = new tk5();
            } else if (d == yk5.k) {
                xk5Var = new yk5();
            } else if (d == zk5.c) {
                xk5Var = new zk5();
            } else if (d == al5.c) {
                xk5Var = new al5();
            } else if (d == bl5.c) {
                xk5Var = new bl5();
            } else if (d == cl5.f) {
                xk5Var = new cl5();
            } else {
                xk5Var = new xk5();
            }
            xk5Var.b = position;
            xk5Var.a = e;
            xk5Var.c(el5Var);
            el5Var.e();
            return xk5Var;
        }
        return (xk5) invokeL.objValue;
    }
}
