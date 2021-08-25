package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.p.a.a.a.c.n;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.activity.base.TTMiddlePageActivity;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.e.l;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.q.c;
import com.bytedance.sdk.openadsdk.q.q;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d implements w.a, com.bytedance.sdk.openadsdk.downloadnew.core.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static boolean f67449j;
    public static boolean k;
    public static boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public int B;
    public b.InterfaceC1902b C;
    public final c.p.a.a.a.d.e D;
    public a E;
    public List<ITTAppDownloadListener> F;
    public boolean G;
    public boolean H;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Context> f67450a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.e.b f67451b;

    /* renamed from: c  reason: collision with root package name */
    public final m f67452c;

    /* renamed from: d  reason: collision with root package name */
    public String f67453d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f67454e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f67455f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67456g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67457h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f67458i;
    public IListenerManager m;
    public int n;
    public c.p.a.a.a.d.b o;
    public c.p.a.a.a.d.c p;
    public c.p.a.a.a.d.d q;
    public boolean r;
    public final AtomicLong s;
    public final AtomicBoolean t;
    public WeakReference<View> u;
    public boolean v;
    public HashSet<Integer> w;
    public com.bytedance.sdk.openadsdk.downloadnew.core.c x;
    public final w y;
    public boolean z;

    /* loaded from: classes9.dex */
    public class a extends com.bytedance.sdk.component.d.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f67469a;

        /* renamed from: b  reason: collision with root package name */
        public long f67470b;

        /* renamed from: c  reason: collision with root package name */
        public long f67471c;

        /* renamed from: d  reason: collision with root package name */
        public String f67472d;

        /* renamed from: e  reason: collision with root package name */
        public String f67473e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f67474f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar) {
            super("DownloadCallbackRunnable");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67474f = dVar;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f67469a = str;
            }
        }

        public void b(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
                this.f67471c = j2;
            }
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f67473e = str;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                try {
                    this.f67474f.l().executeAppDownloadCallback(this.f67474f.A, this.f67469a, this.f67470b, this.f67471c, this.f67472d, this.f67473e);
                } catch (Throwable th) {
                    k.c("DMLibManager", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }

        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.f67470b = j2;
            }
        }

        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f67472d = str;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, String str, long j2, long j3, String str2, String str3) {
            super("DownloadCallbackRunnable");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, Long.valueOf(j2), Long.valueOf(j3), str2, str3};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f67474f = dVar;
            this.f67469a = str;
            this.f67470b = j2;
            this.f67471c = j3;
            this.f67472d = str2;
            this.f67473e = str3;
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1291766287, "Lcom/bytedance/sdk/openadsdk/downloadnew/a/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1291766287, "Lcom/bytedance/sdk/openadsdk/downloadnew/a/d;");
        }
    }

    public d(Context context, m mVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = -1;
        this.f67454e = new AtomicInteger(1);
        this.f67455f = new AtomicBoolean(false);
        this.f67456g = false;
        this.s = new AtomicLong();
        this.t = new AtomicBoolean(false);
        this.v = false;
        this.y = new w(Looper.getMainLooper(), this);
        this.z = true;
        this.f67457h = false;
        this.f67458i = true;
        this.D = new c.p.a.a.a.d.e(this) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f67459a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f67459a = this;
            }

            @Override // c.p.a.a.a.d.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f67459a.f67454e.set(1);
                    d.c("onIdle");
                    if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        if (this.f67459a.x != null) {
                            this.f67459a.x.onIdle();
                            return;
                        }
                        return;
                    }
                    this.f67459a.a("onIdle", 0L, 0L, (String) null, (String) null);
                }
            }

            @Override // c.p.a.a.a.d.e
            public void b(c.p.a.a.a.f.e eVar, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048581, this, eVar, i4) == null) {
                    this.f67459a.f67454e.set(4);
                    this.f67459a.f67455f.set(false);
                    this.f67459a.a(eVar.f34378a);
                    d.c("onDownloadPaused: " + eVar.f34380c + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar.f34381d);
                    if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        if (this.f67459a.x != null) {
                            this.f67459a.x.onDownloadPaused(eVar.f34380c, eVar.f34381d, eVar.f34382e, this.f67459a.f67451b.c());
                            return;
                        }
                        return;
                    }
                    d dVar = this.f67459a;
                    dVar.a("onDownloadPaused", eVar.f34380c, eVar.f34381d, eVar.f34382e, dVar.f67451b.c());
                }
            }

            @Override // c.p.a.a.a.d.e
            public void c(c.p.a.a.a.f.e eVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048582, this, eVar) == null) {
                    this.f67459a.f67454e.set(6);
                    this.f67459a.a(eVar.f34378a);
                    d.c("onDownloadFinished: " + eVar.f34380c + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar.f34381d);
                    if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        if (this.f67459a.x != null) {
                            this.f67459a.x.onDownloadFinished(eVar.f34380c, eVar.f34382e, this.f67459a.f67451b.c());
                            return;
                        }
                        return;
                    }
                    d dVar = this.f67459a;
                    dVar.a("onDownloadFinished", eVar.f34380c, eVar.f34381d, eVar.f34382e, dVar.f67451b.c());
                }
            }

            @Override // c.p.a.a.a.d.e
            public void a(@NonNull c.p.a.a.a.d.d dVar, @Nullable c.p.a.a.a.d.b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, bVar) == null) {
                    this.f67459a.f67454e.set(2);
                    d.c("onDownloadStart: " + dVar.d());
                    this.f67459a.a(dVar.d());
                    if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        if (this.f67459a.x != null) {
                            this.f67459a.x.onIdle();
                            return;
                        }
                        return;
                    }
                    this.f67459a.a("onIdle", 0L, 0L, (String) null, (String) null);
                }
            }

            @Override // c.p.a.a.a.d.e
            public void b(c.p.a.a.a.f.e eVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048580, this, eVar) == null) {
                    this.f67459a.f67454e.set(7);
                    this.f67459a.f67455f.set(true);
                    this.f67459a.a(eVar.f34378a);
                    d.c("onInstalled: " + eVar.f34380c + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar.f34381d);
                    String str2 = !TextUtils.isEmpty(eVar.f34382e) ? eVar.f34382e : "";
                    if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        if (this.f67459a.x != null) {
                            this.f67459a.x.onInstalled(str2, this.f67459a.f67451b.c());
                            return;
                        }
                        return;
                    }
                    d dVar = this.f67459a;
                    dVar.a("onInstalled", eVar.f34380c, eVar.f34381d, str2, dVar.f67451b.c());
                }
            }

            @Override // c.p.a.a.a.d.e
            public void a(c.p.a.a.a.f.e eVar, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048579, this, eVar, i4) == null) {
                    this.f67459a.f67454e.set(3);
                    this.f67459a.f67455f.set(false);
                    this.f67459a.a(eVar.f34378a);
                    d.c("onDownloadActive: " + eVar.f34380c + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar.f34381d);
                    if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        if (this.f67459a.x != null) {
                            this.f67459a.x.onDownloadActive(eVar.f34380c, eVar.f34381d, eVar.f34382e, this.f67459a.f67451b.c());
                            return;
                        }
                        return;
                    }
                    d dVar = this.f67459a;
                    dVar.a("onDownloadActive", eVar.f34380c, eVar.f34381d, eVar.f34382e, dVar.f67451b.c());
                }
            }

            @Override // c.p.a.a.a.d.e
            public void a(c.p.a.a.a.f.e eVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
                    this.f67459a.f67454e.set(5);
                    this.f67459a.a(eVar.f34378a);
                    d.c("onDownloadFailed: " + eVar.f34380c + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar.f34381d);
                    if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        if (this.f67459a.x != null) {
                            this.f67459a.x.onDownloadFailed(eVar.f34380c, eVar.f34381d, eVar.f34382e, this.f67459a.f67451b.c());
                            return;
                        }
                        return;
                    }
                    d dVar = this.f67459a;
                    dVar.a("onDownloadFailed", eVar.f34380c, eVar.f34381d, eVar.f34382e, dVar.f67451b.c());
                }
            }
        };
        this.E = new a(this);
        this.F = new CopyOnWriteArrayList();
        this.G = false;
        this.H = true;
        this.f67450a = new WeakReference<>(context);
        this.f67452c = mVar;
        this.f67451b = mVar.al();
        this.f67453d = str;
        this.n = q.c(mVar.ao());
        this.A = com.bytedance.sdk.component.utils.e.a(this.f67452c.hashCode() + this.f67452c.aP().toString());
        c("====tag===" + str);
        if (this.f67451b == null) {
            k.f("DMLibManager", "download create error: not a App type Ad!");
            return;
        }
        if (o.a() == null) {
            o.a(context);
        }
        this.x = new com.bytedance.sdk.openadsdk.downloadnew.core.c();
        this.q = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.f67453d, this.f67452c, null).h();
        this.o = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.f67452c).d();
        this.p = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.f67452c, this.f67453d).d();
        a();
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            c("tryReleaseResource==");
            WeakReference<Context> weakReference = this.f67450a;
            if (weakReference == null) {
                c("tryReleaseResource==  mContext is null");
                return;
            }
            Activity activity = weakReference.get() instanceof Activity ? (Activity) this.f67450a.get() : null;
            if (activity == null) {
                c("tryReleaseResource==  activity is null");
            } else if (h.d().a(activity)) {
                c("tryReleaseResource==  isActivityAlive is true");
            } else {
                y();
            }
        }
    }

    private synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            synchronized (this) {
                c("unbindDownload==" + this.t.get());
                if (this.f67451b == null) {
                    return;
                }
                if (this.t.get()) {
                    this.t.set(false);
                    g.d().g(this.q.a(), hashCode());
                }
                p();
            }
        }
    }

    private synchronized void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            synchronized (this) {
                c("bindDownload==" + this.t.get());
                if (this.f67451b == null) {
                    return;
                }
                this.t.get();
                this.t.set(true);
                g.d().e(m(), hashCode(), this.D, this.q);
            }
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || m() == null || this.f67451b == null) {
            return;
        }
        if (!this.f67452c.w() && g.a(m(), this.f67451b.b())) {
            c("changeDownloadStatus, not support pause/continue function");
            try {
                Toast.makeText(m(), "应用正在下载...", 0).show();
            } catch (Exception unused) {
            }
        } else if (t()) {
            if (a(this.f67452c)) {
                a(this.f67452c, new b(this) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ d f67460a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f67460a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d.b
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            g.d().h(this.f67460a.f67451b.b(), this.f67460a.q.d(), 2, this.f67460a.p, this.f67460a.o);
                        }
                    }
                });
            } else {
                g.d().h(this.f67451b.b(), this.q.d(), 2, this.p, this.o);
            }
        } else {
            c("changeDownloadStatus, the current status is1: " + this.f67454e);
            g.d().i(this.f67451b.b(), this.q.d(), 2, this.p, this.o, null, new n(this) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67461a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67461a = this;
                }

                @Override // c.p.a.a.a.c.n
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        if (z) {
                            d dVar = this.f67461a;
                            if (dVar.a(dVar.f67452c)) {
                                d dVar2 = this.f67461a;
                                dVar2.a(dVar2.f67452c, new b(this) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.3.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass3 f67462a;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f67462a = this;
                                    }

                                    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d.b
                                    public void a() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            g.d().h(this.f67462a.f67461a.f67451b.b(), this.f67462a.f67461a.q.d(), 2, this.f67462a.f67461a.p, this.f67462a.f67461a.o);
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.d().h(this.f67461a.f67451b.b(), this.f67461a.q.d(), 2, this.f67461a.p, this.f67461a.o);
                    }
                }
            });
            c("changeDownloadStatus, the current status is2: " + this.f67454e);
        }
    }

    private boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            m mVar = this.f67452c;
            if (mVar == null) {
                return false;
            }
            return mVar.X() == 4 && !TextUtils.isEmpty(this.f67452c.ax());
        }
        return invokeV.booleanValue;
    }

    private boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
            if (this.f67451b == null || !h()) {
                return false;
            }
            boolean a2 = a(m(), this.f67451b.a(), this.f67452c, this.f67453d, this.f67457h);
            if (a2) {
                Message obtain = Message.obtain();
                obtain.what = 9;
                this.y.sendMessageDelayed(obtain, 3000L);
            } else {
                h(false);
            }
            return a2;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("download_type", this.B);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    private void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            x();
            this.f67455f.set(true);
        }
    }

    private void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            e();
        }
    }

    private void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            k.f("DMLibManager", hashCode() + "unregisterMultiProcessListener, mMetaMd5:" + this.A);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.component.d.e.c().execute(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ d f67468a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f67468a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            IListenerManager asInterface = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(o.a()).a(3));
                            try {
                                synchronized (this.f67468a.F) {
                                    k.f("DMLibManager", "unregisterMultiProcessListener, mTTAppDownloadListenerList size:" + this.f67468a.F.size());
                                    if (asInterface != null && this.f67468a.F.size() > 0) {
                                        for (ITTAppDownloadListener iTTAppDownloadListener : this.f67468a.F) {
                                            asInterface.unregisterTTAppDownloadListener(this.f67468a.A, iTTAppDownloadListener);
                                        }
                                        this.f67468a.F.clear();
                                    }
                                }
                            } catch (RemoteException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
            }
        }
    }

    private void z() {
        com.bytedance.sdk.openadsdk.core.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65569, this) == null) || (bVar = this.f67451b) == null || bVar.b() == null) {
            return;
        }
        i();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.f67454e.get() == 1) {
                if (com.bytedance.sdk.component.utils.n.c(m()) == 0) {
                    try {
                        Toast.makeText(m(), t.b(m(), "tt_no_network"), 0).show();
                        return true;
                    } catch (Exception unused) {
                        return true;
                    }
                }
                if (q.k(m())) {
                    n();
                }
                w();
                return true;
            }
            if (q.k(m())) {
                n();
            }
            e();
            if (this.f67454e.get() != 3 && this.f67454e.get() != 4) {
                if (this.f67454e.get() == 6) {
                    this.f67455f.set(true);
                }
            } else {
                this.f67455f.set(false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            com.bytedance.sdk.openadsdk.core.e.b bVar = this.f67451b;
            boolean z = false;
            if (bVar == null) {
                return false;
            }
            String d2 = bVar.d();
            if (!TextUtils.isEmpty(d2) && a(m(), d2)) {
                z = true;
                this.f67455f.set(true);
                if (!a(this.f67453d, "click_open", this.f67452c)) {
                    com.bytedance.sdk.openadsdk.e.d.i(m(), this.f67452c, this.f67453d, q.h(this.f67452c), null);
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.f67452c.an() != null) {
                String a2 = this.f67452c.an().a();
                k.b("DMLibManager", "含有deeplink链接 " + this.f67457h);
                k.b("deepLink", "DMLibManager 含有deeplink链接尝试deeplink调起 " + this.f67457h);
                if (!TextUtils.isEmpty(a2)) {
                    Uri parse = Uri.parse(a2);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(parse);
                    if (this.f67457h) {
                        k.b("DMLibManager", "含有deeplink链接，开始上报 lp_open_dpl schema " + a(a2));
                        com.bytedance.sdk.openadsdk.e.d.a(m(), this.f67452c, this.f67453d, "lp_open_dpl", a(a2));
                    }
                    if (q.a(m(), intent)) {
                        k.b("DMLibManager", "含有deeplink链接， 该app已安装 ");
                        if (!(m() instanceof Activity)) {
                            intent.addFlags(268435456);
                        }
                        try {
                            n();
                            if (!a(this.f67453d, "open_url_app", this.f67452c)) {
                                com.bytedance.sdk.openadsdk.e.d.h(m(), this.f67452c, this.f67453d, "open_url_app", null);
                            }
                            m().startActivity(intent);
                            com.bytedance.sdk.openadsdk.e.k.a().a(this.f67452c, this.f67453d, this.f67457h);
                            if (this.f67457h) {
                                k.b("DMLibManager", "含有deeplink链接， 该app已安装，进行开始调起上报 lp_openurl ");
                                com.bytedance.sdk.openadsdk.e.d.b(m(), this.f67452c, this.f67453d, "lp_openurl");
                                com.bytedance.sdk.openadsdk.e.d.b(o.a(), this.f67452c, this.f67453d, "lp_deeplink_success_realtime");
                            } else {
                                com.bytedance.sdk.openadsdk.e.d.b(o.a(), this.f67452c, this.f67453d, "deeplink_success_realtime");
                            }
                            return true;
                        } catch (Throwable unused) {
                            if (!TextUtils.isEmpty(this.f67452c.Z())) {
                                z.a(m(), this.f67452c.Z(), this.f67452c, q.a(this.f67453d), this.f67453d, true, null);
                            }
                            if (this.f67457h) {
                                k.b("DMLibManager", "含有deeplink链接， 该app已安装，调起失败 上报lp_openurl_failed ");
                                com.bytedance.sdk.openadsdk.e.d.b(m(), this.f67452c, this.f67453d, "lp_openurl_failed");
                                com.bytedance.sdk.openadsdk.e.d.b(o.a(), this.f67452c, this.f67453d, "lp_deeplink_fail_realtime");
                            } else {
                                com.bytedance.sdk.openadsdk.e.d.b(o.a(), this.f67452c, this.f67453d, "deeplink_fail_realtime");
                            }
                            return false;
                        }
                    } else if (this.f67457h) {
                        k.b("DMLibManager", "含有deeplink链接， 该app未安装，上报lp_openurl_failed ");
                        com.bytedance.sdk.openadsdk.e.d.b(m(), this.f67452c, this.f67453d, "lp_openurl_failed");
                        com.bytedance.sdk.openadsdk.e.d.b(o.a(), this.f67452c, this.f67453d, "lp_deeplink_fail_realtime");
                    } else {
                        com.bytedance.sdk.openadsdk.e.d.b(o.a(), this.f67452c, this.f67453d, "deeplink_fail_realtime");
                    }
                }
                if (this.f67454e.get() != 4 && this.f67454e.get() != 3 && (!this.f67456g || this.f67455f.get())) {
                    this.f67456g = true;
                    if (!a(this.f67453d, "open_fallback_url", this.f67452c)) {
                        com.bytedance.sdk.openadsdk.e.d.h(m(), this.f67452c, this.f67453d, "open_fallback_url", null);
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public IListenerManager l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.m == null) {
                this.m = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(o.a()).a(3));
            }
            return this.m;
        }
        return (IListenerManager) invokeV.objValue;
    }

    public Context m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            WeakReference<Context> weakReference = this.f67450a;
            return (weakReference == null || weakReference.get() == null) ? o.a() : this.f67450a.get();
        }
        return (Context) invokeV.objValue;
    }

    public void n() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (mVar = this.f67452c) == null || !mVar.az() || this.f67457h || TTMiddlePageActivity.a(this.f67452c)) {
            return;
        }
        q.a(this.f67452c, this.f67453d);
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            k.b("DMLibManager", str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            com.bytedance.sdk.openadsdk.downloadnew.core.c cVar = this.x;
            if (cVar != null) {
                cVar.a();
            }
            q();
            HashSet<Integer> hashSet = this.w;
            if (hashSet != null) {
                Iterator<Integer> it = hashSet.iterator();
                while (it.hasNext()) {
                    g.a(it.next().intValue());
                    it.remove();
                }
            }
            WeakReference<Context> weakReference = this.f67450a;
            if (weakReference != null) {
                weakReference.clear();
                this.f67450a = null;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            s();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            b(0L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || m() == null) {
            return;
        }
        if (!"feed_video_middle_page".equals(this.f67453d)) {
            TTMiddlePageActivity.b(m(), this.f67452c);
        }
        if (k()) {
            this.f67455f.set(true);
        } else if (this.f67452c.al() == null && this.f67452c.Z() != null) {
            z.a(m(), this.f67452c.Z(), this.f67452c, q.a(this.f67453d), this.f67453d, true, null);
        } else if (j()) {
        } else {
            if (u()) {
                this.f67455f.set(true);
            } else if (b(this.z)) {
                this.f67455f.set(true);
            } else {
                z();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            m mVar = this.f67452c;
            return (mVar == null || mVar.R() == null || this.f67451b == null || this.f67452c.R().b() != 3 || this.f67451b.a() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (o.a() == null) {
                o.a(m());
            }
            this.r = true;
            r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.r = false;
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.H = z;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f67457h = z;
        }
    }

    private void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65557, this, z) == null) {
            if (z) {
                com.bytedance.sdk.openadsdk.e.d.a(m(), this.f67452c, this.f67453d, "quickapp_success");
            } else {
                com.bytedance.sdk.openadsdk.e.d.a(m(), this.f67452c, this.f67453d, "quickapp_fail");
            }
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.v = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j2, long j3, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), str2, str3}) == null) {
            a aVar = this.E;
            if (aVar == null) {
                this.E = new a(this, str, j2, j3, str2, str3);
            } else {
                aVar.a(str);
                this.E.a(j2);
                this.E.b(j3);
                this.E.b(str2);
                this.E.c(str3);
            }
            com.bytedance.sdk.component.d.e.c().execute(this.E);
        }
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048590, this, j2) == null) || this.f67451b == null) {
            return;
        }
        this.t.set(false);
        g.d().j(this.q.a(), true);
        r();
    }

    private void b(TTAppDownloadListener tTAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, tTAppDownloadListener) == null) {
            k.f("DMLibManager", hashCode() + "registerMultiProcessListener, mMetaMd5:" + this.A);
            if (!com.bytedance.sdk.openadsdk.multipro.b.b() || tTAppDownloadListener == null) {
                return;
            }
            com.bytedance.sdk.component.d.e.c().execute(new Runnable(this, tTAppDownloadListener) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAppDownloadListener f67466a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f67467b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, tTAppDownloadListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67467b = this;
                    this.f67466a = tTAppDownloadListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(o.a());
                        com.bytedance.sdk.openadsdk.multipro.aidl.b.e eVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.e(this.f67466a);
                        IListenerManager asInterface = IListenerManager.Stub.asInterface(a2.a(3));
                        if (asInterface != null) {
                            try {
                                asInterface.registerTTAppDownloadListener(this.f67467b.A, eVar);
                                synchronized (this.f67467b.F) {
                                    this.f67467b.F.add(eVar);
                                    k.f("DMLibManager", "registerMultiProcessListener, mTTAppDownloadListenerList size:" + this.f67467b.F.size());
                                }
                            } catch (RemoteException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            r();
            o();
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.G = z;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            k.f("DMLibManager", "setActivity==activity:" + activity.getLocalClassName());
            if (activity == null) {
                return;
            }
            this.f67450a = new WeakReference<>(activity);
            r();
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.f67458i = z;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view) == null) || view == null) {
            return;
        }
        this.u = new WeakReference<>(view);
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            this.s.set(j2);
        }
    }

    public static boolean a(Context context, String str, m mVar, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, str, mVar, str2, Boolean.valueOf(z)})) == null) {
            if (context == null) {
                return false;
            }
            try {
                if (mVar.az() && !z) {
                    q.a(mVar, str2);
                }
                Uri parse = Uri.parse(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.addFlags(268435456);
                intent.putExtra("open_url", str);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            this.z = z;
            return u();
        }
        return invokeZ.booleanValue;
    }

    private boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i2)) == null) {
            int f2 = o.h().f();
            if (f2 != -1) {
                if (f2 != 0) {
                    if (f2 != 2) {
                        if (f2 != 3) {
                            if (h.d().b(i2)) {
                                return false;
                            }
                            int i3 = 104857600;
                            com.bytedance.sdk.openadsdk.core.e.b bVar = this.f67451b;
                            if (bVar != null && bVar.g() > 0) {
                                i3 = this.f67451b.g();
                            }
                            if (i3 <= o.h().g()) {
                                return false;
                            }
                        }
                    } else if (i2 == 4) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return !h.d().b(i2);
        }
        return invokeI.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, mVar)) == null) {
            if (mVar == null) {
                return true;
            }
            if (this.f67458i) {
                int c2 = com.bytedance.sdk.component.utils.n.c(m());
                if (c2 == 0) {
                    try {
                        Toast.makeText(m(), t.b(m(), "tt_no_network"), 0).show();
                    } catch (Exception unused) {
                    }
                }
                boolean a2 = a(c2);
                boolean z = mVar.B() == 0;
                boolean z2 = mVar.C() == 0;
                boolean z3 = mVar.C() == 2;
                boolean z4 = mVar.D() == 0;
                if (t()) {
                    if (this.f67457h || z3) {
                        return false;
                    }
                    this.B = 2;
                    if (z2) {
                        return a2;
                    }
                    return true;
                } else if (this.f67457h) {
                    if (z4) {
                        return false;
                    }
                    this.B = 3;
                    return true;
                } else {
                    this.B = 1;
                    if (z) {
                        return a2;
                    }
                    if (mVar.B() == 2 && this.G && !this.H) {
                        return a2;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, this, mVar, bVar) == null) || mVar == null) {
            return;
        }
        String U = mVar.U();
        String a2 = f.a(mVar);
        l Y = mVar.Y();
        String a3 = Y != null ? Y.a() : "";
        boolean z = mVar.X() == 4;
        com.bytedance.sdk.openadsdk.e.d.b(o.a(), mVar, this.f67453d, "pop_up", v());
        f67449j = true;
        l = true;
        com.bytedance.sdk.openadsdk.q.c.a(m(), mVar.ak(), U, new c.a(this, bVar, mVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f67463a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ m f67464b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d f67465c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, bVar, mVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67465c = this;
                this.f67463a = bVar;
                this.f67464b = mVar;
            }

            @Override // com.bytedance.sdk.openadsdk.q.c.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    b bVar2 = this.f67463a;
                    if (bVar2 != null) {
                        bVar2.a();
                    }
                    Context a4 = o.a();
                    m mVar2 = this.f67464b;
                    d dVar = this.f67465c;
                    com.bytedance.sdk.openadsdk.e.d.b(a4, mVar2, dVar.f67453d, "pop_up_download", dVar.v());
                    d.k = true;
                    if (this.f67465c.C != null) {
                        this.f67465c.C.a();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.c.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.c.a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    Context a4 = o.a();
                    m mVar2 = this.f67464b;
                    d dVar = this.f67465c;
                    com.bytedance.sdk.openadsdk.e.d.b(a4, mVar2, dVar.f67453d, "pop_up_cancel", dVar.v());
                    if (this.f67465c.C != null) {
                        this.f67465c.C.b();
                    }
                }
            }
        }, a2, a3, z);
    }

    public boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                k.b("DMLibManager", "使用包名调起 " + this.f67457h);
                if (this.f67457h) {
                    k.b("DMLibManager", "使用包名调起， 开始上报 lp_open_dpl packageName " + str);
                    com.bytedance.sdk.openadsdk.e.d.a(m(), this.f67452c, this.f67453d, "lp_open_dpl", str);
                }
                try {
                    if (q.c(context, str)) {
                        try {
                            Intent b2 = q.b(context, str);
                            if (b2 == null) {
                                return false;
                            }
                            n();
                            b2.putExtra("START_ONLY_FOR_ANDROID", true);
                            context.startActivity(b2);
                            if (this.f67457h) {
                                k.b("DMLibManager", "使用包名调起，开始调起，上报 lp_openurl ");
                                com.bytedance.sdk.openadsdk.e.d.b(m(), this.f67452c, this.f67453d, "lp_openurl");
                            }
                            if (this.f67457h) {
                                com.bytedance.sdk.openadsdk.e.k.a().a(this.f67452c, this.f67453d, true);
                            }
                            return true;
                        } catch (Exception unused) {
                            if (this.f67452c.Z() != null) {
                                z.a(m(), this.f67452c.Z(), this.f67452c, q.a(this.f67453d), this.f67453d, true, null);
                            }
                            if (this.f67457h) {
                                k.b("DMLibManager", "使用包名调起，开始调起，调起异常，上报 lp_openurl_failed ");
                                com.bytedance.sdk.openadsdk.e.d.b(m(), this.f67452c, this.f67453d, "lp_openurl_failed");
                            }
                            return true;
                        }
                    } else if (this.f67457h) {
                        k.b("DMLibManager", "使用包名调起，该app未安装 ，上报 lp_openurl_failed ");
                        com.bytedance.sdk.openadsdk.e.d.b(m(), this.f67452c, this.f67453d, "lp_openurl_failed");
                    }
                } catch (Throwable unused2) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean a(String str, String str2, m mVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, str, str2, mVar)) == null) ? g.a(str, str2, mVar, (Object) 1) : invokeLLL.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(TTAppDownloadListener tTAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, tTAppDownloadListener) == null) {
            a(tTAppDownloadListener, true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(TTAppDownloadListener tTAppDownloadListener, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, tTAppDownloadListener, z) == null) || tTAppDownloadListener == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.c cVar = this.x;
        if (cVar != null) {
            cVar.a(tTAppDownloadListener);
        }
        if (z) {
            b(tTAppDownloadListener);
        }
        r();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(int i2, a.InterfaceC1916a interfaceC1916a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, interfaceC1916a) == null) {
            if (this.w == null) {
                this.w = new HashSet<>();
            }
            this.w.add(Integer.valueOf(i2));
            g.a(i2, interfaceC1916a);
        }
    }

    @Override // com.bytedance.sdk.component.utils.w.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, message) == null) && message.what == 9) {
            if (h.d() != null && !h.d().a()) {
                h(false);
                boolean z = this.z;
                if (!z || b(z)) {
                    return;
                }
                z();
                return;
            }
            h(true);
        }
    }

    public void a(b.InterfaceC1902b interfaceC1902b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, interfaceC1902b) == null) {
            this.C = interfaceC1902b;
        }
    }

    public String a(String str) {
        InterceptResult invokeL;
        Uri parse;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || TextUtils.isEmpty(parse.getScheme())) ? "" : parse.getScheme().toLowerCase() : (String) invokeL.objValue;
    }
}
