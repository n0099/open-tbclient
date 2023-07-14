package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a65;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class zj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y55 a;
    public a65 b;
    public String c;
    public String[] d;
    public String e;
    public a65.f f;
    public l9 g;

    public zj7(l9 l9Var) {
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

    public static zj7 c(l9 l9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, l9Var)) == null) {
            return new zj7(l9Var);
        }
        return (zj7) invokeL.objValue;
    }

    public zj7 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (zj7) invokeL.objValue;
    }

    public zj7 e(a65.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) {
            this.f = fVar;
            return this;
        }
        return (zj7) invokeL.objValue;
    }

    public zj7 f(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            this.d = strArr;
            return this;
        }
        return (zj7) invokeL.objValue;
    }

    public zj7 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (zj7) invokeL.objValue;
    }

    public final List<w55> a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                w55 w55Var = new w55(i, str, this.b);
                if (!StringUtils.isNull(this.e) && this.e.equals(str)) {
                    w55Var.q(R.color.CAM_X0304);
                    w55Var.p();
                }
                arrayList.add(w55Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void b() {
        y55 y55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (y55Var = this.a) != null) {
            y55Var.dismiss();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a65 a65Var = new a65(this.g.getPageActivity());
            this.b = a65Var;
            a65Var.t(this.c);
            this.b.q(this.f);
            this.b.l(a(this.d));
            this.b.n(yi.g(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f0708e9));
            y55 y55Var = new y55(this.g, this.b);
            this.a = y55Var;
            y55Var.l();
        }
    }
}
