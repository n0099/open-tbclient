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
import com.baidu.tieba.b23;
import com.baidu.tieba.ew2;
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
/* loaded from: classes7.dex */
public class p13 extends HandlerThread implements o13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public r13 a;
        public Deque<r13> b;
        public boolean c;
        public b23 d;
        public int e;
        public HashMap<String, Integer> f;
        public c23 g;
        public final /* synthetic */ p13 h;

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.p13$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0427a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.baidu.tieba.p13$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public class RunnableC0428a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0428a(RunnableC0427a runnableC0427a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0427a, swanAppActivity};
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
                            if (p13.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0427a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
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
                        bp3.a0(new RunnableC0428a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            t13.c(this.c.a.a, 33, false, this.c.a.b.size());
                            ib2.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            ib2.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d >= 0.5d && q13.g()) {
                            ib2.a("exit_whiteScreen_L3");
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (activity = uw2.T().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed() && this.a.a != null) {
                    bo3.f().execute(new RunnableC0427a(this, yo3.p(), activity), "SwanPageMonitorRecheck");
                }
            }
        }

        /* renamed from: com.baidu.tieba.p13$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0426a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ r13 a;
            public final /* synthetic */ a b;

            public RunnableC0426a(a aVar, r13 r13Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, r13Var};
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
                this.a = r13Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = yo3.p();
                    if (p != null) {
                        r13 r13Var = this.a;
                        Message.obtain(this.b, 8, new z13(r13Var.a, p, r13Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(p13 p13Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p13Var, looper};
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
            this.h = p13Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = b23.a.a("simple_parser");
            this.g = (c23) b23.a.a("hsv_parser");
        }

        public final void g(r13 r13Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, r13Var) == null) && r13Var != null && i(r13Var.a)) {
                bp3.e0(new RunnableC0426a(this, r13Var));
            }
        }

        public final boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                r13 r13Var = this.a;
                if (r13Var != null && str != null && TextUtils.equals(str, r13Var.a)) {
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
                r13 r13Var = this.a;
                if (r13Var != null && r13Var.i) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (p13.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                bp3.a0(new b(this));
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
                if (p13.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (vh3.d) {
                            q((y13) message.obj);
                            return;
                        } else {
                            p((y13) message.obj);
                            return;
                        }
                    case 2:
                        g((r13) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((x13) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        w13 w13Var = (w13) message.obj;
                        if (w13Var != null) {
                            if (w13Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((a23) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((z13) message.obj);
                        return;
                    case 9:
                        o((y13) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((y13) message.obj);
                        return;
                    case 13:
                        q((y13) message.obj);
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
                r13 r13Var = this.a;
                if (r13Var != null && !r13Var.c()) {
                    if (this.h.a != null) {
                        this.h.a.removeMessages(2);
                    }
                    this.a.d();
                    if (p13.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = vj3.a().getString("screenshot_upload_switch", "1");
                if (p13.b) {
                    Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
                }
                if (!TextUtils.equals(string, "1") || new Random().nextInt(10) % 3 != 0) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void k(y13 y13Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, y13Var) == null) {
                this.h.a.removeMessages(2);
                r13 r13Var = this.a;
                if (r13Var != null) {
                    str = r13Var.a;
                } else {
                    str = StringUtil.NULL_STRING;
                }
                if (p13.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + y13Var.a());
                }
            }
        }

        public final void o(@NonNull y13 y13Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, y13Var) == null) && y13Var.c() >= 0) {
                qa2 U = uw2.T().U();
                if (U != null && U.k() > 0) {
                    return;
                }
                if (p13.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + y13Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, y13Var), y13Var.c());
            }
        }

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && h()) {
                s13.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                uw2.T().u(ih3.a(new ih3()));
                uw2.T().m(str, ih3.a(new ih3()));
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                r13 r13Var = this.a;
                if (r13Var != null && r13Var.c() && this.a.c && h()) {
                    s13.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    s13.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    jb2.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                r13 r13Var = this.a;
                if (r13Var != null && r13Var.i && !r13Var.c()) {
                    this.a.e();
                    long b2 = this.a.b();
                    if (b2 >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                    }
                    if (p13.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            boolean z;
            ew2.a W;
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (activity = uw2.T().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                jq3 T2 = activity.T();
                if (T2 != null && (view2 = T2.a) != null && view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (p13.b) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (!z) {
                    return;
                }
                an3 an3Var = new an3();
                an3Var.k(5L);
                an3Var.i(19L);
                an3Var.f("loading=true");
                hb3 b0 = hb3.b0();
                if (b0 == null) {
                    W = null;
                } else {
                    W = b0.W();
                }
                ii3 ii3Var = new ii3();
                ii3Var.p(an3Var);
                ii3Var.r(W);
                ii3Var.q(ai3.n(gb3.K().k()));
                ii3Var.m(gb3.K().getAppId());
                ii3Var.s(String.valueOf(this.b.size()));
                ii3Var.n(false);
                ai3.R(ii3Var);
            }
        }

        public final void p(y13 y13Var) {
            pa2 f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, y13Var) == null) && (f = q13.f()) != null) {
                String v3 = f.v3();
                nx1 q3 = f.q3();
                if (p13.b && q3 == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + v3);
                }
                if (q3 != null && !i(v3)) {
                    r13 r13Var = new r13(v3, f.o3().a, y13Var.c(), y13Var.a());
                    this.b.addLast(r13Var);
                    this.a = r13Var;
                    q3.s(v13.e());
                    HashMap<String, Integer> hashMap = this.f;
                    if (hashMap != null && hashMap.containsKey(v3)) {
                        this.a.g = this.f.remove(v3).intValue();
                    }
                    if (!this.c && r13Var.b() >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, r13Var), this.a.b());
                    }
                }
            }
        }

        public final void q(y13 y13Var) {
            pa2 f;
            nx1 q3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048587, this, y13Var) != null) || (f = q13.f()) == null || (q3 = f.q3()) == null) {
                return;
            }
            String v3 = f.v3();
            r13 r13Var = new r13(v3, f.o3().a, y13Var.c(), y13Var.a());
            if (!i(v3)) {
                this.b.addLast(r13Var);
                q3.s(v13.e());
            }
            this.a = r13Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(v3)) {
                this.a.g = this.f.get(v3).intValue();
            }
            if (!this.c && r13Var.b() >= 0) {
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, r13Var), this.a.b());
                if (p13.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + v3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void r(a23 a23Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, a23Var) != null) || a23Var == null) {
                return;
            }
            String d = a23Var.d();
            r13 r13Var = null;
            Iterator<r13> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                r13 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    r13Var = next;
                    break;
                }
            }
            int i = 1;
            if (a23Var.e()) {
                if (r13Var != null) {
                    r13Var.g++;
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
            } else if (r13Var != null) {
                r13Var.g--;
            } else {
                HashMap<String, Integer> hashMap2 = this.f;
                if (hashMap2 != null && (num = hashMap2.get(d)) != null && num.intValue() > 0) {
                    this.f.put(d, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        public final void s(z13 z13Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, z13Var) == null) && z13Var != null && i(z13Var.d())) {
                s13.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = z13Var.e();
                pa2 f = q13.f();
                View B = uw2.T().B(z13Var.d());
                if (e != null && B != null && f != null) {
                    Rect b2 = q13.b(e, f, B);
                    this.d.c(q13.d(f));
                    this.a.g();
                    boolean a = z13Var.a();
                    if (!q13.h() && this.e <= 0) {
                        this.a.c = this.d.a(e, b2);
                        if (this.a.c) {
                            s13.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                            if (a) {
                                this.a.f(e);
                                this.a.h = b2;
                            }
                            q13.i(a, z13Var.d());
                            int i = 19;
                            if (vh3.d && !a) {
                                i = 55;
                            }
                            t13.c(this.a, i, a, this.b.size());
                        }
                    } else {
                        s13.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                        this.a.c = false;
                    }
                    this.a.a();
                    if (p13.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + z13Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                    }
                    if (!this.a.c) {
                        double d = this.g.d(e, b2);
                        int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                        if (i2 >= 0) {
                            s13.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                            int i3 = 28;
                            if (vh3.d && !a) {
                                i3 = 56;
                            }
                            t13.d(this.a, i3, w(), e, a, this.b.size());
                        }
                        if (a) {
                            hc2 hc2Var = new hc2();
                            if (q13.g()) {
                                if (i2 >= 0) {
                                    hc2Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                                    hc2Var.d(z13Var.d());
                                    this.a.c = true;
                                    s13.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                                }
                            } else if (this.e == 0 && d >= 0.7d) {
                                hc2Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                                hc2Var.d(z13Var.d());
                                this.a.c = true;
                                s13.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                            } else {
                                wb2.b().a();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948009143, "Lcom/baidu/tieba/p13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948009143, "Lcom/baidu/tieba/p13;");
                return;
            }
        }
        b = hb3.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p13() {
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

    @Override // com.baidu.tieba.o13
    public void a(y13 y13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, y13Var) == null) {
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
            if (y13Var != null) {
                Message.obtain(this.a, y13Var.b(), y13Var).sendToTarget();
            }
        }
    }
}
