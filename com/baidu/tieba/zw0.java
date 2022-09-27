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
public abstract class zw0 implements bx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<vu0>> a;
    @Nullable
    public wu0 b;
    @Nullable
    public List<wu0> c;
    @Nullable
    public List<yu0> d;

    public zw0() {
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

    @Override // com.baidu.tieba.bx0
    @Deprecated
    public void a(@Nullable wu0 wu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wu0Var) == null) {
            this.b = wu0Var;
        }
    }

    @Override // com.baidu.tieba.bx0
    public void b(@NonNull yu0 yu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yu0Var) == null) {
            j(yu0Var);
        }
    }

    @Override // com.baidu.tieba.bx0
    public void c(int i, @NonNull vu0 vu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, vu0Var) == null) {
            CopyOnWriteArrayList<vu0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(vu0Var)) {
                int expectOrder = vu0Var.getExpectOrder();
                if (expectOrder == 0) {
                    copyOnWriteArrayList.add(vu0Var);
                } else if (expectOrder == 1) {
                    copyOnWriteArrayList.add(0, vu0Var);
                } else if (expectOrder == 2) {
                    copyOnWriteArrayList.add(copyOnWriteArrayList.size(), vu0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.bx0
    public void d(@NonNull ut0 ut0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ut0Var) == null) {
            String type = getType();
            dz0.i(type, System.identityHashCode(this) + " notifyEvent " + ut0Var);
            if (ut0Var.j() == 1) {
                if (i(ut0Var)) {
                    return;
                }
                g(ut0Var);
                ut0Var.o();
                return;
            }
            l(ut0Var);
        }
    }

    @Override // com.baidu.tieba.bx0
    public void e(vu0 vu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vu0Var) == null) {
            for (CopyOnWriteArrayList<vu0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(vu0Var);
            }
        }
    }

    @Override // com.baidu.tieba.bx0
    public void f(@NonNull yu0 yu0Var) {
        List<yu0> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, yu0Var) == null) || (list = this.d) == null) {
            return;
        }
        list.remove(yu0Var);
    }

    public void g(ut0 ut0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ut0Var) == null) {
            k(ut0Var);
            h(ut0Var);
            CopyOnWriteArrayList<vu0> copyOnWriteArrayList = this.a.get(Integer.valueOf(ut0Var.getType()));
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
                return;
            }
            Iterator<vu0> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                vu0 next = it.next();
                if (!ut0Var.b(next)) {
                    switch (ut0Var.getType()) {
                        case -1:
                        case 6:
                            next.a(ut0Var);
                            continue;
                        case 1:
                            next.n(ut0Var);
                            continue;
                        case 2:
                            next.q(ut0Var);
                            continue;
                        case 3:
                            next.k(ut0Var);
                            continue;
                        case 4:
                            next.d(ut0Var);
                            continue;
                        case 5:
                            next.h((PlayerStatus) ut0Var.f(2), (PlayerStatus) ut0Var.f(1));
                            continue;
                        case 7:
                            if (next instanceof dy0) {
                                ((dy0) next).g(ut0Var);
                                break;
                            } else {
                                next.a(ut0Var);
                                continue;
                            }
                        case 8:
                            next.j(ut0Var);
                            continue;
                    }
                }
            }
        }
    }

    public abstract /* synthetic */ String getType();

    public final void h(ut0 ut0Var) {
        List<yu0> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ut0Var) == null) || (list = this.d) == null) {
            return;
        }
        for (yu0 yu0Var : list) {
            yu0Var.a(ut0Var);
        }
    }

    public boolean i(ut0 ut0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, ut0Var)) == null) {
            wu0 wu0Var = this.b;
            if (wu0Var != null && wu0Var.getInterceptorLayer() != ut0Var.k() && this.b.e(ut0Var)) {
                dz0.b("AbsMessenger", "isNeedIntercept() = true, event = " + ut0Var);
                ut0Var.o();
                return true;
            }
            List<wu0> list = this.c;
            if (list != null) {
                for (wu0 wu0Var2 : list) {
                    if (wu0Var2.getInterceptorLayer() != ut0Var.k() && wu0Var2.e(ut0Var)) {
                        dz0.b("AbsMessenger", "isNeedIntercept() = true, event = " + ut0Var);
                        ut0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(yu0 yu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, yu0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (this.d.contains(yu0Var)) {
                return;
            }
            int expectOrder = yu0Var.getExpectOrder();
            if (expectOrder == 0) {
                this.d.add(yu0Var);
            } else if (expectOrder == 1) {
                this.d.add(0, yu0Var);
            } else if (expectOrder != 2) {
            } else {
                List<yu0> list = this.d;
                list.add(list.size(), yu0Var);
            }
        }
    }

    public final void k(ut0 ut0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ut0Var) == null) {
            if (ut0Var.i() == 0) {
                String type = getType();
                dz0.b(type, System.identityHashCode(this) + ": dispatch event :" + ut0Var);
                return;
            }
            String type2 = getType();
            dz0.i(type2, System.identityHashCode(this) + ": dispatch event :" + ut0Var);
        }
    }

    public abstract void l(@NonNull ut0 ut0Var);

    @Override // com.baidu.tieba.bx0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<yu0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<wu0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }
}
