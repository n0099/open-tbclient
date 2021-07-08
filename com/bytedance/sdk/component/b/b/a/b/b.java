package com.bytedance.sdk.component.b.b.a.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.k;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<k> f28186a;

    /* renamed from: b  reason: collision with root package name */
    public int f28187b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28188c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f28189d;

    public b(List<k> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28187b = 0;
        this.f28186a = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, sSLSocket)) == null) {
            for (int i2 = this.f28187b; i2 < this.f28186a.size(); i2++) {
                if (this.f28186a.get(i2).a(sSLSocket)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public k a(SSLSocket sSLSocket) throws IOException {
        InterceptResult invokeL;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sSLSocket)) == null) {
            int i2 = this.f28187b;
            int size = this.f28186a.size();
            while (true) {
                if (i2 >= size) {
                    kVar = null;
                    break;
                }
                kVar = this.f28186a.get(i2);
                if (kVar.a(sSLSocket)) {
                    this.f28187b = i2 + 1;
                    break;
                }
                i2++;
            }
            if (kVar != null) {
                this.f28188c = b(sSLSocket);
                com.bytedance.sdk.component.b.b.a.a.f28146a.a(kVar, sSLSocket, this.f28189d);
                return kVar;
            }
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f28189d + ", modes=" + this.f28186a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        return (k) invokeL.objValue;
    }

    public boolean a(IOException iOException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException)) == null) {
            this.f28189d = true;
            if (!this.f28188c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
                return false;
            }
            boolean z = iOException instanceof SSLHandshakeException;
            if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
                return false;
            }
            return z || (iOException instanceof SSLProtocolException);
        }
        return invokeL.booleanValue;
    }
}
