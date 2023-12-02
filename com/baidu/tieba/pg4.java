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
/* loaded from: classes7.dex */
public class pg4 implements ig4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<wf4> a;
    public ce4 b;
    public List<if4> c;
    public List<if4> d;
    public List<if4> e;

    @Override // com.baidu.tieba.ig4
    public <T> void a(mg4<T> mg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mg4Var) == null) {
        }
    }

    public pg4(ce4 ce4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ce4Var};
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
        this.b = ce4Var;
        this.a = new ArrayList();
        kg4.b().e(this);
    }

    @Override // com.baidu.tieba.ig4
    public <T> void b(mg4<T> mg4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mg4Var) != null) || mg4Var.k()) {
            return;
        }
        Iterator<wf4> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            wf4 next = it.next();
            if (next.b(mg4Var)) {
                int i = mg4Var.i();
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

    public void c(wf4 wf4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wf4Var) == null) && wf4Var != null) {
            this.a.add(wf4Var);
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.isEmpty()) {
                this.b.b();
                kg4.b().g(this);
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
        for (wf4 wf4Var : this.a) {
            wf4Var.c(false);
        }
    }
}
