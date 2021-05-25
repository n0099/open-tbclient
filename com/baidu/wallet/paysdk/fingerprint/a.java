package com.baidu.wallet.paysdk.fingerprint;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.security.keystore.KeyGenParameterSpec;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.statistics.api.StatisticManager;
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
/* loaded from: classes5.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static String f25263b = "wallet_fp_ks_alias";

    /* renamed from: c  reason: collision with root package name */
    public static a f25264c = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f25265d = "a";

    /* renamed from: a  reason: collision with root package name */
    public KeyStore f25266a;

    /* renamed from: e  reason: collision with root package name */
    public Context f25267e;

    public a(Context context) throws KeyStoreException {
        try {
            this.f25267e = context.getApplicationContext();
            this.f25266a = KeyStore.getInstance("AndroidKeyStore");
        } catch (KeyStoreException e2) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_FP_KEYSTORE_FAILED);
            e2.printStackTrace();
            throw new KeyStoreException("getInstance keystore occured Exception!");
        }
    }

    public static a a(Context context) throws KeyStoreException {
        if (f25264c == null) {
            synchronized (a.class) {
                if (f25264c == null) {
                    f25264c = new a(context);
                }
            }
        }
        return f25264c;
    }

    public boolean a() {
        return true;
    }

    public void a(String str) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            this.f25266a.load(null);
            keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("CBC").setUserAuthenticationRequired(true).setEncryptionPaddings("PKCS7Padding").setRandomizedEncryptionRequired(false).build());
            keyGenerator.generateKey();
            LogUtil.d(f25265d, "GenerateKey Success");
        } catch (IOException | InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException | CertificateException e2) {
            throw new RuntimeException(e2);
        }
    }

    public FingerprintManager.CryptoObject a(int i2, byte[] bArr) throws InvalidKeyException {
        try {
            this.f25266a.load(null);
            SecretKey secretKey = (SecretKey) this.f25266a.getKey(WalletFingerprint.getKeyStoreNewAlise(this.f25267e), null);
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
}
