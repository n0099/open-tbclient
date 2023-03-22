package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.ashley.core.ComponentOperationHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final g0<y> a;
    public final g0<y> b;
    public boolean c;
    public boolean d;
    public ComponentOperationHandler e;
    public h0<v> f;
    public k6<v> g;
    public n6 h;
    public n6 i;

    public y() {
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
        this.f = new h0<>();
        this.g = new k6<>(false, 16);
        this.h = new n6();
        this.i = new n6();
        this.a = new g0<>();
        this.b = new g0<>();
    }

    public y a(v vVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vVar)) == null) {
            if (b(vVar)) {
                ComponentOperationHandler componentOperationHandler = this.e;
                if (componentOperationHandler != null) {
                    componentOperationHandler.a(this);
                } else {
                    g();
                }
            }
            return this;
        }
        return (y) invokeL.objValue;
    }

    public <T extends v> T c(w wVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wVar)) == null) {
            if (wVar.c() < this.f.b()) {
                return (T) this.f.a(wVar.c());
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public <T extends v> T d(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) {
            return (T) c(w.b(cls));
        }
        return (T) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.y */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(v vVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vVar)) == null) {
            Class<?> cls = vVar.getClass();
            v d = d(cls);
            if (vVar == d) {
                return false;
            }
            if (d != null) {
                k(cls);
            }
            int d2 = w.d(cls);
            this.f.d(d2, vVar);
            this.g.a(vVar);
            this.h.k(d2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public v i(Class<? extends v> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls)) == null) {
            v a = this.f.a(w.b(cls).c());
            if (a != null && k(cls)) {
                ComponentOperationHandler componentOperationHandler = this.e;
                if (componentOperationHandler != null) {
                    componentOperationHandler.c(this);
                } else {
                    h();
                }
            }
            return a;
        }
        return (v) invokeL.objValue;
    }

    public boolean k(Class<? extends v> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cls)) == null) {
            int c = w.b(cls).c();
            v a = this.f.a(c);
            if (a != null) {
                this.f.d(c, null);
                this.g.i(a, true);
                this.h.c(c);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public n6 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return (n6) invokeV.objValue;
    }

    public n6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return (n6) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.b(this);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.b(this);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.y */
    /* JADX WARN: Multi-variable type inference failed */
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048585, this) != null) {
            return;
        }
        while (true) {
            k6<v> k6Var = this.g;
            if (k6Var.b > 0) {
                i(k6Var.get(0).getClass());
            } else {
                return;
            }
        }
    }
}
