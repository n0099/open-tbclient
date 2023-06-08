package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class yk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<zk5> a(gl5 gl5Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gl5Var)) == null) {
            if (gl5Var.c("\u0089PNG") && gl5Var.c("\r\n\u001a\n")) {
                ArrayList arrayList = new ArrayList();
                while (gl5Var.available() > 0) {
                    arrayList.add(b(gl5Var));
                }
                return arrayList;
            }
            throw new IOException("APNG Format error");
        }
        return (List) invokeL.objValue;
    }

    public static zk5 b(gl5 gl5Var) throws IOException {
        InterceptResult invokeL;
        zk5 zk5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, gl5Var)) == null) {
            int position = gl5Var.position();
            int e = gl5Var.e();
            int d = gl5Var.d();
            if (d == vk5.d) {
                zk5Var = new vk5();
            } else if (d == al5.k) {
                zk5Var = new al5();
            } else if (d == bl5.c) {
                zk5Var = new bl5();
            } else if (d == cl5.c) {
                zk5Var = new cl5();
            } else if (d == dl5.c) {
                zk5Var = new dl5();
            } else if (d == el5.f) {
                zk5Var = new el5();
            } else {
                zk5Var = new zk5();
            }
            zk5Var.b = position;
            zk5Var.a = e;
            zk5Var.c(gl5Var);
            gl5Var.e();
            return zk5Var;
        }
        return (zk5) invokeL.objValue;
    }
}
