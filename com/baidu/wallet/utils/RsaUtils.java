package com.baidu.wallet.utils;

import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/* loaded from: classes2.dex */
public class RsaUtils implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public static String privateKey;
    public static String publicKey;
    public transient /* synthetic */ FieldHolder $fh;

    public RsaUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String decrypt(RSAPrivateKey rSAPrivateKey, String str) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, rSAPrivateKey, str)) == null) {
            if (rSAPrivateKey == null || TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, rSAPrivateKey);
                return new String(cipher.doFinal(Base64.decode(str, 2)), "UTF-8");
            } catch (InvalidKeyException unused) {
                throw new Exception("解密公钥非法,请检查");
            } catch (NoSuchAlgorithmException unused2) {
                throw new Exception("无此解密算法");
            } catch (BadPaddingException unused3) {
                throw new Exception("密文数据已损坏");
            } catch (IllegalBlockSizeException unused4) {
                throw new Exception("密文长度非法");
            } catch (NoSuchPaddingException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String encrypt(RSAPublicKey rSAPublicKey, String str) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, rSAPublicKey, str)) == null) {
            if (rSAPublicKey == null || TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, rSAPublicKey);
                return Base64.encodeToString(cipher.doFinal(str.getBytes("UTF-8")), 2);
            } catch (InvalidKeyException unused) {
                throw new Exception("加密公钥非法,请检查");
            } catch (NoSuchAlgorithmException unused2) {
                throw new Exception("无此加密算法");
            } catch (BadPaddingException unused3) {
                throw new Exception("明文数据已损坏");
            } catch (IllegalBlockSizeException unused4) {
                throw new Exception("明文长度非法");
            } catch (NoSuchPaddingException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static void genKeyPair() {
        KeyPairGenerator keyPairGenerator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            try {
                keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                keyPairGenerator = null;
            }
            keyPairGenerator.initialize(1024, new SecureRandom());
            KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
            privateKey = Base64.encodeToString(generateKeyPair.getPrivate().getEncoded(), 2);
            publicKey = Base64.encodeToString(generateKeyPair.getPublic().getEncoded(), 2);
        }
    }

    public static String getPrivateKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? privateKey : (String) invokeV.objValue;
    }

    public static String getPublicKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? publicKey : (String) invokeV.objValue;
    }

    public static RSAPrivateKey loadPrivateKeyByStr(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 2)));
            } catch (NullPointerException unused) {
                throw new Exception("私钥数据为空");
            } catch (NoSuchAlgorithmException unused2) {
                throw new Exception("无此算法");
            } catch (InvalidKeySpecException unused3) {
                throw new Exception("私钥非法");
            }
        }
        return (RSAPrivateKey) invokeL.objValue;
    }

    public static RSAPublicKey loadPublicKeyByStr(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
            } catch (NullPointerException unused) {
                throw new Exception("公钥数据为空");
            } catch (NoSuchAlgorithmException unused2) {
                throw new Exception("无此算法");
            } catch (InvalidKeySpecException unused3) {
                throw new Exception("公钥非法");
            }
        }
        return (RSAPublicKey) invokeL.objValue;
    }
}
