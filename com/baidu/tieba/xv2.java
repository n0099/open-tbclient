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
import com.baidu.tieba.jw2;
import com.baidu.tieba.mq2;
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
public class xv2 extends HandlerThread implements wv2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public zv2 a;
        public Deque<zv2> b;
        public boolean c;
        public jw2 d;
        public int e;
        public HashMap<String, Integer> f;
        public kw2 g;
        public final /* synthetic */ xv2 h;

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.xv2$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC0523a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.baidu.tieba.xv2$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes8.dex */
                public class RunnableC0524a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0524a(RunnableC0523a runnableC0523a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0523a, swanAppActivity};
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
                            if (xv2.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0523a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
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
                        jj3.a0(new RunnableC0524a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            bw2.c(this.c.a.a, 33, false, this.c.a.b.size());
                            q52.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            q52.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d >= 0.5d && yv2.g()) {
                            q52.a("exit_whiteScreen_L3");
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (activity = cr2.V().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed() && this.a.a != null) {
                    ji3.f().execute(new RunnableC0523a(this, gj3.p(), activity), "SwanPageMonitorRecheck");
                }
            }
        }

        /* renamed from: com.baidu.tieba.xv2$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0522a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ zv2 a;
            public final /* synthetic */ a b;

            public RunnableC0522a(a aVar, zv2 zv2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, zv2Var};
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
                this.a = zv2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = gj3.p();
                    if (p != null) {
                        zv2 zv2Var = this.a;
                        Message.obtain(this.b, 8, new hw2(zv2Var.a, p, zv2Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(xv2 xv2Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xv2Var, looper};
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
            this.h = xv2Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = jw2.a.a("simple_parser");
            this.g = (kw2) jw2.a.a("hsv_parser");
        }

        public final void g(zv2 zv2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, zv2Var) == null) && zv2Var != null && i(zv2Var.a)) {
                jj3.e0(new RunnableC0522a(this, zv2Var));
            }
        }

        public final boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                zv2 zv2Var = this.a;
                if (zv2Var != null && str != null && TextUtils.equals(str, zv2Var.a)) {
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
                zv2 zv2Var = this.a;
                if (zv2Var != null && zv2Var.i) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (xv2.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                jj3.a0(new b(this));
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
                if (xv2.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (dc3.d) {
                            q((gw2) message.obj);
                            return;
                        } else {
                            p((gw2) message.obj);
                            return;
                        }
                    case 2:
                        g((zv2) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((fw2) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        ew2 ew2Var = (ew2) message.obj;
                        if (ew2Var != null) {
                            if (ew2Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((iw2) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((hw2) message.obj);
                        return;
                    case 9:
                        o((gw2) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((gw2) message.obj);
                        return;
                    case 13:
                        q((gw2) message.obj);
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
                zv2 zv2Var = this.a;
                if (zv2Var != null && !zv2Var.c()) {
                    if (this.h.a != null) {
                        this.h.a.removeMessages(2);
                    }
                    this.a.d();
                    if (xv2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = de3.a().getString("screenshot_upload_switch", "1");
                if (xv2.b) {
                    Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
                }
                if (!TextUtils.equals(string, "1") || new Random().nextInt(10) % 3 != 0) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void k(gw2 gw2Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gw2Var) == null) {
                this.h.a.removeMessages(2);
                zv2 zv2Var = this.a;
                if (zv2Var != null) {
                    str = zv2Var.a;
                } else {
                    str = StringUtil.NULL_STRING;
                }
                if (xv2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + gw2Var.a());
                }
            }
        }

        public final void o(@NonNull gw2 gw2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, gw2Var) == null) && gw2Var.c() >= 0) {
                y42 W = cr2.V().W();
                if (W != null && W.k() > 0) {
                    return;
                }
                if (xv2.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + gw2Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, gw2Var), gw2Var.c());
            }
        }

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && h()) {
                aw2.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                cr2.V().v(qb3.a(new qb3()));
                cr2.V().n(str, qb3.a(new qb3()));
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                zv2 zv2Var = this.a;
                if (zv2Var != null && zv2Var.c() && this.a.c && h()) {
                    aw2.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    aw2.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    r52.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                zv2 zv2Var = this.a;
                if (zv2Var != null && zv2Var.i && !zv2Var.c()) {
                    this.a.e();
                    long b2 = this.a.b();
                    if (b2 >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                    }
                    if (xv2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            boolean z;
            mq2.a X;
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (activity = cr2.V().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                rk3 T2 = activity.T();
                if (T2 != null && (view2 = T2.a) != null && view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (xv2.b) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (!z) {
                    return;
                }
                ih3 ih3Var = new ih3();
                ih3Var.k(5L);
                ih3Var.i(19L);
                ih3Var.f("loading=true");
                p53 c0 = p53.c0();
                if (c0 == null) {
                    X = null;
                } else {
                    X = c0.X();
                }
                qc3 qc3Var = new qc3();
                qc3Var.p(ih3Var);
                qc3Var.r(X);
                qc3Var.q(ic3.n(o53.K().k()));
                qc3Var.m(o53.K().getAppId());
                qc3Var.s(String.valueOf(this.b.size()));
                qc3Var.n(false);
                ic3.R(qc3Var);
            }
        }

        public final void p(gw2 gw2Var) {
            x42 f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, gw2Var) == null) && (f = yv2.f()) != null) {
                String A3 = f.A3();
                wr1 v3 = f.v3();
                if (xv2.b && v3 == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + A3);
                }
                if (v3 != null && !i(A3)) {
                    zv2 zv2Var = new zv2(A3, f.t3().a, gw2Var.c(), gw2Var.a());
                    this.b.addLast(zv2Var);
                    this.a = zv2Var;
                    v3.r(dw2.e());
                    HashMap<String, Integer> hashMap = this.f;
                    if (hashMap != null && hashMap.containsKey(A3)) {
                        this.a.g = this.f.remove(A3).intValue();
                    }
                    if (!this.c && zv2Var.b() >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, zv2Var), this.a.b());
                    }
                }
            }
        }

        public final void q(gw2 gw2Var) {
            x42 f;
            wr1 v3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048587, this, gw2Var) != null) || (f = yv2.f()) == null || (v3 = f.v3()) == null) {
                return;
            }
            String A3 = f.A3();
            zv2 zv2Var = new zv2(A3, f.t3().a, gw2Var.c(), gw2Var.a());
            if (!i(A3)) {
                this.b.addLast(zv2Var);
                v3.r(dw2.e());
            }
            this.a = zv2Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(A3)) {
                this.a.g = this.f.get(A3).intValue();
            }
            if (!this.c && zv2Var.b() >= 0) {
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, zv2Var), this.a.b());
                if (xv2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + A3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void r(iw2 iw2Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, iw2Var) != null) || iw2Var == null) {
                return;
            }
            String d = iw2Var.d();
            zv2 zv2Var = null;
            Iterator<zv2> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                zv2 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    zv2Var = next;
                    break;
                }
            }
            int i = 1;
            if (iw2Var.e()) {
                if (zv2Var != null) {
                    zv2Var.g++;
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
            } else if (zv2Var != null) {
                zv2Var.g--;
            } else {
                HashMap<String, Integer> hashMap2 = this.f;
                if (hashMap2 != null && (num = hashMap2.get(d)) != null && num.intValue() > 0) {
                    this.f.put(d, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        public final void s(hw2 hw2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, hw2Var) == null) && hw2Var != null && i(hw2Var.d())) {
                aw2.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = hw2Var.e();
                x42 f = yv2.f();
                View C = cr2.V().C(hw2Var.d());
                if (e != null && C != null && f != null) {
                    Rect b2 = yv2.b(e, f, C);
                    this.d.c(yv2.d(f));
                    this.a.g();
                    boolean a = hw2Var.a();
                    if (!yv2.h() && this.e <= 0) {
                        this.a.c = this.d.a(e, b2);
                        if (this.a.c) {
                            aw2.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                            if (a) {
                                this.a.f(e);
                                this.a.h = b2;
                            }
                            yv2.i(a, hw2Var.d());
                            int i = 19;
                            if (dc3.d && !a) {
                                i = 55;
                            }
                            bw2.c(this.a, i, a, this.b.size());
                        }
                    } else {
                        aw2.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                        this.a.c = false;
                    }
                    this.a.a();
                    if (xv2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + hw2Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                    }
                    if (!this.a.c) {
                        double d = this.g.d(e, b2);
                        int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                        if (i2 >= 0) {
                            aw2.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                            int i3 = 28;
                            if (dc3.d && !a) {
                                i3 = 56;
                            }
                            bw2.d(this.a, i3, w(), e, a, this.b.size());
                        }
                        if (a) {
                            p62 p62Var = new p62();
                            if (yv2.g()) {
                                if (i2 >= 0) {
                                    p62Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                                    p62Var.d(hw2Var.d());
                                    this.a.c = true;
                                    aw2.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                                }
                            } else if (this.e == 0 && d >= 0.7d) {
                                p62Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                                p62Var.d(hw2Var.d());
                                this.a.c = true;
                                aw2.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                            } else {
                                e62.b().a();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948313749, "Lcom/baidu/tieba/xv2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948313749, "Lcom/baidu/tieba/xv2;");
                return;
            }
        }
        b = p53.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xv2() {
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

    @Override // com.baidu.tieba.wv2
    public void a(gw2 gw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gw2Var) == null) {
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
            if (gw2Var != null) {
                Message.obtain(this.a, gw2Var.b(), gw2Var).sendToTarget();
            }
        }
    }
}
