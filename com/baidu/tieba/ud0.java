package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class ud0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String u = "ud0";
    public static volatile int v;
    public static volatile boolean w;
    public static volatile ud0 x;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Context b;
    public boolean c;
    public HandlerThread d;
    public volatile boolean e;
    public boolean f;
    public long g;
    public be0 h;
    public vd0 i;
    public d j;
    public ce0 k;
    public de0 l;
    public wd0 m;
    public ae0 n;
    public volatile boolean o;
    public xd0 p;
    public ae0 q;
    public volatile boolean r;
    public ArrayList<od0> s;
    public int t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948207016, "Lcom/baidu/tieba/ud0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948207016, "Lcom/baidu/tieba/ud0;");
        }
    }

    /* loaded from: classes6.dex */
    public class a implements ae0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ud0 a;

        @Override // com.baidu.tieba.ae0
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }

        public a(ud0 ud0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ud0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ud0Var;
        }

        @Override // com.baidu.tieba.ae0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.p.v();
                this.a.p = null;
                this.a.q = null;
                this.a.v(2, z);
            }
        }

        @Override // com.baidu.tieba.ae0
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                this.a.p.x();
            }
        }

        @Override // com.baidu.tieba.ae0
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048579, this, z) != null) {
                return;
            }
            this.a.r = z;
            this.a.u(2, z);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ae0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ud0 a;

        public b(ud0 ud0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ud0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ud0Var;
        }

        @Override // com.baidu.tieba.ae0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.m.p();
                this.a.m = null;
                this.a.n = null;
                this.a.v(4, z);
            }
        }

        @Override // com.baidu.tieba.ae0
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                this.a.m.r();
            }
        }

        @Override // com.baidu.tieba.ae0
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) {
                return;
            }
            boolean unused = ud0.w = z;
        }

        @Override // com.baidu.tieba.ae0
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048579, this, z) != null) {
                return;
            }
            this.a.o = z;
            this.a.u(4, z);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements de0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ud0 a;

        public c(ud0 ud0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ud0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ud0Var;
        }

        @Override // com.baidu.tieba.de0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.u(1, z);
        }

        @Override // com.baidu.tieba.de0
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.a.k.d();
                    this.a.k = null;
                }
                this.a.l = null;
                this.a.v(1, z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ud0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ud0 ud0Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ud0Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ud0Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                        if (this.a.i != null) {
                            this.a.i.onRecorderStart(((Boolean) message.obj).booleanValue());
                        }
                        this.a.e = false;
                        break;
                    case 7002:
                        if (this.a.i != null) {
                            this.a.i.a(((Integer) message.obj).intValue());
                            break;
                        }
                        break;
                    case 7003:
                        if (this.a.i != null) {
                            String str = null;
                            if (this.a.h != null) {
                                str = this.a.h.f();
                            }
                            this.a.i.onRecorderComplete(((Boolean) message.obj).booleanValue(), str);
                            break;
                        }
                        break;
                    case 7004:
                        if (this.a.i != null) {
                            this.a.i.onRecorderError(((Integer) message.obj).intValue());
                            break;
                        }
                        break;
                    case 7005:
                        this.a.R();
                        break;
                    case 7006:
                        this.a.e = false;
                        this.a.U();
                        break;
                }
                super.handleMessage(message);
            }
        }
    }

    public ud0() {
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
        this.a = 0;
        this.c = false;
        this.e = false;
        this.f = false;
        this.g = 0L;
        this.o = false;
        this.r = false;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ArrayList<od0> arrayList = this.s;
            if (arrayList != null) {
                arrayList.clear();
                this.s = null;
            }
            this.b = null;
            this.h = null;
            N(0);
            K();
            d dVar = this.j;
            if (dVar != null) {
                dVar.removeCallbacksAndMessages(null);
                this.j = null;
            }
            HandlerThread handlerThread = this.d;
            if (handlerThread != null) {
                handlerThread.quit();
                this.d = null;
            }
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            String str = u;
            Log.i(str, "restartRecorder mRestartTried = " + this.f);
            d dVar = this.j;
            if (dVar != null) {
                this.f = true;
                dVar.sendMessageDelayed(dVar.obtainMessage(7005), 500L);
            }
        }
    }

    public final void Z() {
        ArrayList<od0> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || (arrayList = this.s) == null) {
            return;
        }
        Iterator<od0> it = arrayList.iterator();
        while (it.hasNext()) {
            md0 c2 = it.next().c();
            if (c2.d() == MirrorType.NO_MIRROR) {
                c2.i(-this.t);
            } else {
                c2.i(this.t);
            }
        }
    }

    public static void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            x = null;
        }
    }

    public static ud0 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            if (x == null) {
                synchronized (ud0.class) {
                    if (x == null) {
                        x = new ud0();
                    }
                }
            }
            return x;
        }
        return (ud0) invokeV.objValue;
    }

    public final synchronized boolean C() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (v == 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            be0 be0Var = this.h;
            if (be0Var == null) {
                return false;
            }
            if (be0Var.o()) {
                if (this.a == 3) {
                    return true;
                }
            } else if (this.a == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void I() {
        xd0 xd0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (xd0Var = this.p) != null) {
            xd0Var.u();
        }
    }

    public final void P() {
        wd0 wd0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (wd0Var = this.m) != null) {
            wd0Var.q(this.h, this.k, this.n);
        }
    }

    public final void Q() {
        d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (dVar = this.j) != null) {
            dVar.sendMessageDelayed(dVar.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.FALSE), 500L);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            A();
            z();
            if (J()) {
                P();
                T();
            } else if (!this.f) {
                L();
            } else {
                Q();
            }
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            Y();
            this.p.w(this.s, this.h, this.k, this.q);
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            Z();
        }
    }

    public long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            xd0 xd0Var = this.p;
            if (xd0Var != null) {
                return xd0Var.j();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.q = new a(this);
            this.n = new b(this);
            this.l = new c(this);
        }
    }

    public static void N(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i) == null) {
            v = i;
        }
    }

    public static void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            w = z;
        }
    }

    public void H(long j) {
        xd0 xd0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048583, this, j) == null) && (xd0Var = this.p) != null && xd0Var.t() && this.r && w) {
            this.p.i(j);
        }
    }

    public void V(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.g *= 1000000;
            vd0 vd0Var = this.i;
            if (vd0Var != null) {
                vd0Var.a(j);
            }
        }
    }

    public void W(od0 od0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, od0Var) == null) {
            X(od0Var, true);
        }
    }

    public void s(od0 od0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, od0Var) == null) {
            t(od0Var, true);
        }
    }

    public final void M(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z) {
                v = i | v;
            }
            this.a++;
        }
    }

    public void X(od0 od0Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048596, this, od0Var, z) == null) && this.p != null) {
            t(od0Var, z);
            this.p.z(this.s);
        }
    }

    public final void w(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z) {
                v = i ^ v;
            }
            this.a--;
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.k = new ce0();
            }
            if (this.h.o()) {
                this.m = new wd0();
            } else {
                w = true;
            }
            this.p = new xd0();
            this.a = 0;
            if (!this.c && this.d == null) {
                HandlerThread handlerThread = new HandlerThread(u);
                this.d = handlerThread;
                handlerThread.start();
            }
            d dVar = this.j;
            if (dVar == null) {
                if (this.d != null) {
                    this.j = new d(this, this.d.getLooper());
                } else {
                    this.j = new d(this, this.b.getMainLooper());
                }
            } else {
                dVar.removeCallbacksAndMessages(null);
            }
            this.h.h();
        }
    }

    public final boolean J() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            wd0 wd0Var = this.m;
            if (wd0Var != null && wd0Var.o()) {
                Log.e(u, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
                this.m.s();
                this.m.p();
                z = false;
            } else {
                z = true;
            }
            xd0 xd0Var = this.p;
            if (xd0Var != null && xd0Var.t()) {
                Log.e(u, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
                this.p.y();
                this.p.v();
                z = false;
            }
            be0 be0Var = this.h;
            if (be0Var != null && !this.k.b(be0Var.f(), this.h.g(), this.l)) {
                Log.e(u, "prepareMovieRecorder movieMuxerInit error!!!");
                return false;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void U() {
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            String str = u;
            Log.i(str, "stopRecorder mStarting = " + this.e);
            if (this.e) {
                if (!B() && (dVar = this.j) != null) {
                    dVar.sendMessage(dVar.obtainMessage(7004, 4002));
                }
                Log.d(u, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
                d dVar2 = this.j;
                if (dVar2 != null) {
                    dVar2.sendMessageDelayed(dVar2.obtainMessage(7006), 500L);
                    return;
                }
                return;
            }
            this.o = false;
            this.r = false;
            this.g = 0L;
            wd0 wd0Var = this.m;
            if (wd0Var != null && wd0Var.o()) {
                this.m.s();
            }
            xd0 xd0Var = this.p;
            if (xd0Var != null && xd0Var.t()) {
                this.p.y();
            }
            O(false);
        }
    }

    public final synchronized boolean B() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                String str = u;
                Log.i(str, "isMovieRecordStarted sMovieRecordState = " + v);
                z = true;
                int i = (v ^ 1) ^ 2;
                if (this.h != null) {
                    if (this.h.o()) {
                        i ^= 4;
                    }
                }
                if (i != 0) {
                    z = false;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void F(ByteBuffer byteBuffer, int i, long j) {
        wd0 wd0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{byteBuffer, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.o && (wd0Var = this.m) != null && wd0Var.o()) {
            this.m.g(byteBuffer, i, j);
        }
    }

    public void S(Context context, be0 be0Var, vd0 vd0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, context, be0Var, vd0Var) == null) {
            String str = u;
            Log.i(str, "startRecorder mStarting = " + this.e);
            if (this.e) {
                Q();
                return;
            }
            this.e = true;
            this.b = context;
            this.h = be0Var;
            this.i = vd0Var;
            R();
        }
    }

    public void t(od0 od0Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048600, this, od0Var, z) == null) && od0Var != null && od0Var.f() != null) {
            if (this.s == null) {
                this.s = new ArrayList<>();
            }
            int i = -1;
            for (int i2 = 0; i2 < this.s.size(); i2++) {
                if (this.s.get(i2).d() == od0Var.d()) {
                    i = i2;
                }
            }
            if (i >= 0 && i < this.s.size()) {
                if (this.s.get(i).f() != od0Var.f()) {
                    this.s.remove(i);
                } else {
                    return;
                }
            }
            if (z) {
                this.s.add(od0Var.clone());
            } else {
                this.s.add(od0Var);
            }
            Collections.sort(this.s);
        }
    }

    public final synchronized void u(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                String str = u;
                Log.i(str, "checkMovieRecordStartState condition = " + i + " && state = " + z);
                M(i, z);
                String str2 = u;
                Log.i(str2, "checkMovieRecordStartState sMovieRecordState = " + v);
                if (D()) {
                    this.j.sendMessage(this.j.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(B())));
                }
            }
        }
    }

    public final synchronized void v(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                String str = u;
                Log.i(str, "checkMovieRecordStopState condition = " + i + " && state = " + z);
                w(i, z);
                String str2 = u;
                Log.i(str2, "checkMovieRecordStopState sMovieRecordState = " + v);
                if (E() && this.j != null) {
                    this.j.sendMessage(this.j.obtainMessage(7003, Boolean.valueOf(C())));
                }
            }
        }
    }
}
