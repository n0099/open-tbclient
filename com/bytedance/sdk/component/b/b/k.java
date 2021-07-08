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
/* loaded from: classes5.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final k f28568a;

    /* renamed from: b  reason: collision with root package name */
    public static final k f28569b;

    /* renamed from: c  reason: collision with root package name */
    public static final k f28570c;

    /* renamed from: h  reason: collision with root package name */
    public static final h[] f28571h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f28572d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f28573e;

    /* renamed from: f  reason: collision with root package name */
    public final String[] f28574f;

    /* renamed from: g  reason: collision with root package name */
    public final String[] f28575g;

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
        f28571h = new h[]{h.aX, h.bb, h.aY, h.bc, h.bi, h.bh, h.ay, h.aI, h.az, h.aJ, h.ag, h.ah, h.E, h.I, h.f28558i};
        k a2 = new a(true).a(f28571h).a(ae.f28515a, ae.f28516b, ae.f28517c, ae.f28518d).a(true).a();
        f28568a = a2;
        f28569b = new a(a2).a(ae.f28518d).a(true).a();
        f28570c = new a(false).a();
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
        this.f28572d = aVar.f28576a;
        this.f28574f = aVar.f28577b;
        this.f28575g = aVar.f28578c;
        this.f28573e = aVar.f28579d;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28572d : invokeV.booleanValue;
    }

    public List<h> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String[] strArr = this.f28574f;
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
            String[] strArr = this.f28575g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28573e : invokeV.booleanValue;
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
                boolean z = this.f28572d;
                if (z != kVar.f28572d) {
                    return false;
                }
                return !z || (Arrays.equals(this.f28574f, kVar.f28574f) && Arrays.equals(this.f28575g, kVar.f28575g) && this.f28573e == kVar.f28573e);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f28572d) {
                return ((((527 + Arrays.hashCode(this.f28574f)) * 31) + Arrays.hashCode(this.f28575g)) * 31) + (!this.f28573e ? 1 : 0);
            }
            return 17;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f28572d) {
                String obj = this.f28574f != null ? b().toString() : "[all enabled]";
                String obj2 = this.f28575g != null ? c().toString() : "[all enabled]";
                return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f28573e + SmallTailInfo.EMOTION_SUFFIX;
            }
            return "ConnectionSpec()";
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f28576a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f28577b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f28578c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f28579d;

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
            this.f28576a = z;
        }

        public a a(h... hVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVarArr)) == null) {
                if (this.f28576a) {
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
                if (this.f28576a) {
                    if (strArr.length != 0) {
                        this.f28578c = (String[]) strArr.clone();
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
            this.f28576a = kVar.f28572d;
            this.f28577b = kVar.f28574f;
            this.f28578c = kVar.f28575g;
            this.f28579d = kVar.f28573e;
        }

        public a a(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, strArr)) == null) {
                if (this.f28576a) {
                    if (strArr.length != 0) {
                        this.f28577b = (String[]) strArr.clone();
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
                if (this.f28576a) {
                    String[] strArr = new String[aeVarArr.length];
                    for (int i2 = 0; i2 < aeVarArr.length; i2++) {
                        strArr[i2] = aeVarArr[i2].f28521f;
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
                if (this.f28576a) {
                    this.f28579d = z;
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
            if (this.f28574f != null) {
                enabledCipherSuites = com.bytedance.sdk.component.b.b.a.c.a(h.f28550a, sSLSocket.getEnabledCipherSuites(), this.f28574f);
            } else {
                enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            }
            if (this.f28575g != null) {
                enabledProtocols = com.bytedance.sdk.component.b.b.a.c.a(com.bytedance.sdk.component.b.b.a.c.f28228h, sSLSocket.getEnabledProtocols(), this.f28575g);
            } else {
                enabledProtocols = sSLSocket.getEnabledProtocols();
            }
            String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
            int a2 = com.bytedance.sdk.component.b.b.a.c.a(h.f28550a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
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
            String[] strArr = b2.f28575g;
            if (strArr != null) {
                sSLSocket.setEnabledProtocols(strArr);
            }
            String[] strArr2 = b2.f28574f;
            if (strArr2 != null) {
                sSLSocket.setEnabledCipherSuites(strArr2);
            }
        }
    }

    public boolean a(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sSLSocket)) == null) {
            if (this.f28572d) {
                String[] strArr = this.f28575g;
                if (strArr == null || com.bytedance.sdk.component.b.b.a.c.b(com.bytedance.sdk.component.b.b.a.c.f28228h, strArr, sSLSocket.getEnabledProtocols())) {
                    String[] strArr2 = this.f28574f;
                    return strArr2 == null || com.bytedance.sdk.component.b.b.a.c.b(h.f28550a, strArr2, sSLSocket.getEnabledCipherSuites());
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
