package com.baidu.wallet.paysdk.fingerprint.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.fingerprint.FpConstancts;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.fingerprint.b;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.paysdk.storage.PayPreferenceManager;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
@TargetApi(23)
/* loaded from: classes6.dex */
public class a extends FingerprintManager.AuthenticationCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FingerprintManager a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.wallet.paysdk.fingerprint.a f50645b;

    /* renamed from: c  reason: collision with root package name */
    public b f50646c;

    /* renamed from: d  reason: collision with root package name */
    public CancellationSignal f50647d;

    /* renamed from: e  reason: collision with root package name */
    public int f50648e;

    /* renamed from: f  reason: collision with root package name */
    public String f50649f;

    /* renamed from: g  reason: collision with root package name */
    public Context f50650g;

    /* renamed from: h  reason: collision with root package name */
    public int f50651h;

    public a(Context context) throws KeyStoreException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50648e = 1;
        this.f50651h = 0;
        this.f50650g = context;
        this.a = (FingerprintManager) context.getSystemService(FingerprintManager.class);
        this.f50645b = com.baidu.wallet.paysdk.fingerprint.a.a(context);
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f50648e = 1;
            if (this.f50646c == null || TextUtils.isEmpty(this.f50649f)) {
                return;
            }
            try {
                FingerprintManager.CryptoObject a = this.f50645b.a(1, null);
                if (a == null) {
                    if (this.f50646c != null) {
                        this.f50646c.a(-1, "");
                        return;
                    }
                    return;
                }
                CancellationSignal cancellationSignal = new CancellationSignal();
                this.f50647d = cancellationSignal;
                this.a.authenticate(a, cancellationSignal, 0, this, null);
            } catch (SecurityException e2) {
                e2.printStackTrace();
                StatisticManager.onEvent("fprd_security_exception_occued_on_encrypt");
                b bVar = this.f50646c;
                if (bVar != null) {
                    bVar.a(-1, "");
                }
            } catch (InvalidKeyException unused) {
                b bVar2 = this.f50646c;
                if (bVar2 != null) {
                    bVar2.a(-3, ResUtils.getString(this.f50650g, "wallet_fp_fingerprint_changed"));
                }
            }
        }
    }

    private void f() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            String[] split = new String(Base64.decode((String) SharedPreferencesUtils.getParam(this.f50650g, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, PayPreferenceManager.getNewPpKey(this.f50650g), ""), 0)).split("\\|");
            if (split.length == 3) {
                this.f50649f = split[0];
                str = split[1];
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f50649f)) {
                this.f50648e = 2;
                try {
                    FingerprintManager.CryptoObject a = this.f50645b.a(2, Base64.decode(str, 0));
                    if (a == null) {
                        StatisticManager.onEventWithValue("fprd_start_fp_failed", "case: decrypttoken & reason : cryptObject is null");
                        if (this.f50646c != null) {
                            this.f50646c.a(-1, "");
                            return;
                        }
                        return;
                    }
                    CancellationSignal cancellationSignal = new CancellationSignal();
                    this.f50647d = cancellationSignal;
                    this.a.authenticate(a, cancellationSignal, 0, this, null);
                    return;
                } catch (SecurityException e2) {
                    e2.printStackTrace();
                    StatisticManager.onEventWithValue("fprd_start_fp_failed", "case: decrypttoken & reason : SecurityException happends");
                    b bVar = this.f50646c;
                    if (bVar != null) {
                        bVar.a(-1, "");
                        return;
                    }
                    return;
                } catch (InvalidKeyException e3) {
                    e3.printStackTrace();
                    WalletFingerprint.getInstance(this.f50650g).clearOTPToken();
                    b bVar2 = this.f50646c;
                    if (bVar2 != null) {
                        bVar2.a(-3, ResUtils.getString(this.f50650g, "wallet_fp_changed_usepwd"));
                        return;
                    }
                    return;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    StatisticManager.onEventWithValue("fprd_start_fp_failed", "case: decrypttoken & reason : exception is" + e4.getLocalizedMessage());
                    b bVar3 = this.f50646c;
                    if (bVar3 != null) {
                        bVar3.a(-1, "");
                        return;
                    }
                    return;
                }
            }
            StatisticManager.onEventWithValue("fprd_start_fp_failed", "impossible case: decrypttoken & reason : encrypt_base64_IV or operateData is null");
            b bVar4 = this.f50646c;
            if (bVar4 != null) {
                bVar4.a(-1, "");
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f50649f = str;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a = null;
            this.f50645b = null;
            this.f50646c = null;
            this.f50647d = null;
            this.f50650g = null;
        }
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationError(int i2, CharSequence charSequence) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, charSequence) == null) {
            super.onAuthenticationError(i2, charSequence);
            String str = "onAuthenticationError code=" + i2 + " # " + ((Object) charSequence);
            if (i2 == 7 || i2 == 9) {
                if (this.f50648e == 1) {
                    string = ResUtils.getString(this.f50650g, "wallet_fp_try_too_many_times_try_later");
                } else {
                    string = ResUtils.getString(this.f50650g, "wallet_fp_error_fp_many_times_usepwd");
                }
                b bVar = this.f50646c;
                if (bVar != null) {
                    bVar.a(-6, string);
                }
            }
        }
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationFailed() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onAuthenticationFailed();
            this.f50651h++;
            String str = "onAuthenticationFailed  reTryCount=" + this.f50651h;
            if (this.f50651h >= 3) {
                if (this.f50648e == 1) {
                    string = ResUtils.getString(this.f50650g, "wallet_fp_try_too_many_times_try_later");
                } else {
                    string = ResUtils.getString(this.f50650g, "wallet_fp_error_fp_many_times_usepwd");
                }
                b bVar = this.f50646c;
                if (bVar != null) {
                    bVar.a(-4, string);
                }
                this.f50651h = 0;
                return;
            }
            b bVar2 = this.f50646c;
            if (bVar2 != null) {
                bVar2.a(-5, ResUtils.getString(this.f50650g, "wallet_fp_error_fp"));
            }
        }
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationHelp(int i2, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, charSequence) == null) {
            String str = "onAuthenticationHelp!  helpCode=" + i2 + " & helpString=" + ((Object) charSequence);
            super.onAuthenticationHelp(i2, charSequence);
        }
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, authenticationResult) == null) || this.f50646c == null) {
            return;
        }
        Cipher cipher = authenticationResult.getCryptoObject().getCipher();
        if (this.f50648e == 2) {
            if (!TextUtils.isEmpty(this.f50649f)) {
                try {
                    String str = new String(cipher.doFinal(Base64.decode(this.f50649f, 0)));
                    String generateOTPKey = WalletFingerprint.getInstance(this.f50650g).generateOTPKey(str);
                    String sn = WalletFingerprint.getInstance(this.f50650g).getSN();
                    if (!TextUtils.isEmpty(generateOTPKey) && !TextUtils.isEmpty(sn)) {
                        this.f50646c.a(0, str);
                        return;
                    }
                    IFingerprintPay fingerprintPay = WalletFingerprint.getInstance(this.f50650g).getFingerprintPay();
                    if (fingerprintPay != null) {
                        fingerprintPay.closeFingerprint(this.f50650g);
                    }
                    this.f50646c.a(-7, ResUtils.getString(this.f50650g, "wallet_fp_token_null"));
                    return;
                } catch (BadPaddingException | IllegalBlockSizeException e2) {
                    e2.printStackTrace();
                    WalletFingerprint.getInstance(this.f50650g).clearOTPToken();
                    this.f50646c.a(-3, ResUtils.getString(this.f50650g, "wallet_fp_changed_usepwd"));
                    StatisticManager.onEvent("fprd_BadPaddingException_IllegalBlockSizeException");
                    return;
                }
            }
            throw new IllegalArgumentException(" #the data to encrypt/decrypt is null! ");
        }
        String str2 = null;
        try {
            String[] split = this.f50649f.split("\\|");
            if (split.length == 2) {
                str2 = split[0];
                this.f50649f = split[1];
            }
            byte[] doFinal = cipher.doFinal(this.f50649f.getBytes());
            byte[] iv = cipher.getIV();
            if (doFinal != null && iv != null) {
                String encodeToString = Base64.encodeToString(doFinal, 0);
                String encodeToString2 = Base64.encodeToString(iv, 0);
                String encodeToString3 = Base64.encodeToString((encodeToString + "|" + encodeToString2 + "|" + str2).getBytes(), 0);
                String newPpKey = PayPreferenceManager.getNewPpKey(this.f50650g);
                if (!TextUtils.isEmpty(newPpKey)) {
                    SharedPreferencesUtils.setParam(this.f50650g, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, newPpKey, encodeToString3);
                }
                this.f50646c.a(0, encodeToString);
                return;
            }
            this.f50646c.a(-2, "");
        } catch (BadPaddingException | IllegalBlockSizeException e3) {
            e3.printStackTrace();
            this.f50646c.a(-2, "");
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f50646c = bVar;
        }
    }

    public void a() {
        CancellationSignal cancellationSignal;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cancellationSignal = this.f50647d) == null) {
            return;
        }
        cancellationSignal.cancel();
        this.f50647d = null;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 == 1) {
                b();
            } else if (i2 == 2) {
                c();
            }
        }
    }
}
