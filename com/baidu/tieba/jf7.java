package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class jf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l55 a;
    public n55 b;
    public String c;
    public String[] d;
    public String e;
    public n55.f f;
    public k9 g;

    public jf7(k9 k9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = k9Var;
    }

    public static jf7 c(k9 k9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, k9Var)) == null) {
            return new jf7(k9Var);
        }
        return (jf7) invokeL.objValue;
    }

    public jf7 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (jf7) invokeL.objValue;
    }

    public jf7 e(n55.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            this.f = fVar;
            return this;
        }
        return (jf7) invokeL.objValue;
    }

    public jf7 f(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            this.d = strArr;
            return this;
        }
        return (jf7) invokeL.objValue;
    }

    public jf7 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (jf7) invokeL.objValue;
    }

    public final List<j55> a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                j55 j55Var = new j55(i, str, this.b);
                if (!StringUtils.isNull(this.e) && this.e.equals(str)) {
                    j55Var.q(R.color.CAM_X0304);
                    j55Var.p();
                }
                arrayList.add(j55Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        l55 l55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (l55Var = this.a) != null) {
            l55Var.dismiss();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            n55 n55Var = new n55(this.g.getPageActivity());
            this.b = n55Var;
            n55Var.t(this.c);
            this.b.q(this.f);
            this.b.l(a(this.d));
            this.b.n(vi.g(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f0708d2));
            l55 l55Var = new l55(this.g, this.b);
            this.a = l55Var;
            l55Var.l();
        }
    }
}
