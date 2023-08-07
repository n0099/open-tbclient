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
/* loaded from: classes8.dex */
public abstract class uz0 implements wz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<qx0>> a;
    @Nullable
    public rx0 b;
    @Nullable
    public List<rx0> c;
    @Nullable
    public List<tx0> d;

    public abstract /* synthetic */ String getType();

    public abstract void l(@NonNull pw0 pw0Var);

    public uz0() {
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

    @Override // com.baidu.tieba.wz0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<tx0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<rx0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.wz0
    @Deprecated
    public void a(@Nullable rx0 rx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rx0Var) == null) {
            this.b = rx0Var;
        }
    }

    @Override // com.baidu.tieba.wz0
    public void b(@NonNull tx0 tx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tx0Var) == null) {
            j(tx0Var);
        }
    }

    @Override // com.baidu.tieba.wz0
    public void e(qx0 qx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, qx0Var) == null) {
            for (CopyOnWriteArrayList<qx0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(qx0Var);
            }
        }
    }

    @Override // com.baidu.tieba.wz0
    public void f(@NonNull tx0 tx0Var) {
        List<tx0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, tx0Var) == null) && (list = this.d) != null) {
            list.remove(tx0Var);
        }
    }

    public final void h(pw0 pw0Var) {
        List<tx0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pw0Var) == null) && (list = this.d) != null) {
            for (tx0 tx0Var : list) {
                tx0Var.a(pw0Var);
            }
        }
    }

    @Override // com.baidu.tieba.wz0
    public void c(int i, @NonNull qx0 qx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, qx0Var) == null) {
            CopyOnWriteArrayList<qx0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(qx0Var)) {
                int expectOrder = qx0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), qx0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, qx0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(qx0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.wz0
    public void d(@NonNull pw0 pw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pw0Var) == null) {
            String type = getType();
            y11.i(type, System.identityHashCode(this) + " notifyEvent " + pw0Var);
            if (pw0Var.j() == 1) {
                if (i(pw0Var)) {
                    return;
                }
                g(pw0Var);
                pw0Var.o();
                return;
            }
            l(pw0Var);
        }
    }

    public final void k(pw0 pw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, pw0Var) == null) {
            if (pw0Var.i() == 0) {
                String type = getType();
                y11.b(type, System.identityHashCode(this) + ": dispatch event :" + pw0Var);
                return;
            }
            String type2 = getType();
            y11.i(type2, System.identityHashCode(this) + ": dispatch event :" + pw0Var);
        }
    }

    public void g(pw0 pw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pw0Var) == null) {
            k(pw0Var);
            h(pw0Var);
            CopyOnWriteArrayList<qx0> copyOnWriteArrayList = this.a.get(Integer.valueOf(pw0Var.getType()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<qx0> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    qx0 next = it.next();
                    if (!pw0Var.b(next)) {
                        switch (pw0Var.getType()) {
                            case -1:
                            case 6:
                                next.a(pw0Var);
                                continue;
                            case 1:
                                next.n(pw0Var);
                                continue;
                            case 2:
                                next.q(pw0Var);
                                continue;
                            case 3:
                                next.k(pw0Var);
                                continue;
                            case 4:
                                next.d(pw0Var);
                                continue;
                            case 5:
                                next.h((PlayerStatus) pw0Var.f(2), (PlayerStatus) pw0Var.f(1));
                                continue;
                            case 7:
                                if (next instanceof y01) {
                                    ((y01) next).g(pw0Var);
                                    break;
                                } else {
                                    next.a(pw0Var);
                                    continue;
                                }
                            case 8:
                                next.j(pw0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(pw0 pw0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, pw0Var)) == null) {
            rx0 rx0Var = this.b;
            if (rx0Var != null && rx0Var.getInterceptorLayer() != pw0Var.k() && this.b.e(pw0Var)) {
                y11.b("AbsMessenger", "isNeedIntercept() = true, event = " + pw0Var);
                pw0Var.o();
                return true;
            }
            List<rx0> list = this.c;
            if (list != null) {
                for (rx0 rx0Var2 : list) {
                    if (rx0Var2.getInterceptorLayer() != pw0Var.k() && rx0Var2.e(pw0Var)) {
                        y11.b("AbsMessenger", "isNeedIntercept() = true, event = " + pw0Var);
                        pw0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(tx0 tx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tx0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(tx0Var)) {
                int expectOrder = tx0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List<tx0> list = this.d;
                            list.add(list.size(), tx0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, tx0Var);
                    return;
                }
                this.d.add(tx0Var);
            }
        }
    }
}
