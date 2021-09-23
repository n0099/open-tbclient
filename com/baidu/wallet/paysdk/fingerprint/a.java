package com.baidu.wallet.paysdk.fingerprint;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.security.keystore.KeyGenParameterSpec;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
@TargetApi(23)
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f62821b = "wallet_fp_ks_alias";

    /* renamed from: c  reason: collision with root package name */
    public static a f62822c = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f62823d = "a";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public KeyStore f62824a;

    /* renamed from: e  reason: collision with root package name */
    public Context f62825e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1724727962, "Lcom/baidu/wallet/paysdk/fingerprint/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1724727962, "Lcom/baidu/wallet/paysdk/fingerprint/a;");
        }
    }

    public a(Context context) throws KeyStoreException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            this.f62825e = context.getApplicationContext();
            this.f62824a = KeyStore.getInstance("AndroidKeyStore");
        } catch (KeyStoreException e2) {
            StatisticManager.onEvent("fprd_keystroed_exception_happends");
            e2.printStackTrace();
            throw new KeyStoreException("getInstance keystore occured Exception!");
        }
    }

    public static a a(Context context) throws KeyStoreException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f62822c == null) {
                synchronized (a.class) {
                    if (f62822c == null) {
                        f62822c = new a(context);
                    }
                }
            }
            return f62822c;
        }
        return (a) invokeL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                this.f62824a.load(null);
                keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("CBC").setUserAuthenticationRequired(true).setEncryptionPaddings("PKCS7Padding").setRandomizedEncryptionRequired(false).build());
                keyGenerator.generateKey();
            } catch (IOException | InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException | CertificateException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public FingerprintManager.CryptoObject a(int i2, byte[] bArr) throws InvalidKeyException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, bArr)) == null) {
            try {
                this.f62824a.load(null);
                SecretKey secretKey = (SecretKey) this.f62824a.getKey(WalletFingerprint.getKeyStoreNewAlise(this.f62825e), null);
                if (secretKey == null) {
                    return null;
                }
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                if (i2 == 1) {
                    cipher.init(i2, secretKey, cipher.getParameters());
                } else {
                    cipher.init(i2, secretKey, new IvParameterSpec(bArr));
                }
                return new FingerprintManager.CryptoObject(cipher);
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                return null;
            } catch (InvalidAlgorithmParameterException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvalidKeyException e4) {
                throw e4;
            } catch (KeyStoreException e5) {
                e = e5;
                e.printStackTrace();
                return null;
            } catch (NoSuchAlgorithmException e6) {
                e = e6;
                e.printStackTrace();
                return null;
            } catch (UnrecoverableKeyException e7) {
                e = e7;
                e.printStackTrace();
                return null;
            } catch (CertificateException e8) {
                e = e8;
                e.printStackTrace();
                return null;
            } catch (NoSuchPaddingException e9) {
                e9.printStackTrace();
                return null;
            }
        }
        return (FingerprintManager.CryptoObject) invokeIL.objValue;
    }
}
