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
import com.baidu.tieba.cp2;
import com.baidu.tieba.zu2;
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
/* loaded from: classes5.dex */
public class nu2 extends HandlerThread implements mu2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public pu2 a;
        public Deque<pu2> b;
        public boolean c;
        public zu2 d;
        public int e;
        public HashMap<String, Integer> f;
        public av2 g;
        public final /* synthetic */ nu2 h;

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.nu2$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC0366a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.baidu.tieba.nu2$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes5.dex */
                public class RunnableC0367a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0367a(RunnableC0366a runnableC0366a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0366a, swanAppActivity};
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
                            if (nu2.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0366a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
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
                        zh3.a0(new RunnableC0367a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            ru2.c(this.c.a.a, 33, false, this.c.a.b.size());
                            g42.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            g42.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d >= 0.5d && ou2.g()) {
                            g42.a("exit_whiteScreen_L3");
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (activity = sp2.U().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed() && this.a.a != null) {
                    zg3.f().execute(new RunnableC0366a(this, wh3.p(), activity), "SwanPageMonitorRecheck");
                }
            }
        }

        /* renamed from: com.baidu.tieba.nu2$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0365a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ pu2 a;
            public final /* synthetic */ a b;

            public RunnableC0365a(a aVar, pu2 pu2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, pu2Var};
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
                this.a = pu2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = wh3.p();
                    if (p != null) {
                        pu2 pu2Var = this.a;
                        Message.obtain(this.b, 8, new xu2(pu2Var.a, p, pu2Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(nu2 nu2Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu2Var, looper};
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
            this.h = nu2Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = zu2.a.a("simple_parser");
            this.g = (av2) zu2.a.a("hsv_parser");
        }

        public final void g(pu2 pu2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, pu2Var) == null) && pu2Var != null && i(pu2Var.a)) {
                zh3.e0(new RunnableC0365a(this, pu2Var));
            }
        }

        public final boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                pu2 pu2Var = this.a;
                if (pu2Var != null && str != null && TextUtils.equals(str, pu2Var.a)) {
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
                pu2 pu2Var = this.a;
                if (pu2Var != null && pu2Var.i) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (nu2.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                zh3.a0(new b(this));
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
                if (nu2.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (ta3.d) {
                            q((wu2) message.obj);
                            return;
                        } else {
                            p((wu2) message.obj);
                            return;
                        }
                    case 2:
                        g((pu2) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((vu2) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        uu2 uu2Var = (uu2) message.obj;
                        if (uu2Var != null) {
                            if (uu2Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((yu2) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((xu2) message.obj);
                        return;
                    case 9:
                        o((wu2) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((wu2) message.obj);
                        return;
                    case 13:
                        q((wu2) message.obj);
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
                pu2 pu2Var = this.a;
                if (pu2Var != null && !pu2Var.c()) {
                    if (this.h.a != null) {
                        this.h.a.removeMessages(2);
                    }
                    this.a.d();
                    if (nu2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = tc3.a().getString("screenshot_upload_switch", "1");
                if (nu2.b) {
                    Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
                }
                if (!TextUtils.equals(string, "1") || new Random().nextInt(10) % 3 != 0) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void k(wu2 wu2Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, wu2Var) == null) {
                this.h.a.removeMessages(2);
                pu2 pu2Var = this.a;
                if (pu2Var != null) {
                    str = pu2Var.a;
                } else {
                    str = StringUtil.NULL_STRING;
                }
                if (nu2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + wu2Var.a());
                }
            }
        }

        public final void o(@NonNull wu2 wu2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, wu2Var) == null) && wu2Var.c() >= 0) {
                o32 V = sp2.U().V();
                if (V != null && V.k() > 0) {
                    return;
                }
                if (nu2.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + wu2Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, wu2Var), wu2Var.c());
            }
        }

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && h()) {
                qu2.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                sp2.U().u(ga3.a(new ga3()));
                sp2.U().m(str, ga3.a(new ga3()));
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                pu2 pu2Var = this.a;
                if (pu2Var != null && pu2Var.c() && this.a.c && h()) {
                    qu2.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    qu2.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    h42.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                pu2 pu2Var = this.a;
                if (pu2Var != null && pu2Var.i && !pu2Var.c()) {
                    this.a.e();
                    long b2 = this.a.b();
                    if (b2 >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                    }
                    if (nu2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            boolean z;
            cp2.a W;
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (activity = sp2.U().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                hj3 T = activity.T();
                if (T != null && (view2 = T.a) != null && view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (nu2.b) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (!z) {
                    return;
                }
                yf3 yf3Var = new yf3();
                yf3Var.k(5L);
                yf3Var.i(19L);
                yf3Var.f("loading=true");
                f43 b0 = f43.b0();
                if (b0 == null) {
                    W = null;
                } else {
                    W = b0.W();
                }
                gb3 gb3Var = new gb3();
                gb3Var.p(yf3Var);
                gb3Var.r(W);
                gb3Var.q(ya3.n(e43.K().k()));
                gb3Var.m(e43.K().getAppId());
                gb3Var.s(String.valueOf(this.b.size()));
                gb3Var.n(false);
                ya3.R(gb3Var);
            }
        }

        public final void p(wu2 wu2Var) {
            n32 f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, wu2Var) == null) && (f = ou2.f()) != null) {
                String t3 = f.t3();
                lq1 o3 = f.o3();
                if (nu2.b && o3 == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + t3);
                }
                if (o3 != null && !i(t3)) {
                    pu2 pu2Var = new pu2(t3, f.m3().a, wu2Var.c(), wu2Var.a());
                    this.b.addLast(pu2Var);
                    this.a = pu2Var;
                    o3.t(tu2.e());
                    HashMap<String, Integer> hashMap = this.f;
                    if (hashMap != null && hashMap.containsKey(t3)) {
                        this.a.g = this.f.remove(t3).intValue();
                    }
                    if (!this.c && pu2Var.b() >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, pu2Var), this.a.b());
                    }
                }
            }
        }

        public final void q(wu2 wu2Var) {
            n32 f;
            lq1 o3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048587, this, wu2Var) != null) || (f = ou2.f()) == null || (o3 = f.o3()) == null) {
                return;
            }
            String t3 = f.t3();
            pu2 pu2Var = new pu2(t3, f.m3().a, wu2Var.c(), wu2Var.a());
            if (!i(t3)) {
                this.b.addLast(pu2Var);
                o3.t(tu2.e());
            }
            this.a = pu2Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(t3)) {
                this.a.g = this.f.get(t3).intValue();
            }
            if (!this.c && pu2Var.b() >= 0) {
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, pu2Var), this.a.b());
                if (nu2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + t3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void r(yu2 yu2Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, yu2Var) != null) || yu2Var == null) {
                return;
            }
            String d = yu2Var.d();
            pu2 pu2Var = null;
            Iterator<pu2> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                pu2 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    pu2Var = next;
                    break;
                }
            }
            int i = 1;
            if (yu2Var.e()) {
                if (pu2Var != null) {
                    pu2Var.g++;
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
            } else if (pu2Var != null) {
                pu2Var.g--;
            } else {
                HashMap<String, Integer> hashMap2 = this.f;
                if (hashMap2 != null && (num = hashMap2.get(d)) != null && num.intValue() > 0) {
                    this.f.put(d, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        public final void s(xu2 xu2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, xu2Var) == null) && xu2Var != null && i(xu2Var.d())) {
                qu2.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = xu2Var.e();
                n32 f = ou2.f();
                View B = sp2.U().B(xu2Var.d());
                if (e != null && B != null && f != null) {
                    Rect b2 = ou2.b(e, f, B);
                    this.d.c(ou2.d(f));
                    this.a.g();
                    boolean a = xu2Var.a();
                    if (!ou2.h() && this.e <= 0) {
                        this.a.c = this.d.a(e, b2);
                        if (this.a.c) {
                            qu2.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                            if (a) {
                                this.a.f(e);
                                this.a.h = b2;
                            }
                            ou2.i(a, xu2Var.d());
                            int i = 19;
                            if (ta3.d && !a) {
                                i = 55;
                            }
                            ru2.c(this.a, i, a, this.b.size());
                        }
                    } else {
                        qu2.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                        this.a.c = false;
                    }
                    this.a.a();
                    if (nu2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + xu2Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                    }
                    if (!this.a.c) {
                        double d = this.g.d(e, b2);
                        int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                        if (i2 >= 0) {
                            qu2.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                            int i3 = 28;
                            if (ta3.d && !a) {
                                i3 = 56;
                            }
                            ru2.d(this.a, i3, w(), e, a, this.b.size());
                        }
                        if (a) {
                            f52 f52Var = new f52();
                            if (ou2.g()) {
                                if (i2 >= 0) {
                                    f52Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                                    f52Var.d(xu2Var.d());
                                    this.a.c = true;
                                    qu2.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                                }
                            } else if (this.e == 0 && d >= 0.7d) {
                                f52Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                                f52Var.d(xu2Var.d());
                                this.a.c = true;
                                qu2.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                            } else {
                                u42.b().a();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948014878, "Lcom/baidu/tieba/nu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948014878, "Lcom/baidu/tieba/nu2;");
                return;
            }
        }
        b = f43.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nu2() {
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

    @Override // com.baidu.tieba.mu2
    public void a(wu2 wu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wu2Var) == null) {
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
            if (wu2Var != null) {
                Message.obtain(this.a, wu2Var.b(), wu2Var).sendToTarget();
            }
        }
    }
}
