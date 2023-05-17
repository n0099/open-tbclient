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
import com.baidu.tieba.a03;
import com.baidu.tieba.du2;
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
public class oz2 extends HandlerThread implements nz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public qz2 a;
        public Deque<qz2> b;
        public boolean c;
        public a03 d;
        public int e;
        public HashMap<String, Integer> f;
        public b03 g;
        public final /* synthetic */ oz2 h;

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.oz2$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0409a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.baidu.tieba.oz2$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes6.dex */
                public class RunnableC0410a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0410a(RunnableC0409a runnableC0409a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0409a, swanAppActivity};
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
                            if (oz2.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0409a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
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
                        an3.a0(new RunnableC0410a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            sz2.c(this.c.a.a, 33, false, this.c.a.b.size());
                            h92.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            h92.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d >= 0.5d && pz2.g()) {
                            h92.a("exit_whiteScreen_L3");
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (activity = tu2.U().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed() && this.a.a != null) {
                    am3.f().execute(new RunnableC0409a(this, xm3.p(), activity), "SwanPageMonitorRecheck");
                }
            }
        }

        /* renamed from: com.baidu.tieba.oz2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0408a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ qz2 a;
            public final /* synthetic */ a b;

            public RunnableC0408a(a aVar, qz2 qz2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, qz2Var};
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
                this.a = qz2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = xm3.p();
                    if (p != null) {
                        qz2 qz2Var = this.a;
                        Message.obtain(this.b, 8, new yz2(qz2Var.a, p, qz2Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(oz2 oz2Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz2Var, looper};
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
            this.h = oz2Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = a03.a.a("simple_parser");
            this.g = (b03) a03.a.a("hsv_parser");
        }

        public final void g(qz2 qz2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, qz2Var) == null) && qz2Var != null && i(qz2Var.a)) {
                an3.e0(new RunnableC0408a(this, qz2Var));
            }
        }

        public final boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                qz2 qz2Var = this.a;
                if (qz2Var != null && str != null && TextUtils.equals(str, qz2Var.a)) {
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
                qz2 qz2Var = this.a;
                if (qz2Var != null && qz2Var.i) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (oz2.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                an3.a0(new b(this));
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
                if (oz2.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (uf3.d) {
                            q((xz2) message.obj);
                            return;
                        } else {
                            p((xz2) message.obj);
                            return;
                        }
                    case 2:
                        g((qz2) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((wz2) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        vz2 vz2Var = (vz2) message.obj;
                        if (vz2Var != null) {
                            if (vz2Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((zz2) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((yz2) message.obj);
                        return;
                    case 9:
                        o((xz2) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((xz2) message.obj);
                        return;
                    case 13:
                        q((xz2) message.obj);
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
                qz2 qz2Var = this.a;
                if (qz2Var != null && !qz2Var.c()) {
                    if (this.h.a != null) {
                        this.h.a.removeMessages(2);
                    }
                    this.a.d();
                    if (oz2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = uh3.a().getString("screenshot_upload_switch", "1");
                if (oz2.b) {
                    Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
                }
                if (!TextUtils.equals(string, "1") || new Random().nextInt(10) % 3 != 0) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void k(xz2 xz2Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, xz2Var) == null) {
                this.h.a.removeMessages(2);
                qz2 qz2Var = this.a;
                if (qz2Var != null) {
                    str = qz2Var.a;
                } else {
                    str = StringUtil.NULL_STRING;
                }
                if (oz2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + xz2Var.a());
                }
            }
        }

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && h()) {
                rz2.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                tu2.U().u(hf3.a(new hf3()));
                tu2.U().m(str, hf3.a(new hf3()));
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                qz2 qz2Var = this.a;
                if (qz2Var != null && qz2Var.c() && this.a.c && h()) {
                    rz2.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    rz2.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    i92.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                qz2 qz2Var = this.a;
                if (qz2Var != null && qz2Var.i && !qz2Var.c()) {
                    this.a.e();
                    long b2 = this.a.b();
                    if (b2 >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                    }
                    if (oz2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            boolean z;
            du2.a W;
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (activity = tu2.U().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                io3 V = activity.V();
                if (V != null && (view2 = V.a) != null && view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (oz2.b) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (!z) {
                    return;
                }
                zk3 zk3Var = new zk3();
                zk3Var.k(5L);
                zk3Var.i(19L);
                zk3Var.f("loading=true");
                g93 b0 = g93.b0();
                if (b0 == null) {
                    W = null;
                } else {
                    W = b0.W();
                }
                hg3 hg3Var = new hg3();
                hg3Var.p(zk3Var);
                hg3Var.r(W);
                hg3Var.q(zf3.n(f93.K().k()));
                hg3Var.m(f93.K().getAppId());
                hg3Var.s(String.valueOf(this.b.size()));
                hg3Var.n(false);
                zf3.R(hg3Var);
            }
        }

        public final void o(@NonNull xz2 xz2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, xz2Var) == null) && xz2Var.c() >= 0) {
                p82 V = tu2.U().V();
                if (V != null && V.k() > 0) {
                    return;
                }
                if (oz2.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + xz2Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, xz2Var), xz2Var.c());
            }
        }

        public final void r(zz2 zz2Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, zz2Var) != null) || zz2Var == null) {
                return;
            }
            String d = zz2Var.d();
            qz2 qz2Var = null;
            Iterator<qz2> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                qz2 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    qz2Var = next;
                    break;
                }
            }
            int i = 1;
            if (zz2Var.e()) {
                if (qz2Var != null) {
                    qz2Var.g++;
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
            } else if (qz2Var != null) {
                qz2Var.g--;
            } else {
                HashMap<String, Integer> hashMap2 = this.f;
                if (hashMap2 != null && (num = hashMap2.get(d)) != null && num.intValue() > 0) {
                    this.f.put(d, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        public final void p(xz2 xz2Var) {
            o82 f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, xz2Var) == null) && (f = pz2.f()) != null) {
                String w3 = f.w3();
                mv1 r3 = f.r3();
                if (oz2.b && r3 == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + w3);
                }
                if (r3 != null && !i(w3)) {
                    qz2 qz2Var = new qz2(w3, f.p3().a, xz2Var.c(), xz2Var.a());
                    this.b.addLast(qz2Var);
                    this.a = qz2Var;
                    r3.t(uz2.e());
                    HashMap<String, Integer> hashMap = this.f;
                    if (hashMap != null && hashMap.containsKey(w3)) {
                        this.a.g = this.f.remove(w3).intValue();
                    }
                    if (!this.c && qz2Var.b() >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, qz2Var), this.a.b());
                    }
                }
            }
        }

        public final void q(xz2 xz2Var) {
            o82 f;
            mv1 r3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048587, this, xz2Var) != null) || (f = pz2.f()) == null || (r3 = f.r3()) == null) {
                return;
            }
            String w3 = f.w3();
            qz2 qz2Var = new qz2(w3, f.p3().a, xz2Var.c(), xz2Var.a());
            if (!i(w3)) {
                this.b.addLast(qz2Var);
                r3.t(uz2.e());
            }
            this.a = qz2Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(w3)) {
                this.a.g = this.f.get(w3).intValue();
            }
            if (!this.c && qz2Var.b() >= 0) {
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, qz2Var), this.a.b());
                if (oz2.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + w3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void s(yz2 yz2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, yz2Var) == null) && yz2Var != null && i(yz2Var.d())) {
                rz2.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = yz2Var.e();
                o82 f = pz2.f();
                View B = tu2.U().B(yz2Var.d());
                if (e != null && B != null && f != null) {
                    Rect b2 = pz2.b(e, f, B);
                    this.d.c(pz2.d(f));
                    this.a.g();
                    boolean a = yz2Var.a();
                    if (!pz2.h() && this.e <= 0) {
                        this.a.c = this.d.a(e, b2);
                        if (this.a.c) {
                            rz2.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                            if (a) {
                                this.a.f(e);
                                this.a.h = b2;
                            }
                            pz2.i(a, yz2Var.d());
                            int i = 19;
                            if (uf3.d && !a) {
                                i = 55;
                            }
                            sz2.c(this.a, i, a, this.b.size());
                        }
                    } else {
                        rz2.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                        this.a.c = false;
                    }
                    this.a.a();
                    if (oz2.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + yz2Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                    }
                    if (!this.a.c) {
                        double d = this.g.d(e, b2);
                        int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                        if (i2 >= 0) {
                            rz2.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                            int i3 = 28;
                            if (uf3.d && !a) {
                                i3 = 56;
                            }
                            sz2.d(this.a, i3, w(), e, a, this.b.size());
                        }
                        if (a) {
                            ga2 ga2Var = new ga2();
                            if (pz2.g()) {
                                if (i2 >= 0) {
                                    ga2Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                                    ga2Var.d(yz2Var.d());
                                    this.a.c = true;
                                    rz2.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                                }
                            } else if (this.e == 0 && d >= 0.7d) {
                                ga2Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                                ga2Var.d(yz2Var.d());
                                this.a.c = true;
                                rz2.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                            } else {
                                v92.b().a();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948049474, "Lcom/baidu/tieba/oz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948049474, "Lcom/baidu/tieba/oz2;");
                return;
            }
        }
        b = g93.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oz2() {
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

    @Override // com.baidu.tieba.nz2
    public void a(xz2 xz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xz2Var) == null) {
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
            if (xz2Var != null) {
                Message.obtain(this.a, xz2Var.b(), xz2Var).sendToTarget();
            }
        }
    }
}
