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
/* loaded from: classes8.dex */
public class x5c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i5c a;
    public h5c b;
    public List<y5c> c;
    public List<y5c> d;
    public AtomicInteger e;
    public WeakReference<TransVodProxy> f;
    public AtomicBoolean g;
    public AtomicBoolean h;
    public long i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948252803, "Lcom/baidu/tieba/x5c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948252803, "Lcom/baidu/tieba/x5c;");
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    public x5c() {
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
        this.b = new h5c();
        this.c = new LinkedList();
        this.d = new LinkedList();
        this.e = new AtomicInteger(4);
        this.f = null;
        this.g = new AtomicBoolean(false);
        this.h = new AtomicBoolean(false);
        this.i = 0L;
    }

    public void c() {
        y5c y5cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Iterator<y5c> it = this.c.iterator();
            y5c y5cVar2 = null;
            if (it.hasNext()) {
                y5cVar = it.next();
            } else {
                y5cVar = null;
            }
            while (it.hasNext()) {
                y5c next = it.next();
                y5cVar.k(next);
                y5cVar = next;
            }
            Iterator<y5c> it2 = this.d.iterator();
            if (it2.hasNext()) {
                y5cVar2 = it2.next();
            }
            while (it2.hasNext()) {
                y5c next2 = it2.next();
                y5cVar2.k(next2);
                y5cVar2 = next2;
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.e.set(6);
            for (y5c y5cVar : this.c) {
                y5cVar.a();
            }
            for (y5c y5cVar2 : this.d) {
                y5cVar2.a();
            }
            this.g.set(true);
            this.h.set(true);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.e.set(1);
            for (y5c y5cVar : this.c) {
                y5cVar.x();
            }
            for (y5c y5cVar2 : this.d) {
                y5cVar2.x();
            }
            this.g.set(false);
            this.h.set(false);
            i5c i5cVar = this.a;
            if (i5cVar != null) {
                i5cVar.f();
            }
            h5c h5cVar = this.b;
            if (h5cVar != null) {
                h5cVar.h();
            }
        }
    }

    public x5c a(int i, y5c y5cVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, y5cVar)) == null) {
            y5cVar.t(i);
            y5cVar.q(this);
            if (i == 0) {
                this.c.add(y5cVar);
            } else if (i == 1) {
                this.d.add(y5cVar);
            }
            return this;
        }
        return (x5c) invokeIL.objValue;
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

    public final i5c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (i5c) invokeV.objValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e.get();
        }
        return invokeV.intValue;
    }

    public final h5c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (h5c) invokeV.objValue;
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
            for (y5c y5cVar : this.c) {
                y5cVar.l();
            }
            for (y5c y5cVar2 : this.d) {
                y5cVar2.l();
            }
        }
    }

    public void k(Handler handler, TransVodProxy transVodProxy, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, handler, transVodProxy, context) == null) {
            if (handler != null) {
                if (transVodProxy != null) {
                    this.f = new WeakReference<>(transVodProxy);
                    this.a = new i5c(this.f.get(), context);
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
