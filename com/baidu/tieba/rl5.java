package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.graphic.decode.State;
import com.baidu.tieba.wl5;
import com.baidu.tieba.yl5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;
/* loaded from: classes7.dex */
public abstract class rl5<R extends wl5, W extends yl5> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String t = "rl5";
    public static final Rect u;
    public transient /* synthetic */ FieldHolder $fh;
    public final am5 a;
    public final Handler b;
    public List<ql5<R, W>> c;
    public int d;
    public int e;
    public Integer f;
    public final Set<sl5> g;
    public final AtomicBoolean h;
    public final Runnable i;
    public int j;
    public final Set<Bitmap> k;
    public final Object l;
    public Map<Bitmap, Canvas> m;
    public ByteBuffer n;
    public volatile Rect o;
    public W p;
    public R q;
    public boolean r;
    public volatile State s;

    public abstract Rect F(R r) throws IOException;

    public abstract void H();

    public abstract void J(ql5<R, W> ql5Var);

    public final String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? "" : (String) invokeV.objValue;
    }

    public abstract int v();

    public abstract R x(wl5 wl5Var);

    public abstract W z();

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl5 a;

        public a(rl5 rl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.h.get()) {
                return;
            }
            if (this.a.p()) {
                long currentTimeMillis = System.currentTimeMillis();
                this.a.b.postDelayed(this, Math.max(0L, this.a.N() - (System.currentTimeMillis() - currentTimeMillis)));
                for (sl5 sl5Var : this.a.g) {
                    sl5Var.b(this.a.n);
                }
                return;
            }
            this.a.O();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl5 a;
        public final /* synthetic */ rl5 b;

        public b(rl5 rl5Var, sl5 sl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl5Var, sl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rl5Var;
            this.a = sl5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.g.add(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl5 a;
        public final /* synthetic */ rl5 b;

        public c(rl5 rl5Var, sl5 sl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl5Var, sl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rl5Var;
            this.a = sl5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.g.remove(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl5 a;

        public d(rl5 rl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g.size() == 0) {
                this.a.O();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Thread a;
        public final /* synthetic */ rl5 b;

        public e(rl5 rl5Var, Thread thread) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl5Var, thread};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rl5Var;
            this.a = thread;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.rl5 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    try {
                        if (this.b.o == null) {
                            if (this.b.q == null) {
                                this.b.q = this.b.x(this.b.a.a());
                            } else {
                                this.b.q.reset();
                            }
                            this.b.A(this.b.F(this.b.q));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.b.o = rl5.u;
                    }
                } finally {
                    LockSupport.unpark(this.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl5 a;

        public f(rl5 rl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.B();
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl5 a;

        public g(rl5 rl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.C();
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl5 a;

        public h(rl5 rl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.e = 0;
            rl5 rl5Var = this.a;
            rl5Var.d = -1;
            rl5Var.r = false;
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ rl5 c;

        public i(rl5 rl5Var, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl5Var, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rl5Var;
            this.a = i;
            this.b = z;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.rl5 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.C();
            try {
                this.c.j = this.a;
                this.c.A(this.c.F(this.c.x(this.c.a.a())));
                if (!this.b) {
                    return;
                }
                this.c.B();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948125486, "Lcom/baidu/tieba/rl5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948125486, "Lcom/baidu/tieba/rl5;");
                return;
            }
        }
        u = new Rect();
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.s != State.RUNNING && this.s != State.INITIALIZING) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.post(new h(this));
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.b.post(new d(this));
        }
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.c.size();
        }
        return invokeV.intValue;
    }

    public final int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            Integer num = this.f;
            if (num != null) {
                return num.intValue();
            }
            return v();
        }
        return invokeV.intValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public rl5(am5 am5Var, @Nullable sl5 sl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {am5Var, sl5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.d = -1;
        this.f = null;
        this.g = new HashSet();
        this.h = new AtomicBoolean(true);
        this.i = new a(this);
        this.j = 1;
        this.k = new HashSet();
        this.l = new Object();
        this.m = new WeakHashMap();
        this.p = z();
        this.q = null;
        this.r = false;
        this.s = State.IDLE;
        this.a = am5Var;
        if (sl5Var != null) {
            this.g.add(sl5Var);
        }
        this.b = new Handler(tl5.b().c(tl5.b().a()));
    }

    public void G(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bitmap) == null) {
            synchronized (this.l) {
                if (bitmap != null) {
                    this.k.add(bitmap);
                }
            }
        }
    }

    public void I(sl5 sl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sl5Var) == null) {
            this.b.post(new c(this, sl5Var));
        }
    }

    public void o(sl5 sl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, sl5Var) == null) {
            this.b.post(new b(this, sl5Var));
        }
    }

    public ql5<R, W> t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            if (i2 >= 0 && i2 < this.c.size()) {
                return this.c.get(i2);
            }
            return null;
        }
        return (ql5) invokeI.objValue;
    }

    public boolean L(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i2, i3)) == null) {
            int s = s(i2, i3);
            if (s != this.j) {
                boolean D = D();
                this.b.removeCallbacks(this.i);
                this.b.post(new i(this, s, D));
                return true;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public final void A(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rect) == null) {
            this.o = rect;
            int width = rect.width() * rect.height();
            int i2 = this.j;
            this.n = ByteBuffer.allocate(((width / (i2 * i2)) + 1) * 4);
            if (this.p == null) {
                this.p = z();
            }
        }
    }

    @WorkerThread
    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.h.compareAndSet(true, false);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                if (this.c.size() == 0) {
                    if (this.q == null) {
                        this.q = x(this.a.a());
                    } else {
                        this.q.reset();
                    }
                    A(F(this.q));
                }
                String str = t;
                Log.i(str, q() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - currentTimeMillis));
                this.s = State.RUNNING;
                if (w() != 0 && this.r) {
                    String str2 = t;
                    Log.i(str2, q() + " No need to started");
                    return;
                }
                this.d = -1;
                this.i.run();
                for (sl5 sl5Var : this.g) {
                    sl5Var.onStart();
                }
            } catch (Throwable th) {
                String str3 = t;
                Log.i(str3, q() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - currentTimeMillis));
                this.s = State.RUNNING;
                throw th;
            }
        }
    }

    @WorkerThread
    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.removeCallbacks(this.i);
            this.c.clear();
            synchronized (this.l) {
                for (Bitmap bitmap : this.k) {
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                }
                this.k.clear();
            }
            if (this.n != null) {
                this.n = null;
            }
            this.m.clear();
            try {
                if (this.q != null) {
                    this.q.close();
                    this.q = null;
                }
                if (this.p != null) {
                    this.p.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            H();
            this.s = State.IDLE;
            for (sl5 sl5Var : this.g) {
                sl5Var.a();
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || this.o == u) {
            return;
        }
        if (this.s != State.RUNNING && this.s != State.INITIALIZING) {
            if (this.s == State.FINISHING) {
                String str = t;
                Log.e(str, q() + " Processing,wait for finish at " + this.s);
            }
            this.s = State.INITIALIZING;
            if (Looper.myLooper() == this.b.getLooper()) {
                B();
                return;
            } else {
                this.b.post(new f(this));
                return;
            }
        }
        String str2 = t;
        Log.i(str2, q() + " Already started");
    }

    public void O() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || this.o == u) {
            return;
        }
        if (this.s != State.FINISHING && this.s != State.IDLE) {
            if (this.s == State.INITIALIZING) {
                String str = t;
                Log.e(str, q() + "Processing,wait for finish at " + this.s);
            }
            this.s = State.FINISHING;
            if (Looper.myLooper() == this.b.getLooper()) {
                C();
                return;
            } else {
                this.b.post(new g(this));
                return;
            }
        }
        String str2 = t;
        Log.i(str2, q() + "No need to stop");
    }

    public Bitmap E(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i2, i3)) == null) {
            synchronized (this.l) {
                Iterator<Bitmap> it = this.k.iterator();
                Bitmap bitmap = null;
                while (it.hasNext()) {
                    int i4 = i2 * i3 * 4;
                    Bitmap next = it.next();
                    if (next != null && next.getAllocationByteCount() >= i4) {
                        it.remove();
                        if ((next.getWidth() != i2 || next.getHeight() != i3) && i2 > 0 && i3 > 0) {
                            next.reconfigure(i2, i3, Bitmap.Config.ARGB_8888);
                        }
                        next.eraseColor(0);
                        return next;
                    }
                    bitmap = next;
                }
                if (i2 <= 0 || i3 <= 0) {
                    return null;
                }
                try {
                    bitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return bitmap;
            }
        }
        return (Bitmap) invokeII.objValue;
    }

    @WorkerThread
    public final long N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int i2 = this.d + 1;
            this.d = i2;
            if (i2 >= u()) {
                this.d = 0;
                this.e++;
            }
            ql5<R, W> t2 = t(this.d);
            if (t2 == null) {
                return 0L;
            }
            J(t2);
            return t2.f;
        }
        return invokeV.longValue;
    }

    public Rect r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.o == null) {
                if (this.s == State.FINISHING) {
                    Log.e(t, "In finishing,do not interrupt");
                }
                Thread currentThread = Thread.currentThread();
                this.b.post(new e(this, currentThread));
                LockSupport.park(currentThread);
            }
            if (this.o == null) {
                return u;
            }
            return this.o;
        }
        return (Rect) invokeV.objValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (!D() || this.c.size() == 0) {
                return false;
            }
            if (w() <= 0 || this.e < w() - 1) {
                return true;
            }
            if (this.e == w() - 1 && this.d < u() - 1) {
                return true;
            }
            this.r = true;
            return false;
        }
        return invokeV.booleanValue;
    }

    public int s(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i2, i3)) == null) {
            int i4 = 1;
            if (i2 != 0 && i3 != 0) {
                int min = Math.min(r().width() / i2, r().height() / i3);
                while (true) {
                    int i5 = i4 * 2;
                    if (i5 > min) {
                        break;
                    }
                    i4 = i5;
                }
            }
            return i4;
        }
        return invokeII.intValue;
    }
}
