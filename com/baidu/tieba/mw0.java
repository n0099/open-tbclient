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
public abstract class mw0 implements ow0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<iu0>> a;
    @Nullable
    public ju0 b;
    @Nullable
    public List<ju0> c;
    @Nullable
    public List<lu0> d;

    public mw0() {
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

    @Override // com.baidu.tieba.ow0
    @Deprecated
    public void a(@Nullable ju0 ju0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ju0Var) == null) {
            this.b = ju0Var;
        }
    }

    @Override // com.baidu.tieba.ow0
    public void b(@NonNull lu0 lu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lu0Var) == null) {
            j(lu0Var);
        }
    }

    @Override // com.baidu.tieba.ow0
    public void c(int i, @NonNull iu0 iu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, iu0Var) == null) {
            CopyOnWriteArrayList<iu0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(iu0Var)) {
                int expectOrder = iu0Var.getExpectOrder();
                if (expectOrder == 0) {
                    copyOnWriteArrayList.add(iu0Var);
                } else if (expectOrder == 1) {
                    copyOnWriteArrayList.add(0, iu0Var);
                } else if (expectOrder == 2) {
                    copyOnWriteArrayList.add(copyOnWriteArrayList.size(), iu0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.ow0
    public void d(@NonNull ht0 ht0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ht0Var) == null) {
            String type = getType();
            qy0.i(type, System.identityHashCode(this) + " notifyEvent " + ht0Var);
            if (ht0Var.j() == 1) {
                if (i(ht0Var)) {
                    return;
                }
                g(ht0Var);
                ht0Var.o();
                return;
            }
            l(ht0Var);
        }
    }

    @Override // com.baidu.tieba.ow0
    public void e(iu0 iu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iu0Var) == null) {
            for (CopyOnWriteArrayList<iu0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(iu0Var);
            }
        }
    }

    @Override // com.baidu.tieba.ow0
    public void f(@NonNull lu0 lu0Var) {
        List<lu0> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, lu0Var) == null) || (list = this.d) == null) {
            return;
        }
        list.remove(lu0Var);
    }

    public void g(ht0 ht0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ht0Var) == null) {
            k(ht0Var);
            h(ht0Var);
            CopyOnWriteArrayList<iu0> copyOnWriteArrayList = this.a.get(Integer.valueOf(ht0Var.getType()));
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
                return;
            }
            Iterator<iu0> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                iu0 next = it.next();
                if (!ht0Var.b(next)) {
                    switch (ht0Var.getType()) {
                        case -1:
                        case 6:
                            next.a(ht0Var);
                            continue;
                        case 1:
                            next.n(ht0Var);
                            continue;
                        case 2:
                            next.q(ht0Var);
                            continue;
                        case 3:
                            next.k(ht0Var);
                            continue;
                        case 4:
                            next.d(ht0Var);
                            continue;
                        case 5:
                            next.h((PlayerStatus) ht0Var.f(2), (PlayerStatus) ht0Var.f(1));
                            continue;
                        case 7:
                            if (next instanceof qx0) {
                                ((qx0) next).g(ht0Var);
                                break;
                            } else {
                                next.a(ht0Var);
                                continue;
                            }
                        case 8:
                            next.j(ht0Var);
                            continue;
                    }
                }
            }
        }
    }

    public abstract /* synthetic */ String getType();

    public final void h(ht0 ht0Var) {
        List<lu0> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ht0Var) == null) || (list = this.d) == null) {
            return;
        }
        for (lu0 lu0Var : list) {
            lu0Var.a(ht0Var);
        }
    }

    public boolean i(ht0 ht0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, ht0Var)) == null) {
            ju0 ju0Var = this.b;
            if (ju0Var != null && ju0Var.getInterceptorLayer() != ht0Var.k() && this.b.e(ht0Var)) {
                qy0.b("AbsMessenger", "isNeedIntercept() = true, event = " + ht0Var);
                ht0Var.o();
                return true;
            }
            List<ju0> list = this.c;
            if (list != null) {
                for (ju0 ju0Var2 : list) {
                    if (ju0Var2.getInterceptorLayer() != ht0Var.k() && ju0Var2.e(ht0Var)) {
                        qy0.b("AbsMessenger", "isNeedIntercept() = true, event = " + ht0Var);
                        ht0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(lu0 lu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, lu0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (this.d.contains(lu0Var)) {
                return;
            }
            int expectOrder = lu0Var.getExpectOrder();
            if (expectOrder == 0) {
                this.d.add(lu0Var);
            } else if (expectOrder == 1) {
                this.d.add(0, lu0Var);
            } else if (expectOrder != 2) {
            } else {
                List<lu0> list = this.d;
                list.add(list.size(), lu0Var);
            }
        }
    }

    public final void k(ht0 ht0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ht0Var) == null) {
            if (ht0Var.i() == 0) {
                String type = getType();
                qy0.b(type, System.identityHashCode(this) + ": dispatch event :" + ht0Var);
                return;
            }
            String type2 = getType();
            qy0.i(type2, System.identityHashCode(this) + ": dispatch event :" + ht0Var);
        }
    }

    public abstract void l(@NonNull ht0 ht0Var);

    @Override // com.baidu.tieba.ow0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<lu0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<ju0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }
}
