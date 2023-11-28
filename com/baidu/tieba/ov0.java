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
/* loaded from: classes7.dex */
public abstract class ov0 implements qv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<kt0>> a;
    @Nullable
    public lt0 b;
    @Nullable
    public List<lt0> c;
    @Nullable
    public List<nt0> d;

    public abstract void l(@NonNull ks0 ks0Var);

    public ov0() {
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

    @Override // com.baidu.tieba.qv0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            List<nt0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<lt0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.qv0
    @Deprecated
    public void a(@Nullable lt0 lt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lt0Var) == null) {
            this.b = lt0Var;
        }
    }

    @Override // com.baidu.tieba.qv0
    public void b(@NonNull nt0 nt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nt0Var) == null) {
            j(nt0Var);
        }
    }

    @Override // com.baidu.tieba.qv0
    public void e(kt0 kt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kt0Var) == null) {
            for (CopyOnWriteArrayList<kt0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(kt0Var);
            }
        }
    }

    @Override // com.baidu.tieba.qv0
    public void f(@NonNull nt0 nt0Var) {
        List<nt0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, nt0Var) == null) && (list = this.d) != null) {
            list.remove(nt0Var);
        }
    }

    public final void h(ks0 ks0Var) {
        List<nt0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, ks0Var) == null) && (list = this.d) != null) {
            for (nt0 nt0Var : list) {
                nt0Var.a(ks0Var);
            }
        }
    }

    @Override // com.baidu.tieba.qv0
    public void c(int i, @NonNull kt0 kt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, kt0Var) == null) {
            CopyOnWriteArrayList<kt0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(kt0Var)) {
                int expectOrder = kt0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), kt0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, kt0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(kt0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.qv0
    public void d(@NonNull ks0 ks0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ks0Var) == null) {
            String type = getType();
            jx0.i(type, System.identityHashCode(this) + " notifyEvent " + ks0Var);
            if (ks0Var.j() == 1) {
                if (i(ks0Var)) {
                    return;
                }
                g(ks0Var);
                ks0Var.p();
                return;
            }
            l(ks0Var);
        }
    }

    public final void k(ks0 ks0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ks0Var) == null) {
            if (ks0Var.i() == 0) {
                String type = getType();
                jx0.b(type, System.identityHashCode(this) + ": dispatch event :" + ks0Var);
                return;
            }
            String type2 = getType();
            jx0.i(type2, System.identityHashCode(this) + ": dispatch event :" + ks0Var);
        }
    }

    public void g(ks0 ks0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ks0Var) == null) {
            k(ks0Var);
            h(ks0Var);
            CopyOnWriteArrayList<kt0> copyOnWriteArrayList = this.a.get(Integer.valueOf(ks0Var.m()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<kt0> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    kt0 next = it.next();
                    if (!ks0Var.b(next)) {
                        switch (ks0Var.m()) {
                            case -1:
                            case 6:
                                next.a(ks0Var);
                                continue;
                            case 1:
                                next.o(ks0Var);
                                continue;
                            case 2:
                                next.r(ks0Var);
                                continue;
                            case 3:
                                next.k(ks0Var);
                                continue;
                            case 4:
                                next.d(ks0Var);
                                continue;
                            case 5:
                                next.h((PlayerStatus) ks0Var.f(2), (PlayerStatus) ks0Var.f(1));
                                continue;
                            case 7:
                                if (next instanceof nw0) {
                                    ((nw0) next).g(ks0Var);
                                    break;
                                } else {
                                    next.a(ks0Var);
                                    continue;
                                }
                            case 8:
                                next.j(ks0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(ks0 ks0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ks0Var)) == null) {
            lt0 lt0Var = this.b;
            if (lt0Var != null && lt0Var.getInterceptorLayer() != ks0Var.k() && this.b.e(ks0Var)) {
                jx0.b("AbsMessenger", "isNeedIntercept() = true, event = " + ks0Var);
                ks0Var.p();
                return true;
            }
            List<lt0> list = this.c;
            if (list != null) {
                for (lt0 lt0Var2 : list) {
                    if (lt0Var2.getInterceptorLayer() != ks0Var.k() && lt0Var2.e(ks0Var)) {
                        jx0.b("AbsMessenger", "isNeedIntercept() = true, event = " + ks0Var);
                        ks0Var.p();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(nt0 nt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, nt0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(nt0Var)) {
                int expectOrder = nt0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List<nt0> list = this.d;
                            list.add(list.size(), nt0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, nt0Var);
                    return;
                }
                this.d.add(nt0Var);
            }
        }
    }
}
