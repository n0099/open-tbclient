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
/* loaded from: classes4.dex */
public class je4 implements ce4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<qd4> a;
    public wb4 b;
    public List<cd4> c;
    public List<cd4> d;
    public List<cd4> e;

    @Override // com.baidu.tieba.ce4
    public <T> void a(ge4<T> ge4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ge4Var) == null) {
        }
    }

    public je4(wb4 wb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wb4Var};
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
        this.b = wb4Var;
        this.a = new ArrayList();
        ee4.b().e(this);
    }

    @Override // com.baidu.tieba.ce4
    public <T> void b(ge4<T> ge4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ge4Var) != null) || ge4Var.k()) {
            return;
        }
        Iterator<qd4> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            qd4 next = it.next();
            if (next.b(ge4Var)) {
                int i = ge4Var.i();
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

    public void c(qd4 qd4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qd4Var) == null) && qd4Var != null) {
            this.a.add(qd4Var);
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.isEmpty()) {
                this.b.b();
                ee4.b().g(this);
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
        for (qd4 qd4Var : this.a) {
            qd4Var.c(false);
        }
    }
}
