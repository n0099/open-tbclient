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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.tieba.gu2;
import com.baidu.tieba.jo2;
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
public class ut2 extends HandlerThread implements tt2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public wt2 a;
        public Deque b;
        public boolean c;
        public gu2 d;
        public int e;
        public HashMap f;
        public hu2 g;
        public final /* synthetic */ ut2 h;

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.ut2$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0425a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.baidu.tieba.ut2$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes6.dex */
                public class RunnableC0426a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0426a(RunnableC0425a runnableC0425a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0425a, swanAppActivity};
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
                            if (ut2.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0425a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
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
                        gh3.a0(new RunnableC0426a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            yt2.c(this.c.a.a, 33, false, this.c.a.b.size());
                            n32.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            n32.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d >= 0.5d && vt2.g()) {
                            n32.a("exit_whiteScreen_L3");
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (activity = zo2.U().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed() && this.a.a != null) {
                    gg3.f().execute(new RunnableC0425a(this, dh3.p(), activity), "SwanPageMonitorRecheck");
                }
            }
        }

        /* renamed from: com.baidu.tieba.ut2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0424a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ wt2 a;
            public final /* synthetic */ a b;

            public RunnableC0424a(a aVar, wt2 wt2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, wt2Var};
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
                this.a = wt2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = dh3.p();
                    if (p != null) {
                        wt2 wt2Var = this.a;
                        Message.obtain(this.b, 8, new eu2(wt2Var.a, p, wt2Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ut2 ut2Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ut2Var, looper};
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
            this.h = ut2Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = gu2.a.a("simple_parser");
            this.g = (hu2) gu2.a.a("hsv_parser");
        }

        public final void g(wt2 wt2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, wt2Var) == null) && wt2Var != null && i(wt2Var.a)) {
                gh3.e0(new RunnableC0424a(this, wt2Var));
            }
        }

        public final boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                wt2 wt2Var = this.a;
                if (wt2Var != null && str != null && TextUtils.equals(str, wt2Var.a)) {
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
                wt2 wt2Var = this.a;
                if (wt2Var != null && wt2Var.i) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (ut2.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                gh3.a0(new b(this));
            }
        }

        public final void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
                this.b.clear();
                HashMap hashMap = this.f;
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
                if (ut2.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (aa3.d) {
                            q((du2) message.obj);
                            return;
                        } else {
                            p((du2) message.obj);
                            return;
                        }
                    case 2:
                        g((wt2) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((cu2) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        bu2 bu2Var = (bu2) message.obj;
                        if (bu2Var != null) {
                            if (bu2Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((fu2) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((eu2) message.obj);
                        return;
                    case 9:
                        o((du2) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((du2) message.obj);
                        return;
                    case 13:
                        q((du2) message.obj);
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
                wt2 wt2Var = this.a;
                if (wt2Var != null && !wt2Var.c()) {
                    if (this.h.a != null) {
                        this.h.a.removeMessages(2);
                    }
                    this.a.d();
                    if (ut2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = ac3.a().getString("screenshot_upload_switch", "1");
                if (ut2.b) {
                    Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
                }
                if (!TextUtils.equals(string, "1") || new Random().nextInt(10) % 3 != 0) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void k(du2 du2Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, du2Var) == null) {
                this.h.a.removeMessages(2);
                wt2 wt2Var = this.a;
                if (wt2Var != null) {
                    str = wt2Var.a;
                } else {
                    str = StringUtil.NULL_STRING;
                }
                if (ut2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + du2Var.a());
                }
            }
        }

        public final void o(du2 du2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, du2Var) == null) && du2Var.c() >= 0) {
                v22 V = zo2.U().V();
                if (V != null && V.k() > 0) {
                    return;
                }
                if (ut2.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + du2Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, du2Var), du2Var.c());
            }
        }

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && h()) {
                xt2.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                zo2.U().u(n93.a(new n93()));
                zo2.U().m(str, n93.a(new n93()));
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                wt2 wt2Var = this.a;
                if (wt2Var != null && wt2Var.c() && this.a.c && h()) {
                    xt2.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    xt2.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    o32.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                wt2 wt2Var = this.a;
                if (wt2Var != null && wt2Var.i && !wt2Var.c()) {
                    this.a.e();
                    long b2 = this.a.b();
                    if (b2 >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                    }
                    if (ut2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            boolean z;
            jo2.a W;
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (activity = zo2.U().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                oi3 T = activity.T();
                if (T != null && (view2 = T.a) != null && view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (ut2.b) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (!z) {
                    return;
                }
                ff3 ff3Var = new ff3();
                ff3Var.k(5L);
                ff3Var.i(19L);
                ff3Var.f("loading=true");
                m33 b0 = m33.b0();
                if (b0 == null) {
                    W = null;
                } else {
                    W = b0.W();
                }
                na3 na3Var = new na3();
                na3Var.p(ff3Var);
                na3Var.r(W);
                na3Var.q(fa3.n(l33.K().k()));
                na3Var.m(l33.K().getAppId());
                na3Var.s(String.valueOf(this.b.size()));
                na3Var.n(false);
                fa3.R(na3Var);
            }
        }

        public final void p(du2 du2Var) {
            u22 f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, du2Var) == null) && (f = vt2.f()) != null) {
                String t3 = f.t3();
                sp1 o3 = f.o3();
                if (ut2.b && o3 == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + t3);
                }
                if (o3 != null && !i(t3)) {
                    wt2 wt2Var = new wt2(t3, f.m3().a, du2Var.c(), du2Var.a());
                    this.b.addLast(wt2Var);
                    this.a = wt2Var;
                    o3.t(au2.e());
                    HashMap hashMap = this.f;
                    if (hashMap != null && hashMap.containsKey(t3)) {
                        this.a.g = ((Integer) this.f.remove(t3)).intValue();
                    }
                    if (!this.c && wt2Var.b() >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, wt2Var), this.a.b());
                    }
                }
            }
        }

        public final void q(du2 du2Var) {
            u22 f;
            sp1 o3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048587, this, du2Var) != null) || (f = vt2.f()) == null || (o3 = f.o3()) == null) {
                return;
            }
            String t3 = f.t3();
            wt2 wt2Var = new wt2(t3, f.m3().a, du2Var.c(), du2Var.a());
            if (!i(t3)) {
                this.b.addLast(wt2Var);
                o3.t(au2.e());
            }
            this.a = wt2Var;
            HashMap hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(t3)) {
                this.a.g = ((Integer) this.f.get(t3)).intValue();
            }
            if (!this.c && wt2Var.b() >= 0) {
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, wt2Var), this.a.b());
                if (ut2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + t3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void r(fu2 fu2Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, fu2Var) != null) || fu2Var == null) {
                return;
            }
            String d = fu2Var.d();
            wt2 wt2Var = null;
            Iterator it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                wt2 wt2Var2 = (wt2) it.next();
                if (TextUtils.equals(wt2Var2.a, d)) {
                    wt2Var = wt2Var2;
                    break;
                }
            }
            int i = 1;
            if (fu2Var.e()) {
                if (wt2Var != null) {
                    wt2Var.g++;
                    return;
                }
                if (this.f == null) {
                    this.f = new HashMap();
                }
                Integer num2 = (Integer) this.f.get(d);
                HashMap hashMap = this.f;
                if (num2 != null) {
                    i = 1 + num2.intValue();
                }
                hashMap.put(d, Integer.valueOf(i));
            } else if (wt2Var != null) {
                wt2Var.g--;
            } else {
                HashMap hashMap2 = this.f;
                if (hashMap2 != null && (num = (Integer) hashMap2.get(d)) != null && num.intValue() > 0) {
                    this.f.put(d, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        public final void s(eu2 eu2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, eu2Var) == null) && eu2Var != null && i(eu2Var.d())) {
                xt2.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = eu2Var.e();
                u22 f = vt2.f();
                View B = zo2.U().B(eu2Var.d());
                if (e != null && B != null && f != null) {
                    Rect b2 = vt2.b(e, f, B);
                    this.d.c(vt2.d(f));
                    this.a.g();
                    boolean a = eu2Var.a();
                    if (!vt2.h() && this.e <= 0) {
                        this.a.c = this.d.a(e, b2);
                        if (this.a.c) {
                            xt2.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                            if (a) {
                                this.a.f(e);
                                this.a.h = b2;
                            }
                            vt2.i(a, eu2Var.d());
                            int i = 19;
                            if (aa3.d && !a) {
                                i = 55;
                            }
                            yt2.c(this.a, i, a, this.b.size());
                        }
                    } else {
                        xt2.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                        this.a.c = false;
                    }
                    this.a.a();
                    if (ut2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + eu2Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                    }
                    if (!this.a.c) {
                        double d = this.g.d(e, b2);
                        int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                        if (i2 >= 0) {
                            xt2.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                            int i3 = 28;
                            if (aa3.d && !a) {
                                i3 = 56;
                            }
                            yt2.d(this.a, i3, w(), e, a, this.b.size());
                        }
                        if (a) {
                            m42 m42Var = new m42();
                            if (vt2.g()) {
                                if (i2 >= 0) {
                                    m42Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                                    m42Var.d(eu2Var.d());
                                    this.a.c = true;
                                    xt2.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                                }
                            } else if (this.e == 0 && d >= 0.7d) {
                                m42Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                                m42Var.d(eu2Var.d());
                                this.a.c = true;
                                xt2.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                            } else {
                                b42.b().a();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948222454, "Lcom/baidu/tieba/ut2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948222454, "Lcom/baidu/tieba/ut2;");
                return;
            }
        }
        b = m33.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ut2() {
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

    @Override // com.baidu.tieba.tt2
    public void a(du2 du2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, du2Var) == null) {
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
            if (du2Var != null) {
                Message.obtain(this.a, du2Var.b(), du2Var).sendToTarget();
            }
        }
    }
}
