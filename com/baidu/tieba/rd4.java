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
public class rd4 implements kd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List a;
    public eb4 b;
    public List c;
    public List d;
    public List e;

    @Override // com.baidu.tieba.kd4
    public void a(od4 od4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, od4Var) == null) {
        }
    }

    public rd4(eb4 eb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eb4Var};
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
        this.b = eb4Var;
        this.a = new ArrayList();
        md4.b().e(this);
    }

    @Override // com.baidu.tieba.kd4
    public void b(od4 od4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, od4Var) != null) || od4Var.k()) {
            return;
        }
        Iterator it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            yc4 yc4Var = (yc4) it.next();
            if (yc4Var.b(od4Var)) {
                int i = od4Var.i();
                this.a.remove(yc4Var);
                if (i != 2) {
                    if (i != 3) {
                        if (i == 10) {
                            this.c.add(yc4Var.a().a.b);
                        }
                    } else {
                        this.d.add(yc4Var.a().a.b);
                    }
                } else {
                    this.e.add(yc4Var.a().a.b);
                }
            }
        }
        d();
    }

    public void c(yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yc4Var) == null) && yc4Var != null) {
            this.a.add(yc4Var);
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.isEmpty()) {
                this.b.b();
                md4.b().g(this);
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
        for (yc4 yc4Var : this.a) {
            yc4Var.c(false);
        }
    }
}
