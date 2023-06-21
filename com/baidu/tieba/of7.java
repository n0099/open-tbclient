package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.o55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class of7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m55 a;
    public o55 b;
    public String c;
    public String[] d;
    public String e;
    public o55.f f;
    public k9 g;

    public of7(k9 k9Var) {
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

    public static of7 c(k9 k9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, k9Var)) == null) {
            return new of7(k9Var);
        }
        return (of7) invokeL.objValue;
    }

    public of7 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (of7) invokeL.objValue;
    }

    public of7 e(o55.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            this.f = fVar;
            return this;
        }
        return (of7) invokeL.objValue;
    }

    public of7 f(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            this.d = strArr;
            return this;
        }
        return (of7) invokeL.objValue;
    }

    public of7 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (of7) invokeL.objValue;
    }

    public final List<k55> a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                k55 k55Var = new k55(i, str, this.b);
                if (!StringUtils.isNull(this.e) && this.e.equals(str)) {
                    k55Var.q(R.color.CAM_X0304);
                    k55Var.p();
                }
                arrayList.add(k55Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        m55 m55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (m55Var = this.a) != null) {
            m55Var.dismiss();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            o55 o55Var = new o55(this.g.getPageActivity());
            this.b = o55Var;
            o55Var.t(this.c);
            this.b.q(this.f);
            this.b.l(a(this.d));
            this.b.n(wi.g(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f0708d2));
            m55 m55Var = new m55(this.g, this.b);
            this.a = m55Var;
            m55Var.l();
        }
    }
}
