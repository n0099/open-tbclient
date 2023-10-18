package com.baidu.tieba;

import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.rz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class ze7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pz4 a;
    public rz4 b;
    public String c;
    public String[] d;
    public String e;
    public rz4.f f;
    public BdPageContext g;

    public ze7(BdPageContext bdPageContext) {
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

    public static ze7 c(BdPageContext bdPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bdPageContext)) == null) {
            return new ze7(bdPageContext);
        }
        return (ze7) invokeL.objValue;
    }

    public ze7 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (ze7) invokeL.objValue;
    }

    public ze7 e(rz4.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            this.f = fVar;
            return this;
        }
        return (ze7) invokeL.objValue;
    }

    public ze7 f(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            this.d = strArr;
            return this;
        }
        return (ze7) invokeL.objValue;
    }

    public ze7 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (ze7) invokeL.objValue;
    }

    public final List<nz4> a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                nz4 nz4Var = new nz4(i, str, this.b);
                if (!StringUtils.isNull(this.e) && this.e.equals(str)) {
                    nz4Var.r(R.color.CAM_X0304);
                    nz4Var.q();
                }
                arrayList.add(nz4Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        pz4 pz4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (pz4Var = this.a) != null) {
            pz4Var.dismiss();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            rz4 rz4Var = new rz4(this.g.getPageActivity());
            this.b = rz4Var;
            rz4Var.u(this.c);
            this.b.r(this.f);
            this.b.m(a(this.d));
            this.b.o(BdUtilHelper.getDimens(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f0708ea));
            pz4 pz4Var = new pz4(this.g, this.b);
            this.a = pz4Var;
            pz4Var.l();
        }
    }
}
