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
public abstract class qy0 implements sy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<mw0>> a;
    @Nullable
    public nw0 b;
    @Nullable
    public List<nw0> c;
    @Nullable
    public List<pw0> d;

    public abstract /* synthetic */ String getType();

    public abstract void l(@NonNull lv0 lv0Var);

    public qy0() {
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

    @Override // com.baidu.tieba.sy0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<pw0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<nw0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.sy0
    @Deprecated
    public void a(@Nullable nw0 nw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nw0Var) == null) {
            this.b = nw0Var;
        }
    }

    @Override // com.baidu.tieba.sy0
    public void b(@NonNull pw0 pw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pw0Var) == null) {
            j(pw0Var);
        }
    }

    @Override // com.baidu.tieba.sy0
    public void e(mw0 mw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mw0Var) == null) {
            for (CopyOnWriteArrayList<mw0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(mw0Var);
            }
        }
    }

    @Override // com.baidu.tieba.sy0
    public void f(@NonNull pw0 pw0Var) {
        List<pw0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, pw0Var) == null) && (list = this.d) != null) {
            list.remove(pw0Var);
        }
    }

    public final void h(lv0 lv0Var) {
        List<pw0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lv0Var) == null) && (list = this.d) != null) {
            for (pw0 pw0Var : list) {
                pw0Var.a(lv0Var);
            }
        }
    }

    @Override // com.baidu.tieba.sy0
    public void c(int i, @NonNull mw0 mw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, mw0Var) == null) {
            CopyOnWriteArrayList<mw0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(mw0Var)) {
                int expectOrder = mw0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), mw0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, mw0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(mw0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.sy0
    public void d(@NonNull lv0 lv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lv0Var) == null) {
            String type = getType();
            v01.i(type, System.identityHashCode(this) + " notifyEvent " + lv0Var);
            if (lv0Var.j() == 1) {
                if (i(lv0Var)) {
                    return;
                }
                g(lv0Var);
                lv0Var.o();
                return;
            }
            l(lv0Var);
        }
    }

    public final void k(lv0 lv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, lv0Var) == null) {
            if (lv0Var.i() == 0) {
                String type = getType();
                v01.b(type, System.identityHashCode(this) + ": dispatch event :" + lv0Var);
                return;
            }
            String type2 = getType();
            v01.i(type2, System.identityHashCode(this) + ": dispatch event :" + lv0Var);
        }
    }

    public void g(lv0 lv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lv0Var) == null) {
            k(lv0Var);
            h(lv0Var);
            CopyOnWriteArrayList<mw0> copyOnWriteArrayList = this.a.get(Integer.valueOf(lv0Var.getType()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<mw0> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    mw0 next = it.next();
                    if (!lv0Var.b(next)) {
                        switch (lv0Var.getType()) {
                            case -1:
                            case 6:
                                next.a(lv0Var);
                                continue;
                            case 1:
                                next.n(lv0Var);
                                continue;
                            case 2:
                                next.q(lv0Var);
                                continue;
                            case 3:
                                next.k(lv0Var);
                                continue;
                            case 4:
                                next.d(lv0Var);
                                continue;
                            case 5:
                                next.h((PlayerStatus) lv0Var.f(2), (PlayerStatus) lv0Var.f(1));
                                continue;
                            case 7:
                                if (next instanceof uz0) {
                                    ((uz0) next).g(lv0Var);
                                    break;
                                } else {
                                    next.a(lv0Var);
                                    continue;
                                }
                            case 8:
                                next.j(lv0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(lv0 lv0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, lv0Var)) == null) {
            nw0 nw0Var = this.b;
            if (nw0Var != null && nw0Var.getInterceptorLayer() != lv0Var.k() && this.b.e(lv0Var)) {
                v01.b("AbsMessenger", "isNeedIntercept() = true, event = " + lv0Var);
                lv0Var.o();
                return true;
            }
            List<nw0> list = this.c;
            if (list != null) {
                for (nw0 nw0Var2 : list) {
                    if (nw0Var2.getInterceptorLayer() != lv0Var.k() && nw0Var2.e(lv0Var)) {
                        v01.b("AbsMessenger", "isNeedIntercept() = true, event = " + lv0Var);
                        lv0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(pw0 pw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pw0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(pw0Var)) {
                int expectOrder = pw0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List<pw0> list = this.d;
                            list.add(list.size(), pw0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, pw0Var);
                    return;
                }
                this.d.add(pw0Var);
            }
        }
    }
}
