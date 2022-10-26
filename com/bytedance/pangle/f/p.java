package com.bytedance.pangle.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class p extends r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x509Certificate, bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((X509Certificate) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = -1;
        this.a = bArr;
    }

    @Override // java.security.cert.Certificate
    public final boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof p)) {
                return false;
            }
            try {
                return Arrays.equals(getEncoded(), ((p) obj).getEncoded());
            } catch (CertificateEncodingException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.bytedance.pangle.f.r, java.security.cert.Certificate
    public final byte[] getEncoded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // java.security.cert.Certificate
    public final int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b == -1) {
                try {
                    this.b = Arrays.hashCode(getEncoded());
                } catch (CertificateEncodingException unused) {
                    this.b = 0;
                }
            }
            return this.b;
        }
        return invokeV.intValue;
    }
}
