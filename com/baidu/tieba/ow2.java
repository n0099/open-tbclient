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
import com.baidu.tieba.ax2;
import com.baidu.tieba.dr2;
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
public class ow2 extends HandlerThread implements nw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public qw2 a;
        public Deque<qw2> b;
        public boolean c;
        public ax2 d;
        public int e;
        public HashMap<String, Integer> f;
        public bx2 g;
        public final /* synthetic */ ow2 h;

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.ow2$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0429a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.baidu.tieba.ow2$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public class RunnableC0430a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0430a(RunnableC0429a runnableC0429a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0429a, swanAppActivity};
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
                            if (ow2.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0429a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
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
                        ak3.a0(new RunnableC0430a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            sw2.c(this.c.a.a, 33, false, this.c.a.b.size());
                            h62.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            h62.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d >= 0.5d && pw2.g()) {
                            h62.a("exit_whiteScreen_L3");
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (activity = tr2.V().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed() && this.a.a != null) {
                    aj3.f().execute(new RunnableC0429a(this, xj3.p(), activity), "SwanPageMonitorRecheck");
                }
            }
        }

        /* renamed from: com.baidu.tieba.ow2$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0428a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ qw2 a;
            public final /* synthetic */ a b;

            public RunnableC0428a(a aVar, qw2 qw2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, qw2Var};
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
                this.a = qw2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = xj3.p();
                    if (p != null) {
                        qw2 qw2Var = this.a;
                        Message.obtain(this.b, 8, new yw2(qw2Var.a, p, qw2Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ow2 ow2Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow2Var, looper};
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
            this.h = ow2Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = ax2.a.a("simple_parser");
            this.g = (bx2) ax2.a.a("hsv_parser");
        }

        public final void g(qw2 qw2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, qw2Var) == null) && qw2Var != null && i(qw2Var.a)) {
                ak3.e0(new RunnableC0428a(this, qw2Var));
            }
        }

        public final boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                qw2 qw2Var = this.a;
                if (qw2Var != null && str != null && TextUtils.equals(str, qw2Var.a)) {
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
                qw2 qw2Var = this.a;
                if (qw2Var != null && qw2Var.i) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (ow2.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                ak3.a0(new b(this));
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
                if (ow2.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (uc3.d) {
                            q((xw2) message.obj);
                            return;
                        } else {
                            p((xw2) message.obj);
                            return;
                        }
                    case 2:
                        g((qw2) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((ww2) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        vw2 vw2Var = (vw2) message.obj;
                        if (vw2Var != null) {
                            if (vw2Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((zw2) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((yw2) message.obj);
                        return;
                    case 9:
                        o((xw2) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((xw2) message.obj);
                        return;
                    case 13:
                        q((xw2) message.obj);
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
                qw2 qw2Var = this.a;
                if (qw2Var != null && !qw2Var.c()) {
                    if (this.h.a != null) {
                        this.h.a.removeMessages(2);
                    }
                    this.a.d();
                    if (ow2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = ue3.a().getString("screenshot_upload_switch", "1");
                if (ow2.b) {
                    Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
                }
                if (!TextUtils.equals(string, "1") || new Random().nextInt(10) % 3 != 0) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void k(xw2 xw2Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, xw2Var) == null) {
                this.h.a.removeMessages(2);
                qw2 qw2Var = this.a;
                if (qw2Var != null) {
                    str = qw2Var.a;
                } else {
                    str = StringUtil.NULL_STRING;
                }
                if (ow2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + xw2Var.a());
                }
            }
        }

        public final void o(@NonNull xw2 xw2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, xw2Var) == null) && xw2Var.c() >= 0) {
                p52 W = tr2.V().W();
                if (W != null && W.k() > 0) {
                    return;
                }
                if (ow2.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + xw2Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, xw2Var), xw2Var.c());
            }
        }

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && h()) {
                rw2.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                tr2.V().v(hc3.a(new hc3()));
                tr2.V().n(str, hc3.a(new hc3()));
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                qw2 qw2Var = this.a;
                if (qw2Var != null && qw2Var.c() && this.a.c && h()) {
                    rw2.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    rw2.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    i62.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                qw2 qw2Var = this.a;
                if (qw2Var != null && qw2Var.i && !qw2Var.c()) {
                    this.a.e();
                    long b2 = this.a.b();
                    if (b2 >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                    }
                    if (ow2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            boolean z;
            dr2.a X;
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (activity = tr2.V().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                il3 U = activity.U();
                if (U != null && (view2 = U.a) != null && view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (ow2.b) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (!z) {
                    return;
                }
                zh3 zh3Var = new zh3();
                zh3Var.k(5L);
                zh3Var.i(19L);
                zh3Var.f("loading=true");
                g63 c0 = g63.c0();
                if (c0 == null) {
                    X = null;
                } else {
                    X = c0.X();
                }
                hd3 hd3Var = new hd3();
                hd3Var.p(zh3Var);
                hd3Var.r(X);
                hd3Var.q(zc3.n(f63.K().k()));
                hd3Var.m(f63.K().getAppId());
                hd3Var.s(String.valueOf(this.b.size()));
                hd3Var.n(false);
                zc3.R(hd3Var);
            }
        }

        public final void p(xw2 xw2Var) {
            o52 f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, xw2Var) == null) && (f = pw2.f()) != null) {
                String A3 = f.A3();
                ns1 v3 = f.v3();
                if (ow2.b && v3 == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + A3);
                }
                if (v3 != null && !i(A3)) {
                    qw2 qw2Var = new qw2(A3, f.t3().a, xw2Var.c(), xw2Var.a());
                    this.b.addLast(qw2Var);
                    this.a = qw2Var;
                    v3.r(uw2.e());
                    HashMap<String, Integer> hashMap = this.f;
                    if (hashMap != null && hashMap.containsKey(A3)) {
                        this.a.g = this.f.remove(A3).intValue();
                    }
                    if (!this.c && qw2Var.b() >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, qw2Var), this.a.b());
                    }
                }
            }
        }

        public final void q(xw2 xw2Var) {
            o52 f;
            ns1 v3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048587, this, xw2Var) != null) || (f = pw2.f()) == null || (v3 = f.v3()) == null) {
                return;
            }
            String A3 = f.A3();
            qw2 qw2Var = new qw2(A3, f.t3().a, xw2Var.c(), xw2Var.a());
            if (!i(A3)) {
                this.b.addLast(qw2Var);
                v3.r(uw2.e());
            }
            this.a = qw2Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(A3)) {
                this.a.g = this.f.get(A3).intValue();
            }
            if (!this.c && qw2Var.b() >= 0) {
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, qw2Var), this.a.b());
                if (ow2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + A3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void r(zw2 zw2Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, zw2Var) != null) || zw2Var == null) {
                return;
            }
            String d = zw2Var.d();
            qw2 qw2Var = null;
            Iterator<qw2> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                qw2 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    qw2Var = next;
                    break;
                }
            }
            int i = 1;
            if (zw2Var.e()) {
                if (qw2Var != null) {
                    qw2Var.g++;
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
            } else if (qw2Var != null) {
                qw2Var.g--;
            } else {
                HashMap<String, Integer> hashMap2 = this.f;
                if (hashMap2 != null && (num = hashMap2.get(d)) != null && num.intValue() > 0) {
                    this.f.put(d, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        public final void s(yw2 yw2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, yw2Var) == null) && yw2Var != null && i(yw2Var.d())) {
                rw2.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = yw2Var.e();
                o52 f = pw2.f();
                View C = tr2.V().C(yw2Var.d());
                if (e != null && C != null && f != null) {
                    Rect b2 = pw2.b(e, f, C);
                    this.d.c(pw2.d(f));
                    this.a.g();
                    boolean a = yw2Var.a();
                    if (!pw2.h() && this.e <= 0) {
                        this.a.c = this.d.a(e, b2);
                        if (this.a.c) {
                            rw2.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                            if (a) {
                                this.a.f(e);
                                this.a.h = b2;
                            }
                            pw2.i(a, yw2Var.d());
                            int i = 19;
                            if (uc3.d && !a) {
                                i = 55;
                            }
                            sw2.c(this.a, i, a, this.b.size());
                        }
                    } else {
                        rw2.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                        this.a.c = false;
                    }
                    this.a.a();
                    if (ow2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + yw2Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                    }
                    if (!this.a.c) {
                        double d = this.g.d(e, b2);
                        int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                        if (i2 >= 0) {
                            rw2.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                            int i3 = 28;
                            if (uc3.d && !a) {
                                i3 = 56;
                            }
                            sw2.d(this.a, i3, w(), e, a, this.b.size());
                        }
                        if (a) {
                            g72 g72Var = new g72();
                            if (pw2.g()) {
                                if (i2 >= 0) {
                                    g72Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                                    g72Var.d(yw2Var.d());
                                    this.a.c = true;
                                    rw2.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                                }
                            } else if (this.e == 0 && d >= 0.7d) {
                                g72Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                                g72Var.d(yw2Var.d());
                                this.a.c = true;
                                rw2.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                            } else {
                                v62.b().a();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948046591, "Lcom/baidu/tieba/ow2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948046591, "Lcom/baidu/tieba/ow2;");
                return;
            }
        }
        b = g63.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ow2() {
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

    @Override // com.baidu.tieba.nw2
    public void a(xw2 xw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xw2Var) == null) {
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
            if (xw2Var != null) {
                Message.obtain(this.a, xw2Var.b(), xw2Var).sendToTarget();
            }
        }
    }
}
