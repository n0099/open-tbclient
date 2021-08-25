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
/* loaded from: classes9.dex */
public final class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ae f64759a;

    /* renamed from: b  reason: collision with root package name */
    public final h f64760b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Certificate> f64761c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Certificate> f64762d;

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
        this.f64759a = aeVar;
        this.f64760b = hVar;
        this.f64761c = list;
        this.f64762d = list2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64761c : (List) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj instanceof r) {
                r rVar = (r) obj;
                return this.f64759a.equals(rVar.f64759a) && this.f64760b.equals(rVar.f64760b) && this.f64761c.equals(rVar.f64761c) && this.f64762d.equals(rVar.f64762d);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ((((((527 + this.f64759a.hashCode()) * 31) + this.f64760b.hashCode()) * 31) + this.f64761c.hashCode()) * 31) + this.f64762d.hashCode() : invokeV.intValue;
    }

    public h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64760b : (h) invokeV.objValue;
    }
}
