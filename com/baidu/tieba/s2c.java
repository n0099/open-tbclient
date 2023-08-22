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
public class s2c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d2c a;
    public c2c b;
    public List<t2c> c;
    public List<t2c> d;
    public AtomicInteger e;
    public WeakReference<TransVodProxy> f;
    public AtomicBoolean g;
    public AtomicBoolean h;
    public long i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948100965, "Lcom/baidu/tieba/s2c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948100965, "Lcom/baidu/tieba/s2c;");
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    public s2c() {
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
        this.b = new c2c();
        this.c = new LinkedList();
        this.d = new LinkedList();
        this.e = new AtomicInteger(4);
        this.f = null;
        this.g = new AtomicBoolean(false);
        this.h = new AtomicBoolean(false);
        this.i = 0L;
    }

    public void c() {
        t2c t2cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Iterator<t2c> it = this.c.iterator();
            t2c t2cVar2 = null;
            if (it.hasNext()) {
                t2cVar = it.next();
            } else {
                t2cVar = null;
            }
            while (it.hasNext()) {
                t2c next = it.next();
                t2cVar.k(next);
                t2cVar = next;
            }
            Iterator<t2c> it2 = this.d.iterator();
            if (it2.hasNext()) {
                t2cVar2 = it2.next();
            }
            while (it2.hasNext()) {
                t2c next2 = it2.next();
                t2cVar2.k(next2);
                t2cVar2 = next2;
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.e.set(6);
            for (t2c t2cVar : this.c) {
                t2cVar.a();
            }
            for (t2c t2cVar2 : this.d) {
                t2cVar2.a();
            }
            this.g.set(true);
            this.h.set(true);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.e.set(1);
            for (t2c t2cVar : this.c) {
                t2cVar.x();
            }
            for (t2c t2cVar2 : this.d) {
                t2cVar2.x();
            }
            this.g.set(false);
            this.h.set(false);
            d2c d2cVar = this.a;
            if (d2cVar != null) {
                d2cVar.f();
            }
            c2c c2cVar = this.b;
            if (c2cVar != null) {
                c2cVar.h();
            }
        }
    }

    public s2c a(int i, t2c t2cVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, t2cVar)) == null) {
            t2cVar.t(i);
            t2cVar.q(this);
            if (i == 0) {
                this.c.add(t2cVar);
            } else if (i == 1) {
                this.d.add(t2cVar);
            }
            return this;
        }
        return (s2c) invokeIL.objValue;
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

    public final d2c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (d2c) invokeV.objValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e.get();
        }
        return invokeV.intValue;
    }

    public final c2c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (c2c) invokeV.objValue;
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
            for (t2c t2cVar : this.c) {
                t2cVar.l();
            }
            for (t2c t2cVar2 : this.d) {
                t2cVar2.l();
            }
        }
    }

    public void k(Handler handler, TransVodProxy transVodProxy, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, handler, transVodProxy, context) == null) {
            if (handler != null) {
                if (transVodProxy != null) {
                    this.f = new WeakReference<>(transVodProxy);
                    this.a = new d2c(this.f.get(), context);
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
