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
public abstract class xx0 implements zx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<tv0>> a;
    @Nullable
    public uv0 b;
    @Nullable
    public List<uv0> c;
    @Nullable
    public List<wv0> d;

    public abstract /* synthetic */ String getType();

    public abstract void l(@NonNull su0 su0Var);

    public xx0() {
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

    @Override // com.baidu.tieba.zx0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<wv0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<uv0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.zx0
    @Deprecated
    public void a(@Nullable uv0 uv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, uv0Var) == null) {
            this.b = uv0Var;
        }
    }

    @Override // com.baidu.tieba.zx0
    public void b(@NonNull wv0 wv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wv0Var) == null) {
            j(wv0Var);
        }
    }

    @Override // com.baidu.tieba.zx0
    public void e(tv0 tv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tv0Var) == null) {
            for (CopyOnWriteArrayList<tv0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(tv0Var);
            }
        }
    }

    @Override // com.baidu.tieba.zx0
    public void f(@NonNull wv0 wv0Var) {
        List<wv0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, wv0Var) == null) && (list = this.d) != null) {
            list.remove(wv0Var);
        }
    }

    public final void h(su0 su0Var) {
        List<wv0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, su0Var) == null) && (list = this.d) != null) {
            for (wv0 wv0Var : list) {
                wv0Var.a(su0Var);
            }
        }
    }

    @Override // com.baidu.tieba.zx0
    public void c(int i, @NonNull tv0 tv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, tv0Var) == null) {
            CopyOnWriteArrayList<tv0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(tv0Var)) {
                int expectOrder = tv0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), tv0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, tv0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(tv0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.zx0
    public void d(@NonNull su0 su0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, su0Var) == null) {
            String type = getType();
            c01.i(type, System.identityHashCode(this) + " notifyEvent " + su0Var);
            if (su0Var.j() == 1) {
                if (i(su0Var)) {
                    return;
                }
                g(su0Var);
                su0Var.o();
                return;
            }
            l(su0Var);
        }
    }

    public final void k(su0 su0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, su0Var) == null) {
            if (su0Var.i() == 0) {
                String type = getType();
                c01.b(type, System.identityHashCode(this) + ": dispatch event :" + su0Var);
                return;
            }
            String type2 = getType();
            c01.i(type2, System.identityHashCode(this) + ": dispatch event :" + su0Var);
        }
    }

    public void g(su0 su0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, su0Var) == null) {
            k(su0Var);
            h(su0Var);
            CopyOnWriteArrayList<tv0> copyOnWriteArrayList = this.a.get(Integer.valueOf(su0Var.getType()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<tv0> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    tv0 next = it.next();
                    if (!su0Var.b(next)) {
                        switch (su0Var.getType()) {
                            case -1:
                            case 6:
                                next.a(su0Var);
                                continue;
                            case 1:
                                next.n(su0Var);
                                continue;
                            case 2:
                                next.q(su0Var);
                                continue;
                            case 3:
                                next.k(su0Var);
                                continue;
                            case 4:
                                next.d(su0Var);
                                continue;
                            case 5:
                                next.h((PlayerStatus) su0Var.f(2), (PlayerStatus) su0Var.f(1));
                                continue;
                            case 7:
                                if (next instanceof bz0) {
                                    ((bz0) next).g(su0Var);
                                    break;
                                } else {
                                    next.a(su0Var);
                                    continue;
                                }
                            case 8:
                                next.j(su0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(su0 su0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, su0Var)) == null) {
            uv0 uv0Var = this.b;
            if (uv0Var != null && uv0Var.getInterceptorLayer() != su0Var.k() && this.b.e(su0Var)) {
                c01.b("AbsMessenger", "isNeedIntercept() = true, event = " + su0Var);
                su0Var.o();
                return true;
            }
            List<uv0> list = this.c;
            if (list != null) {
                for (uv0 uv0Var2 : list) {
                    if (uv0Var2.getInterceptorLayer() != su0Var.k() && uv0Var2.e(su0Var)) {
                        c01.b("AbsMessenger", "isNeedIntercept() = true, event = " + su0Var);
                        su0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(wv0 wv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, wv0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(wv0Var)) {
                int expectOrder = wv0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List<wv0> list = this.d;
                            list.add(list.size(), wv0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, wv0Var);
                    return;
                }
                this.d.add(wv0Var);
            }
        }
    }
}
