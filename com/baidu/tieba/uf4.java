package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class uf4 implements nf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<bf4> a;
    public hd4 b;
    public List<ne4> c;
    public List<ne4> d;
    public List<ne4> e;

    @Override // com.baidu.tieba.nf4
    public <T> void a(rf4<T> rf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rf4Var) == null) {
        }
    }

    public uf4(hd4 hd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hd4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.b = hd4Var;
        this.a = new ArrayList();
        pf4.b().e(this);
    }

    @Override // com.baidu.tieba.nf4
    public <T> void b(rf4<T> rf4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rf4Var) != null) || rf4Var.k()) {
            return;
        }
        Iterator<bf4> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            bf4 next = it.next();
            if (next.b(rf4Var)) {
                int i = rf4Var.i();
                this.a.remove(next);
                if (i != 2) {
                    if (i != 3) {
                        if (i == 10) {
                            this.c.add(next.a().a.b);
                        }
                    } else {
                        this.d.add(next.a().a.b);
                    }
                } else {
                    this.e.add(next.a().a.b);
                }
            }
        }
        d();
    }

    public void c(bf4 bf4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bf4Var) == null) && bf4Var != null) {
            this.a.add(bf4Var);
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.isEmpty()) {
                this.b.b();
                pf4.b().g(this);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || d()) {
            return;
        }
        for (bf4 bf4Var : this.a) {
            bf4Var.c(false);
        }
    }
}
