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
public abstract class wx0 implements yx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<sv0>> a;
    @Nullable
    public tv0 b;
    @Nullable
    public List<tv0> c;
    @Nullable
    public List<vv0> d;

    public abstract /* synthetic */ String getType();

    public abstract void l(@NonNull ru0 ru0Var);

    public wx0() {
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

    @Override // com.baidu.tieba.yx0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<vv0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<tv0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.yx0
    @Deprecated
    public void a(@Nullable tv0 tv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tv0Var) == null) {
            this.b = tv0Var;
        }
    }

    @Override // com.baidu.tieba.yx0
    public void b(@NonNull vv0 vv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vv0Var) == null) {
            j(vv0Var);
        }
    }

    @Override // com.baidu.tieba.yx0
    public void e(sv0 sv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sv0Var) == null) {
            for (CopyOnWriteArrayList<sv0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(sv0Var);
            }
        }
    }

    @Override // com.baidu.tieba.yx0
    public void f(@NonNull vv0 vv0Var) {
        List<vv0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, vv0Var) == null) && (list = this.d) != null) {
            list.remove(vv0Var);
        }
    }

    public final void h(ru0 ru0Var) {
        List<vv0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ru0Var) == null) && (list = this.d) != null) {
            for (vv0 vv0Var : list) {
                vv0Var.a(ru0Var);
            }
        }
    }

    @Override // com.baidu.tieba.yx0
    public void c(int i, @NonNull sv0 sv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, sv0Var) == null) {
            CopyOnWriteArrayList<sv0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(sv0Var)) {
                int expectOrder = sv0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), sv0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, sv0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(sv0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.yx0
    public void d(@NonNull ru0 ru0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ru0Var) == null) {
            String type = getType();
            b01.i(type, System.identityHashCode(this) + " notifyEvent " + ru0Var);
            if (ru0Var.j() == 1) {
                if (i(ru0Var)) {
                    return;
                }
                g(ru0Var);
                ru0Var.o();
                return;
            }
            l(ru0Var);
        }
    }

    public final void k(ru0 ru0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ru0Var) == null) {
            if (ru0Var.i() == 0) {
                String type = getType();
                b01.b(type, System.identityHashCode(this) + ": dispatch event :" + ru0Var);
                return;
            }
            String type2 = getType();
            b01.i(type2, System.identityHashCode(this) + ": dispatch event :" + ru0Var);
        }
    }

    public void g(ru0 ru0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ru0Var) == null) {
            k(ru0Var);
            h(ru0Var);
            CopyOnWriteArrayList<sv0> copyOnWriteArrayList = this.a.get(Integer.valueOf(ru0Var.getType()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<sv0> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    sv0 next = it.next();
                    if (!ru0Var.b(next)) {
                        switch (ru0Var.getType()) {
                            case -1:
                            case 6:
                                next.a(ru0Var);
                                continue;
                            case 1:
                                next.n(ru0Var);
                                continue;
                            case 2:
                                next.q(ru0Var);
                                continue;
                            case 3:
                                next.k(ru0Var);
                                continue;
                            case 4:
                                next.d(ru0Var);
                                continue;
                            case 5:
                                next.h((PlayerStatus) ru0Var.f(2), (PlayerStatus) ru0Var.f(1));
                                continue;
                            case 7:
                                if (next instanceof az0) {
                                    ((az0) next).g(ru0Var);
                                    break;
                                } else {
                                    next.a(ru0Var);
                                    continue;
                                }
                            case 8:
                                next.j(ru0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(ru0 ru0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, ru0Var)) == null) {
            tv0 tv0Var = this.b;
            if (tv0Var != null && tv0Var.getInterceptorLayer() != ru0Var.k() && this.b.e(ru0Var)) {
                b01.b("AbsMessenger", "isNeedIntercept() = true, event = " + ru0Var);
                ru0Var.o();
                return true;
            }
            List<tv0> list = this.c;
            if (list != null) {
                for (tv0 tv0Var2 : list) {
                    if (tv0Var2.getInterceptorLayer() != ru0Var.k() && tv0Var2.e(ru0Var)) {
                        b01.b("AbsMessenger", "isNeedIntercept() = true, event = " + ru0Var);
                        ru0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(vv0 vv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, vv0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(vv0Var)) {
                int expectOrder = vv0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List<vv0> list = this.d;
                            list.add(list.size(), vv0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, vv0Var);
                    return;
                }
                this.d.add(vv0Var);
            }
        }
    }
}
