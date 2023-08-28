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
import com.baidu.tieba.aw2;
import com.baidu.tieba.x13;
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
/* loaded from: classes6.dex */
public class l13 extends HandlerThread implements k13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public n13 a;
        public Deque<n13> b;
        public boolean c;
        public x13 d;
        public int e;
        public HashMap<String, Integer> f;
        public y13 g;
        public final /* synthetic */ l13 h;

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.l13$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0392a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.baidu.tieba.l13$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes6.dex */
                public class RunnableC0393a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0393a(RunnableC0392a runnableC0392a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0392a, swanAppActivity};
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
                            if (l13.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0392a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
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
                        xo3.a0(new RunnableC0393a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            p13.c(this.c.a.a, 33, false, this.c.a.b.size());
                            eb2.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            eb2.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d >= 0.5d && m13.g()) {
                            eb2.a("exit_whiteScreen_L3");
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (activity = qw2.T().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed() && this.a.a != null) {
                    xn3.f().execute(new RunnableC0392a(this, uo3.p(), activity), "SwanPageMonitorRecheck");
                }
            }
        }

        /* renamed from: com.baidu.tieba.l13$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0391a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n13 a;
            public final /* synthetic */ a b;

            public RunnableC0391a(a aVar, n13 n13Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, n13Var};
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
                this.a = n13Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = uo3.p();
                    if (p != null) {
                        n13 n13Var = this.a;
                        Message.obtain(this.b, 8, new v13(n13Var.a, p, n13Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l13 l13Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l13Var, looper};
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
            this.h = l13Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = x13.a.a("simple_parser");
            this.g = (y13) x13.a.a("hsv_parser");
        }

        public final void g(n13 n13Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, n13Var) == null) && n13Var != null && i(n13Var.a)) {
                xo3.e0(new RunnableC0391a(this, n13Var));
            }
        }

        public final boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                n13 n13Var = this.a;
                if (n13Var != null && str != null && TextUtils.equals(str, n13Var.a)) {
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
                n13 n13Var = this.a;
                if (n13Var != null && n13Var.i) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (l13.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                xo3.a0(new b(this));
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
                if (l13.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (rh3.d) {
                            q((u13) message.obj);
                            return;
                        } else {
                            p((u13) message.obj);
                            return;
                        }
                    case 2:
                        g((n13) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((t13) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        s13 s13Var = (s13) message.obj;
                        if (s13Var != null) {
                            if (s13Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((w13) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((v13) message.obj);
                        return;
                    case 9:
                        o((u13) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((u13) message.obj);
                        return;
                    case 13:
                        q((u13) message.obj);
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
                n13 n13Var = this.a;
                if (n13Var != null && !n13Var.c()) {
                    if (this.h.a != null) {
                        this.h.a.removeMessages(2);
                    }
                    this.a.d();
                    if (l13.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = rj3.a().getString("screenshot_upload_switch", "1");
                if (l13.b) {
                    Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
                }
                if (!TextUtils.equals(string, "1") || new Random().nextInt(10) % 3 != 0) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void k(u13 u13Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, u13Var) == null) {
                this.h.a.removeMessages(2);
                n13 n13Var = this.a;
                if (n13Var != null) {
                    str = n13Var.a;
                } else {
                    str = StringUtil.NULL_STRING;
                }
                if (l13.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + u13Var.a());
                }
            }
        }

        public final void o(@NonNull u13 u13Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, u13Var) == null) && u13Var.c() >= 0) {
                ma2 U = qw2.T().U();
                if (U != null && U.k() > 0) {
                    return;
                }
                if (l13.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + u13Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, u13Var), u13Var.c());
            }
        }

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && h()) {
                o13.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                qw2.T().u(eh3.a(new eh3()));
                qw2.T().m(str, eh3.a(new eh3()));
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                n13 n13Var = this.a;
                if (n13Var != null && n13Var.c() && this.a.c && h()) {
                    o13.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    o13.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    fb2.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                n13 n13Var = this.a;
                if (n13Var != null && n13Var.i && !n13Var.c()) {
                    this.a.e();
                    long b2 = this.a.b();
                    if (b2 >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                    }
                    if (l13.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            boolean z;
            aw2.a W;
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (activity = qw2.T().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                fq3 T2 = activity.T();
                if (T2 != null && (view2 = T2.a) != null && view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (l13.b) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (!z) {
                    return;
                }
                wm3 wm3Var = new wm3();
                wm3Var.k(5L);
                wm3Var.i(19L);
                wm3Var.f("loading=true");
                db3 b0 = db3.b0();
                if (b0 == null) {
                    W = null;
                } else {
                    W = b0.W();
                }
                ei3 ei3Var = new ei3();
                ei3Var.p(wm3Var);
                ei3Var.r(W);
                ei3Var.q(wh3.n(cb3.K().k()));
                ei3Var.m(cb3.K().getAppId());
                ei3Var.s(String.valueOf(this.b.size()));
                ei3Var.n(false);
                wh3.R(ei3Var);
            }
        }

        public final void p(u13 u13Var) {
            la2 f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, u13Var) == null) && (f = m13.f()) != null) {
                String v3 = f.v3();
                jx1 q3 = f.q3();
                if (l13.b && q3 == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + v3);
                }
                if (q3 != null && !i(v3)) {
                    n13 n13Var = new n13(v3, f.o3().a, u13Var.c(), u13Var.a());
                    this.b.addLast(n13Var);
                    this.a = n13Var;
                    q3.s(r13.e());
                    HashMap<String, Integer> hashMap = this.f;
                    if (hashMap != null && hashMap.containsKey(v3)) {
                        this.a.g = this.f.remove(v3).intValue();
                    }
                    if (!this.c && n13Var.b() >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, n13Var), this.a.b());
                    }
                }
            }
        }

        public final void q(u13 u13Var) {
            la2 f;
            jx1 q3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048587, this, u13Var) != null) || (f = m13.f()) == null || (q3 = f.q3()) == null) {
                return;
            }
            String v3 = f.v3();
            n13 n13Var = new n13(v3, f.o3().a, u13Var.c(), u13Var.a());
            if (!i(v3)) {
                this.b.addLast(n13Var);
                q3.s(r13.e());
            }
            this.a = n13Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(v3)) {
                this.a.g = this.f.get(v3).intValue();
            }
            if (!this.c && n13Var.b() >= 0) {
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, n13Var), this.a.b());
                if (l13.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + v3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void r(w13 w13Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, w13Var) != null) || w13Var == null) {
                return;
            }
            String d = w13Var.d();
            n13 n13Var = null;
            Iterator<n13> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n13 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    n13Var = next;
                    break;
                }
            }
            int i = 1;
            if (w13Var.e()) {
                if (n13Var != null) {
                    n13Var.g++;
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
            } else if (n13Var != null) {
                n13Var.g--;
            } else {
                HashMap<String, Integer> hashMap2 = this.f;
                if (hashMap2 != null && (num = hashMap2.get(d)) != null && num.intValue() > 0) {
                    this.f.put(d, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        public final void s(v13 v13Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, v13Var) == null) && v13Var != null && i(v13Var.d())) {
                o13.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = v13Var.e();
                la2 f = m13.f();
                View B = qw2.T().B(v13Var.d());
                if (e != null && B != null && f != null) {
                    Rect b2 = m13.b(e, f, B);
                    this.d.c(m13.d(f));
                    this.a.g();
                    boolean a = v13Var.a();
                    if (!m13.h() && this.e <= 0) {
                        this.a.c = this.d.a(e, b2);
                        if (this.a.c) {
                            o13.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                            if (a) {
                                this.a.f(e);
                                this.a.h = b2;
                            }
                            m13.i(a, v13Var.d());
                            int i = 19;
                            if (rh3.d && !a) {
                                i = 55;
                            }
                            p13.c(this.a, i, a, this.b.size());
                        }
                    } else {
                        o13.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                        this.a.c = false;
                    }
                    this.a.a();
                    if (l13.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + v13Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                    }
                    if (!this.a.c) {
                        double d = this.g.d(e, b2);
                        int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                        if (i2 >= 0) {
                            o13.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                            int i3 = 28;
                            if (rh3.d && !a) {
                                i3 = 56;
                            }
                            p13.d(this.a, i3, w(), e, a, this.b.size());
                        }
                        if (a) {
                            dc2 dc2Var = new dc2();
                            if (m13.g()) {
                                if (i2 >= 0) {
                                    dc2Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                                    dc2Var.d(v13Var.d());
                                    this.a.c = true;
                                    o13.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                                }
                            } else if (this.e == 0 && d >= 0.7d) {
                                dc2Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                                dc2Var.d(v13Var.d());
                                this.a.c = true;
                                o13.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                            } else {
                                sb2.b().a();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947889979, "Lcom/baidu/tieba/l13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947889979, "Lcom/baidu/tieba/l13;");
                return;
            }
        }
        b = db3.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l13() {
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

    @Override // com.baidu.tieba.k13
    public void a(u13 u13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, u13Var) == null) {
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
            if (u13Var != null) {
                Message.obtain(this.a, u13Var.b(), u13Var).sendToTarget();
            }
        }
    }
}
