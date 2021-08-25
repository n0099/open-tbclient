package com.bytedance.sdk.component.adnet.core;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.core.m;
import com.bytedance.sdk.component.adnet.core.o;
import com.bytedance.sdk.component.adnet.err.VAdError;
import com.bytedance.sdk.component.adnet.face.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes9.dex */
public abstract class Request<T> implements Comparable<Request<T>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int METHOD_DELETE = 3;
    public static final int METHOD_DEPRECATED_GET_OR_POST = -1;
    public static final int METHOD_GET = 0;
    public static final int METHOD_HEAD = 4;
    public static final int METHOD_OPTIONS = 5;
    public static final int METHOD_PATCH = 7;
    public static final int METHOD_POST = 1;
    public static final int METHOD_PUT = 2;
    public static final int METHOD_TRACE = 6;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    @GuardedBy("mLock")

    /* renamed from: a  reason: collision with root package name */
    public m.a<T> f64085a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f64086b;

    /* renamed from: c  reason: collision with root package name */
    public final o.a f64087c;

    /* renamed from: d  reason: collision with root package name */
    public final int f64088d;

    /* renamed from: e  reason: collision with root package name */
    public String f64089e;

    /* renamed from: f  reason: collision with root package name */
    public String f64090f;

    /* renamed from: g  reason: collision with root package name */
    public final int f64091g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f64092h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f64093i;

    /* renamed from: j  reason: collision with root package name */
    public l f64094j;
    public boolean k;
    @GuardedBy("mLock")
    public boolean l;
    @GuardedBy("mLock")
    public boolean m;
    public boolean n;
    public com.bytedance.sdk.component.adnet.face.d o;
    public a.C1882a p;
    public Object q;
    public long r;
    public long s;
    public boolean t;
    public String u;
    public Map<String, Object> v;
    @GuardedBy("mLock")
    public a w;

    /* loaded from: classes9.dex */
    public interface a {
        void a(Request<?> request);

        void a(Request<?> request, m<?> mVar);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f64098a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f64099b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f64100c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f64101d;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ b[] f64102e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(636769476, "Lcom/bytedance/sdk/component/adnet/core/Request$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(636769476, "Lcom/bytedance/sdk/component/adnet/core/Request$b;");
                    return;
                }
            }
            f64098a = new b("LOW", 0);
            f64099b = new b("NORMAL", 1);
            f64100c = new b("HIGH", 2);
            b bVar = new b("IMMEDIATE", 3);
            f64101d = bVar;
            f64102e = new b[]{f64098a, f64099b, f64100c, bVar};
        }

        public b(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static b valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (b) Enum.valueOf(b.class, str) : (b) invokeL.objValue;
        }

        public static b[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (b[]) f64102e.clone() : (b[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public Request(String str, m.a aVar) {
        this(-1, str, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (m.a) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static int b(String str) {
        Uri parse;
        String host;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
                    return 0;
                }
                return host.hashCode();
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public abstract m<T> a(i iVar);

    public VAdError a(VAdError vAdError) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vAdError)) == null) ? vAdError : (VAdError) invokeL.objValue;
    }

    public void a(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
        }
    }

    public abstract void a(m<T> mVar);

    public Request addExtra(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, obj)) == null) {
            if (!TextUtils.isEmpty(str) && obj != null) {
                if (this.v == null) {
                    this.v = new HashMap();
                }
                this.v.put(str, obj);
            }
            return this;
        }
        return (Request) invokeLL.objValue;
    }

    public void addMarker(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && o.a.f64182a) {
            this.f64087c.a(str, Thread.currentThread().getId());
        }
    }

    public void build(l lVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, lVar) == null) || lVar == null) {
            return;
        }
        lVar.a(this);
    }

    public Map<String, String> c() throws com.bytedance.sdk.component.adnet.err.a {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @CallSuper
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this.f64092h) {
                this.l = true;
                this.f64085a = null;
            }
        }
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((Request) ((Request) obj));
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? "UTF-8" : (String) invokeV.objValue;
    }

    public void deliverError(m<T> mVar) {
        m.a<T> aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, mVar) == null) {
            synchronized (this.f64092h) {
                aVar = this.f64085a;
            }
            if (aVar != null) {
                aVar.b(mVar);
            }
        }
    }

    public void e() {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            synchronized (this.f64092h) {
                aVar = this.w;
            }
            if (aVar != null) {
                aVar.a(this);
            }
        }
    }

    @Nullable
    public m.a getBaseListener() {
        InterceptResult invokeV;
        m.a<T> aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            synchronized (this.f64092h) {
                aVar = this.f64085a;
            }
            return aVar;
        }
        return (m.a) invokeV.objValue;
    }

    public byte[] getBody() throws com.bytedance.sdk.component.adnet.err.a {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            Map<String, String> c2 = c();
            if (c2 == null || c2.size() <= 0) {
                return null;
            }
            return a(c2, d());
        }
        return (byte[]) invokeV.objValue;
    }

    public String getBodyContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "application/x-www-form-urlencoded; charset=" + d();
        }
        return (String) invokeV.objValue;
    }

    public a.C1882a getCacheEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.p : (a.C1882a) invokeV.objValue;
    }

    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String url = getUrl();
            int method = getMethod();
            if (method == 0 || method == -1) {
                return url;
            }
            return Integer.toString(method) + SignatureImpl.SEP + url;
        }
        return (String) invokeV.objValue;
    }

    public Map<String, Object> getExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.v : (Map) invokeV.objValue;
    }

    public Map<String, String> getHeaders() throws com.bytedance.sdk.component.adnet.err.a {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? Collections.emptyMap() : (Map) invokeV.objValue;
    }

    public String getIpAddrStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.u : (String) invokeV.objValue;
    }

    public int getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f64088d : invokeV.intValue;
    }

    public long getNetDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.s : invokeV.longValue;
    }

    @Deprecated
    public byte[] getPostBody() throws com.bytedance.sdk.component.adnet.err.a {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            Map<String, String> a2 = a();
            if (a2 == null || a2.size() <= 0) {
                return null;
            }
            return a(a2, b());
        }
        return (byte[]) invokeV.objValue;
    }

    public b getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? b.f64099b : (b) invokeV.objValue;
    }

    public final l getRequestQueue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f64094j : (l) invokeV.objValue;
    }

    public com.bytedance.sdk.component.adnet.face.d getRetryPolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.o : (com.bytedance.sdk.component.adnet.face.d) invokeV.objValue;
    }

    public final int getSequence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            Integer num = this.f64093i;
            if (num != null) {
                return num.intValue();
            }
            throw new IllegalStateException("getSequence called before setSequence");
        }
        return invokeV.intValue;
    }

    public long getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.r : invokeV.longValue;
    }

    public Object getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.q : invokeV.objValue;
    }

    public final int getTimeoutMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? getRetryPolicy().a() : invokeV.intValue;
    }

    public int getTrafficStatsTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f64091g : invokeV.intValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f64089e : (String) invokeV.objValue;
    }

    public String getUserAgent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f64090f : (String) invokeV.objValue;
    }

    public boolean hasHadResponseDelivered() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            synchronized (this.f64092h) {
                z = this.m;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean isCanceled() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            synchronized (this.f64092h) {
                z = this.l;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean isResponseOnMain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public void markDelivered() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            synchronized (this.f64092h) {
                this.m = true;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.bytedance.sdk.component.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setCacheEntry(a.C1882a c1882a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, c1882a)) == null) {
            this.p = c1882a;
            return this;
        }
        return (Request) invokeL.objValue;
    }

    public void setIpAddrStr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.u = str;
        }
    }

    public void setNetDuration(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048623, this, j2) == null) {
            this.s = j2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.bytedance.sdk.component.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRequestQueue(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, lVar)) == null) {
            this.f64094j = lVar;
            return this;
        }
        return (Request) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.bytedance.sdk.component.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setResponseOnMain(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048625, this, z)) == null) {
            this.t = z;
            return this;
        }
        return (Request) invokeZ.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.bytedance.sdk.component.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRetryPolicy(com.bytedance.sdk.component.adnet.face.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, dVar)) == null) {
            this.o = dVar;
            return this;
        }
        return (Request) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.bytedance.sdk.component.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setSequence(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048627, this, i2)) == null) {
            this.f64093i = Integer.valueOf(i2);
            return this;
        }
        return (Request) invokeI.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.bytedance.sdk.component.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldCache(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048628, this, z)) == null) {
            this.k = z;
            return this;
        }
        return (Request) invokeZ.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.bytedance.sdk.component.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldRetryServerErrors(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048629, this, z)) == null) {
            this.n = z;
            return this;
        }
        return (Request) invokeZ.objValue;
    }

    public void setStartTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.r = SystemClock.elapsedRealtime();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.bytedance.sdk.component.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setTag(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, obj)) == null) {
            this.q = obj;
            return this;
        }
        return (Request) invokeL.objValue;
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.f64089e = str;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.bytedance.sdk.component.adnet.core.Request<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setUserAgent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, str)) == null) {
            this.f64090f = str;
            return this;
        }
        return (Request) invokeL.objValue;
    }

    public final boolean shouldCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public final boolean shouldRetryServerErrors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            String str = "0x" + Integer.toHexString(getTrafficStatsTag());
            StringBuilder sb = new StringBuilder();
            sb.append(isCanceled() ? "[X] " : "[ ] ");
            sb.append(getUrl());
            sb.append(" ");
            sb.append(str);
            sb.append(" ");
            sb.append(getPriority());
            sb.append(" ");
            sb.append(this.f64093i);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public Request(int i2, String str, @Nullable m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64087c = o.a.f64182a ? new o.a() : null;
        this.f64090f = "VADNetAgent/0";
        this.f64092h = new Object();
        this.k = true;
        this.l = false;
        this.m = false;
        this.n = false;
        this.p = null;
        this.r = 0L;
        this.s = 0L;
        this.t = true;
        this.f64086b = new Handler(Looper.getMainLooper());
        this.f64088d = i2;
        this.f64089e = str;
        this.f64085a = aVar;
        setRetryPolicy(new e());
        this.f64091g = b(str);
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            l lVar = this.f64094j;
            if (lVar != null) {
                lVar.c(this);
            }
            if (o.a.f64182a) {
                long id = Thread.currentThread().getId();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    this.f64086b.post(new Runnable(this, str, id) { // from class: com.bytedance.sdk.component.adnet.core.Request.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f64095a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ long f64096b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ Request f64097c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str, Long.valueOf(id)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f64097c = this;
                            this.f64095a = str;
                            this.f64096b = id;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f64097c.f64087c.a(this.f64095a, this.f64096b);
                                this.f64097c.f64087c.a(this.f64097c.toString());
                            }
                        }
                    });
                    return;
                }
                this.f64087c.a(str, id);
                this.f64087c.a(toString());
            }
        }
    }

    public int compareTo(Request<T> request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, request)) == null) {
            b priority = getPriority();
            b priority2 = request.getPriority();
            return priority == priority2 ? this.f64093i.intValue() - request.f64093i.intValue() : priority2.ordinal() - priority.ordinal();
        }
        return invokeL.intValue;
    }

    @Deprecated
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? d() : (String) invokeV.objValue;
    }

    public void b(m<?> mVar) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, mVar) == null) {
            synchronized (this.f64092h) {
                aVar = this.w;
            }
            if (aVar != null) {
                aVar.a(this, mVar);
            }
        }
    }

    public void a(int i2) {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (lVar = this.f64094j) == null) {
            return;
        }
        lVar.a(this, i2);
    }

    @Deprecated
    public Map<String, String> a() throws com.bytedance.sdk.component.adnet.err.a {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c() : (Map) invokeV.objValue;
    }

    private byte[] a(Map<String, String> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, map, str)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        sb.append(URLEncoder.encode(entry.getKey(), str));
                        sb.append(com.alipay.sdk.encrypt.a.f35879h);
                        sb.append(URLEncoder.encode(entry.getValue(), str));
                        sb.append(Typography.amp);
                    } else {
                        throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", entry.getKey(), entry.getValue()));
                    }
                }
                return sb.toString().getBytes(str);
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException("Encoding not supported: " + str, e2);
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            synchronized (this.f64092h) {
                this.w = aVar;
            }
        }
    }
}
