package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.r55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class tf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p55 a;
    public r55 b;
    public String c;
    public String[] d;
    public String e;
    public r55.f f;
    public l9 g;

    public tf7(l9 l9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = l9Var;
    }

    public static tf7 c(l9 l9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, l9Var)) == null) {
            return new tf7(l9Var);
        }
        return (tf7) invokeL.objValue;
    }

    public tf7 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (tf7) invokeL.objValue;
    }

    public tf7 e(r55.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            this.f = fVar;
            return this;
        }
        return (tf7) invokeL.objValue;
    }

    public tf7 f(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            this.d = strArr;
            return this;
        }
        return (tf7) invokeL.objValue;
    }

    public tf7 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (tf7) invokeL.objValue;
    }

    public final List<n55> a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                n55 n55Var = new n55(i, str, this.b);
                if (!StringUtils.isNull(this.e) && this.e.equals(str)) {
                    n55Var.q(R.color.CAM_X0304);
                    n55Var.p();
                }
                arrayList.add(n55Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        p55 p55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (p55Var = this.a) != null) {
            p55Var.dismiss();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            r55 r55Var = new r55(this.g.getPageActivity());
            this.b = r55Var;
            r55Var.t(this.c);
            this.b.q(this.f);
            this.b.l(a(this.d));
            this.b.n(xi.g(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f0708d2));
            p55 p55Var = new p55(this.g, this.b);
            this.a = p55Var;
            p55Var.l();
        }
    }
}
