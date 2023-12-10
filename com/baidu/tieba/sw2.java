package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.tieba.ex2;
import com.baidu.tieba.hr2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
/* loaded from: classes8.dex */
public class sw2 extends HandlerThread implements rw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public uw2 a;
        public Deque<uw2> b;
        public boolean c;
        public ex2 d;
        public int e;
        public HashMap<String, Integer> f;
        public fx2 g;
        public final /* synthetic */ sw2 h;

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.sw2$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC0476a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.baidu.tieba.sw2$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes8.dex */
                public class RunnableC0477a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0477a(RunnableC0476a runnableC0476a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0476a, swanAppActivity};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = swanAppActivity;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            if (sw2.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0476a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, bitmap, swanAppActivity};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = bVar;
                    this.a = bitmap;
                    this.b = swanAppActivity;
                }

                public final void a(SwanAppActivity swanAppActivity) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, swanAppActivity) == null) {
                        ek3.a0(new RunnableC0477a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            ww2.c(this.c.a.a, 33, false, this.c.a.b.size());
                            l62.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            l62.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d >= 0.5d && tw2.g()) {
                            l62.a("exit_whiteScreen_L3");
                            a(this.b);
                        }
                    }
                }
            }

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (activity = xr2.V().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed() && this.a.a != null) {
                    ej3.f().execute(new RunnableC0476a(this, bk3.p(), activity), "SwanPageMonitorRecheck");
                }
            }
        }

        /* renamed from: com.baidu.tieba.sw2$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0475a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ uw2 a;
            public final /* synthetic */ a b;

            public RunnableC0475a(a aVar, uw2 uw2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, uw2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = uw2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = bk3.p();
                    if (p != null) {
                        uw2 uw2Var = this.a;
                        Message.obtain(this.b, 8, new cx2(uw2Var.a, p, uw2Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sw2 sw2Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sw2Var, looper};
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
            this.h = sw2Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = ex2.a.a("simple_parser");
            this.g = (fx2) ex2.a.a("hsv_parser");
        }

        public final void g(uw2 uw2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, uw2Var) == null) && uw2Var != null && i(uw2Var.a)) {
                ek3.e0(new RunnableC0475a(this, uw2Var));
            }
        }

        public final boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                uw2 uw2Var = this.a;
                if (uw2Var != null && str != null && TextUtils.equals(str, uw2Var.a)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                uw2 uw2Var = this.a;
                if (uw2Var != null && uw2Var.i) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (sw2.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                ek3.a0(new b(this));
            }
        }

        public final void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                this.b.clear();
                HashMap<String, Integer> hashMap = this.f;
                if (hashMap != null) {
                    hashMap.clear();
                }
                this.a = null;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                if (sw2.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (yc3.d) {
                            q((bx2) message.obj);
                            return;
                        } else {
                            p((bx2) message.obj);
                            return;
                        }
                    case 2:
                        g((uw2) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((ax2) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        zw2 zw2Var = (zw2) message.obj;
                        if (zw2Var != null) {
                            if (zw2Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((dx2) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((cx2) message.obj);
                        return;
                    case 9:
                        o((bx2) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((bx2) message.obj);
                        return;
                    case 13:
                        q((bx2) message.obj);
                        return;
                    default:
                        return;
                }
            }
        }

        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.c = true;
                uw2 uw2Var = this.a;
                if (uw2Var != null && !uw2Var.c()) {
                    if (this.h.a != null) {
                        this.h.a.removeMessages(2);
                    }
                    this.a.d();
                    if (sw2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = ye3.a().getString("screenshot_upload_switch", "1");
                if (sw2.b) {
                    Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
                }
                if (!TextUtils.equals(string, "1") || new Random().nextInt(10) % 3 != 0) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void k(bx2 bx2Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, bx2Var) == null) {
                this.h.a.removeMessages(2);
                uw2 uw2Var = this.a;
                if (uw2Var != null) {
                    str = uw2Var.a;
                } else {
                    str = StringUtil.NULL_STRING;
                }
                if (sw2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + bx2Var.a());
                }
            }
        }

        public final void o(@NonNull bx2 bx2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, bx2Var) == null) && bx2Var.c() >= 0) {
                t52 W = xr2.V().W();
                if (W != null && W.k() > 0) {
                    return;
                }
                if (sw2.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + bx2Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, bx2Var), bx2Var.c());
            }
        }

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && h()) {
                vw2.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                xr2.V().v(lc3.a(new lc3()));
                xr2.V().n(str, lc3.a(new lc3()));
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                uw2 uw2Var = this.a;
                if (uw2Var != null && uw2Var.c() && this.a.c && h()) {
                    vw2.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    vw2.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    m62.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                uw2 uw2Var = this.a;
                if (uw2Var != null && uw2Var.i && !uw2Var.c()) {
                    this.a.e();
                    long b2 = this.a.b();
                    if (b2 >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                    }
                    if (sw2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            boolean z;
            hr2.a X;
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (activity = xr2.V().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                ml3 U = activity.U();
                if (U != null && (view2 = U.a) != null && view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (sw2.b) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (!z) {
                    return;
                }
                di3 di3Var = new di3();
                di3Var.k(5L);
                di3Var.i(19L);
                di3Var.f("loading=true");
                k63 c0 = k63.c0();
                if (c0 == null) {
                    X = null;
                } else {
                    X = c0.X();
                }
                ld3 ld3Var = new ld3();
                ld3Var.p(di3Var);
                ld3Var.r(X);
                ld3Var.q(dd3.n(j63.K().k()));
                ld3Var.m(j63.K().getAppId());
                ld3Var.s(String.valueOf(this.b.size()));
                ld3Var.n(false);
                dd3.R(ld3Var);
            }
        }

        public final void p(bx2 bx2Var) {
            s52 f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, bx2Var) == null) && (f = tw2.f()) != null) {
                String A3 = f.A3();
                rs1 v3 = f.v3();
                if (sw2.b && v3 == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + A3);
                }
                if (v3 != null && !i(A3)) {
                    uw2 uw2Var = new uw2(A3, f.t3().a, bx2Var.c(), bx2Var.a());
                    this.b.addLast(uw2Var);
                    this.a = uw2Var;
                    v3.r(yw2.e());
                    HashMap<String, Integer> hashMap = this.f;
                    if (hashMap != null && hashMap.containsKey(A3)) {
                        this.a.g = this.f.remove(A3).intValue();
                    }
                    if (!this.c && uw2Var.b() >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, uw2Var), this.a.b());
                    }
                }
            }
        }

        public final void q(bx2 bx2Var) {
            s52 f;
            rs1 v3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048587, this, bx2Var) != null) || (f = tw2.f()) == null || (v3 = f.v3()) == null) {
                return;
            }
            String A3 = f.A3();
            uw2 uw2Var = new uw2(A3, f.t3().a, bx2Var.c(), bx2Var.a());
            if (!i(A3)) {
                this.b.addLast(uw2Var);
                v3.r(yw2.e());
            }
            this.a = uw2Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(A3)) {
                this.a.g = this.f.get(A3).intValue();
            }
            if (!this.c && uw2Var.b() >= 0) {
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, uw2Var), this.a.b());
                if (sw2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + A3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void r(dx2 dx2Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, dx2Var) != null) || dx2Var == null) {
                return;
            }
            String d = dx2Var.d();
            uw2 uw2Var = null;
            Iterator<uw2> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                uw2 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    uw2Var = next;
                    break;
                }
            }
            int i = 1;
            if (dx2Var.e()) {
                if (uw2Var != null) {
                    uw2Var.g++;
                    return;
                }
                if (this.f == null) {
                    this.f = new HashMap<>();
                }
                Integer num2 = this.f.get(d);
                HashMap<String, Integer> hashMap = this.f;
                if (num2 != null) {
                    i = 1 + num2.intValue();
                }
                hashMap.put(d, Integer.valueOf(i));
            } else if (uw2Var != null) {
                uw2Var.g--;
            } else {
                HashMap<String, Integer> hashMap2 = this.f;
                if (hashMap2 != null && (num = hashMap2.get(d)) != null && num.intValue() > 0) {
                    this.f.put(d, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        public final void s(cx2 cx2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, cx2Var) == null) && cx2Var != null && i(cx2Var.d())) {
                vw2.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = cx2Var.e();
                s52 f = tw2.f();
                View C = xr2.V().C(cx2Var.d());
                if (e != null && C != null && f != null) {
                    Rect b2 = tw2.b(e, f, C);
                    this.d.c(tw2.d(f));
                    this.a.g();
                    boolean a = cx2Var.a();
                    if (!tw2.h() && this.e <= 0) {
                        this.a.c = this.d.a(e, b2);
                        if (this.a.c) {
                            vw2.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                            if (a) {
                                this.a.f(e);
                                this.a.h = b2;
                            }
                            tw2.i(a, cx2Var.d());
                            int i = 19;
                            if (yc3.d && !a) {
                                i = 55;
                            }
                            ww2.c(this.a, i, a, this.b.size());
                        }
                    } else {
                        vw2.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                        this.a.c = false;
                    }
                    this.a.a();
                    if (sw2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + cx2Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                    }
                    if (!this.a.c) {
                        double d = this.g.d(e, b2);
                        int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                        if (i2 >= 0) {
                            vw2.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                            int i3 = 28;
                            if (yc3.d && !a) {
                                i3 = 56;
                            }
                            ww2.d(this.a, i3, w(), e, a, this.b.size());
                        }
                        if (a) {
                            k72 k72Var = new k72();
                            if (tw2.g()) {
                                if (i2 >= 0) {
                                    k72Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                                    k72Var.d(cx2Var.d());
                                    this.a.c = true;
                                    vw2.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                                }
                            } else if (this.e == 0 && d >= 0.7d) {
                                k72Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                                k72Var.d(cx2Var.d());
                                this.a.c = true;
                                vw2.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                            } else {
                                z62.b().a();
                            }
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948165755, "Lcom/baidu/tieba/sw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948165755, "Lcom/baidu/tieba/sw2;");
                return;
            }
        }
        b = k63.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sw2() {
        super("SwanAppPageMonitor");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        d();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            start();
            this.a = new a(this, getLooper());
        }
    }

    @Override // com.baidu.tieba.rw2
    public void a(bx2 bx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bx2Var) == null) {
            if (!isAlive()) {
                if (b) {
                    Log.d("SwanAppPageMonitor", "thread is not alive");
                }
                try {
                    d();
                } catch (Error | Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (bx2Var != null) {
                Message.obtain(this.a, bx2Var.b(), bx2Var).sendToTarget();
            }
        }
    }
}
