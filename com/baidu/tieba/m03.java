package com.baidu.tieba;

import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c03;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public class m03 implements c03.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map a;

    public m03() {
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
        this.a = new HashMap();
    }

    @Override // com.baidu.tieba.c03.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (String str : this.a.keySet()) {
                c(str);
            }
        }
    }

    @Override // com.baidu.tieba.c03.c
    public void b(e03 e03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e03Var) == null) {
            Message h = e03Var.h();
            if (e03Var.m()) {
                h(h);
            }
            Set l = e03Var.l();
            Set k = e03Var.k();
            if (e03Var.n()) {
                Iterator it = n03.k().q().iterator();
                while (it.hasNext()) {
                    l03 l03Var = (l03) it.next();
                    boolean g = g(l03Var, k);
                    if (l.contains(l03Var.b) || g) {
                        l03Var.g0(h);
                        if (g) {
                            k.remove(l03Var.getAppId());
                        }
                    }
                }
                f(k, h);
                return;
            }
            Iterator it2 = n03.k().q().iterator();
            while (it2.hasNext()) {
                l03 l03Var2 = (l03) it2.next();
                if (l03Var2 != null && l03Var2.T() && (l.contains(l03Var2.b) || g(l03Var2, k))) {
                    l03Var2.g0(h);
                }
            }
        }
    }

    @Override // com.baidu.tieba.c03.c
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            Deque deque = (Deque) this.a.get(str);
            c03.f("flushMsg:: appid=" + str + " msgQueue=" + deque);
            if (deque != null && !deque.isEmpty()) {
                List<l03> j = n03.k().j(str);
                c03.f("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + j.size());
                if (j.isEmpty()) {
                    return;
                }
                for (l03 l03Var : j) {
                    l03Var.i0(deque);
                }
                deque.clear();
            }
        }
    }

    @Override // com.baidu.tieba.c03.c
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.a.remove(str);
        }
    }

    public final void h(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, message) == null) {
            try {
                n03.k().e.send(message);
            } catch (RemoteException e) {
                c03.f(Log.getStackTraceString(e));
            }
        }
    }

    public final void e(String str, Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, str, message) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        Deque deque = (Deque) this.a.get(str);
        if (deque == null) {
            deque = new ArrayDeque();
            this.a.put(str, deque);
        }
        deque.offer(message);
    }

    public final void f(Set set, Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, set, message) == null) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                e((String) it.next(), message);
            }
        }
    }

    public boolean g(l03 l03Var, Set set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, l03Var, set)) == null) {
            if (l03Var.E() && set.contains(l03Var.getAppId())) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
