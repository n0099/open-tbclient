package com.bytedance.sdk.component.b.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.CertificatePinner;
/* loaded from: classes9.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final g f64693a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Set<b> f64694b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.a.i.c f64695c;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<b> f64696a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64696a = new ArrayList();
        }

        public g a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new g(new LinkedHashSet(this.f64696a), null) : (g) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f64697a;

        /* renamed from: b  reason: collision with root package name */
        public final String f64698b;

        /* renamed from: c  reason: collision with root package name */
        public final String f64699c;

        /* renamed from: d  reason: collision with root package name */
        public final com.bytedance.sdk.component.b.a.f f64700d;

        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.f64697a.startsWith(CertificatePinner.Pin.WILDCARD)) {
                    int indexOf = str.indexOf(46);
                    if ((str.length() - indexOf) - 1 == this.f64698b.length()) {
                        String str2 = this.f64698b;
                        if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                            return true;
                        }
                    }
                    return false;
                }
                return str.equals(this.f64698b);
            }
            return invokeL.booleanValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (this.f64697a.equals(bVar.f64697a) && this.f64699c.equals(bVar.f64699c) && this.f64700d.equals(bVar.f64700d)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ((((527 + this.f64697a.hashCode()) * 31) + this.f64699c.hashCode()) * 31) + this.f64700d.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.f64699c + this.f64700d.b();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(731368723, "Lcom/bytedance/sdk/component/b/b/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(731368723, "Lcom/bytedance/sdk/component/b/b/g;");
                return;
            }
        }
        f64693a = new a().a();
    }

    public g(Set<b> set, com.bytedance.sdk.component.b.b.a.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {set, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64694b = set;
        this.f64695c = cVar;
    }

    public static com.bytedance.sdk.component.b.a.f b(X509Certificate x509Certificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, x509Certificate)) == null) ? com.bytedance.sdk.component.b.a.f.a(x509Certificate.getPublicKey().getEncoded()).d() : (com.bytedance.sdk.component.b.a.f) invokeL.objValue;
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, list) == null) {
            List<b> a2 = a(str);
            if (a2.isEmpty()) {
                return;
            }
            com.bytedance.sdk.component.b.b.a.i.c cVar = this.f64695c;
            if (cVar != null) {
                list = cVar.a(list, str);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i2);
                int size2 = a2.size();
                com.bytedance.sdk.component.b.a.f fVar = null;
                com.bytedance.sdk.component.b.a.f fVar2 = null;
                for (int i3 = 0; i3 < size2; i3++) {
                    b bVar = a2.get(i3);
                    if (bVar.f64699c.equals("sha256/")) {
                        if (fVar == null) {
                            fVar = b(x509Certificate);
                        }
                        if (bVar.f64700d.equals(fVar)) {
                            return;
                        }
                    } else if (bVar.f64699c.equals("sha1/")) {
                        if (fVar2 == null) {
                            fVar2 = a(x509Certificate);
                        }
                        if (bVar.f64700d.equals(fVar2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.f64699c);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i4 = 0; i4 < size3; i4++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i4);
                sb.append("\n    ");
                sb.append(a((Certificate) x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            int size4 = a2.size();
            for (int i5 = 0; i5 < size4; i5++) {
                sb.append("\n    ");
                sb.append(a2.get(i5));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof g) {
                g gVar = (g) obj;
                if (com.bytedance.sdk.component.b.b.a.c.a(this.f64695c, gVar.f64695c) && this.f64694b.equals(gVar.f64694b)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            com.bytedance.sdk.component.b.b.a.i.c cVar = this.f64695c;
            return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f64694b.hashCode();
        }
        return invokeV.intValue;
    }

    public List<b> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            List<b> emptyList = Collections.emptyList();
            for (b bVar : this.f64694b) {
                if (bVar.a(str)) {
                    if (emptyList.isEmpty()) {
                        emptyList = new ArrayList<>();
                    }
                    emptyList.add(bVar);
                }
            }
            return emptyList;
        }
        return (List) invokeL.objValue;
    }

    public g a(com.bytedance.sdk.component.b.b.a.i.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? com.bytedance.sdk.component.b.b.a.c.a(this.f64695c, cVar) ? this : new g(this.f64694b, cVar) : (g) invokeL.objValue;
    }

    public static String a(Certificate certificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, certificate)) == null) {
            if (certificate instanceof X509Certificate) {
                return "sha256/" + b((X509Certificate) certificate).b();
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return (String) invokeL.objValue;
    }

    public static com.bytedance.sdk.component.b.a.f a(X509Certificate x509Certificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, x509Certificate)) == null) ? com.bytedance.sdk.component.b.a.f.a(x509Certificate.getPublicKey().getEncoded()).c() : (com.bytedance.sdk.component.b.a.f) invokeL.objValue;
    }
}
