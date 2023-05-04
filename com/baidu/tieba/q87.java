package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.f15;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class q87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d15 a;
    public f15 b;
    public String c;
    public String[] d;
    public String e;
    public f15.f f;
    public a9 g;

    public q87(a9 a9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = a9Var;
    }

    public static q87 c(a9 a9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, a9Var)) == null) {
            return new q87(a9Var);
        }
        return (q87) invokeL.objValue;
    }

    public q87 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (q87) invokeL.objValue;
    }

    public q87 e(f15.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            this.f = fVar;
            return this;
        }
        return (q87) invokeL.objValue;
    }

    public q87 f(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            this.d = strArr;
            return this;
        }
        return (q87) invokeL.objValue;
    }

    public q87 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (q87) invokeL.objValue;
    }

    public final List<b15> a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                b15 b15Var = new b15(i, str, this.b);
                if (!StringUtils.isNull(this.e) && this.e.equals(str)) {
                    b15Var.q(R.color.CAM_X0304);
                    b15Var.p();
                }
                arrayList.add(b15Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        d15 d15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (d15Var = this.a) != null) {
            d15Var.dismiss();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            f15 f15Var = new f15(this.g.getPageActivity());
            this.b = f15Var;
            f15Var.s(this.c);
            this.b.p(this.f);
            this.b.k(a(this.d));
            this.b.m(ii.g(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f07076d));
            d15 d15Var = new d15(this.g, this.b);
            this.a = d15Var;
            d15Var.k();
        }
    }
}
