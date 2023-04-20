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
public abstract class yx0 implements ay0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<uv0>> a;
    @Nullable
    public vv0 b;
    @Nullable
    public List<vv0> c;
    @Nullable
    public List<xv0> d;

    public abstract /* synthetic */ String getType();

    public abstract void l(@NonNull tu0 tu0Var);

    public yx0() {
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

    @Override // com.baidu.tieba.ay0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<xv0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<vv0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.ay0
    @Deprecated
    public void a(@Nullable vv0 vv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vv0Var) == null) {
            this.b = vv0Var;
        }
    }

    @Override // com.baidu.tieba.ay0
    public void b(@NonNull xv0 xv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xv0Var) == null) {
            j(xv0Var);
        }
    }

    @Override // com.baidu.tieba.ay0
    public void e(uv0 uv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, uv0Var) == null) {
            for (CopyOnWriteArrayList<uv0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(uv0Var);
            }
        }
    }

    @Override // com.baidu.tieba.ay0
    public void f(@NonNull xv0 xv0Var) {
        List<xv0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, xv0Var) == null) && (list = this.d) != null) {
            list.remove(xv0Var);
        }
    }

    public final void h(tu0 tu0Var) {
        List<xv0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tu0Var) == null) && (list = this.d) != null) {
            for (xv0 xv0Var : list) {
                xv0Var.a(tu0Var);
            }
        }
    }

    @Override // com.baidu.tieba.ay0
    public void c(int i, @NonNull uv0 uv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, uv0Var) == null) {
            CopyOnWriteArrayList<uv0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(uv0Var)) {
                int expectOrder = uv0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), uv0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, uv0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(uv0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.ay0
    public void d(@NonNull tu0 tu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tu0Var) == null) {
            String type = getType();
            d01.i(type, System.identityHashCode(this) + " notifyEvent " + tu0Var);
            if (tu0Var.j() == 1) {
                if (i(tu0Var)) {
                    return;
                }
                g(tu0Var);
                tu0Var.o();
                return;
            }
            l(tu0Var);
        }
    }

    public final void k(tu0 tu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tu0Var) == null) {
            if (tu0Var.i() == 0) {
                String type = getType();
                d01.b(type, System.identityHashCode(this) + ": dispatch event :" + tu0Var);
                return;
            }
            String type2 = getType();
            d01.i(type2, System.identityHashCode(this) + ": dispatch event :" + tu0Var);
        }
    }

    public void g(tu0 tu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tu0Var) == null) {
            k(tu0Var);
            h(tu0Var);
            CopyOnWriteArrayList<uv0> copyOnWriteArrayList = this.a.get(Integer.valueOf(tu0Var.getType()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<uv0> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    uv0 next = it.next();
                    if (!tu0Var.b(next)) {
                        switch (tu0Var.getType()) {
                            case -1:
                            case 6:
                                next.a(tu0Var);
                                continue;
                            case 1:
                                next.n(tu0Var);
                                continue;
                            case 2:
                                next.q(tu0Var);
                                continue;
                            case 3:
                                next.k(tu0Var);
                                continue;
                            case 4:
                                next.d(tu0Var);
                                continue;
                            case 5:
                                next.h((PlayerStatus) tu0Var.f(2), (PlayerStatus) tu0Var.f(1));
                                continue;
                            case 7:
                                if (next instanceof cz0) {
                                    ((cz0) next).g(tu0Var);
                                    break;
                                } else {
                                    next.a(tu0Var);
                                    continue;
                                }
                            case 8:
                                next.j(tu0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(tu0 tu0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, tu0Var)) == null) {
            vv0 vv0Var = this.b;
            if (vv0Var != null && vv0Var.getInterceptorLayer() != tu0Var.k() && this.b.e(tu0Var)) {
                d01.b("AbsMessenger", "isNeedIntercept() = true, event = " + tu0Var);
                tu0Var.o();
                return true;
            }
            List<vv0> list = this.c;
            if (list != null) {
                for (vv0 vv0Var2 : list) {
                    if (vv0Var2.getInterceptorLayer() != tu0Var.k() && vv0Var2.e(tu0Var)) {
                        d01.b("AbsMessenger", "isNeedIntercept() = true, event = " + tu0Var);
                        tu0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(xv0 xv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, xv0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(xv0Var)) {
                int expectOrder = xv0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List<xv0> list = this.d;
                            list.add(list.size(), xv0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, xv0Var);
                    return;
                }
                this.d.add(xv0Var);
            }
        }
    }
}
