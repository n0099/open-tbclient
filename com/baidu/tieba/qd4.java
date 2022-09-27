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
/* loaded from: classes5.dex */
public class qd4 implements jd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<xc4> a;
    public db4 b;
    public List<jc4> c;
    public List<jc4> d;
    public List<jc4> e;

    public qd4(db4 db4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {db4Var};
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
        this.b = db4Var;
        this.a = new ArrayList();
        ld4.b().e(this);
    }

    @Override // com.baidu.tieba.jd4
    public <T> void a(nd4<T> nd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nd4Var) == null) {
        }
    }

    @Override // com.baidu.tieba.jd4
    public <T> void b(nd4<T> nd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nd4Var) == null) || nd4Var.k()) {
            return;
        }
        Iterator<xc4> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            xc4 next = it.next();
            if (next.b(nd4Var)) {
                int i = nd4Var.i();
                this.a.remove(next);
                if (i == 2) {
                    this.e.add(next.a().a.b);
                } else if (i == 3) {
                    this.d.add(next.a().a.b);
                } else if (i == 10) {
                    this.c.add(next.a().a.b);
                }
            }
        }
        d();
    }

    public void c(xc4 xc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xc4Var) == null) || xc4Var == null) {
            return;
        }
        this.a.add(xc4Var);
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.isEmpty()) {
                this.b.b();
                ld4.b().g(this);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || d()) {
            return;
        }
        for (xc4 xc4Var : this.a) {
            xc4Var.c(false);
        }
    }
}
