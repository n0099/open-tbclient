package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public abstract class sx0 implements ux0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<ov0>> a;
    @Nullable
    public pv0 b;
    @Nullable
    public List<pv0> c;
    @Nullable
    public List<rv0> d;

    public abstract /* synthetic */ String getType();

    public abstract void l(@NonNull nu0 nu0Var);

    public sx0() {
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
        this.a = new ConcurrentHashMap<>();
    }

    @Override // com.baidu.tieba.ux0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<rv0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<pv0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.ux0
    @Deprecated
    public void a(@Nullable pv0 pv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pv0Var) == null) {
            this.b = pv0Var;
        }
    }

    @Override // com.baidu.tieba.ux0
    public void b(@NonNull rv0 rv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv0Var) == null) {
            j(rv0Var);
        }
    }

    @Override // com.baidu.tieba.ux0
    public void e(ov0 ov0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ov0Var) == null) {
            for (CopyOnWriteArrayList<ov0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(ov0Var);
            }
        }
    }

    @Override // com.baidu.tieba.ux0
    public void f(@NonNull rv0 rv0Var) {
        List<rv0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, rv0Var) == null) && (list = this.d) != null) {
            list.remove(rv0Var);
        }
    }

    public final void h(nu0 nu0Var) {
        List<rv0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nu0Var) == null) && (list = this.d) != null) {
            for (rv0 rv0Var : list) {
                rv0Var.a(nu0Var);
            }
        }
    }

    @Override // com.baidu.tieba.ux0
    public void c(int i, @NonNull ov0 ov0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, ov0Var) == null) {
            CopyOnWriteArrayList<ov0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(ov0Var)) {
                int expectOrder = ov0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), ov0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, ov0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(ov0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.ux0
    public void d(@NonNull nu0 nu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nu0Var) == null) {
            String type = getType();
            wz0.i(type, System.identityHashCode(this) + " notifyEvent " + nu0Var);
            if (nu0Var.j() == 1) {
                if (i(nu0Var)) {
                    return;
                }
                g(nu0Var);
                nu0Var.o();
                return;
            }
            l(nu0Var);
        }
    }

    public final void k(nu0 nu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, nu0Var) == null) {
            if (nu0Var.i() == 0) {
                String type = getType();
                wz0.b(type, System.identityHashCode(this) + ": dispatch event :" + nu0Var);
                return;
            }
            String type2 = getType();
            wz0.i(type2, System.identityHashCode(this) + ": dispatch event :" + nu0Var);
        }
    }

    public void g(nu0 nu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, nu0Var) == null) {
            k(nu0Var);
            h(nu0Var);
            CopyOnWriteArrayList<ov0> copyOnWriteArrayList = this.a.get(Integer.valueOf(nu0Var.getType()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<ov0> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    ov0 next = it.next();
                    if (!nu0Var.b(next)) {
                        switch (nu0Var.getType()) {
                            case -1:
                            case 6:
                                next.a(nu0Var);
                                continue;
                            case 1:
                                next.n(nu0Var);
                                continue;
                            case 2:
                                next.q(nu0Var);
                                continue;
                            case 3:
                                next.k(nu0Var);
                                continue;
                            case 4:
                                next.d(nu0Var);
                                continue;
                            case 5:
                                next.h((PlayerStatus) nu0Var.f(2), (PlayerStatus) nu0Var.f(1));
                                continue;
                            case 7:
                                if (next instanceof wy0) {
                                    ((wy0) next).g(nu0Var);
                                    break;
                                } else {
                                    next.a(nu0Var);
                                    continue;
                                }
                            case 8:
                                next.j(nu0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(nu0 nu0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, nu0Var)) == null) {
            pv0 pv0Var = this.b;
            if (pv0Var != null && pv0Var.getInterceptorLayer() != nu0Var.k() && this.b.e(nu0Var)) {
                wz0.b("AbsMessenger", "isNeedIntercept() = true, event = " + nu0Var);
                nu0Var.o();
                return true;
            }
            List<pv0> list = this.c;
            if (list != null) {
                for (pv0 pv0Var2 : list) {
                    if (pv0Var2.getInterceptorLayer() != nu0Var.k() && pv0Var2.e(nu0Var)) {
                        wz0.b("AbsMessenger", "isNeedIntercept() = true, event = " + nu0Var);
                        nu0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(rv0 rv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, rv0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(rv0Var)) {
                int expectOrder = rv0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List<rv0> list = this.d;
                            list.add(list.size(), rv0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, rv0Var);
                    return;
                }
                this.d.add(rv0Var);
            }
        }
    }
}
