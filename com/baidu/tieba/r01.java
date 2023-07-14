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
public abstract class r01 implements t01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<ny0>> a;
    @Nullable
    public oy0 b;
    @Nullable
    public List<oy0> c;
    @Nullable
    public List<qy0> d;

    public abstract /* synthetic */ String getType();

    public abstract void l(@NonNull mx0 mx0Var);

    public r01() {
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

    @Override // com.baidu.tieba.t01
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            List<qy0> list = this.d;
            if (list != null) {
                list.clear();
                this.d = null;
            }
            this.a.clear();
            this.b = null;
            List<oy0> list2 = this.c;
            if (list2 != null) {
                list2.clear();
                this.c = null;
            }
        }
    }

    @Override // com.baidu.tieba.t01
    @Deprecated
    public void a(@Nullable oy0 oy0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oy0Var) == null) {
            this.b = oy0Var;
        }
    }

    @Override // com.baidu.tieba.t01
    public void b(@NonNull qy0 qy0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qy0Var) == null) {
            j(qy0Var);
        }
    }

    @Override // com.baidu.tieba.t01
    public void e(ny0 ny0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ny0Var) == null) {
            for (CopyOnWriteArrayList<ny0> copyOnWriteArrayList : this.a.values()) {
                copyOnWriteArrayList.remove(ny0Var);
            }
        }
    }

    @Override // com.baidu.tieba.t01
    public void f(@NonNull qy0 qy0Var) {
        List<qy0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, qy0Var) == null) && (list = this.d) != null) {
            list.remove(qy0Var);
        }
    }

    public final void h(mx0 mx0Var) {
        List<qy0> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mx0Var) == null) && (list = this.d) != null) {
            for (qy0 qy0Var : list) {
                qy0Var.a(mx0Var);
            }
        }
    }

    @Override // com.baidu.tieba.t01
    public void c(int i, @NonNull ny0 ny0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, ny0Var) == null) {
            CopyOnWriteArrayList<ny0> copyOnWriteArrayList = this.a.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(ny0Var)) {
                int expectOrder = ny0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), ny0Var);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, ny0Var);
                    }
                } else {
                    copyOnWriteArrayList.add(ny0Var);
                }
            }
            this.a.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.tieba.t01
    public void d(@NonNull mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mx0Var) == null) {
            String type = getType();
            v21.i(type, System.identityHashCode(this) + " notifyEvent " + mx0Var);
            if (mx0Var.j() == 1) {
                if (i(mx0Var)) {
                    return;
                }
                g(mx0Var);
                mx0Var.o();
                return;
            }
            l(mx0Var);
        }
    }

    public final void k(mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, mx0Var) == null) {
            if (mx0Var.i() == 0) {
                String type = getType();
                v21.b(type, System.identityHashCode(this) + ": dispatch event :" + mx0Var);
                return;
            }
            String type2 = getType();
            v21.i(type2, System.identityHashCode(this) + ": dispatch event :" + mx0Var);
        }
    }

    public void g(mx0 mx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mx0Var) == null) {
            k(mx0Var);
            h(mx0Var);
            CopyOnWriteArrayList<ny0> copyOnWriteArrayList = this.a.get(Integer.valueOf(mx0Var.getType()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator<ny0> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    ny0 next = it.next();
                    if (!mx0Var.b(next)) {
                        switch (mx0Var.getType()) {
                            case -1:
                            case 6:
                                next.a(mx0Var);
                                continue;
                            case 1:
                                next.n(mx0Var);
                                continue;
                            case 2:
                                next.q(mx0Var);
                                continue;
                            case 3:
                                next.k(mx0Var);
                                continue;
                            case 4:
                                next.d(mx0Var);
                                continue;
                            case 5:
                                next.h((PlayerStatus) mx0Var.f(2), (PlayerStatus) mx0Var.f(1));
                                continue;
                            case 7:
                                if (next instanceof v11) {
                                    ((v11) next).g(mx0Var);
                                    break;
                                } else {
                                    next.a(mx0Var);
                                    continue;
                                }
                            case 8:
                                next.j(mx0Var);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public boolean i(mx0 mx0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, mx0Var)) == null) {
            oy0 oy0Var = this.b;
            if (oy0Var != null && oy0Var.getInterceptorLayer() != mx0Var.k() && this.b.e(mx0Var)) {
                v21.b("AbsMessenger", "isNeedIntercept() = true, event = " + mx0Var);
                mx0Var.o();
                return true;
            }
            List<oy0> list = this.c;
            if (list != null) {
                for (oy0 oy0Var2 : list) {
                    if (oy0Var2.getInterceptorLayer() != mx0Var.k() && oy0Var2.e(mx0Var)) {
                        v21.b("AbsMessenger", "isNeedIntercept() = true, event = " + mx0Var);
                        mx0Var.o();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void j(qy0 qy0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, qy0Var) == null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains(qy0Var)) {
                int expectOrder = qy0Var.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List<qy0> list = this.d;
                            list.add(list.size(), qy0Var);
                            return;
                        }
                        return;
                    }
                    this.d.add(0, qy0Var);
                    return;
                }
                this.d.add(qy0Var);
            }
        }
    }
}
