package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class js8 implements is8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<hs8> a;
    public ls8 b;
    public is8 c;
    public int d;

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public abstract List<hs8> j(List list);

    public js8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.d = -1;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.size() > 0) {
                return this.a.size();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public List<hs8> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return Collections.unmodifiableList(this.a);
        }
        return (List) invokeV.objValue;
    }

    public hs8 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i >= 0 && i < e()) {
                return f().get(i);
            }
            return null;
        }
        return (hs8) invokeI.objValue;
    }

    public void i(int i) {
        ls8 ls8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && i >= 0 && (ls8Var = this.b) != null) {
            ls8Var.c(i, 1);
        }
    }

    public void k(is8 is8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, is8Var) == null) {
            this.c = is8Var;
        }
    }

    public void l(ls8 ls8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ls8Var) == null) {
            this.b = ls8Var;
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.d = i;
        }
    }

    public void g(List list) {
        List<hs8> j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && list != null && !list.isEmpty() && (j = j(list)) != null && !j.isEmpty()) {
            this.a.addAll(j);
            ls8 ls8Var = this.b;
            if (ls8Var != null) {
                ls8Var.b(0, e());
            }
        }
    }

    public void h(List list) {
        List<hs8> j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, list) == null) && list != null && !list.isEmpty() && (j = j(list)) != null && !j.isEmpty() && this.b != null) {
            int e = e();
            this.a.clear();
            this.b.a(0, e);
            this.a.addAll(j);
            this.b.c(0, e());
        }
    }
}
