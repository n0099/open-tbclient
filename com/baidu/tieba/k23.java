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
import com.baidu.tieba.w23;
import com.baidu.tieba.zw2;
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
public class k23 extends HandlerThread implements j23 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public m23 a;
        public Deque<m23> b;
        public boolean c;
        public w23 d;
        public int e;
        public HashMap<String, Integer> f;
        public x23 g;
        public final /* synthetic */ k23 h;

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.k23$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0376a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Bitmap a;
                public final /* synthetic */ SwanAppActivity b;
                public final /* synthetic */ b c;

                /* renamed from: com.baidu.tieba.k23$a$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes6.dex */
                public class RunnableC0377a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SwanAppActivity a;

                    public RunnableC0377a(RunnableC0376a runnableC0376a, SwanAppActivity swanAppActivity) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnableC0376a, swanAppActivity};
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
                            if (k23.b) {
                                Log.d("SwanAppPageMonitor", "recheckAndExit call activity finish.");
                            }
                            this.a.finish();
                        }
                    }
                }

                public RunnableC0376a(b bVar, Bitmap bitmap, SwanAppActivity swanAppActivity) {
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
                        wp3.a0(new RunnableC0377a(this, swanAppActivity));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (this.c.a.d.a(this.a, this.c.a.a.h)) {
                            o23.c(this.c.a.a, 33, false, this.c.a.b.size());
                            dc2.a("exit_whiteScreen_L1");
                            a(this.b);
                            return;
                        }
                        double d = this.c.a.g.d(this.a, this.c.a.a.h);
                        if (d >= 0.7d && this.c.a.e == 0) {
                            dc2.a("exit_whiteScreen_L2");
                            a(this.b);
                        } else if (d >= 0.5d && l23.g()) {
                            dc2.a("exit_whiteScreen_L3");
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (activity = px2.T().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed() && this.a.a != null) {
                    wo3.f().execute(new RunnableC0376a(this, tp3.p(), activity), "SwanPageMonitorRecheck");
                }
            }
        }

        /* renamed from: com.baidu.tieba.k23$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0375a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m23 a;
            public final /* synthetic */ a b;

            public RunnableC0375a(a aVar, m23 m23Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, m23Var};
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
                this.a = m23Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.v(this.a.a);
                    Bitmap p = tp3.p();
                    if (p != null) {
                        m23 m23Var = this.a;
                        Message.obtain(this.b, 8, new u23(m23Var.a, p, m23Var.i)).sendToTarget();
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k23 k23Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k23Var, looper};
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
            this.h = k23Var;
            this.b = new ArrayDeque();
            this.c = true;
            this.e = 0;
            this.d = w23.a.a("simple_parser");
            this.g = (x23) w23.a.a("hsv_parser");
        }

        public final void g(m23 m23Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, m23Var) == null) && m23Var != null && i(m23Var.a)) {
                wp3.e0(new RunnableC0375a(this, m23Var));
            }
        }

        public final boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                m23 m23Var = this.a;
                if (m23Var != null && str != null && TextUtils.equals(str, m23Var.a)) {
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
                m23 m23Var = this.a;
                if (m23Var != null && m23Var.i) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                if (k23.b) {
                    Log.d("SwanAppPageMonitor", "recheckAndExit");
                }
                wp3.a0(new b(this));
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
                if (k23.b) {
                    Log.d("SwanAppPageMonitor", "get message " + message.what);
                }
                switch (message.what) {
                    case 1:
                        removeMessages(9);
                        removeMessages(10);
                        if (qi3.d) {
                            q((t23) message.obj);
                            return;
                        } else {
                            p((t23) message.obj);
                            return;
                        }
                    case 2:
                        g((m23) message.obj);
                        return;
                    case 3:
                        removeMessages(2);
                        removeMessages(8);
                        return;
                    case 4:
                        if (((s23) message.obj).e()) {
                            j();
                            return;
                        } else {
                            m();
                            return;
                        }
                    case 5:
                        r23 r23Var = (r23) message.obj;
                        if (r23Var != null) {
                            if (r23Var.e()) {
                                this.e++;
                                return;
                            } else {
                                this.e--;
                                return;
                            }
                        }
                        return;
                    case 6:
                        r((v23) message.obj);
                        return;
                    case 7:
                        removeMessages(-1, null);
                        u();
                        return;
                    case 8:
                        s((u23) message.obj);
                        return;
                    case 9:
                        o((t23) message.obj);
                        return;
                    case 10:
                        n();
                        return;
                    case 11:
                        l();
                        return;
                    case 12:
                        k((t23) message.obj);
                        return;
                    case 13:
                        q((t23) message.obj);
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
                m23 m23Var = this.a;
                if (m23Var != null && !m23Var.c()) {
                    if (this.h.a != null) {
                        this.h.a.removeMessages(2);
                    }
                    this.a.d();
                    if (k23.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onBackground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final boolean w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                String string = qk3.a().getString("screenshot_upload_switch", "1");
                if (k23.b) {
                    Log.d("SwanAppPageMonitor", "Screenshot upload cloud switch: status = " + string);
                }
                if (!TextUtils.equals(string, "1") || new Random().nextInt(10) % 3 != 0) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void k(t23 t23Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, t23Var) == null) {
                this.h.a.removeMessages(2);
                m23 m23Var = this.a;
                if (m23Var != null) {
                    str = m23Var.a;
                } else {
                    str = StringUtil.NULL_STRING;
                }
                if (k23.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** cancel route monitor finished webViewId=" + str + " isNewLaunch=" + t23Var.a());
                }
            }
        }

        public final void o(@NonNull t23 t23Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, t23Var) == null) && t23Var.c() >= 0) {
                lb2 U = px2.T().U();
                if (U != null && U.k() > 0) {
                    return;
                }
                if (k23.b) {
                    Log.d("SwanAppPageMonitor", "start loading check: remainTime=" + t23Var.c());
                }
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 10, t23Var), t23Var.c());
            }
        }

        public final void v(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && h()) {
                n23.a("SwanAppPageMonitor", "发送白屏通知 slaveId=" + str);
                px2.T().u(di3.a(new di3()));
                px2.T().m(str, di3.a(new di3()));
            }
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                m23 m23Var = this.a;
                if (m23Var != null && m23Var.c() && this.a.c && h()) {
                    n23.a("SwanAppPageMonitor", "退出时检测白屏");
                    t();
                }
                if (h()) {
                    n23.a("SwanAppPageMonitor", "退出时检测骨架屏");
                    ec2.c();
                }
            }
        }

        public final void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.c = false;
                m23 m23Var = this.a;
                if (m23Var != null && m23Var.i && !m23Var.c()) {
                    this.a.e();
                    long b2 = this.a.b();
                    if (b2 >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, this.a), b2);
                    }
                    if (k23.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** onForeground, isNewLaunch=" + this.a.i);
                    }
                }
            }
        }

        public final void n() {
            SwanAppActivity activity;
            boolean z;
            zw2.a W;
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (activity = px2.T().getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                er3 U = activity.U();
                if (U != null && (view2 = U.a) != null && view2.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (k23.b) {
                    Log.d("SwanAppPageMonitor", "Loading check result: " + z);
                }
                if (!z) {
                    return;
                }
                vn3 vn3Var = new vn3();
                vn3Var.k(5L);
                vn3Var.i(19L);
                vn3Var.f("loading=true");
                cc3 b0 = cc3.b0();
                if (b0 == null) {
                    W = null;
                } else {
                    W = b0.W();
                }
                dj3 dj3Var = new dj3();
                dj3Var.p(vn3Var);
                dj3Var.r(W);
                dj3Var.q(vi3.n(bc3.K().k()));
                dj3Var.m(bc3.K().getAppId());
                dj3Var.s(String.valueOf(this.b.size()));
                dj3Var.n(false);
                vi3.R(dj3Var);
            }
        }

        public final void p(t23 t23Var) {
            kb2 f;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, t23Var) == null) && (f = l23.f()) != null) {
                String v3 = f.v3();
                iy1 q3 = f.q3();
                if (k23.b && q3 == null) {
                    Log.d("SwanAppPageMonitor", "webview manager is null for id " + v3);
                }
                if (q3 != null && !i(v3)) {
                    m23 m23Var = new m23(v3, f.o3().a, t23Var.c(), t23Var.a());
                    this.b.addLast(m23Var);
                    this.a = m23Var;
                    q3.s(q23.e());
                    HashMap<String, Integer> hashMap = this.f;
                    if (hashMap != null && hashMap.containsKey(v3)) {
                        this.a.g = this.f.remove(v3).intValue();
                    }
                    if (!this.c && m23Var.b() >= 0) {
                        this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, m23Var), this.a.b());
                    }
                }
            }
        }

        public final void q(t23 t23Var) {
            kb2 f;
            iy1 q3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048587, this, t23Var) != null) || (f = l23.f()) == null || (q3 = f.q3()) == null) {
                return;
            }
            String v3 = f.v3();
            m23 m23Var = new m23(v3, f.o3().a, t23Var.c(), t23Var.a());
            if (!i(v3)) {
                this.b.addLast(m23Var);
                q3.s(q23.e());
            }
            this.a = m23Var;
            HashMap<String, Integer> hashMap = this.f;
            if (hashMap != null && hashMap.containsKey(v3)) {
                this.a.g = this.f.get(v3).intValue();
            }
            if (!this.c && m23Var.b() >= 0) {
                this.h.a.sendMessageDelayed(Message.obtain(this.h.a, 2, m23Var), this.a.b());
                if (k23.b) {
                    Log.d("SwanAPPPageMonitor-Route", "**************** start countdown webViewId=" + v3 + " time=" + this.a.b() + " isNewLaunch=" + this.a.i);
                }
            }
        }

        public final void r(v23 v23Var) {
            Integer num;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, v23Var) != null) || v23Var == null) {
                return;
            }
            String d = v23Var.d();
            m23 m23Var = null;
            Iterator<m23> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m23 next = it.next();
                if (TextUtils.equals(next.a, d)) {
                    m23Var = next;
                    break;
                }
            }
            int i = 1;
            if (v23Var.e()) {
                if (m23Var != null) {
                    m23Var.g++;
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
            } else if (m23Var != null) {
                m23Var.g--;
            } else {
                HashMap<String, Integer> hashMap2 = this.f;
                if (hashMap2 != null && (num = hashMap2.get(d)) != null && num.intValue() > 0) {
                    this.f.put(d, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        public final void s(u23 u23Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, u23Var) == null) && u23Var != null && i(u23Var.d())) {
                n23.a("SwanAppPageMonitor", "开始分析是否白屏");
                Bitmap e = u23Var.e();
                kb2 f = l23.f();
                View B = px2.T().B(u23Var.d());
                if (e != null && B != null && f != null) {
                    Rect b2 = l23.b(e, f, B);
                    this.d.c(l23.d(f));
                    this.a.g();
                    boolean a = u23Var.a();
                    if (!l23.h() && this.e <= 0) {
                        this.a.c = this.d.a(e, b2);
                        if (this.a.c) {
                            n23.a("SwanAppPageMonitor", "检测到当前页面为纯白屏");
                            if (a) {
                                this.a.f(e);
                                this.a.h = b2;
                            }
                            l23.i(a, u23Var.d());
                            int i = 19;
                            if (qi3.d && !a) {
                                i = 55;
                            }
                            o23.c(this.a, i, a, this.b.size());
                        }
                    } else {
                        n23.a("SwanAppPageMonitor", "有dialog或NAView，dialogNum=" + this.e);
                        this.a.c = false;
                    }
                    this.a.a();
                    if (k23.b) {
                        Log.d("SwanAPPPageMonitor-Route", "**************** detected finished, webViewId=" + u23Var.d() + " isWhite=" + this.a.c + " isNewLaunch=" + a);
                    }
                    if (!this.a.c) {
                        double d = this.g.d(e, b2);
                        int i2 = (d > 0.5d ? 1 : (d == 0.5d ? 0 : -1));
                        if (i2 >= 0) {
                            n23.a("SwanAppPageMonitor", "检测到区域白屏 isFirstPage=" + a);
                            int i3 = 28;
                            if (qi3.d && !a) {
                                i3 = 56;
                            }
                            o23.d(this.a, i3, w(), e, a, this.b.size());
                        }
                        if (a) {
                            cd2 cd2Var = new cd2();
                            if (l23.g()) {
                                if (i2 >= 0) {
                                    cd2Var.e(SceneType.SCENE_WHITE_SCREEN_L3);
                                    cd2Var.d(u23Var.d());
                                    this.a.c = true;
                                    n23.a("SwanAppPageMonitor", "首页非纯白屏，LoadingView在展示，有50%以上区域白屏");
                                }
                            } else if (this.e == 0 && d >= 0.7d) {
                                cd2Var.e(SceneType.SCENE_WHITE_SCREEN_L2);
                                cd2Var.d(u23Var.d());
                                this.a.c = true;
                                n23.a("SwanAppPageMonitor", "首页非纯白屏，没有LoadingView在展示，且dialog数量为0，有70%以上区域白屏");
                            } else {
                                rc2.b().a();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947861149, "Lcom/baidu/tieba/k23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947861149, "Lcom/baidu/tieba/k23;");
                return;
            }
        }
        b = cc3.v;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k23() {
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

    @Override // com.baidu.tieba.j23
    public void a(t23 t23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t23Var) == null) {
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
            if (t23Var != null) {
                Message.obtain(this.a, t23Var.b(), t23Var).sendToTarget();
            }
        }
    }
}
