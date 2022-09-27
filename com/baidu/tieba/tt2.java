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
import com.baidu.tieba.fu2;
import com.baidu.tieba.io2;
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
public class tt2 extends HandlerThread implements st2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public vt2 a;
        public Deque<vt2> b;
        public boolean c;
        public fu2 d;
        public int e;
        public HashMap<String, Integer> f;
        public gu2 g;
        public final /* synthetic */ tt2 h;

        /* renamed from: com.baidu.tieba.tt2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0430a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ vt2 a;
            public final /* synthetic */ a b;

            public RunnableC0430a(a aVar, vt2 vt2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, vt2Var};
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
                this.a = vt2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = ch3.p();
                    if (p != null) {
                        vt2 vt2Var = this.a;
                        Message.obtain(this.b, 8, new du2(vt2Var.a, p, vt2Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.tt2$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0431a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.baidu.tieba.tt2$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes6.dex */
                public class RunnableC0432a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0432a(RunnableC0431a runnableC0431a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0431a, swanAppActivity};
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
                            if (tt2.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0431a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
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
                        fh3.a0(new RunnableC0432a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            xt2.c(this.c.a.a, 33, false, this.c.a.b.size());
                            m32.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            m32.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d < 0.5d || !ut2.g()) {
                        } else {
                            m32.a("exit_whiteScreen_L3");
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = yo2.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || this.a.a == null) {
                    return;
                }
                fg3.f().execute(new RunnableC0431a(this, ch3.p(), activity), "SwanPageMonitorRecheck");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(tt2 tt2Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tt2Var, looper};
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
            this.h = tt2Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = fu2.a.a("simple_parser");
            this.g = (gu2) fu2.a.a("hsv_parser");
        }

        public final void g(vt2 vt2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, vt2Var) == null) && vt2Var != null && i(vt2Var.a)) {
                fh3.e0(new RunnableC0430a(this, vt2Var));
            }
        }

        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                vt2 vt2Var = this.a;
                return vt2Var != null && vt2Var.i;
            }
            return invokeV.booleanValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                if (tt2.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (z93.d) {
                            q((cu2) message.obj);
                            return;
                        } else {
                            p((cu2) message.obj);
                            return;
                        }
                    case 2:
                        g((vt2) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((bu2) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        au2 au2Var = (au2) message.obj;
                        if (au2Var != null) {
                            if (au2Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((eu2) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((du2) message.obj);
                        return;
                    case 9:
                        o((cu2) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((cu2) message.obj);
                        return;
                    case 13:
                        q((cu2) message.obj);
                        return;
                    default:
                        return;
                }
            }
        }

        public final boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                vt2 vt2Var = this.a;
                return (vt2Var == null || str == null || !TextUtils.equals(str, vt2Var.a)) ? false : true;
            }
            return invokeL.booleanValue;
        }

        public final void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.c = true;
                vt2 vt2Var = this.a;
                if (vt2Var == null || vt2Var.c()) {
                    return;
                }
                if (this.h.a != null) {
                    this.h.a.removeMessages(2);
                }
                this.a.d();
                if (tt2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void k(cu2 cu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cu2Var) == null) {
                this.h.a.removeMessages(2);
                vt2 vt2Var = this.a;
                String str = vt2Var != null ? vt2Var.a : StringUtil.NULL_STRING;
                if (tt2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + cu2Var.a());
                }
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                vt2 vt2Var = this.a;
                if (vt2Var != null && vt2Var.c() && this.a.c && h()) {
                    wt2.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    wt2.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    n32.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                vt2 vt2Var = this.a;
                if (vt2Var == null || !vt2Var.i || vt2Var.c()) {
                    return;
                }
                this.a.e();
                long b2 = this.a.b();
                if (b2 >= 0) {
                    this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                }
                if (tt2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (activity = yo2.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            ni3 T = activity.T();
            boolean z = (T == null || (view2 = T.a) == null || view2.getVisibility() != 0) ? false : true;
            if (tt2.b) {
                Log.d("SwanAppPageMonitor", "Loading check result: " + z);
            }
            if (z) {
                ef3 ef3Var = new ef3();
                ef3Var.k(5L);
                ef3Var.i(19L);
                ef3Var.f("loading=true");
                l33 b0 = l33.b0();
                io2.a W = b0 == null ? null : b0.W();
                ma3 ma3Var = new ma3();
                ma3Var.p(ef3Var);
                ma3Var.r(W);
                ma3Var.q(ea3.n(k33.K().k()));
                ma3Var.m(k33.K().getAppId());
                ma3Var.s(String.valueOf(this.b.size()));
                ma3Var.n(false);
                ea3.R(ma3Var);
            }
        }

        public final void o(@NonNull cu2 cu2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, cu2Var) == null) || cu2Var.c() < 0) {
                return;
            }
            u22 V = yo2.U().V();
            if (V == null || V.k() <= 0) {
                if (tt2.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + cu2Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, cu2Var), cu2Var.c());
            }
        }

        public final void p(cu2 cu2Var) {
            t22 f;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, cu2Var) == null) || (f = ut2.f()) == null) {
                return;
            }
            String t3 = f.t3();
            rp1 o3 = f.o3();
            if (tt2.b && o3 == null) {
                Log.d("SwanAppPageMonitor", "webview manager is null for id " + t3);
            }
            if (o3 == null || i(t3)) {
                return;
            }
            vt2 vt2Var = new vt2(t3, f.m3().a, cu2Var.c(), cu2Var.a());
            this.b.addLast(vt2Var);
            this.a = vt2Var;
            o3.t(zt2.e());
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(t3)) {
                this.a.g = this.f.remove(t3).intValue();
            }
            if (this.c || vt2Var.b() < 0) {
                return;
            }
            this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, vt2Var), this.a.b());
        }

        public final void q(cu2 cu2Var) {
            t22 f;
            rp1 o3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, cu2Var) == null) || (f = ut2.f()) == null || (o3 = f.o3()) == null) {
                return;
            }
            String t3 = f.t3();
            vt2 vt2Var = new vt2(t3, f.m3().a, cu2Var.c(), cu2Var.a());
            if (!i(t3)) {
                this.b.addLast(vt2Var);
                o3.t(zt2.e());
            }
            this.a = vt2Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(t3)) {
                this.a.g = this.f.get(t3).intValue();
            }
            if (this.c || vt2Var.b() < 0) {
                return;
            }
            this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, vt2Var), this.a.b());
            if (tt2.b) {
                Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + t3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
            }
        }

        public final void r(eu2 eu2Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048588, this, eu2Var) == null) || eu2Var == null) {
                return;
            }
            String d = eu2Var.d();
            vt2 vt2Var = null;
            Iterator<vt2> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                vt2 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    vt2Var = next;
                    break;
                }
            }
            if (eu2Var.e()) {
                if (vt2Var != null) {
                    vt2Var.g++;
                    return;
                }
                if (this.f == null) {
                    this.f = new HashMap<>();
                }
                Integer num2 = this.f.get(d);
                this.f.put(d, Integer.valueOf(num2 != null ? 1 + num2.intValue() : 1));
            } else if (vt2Var != null) {
                vt2Var.g--;
            } else {
                HashMap<String, Integer> hashMap = this.f;
                if (hashMap == null || (num = hashMap.get(d)) == null || num.intValue() <= 0) {
                    return;
                }
                this.f.put(d, Integer.valueOf(num.intValue() - 1));
            }
        }

        public final void s(du2 du2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, du2Var) == null) && du2Var != null && i(du2Var.d())) {
                wt2.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = du2Var.e();
                t22 f = ut2.f();
                View B = yo2.U().B(du2Var.d());
                if (e == null || B == null || f == null) {
                    return;
                }
                Rect b2 = ut2.b(e, f, B);
                this.d.c(ut2.d(f));
                this.a.g();
                boolean a = du2Var.a();
                if (!ut2.h() && this.e <= 0) {
                    this.a.c = this.d.a(e, b2);
                    if (this.a.c) {
                        wt2.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                        if (a) {
                            this.a.f(e);
                            this.a.h = b2;
                        }
                        ut2.i(a, du2Var.d());
                        int i = 19;
                        if (z93.d && !a) {
                            i = 55;
                        }
                        xt2.c(this.a, i, a, this.b.size());
                    }
                } else {
                    wt2.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                    this.a.c = false;
                }
                this.a.a();
                if (tt2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + du2Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                }
                if (this.a.c) {
                    return;
                }
                double d = this.g.d(e, b2);
                int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                if (i2 >= 0) {
                    wt2.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                    int i3 = 28;
                    if (z93.d && !a) {
                        i3 = 56;
                    }
                    xt2.d(this.a, i3, w(), e, a, this.b.size());
                }
                if (a) {
                    l42 l42Var = new l42();
                    if (ut2.g()) {
                        if (i2 >= 0) {
                            l42Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                            l42Var.d(du2Var.d());
                            this.a.c = true;
                            wt2.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                        }
                    } else if (this.e == 0 && d >= 0.7d) {
                        l42Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                        l42Var.d(du2Var.d());
                        this.a.c = true;
                        wt2.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                    } else {
                        a42.b().a();
                    }
                }
            }
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (tt2.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                fh3.a0(new b(this));
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

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && h()) {
                wt2.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                yo2.U().u(m93.a(new m93()));
                yo2.U().m(str, m93.a(new m93()));
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = zb3.a().getString("screenshot_upload_switch", "1");
                if (tt2.b) {
                    Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
                }
                return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948192663, "Lcom/baidu/tieba/tt2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948192663, "Lcom/baidu/tieba/tt2;");
                return;
            }
        }
        b = l33.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tt2() {
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

    @Override // com.baidu.tieba.st2
    public void a(cu2 cu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cu2Var) == null) {
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
            if (cu2Var != null) {
                Message.obtain(this.a, cu2Var.b(), cu2Var).sendToTarget();
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            start();
            this.a = new a(this, getLooper());
        }
    }
}
