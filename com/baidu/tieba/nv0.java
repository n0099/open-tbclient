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
public abstract class nv0 implements pv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<jt0>> a;
    @Nullable
    public kt0 b;
    @Nullable
    public List<kt0> c;
    @Nullable
    public List<mt0> d;

    public abstract void l(@NonNull js0 js0Var);

    public nv0() {
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

    @Override // com.baidu.tieba.pv0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            List<mt0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<kt0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.pv0
    @Deprecated
    public void a(@Nullable kt0 kt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kt0Var) == null) {
            this.b = kt0Var;
        }
    }

    @Override // com.baidu.tieba.pv0
    public void b(@NonNull mt0 mt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mt0Var) == null) {
            j(mt0Var);
        }
    }

    @Override // com.baidu.tieba.pv0
    public void e(jt0 jt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jt0Var) == null) {
            for (CopyOnWriteArrayList<jt0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(jt0Var);
            }
        }
    }

    @Override // com.baidu.tieba.pv0
    public void f(@NonNull mt0 mt0Var) {
        List<mt0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, mt0Var) == null) && (list = this.d) != null) {
            list.remove(mt0Var);
        }
    }

    public final void h(js0 js0Var) {
        List<mt0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, js0Var) == null) && (list = this.d) != null) {
            for (mt0 mt0Var : list) {
                mt0Var.a(js0Var);
            }
        }
    }

    @Override // com.baidu.tieba.pv0
    public void c(int i, @NonNull jt0 jt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, jt0Var) == null) {
            CopyOnWriteArrayList<jt0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(jt0Var)) {
                int expectOrder = jt0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), jt0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, jt0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(jt0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.pv0
    public void d(@NonNull js0 js0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, js0Var) == null) {
            String type = getType();
            ix0.i(type, System.identityHashCode(this) + " notifyEvent " + js0Var);
            if (js0Var.j() == 1) {
                if (i(js0Var)) {
                    return;
                }
                g(js0Var);
                js0Var.p();
                return;
            }
            l(js0Var);
        }
    }

    public final void k(js0 js0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, js0Var) == null) {
            if (js0Var.i() == 0) {
                String type = getType();
                ix0.b(type, System.identityHashCode(this) + ": dispatch event :" + js0Var);
                return;
            }
            String type2 = getType();
            ix0.i(type2, System.identityHashCode(this) + ": dispatch event :" + js0Var);
        }
    }

    public void g(js0 js0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, js0Var) == null) {
            k(js0Var);
            h(js0Var);
            CopyOnWriteArrayList<jt0> copyOnWriteArrayList = this.a.get(Integer.valueOf(js0Var.m()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<jt0> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    jt0 next = it.next();
                    if (!js0Var.b(next)) {
                        switch (js0Var.m()) {
                            case -1:
                            case 6:
                                next.a(js0Var);
                                continue;
                            case 1:
                                next.o(js0Var);
                                continue;
                            case 2:
                                next.r(js0Var);
                                continue;
                            case 3:
                                next.l(js0Var);
                                continue;
                            case 4:
                                next.d(js0Var);
                                continue;
                            case 5:
                                next.h((PlayerStatus) js0Var.f(2), (PlayerStatus) js0Var.f(1));
                                continue;
                            case 7:
                                if (next instanceof mw0) {
                                    ((mw0) next).g(js0Var);
                                    break;
                                } else {
                                    next.a(js0Var);
                                    continue;
                                }
                            case 8:
                                next.k(js0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(js0 js0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, js0Var)) == null) {
            kt0 kt0Var = this.b;
            if (kt0Var != null && kt0Var.getInterceptorLayer() != js0Var.k() && this.b.e(js0Var)) {
                ix0.b("AbsMessenger", "isNeedIntercept() = true, event = " + js0Var);
                js0Var.p();
                return true;
            }
            List<kt0> list = this.c;
            if (list != null) {
                for (kt0 kt0Var2 : list) {
                    if (kt0Var2.getInterceptorLayer() != js0Var.k() && kt0Var2.e(js0Var)) {
                        ix0.b("AbsMessenger", "isNeedIntercept() = true, event = " + js0Var);
                        js0Var.p();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(mt0 mt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, mt0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(mt0Var)) {
                int expectOrder = mt0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List<mt0> list = this.d;
                            list.add(list.size(), mt0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, mt0Var);
                    return;
                }
                this.d.add(mt0Var);
            }
        }
    }
}
