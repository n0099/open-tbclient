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
public abstract class zz0 implements b01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<vx0>> a;
    @Nullable
    public wx0 b;
    @Nullable
    public List<wx0> c;
    @Nullable
    public List<yx0> d;

    public abstract /* synthetic */ String getType();

    public abstract void l(@NonNull uw0 uw0Var);

    public zz0() {
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

    @Override // com.baidu.tieba.b01
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<yx0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<wx0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.b01
    @Deprecated
    public void a(@Nullable wx0 wx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wx0Var) == null) {
            this.b = wx0Var;
        }
    }

    @Override // com.baidu.tieba.b01
    public void b(@NonNull yx0 yx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yx0Var) == null) {
            j(yx0Var);
        }
    }

    @Override // com.baidu.tieba.b01
    public void e(vx0 vx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vx0Var) == null) {
            for (CopyOnWriteArrayList<vx0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(vx0Var);
            }
        }
    }

    @Override // com.baidu.tieba.b01
    public void f(@NonNull yx0 yx0Var) {
        List<yx0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, yx0Var) == null) && (list = this.d) != null) {
            list.remove(yx0Var);
        }
    }

    public final void h(uw0 uw0Var) {
        List<yx0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uw0Var) == null) && (list = this.d) != null) {
            for (yx0 yx0Var : list) {
                yx0Var.a(uw0Var);
            }
        }
    }

    @Override // com.baidu.tieba.b01
    public void c(int i, @NonNull vx0 vx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, vx0Var) == null) {
            CopyOnWriteArrayList<vx0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(vx0Var)) {
                int expectOrder = vx0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), vx0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, vx0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(vx0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.b01
    public void d(@NonNull uw0 uw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, uw0Var) == null) {
            String type = getType();
            e21.i(type, System.identityHashCode(this) + " notifyEvent " + uw0Var);
            if (uw0Var.j() == 1) {
                if (i(uw0Var)) {
                    return;
                }
                g(uw0Var);
                uw0Var.o();
                return;
            }
            l(uw0Var);
        }
    }

    public final void k(uw0 uw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, uw0Var) == null) {
            if (uw0Var.i() == 0) {
                String type = getType();
                e21.b(type, System.identityHashCode(this) + ": dispatch event :" + uw0Var);
                return;
            }
            String type2 = getType();
            e21.i(type2, System.identityHashCode(this) + ": dispatch event :" + uw0Var);
        }
    }

    public void g(uw0 uw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, uw0Var) == null) {
            k(uw0Var);
            h(uw0Var);
            CopyOnWriteArrayList<vx0> copyOnWriteArrayList = this.a.get(Integer.valueOf(uw0Var.getType()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<vx0> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    vx0 next = it.next();
                    if (!uw0Var.b(next)) {
                        switch (uw0Var.getType()) {
                            case -1:
                            case 6:
                                next.a(uw0Var);
                                continue;
                            case 1:
                                next.n(uw0Var);
                                continue;
                            case 2:
                                next.q(uw0Var);
                                continue;
                            case 3:
                                next.k(uw0Var);
                                continue;
                            case 4:
                                next.d(uw0Var);
                                continue;
                            case 5:
                                next.h((PlayerStatus) uw0Var.f(2), (PlayerStatus) uw0Var.f(1));
                                continue;
                            case 7:
                                if (next instanceof d11) {
                                    ((d11) next).g(uw0Var);
                                    break;
                                } else {
                                    next.a(uw0Var);
                                    continue;
                                }
                            case 8:
                                next.j(uw0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(uw0 uw0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, uw0Var)) == null) {
            wx0 wx0Var = this.b;
            if (wx0Var != null && wx0Var.getInterceptorLayer() != uw0Var.k() && this.b.e(uw0Var)) {
                e21.b("AbsMessenger", "isNeedIntercept() = true, event = " + uw0Var);
                uw0Var.o();
                return true;
            }
            List<wx0> list = this.c;
            if (list != null) {
                for (wx0 wx0Var2 : list) {
                    if (wx0Var2.getInterceptorLayer() != uw0Var.k() && wx0Var2.e(uw0Var)) {
                        e21.b("AbsMessenger", "isNeedIntercept() = true, event = " + uw0Var);
                        uw0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(yx0 yx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, yx0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(yx0Var)) {
                int expectOrder = yx0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List<yx0> list = this.d;
                            list.add(list.size(), yx0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, yx0Var);
                    return;
                }
                this.d.add(yx0Var);
            }
        }
    }
}
