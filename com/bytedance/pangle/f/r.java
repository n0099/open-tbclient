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
/* loaded from: classes6.dex */
public class r extends X509Certificate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final X509Certificate a;

    public r(X509Certificate x509Certificate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x509Certificate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = x509Certificate;
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.checkValidity();
        }
    }

    @Override // java.security.cert.X509Certificate
    public int getBasicConstraints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getBasicConstraints() : invokeV.intValue;
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getCriticalExtensionOIDs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.getCriticalExtensionOIDs() : (Set) invokeV.objValue;
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.getEncoded() : (byte[]) invokeV.objValue;
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.a.getExtensionValue(str) : (byte[]) invokeL.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public Principal getIssuerDN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a.getIssuerDN() : (Principal) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getIssuerUniqueID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.getIssuerUniqueID() : (boolean[]) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getKeyUsage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.getKeyUsage() : (boolean[]) invokeV.objValue;
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getNonCriticalExtensionOIDs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a.getNonCriticalExtensionOIDs() : (Set) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotAfter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a.getNotAfter() : (Date) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotBefore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a.getNotBefore() : (Date) invokeV.objValue;
    }

    @Override // java.security.cert.Certificate
    public PublicKey getPublicKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a.getPublicKey() : (PublicKey) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a.getSerialNumber() : (BigInteger) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.a.getSigAlgName() : (String) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgOID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.a.getSigAlgOID() : (String) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.a.getSigAlgParams() : (byte[]) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.a.getSignature() : (byte[]) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public Principal getSubjectDN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.a.getSubjectDN() : (Principal) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getSubjectUniqueID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.a.getSubjectUniqueID() : (boolean[]) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.a.getTBSCertificate() : (byte[]) invokeV.objValue;
    }

    @Override // java.security.cert.X509Certificate
    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.a.getVersion() : invokeV.intValue;
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.a.hasUnsupportedCriticalExtension() : invokeV.booleanValue;
    }

    @Override // java.security.cert.Certificate
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.a.toString() : (String) invokeV.objValue;
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey publicKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, publicKey) == null) {
            this.a.verify(publicKey);
        }
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, date) == null) {
            this.a.checkValidity(date);
        }
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey publicKey, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, publicKey, str) == null) {
            this.a.verify(publicKey, str);
        }
    }
}
