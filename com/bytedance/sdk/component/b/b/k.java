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
    public static final k f64720a;

    /* renamed from: b  reason: collision with root package name */
    public static final k f64721b;

    /* renamed from: c  reason: collision with root package name */
    public static final k f64722c;

    /* renamed from: h  reason: collision with root package name */
    public static final h[] f64723h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f64724d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f64725e;

    /* renamed from: f  reason: collision with root package name */
    public final String[] f64726f;

    /* renamed from: g  reason: collision with root package name */
    public final String[] f64727g;

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
        f64723h = new h[]{h.aX, h.bb, h.aY, h.bc, h.bi, h.bh, h.ay, h.aI, h.az, h.aJ, h.ag, h.ah, h.E, h.I, h.f64709i};
        k a2 = new a(true).a(f64723h).a(ae.f64665a, ae.f64666b, ae.f64667c, ae.f64668d).a(true).a();
        f64720a = a2;
        f64721b = new a(a2).a(ae.f64668d).a(true).a();
        f64722c = new a(false).a();
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
        this.f64724d = aVar.f64728a;
        this.f64726f = aVar.f64729b;
        this.f64727g = aVar.f64730c;
        this.f64725e = aVar.f64731d;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64724d : invokeV.booleanValue;
    }

    public List<h> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String[] strArr = this.f64726f;
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
            String[] strArr = this.f64727g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f64725e : invokeV.booleanValue;
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
                boolean z = this.f64724d;
                if (z != kVar.f64724d) {
                    return false;
                }
                return !z || (Arrays.equals(this.f64726f, kVar.f64726f) && Arrays.equals(this.f64727g, kVar.f64727g) && this.f64725e == kVar.f64725e);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f64724d) {
                return ((((527 + Arrays.hashCode(this.f64726f)) * 31) + Arrays.hashCode(this.f64727g)) * 31) + (!this.f64725e ? 1 : 0);
            }
            return 17;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f64724d) {
                String obj = this.f64726f != null ? b().toString() : "[all enabled]";
                String obj2 = this.f64727g != null ? c().toString() : "[all enabled]";
                return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f64725e + SmallTailInfo.EMOTION_SUFFIX;
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
        public boolean f64728a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f64729b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f64730c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64731d;

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
            this.f64728a = z;
        }

        public a a(h... hVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVarArr)) == null) {
                if (this.f64728a) {
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
                if (this.f64728a) {
                    if (strArr.length != 0) {
                        this.f64730c = (String[]) strArr.clone();
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
            this.f64728a = kVar.f64724d;
            this.f64729b = kVar.f64726f;
            this.f64730c = kVar.f64727g;
            this.f64731d = kVar.f64725e;
        }

        public a a(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, strArr)) == null) {
                if (this.f64728a) {
                    if (strArr.length != 0) {
                        this.f64729b = (String[]) strArr.clone();
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
                if (this.f64728a) {
                    String[] strArr = new String[aeVarArr.length];
                    for (int i2 = 0; i2 < aeVarArr.length; i2++) {
                        strArr[i2] = aeVarArr[i2].f64671f;
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
                if (this.f64728a) {
                    this.f64731d = z;
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
            if (this.f64726f != null) {
                enabledCipherSuites = com.bytedance.sdk.component.b.b.a.c.a(h.f64701a, sSLSocket.getEnabledCipherSuites(), this.f64726f);
            } else {
                enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            }
            if (this.f64727g != null) {
                enabledProtocols = com.bytedance.sdk.component.b.b.a.c.a(com.bytedance.sdk.component.b.b.a.c.f64370h, sSLSocket.getEnabledProtocols(), this.f64727g);
            } else {
                enabledProtocols = sSLSocket.getEnabledProtocols();
            }
            String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
            int a2 = com.bytedance.sdk.component.b.b.a.c.a(h.f64701a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
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
            String[] strArr = b2.f64727g;
            if (strArr != null) {
                sSLSocket.setEnabledProtocols(strArr);
            }
            String[] strArr2 = b2.f64726f;
            if (strArr2 != null) {
                sSLSocket.setEnabledCipherSuites(strArr2);
            }
        }
    }

    public boolean a(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sSLSocket)) == null) {
            if (this.f64724d) {
                String[] strArr = this.f64727g;
                if (strArr == null || com.bytedance.sdk.component.b.b.a.c.b(com.bytedance.sdk.component.b.b.a.c.f64370h, strArr, sSLSocket.getEnabledProtocols())) {
                    String[] strArr2 = this.f64726f;
                    return strArr2 == null || com.bytedance.sdk.component.b.b.a.c.b(h.f64701a, strArr2, sSLSocket.getEnabledCipherSuites());
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
