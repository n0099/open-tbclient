package com.baidu.tieba;

import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class zi7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a55 a;
    public c55 b;
    public String c;
    public String[] d;
    public String e;
    public c55.f f;
    public BdPageContext g;

    public zi7(BdPageContext bdPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = bdPageContext;
    }

    public static zi7 c(BdPageContext bdPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bdPageContext)) == null) {
            return new zi7(bdPageContext);
        }
        return (zi7) invokeL.objValue;
    }

    public zi7 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (zi7) invokeL.objValue;
    }

    public zi7 e(c55.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            this.f = fVar;
            return this;
        }
        return (zi7) invokeL.objValue;
    }

    public zi7 f(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            this.d = strArr;
            return this;
        }
        return (zi7) invokeL.objValue;
    }

    public zi7 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (zi7) invokeL.objValue;
    }

    public final List<y45> a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                y45 y45Var = new y45(i, str, this.b);
                if (!StringUtils.isNull(this.e) && this.e.equals(str)) {
                    y45Var.q(R.color.CAM_X0304);
                    y45Var.p();
                }
                arrayList.add(y45Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        a55 a55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (a55Var = this.a) != null) {
            a55Var.dismiss();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c55 c55Var = new c55(this.g.getPageActivity());
            this.b = c55Var;
            c55Var.t(this.c);
            this.b.q(this.f);
            this.b.l(a(this.d));
            this.b.n(BdUtilHelper.getDimens(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f0708e9));
            a55 a55Var = new a55(this.g, this.b);
            this.a = a55Var;
            a55Var.l();
        }
    }
}
