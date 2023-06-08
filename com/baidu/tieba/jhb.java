package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.Surface;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.pms.init.ApsCloudControlProcessor;
import com.baidu.tieba.egb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.util.UriUtil;
import com.google.gson.Gson;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import com.yy.transvod.player.log.TLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jhb extends oeb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vfb A;
    public mfb B;
    public rfb C;
    public ufb D;
    public qfb E;
    public kfb F;
    public pfb G;
    public ofb H;
    public xfb I;
    public egb.c J;
    public lfb K;
    public tfb L;
    public wfb M;
    public bgb N;
    public agb O;
    public RelativeLayout b;
    public final Handler c;
    public volatile hhb d;
    public final Object e;
    public Gson f;
    public Context g;
    public final Object h;
    public Surface i;
    public final AtomicBoolean j;
    public wib k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public String r;
    public int s;
    public int t;
    public boolean u;
    public long v;
    public long w;
    public final ExecutorService x;
    public yfb y;
    public sfb z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947884709, "Lcom/baidu/tieba/jhb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947884709, "Lcom/baidu/tieba/jhb;");
        }
    }

    /* loaded from: classes6.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jhb a;

        /* loaded from: classes6.dex */
        public class a implements egb.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ s a;

            public a(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = sVar;
            }

            @Override // com.baidu.tieba.egb.d
            public void a(Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
                    TLog.h("[VodPlayerServer]", this.a.a.I() + "sendBitmap2MainProcess");
                    this.a.a.b(bitmap);
                }
            }
        }

        public s(jhb jhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jhbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null) {
                this.a.d.q(this.a.x, new a(this));
                TLog.h("[VodPlayerServer]", this.a.I() + "(execCmd) screenShot");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jhb a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ t a;

            public a(t tVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = tVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.x.shutdown();
                }
            }
        }

        public t(jhb jhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jhbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.a.e) {
                    if (this.a.d != null) {
                        this.a.g();
                        this.a.d.s0();
                        this.a.d = null;
                    }
                }
                this.a.t = -1;
                this.a.c.post(new a(this));
                TLog.h("[VodPlayerServer]", this.a.I() + "(execCmd) release");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ jhb b;

        public a(jhb jhbVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jhbVar;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.d != null) {
                this.b.t = this.a.optInt("taskId");
                long optLong = this.a.optLong("apiStartTimeMs");
                if (this.b.u && this.b.w != 0) {
                    this.b.u = false;
                    optLong += this.b.w;
                    TLog.h("[VodPlayerServer]", this.b.I() + "apiStartTimeMs add " + this.b.w + "ms");
                }
                this.b.d.F(this.b.t, optLong);
                TLog.h("[VodPlayerServer]", this.b.I() + "(execCmd) startPlay");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ jhb b;

        public a0(jhb jhbVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jhbVar;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.d != null) {
                    TLog.m("[VodPlayerServer]", this.b.I() + "Cmd.initPlay#VodPlayer has inited before.");
                    return;
                }
                if (this.b.g == null) {
                    TLog.m("[VodPlayerServer]", this.b.I() + "Cmd.initPlay#VodPlayer mContext is null.");
                    synchronized (this.b.h) {
                        try {
                            this.b.h.wait(3000L);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (this.b.g != null) {
                    dgb a = dgb.a(this.a.optString("opt"));
                    a.k = new gib();
                    TLog.h("[VodPlayerServer]", this.b.I() + "create vodplayer server:" + a.toString());
                    long currentTimeMillis = System.currentTimeMillis();
                    jhb jhbVar = this.b;
                    jhbVar.d = new hhb(jhbVar.g, a, null);
                    this.b.w = System.currentTimeMillis() - currentTimeMillis;
                    jhb jhbVar2 = this.b;
                    jhbVar2.s = jhbVar2.d.o0();
                    this.b.G();
                    this.b.F();
                    this.b.J();
                    jhb jhbVar3 = this.b;
                    jhbVar3.N(jhbVar3.s);
                    return;
                }
                TLog.d("[VodPlayerServer]", this.b.I() + "initPlay,mContext is null ");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jhb a;

        public b(jhb jhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jhbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null) {
                this.a.d.m();
                TLog.h("[VodPlayerServer]", this.a.I() + "(execCmd) pausePlay");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ jhb b;

        public b0(jhb jhbVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jhbVar;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            sgb a;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.d == null || (a = sgb.a(this.a.optString(UriUtil.LOCAL_RESOURCE_SCHEME))) == null) {
                return;
            }
            this.b.d.u0(a);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jhb a;

        public c(jhb jhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jhbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null) {
                this.a.d.G();
                TLog.h("[VodPlayerServer]", this.a.I() + "(execCmd) stopPlay");
                this.a.t = -1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dfb a;
        public final /* synthetic */ jhb b;

        public c0(jhb jhbVar, dfb dfbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar, dfbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jhbVar;
            this.a = dfbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.L(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jhb a;

        public d(jhb jhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jhbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null) {
                this.a.d.o();
                TLog.h("[VodPlayerServer]", this.a.I() + "(execCmd) resumePlay");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ jhb b;

        public d0(jhb jhbVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jhbVar;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.d != null) {
                this.b.d.n0(igb.a(this.a.optString(ApsCloudControlProcessor.SERVER_DPM)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ jhb b;

        public e(jhb jhbVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jhbVar;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.d != null) {
                int optInt = this.a.optInt("p");
                this.b.d.r(optInt);
                TLog.h("[VodPlayerServer]", this.b.I() + "(execCmd) seekTo:" + optInt);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jhb a;

        public e0(jhb jhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jhbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null) {
                this.a.d.l0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ jhb b;

        public f(jhb jhbVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jhbVar;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.d != null) {
                int optInt = this.a.optInt(com.kuaishou.weapon.p0.u.A);
                this.b.d.u(optInt);
                TLog.h("[VodPlayerServer]", this.b.I() + "(execCmd) setDisplayMode:" + optInt);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ jhb b;

        public f0(jhb jhbVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jhbVar;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.d != null) {
                jfb a = jfb.a(this.a.optString("source"));
                this.b.d.s(a);
                TLog.h("[VodPlayerServer]", this.b.I() + "(execCmd) setDataSource:" + a.toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ jhb b;

        public g(jhb jhbVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jhbVar;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.d != null) {
                View view2 = (View) this.b.d.i();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
                if (layoutParams == null) {
                    return;
                }
                layoutParams.width = this.a.optInt("w");
                layoutParams.height = this.a.optInt("h");
                layoutParams.addRule(this.a.optInt("r"));
                view2.setLayoutParams(layoutParams);
                TLog.h("[VodPlayerServer]", this.b.I() + "(execCmd) setLayoutParams");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ jhb b;

        public g0(jhb jhbVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jhbVar;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.d != null) {
                jfb a = jfb.a(this.a.optString("source"));
                this.b.d.t(a);
                TLog.h("[VodPlayerServer]", this.b.I() + "(execCmd) setDataSourceAndPrepare:" + a.toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ jhb b;

        public h(jhb jhbVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jhbVar;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.d != null) {
                int optInt = this.a.optInt("p");
                this.b.d.v(optInt);
                TLog.h("[VodPlayerServer]", this.b.I() + "(execCmd) setNumberOfLoops:" + optInt);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ jhb b;

        public h0(jhb jhbVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jhbVar;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.d != null) {
                int optInt = this.a.optInt("taskId");
                jfb a = jfb.a(this.a.optString("source"));
                this.b.d.K0(optInt, a);
                TLog.h("[VodPlayerServer]", this.b.I() + "(execCmd) setPcdnUrls:" + a.toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jhb a;

        public i(jhb jhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jhbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null) {
                this.a.d.n();
                TLog.h("[VodPlayerServer]", this.a.I() + "(execCmd) pausePlayWithAudio");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jhb a;

        public j(jhb jhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jhbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null) {
                this.a.d.p();
                TLog.h("[VodPlayerServer]", this.a.I() + "(execCmd) resumePlayWithAudio");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jhb a;

        public k(jhb jhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jhbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null) {
                this.a.d.r0();
                TLog.h("[VodPlayerServer]", this.a.I() + "(execCmd) pausePlayWithVideo");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jhb a;

        public l(jhb jhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jhbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null) {
                this.a.d.t0();
                TLog.h("[VodPlayerServer]", this.a.I() + "(execCmd) resumePlayWithVideo");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ jhb b;

        public m(jhb jhbVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jhbVar;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.d != null) {
                boolean optBoolean = this.a.optBoolean("b");
                this.b.d.I0(optBoolean);
                TLog.h("[VodPlayerServer]", this.b.I() + "(execCmd) setVideoExtrasInfoEnable:" + optBoolean);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ jhb b;

        public n(jhb jhbVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jhbVar;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.d != null) {
                int optInt = this.a.optInt("v");
                this.b.d.J0(optInt);
                TLog.h("[VodPlayerServer]", this.b.I() + "(execCmd) setVolume:" + optInt);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ jhb b;

        public o(jhb jhbVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jhbVar;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.d != null) {
                boolean optBoolean = this.a.optBoolean("al");
                this.b.d.x0(optBoolean);
                TLog.h("[VodPlayerServer]", this.b.I() + "(execCmd) setIsSpecialMp4WithAlpha:" + optBoolean);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ jhb b;

        public p(jhb jhbVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jhbVar;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.d != null) {
                int optInt = this.a.optInt("rt");
                this.b.d.E(optInt);
                TLog.h("[VodPlayerServer]", this.b.I() + "(execCmd) setRotateMode:" + optInt);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ jhb b;

        public q(jhb jhbVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jhbVar;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean optBoolean = this.a.optBoolean("af");
                tgb.h(optBoolean);
                TLog.h("[VodPlayerServer]", this.b.I() + "(execCmd) enableAutoControl:" + optBoolean);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ jhb b;

        public r(jhb jhbVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jhbVar;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.d != null) {
                int optInt = this.a.optInt("ot");
                this.b.d.G0(optInt);
                TLog.h("[VodPlayerServer]", this.b.I() + "(execCmd) setOrientateMode:" + optInt);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jhb a;

        public u(jhb jhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jhbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.a.e) {
                    if (this.a.d != null && this.a.b != null) {
                        try {
                            View view2 = (View) this.a.d.i();
                            if (this.a.b.indexOfChild(view2) < 0) {
                                this.a.b.addView(view2);
                                TLog.h("[VodPlayerServer]", this.a.I() + "add player view");
                            }
                        } catch (Exception e) {
                            TLog.d("[VodPlayerServer]", this.a.I() + "add player view exception:" + e.getMessage());
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jhb a;

        public v(jhb jhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jhbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.d != null) {
                    this.a.d.e();
                }
                TLog.h("[VodPlayerServer]", this.a.I() + "(execCmd) appInBackground");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jhb a;

        public w(jhb jhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jhbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.d != null) {
                    this.a.O(this.a.d.p0());
                }
                TLog.h("[VodPlayerServer]", this.a.I() + "(execCmd) getRedirectUrl");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class x implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jhb a;

        public x(jhb jhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jhbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.d != null) {
                    this.a.d.v0(true);
                }
                TLog.h("[VodPlayerServer]", this.a.I() + "(execCmd) setEnableFirstVideoFrameShow");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jhb a;

        public y(jhb jhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jhbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.d != null) {
                    this.a.d.w0(true);
                }
                TLog.h("[VodPlayerServer]", this.a.I() + "(execCmd) setEnableRevDecodeOutputSize");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jhb a;

        public z(jhb jhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jhbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.d != null) {
                    this.a.d.f();
                }
                TLog.h("[VodPlayerServer]", this.a.I() + "(execCmd) appInFrontground");
            }
        }
    }

    public final void M(dfb dfbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, dfbVar) != null) || dfbVar == null) {
            return;
        }
        K(new c0(this, dfbVar));
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.d != null) {
            TLog.h("[VodPlayerServer]", I() + "addExternalSurfaceEvent");
            wib a2 = ((gib) this.d.i()).a();
            this.k = a2;
            if (this.l) {
                this.l = false;
                a2.a(this.i);
            }
            if (this.m) {
                this.m = false;
                this.k.b(this.o, this.p, this.q);
            }
            if (this.n) {
                this.n = false;
                this.k.surfaceDestroyed();
            }
        }
    }

    public final String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuilder sb = new StringBuilder(30);
            sb.append(PreferencesUtil.LEFT_MOUNT);
            sb.append("channel:");
            sb.append(this.r);
            if (this.s != -1) {
                sb.append(",context:");
                sb.append(this.s);
            }
            if (this.t != -1) {
                sb.append(",task:");
                sb.append(this.t);
            }
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oeb
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.g();
            int i2 = 0;
            if (this.j.compareAndSet(true, false)) {
                StringBuilder sb = new StringBuilder();
                sb.append(I());
                sb.append("surfaceDestroyed: ");
                Surface surface = this.i;
                if (surface != null) {
                    i2 = surface.hashCode();
                }
                sb.append(i2);
                TLog.h("[VodPlayerServer]", sb.toString());
                this.i = null;
                wib wibVar = this.k;
                if (wibVar != null) {
                    wibVar.surfaceDestroyed();
                } else {
                    this.n = true;
                }
            }
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.postAtFrontOfQueue(new u(this));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void H(String str) throws Exception {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("cmd");
            switch (optString.hashCode()) {
                case -2129411402:
                    if (optString.equals("startPlay")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -2093030610:
                    if (optString.equals("setEnableRevDecodeOutputSize")) {
                        c2 = DecodedBitStreamParser.RS;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1982498572:
                    if (optString.equals("appInBackground")) {
                        c2 = 27;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1617828140:
                    if (optString.equals("setIsSpecialMp4WithAlpha")) {
                        c2 = 21;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1508657702:
                    if (optString.equals("setEnableFirstVideoFrameShow")) {
                        c2 = DecodedBitStreamParser.GS;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1251896589:
                    if (optString.equals("disableJoyPkPipMode")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1187347186:
                    if (optString.equals("enableJoyPkPipMode")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -906224877:
                    if (optString.equals("seekTo")) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -697872445:
                    if (optString.equals("setDisplayMode")) {
                        c2 = '\f';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -557192959:
                    if (optString.equals("resumePlay")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -446053678:
                    if (optString.equals("setEffectResources")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -417400442:
                    if (optString.equals("screenShot")) {
                        c2 = 25;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -336540857:
                    if (optString.equals("setAudioFocusEnable")) {
                        c2 = 23;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -28201491:
                    if (optString.equals("setVideoExtrasInfoEnable")) {
                        c2 = 19;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 16017901:
                    if (optString.equals("setNumberOfLoops")) {
                        c2 = 14;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 25421522:
                    if (optString.equals("setLayoutParams")) {
                        c2 = '\r';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 87624170:
                    if (optString.equals("appInFrontground")) {
                        c2 = 31;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 251281091:
                    if (optString.equals("setPcdnUrls")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 268328036:
                    if (optString.equals("initPlay")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 347104503:
                    if (optString.equals("setDataSourceAndPrepare")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 397437856:
                    if (optString.equals("setRotateMode")) {
                        c2 = 22;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 670514716:
                    if (optString.equals("setVolume")) {
                        c2 = 20;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 734547631:
                    if (optString.equals("resumePlayWithAudio")) {
                        c2 = 16;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 753583956:
                    if (optString.equals("resumePlayWithVideo")) {
                        c2 = 18;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 829307466:
                    if (optString.equals("pausePlay")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 960176686:
                    if (optString.equals("setOrientateMode")) {
                        c2 = 24;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1090594823:
                    if (optString.equals("release")) {
                        c2 = 26;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1598099861:
                    if (optString.equals("sendRedirectUrlData")) {
                        c2 = DecodedBitStreamParser.FS;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1714697814:
                    if (optString.equals("stopPlay")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1748853351:
                    if (optString.equals("setDataSource")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2002804614:
                    if (optString.equals("pausePlayWithAudio")) {
                        c2 = 15;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2021840939:
                    if (optString.equals("pausePlayWithVideo")) {
                        c2 = 17;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    this.v = System.currentTimeMillis();
                    K(new a0(this, jSONObject.getJSONObject("data")));
                    return;
                case 1:
                    K(new b0(this, jSONObject.getJSONObject("data")));
                    return;
                case 2:
                    K(new d0(this, jSONObject.getJSONObject("data")));
                    return;
                case 3:
                    K(new e0(this));
                    return;
                case 4:
                    K(new f0(this, jSONObject.getJSONObject("data")));
                    return;
                case 5:
                    K(new g0(this, jSONObject.getJSONObject("data")));
                    return;
                case 6:
                    K(new h0(this, jSONObject.getJSONObject("data")));
                    return;
                case 7:
                    long currentTimeMillis = System.currentTimeMillis();
                    long j2 = this.v;
                    if (j2 != 0 && currentTimeMillis >= j2 && currentTimeMillis - j2 < 20) {
                        this.u = true;
                    }
                    K(new a(this, jSONObject.getJSONObject("data")));
                    return;
                case '\b':
                    K(new b(this));
                    return;
                case '\t':
                    K(new c(this));
                    return;
                case '\n':
                    K(new d(this));
                    return;
                case 11:
                    K(new e(this, jSONObject.getJSONObject("data")));
                    return;
                case '\f':
                    K(new f(this, jSONObject.getJSONObject("data")));
                    return;
                case '\r':
                    K(new g(this, jSONObject.getJSONObject("data")));
                    return;
                case 14:
                    K(new h(this, jSONObject.getJSONObject("data")));
                    return;
                case 15:
                    K(new i(this));
                    return;
                case 16:
                    K(new j(this));
                    return;
                case 17:
                    K(new k(this));
                    return;
                case 18:
                    K(new l(this));
                    return;
                case 19:
                    K(new m(this, jSONObject.getJSONObject("data")));
                    return;
                case 20:
                    K(new n(this, jSONObject.getJSONObject("data")));
                    return;
                case 21:
                    K(new o(this, jSONObject.getJSONObject("data")));
                    return;
                case 22:
                    K(new p(this, jSONObject.getJSONObject("data")));
                    return;
                case 23:
                    K(new q(this, jSONObject.getJSONObject("data")));
                    return;
                case 24:
                    K(new r(this, jSONObject.getJSONObject("data")));
                    return;
                case 25:
                    K(new s(this));
                    return;
                case 26:
                    K(new t(this));
                    return;
                case 27:
                    K(new v(this));
                    return;
                case 28:
                    K(new w(this));
                    return;
                case 29:
                    K(new x(this));
                    return;
                case 30:
                    K(new y(this));
                    return;
                case 31:
                    K(new z(this));
                    return;
                default:
                    return;
            }
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.d != null) {
            this.d.D(this.y);
            this.d.A0(this.z);
            this.d.D0(this.A);
            this.d.x(this.B);
            this.d.A(this.C);
            this.d.C0(this.D);
            this.d.z(this.E);
            this.d.y(this.H);
            this.d.C(this.I);
            this.d.w(this.x, this.K);
            this.d.B0(this.L);
            this.d.B(this.M);
            this.d.F0(this.N);
            this.d.E0(this.O);
            this.d.y0(this.F);
            this.d.z0(this.G);
            this.d.H0(this.J);
        }
    }

    public final void K(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, runnable) == null) {
            try {
                this.x.execute(runnable);
            } catch (Exception e2) {
                e2.printStackTrace();
                TLog.d("[VodPlayerServer]", I() + "(postToWorkThread) ex: " + e2.getMessage());
            }
        }
    }

    public final void L(dfb dfbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, dfbVar) != null) || dfbVar == null) {
            return;
        }
        try {
            c(this.f.toJson(dfbVar));
        } catch (Exception e2) {
            TLog.g(this, "sendData " + dfbVar.a + " exception:" + e2.toString());
            throw e2;
        }
    }

    public final void N(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            dfb dfbVar = new dfb();
            dfbVar.a = "setPlayerUID";
            dfbVar.b.put("playerUID", Integer.valueOf(i2));
            TLog.h("[VodPlayerServer]", I() + "onSendPlayerUIDToMainProcess,playerUID=" + i2);
            M(dfbVar);
        }
    }

    public final void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            dfb dfbVar = new dfb();
            dfbVar.a = "setRedirectUrl";
            dfbVar.b.put("redirectUrl", str);
            TLog.h("[VodPlayerServer]", I() + "sendRedirectUrlToMainProcess,redirectUrl=" + str);
            M(dfbVar);
        }
    }

    @Override // com.baidu.tieba.neb
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            try {
                H(str);
            } catch (Exception e2) {
                e2.printStackTrace();
                TLog.d("[VodPlayerServer]", I() + "(onDataFromMainThread) ex" + e2.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.oeb
    public void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            super.d(context);
            this.g = context;
            synchronized (this.h) {
                this.h.notifyAll();
            }
            TLog.h("[VodPlayerServer]", I() + "setContext");
        }
    }

    @Override // com.baidu.tieba.oeb
    public void e(Context context, Surface surface, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, surface, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.e(context, surface, i2, i3, i4);
            this.o = i2;
            this.p = i3;
            this.q = i4;
            TLog.h("[VodPlayerServer]", I() + "surfaceChanged,format:" + i2 + ",width:" + i3 + ",height:" + i4);
            wib wibVar = this.k;
            if (wibVar != null) {
                wibVar.b(i2, i3, i4);
            } else {
                this.m = true;
            }
        }
    }

    @Override // com.baidu.tieba.oeb
    public void f(Context context, Surface surface) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, context, surface) == null) {
            super.f(context, surface);
            this.j.set(true);
            this.g = context;
            this.i = surface;
            StringBuilder sb = new StringBuilder();
            sb.append(I());
            sb.append("surfaceCreated: ");
            Surface surface2 = this.i;
            if (surface2 != null) {
                i2 = surface2.hashCode();
            } else {
                i2 = 0;
            }
            sb.append(i2);
            TLog.h("[VodPlayerServer]", sb.toString());
            wib wibVar = this.k;
            if (wibVar != null) {
                wibVar.a(surface);
            } else {
                this.l = true;
            }
        }
    }
}
