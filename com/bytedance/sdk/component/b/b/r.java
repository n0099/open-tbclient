package com.bytedance.sdk.component.b.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
/* loaded from: classes5.dex */
public final class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ae f28606a;

    /* renamed from: b  reason: collision with root package name */
    public final h f28607b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Certificate> f28608c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Certificate> f28609d;

    public r(ae aeVar, h hVar, List<Certificate> list, List<Certificate> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aeVar, hVar, list, list2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28606a = aeVar;
        this.f28607b = hVar;
        this.f28608c = list;
        this.f28609d = list2;
    }

    public static r a(SSLSession sSLSession) {
        InterceptResult invokeL;
        Certificate[] certificateArr;
        List emptyList;
        List emptyList2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sSLSession)) == null) {
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite != null) {
                h a2 = h.a(cipherSuite);
                String protocol = sSLSession.getProtocol();
                if (protocol != null) {
                    ae a3 = ae.a(protocol);
                    try {
                        certificateArr = sSLSession.getPeerCertificates();
                    } catch (SSLPeerUnverifiedException unused) {
                        certificateArr = null;
                    }
                    if (certificateArr != null) {
                        emptyList = com.bytedance.sdk.component.b.b.a.c.a(certificateArr);
                    } else {
                        emptyList = Collections.emptyList();
                    }
                    Certificate[] localCertificates = sSLSession.getLocalCertificates();
                    if (localCertificates != null) {
                        emptyList2 = com.bytedance.sdk.component.b.b.a.c.a(localCertificates);
                    } else {
                        emptyList2 = Collections.emptyList();
                    }
                    return new r(a3, a2, emptyList, emptyList2);
                }
                throw new IllegalStateException("tlsVersion == null");
            }
            throw new IllegalStateException("cipherSuite == null");
        }
        return (r) invokeL.objValue;
    }

    public List<Certificate> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28608c : (List) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj instanceof r) {
                r rVar = (r) obj;
                return this.f28606a.equals(rVar.f28606a) && this.f28607b.equals(rVar.f28607b) && this.f28608c.equals(rVar.f28608c) && this.f28609d.equals(rVar.f28609d);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ((((((527 + this.f28606a.hashCode()) * 31) + this.f28607b.hashCode()) * 31) + this.f28608c.hashCode()) * 31) + this.f28609d.hashCode() : invokeV.intValue;
    }

    public h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28607b : (h) invokeV.objValue;
    }
}
