package com.baidu.turbonet.net.impl;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.tieba.a1b;
import com.baidu.tieba.c1b;
import com.baidu.tieba.g0b;
import com.baidu.tieba.j0b;
import com.baidu.tieba.w0b;
import com.baidu.tieba.x0b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.CronetException;
import com.baidu.turbonet.net.InlineExecutionProhibitedException;
import com.baidu.turbonet.net.RequestFinishedInfo;
import com.baidu.turbonet.net.RequestTimeInfo;
import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UrlRequest;
import com.baidu.turbonet.net.impl.VersionSafeCallbacks;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNIAdditionalImport;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.NativeClassQualifiedName;
@JNIAdditionalImport({VersionSafeCallbacks.class})
@JNINamespace("cronet")
@VisibleForTesting
/* loaded from: classes9.dex */
public final class CronetUrlRequest extends a1b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public Object D;
    public String E;
    public String F;
    public CronetUploadDataStream G;
    public c1b H;
    public int I;
    public CronetException J;
    public g0b K;
    public j L;
    @GuardedBy("mUrlRequestAdapterLock")
    public Runnable M;
    public final boolean a;
    @GuardedBy("mUrlRequestAdapterLock")
    public long b;
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean c;
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean d;
    @GuardedBy("mUrlRequestAdapterLock")
    public boolean e;
    public final Object f;
    public final CronetUrlRequestContext g;
    public final Executor h;
    public final List<String> i;
    public final VersionSafeCallbacks.h j;
    public final String k;
    public final int l;
    public final int m;
    public String n;
    public final HeadersList o;
    public final Collection<Object> p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public final int t;
    public final boolean u;
    public final int v;
    public final VersionSafeCallbacks.e w;
    public RequestTimeInfo x;
    public boolean y;
    public int z;

    /* loaded from: classes9.dex */
    public interface i {
        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void a(long j, CronetUrlRequest cronetUrlRequest, String str);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void b(long j, CronetUrlRequest cronetUrlRequest, int i);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void c(long j, CronetUrlRequest cronetUrlRequest);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean d(long j, CronetUrlRequest cronetUrlRequest, ByteBuffer byteBuffer, int i, int i2);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        String e(long j, CronetUrlRequest cronetUrlRequest, boolean z);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean f(long j, CronetUrlRequest cronetUrlRequest, String str);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        long g(long j, CronetUrlRequest cronetUrlRequest, int i);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void h(long j, CronetUrlRequest cronetUrlRequest, int i);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        RequestTimeInfo i(long j, CronetUrlRequest cronetUrlRequest);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        String j(long j, CronetUrlRequest cronetUrlRequest);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void k(long j, CronetUrlRequest cronetUrlRequest);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean l(long j, CronetUrlRequest cronetUrlRequest, String str, String str2);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void m(long j, CronetUrlRequest cronetUrlRequest, int i);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void n(long j, CronetUrlRequest cronetUrlRequest, boolean z);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void o(long j, CronetUrlRequest cronetUrlRequest);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void p(long j, CronetUrlRequest cronetUrlRequest, int i);

        long q(CronetUrlRequest cronetUrlRequest, long j, String str, int i, boolean z, boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, int i4);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        String r(long j, CronetUrlRequest cronetUrlRequest);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        String s(long j, CronetUrlRequest cronetUrlRequest);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        String t(long j, CronetUrlRequest cronetUrlRequest);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void u(long j, CronetUrlRequest cronetUrlRequest, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1416301571, "Lcom/baidu/turbonet/net/impl/CronetUrlRequest;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1416301571, "Lcom/baidu/turbonet/net/impl/CronetUrlRequest;");
        }
    }

    public static int H(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) {
            int i3 = 1;
            if (i2 != 1) {
                i3 = 2;
                if (i2 != 2) {
                    return 0;
                }
            }
            return i3;
        }
        return invokeI.intValue;
    }

    public static int I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        return i2 != 4 ? 4 : 5;
                    }
                    return 3;
                }
                return 2;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    /* loaded from: classes9.dex */
    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public HeadersList() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ HeadersList(a aVar) {
            this();
        }
    }

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CronetUrlRequest a;

        public a(CronetUrlRequest cronetUrlRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cronetUrlRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.G.r();
                synchronized (this.a.f) {
                    if (this.a.L()) {
                        return;
                    }
                    this.a.G.m(this.a.b);
                    this.a.S();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c1b a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CronetUrlRequest c;

        public b(CronetUrlRequest cronetUrlRequest, c1b c1bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest, c1bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cronetUrlRequest;
            this.a = c1bVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.F();
                synchronized (this.c.f) {
                    if (this.c.L()) {
                        return;
                    }
                    this.c.d = true;
                    try {
                        this.c.j.d(this.c, this.a, this.b);
                    } catch (Exception e) {
                        this.c.O(e);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CronetUrlRequest a;

        public c(CronetUrlRequest cronetUrlRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cronetUrlRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.F();
                synchronized (this.a.f) {
                    if (this.a.L()) {
                        return;
                    }
                    this.a.e = true;
                    try {
                        this.a.j.e(this.a, this.a.H);
                    } catch (Exception e) {
                        this.a.O(e);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CronetUrlRequest a;

        public d(CronetUrlRequest cronetUrlRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cronetUrlRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.a.f) {
                    if (this.a.L()) {
                        return;
                    }
                    this.a.J(0);
                    try {
                        this.a.j.f(this.a, this.a.H);
                        this.a.N();
                    } catch (Exception e) {
                        Log.e(CronetUrlRequestContext.s, "Exception in onSucceeded method", e);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CronetUrlRequest a;

        public e(CronetUrlRequest cronetUrlRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cronetUrlRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Log.e(CronetUrlRequestContext.s, "****** onCanceled, url is: %s", this.a.H.f());
                    this.a.j.a(this.a, this.a.H);
                    this.a.N();
                } catch (Exception e) {
                    Log.e(CronetUrlRequestContext.s, "Exception in onCanceled method", e);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VersionSafeCallbacks.UrlRequestStatusListener a;
        public final /* synthetic */ int b;

        public f(CronetUrlRequest cronetUrlRequest, VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest, urlRequestStatusListener, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = urlRequestStatusListener;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(a1b.o(this.b));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CronetUrlRequest a;

        public g(CronetUrlRequest cronetUrlRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cronetUrlRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.j.b(this.a, this.a.H, this.a.J);
                    this.a.N();
                } catch (Exception e) {
                    Log.e(CronetUrlRequestContext.s, "Exception in onFailed method", e);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RequestFinishedInfo a;
        public final /* synthetic */ CronetUrlRequest b;

        public h(CronetUrlRequest cronetUrlRequest, RequestFinishedInfo requestFinishedInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest, requestFinishedInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cronetUrlRequest;
            this.a = requestFinishedInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.w.b(this.a);
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ByteBuffer a;
        public final /* synthetic */ CronetUrlRequest b;

        public j(CronetUrlRequest cronetUrlRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUrlRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cronetUrlRequest;
        }

        public /* synthetic */ j(CronetUrlRequest cronetUrlRequest, a aVar) {
            this(cronetUrlRequest);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.F();
                ByteBuffer byteBuffer = this.a;
                this.a = null;
                try {
                    synchronized (this.b.f) {
                        if (!this.b.L()) {
                            this.b.e = true;
                            this.b.j.c(this.b, this.b.H, byteBuffer);
                        }
                    }
                } catch (Exception e) {
                    this.b.O(e);
                }
            }
        }
    }

    public CronetUrlRequest(CronetUrlRequestContext cronetUrlRequestContext, String str, int i2, UrlRequest.Callback callback, Executor executor, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i3, boolean z5, int i4, RequestFinishedInfo.Listener listener, int i5) {
        VersionSafeCallbacks.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cronetUrlRequestContext, str, Integer.valueOf(i2), callback, executor, collection, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i3), Boolean.valueOf(z5), Integer.valueOf(i4), listener, Integer.valueOf(i5)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = new Object();
        this.i = new ArrayList();
        this.o = new HeadersList(null);
        if (str != null) {
            if (callback != null) {
                if (executor != null) {
                    this.a = z3;
                    this.g = cronetUrlRequestContext;
                    this.k = str;
                    this.i.add(str);
                    this.l = I(i2);
                    this.j = new VersionSafeCallbacks.h(callback);
                    this.h = executor;
                    this.p = collection;
                    this.q = z;
                    this.r = z2;
                    this.s = z4;
                    this.t = i3;
                    this.u = z5;
                    this.v = i4;
                    if (listener != null) {
                        eVar = new VersionSafeCallbacks.e(listener);
                    } else {
                        eVar = null;
                    }
                    this.w = eVar;
                    this.m = H(i5);
                    this.y = false;
                    this.z = 0;
                    this.A = 0;
                    this.B = 0;
                    this.C = 0;
                    this.D = null;
                    this.E = null;
                    this.F = null;
                    this.H = new c1b(new ArrayList(this.i), 0, "", new HeadersList(null), false, "", "");
                    return;
                }
                throw new NullPointerException("Executor is required");
            }
            throw new NullPointerException("Listener is required");
        }
        throw new NullPointerException("URL is required");
    }

    @CalledByNative
    private void onSucceeded(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65554, this, j2) == null) {
            this.H.j(j2);
            Q(new d(this));
        }
    }

    public final void K(CronetException cronetException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cronetException) == null) {
            synchronized (this.f) {
                if (L()) {
                    return;
                }
                this.J = cronetException;
                J(1);
            }
        }
    }

    public final void O(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, exc) == null) {
            CallbackExceptionImpl callbackExceptionImpl = new CallbackExceptionImpl("Exception received from UrlRequest.Callback", exc);
            Log.e(CronetUrlRequestContext.s, "Exception in CalledByNative method", exc);
            K(callbackExceptionImpl);
        }
    }

    public void P(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th) == null) {
            CallbackExceptionImpl callbackExceptionImpl = new CallbackExceptionImpl("Exception received from UploadDataProvider", th);
            Log.e(CronetUrlRequestContext.s, "Exception in upload method", th);
            K(callbackExceptionImpl);
        }
    }

    public final void Q(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, runnable) == null) {
            try {
                this.h.execute(runnable);
            } catch (RejectedExecutionException e2) {
                Log.e(CronetUrlRequestContext.s, "Exception posting task to executor", e2);
                K(new CronetExceptionImpl("Exception posting task to executor", e2));
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            G();
            this.E = str;
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            G();
            this.F = str;
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            G();
            this.C = i2;
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            G();
            this.B = i2;
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            G();
            this.A = i2;
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void k(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, obj) == null) {
            G();
            this.D = obj;
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            G();
            this.z = i2;
        }
    }

    @Override // com.baidu.tieba.a1b
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            G();
            if (str != null) {
                this.n = str;
                return;
            }
            throw new NullPointerException("Method is required.");
        }
    }

    @CalledByNative
    private void onStatus(VersionSafeCallbacks.UrlRequestStatusListener urlRequestStatusListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65553, this, urlRequestStatusListener, i2) == null) {
            Q(new f(this, urlRequestStatusListener, i2));
        }
    }

    @Override // com.baidu.tieba.a1b
    public void n(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, str2) == null) {
            G();
            if (str != null) {
                if (str2 != null) {
                    this.o.add(new AbstractMap.SimpleImmutableEntry(str, str2));
                    return;
                }
                throw new NullPointerException("Invalid header value.");
            }
            throw new NullPointerException("Invalid header name.");
        }
    }

    @Override // com.baidu.tieba.a1b
    public void q(UploadDataProvider uploadDataProvider, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, uploadDataProvider, executor) == null) {
            if (uploadDataProvider != null) {
                if (this.n == null) {
                    this.n = "POST";
                }
                this.G = new CronetUploadDataStream(uploadDataProvider, executor, this);
                return;
            }
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
    }

    @CalledByNative
    public static RequestTimeInfo createObject(long j2, long j3, long j4, long j5, long j6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)})) == null) {
            return new RequestTimeInfo(j2, j3, j4, j5, j6);
        }
        return (RequestTimeInfo) invokeCommon.objValue;
    }

    @CalledByNative
    private void onError(int i2, int i3, int i4, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(j2)}) == null) {
            c1b c1bVar = this.H;
            if (c1bVar != null) {
                c1bVar.j(j2);
            }
            int M = M(i2);
            K(new NetworkExceptionImpl("Exception in CronetUrlRequest: " + str, M, i3));
        }
    }

    @CalledByNative
    private void onCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            Q(new e(this));
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a && this.g.s(Thread.currentThread())) {
            throw new InlineExecutionProhibitedException();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.f) {
                if (this.c || L()) {
                    throw new IllegalStateException("Request is already started.");
                }
            }
        }
    }

    @GuardedBy("mUrlRequestAdapterLock")
    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.c && this.b == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @GuardedBy("mUrlRequestAdapterLock")
    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            j0b.v().o(this.b, this);
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            G();
            this.y = true;
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public Object d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.D;
        }
        return invokeV.objValue;
    }

    @CalledByNative
    private void onMetricsCollected(long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, boolean z, long j15, long j16) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j8), Long.valueOf(j9), Long.valueOf(j10), Long.valueOf(j11), Long.valueOf(j12), Long.valueOf(j13), Long.valueOf(j14), Boolean.valueOf(z), Long.valueOf(j15), Long.valueOf(j16)}) == null) {
            synchronized (this.f) {
                if (this.K == null) {
                    this.K = new g0b(j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, z, j15, j16);
                } else {
                    throw new IllegalStateException("Metrics collection should only happen once.");
                }
            }
        }
    }

    @CalledByNative
    private void onNativeAdapterDestroyed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            synchronized (this.f) {
                if (this.M != null) {
                    this.M.run();
                }
                if (this.J == null) {
                    return;
                }
                try {
                    this.h.execute(new g(this));
                } catch (RejectedExecutionException e2) {
                    Log.e(CronetUrlRequestContext.s, "Exception posting task to executor", e2);
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this.f) {
                Log.i(CronetUrlRequestContext.s, "****** Request cancel, url is: %s", this.k);
                if (!L() && this.c) {
                    J(2);
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this.f) {
                if (this.d) {
                    this.d = false;
                    if (L()) {
                        return;
                    }
                    j0b.v().k(this.b, this);
                    return;
                }
                throw new IllegalStateException("No redirect to follow.");
            }
        }
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i2, int i3, int i4, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2)}) == null) {
            this.H.j(j2);
            if (byteBuffer.position() == i3 && byteBuffer.limit() == i4) {
                if (this.L == null) {
                    this.L = new j(this, null);
                }
                byteBuffer.position(i3 + i2);
                j jVar = this.L;
                jVar.a = byteBuffer;
                Q(jVar);
                return;
            }
            K(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
        }
    }

    @CalledByNative
    private void onRedirectReceived(String str, int i2, String str2, String[] strArr, boolean z, String str3, String str4, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, this, new Object[]{str, Integer.valueOf(i2), str2, strArr, Boolean.valueOf(z), str3, str4, Long.valueOf(j2)}) == null) {
            c1b R = R(i2, str2, strArr, z, str3, str4, j2);
            this.i.add(str);
            Q(new b(this, R, str));
        }
    }

    @CalledByNative
    private void onResponseStarted(int i2, String str, String[] strArr, boolean z, String str2, String str3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, this, new Object[]{Integer.valueOf(i2), str, strArr, Boolean.valueOf(z), str2, str3, Long.valueOf(j2)}) == null) {
            this.H = R(i2, str, strArr, z, str2, str3, j2);
            Q(new c(this));
        }
    }

    @GuardedBy("mUrlRequestAdapterLock")
    public final void J(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.I = i2;
            if (this.b == 0) {
                return;
            }
            j0b.v().s(this.b, this).isEmpty();
            j0b.v().j(this.b, this).isEmpty();
            j0b.v().r(this.b, this).isEmpty();
            boolean z = false;
            j0b.v().e(this.b, this, false).isEmpty();
            j0b.v().e(this.b, this, true).isEmpty();
            j0b.v().t(this.b, this).isEmpty();
            int i3 = (j0b.v().g(this.b, this, 1) > 0L ? 1 : (j0b.v().g(this.b, this, 1) == 0L ? 0 : -1));
            int i4 = (j0b.v().g(this.b, this, 2) > 0L ? 1 : (j0b.v().g(this.b, this, 2) == 0L ? 0 : -1));
            int i5 = (j0b.v().g(this.b, this, 3) > 0L ? 1 : (j0b.v().g(this.b, this, 3) == 0L ? 0 : -1));
            int i6 = (j0b.v().g(this.b, this, 4) > 0L ? 1 : (j0b.v().g(this.b, this, 4) == 0L ? 0 : -1));
            int i7 = (j0b.v().g(this.b, this, 5) > 0L ? 1 : (j0b.v().g(this.b, this, 5) == 0L ? 0 : -1));
            RequestTimeInfo i8 = j0b.v().i(this.b, this);
            this.x = i8;
            if (i8 == null) {
                this.x = new RequestTimeInfo();
            }
            if (this.D != null) {
                this.g.y(this);
            }
            this.g.t();
            i v = j0b.v();
            long j2 = this.b;
            if (i2 == 2) {
                z = true;
            }
            v.n(j2, this, z);
            this.b = 0L;
        }
    }

    public final int M(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            switch (i2) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                case 8:
                    return 8;
                case 9:
                    return 9;
                case 10:
                    return 10;
                case 11:
                    return 11;
                default:
                    String str = CronetUrlRequestContext.s;
                    Log.e(str, "Unknown error code: " + i2, new Object[0]);
                    return i2;
            }
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.turbonet.net.UrlRequest
    public void e(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, byteBuffer) == null) {
            w0b.b(byteBuffer);
            w0b.a(byteBuffer);
            synchronized (this.f) {
                if (this.e) {
                    this.e = false;
                    if (L()) {
                        return;
                    }
                    if (j0b.v().d(this.b, this, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                        return;
                    }
                    this.e = true;
                    throw new IllegalArgumentException("Unable to call native read");
                }
                throw new IllegalStateException("Unexpected read attempt.");
            }
        }
    }

    public final void N() {
        g0b g0bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (g0bVar = this.K) != null) {
            x0b x0bVar = new x0b(this.k, this.p, g0bVar, this.I, this.H, this.J);
            this.g.z(x0bVar);
            VersionSafeCallbacks.e eVar = this.w;
            if (eVar != null) {
                try {
                    eVar.a().execute(new h(this, x0bVar));
                } catch (RejectedExecutionException e2) {
                    Log.e(CronetUrlRequestContext.s, "Exception posting task to executor", e2);
                }
            }
        }
    }

    public final c1b R(int i2, String str, String[] strArr, boolean z, String str2, String str3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), str, strArr, Boolean.valueOf(z), str2, str3, Long.valueOf(j2)})) == null) {
            HeadersList headersList = new HeadersList(null);
            for (int i3 = 0; i3 < strArr.length; i3 += 2) {
                headersList.add(new AbstractMap.SimpleImmutableEntry(strArr[i3], strArr[i3 + 1]));
            }
            return new c1b(new ArrayList(this.i), i2, str, headersList, z, str2, str3, j2);
        }
        return (c1b) invokeCommon.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:107:0x0231 */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01f2, code lost:
        if (com.baidu.tieba.j0b.v().l(r19.b, r19, "X-From-H3-TRNet", com.baidu.searchbox.player.model.YYOption.IsLive.VALUE_TRUE) == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01fc, code lost:
        throw new java.lang.IllegalArgumentException("Invalid value for header X-From-H3-TRNet.");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008c A[Catch: RuntimeException -> 0x0222, all -> 0x0231, TryCatch #0 {all -> 0x0231, blocks: (B:16:0x0051, B:18:0x0060, B:21:0x006f, B:22:0x0087, B:23:0x0088, B:25:0x008c, B:26:0x0091, B:29:0x0096, B:30:0x009f, B:32:0x00a3, B:33:0x00ae, B:35:0x00b2, B:36:0x00bd, B:38:0x00c1, B:39:0x00cc, B:41:0x00d0, B:42:0x00db, B:44:0x00e3, B:45:0x00ee, B:47:0x00f6, B:48:0x0101, B:49:0x0109, B:51:0x010f, B:53:0x0124, B:56:0x0132, B:58:0x0140, B:61:0x014d, B:63:0x015b, B:66:0x0168, B:69:0x0185, B:70:0x01af, B:72:0x01b2, B:75:0x01d7, B:76:0x01de, B:78:0x01e1, B:81:0x01f5, B:82:0x01fc, B:83:0x01fd, B:86:0x0203, B:87:0x020f, B:89:0x0211, B:90:0x0218, B:91:0x0219, B:92:0x021e, B:101:0x0228, B:102:0x022b, B:105:0x022f), top: B:112:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a3 A[Catch: RuntimeException -> 0x0220, all -> 0x0231, TryCatch #0 {all -> 0x0231, blocks: (B:16:0x0051, B:18:0x0060, B:21:0x006f, B:22:0x0087, B:23:0x0088, B:25:0x008c, B:26:0x0091, B:29:0x0096, B:30:0x009f, B:32:0x00a3, B:33:0x00ae, B:35:0x00b2, B:36:0x00bd, B:38:0x00c1, B:39:0x00cc, B:41:0x00d0, B:42:0x00db, B:44:0x00e3, B:45:0x00ee, B:47:0x00f6, B:48:0x0101, B:49:0x0109, B:51:0x010f, B:53:0x0124, B:56:0x0132, B:58:0x0140, B:61:0x014d, B:63:0x015b, B:66:0x0168, B:69:0x0185, B:70:0x01af, B:72:0x01b2, B:75:0x01d7, B:76:0x01de, B:78:0x01e1, B:81:0x01f5, B:82:0x01fc, B:83:0x01fd, B:86:0x0203, B:87:0x020f, B:89:0x0211, B:90:0x0218, B:91:0x0219, B:92:0x021e, B:101:0x0228, B:102:0x022b, B:105:0x022f), top: B:112:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b2 A[Catch: RuntimeException -> 0x0220, all -> 0x0231, TryCatch #0 {all -> 0x0231, blocks: (B:16:0x0051, B:18:0x0060, B:21:0x006f, B:22:0x0087, B:23:0x0088, B:25:0x008c, B:26:0x0091, B:29:0x0096, B:30:0x009f, B:32:0x00a3, B:33:0x00ae, B:35:0x00b2, B:36:0x00bd, B:38:0x00c1, B:39:0x00cc, B:41:0x00d0, B:42:0x00db, B:44:0x00e3, B:45:0x00ee, B:47:0x00f6, B:48:0x0101, B:49:0x0109, B:51:0x010f, B:53:0x0124, B:56:0x0132, B:58:0x0140, B:61:0x014d, B:63:0x015b, B:66:0x0168, B:69:0x0185, B:70:0x01af, B:72:0x01b2, B:75:0x01d7, B:76:0x01de, B:78:0x01e1, B:81:0x01f5, B:82:0x01fc, B:83:0x01fd, B:86:0x0203, B:87:0x020f, B:89:0x0211, B:90:0x0218, B:91:0x0219, B:92:0x021e, B:101:0x0228, B:102:0x022b, B:105:0x022f), top: B:112:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c1 A[Catch: RuntimeException -> 0x0220, all -> 0x0231, TryCatch #0 {all -> 0x0231, blocks: (B:16:0x0051, B:18:0x0060, B:21:0x006f, B:22:0x0087, B:23:0x0088, B:25:0x008c, B:26:0x0091, B:29:0x0096, B:30:0x009f, B:32:0x00a3, B:33:0x00ae, B:35:0x00b2, B:36:0x00bd, B:38:0x00c1, B:39:0x00cc, B:41:0x00d0, B:42:0x00db, B:44:0x00e3, B:45:0x00ee, B:47:0x00f6, B:48:0x0101, B:49:0x0109, B:51:0x010f, B:53:0x0124, B:56:0x0132, B:58:0x0140, B:61:0x014d, B:63:0x015b, B:66:0x0168, B:69:0x0185, B:70:0x01af, B:72:0x01b2, B:75:0x01d7, B:76:0x01de, B:78:0x01e1, B:81:0x01f5, B:82:0x01fc, B:83:0x01fd, B:86:0x0203, B:87:0x020f, B:89:0x0211, B:90:0x0218, B:91:0x0219, B:92:0x021e, B:101:0x0228, B:102:0x022b, B:105:0x022f), top: B:112:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d0 A[Catch: RuntimeException -> 0x0220, all -> 0x0231, TryCatch #0 {all -> 0x0231, blocks: (B:16:0x0051, B:18:0x0060, B:21:0x006f, B:22:0x0087, B:23:0x0088, B:25:0x008c, B:26:0x0091, B:29:0x0096, B:30:0x009f, B:32:0x00a3, B:33:0x00ae, B:35:0x00b2, B:36:0x00bd, B:38:0x00c1, B:39:0x00cc, B:41:0x00d0, B:42:0x00db, B:44:0x00e3, B:45:0x00ee, B:47:0x00f6, B:48:0x0101, B:49:0x0109, B:51:0x010f, B:53:0x0124, B:56:0x0132, B:58:0x0140, B:61:0x014d, B:63:0x015b, B:66:0x0168, B:69:0x0185, B:70:0x01af, B:72:0x01b2, B:75:0x01d7, B:76:0x01de, B:78:0x01e1, B:81:0x01f5, B:82:0x01fc, B:83:0x01fd, B:86:0x0203, B:87:0x020f, B:89:0x0211, B:90:0x0218, B:91:0x0219, B:92:0x021e, B:101:0x0228, B:102:0x022b, B:105:0x022f), top: B:112:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3 A[Catch: RuntimeException -> 0x0220, all -> 0x0231, TryCatch #0 {all -> 0x0231, blocks: (B:16:0x0051, B:18:0x0060, B:21:0x006f, B:22:0x0087, B:23:0x0088, B:25:0x008c, B:26:0x0091, B:29:0x0096, B:30:0x009f, B:32:0x00a3, B:33:0x00ae, B:35:0x00b2, B:36:0x00bd, B:38:0x00c1, B:39:0x00cc, B:41:0x00d0, B:42:0x00db, B:44:0x00e3, B:45:0x00ee, B:47:0x00f6, B:48:0x0101, B:49:0x0109, B:51:0x010f, B:53:0x0124, B:56:0x0132, B:58:0x0140, B:61:0x014d, B:63:0x015b, B:66:0x0168, B:69:0x0185, B:70:0x01af, B:72:0x01b2, B:75:0x01d7, B:76:0x01de, B:78:0x01e1, B:81:0x01f5, B:82:0x01fc, B:83:0x01fd, B:86:0x0203, B:87:0x020f, B:89:0x0211, B:90:0x0218, B:91:0x0219, B:92:0x021e, B:101:0x0228, B:102:0x022b, B:105:0x022f), top: B:112:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f6 A[Catch: RuntimeException -> 0x0220, all -> 0x0231, TryCatch #0 {all -> 0x0231, blocks: (B:16:0x0051, B:18:0x0060, B:21:0x006f, B:22:0x0087, B:23:0x0088, B:25:0x008c, B:26:0x0091, B:29:0x0096, B:30:0x009f, B:32:0x00a3, B:33:0x00ae, B:35:0x00b2, B:36:0x00bd, B:38:0x00c1, B:39:0x00cc, B:41:0x00d0, B:42:0x00db, B:44:0x00e3, B:45:0x00ee, B:47:0x00f6, B:48:0x0101, B:49:0x0109, B:51:0x010f, B:53:0x0124, B:56:0x0132, B:58:0x0140, B:61:0x014d, B:63:0x015b, B:66:0x0168, B:69:0x0185, B:70:0x01af, B:72:0x01b2, B:75:0x01d7, B:76:0x01de, B:78:0x01e1, B:81:0x01f5, B:82:0x01fc, B:83:0x01fd, B:86:0x0203, B:87:0x020f, B:89:0x0211, B:90:0x0218, B:91:0x0219, B:92:0x021e, B:101:0x0228, B:102:0x022b, B:105:0x022f), top: B:112:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010f A[Catch: RuntimeException -> 0x0220, all -> 0x0231, TryCatch #0 {all -> 0x0231, blocks: (B:16:0x0051, B:18:0x0060, B:21:0x006f, B:22:0x0087, B:23:0x0088, B:25:0x008c, B:26:0x0091, B:29:0x0096, B:30:0x009f, B:32:0x00a3, B:33:0x00ae, B:35:0x00b2, B:36:0x00bd, B:38:0x00c1, B:39:0x00cc, B:41:0x00d0, B:42:0x00db, B:44:0x00e3, B:45:0x00ee, B:47:0x00f6, B:48:0x0101, B:49:0x0109, B:51:0x010f, B:53:0x0124, B:56:0x0132, B:58:0x0140, B:61:0x014d, B:63:0x015b, B:66:0x0168, B:69:0x0185, B:70:0x01af, B:72:0x01b2, B:75:0x01d7, B:76:0x01de, B:78:0x01e1, B:81:0x01f5, B:82:0x01fc, B:83:0x01fd, B:86:0x0203, B:87:0x020f, B:89:0x0211, B:90:0x0218, B:91:0x0219, B:92:0x021e, B:101:0x0228, B:102:0x022b, B:105:0x022f), top: B:112:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0219 A[Catch: all -> 0x0231, TRY_ENTER, TryCatch #0 {all -> 0x0231, blocks: (B:16:0x0051, B:18:0x0060, B:21:0x006f, B:22:0x0087, B:23:0x0088, B:25:0x008c, B:26:0x0091, B:29:0x0096, B:30:0x009f, B:32:0x00a3, B:33:0x00ae, B:35:0x00b2, B:36:0x00bd, B:38:0x00c1, B:39:0x00cc, B:41:0x00d0, B:42:0x00db, B:44:0x00e3, B:45:0x00ee, B:47:0x00f6, B:48:0x0101, B:49:0x0109, B:51:0x010f, B:53:0x0124, B:56:0x0132, B:58:0x0140, B:61:0x014d, B:63:0x015b, B:66:0x0168, B:69:0x0185, B:70:0x01af, B:72:0x01b2, B:75:0x01d7, B:76:0x01de, B:78:0x01e1, B:81:0x01f5, B:82:0x01fc, B:83:0x01fd, B:86:0x0203, B:87:0x020f, B:89:0x0211, B:90:0x0218, B:91:0x0219, B:92:0x021e, B:101:0x0228, B:102:0x022b, B:105:0x022f), top: B:112:0x0009 }] */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    @Override // com.baidu.turbonet.net.UrlRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m() {
        ?? r18;
        int i2;
        boolean z;
        Iterator<Map.Entry<String, String>> it;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r18 = 1048600;
            if (interceptable.invokeV(1048600, this) != null) {
                return;
            }
        }
        Object obj = this.f;
        synchronized (obj) {
            try {
                try {
                    boolean z3 = false;
                    Log.i(CronetUrlRequestContext.s, "****** Request start, url is: %s", this.k);
                    G();
                    try {
                        i v = j0b.v();
                        long p = this.g.p();
                        String str = this.k;
                        int i3 = this.l;
                        boolean z4 = this.q;
                        boolean z5 = this.r;
                        try {
                            if (!this.g.q() && this.w == null) {
                                z = false;
                                this.b = v.q(this, p, str, i3, z4, z5, z, this.s, this.t, this.u, this.v, this.m);
                                this.g.u();
                                if (this.n != null && !j0b.v().f(this.b, this, this.n)) {
                                    throw new IllegalArgumentException("Invalid http method " + this.n);
                                }
                                if (this.D != null) {
                                    this.g.l(this);
                                }
                                i2 = 1;
                                if (this.y) {
                                    try {
                                        j0b.v().c(this.b, this);
                                    } catch (RuntimeException e2) {
                                        e = e2;
                                        J(i2);
                                        throw e;
                                    }
                                }
                                if (this.z > 0) {
                                    j0b.v().m(this.b, this, this.z);
                                }
                                if (this.A > 0) {
                                    j0b.v().b(this.b, this, this.A);
                                }
                                if (this.B > 0) {
                                    j0b.v().p(this.b, this, this.B);
                                }
                                if (this.C > 0) {
                                    j0b.v().h(this.b, this, this.C);
                                }
                                if (!TextUtils.isEmpty(this.E)) {
                                    j0b.v().u(this.b, this, this.E);
                                }
                                if (!TextUtils.isEmpty(this.F)) {
                                    j0b.v().a(this.b, this, this.F);
                                }
                                it = this.o.iterator();
                                boolean z6 = false;
                                z2 = false;
                                while (it.hasNext()) {
                                    Map.Entry<String, String> next = it.next();
                                    if (next.getKey().equalsIgnoreCase("Content-Type") && !next.getValue().isEmpty()) {
                                        z3 = true;
                                    }
                                    if (next.getKey().equalsIgnoreCase(HttpRequest.EXT_HEADER_TRACE_ID) && !next.getValue().isEmpty()) {
                                        z2 = true;
                                    }
                                    if (next.getKey().equalsIgnoreCase("X-From-H3-TRNet") && !next.getValue().isEmpty()) {
                                        z6 = true;
                                    }
                                    if (!j0b.v().l(this.b, this, next.getKey(), next.getValue())) {
                                        throw new IllegalArgumentException("Invalid header " + next.getKey() + "=" + next.getValue());
                                    }
                                }
                                if (!z2 && !j0b.v().l(this.b, this, HttpRequest.EXT_HEADER_TRACE_ID, UUID.randomUUID().toString().replace("-", "").toLowerCase())) {
                                    throw new IllegalArgumentException("Invalid value for header X-Bd-Traceid .");
                                }
                                if (this.G == null) {
                                    if (z3) {
                                        this.c = true;
                                        this.G.t(new a(this));
                                        return;
                                    }
                                    throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
                                }
                                this.c = true;
                                S();
                                return;
                            }
                            this.b = v.q(this, p, str, i3, z4, z5, z, this.s, this.t, this.u, this.v, this.m);
                            this.g.u();
                            if (this.n != null) {
                                throw new IllegalArgumentException("Invalid http method " + this.n);
                            }
                            if (this.D != null) {
                            }
                            i2 = 1;
                            if (this.y) {
                            }
                            if (this.z > 0) {
                            }
                            if (this.A > 0) {
                            }
                            if (this.B > 0) {
                            }
                            if (this.C > 0) {
                            }
                            if (!TextUtils.isEmpty(this.E)) {
                            }
                            if (!TextUtils.isEmpty(this.F)) {
                            }
                            it = this.o.iterator();
                            boolean z62 = false;
                            z2 = false;
                            while (it.hasNext()) {
                            }
                            if (!z2) {
                                throw new IllegalArgumentException("Invalid value for header X-Bd-Traceid .");
                            }
                            if (this.G == null) {
                            }
                        } catch (RuntimeException e3) {
                            e = e3;
                            i2 = 1;
                            J(i2);
                            throw e;
                        }
                        z = true;
                    } catch (RuntimeException e4) {
                        e = e4;
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r18 = obj;
                throw th;
            }
        }
    }
}
