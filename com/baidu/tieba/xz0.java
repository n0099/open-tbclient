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
public abstract class xz0 implements zz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<tx0>> a;
    @Nullable
    public ux0 b;
    @Nullable
    public List<ux0> c;
    @Nullable
    public List<wx0> d;

    public abstract /* synthetic */ String getType();

    public abstract void l(@NonNull sw0 sw0Var);

    public xz0() {
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

    @Override // com.baidu.tieba.zz0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<wx0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<ux0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.zz0
    @Deprecated
    public void a(@Nullable ux0 ux0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ux0Var) == null) {
            this.b = ux0Var;
        }
    }

    @Override // com.baidu.tieba.zz0
    public void b(@NonNull wx0 wx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wx0Var) == null) {
            j(wx0Var);
        }
    }

    @Override // com.baidu.tieba.zz0
    public void e(tx0 tx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tx0Var) == null) {
            for (CopyOnWriteArrayList<tx0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(tx0Var);
            }
        }
    }

    @Override // com.baidu.tieba.zz0
    public void f(@NonNull wx0 wx0Var) {
        List<wx0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, wx0Var) == null) && (list = this.d) != null) {
            list.remove(wx0Var);
        }
    }

    public final void h(sw0 sw0Var) {
        List<wx0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sw0Var) == null) && (list = this.d) != null) {
            for (wx0 wx0Var : list) {
                wx0Var.a(sw0Var);
            }
        }
    }

    @Override // com.baidu.tieba.zz0
    public void c(int i, @NonNull tx0 tx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, tx0Var) == null) {
            CopyOnWriteArrayList<tx0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(tx0Var)) {
                int expectOrder = tx0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), tx0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, tx0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(tx0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.zz0
    public void d(@NonNull sw0 sw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sw0Var) == null) {
            String type = getType();
            b21.i(type, System.identityHashCode(this) + " notifyEvent " + sw0Var);
            if (sw0Var.j() == 1) {
                if (i(sw0Var)) {
                    return;
                }
                g(sw0Var);
                sw0Var.o();
                return;
            }
            l(sw0Var);
        }
    }

    public final void k(sw0 sw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sw0Var) == null) {
            if (sw0Var.i() == 0) {
                String type = getType();
                b21.b(type, System.identityHashCode(this) + ": dispatch event :" + sw0Var);
                return;
            }
            String type2 = getType();
            b21.i(type2, System.identityHashCode(this) + ": dispatch event :" + sw0Var);
        }
    }

    public void g(sw0 sw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sw0Var) == null) {
            k(sw0Var);
            h(sw0Var);
            CopyOnWriteArrayList<tx0> copyOnWriteArrayList = this.a.get(Integer.valueOf(sw0Var.getType()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<tx0> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    tx0 next = it.next();
                    if (!sw0Var.b(next)) {
                        switch (sw0Var.getType()) {
                            case -1:
                            case 6:
                                next.a(sw0Var);
                                continue;
                            case 1:
                                next.n(sw0Var);
                                continue;
                            case 2:
                                next.q(sw0Var);
                                continue;
                            case 3:
                                next.k(sw0Var);
                                continue;
                            case 4:
                                next.d(sw0Var);
                                continue;
                            case 5:
                                next.h((PlayerStatus) sw0Var.f(2), (PlayerStatus) sw0Var.f(1));
                                continue;
                            case 7:
                                if (next instanceof b11) {
                                    ((b11) next).g(sw0Var);
                                    break;
                                } else {
                                    next.a(sw0Var);
                                    continue;
                                }
                            case 8:
                                next.j(sw0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(sw0 sw0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, sw0Var)) == null) {
            ux0 ux0Var = this.b;
            if (ux0Var != null && ux0Var.getInterceptorLayer() != sw0Var.k() && this.b.e(sw0Var)) {
                b21.b("AbsMessenger", "isNeedIntercept() = true, event = " + sw0Var);
                sw0Var.o();
                return true;
            }
            List<ux0> list = this.c;
            if (list != null) {
                for (ux0 ux0Var2 : list) {
                    if (ux0Var2.getInterceptorLayer() != sw0Var.k() && ux0Var2.e(sw0Var)) {
                        b21.b("AbsMessenger", "isNeedIntercept() = true, event = " + sw0Var);
                        sw0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(wx0 wx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, wx0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(wx0Var)) {
                int expectOrder = wx0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List<wx0> list = this.d;
                            list.add(list.size(), wx0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, wx0Var);
                    return;
                }
                this.d.add(wx0Var);
            }
        }
    }
}
