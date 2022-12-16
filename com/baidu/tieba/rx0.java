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
/* loaded from: classes6.dex */
public abstract class rx0 implements tx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<nv0>> a;
    @Nullable
    public ov0 b;
    @Nullable
    public List<ov0> c;
    @Nullable
    public List<qv0> d;

    public abstract /* synthetic */ String getType();

    public abstract void l(@NonNull mu0 mu0Var);

    public rx0() {
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

    @Override // com.baidu.tieba.tx0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<qv0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<ov0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.tx0
    @Deprecated
    public void a(@Nullable ov0 ov0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ov0Var) == null) {
            this.b = ov0Var;
        }
    }

    @Override // com.baidu.tieba.tx0
    public void b(@NonNull qv0 qv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qv0Var) == null) {
            j(qv0Var);
        }
    }

    @Override // com.baidu.tieba.tx0
    public void e(nv0 nv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nv0Var) == null) {
            for (CopyOnWriteArrayList<nv0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(nv0Var);
            }
        }
    }

    @Override // com.baidu.tieba.tx0
    public void f(@NonNull qv0 qv0Var) {
        List<qv0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, qv0Var) == null) && (list = this.d) != null) {
            list.remove(qv0Var);
        }
    }

    public final void h(mu0 mu0Var) {
        List<qv0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mu0Var) == null) && (list = this.d) != null) {
            for (qv0 qv0Var : list) {
                qv0Var.a(mu0Var);
            }
        }
    }

    @Override // com.baidu.tieba.tx0
    public void c(int i, @NonNull nv0 nv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, nv0Var) == null) {
            CopyOnWriteArrayList<nv0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(nv0Var)) {
                int expectOrder = nv0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), nv0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, nv0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(nv0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.tx0
    public void d(@NonNull mu0 mu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mu0Var) == null) {
            String type = getType();
            vz0.i(type, System.identityHashCode(this) + " notifyEvent " + mu0Var);
            if (mu0Var.j() == 1) {
                if (i(mu0Var)) {
                    return;
                }
                g(mu0Var);
                mu0Var.o();
                return;
            }
            l(mu0Var);
        }
    }

    public final void k(mu0 mu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, mu0Var) == null) {
            if (mu0Var.i() == 0) {
                String type = getType();
                vz0.b(type, System.identityHashCode(this) + ": dispatch event :" + mu0Var);
                return;
            }
            String type2 = getType();
            vz0.i(type2, System.identityHashCode(this) + ": dispatch event :" + mu0Var);
        }
    }

    public void g(mu0 mu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mu0Var) == null) {
            k(mu0Var);
            h(mu0Var);
            CopyOnWriteArrayList<nv0> copyOnWriteArrayList = this.a.get(Integer.valueOf(mu0Var.getType()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<nv0> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    nv0 next = it.next();
                    if (!mu0Var.b(next)) {
                        switch (mu0Var.getType()) {
                            case -1:
                            case 6:
                                next.a(mu0Var);
                                continue;
                            case 1:
                                next.n(mu0Var);
                                continue;
                            case 2:
                                next.q(mu0Var);
                                continue;
                            case 3:
                                next.k(mu0Var);
                                continue;
                            case 4:
                                next.d(mu0Var);
                                continue;
                            case 5:
                                next.h((PlayerStatus) mu0Var.f(2), (PlayerStatus) mu0Var.f(1));
                                continue;
                            case 7:
                                if (next instanceof vy0) {
                                    ((vy0) next).g(mu0Var);
                                    break;
                                } else {
                                    next.a(mu0Var);
                                    continue;
                                }
                            case 8:
                                next.j(mu0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(mu0 mu0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, mu0Var)) == null) {
            ov0 ov0Var = this.b;
            if (ov0Var != null && ov0Var.getInterceptorLayer() != mu0Var.k() && this.b.e(mu0Var)) {
                vz0.b("AbsMessenger", "isNeedIntercept() = true, event = " + mu0Var);
                mu0Var.o();
                return true;
            }
            List<ov0> list = this.c;
            if (list != null) {
                for (ov0 ov0Var2 : list) {
                    if (ov0Var2.getInterceptorLayer() != mu0Var.k() && ov0Var2.e(mu0Var)) {
                        vz0.b("AbsMessenger", "isNeedIntercept() = true, event = " + mu0Var);
                        mu0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(qv0 qv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, qv0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(qv0Var)) {
                int expectOrder = qv0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List<qv0> list = this.d;
                            list.add(list.size(), qv0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, qv0Var);
                    return;
                }
                this.d.add(qv0Var);
            }
        }
    }
}
