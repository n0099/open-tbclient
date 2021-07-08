package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
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
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.activity.base.TTMiddlePageActivity;
import com.bytedance.sdk.openadsdk.core.e.l;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.e.k;
import com.bytedance.sdk.openadsdk.r.b;
import com.bytedance.sdk.openadsdk.r.o;
import d.l.a.a.a.c.n;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d implements u.a, com.bytedance.sdk.openadsdk.downloadnew.core.a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean j;
    public static boolean k;
    public static boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public int B;
    public final d.l.a.a.a.d.e C;
    public a D;
    public List<ITTAppDownloadListener> E;
    public boolean F;
    public boolean G;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Context> f31128a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.e.b f31129b;

    /* renamed from: c  reason: collision with root package name */
    public final m f31130c;

    /* renamed from: d  reason: collision with root package name */
    public String f31131d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f31132e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f31133f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31134g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f31135h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f31136i;
    public IListenerManager m;
    public int n;
    public d.l.a.a.a.d.b o;
    public d.l.a.a.a.d.c p;
    public d.l.a.a.a.d.d q;
    public boolean r;
    public final AtomicLong s;
    public final AtomicBoolean t;
    public WeakReference<View> u;
    public boolean v;
    public HashSet<Integer> w;
    public com.bytedance.sdk.openadsdk.downloadnew.core.c x;
    public final u y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class a extends com.bytedance.sdk.component.e.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f31147a;

        /* renamed from: b  reason: collision with root package name */
        public long f31148b;

        /* renamed from: c  reason: collision with root package name */
        public long f31149c;

        /* renamed from: d  reason: collision with root package name */
        public String f31150d;

        /* renamed from: e  reason: collision with root package name */
        public String f31151e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f31152f;

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
            this.f31152f = dVar;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f31147a = str;
            }
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                this.f31149c = j;
            }
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f31151e = str;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                try {
                    this.f31152f.l().executeAppDownloadCallback(this.f31152f.A, this.f31147a, this.f31148b, this.f31149c, this.f31150d, this.f31151e);
                } catch (Throwable th) {
                    j.c("DMLibManager", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }

        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f31148b = j;
            }
        }

        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f31150d = str;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, String str, long j, long j2, String str2, String str3) {
            super("DownloadCallbackRunnable");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, Long.valueOf(j), Long.valueOf(j2), str2, str3};
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
            this.f31152f = dVar;
            this.f31147a = str;
            this.f31148b = j;
            this.f31149c = j2;
            this.f31150d = str2;
            this.f31151e = str3;
        }
    }

    /* loaded from: classes5.dex */
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
        this.f31132e = new AtomicInteger(1);
        this.f31133f = new AtomicBoolean(false);
        this.f31134g = false;
        this.s = new AtomicLong();
        this.t = new AtomicBoolean(false);
        this.v = false;
        this.y = new u(Looper.getMainLooper(), this);
        this.z = true;
        this.f31135h = false;
        this.f31136i = true;
        this.C = new d.l.a.a.a.d.e(this) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f31137a;

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
                this.f31137a = this;
            }

            @Override // d.l.a.a.a.d.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f31137a.f31132e.set(1);
                    d.c("onIdle");
                    if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        if (this.f31137a.x != null) {
                            this.f31137a.x.onIdle();
                            return;
                        }
                        return;
                    }
                    this.f31137a.a("onIdle", 0L, 0L, (String) null, (String) null);
                }
            }

            @Override // d.l.a.a.a.d.e
            public void b(d.l.a.a.a.f.e eVar, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048581, this, eVar, i4) == null) {
                    this.f31137a.f31132e.set(4);
                    this.f31137a.f31133f.set(false);
                    this.f31137a.a(eVar.f71134a);
                    d.c("onDownloadPaused: " + eVar.f71136c + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar.f71137d);
                    if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        if (this.f31137a.x != null) {
                            this.f31137a.x.onDownloadPaused(eVar.f71136c, eVar.f71137d, eVar.f71138e, this.f31137a.f31129b.c());
                            return;
                        }
                        return;
                    }
                    d dVar = this.f31137a;
                    dVar.a("onDownloadPaused", eVar.f71136c, eVar.f71137d, eVar.f71138e, dVar.f31129b.c());
                }
            }

            @Override // d.l.a.a.a.d.e
            public void c(d.l.a.a.a.f.e eVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048582, this, eVar) == null) {
                    this.f31137a.f31132e.set(6);
                    this.f31137a.a(eVar.f71134a);
                    d.c("onDownloadFinished: " + eVar.f71136c + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar.f71137d);
                    if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        if (this.f31137a.x != null) {
                            this.f31137a.x.onDownloadFinished(eVar.f71136c, eVar.f71138e, this.f31137a.f31129b.c());
                            return;
                        }
                        return;
                    }
                    d dVar = this.f31137a;
                    dVar.a("onDownloadFinished", eVar.f71136c, eVar.f71137d, eVar.f71138e, dVar.f31129b.c());
                }
            }

            @Override // d.l.a.a.a.d.e
            public void a(@NonNull d.l.a.a.a.d.d dVar, @Nullable d.l.a.a.a.d.b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, bVar) == null) {
                    this.f31137a.f31132e.set(2);
                    d.c("onDownloadStart: " + dVar.d());
                    this.f31137a.a(dVar.d());
                    if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        if (this.f31137a.x != null) {
                            this.f31137a.x.onIdle();
                            return;
                        }
                        return;
                    }
                    this.f31137a.a("onIdle", 0L, 0L, (String) null, (String) null);
                }
            }

            @Override // d.l.a.a.a.d.e
            public void b(d.l.a.a.a.f.e eVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048580, this, eVar) == null) {
                    this.f31137a.f31132e.set(7);
                    this.f31137a.f31133f.set(true);
                    this.f31137a.a(eVar.f71134a);
                    d.c("onInstalled: " + eVar.f71136c + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar.f71137d);
                    if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        if (this.f31137a.x != null) {
                            this.f31137a.x.onInstalled(eVar.f71138e, this.f31137a.f31129b.c());
                            return;
                        }
                        return;
                    }
                    d dVar = this.f31137a;
                    dVar.a("onInstalled", eVar.f71136c, eVar.f71137d, eVar.f71138e, dVar.f31129b.c());
                }
            }

            @Override // d.l.a.a.a.d.e
            public void a(d.l.a.a.a.f.e eVar, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048579, this, eVar, i4) == null) {
                    this.f31137a.f31132e.set(3);
                    this.f31137a.f31133f.set(false);
                    this.f31137a.a(eVar.f71134a);
                    d.c("onDownloadActive: " + eVar.f71136c + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar.f71137d);
                    if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        if (this.f31137a.x != null) {
                            this.f31137a.x.onDownloadActive(eVar.f71136c, eVar.f71137d, eVar.f71138e, this.f31137a.f31129b.c());
                            return;
                        }
                        return;
                    }
                    d dVar = this.f31137a;
                    dVar.a("onDownloadActive", eVar.f71136c, eVar.f71137d, eVar.f71138e, dVar.f31129b.c());
                }
            }

            @Override // d.l.a.a.a.d.e
            public void a(d.l.a.a.a.f.e eVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
                    this.f31137a.f31132e.set(5);
                    this.f31137a.a(eVar.f71134a);
                    d.c("onDownloadFailed: " + eVar.f71136c + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar.f71137d);
                    if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        if (this.f31137a.x != null) {
                            this.f31137a.x.onDownloadFailed(eVar.f71136c, eVar.f71137d, eVar.f71138e, this.f31137a.f31129b.c());
                            return;
                        }
                        return;
                    }
                    d dVar = this.f31137a;
                    dVar.a("onDownloadFailed", eVar.f71136c, eVar.f71137d, eVar.f71138e, dVar.f31129b.c());
                }
            }
        };
        this.D = new a(this);
        this.E = new CopyOnWriteArrayList();
        this.F = false;
        this.G = true;
        this.f31128a = new WeakReference<>(context);
        this.f31130c = mVar;
        this.f31129b = mVar.al();
        this.f31131d = str;
        this.n = o.c(mVar.ao());
        this.A = com.bytedance.sdk.component.utils.e.a(this.f31130c.hashCode() + this.f31130c.aO().toString());
        c("====tag===" + str);
        if (this.f31129b == null) {
            j.f("DMLibManager", "download create error: not a App type Ad!");
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.o.a() == null) {
            com.bytedance.sdk.openadsdk.core.o.a(context);
        }
        this.x = new com.bytedance.sdk.openadsdk.downloadnew.core.c();
        this.q = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.f31131d, this.f31130c, null).h();
        this.o = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.f31130c).d();
        this.p = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(this.f31130c, this.f31131d).d();
        a();
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            c("tryReleaseResource==");
            WeakReference<Context> weakReference = this.f31128a;
            if (weakReference == null) {
                c("tryReleaseResource==  mContext is null");
                return;
            }
            Activity activity = weakReference.get() instanceof Activity ? (Activity) this.f31128a.get() : null;
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
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            synchronized (this) {
                c("unbindDownload==" + this.t.get());
                if (this.f31129b == null) {
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
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            synchronized (this) {
                c("bindDownload==" + this.t.get());
                if (this.f31129b == null) {
                    return;
                }
                this.t.get();
                this.t.set(true);
                g.d().e(m(), hashCode(), this.C, this.q);
            }
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || m() == null || this.f31129b == null) {
            return;
        }
        TTCustomController f2 = h.d().f();
        if (f2 != null && !f2.isCanUseWriteExternal()) {
            try {
                String str = g.f31162a;
                String absolutePath = Environment.getDataDirectory().getAbsolutePath();
                if (str != null) {
                    if (!str.startsWith(absolutePath)) {
                        return;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        if (!this.f31130c.w() && g.a(m(), this.f31129b.b())) {
            c("changeDownloadStatus, not support pause/continue function");
            try {
                Toast.makeText(m(), "应用正在下载...", 0).show();
            } catch (Exception unused2) {
            }
        } else if (t()) {
            if (a(this.f31130c)) {
                a(this.f31130c, new b(this) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ d f31138a;

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
                        this.f31138a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d.b
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            g.d().h(this.f31138a.f31129b.b(), this.f31138a.q.d(), 2, this.f31138a.p, this.f31138a.o);
                        }
                    }
                });
            } else {
                g.d().h(this.f31129b.b(), this.q.d(), 2, this.p, this.o);
            }
        } else {
            c("changeDownloadStatus, the current status is1: " + this.f31132e);
            g.d().i(this.f31129b.b(), this.q.d(), 2, this.p, this.o, null, new n(this) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f31139a;

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
                    this.f31139a = this;
                }

                @Override // d.l.a.a.a.c.n
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        if (z) {
                            d dVar = this.f31139a;
                            if (dVar.a(dVar.f31130c)) {
                                d dVar2 = this.f31139a;
                                dVar2.a(dVar2.f31130c, new b(this) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.3.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass3 f31140a;

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
                                        this.f31140a = this;
                                    }

                                    @Override // com.bytedance.sdk.openadsdk.downloadnew.a.d.b
                                    public void a() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            g.d().h(this.f31140a.f31139a.f31129b.b(), this.f31140a.f31139a.q.d(), 2, this.f31140a.f31139a.p, this.f31140a.f31139a.o);
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.d().h(this.f31139a.f31129b.b(), this.f31139a.q.d(), 2, this.f31139a.p, this.f31139a.o);
                    }
                }
            });
            c("changeDownloadStatus, the current status is2: " + this.f31132e);
        }
    }

    private boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            m mVar = this.f31130c;
            if (mVar == null) {
                return false;
            }
            return mVar.X() == 4 && !TextUtils.isEmpty(this.f31130c.ax());
        }
        return invokeV.booleanValue;
    }

    private boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            if (this.f31129b == null || !h()) {
                return false;
            }
            boolean a2 = a(m(), this.f31129b.a(), this.f31130c, this.f31131d, this.f31135h);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            x();
            this.f31133f.set(true);
        }
    }

    private void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            e();
        }
    }

    private void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            j.f("DMLibManager", hashCode() + "unregisterMultiProcessListener, mMetaMd5:" + this.A);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.component.e.e.c().execute(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ d f31146a;

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
                        this.f31146a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            IListenerManager asInterface = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(com.bytedance.sdk.openadsdk.core.o.a()).a(3));
                            try {
                                synchronized (this.f31146a.E) {
                                    j.f("DMLibManager", "unregisterMultiProcessListener, mTTAppDownloadListenerList size:" + this.f31146a.E.size());
                                    if (asInterface != null && this.f31146a.E.size() > 0) {
                                        for (ITTAppDownloadListener iTTAppDownloadListener : this.f31146a.E) {
                                            asInterface.unregisterTTAppDownloadListener(this.f31146a.A, iTTAppDownloadListener);
                                        }
                                        this.f31146a.E.clear();
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
        if (!(interceptable == null || interceptable.invokeV(65568, this) == null) || (bVar = this.f31129b) == null || bVar.b() == null) {
            return;
        }
        i();
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            m mVar = this.f31130c;
            return (mVar == null || mVar.R() == null || this.f31129b == null || this.f31130c.R().b() != 3 || this.f31129b.a() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.f31132e.get() == 1) {
                if (com.bytedance.sdk.component.utils.m.c(m()) == 0) {
                    try {
                        Toast.makeText(m(), r.b(m(), "tt_no_network"), 0).show();
                        return true;
                    } catch (Exception unused) {
                        return true;
                    }
                }
                if (o.k(m())) {
                    n();
                }
                w();
                return true;
            }
            if (o.k(m())) {
                n();
            }
            e();
            if (this.f31132e.get() != 3 && this.f31132e.get() != 4) {
                if (this.f31132e.get() == 6) {
                    this.f31133f.set(true);
                }
            } else {
                this.f31133f.set(false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            com.bytedance.sdk.openadsdk.core.e.b bVar = this.f31129b;
            boolean z = false;
            if (bVar == null) {
                return false;
            }
            String d2 = bVar.d();
            if (!TextUtils.isEmpty(d2) && a(m(), d2)) {
                z = true;
                this.f31133f.set(true);
                if (!a(this.f31131d, "click_open", this.f31130c)) {
                    com.bytedance.sdk.openadsdk.e.d.j(m(), this.f31130c, this.f31131d, o.h(this.f31130c), null);
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.f31130c.an() != null) {
                String a2 = this.f31130c.an().a();
                j.b("DMLibManager", "含有deeplink链接 " + this.f31135h);
                j.b("deepLink", "DMLibManager 含有deeplink链接尝试deeplink调起 " + this.f31135h);
                if (!TextUtils.isEmpty(a2)) {
                    Uri parse = Uri.parse(a2);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(parse);
                    if (this.f31135h) {
                        j.b("DMLibManager", "含有deeplink链接，开始上报 lp_open_dpl schema " + a(a2));
                        com.bytedance.sdk.openadsdk.e.d.a(m(), this.f31130c, this.f31131d, "lp_open_dpl", a(a2));
                    }
                    if (o.a(m(), intent)) {
                        j.b("DMLibManager", "含有deeplink链接， 该app已安装 ");
                        if (!(m() instanceof Activity)) {
                            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                        }
                        try {
                            n();
                            if (!a(this.f31131d, "open_url_app", this.f31130c)) {
                                com.bytedance.sdk.openadsdk.e.d.i(m(), this.f31130c, this.f31131d, "open_url_app", null);
                            }
                            m().startActivity(intent);
                            k.a().a(this.f31130c, this.f31131d, this.f31135h);
                            if (this.f31135h) {
                                j.b("DMLibManager", "含有deeplink链接， 该app已安装，进行开始调起上报 lp_openurl ");
                                com.bytedance.sdk.openadsdk.e.d.b(m(), this.f31130c, this.f31131d, "lp_openurl");
                                com.bytedance.sdk.openadsdk.e.d.b(com.bytedance.sdk.openadsdk.core.o.a(), this.f31130c, this.f31131d, "lp_deeplink_success_realtime");
                            } else {
                                com.bytedance.sdk.openadsdk.e.d.b(com.bytedance.sdk.openadsdk.core.o.a(), this.f31130c, this.f31131d, "deeplink_success_realtime");
                            }
                            return true;
                        } catch (Throwable unused) {
                            if (!TextUtils.isEmpty(this.f31130c.Z())) {
                                z.a(m(), this.f31130c.Z(), this.f31130c, o.a(this.f31131d), this.f31131d, true, null);
                            }
                            if (this.f31135h) {
                                j.b("DMLibManager", "含有deeplink链接， 该app已安装，调起失败 上报lp_openurl_failed ");
                                com.bytedance.sdk.openadsdk.e.d.b(m(), this.f31130c, this.f31131d, "lp_openurl_failed");
                                com.bytedance.sdk.openadsdk.e.d.b(com.bytedance.sdk.openadsdk.core.o.a(), this.f31130c, this.f31131d, "lp_deeplink_fail_realtime");
                            } else {
                                com.bytedance.sdk.openadsdk.e.d.b(com.bytedance.sdk.openadsdk.core.o.a(), this.f31130c, this.f31131d, "deeplink_fail_realtime");
                            }
                            return false;
                        }
                    } else if (this.f31135h) {
                        j.b("DMLibManager", "含有deeplink链接， 该app未安装，上报lp_openurl_failed ");
                        com.bytedance.sdk.openadsdk.e.d.b(m(), this.f31130c, this.f31131d, "lp_openurl_failed");
                        com.bytedance.sdk.openadsdk.e.d.b(com.bytedance.sdk.openadsdk.core.o.a(), this.f31130c, this.f31131d, "lp_deeplink_fail_realtime");
                    } else {
                        com.bytedance.sdk.openadsdk.e.d.b(com.bytedance.sdk.openadsdk.core.o.a(), this.f31130c, this.f31131d, "deeplink_fail_realtime");
                    }
                }
                if (this.f31132e.get() != 4 && this.f31132e.get() != 3 && (!this.f31134g || this.f31133f.get())) {
                    this.f31134g = true;
                    if (!a(this.f31131d, "open_fallback_url", this.f31130c)) {
                        com.bytedance.sdk.openadsdk.e.d.i(m(), this.f31130c, this.f31131d, "open_fallback_url", null);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.m == null) {
                this.m = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(com.bytedance.sdk.openadsdk.core.o.a()).a(3));
            }
            return this.m;
        }
        return (IListenerManager) invokeV.objValue;
    }

    public Context m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            WeakReference<Context> weakReference = this.f31128a;
            return (weakReference == null || weakReference.get() == null) ? com.bytedance.sdk.openadsdk.core.o.a() : this.f31128a.get();
        }
        return (Context) invokeV.objValue;
    }

    public void n() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (mVar = this.f31130c) == null || !mVar.az() || this.f31135h || TTMiddlePageActivity.a(this.f31130c)) {
            return;
        }
        o.a(this.f31130c, this.f31131d);
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            j.b("DMLibManager", str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
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
            WeakReference<Context> weakReference = this.f31128a;
            if (weakReference != null) {
                weakReference.clear();
                this.f31128a = null;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            s();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            b(0L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || m() == null) {
            return;
        }
        if (!"feed_video_middle_page".equals(this.f31131d)) {
            TTMiddlePageActivity.b(m(), this.f31130c);
        }
        if (k()) {
            this.f31133f.set(true);
        } else if (this.f31130c.al() == null && this.f31130c.Z() != null) {
            z.a(m(), this.f31130c.Z(), this.f31130c, o.a(this.f31131d), this.f31131d, true, null);
        } else if (j()) {
        } else {
            if (u()) {
                this.f31133f.set(true);
            } else if (b(this.z)) {
                this.f31133f.set(true);
            } else {
                z();
            }
        }
    }

    private void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65556, this, z) == null) {
            if (z) {
                com.bytedance.sdk.openadsdk.e.d.a(m(), this.f31130c, this.f31131d, "quickapp_success");
            } else {
                com.bytedance.sdk.openadsdk.e.d.a(m(), this.f31130c, this.f31131d, "quickapp_fail");
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (com.bytedance.sdk.openadsdk.core.o.a() == null) {
                com.bytedance.sdk.openadsdk.core.o.a(m());
            }
            this.r = true;
            r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.r = false;
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.G = z;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f31135h = z;
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.v = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j2, long j3, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), str2, str3}) == null) {
            a aVar = this.D;
            if (aVar == null) {
                this.D = new a(this, str, j2, j3, str2, str3);
            } else {
                aVar.a(str);
                this.D.a(j2);
                this.D.b(j3);
                this.D.b(str2);
                this.D.c(str3);
            }
            com.bytedance.sdk.component.e.e.c().execute(this.D);
        }
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) || this.f31129b == null) {
            return;
        }
        this.t.set(false);
        g.d().j(this.q.a(), true);
        r();
    }

    private void b(TTAppDownloadListener tTAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, tTAppDownloadListener) == null) {
            j.f("DMLibManager", hashCode() + "registerMultiProcessListener, mMetaMd5:" + this.A);
            if (!com.bytedance.sdk.openadsdk.multipro.b.b() || tTAppDownloadListener == null) {
                return;
            }
            com.bytedance.sdk.component.e.e.c().execute(new Runnable(this, tTAppDownloadListener) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTAppDownloadListener f31144a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f31145b;

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
                    this.f31145b = this;
                    this.f31144a = tTAppDownloadListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(com.bytedance.sdk.openadsdk.core.o.a());
                        com.bytedance.sdk.openadsdk.multipro.aidl.b.e eVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.e(this.f31144a);
                        IListenerManager asInterface = IListenerManager.Stub.asInterface(a2.a(3));
                        if (asInterface != null) {
                            try {
                                asInterface.registerTTAppDownloadListener(this.f31145b.A, eVar);
                                synchronized (this.f31145b.E) {
                                    this.f31145b.E.add(eVar);
                                    j.f("DMLibManager", "registerMultiProcessListener, mTTAppDownloadListenerList size:" + this.f31145b.E.size());
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
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.F = z;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a
    public void a(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            j.f("DMLibManager", "setActivity==activity:" + activity.getLocalClassName());
            if (activity == null) {
                return;
            }
            this.f31128a = new WeakReference<>(activity);
            r();
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f31136i = z;
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
                    o.a(mVar, str2);
                }
                Uri parse = Uri.parse(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
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
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.z = z;
            return u();
        }
        return invokeZ.booleanValue;
    }

    private boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i2)) == null) {
            int f2 = com.bytedance.sdk.openadsdk.core.o.h().f();
            if (f2 != -1) {
                if (f2 != 0) {
                    if (f2 != 2) {
                        if (f2 != 3) {
                            if (h.d().b(i2)) {
                                return false;
                            }
                            int i3 = 104857600;
                            com.bytedance.sdk.openadsdk.core.e.b bVar = this.f31129b;
                            if (bVar != null && bVar.g() > 0) {
                                i3 = this.f31129b.g();
                            }
                            if (i3 <= com.bytedance.sdk.openadsdk.core.o.h().g()) {
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
            if (this.f31136i) {
                int c2 = com.bytedance.sdk.component.utils.m.c(m());
                if (c2 == 0) {
                    try {
                        Toast.makeText(m(), r.b(m(), "tt_no_network"), 0).show();
                    } catch (Exception unused) {
                    }
                }
                boolean a2 = a(c2);
                boolean z = mVar.B() == 0;
                boolean z2 = mVar.C() == 0;
                boolean z3 = mVar.C() == 2;
                boolean z4 = mVar.D() == 0;
                if (t()) {
                    if (this.f31135h || z3) {
                        return false;
                    }
                    this.B = 2;
                    if (z2) {
                        return a2;
                    }
                    return true;
                } else if (this.f31135h) {
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
                    if (mVar.B() == 2 && this.F && !this.G) {
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
        com.bytedance.sdk.openadsdk.e.d.b(com.bytedance.sdk.openadsdk.core.o.a(), mVar, this.f31131d, "pop_up", v());
        j = true;
        l = true;
        com.bytedance.sdk.openadsdk.r.b.a(m(), mVar.ak(), U, new b.a(this, bVar, mVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.d.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f31141a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ m f31142b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d f31143c;

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
                this.f31143c = this;
                this.f31141a = bVar;
                this.f31142b = mVar;
            }

            @Override // com.bytedance.sdk.openadsdk.r.b.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    b bVar2 = this.f31141a;
                    if (bVar2 != null) {
                        bVar2.a();
                    }
                    Context a4 = com.bytedance.sdk.openadsdk.core.o.a();
                    m mVar2 = this.f31142b;
                    d dVar = this.f31143c;
                    com.bytedance.sdk.openadsdk.e.d.b(a4, mVar2, dVar.f31131d, "pop_up_download", dVar.v());
                    d.k = true;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.r.b.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.r.b.a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    Context a4 = com.bytedance.sdk.openadsdk.core.o.a();
                    m mVar2 = this.f31142b;
                    d dVar = this.f31143c;
                    com.bytedance.sdk.openadsdk.e.d.b(a4, mVar2, dVar.f31131d, "pop_up_cancel", dVar.v());
                }
            }
        }, a2, a3, z);
    }

    public boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                j.b("DMLibManager", "使用包名调起 " + this.f31135h);
                if (this.f31135h) {
                    j.b("DMLibManager", "使用包名调起， 开始上报 lp_open_dpl packageName " + str);
                    com.bytedance.sdk.openadsdk.e.d.a(m(), this.f31130c, this.f31131d, "lp_open_dpl", str);
                }
                try {
                    if (o.c(context, str)) {
                        try {
                            Intent b2 = o.b(context, str);
                            if (b2 == null) {
                                return false;
                            }
                            n();
                            b2.putExtra("START_ONLY_FOR_ANDROID", true);
                            context.startActivity(b2);
                            if (this.f31135h) {
                                j.b("DMLibManager", "使用包名调起，开始调起，上报 lp_openurl ");
                                com.bytedance.sdk.openadsdk.e.d.b(m(), this.f31130c, this.f31131d, "lp_openurl");
                            }
                            if (this.f31135h) {
                                k.a().a(this.f31130c, this.f31131d, true);
                            }
                            return true;
                        } catch (Exception unused) {
                            if (this.f31130c.Z() != null) {
                                z.a(m(), this.f31130c.Z(), this.f31130c, o.a(this.f31131d), this.f31131d, true, null);
                            }
                            if (this.f31135h) {
                                j.b("DMLibManager", "使用包名调起，开始调起，调起异常，上报 lp_openurl_failed ");
                                com.bytedance.sdk.openadsdk.e.d.b(m(), this.f31130c, this.f31131d, "lp_openurl_failed");
                            }
                            return true;
                        }
                    } else if (this.f31135h) {
                        j.b("DMLibManager", "使用包名调起，该app未安装 ，上报 lp_openurl_failed ");
                        com.bytedance.sdk.openadsdk.e.d.b(m(), this.f31130c, this.f31131d, "lp_openurl_failed");
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
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, str2, mVar)) == null) ? g.a(str, str2, mVar, (Object) 1) : invokeLLL.booleanValue;
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
    public void a(int i2, a.InterfaceC0348a interfaceC0348a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, interfaceC0348a) == null) {
            if (this.w == null) {
                this.w = new HashSet<>();
            }
            this.w.add(Integer.valueOf(i2));
            g.a(i2, interfaceC0348a);
        }
    }

    @Override // com.bytedance.sdk.component.utils.u.a
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

    public String a(String str) {
        InterceptResult invokeL;
        Uri parse;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || TextUtils.isEmpty(parse.getScheme())) ? "" : parse.getScheme().toLowerCase() : (String) invokeL.objValue;
    }
}
