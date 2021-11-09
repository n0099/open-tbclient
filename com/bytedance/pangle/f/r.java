package com.bytedance.pangle.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigInteger;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Set;
/* loaded from: classes11.dex */
public class r extends X509Certificate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final X509Certificate f61420a;

    public r(X509Certificate x509Certificate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x509Certificate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61420a = x509Certificate;
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f61420a.checkValidity();
        }
    }

    @Override // java.security.cert.X509Certificate
    public int getBasicConstraints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f61420a.getBasicConstraints() : invokeV.intValue;
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getCriticalExtensionOIDs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f61420a.getCriticalExtensionOIDs() : (Set) invokeV.objValue;
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f61420a.getEncoded() : (byte[]) invokeV.objValue;
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.f61420a.getExtensionValue(str) : (byte[]) invokeL.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public Principal getIssuerDN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f61420a.getIssuerDN() : (Principal) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getIssuerUniqueID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f61420a.getIssuerUniqueID() : (boolean[]) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getKeyUsage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f61420a.getKeyUsage() : (boolean[]) invokeV.objValue;
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getNonCriticalExtensionOIDs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f61420a.getNonCriticalExtensionOIDs() : (Set) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotAfter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f61420a.getNotAfter() : (Date) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotBefore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f61420a.getNotBefore() : (Date) invokeV.objValue;
    }

    @Override // java.security.cert.Certificate
    public PublicKey getPublicKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f61420a.getPublicKey() : (PublicKey) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f61420a.getSerialNumber() : (BigInteger) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f61420a.getSigAlgName() : (String) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgOID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f61420a.getSigAlgOID() : (String) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f61420a.getSigAlgParams() : (byte[]) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f61420a.getSignature() : (byte[]) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public Principal getSubjectDN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f61420a.getSubjectDN() : (Principal) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getSubjectUniqueID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f61420a.getSubjectUniqueID() : (boolean[]) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f61420a.getTBSCertificate() : (byte[]) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f61420a.getVersion() : invokeV.intValue;
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f61420a.hasUnsupportedCriticalExtension() : invokeV.booleanValue;
    }

    @Override // java.security.cert.Certificate
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f61420a.toString() : (String) invokeV.objValue;
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey publicKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, publicKey) == null) {
            this.f61420a.verify(publicKey);
        }
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, date) == null) {
            this.f61420a.checkValidity(date);
        }
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey publicKey, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, publicKey, str) == null) {
            this.f61420a.verify(publicKey, str);
        }
    }
}
