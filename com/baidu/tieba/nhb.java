package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.core.TransVodProxy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class nhb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ygb a;
    public xgb b;
    public List<ohb> c;
    public List<ohb> d;
    public AtomicInteger e;
    public WeakReference<TransVodProxy> f;
    public AtomicBoolean g;
    public AtomicBoolean h;
    public long i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948003873, "Lcom/baidu/tieba/nhb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948003873, "Lcom/baidu/tieba/nhb;");
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    public nhb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = new xgb();
        this.c = new LinkedList();
        this.d = new LinkedList();
        this.e = new AtomicInteger(4);
        this.f = null;
        this.g = new AtomicBoolean(false);
        this.h = new AtomicBoolean(false);
        this.i = 0L;
    }

    public void c() {
        ohb ohbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Iterator<ohb> it = this.c.iterator();
            ohb ohbVar2 = null;
            if (it.hasNext()) {
                ohbVar = it.next();
            } else {
                ohbVar = null;
            }
            while (it.hasNext()) {
                ohb next = it.next();
                ohbVar.k(next);
                ohbVar = next;
            }
            Iterator<ohb> it2 = this.d.iterator();
            if (it2.hasNext()) {
                ohbVar2 = it2.next();
            }
            while (it2.hasNext()) {
                ohb next2 = it2.next();
                ohbVar2.k(next2);
                ohbVar2 = next2;
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.e.set(6);
            for (ohb ohbVar : this.c) {
                ohbVar.a();
            }
            for (ohb ohbVar2 : this.d) {
                ohbVar2.a();
            }
            this.g.set(true);
            this.h.set(true);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.e.set(1);
            for (ohb ohbVar : this.c) {
                ohbVar.x();
            }
            for (ohb ohbVar2 : this.d) {
                ohbVar2.x();
            }
            this.g.set(false);
            this.h.set(false);
            ygb ygbVar = this.a;
            if (ygbVar != null) {
                ygbVar.f();
            }
            xgb xgbVar = this.b;
            if (xgbVar != null) {
                xgbVar.h();
            }
        }
    }

    public nhb a(int i, ohb ohbVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, ohbVar)) == null) {
            ohbVar.t(i);
            ohbVar.q(this);
            if (i == 0) {
                this.c.add(ohbVar);
            } else if (i == 1) {
                this.d.add(ohbVar);
            }
            return this;
        }
        return (nhb) invokeIL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.clear();
            this.d.clear();
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return invokeV.longValue;
    }

    public final ygb f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (ygb) invokeV.objValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e.get();
        }
        return invokeV.intValue;
    }

    public final xgb h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (xgb) invokeV.objValue;
    }

    public final TransVodProxy i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f.get();
        }
        return (TransVodProxy) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (ohb ohbVar : this.c) {
                ohbVar.l();
            }
            for (ohb ohbVar2 : this.d) {
                ohbVar2.l();
            }
        }
    }

    public void k(Handler handler, TransVodProxy transVodProxy, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, handler, transVodProxy, context) == null) {
            if (handler != null) {
                if (transVodProxy != null) {
                    this.f = new WeakReference<>(transVodProxy);
                    this.a = new ygb(this.f.get(), context);
                    this.b.b(this.f.get());
                    return;
                }
                throw new RuntimeException("proxy MUST not be null.");
            }
            throw new RuntimeException("handler MUST not be null.");
        }
    }

    public void l(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.i = j;
        }
    }
}
