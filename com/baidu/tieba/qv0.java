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
public abstract class qv0 implements sv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<mt0>> a;
    @Nullable
    public nt0 b;
    @Nullable
    public List<nt0> c;
    @Nullable
    public List<pt0> d;

    public abstract void l(@NonNull ms0 ms0Var);

    public qv0() {
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

    @Override // com.baidu.tieba.sv0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            List<pt0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<nt0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.sv0
    @Deprecated
    public void a(@Nullable nt0 nt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nt0Var) == null) {
            this.b = nt0Var;
        }
    }

    @Override // com.baidu.tieba.sv0
    public void b(@NonNull pt0 pt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pt0Var) == null) {
            j(pt0Var);
        }
    }

    @Override // com.baidu.tieba.sv0
    public void e(mt0 mt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mt0Var) == null) {
            for (CopyOnWriteArrayList<mt0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(mt0Var);
            }
        }
    }

    @Override // com.baidu.tieba.sv0
    public void f(@NonNull pt0 pt0Var) {
        List<pt0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, pt0Var) == null) && (list = this.d) != null) {
            list.remove(pt0Var);
        }
    }

    public final void h(ms0 ms0Var) {
        List<pt0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, ms0Var) == null) && (list = this.d) != null) {
            for (pt0 pt0Var : list) {
                pt0Var.a(ms0Var);
            }
        }
    }

    @Override // com.baidu.tieba.sv0
    public void c(int i, @NonNull mt0 mt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, mt0Var) == null) {
            CopyOnWriteArrayList<mt0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(mt0Var)) {
                int expectOrder = mt0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), mt0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, mt0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(mt0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.sv0
    public void d(@NonNull ms0 ms0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ms0Var) == null) {
            String type = getType();
            lx0.i(type, System.identityHashCode(this) + " notifyEvent " + ms0Var);
            if (ms0Var.j() == 1) {
                if (i(ms0Var)) {
                    return;
                }
                g(ms0Var);
                ms0Var.p();
                return;
            }
            l(ms0Var);
        }
    }

    public final void k(ms0 ms0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ms0Var) == null) {
            if (ms0Var.i() == 0) {
                String type = getType();
                lx0.b(type, System.identityHashCode(this) + ": dispatch event :" + ms0Var);
                return;
            }
            String type2 = getType();
            lx0.i(type2, System.identityHashCode(this) + ": dispatch event :" + ms0Var);
        }
    }

    public void g(ms0 ms0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ms0Var) == null) {
            k(ms0Var);
            h(ms0Var);
            CopyOnWriteArrayList<mt0> copyOnWriteArrayList = this.a.get(Integer.valueOf(ms0Var.m()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<mt0> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    mt0 next = it.next();
                    if (!ms0Var.b(next)) {
                        switch (ms0Var.m()) {
                            case -1:
                            case 6:
                                next.a(ms0Var);
                                continue;
                            case 1:
                                next.o(ms0Var);
                                continue;
                            case 2:
                                next.r(ms0Var);
                                continue;
                            case 3:
                                next.k(ms0Var);
                                continue;
                            case 4:
                                next.d(ms0Var);
                                continue;
                            case 5:
                                next.h((PlayerStatus) ms0Var.f(2), (PlayerStatus) ms0Var.f(1));
                                continue;
                            case 7:
                                if (next instanceof pw0) {
                                    ((pw0) next).g(ms0Var);
                                    break;
                                } else {
                                    next.a(ms0Var);
                                    continue;
                                }
                            case 8:
                                next.j(ms0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(ms0 ms0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ms0Var)) == null) {
            nt0 nt0Var = this.b;
            if (nt0Var != null && nt0Var.getInterceptorLayer() != ms0Var.k() && this.b.e(ms0Var)) {
                lx0.b("AbsMessenger", "isNeedIntercept() = true, event = " + ms0Var);
                ms0Var.p();
                return true;
            }
            List<nt0> list = this.c;
            if (list != null) {
                for (nt0 nt0Var2 : list) {
                    if (nt0Var2.getInterceptorLayer() != ms0Var.k() && nt0Var2.e(ms0Var)) {
                        lx0.b("AbsMessenger", "isNeedIntercept() = true, event = " + ms0Var);
                        ms0Var.p();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(pt0 pt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, pt0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(pt0Var)) {
                int expectOrder = pt0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List<pt0> list = this.d;
                            list.add(list.size(), pt0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, pt0Var);
                    return;
                }
                this.d.add(pt0Var);
            }
        }
    }
}
