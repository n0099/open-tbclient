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
public abstract class wu0 implements yu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<ss0>> a;
    @Nullable
    public ts0 b;
    @Nullable
    public List<ts0> c;
    @Nullable
    public List<vs0> d;

    public abstract void l(@NonNull sr0 sr0Var);

    public wu0() {
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

    @Override // com.baidu.tieba.yu0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            List<vs0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<ts0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.yu0
    @Deprecated
    public void a(@Nullable ts0 ts0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ts0Var) == null) {
            this.b = ts0Var;
        }
    }

    @Override // com.baidu.tieba.yu0
    public void b(@NonNull vs0 vs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vs0Var) == null) {
            j(vs0Var);
        }
    }

    @Override // com.baidu.tieba.yu0
    public void e(ss0 ss0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ss0Var) == null) {
            for (CopyOnWriteArrayList<ss0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(ss0Var);
            }
        }
    }

    @Override // com.baidu.tieba.yu0
    public void f(@NonNull vs0 vs0Var) {
        List<vs0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, vs0Var) == null) && (list = this.d) != null) {
            list.remove(vs0Var);
        }
    }

    public final void h(sr0 sr0Var) {
        List<vs0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, sr0Var) == null) && (list = this.d) != null) {
            for (vs0 vs0Var : list) {
                vs0Var.a(sr0Var);
            }
        }
    }

    @Override // com.baidu.tieba.yu0
    public void c(int i, @NonNull ss0 ss0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, ss0Var) == null) {
            CopyOnWriteArrayList<ss0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(ss0Var)) {
                int expectOrder = ss0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), ss0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, ss0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(ss0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.yu0
    public void d(@NonNull sr0 sr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sr0Var) == null) {
            String type = getType();
            rw0.i(type, System.identityHashCode(this) + " notifyEvent " + sr0Var);
            if (sr0Var.j() == 1) {
                if (i(sr0Var)) {
                    return;
                }
                g(sr0Var);
                sr0Var.p();
                return;
            }
            l(sr0Var);
        }
    }

    public final void k(sr0 sr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, sr0Var) == null) {
            if (sr0Var.i() == 0) {
                String type = getType();
                rw0.b(type, System.identityHashCode(this) + ": dispatch event :" + sr0Var);
                return;
            }
            String type2 = getType();
            rw0.i(type2, System.identityHashCode(this) + ": dispatch event :" + sr0Var);
        }
    }

    public void g(sr0 sr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sr0Var) == null) {
            k(sr0Var);
            h(sr0Var);
            CopyOnWriteArrayList<ss0> copyOnWriteArrayList = this.a.get(Integer.valueOf(sr0Var.m()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<ss0> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    ss0 next = it.next();
                    if (!sr0Var.b(next)) {
                        switch (sr0Var.m()) {
                            case -1:
                            case 6:
                                next.a(sr0Var);
                                continue;
                            case 1:
                                next.n(sr0Var);
                                continue;
                            case 2:
                                next.q(sr0Var);
                                continue;
                            case 3:
                                next.k(sr0Var);
                                continue;
                            case 4:
                                next.d(sr0Var);
                                continue;
                            case 5:
                                next.h((PlayerStatus) sr0Var.f(2), (PlayerStatus) sr0Var.f(1));
                                continue;
                            case 7:
                                if (next instanceof vv0) {
                                    ((vv0) next).g(sr0Var);
                                    break;
                                } else {
                                    next.a(sr0Var);
                                    continue;
                                }
                            case 8:
                                next.j(sr0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(sr0 sr0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sr0Var)) == null) {
            ts0 ts0Var = this.b;
            if (ts0Var != null && ts0Var.getInterceptorLayer() != sr0Var.k() && this.b.e(sr0Var)) {
                rw0.b("AbsMessenger", "isNeedIntercept() = true, event = " + sr0Var);
                sr0Var.p();
                return true;
            }
            List<ts0> list = this.c;
            if (list != null) {
                for (ts0 ts0Var2 : list) {
                    if (ts0Var2.getInterceptorLayer() != sr0Var.k() && ts0Var2.e(sr0Var)) {
                        rw0.b("AbsMessenger", "isNeedIntercept() = true, event = " + sr0Var);
                        sr0Var.p();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(vs0 vs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, vs0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(vs0Var)) {
                int expectOrder = vs0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List<vs0> list = this.d;
                            list.add(list.size(), vs0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, vs0Var);
                    return;
                }
                this.d.add(vs0Var);
            }
        }
    }
}
