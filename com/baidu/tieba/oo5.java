package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class oo5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, po5> a;
    public ArrayList<Integer> b;
    public qo5 c;

    public oo5(qo5 qo5Var, ArrayList<Integer> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qo5Var, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = arrayList;
        this.c = qo5Var;
        this.a = new HashMap<>();
    }

    public int a(String str, int i) {
        InterceptResult invokeLI;
        ArrayList<Integer> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (this.a == null || dj.isEmpty(str) || (arrayList = this.b) == null || !arrayList.contains(Integer.valueOf(i))) {
                return 0;
            }
            if (!this.a.containsKey(str)) {
                b(str);
            }
            po5 po5Var = this.a.get(str);
            if (po5Var == null) {
                return 0;
            }
            return po5Var.a(i);
        }
        return invokeLI.intValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.a == null || dj.isEmpty(str) || this.c == null) {
            return;
        }
        if (this.a.containsKey(str)) {
            po5 po5Var = this.a.get(str);
            this.c.b(this.b, po5Var);
            this.a.put(str, po5Var);
            return;
        }
        po5 po5Var2 = new po5();
        this.c.b(this.b, po5Var2);
        this.a.put(str, po5Var2);
    }
}
