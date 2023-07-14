package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class o66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, p66> a;
    public ArrayList<Integer> b;
    public q66 c;

    public o66(q66 q66Var, ArrayList<Integer> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q66Var, arrayList};
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
        this.c = q66Var;
        this.a = new HashMap<>();
    }

    public int a(String str, int i) {
        InterceptResult invokeLI;
        ArrayList<Integer> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (this.a == null || xi.isEmpty(str) || (arrayList = this.b) == null || !arrayList.contains(Integer.valueOf(i))) {
                return 0;
            }
            if (!this.a.containsKey(str)) {
                b(str);
            }
            p66 p66Var = this.a.get(str);
            if (p66Var == null) {
                return 0;
            }
            return p66Var.a(i);
        }
        return invokeLI.intValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && this.a != null && !xi.isEmpty(str) && this.c != null) {
            if (this.a.containsKey(str)) {
                p66 p66Var = this.a.get(str);
                this.c.b(this.b, p66Var);
                this.a.put(str, p66Var);
                return;
            }
            p66 p66Var2 = new p66();
            this.c.b(this.b, p66Var2);
            this.a.put(str, p66Var2);
        }
    }
}
