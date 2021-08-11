package com.bytedance.sdk.component.b.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
/* loaded from: classes9.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final k f64520a;

    /* renamed from: b  reason: collision with root package name */
    public static final k f64521b;

    /* renamed from: c  reason: collision with root package name */
    public static final k f64522c;

    /* renamed from: h  reason: collision with root package name */
    public static final h[] f64523h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f64524d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f64525e;

    /* renamed from: f  reason: collision with root package name */
    public final String[] f64526f;

    /* renamed from: g  reason: collision with root package name */
    public final String[] f64527g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(731368847, "Lcom/bytedance/sdk/component/b/b/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(731368847, "Lcom/bytedance/sdk/component/b/b/k;");
                return;
            }
        }
        f64523h = new h[]{h.aX, h.bb, h.aY, h.bc, h.bi, h.bh, h.ay, h.aI, h.az, h.aJ, h.ag, h.ah, h.E, h.I, h.f64509i};
        k a2 = new a(true).a(f64523h).a(ae.f64465a, ae.f64466b, ae.f64467c, ae.f64468d).a(true).a();
        f64520a = a2;
        f64521b = new a(a2).a(ae.f64468d).a(true).a();
        f64522c = new a(false).a();
    }

    public k(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64524d = aVar.f64528a;
        this.f64526f = aVar.f64529b;
        this.f64527g = aVar.f64530c;
        this.f64525e = aVar.f64531d;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64524d : invokeV.booleanValue;
    }

    public List<h> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String[] strArr = this.f64526f;
            if (strArr != null) {
                return h.a(strArr);
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public List<ae> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String[] strArr = this.f64527g;
            if (strArr != null) {
                return ae.a(strArr);
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f64525e : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj instanceof k) {
                if (obj == this) {
                    return true;
                }
                k kVar = (k) obj;
                boolean z = this.f64524d;
                if (z != kVar.f64524d) {
                    return false;
                }
                return !z || (Arrays.equals(this.f64526f, kVar.f64526f) && Arrays.equals(this.f64527g, kVar.f64527g) && this.f64525e == kVar.f64525e);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f64524d) {
                return ((((527 + Arrays.hashCode(this.f64526f)) * 31) + Arrays.hashCode(this.f64527g)) * 31) + (!this.f64525e ? 1 : 0);
            }
            return 17;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f64524d) {
                String obj = this.f64526f != null ? b().toString() : "[all enabled]";
                String obj2 = this.f64527g != null ? c().toString() : "[all enabled]";
                return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f64525e + SmallTailInfo.EMOTION_SUFFIX;
            }
            return "ConnectionSpec()";
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f64528a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f64529b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f64530c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64531d;

        public a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f64528a = z;
        }

        public a a(h... hVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVarArr)) == null) {
                if (this.f64528a) {
                    String[] strArr = new String[hVarArr.length];
                    for (int i2 = 0; i2 < hVarArr.length; i2++) {
                        strArr[i2] = hVarArr[i2].bj;
                    }
                    return a(strArr);
                }
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            return (a) invokeL.objValue;
        }

        public a b(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, strArr)) == null) {
                if (this.f64528a) {
                    if (strArr.length != 0) {
                        this.f64530c = (String[]) strArr.clone();
                        return this;
                    }
                    throw new IllegalArgumentException("At least one TLS version is required");
                }
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            return (a) invokeL.objValue;
        }

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64528a = kVar.f64524d;
            this.f64529b = kVar.f64526f;
            this.f64530c = kVar.f64527g;
            this.f64531d = kVar.f64525e;
        }

        public a a(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, strArr)) == null) {
                if (this.f64528a) {
                    if (strArr.length != 0) {
                        this.f64529b = (String[]) strArr.clone();
                        return this;
                    }
                    throw new IllegalArgumentException("At least one cipher suite is required");
                }
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            return (a) invokeL.objValue;
        }

        public a a(ae... aeVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aeVarArr)) == null) {
                if (this.f64528a) {
                    String[] strArr = new String[aeVarArr.length];
                    for (int i2 = 0; i2 < aeVarArr.length; i2++) {
                        strArr[i2] = aeVarArr[i2].f64471f;
                    }
                    return b(strArr);
                }
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            return (a) invokeL.objValue;
        }

        public a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                if (this.f64528a) {
                    this.f64531d = z;
                    return this;
                }
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            return (a) invokeZ.objValue;
        }

        public k a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new k(this) : (k) invokeV.objValue;
        }
    }

    private k b(SSLSocket sSLSocket, boolean z) {
        InterceptResult invokeLZ;
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, this, sSLSocket, z)) == null) {
            if (this.f64526f != null) {
                enabledCipherSuites = com.bytedance.sdk.component.b.b.a.c.a(h.f64501a, sSLSocket.getEnabledCipherSuites(), this.f64526f);
            } else {
                enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            }
            if (this.f64527g != null) {
                enabledProtocols = com.bytedance.sdk.component.b.b.a.c.a(com.bytedance.sdk.component.b.b.a.c.f64170h, sSLSocket.getEnabledProtocols(), this.f64527g);
            } else {
                enabledProtocols = sSLSocket.getEnabledProtocols();
            }
            String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
            int a2 = com.bytedance.sdk.component.b.b.a.c.a(h.f64501a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
            if (z && a2 != -1) {
                enabledCipherSuites = com.bytedance.sdk.component.b.b.a.c.a(enabledCipherSuites, supportedCipherSuites[a2]);
            }
            return new a(this).a(enabledCipherSuites).b(enabledProtocols).a();
        }
        return (k) invokeLZ.objValue;
    }

    public void a(SSLSocket sSLSocket, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, sSLSocket, z) == null) {
            k b2 = b(sSLSocket, z);
            String[] strArr = b2.f64527g;
            if (strArr != null) {
                sSLSocket.setEnabledProtocols(strArr);
            }
            String[] strArr2 = b2.f64526f;
            if (strArr2 != null) {
                sSLSocket.setEnabledCipherSuites(strArr2);
            }
        }
    }

    public boolean a(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sSLSocket)) == null) {
            if (this.f64524d) {
                String[] strArr = this.f64527g;
                if (strArr == null || com.bytedance.sdk.component.b.b.a.c.b(com.bytedance.sdk.component.b.b.a.c.f64170h, strArr, sSLSocket.getEnabledProtocols())) {
                    String[] strArr2 = this.f64526f;
                    return strArr2 == null || com.bytedance.sdk.component.b.b.a.c.b(h.f64501a, strArr2, sSLSocket.getEnabledCipherSuites());
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
