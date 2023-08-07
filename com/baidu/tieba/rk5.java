package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class rk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<sk5> a(zk5 zk5Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, zk5Var)) == null) {
            if (zk5Var.c("\u0089PNG") && zk5Var.c("\r\n\u001a\n")) {
                ArrayList arrayList = new ArrayList();
                while (zk5Var.available() > 0) {
                    arrayList.add(b(zk5Var));
                }
                return arrayList;
            }
            throw new IOException("APNG Format error");
        }
        return (List) invokeL.objValue;
    }

    public static sk5 b(zk5 zk5Var) throws IOException {
        InterceptResult invokeL;
        sk5 sk5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, zk5Var)) == null) {
            int position = zk5Var.position();
            int e = zk5Var.e();
            int d = zk5Var.d();
            if (d == ok5.d) {
                sk5Var = new ok5();
            } else if (d == tk5.k) {
                sk5Var = new tk5();
            } else if (d == uk5.c) {
                sk5Var = new uk5();
            } else if (d == vk5.c) {
                sk5Var = new vk5();
            } else if (d == wk5.c) {
                sk5Var = new wk5();
            } else if (d == xk5.f) {
                sk5Var = new xk5();
            } else {
                sk5Var = new sk5();
            }
            sk5Var.b = position;
            sk5Var.a = e;
            sk5Var.c(zk5Var);
            zk5Var.e();
            return sk5Var;
        }
        return (sk5) invokeL.objValue;
    }
}
