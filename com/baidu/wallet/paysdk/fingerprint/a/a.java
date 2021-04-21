package com.baidu.wallet.paysdk.fingerprint.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.fingerprint.FpConstancts;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.fingerprint.b;
import com.baidu.wallet.paysdk.storage.PayPreferenceManager;
import com.baidu.wallet.statistics.api.StatisticManager;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
@TargetApi(23)
/* loaded from: classes5.dex */
public class a extends FingerprintManager.AuthenticationCallback {

    /* renamed from: a  reason: collision with root package name */
    public FingerprintManager f25323a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.wallet.paysdk.fingerprint.a f25324b;

    /* renamed from: c  reason: collision with root package name */
    public b f25325c;

    /* renamed from: d  reason: collision with root package name */
    public CancellationSignal f25326d;

    /* renamed from: f  reason: collision with root package name */
    public String f25328f;

    /* renamed from: g  reason: collision with root package name */
    public Context f25329g;

    /* renamed from: e  reason: collision with root package name */
    public int f25327e = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f25330h = 0;

    public a(Context context) throws KeyStoreException {
        this.f25329g = context;
        this.f25323a = (FingerprintManager) context.getSystemService(FingerprintManager.class);
        this.f25324b = com.baidu.wallet.paysdk.fingerprint.a.a(context);
    }

    private void e() {
        this.f25327e = 1;
        if (this.f25325c == null || TextUtils.isEmpty(this.f25328f)) {
            return;
        }
        try {
            FingerprintManager.CryptoObject a2 = this.f25324b.a(1, null);
            if (a2 == null) {
                if (this.f25325c != null) {
                    this.f25325c.a(-1, "");
                    return;
                }
                return;
            }
            CancellationSignal cancellationSignal = new CancellationSignal();
            this.f25326d = cancellationSignal;
            this.f25323a.authenticate(a2, cancellationSignal, 0, this, null);
        } catch (SecurityException e2) {
            e2.printStackTrace();
            StatisticManager.onEvent(StatServiceEvent.EVENT_FP_SECURITY_EXCEPTION_ON_ENCRYPT);
            b bVar = this.f25325c;
            if (bVar != null) {
                bVar.a(-1, "");
            }
        } catch (InvalidKeyException unused) {
            b bVar2 = this.f25325c;
            if (bVar2 != null) {
                bVar2.a(-3, ResUtils.getString(this.f25329g, "wallet_fp_fingerprint_changed"));
            }
        }
    }

    private void f() {
        String str;
        String[] split = new String(Base64.decode((String) SharedPreferencesUtils.getParam(this.f25329g, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, PayPreferenceManager.getNewPpKey(this.f25329g), ""), 0)).split("\\|");
        if (split.length == 3) {
            this.f25328f = split[0];
            str = split[1];
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f25328f)) {
            this.f25327e = 2;
            try {
                FingerprintManager.CryptoObject a2 = this.f25324b.a(2, Base64.decode(str, 0));
                if (a2 == null) {
                    StatisticManager.onEventWithValue(StatServiceEvent.EVENT_FP_START_FP_FAILED, "case: decrypttoken & reason : cryptObject is null");
                    if (this.f25325c != null) {
                        this.f25325c.a(-1, "");
                        return;
                    }
                    return;
                }
                CancellationSignal cancellationSignal = new CancellationSignal();
                this.f25326d = cancellationSignal;
                this.f25323a.authenticate(a2, cancellationSignal, 0, this, null);
                return;
            } catch (SecurityException e2) {
                e2.printStackTrace();
                StatisticManager.onEventWithValue(StatServiceEvent.EVENT_FP_START_FP_FAILED, "case: decrypttoken & reason : SecurityException happends");
                b bVar = this.f25325c;
                if (bVar != null) {
                    bVar.a(-1, "");
                    return;
                }
                return;
            } catch (InvalidKeyException e3) {
                e3.printStackTrace();
                WalletFingerprint.getInstance(this.f25329g).clearOTPToken();
                b bVar2 = this.f25325c;
                if (bVar2 != null) {
                    bVar2.a(-3, ResUtils.getString(this.f25329g, "wallet_fp_changed_usepwd"));
                    return;
                }
                return;
            } catch (Exception e4) {
                e4.printStackTrace();
                StatisticManager.onEventWithValue(StatServiceEvent.EVENT_FP_START_FP_FAILED, "case: decrypttoken & reason : exception is" + e4.getLocalizedMessage());
                b bVar3 = this.f25325c;
                if (bVar3 != null) {
                    bVar3.a(-1, "");
                    return;
                }
                return;
            }
        }
        StatisticManager.onEventWithValue(StatServiceEvent.EVENT_FP_START_FP_FAILED, "impossible case: decrypttoken & reason : encrypt_base64_IV or operateData is null");
        b bVar4 = this.f25325c;
        if (bVar4 != null) {
            bVar4.a(-1, "");
        }
    }

    public void a(String str) {
        this.f25328f = str;
    }

    public void b() {
        e();
    }

    public void c() {
        f();
    }

    public void d() {
        this.f25323a = null;
        this.f25324b = null;
        this.f25325c = null;
        this.f25326d = null;
        this.f25329g = null;
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationError(int i, CharSequence charSequence) {
        String string;
        super.onAuthenticationError(i, charSequence);
        LogUtil.d("FingerprintPresenter", "onAuthenticationError code=" + i + " # " + ((Object) charSequence));
        if (i == 7) {
            if (this.f25327e == 1) {
                string = ResUtils.getString(this.f25329g, "wallet_fp_try_too_many_times_try_later");
            } else {
                string = ResUtils.getString(this.f25329g, "wallet_fp_error_fp_many_times_usepwd");
            }
            b bVar = this.f25325c;
            if (bVar != null) {
                bVar.a(-6, string);
            }
        }
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationFailed() {
        String string;
        super.onAuthenticationFailed();
        this.f25330h++;
        LogUtil.d("FingerprintPresenter", "onAuthenticationFailed  reTryCount=" + this.f25330h);
        if (this.f25330h >= 3) {
            if (this.f25327e == 1) {
                string = ResUtils.getString(this.f25329g, "wallet_fp_try_too_many_times_try_later");
            } else {
                string = ResUtils.getString(this.f25329g, "wallet_fp_error_fp_many_times_usepwd");
            }
            b bVar = this.f25325c;
            if (bVar != null) {
                bVar.a(-4, string);
            }
            this.f25330h = 0;
            return;
        }
        b bVar2 = this.f25325c;
        if (bVar2 != null) {
            bVar2.a(-5, ResUtils.getString(this.f25329g, "wallet_fp_error_fp"));
        }
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationHelp(int i, CharSequence charSequence) {
        LogUtil.d("FingerprintPresenter", "onAuthenticationHelp!  helpCode=" + i + " & helpString=" + ((Object) charSequence));
        super.onAuthenticationHelp(i, charSequence);
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
        if (this.f25325c == null) {
            return;
        }
        Cipher cipher = authenticationResult.getCryptoObject().getCipher();
        if (this.f25327e == 2) {
            if (!TextUtils.isEmpty(this.f25328f)) {
                try {
                    this.f25325c.a(0, new String(cipher.doFinal(Base64.decode(this.f25328f, 0))));
                    return;
                } catch (BadPaddingException | IllegalBlockSizeException e2) {
                    e2.printStackTrace();
                    WalletFingerprint.getInstance(this.f25329g).clearOTPToken();
                    this.f25325c.a(-3, ResUtils.getString(this.f25329g, "wallet_fp_changed_usepwd"));
                    StatisticManager.onEvent(StatServiceEvent.EVENT_FP_BadPaddingException_IllegalBlockSizeException);
                    return;
                }
            }
            throw new IllegalArgumentException(" #the data to encrypt/decrypt is null! ");
        }
        String str = null;
        try {
            String[] split = this.f25328f.split("\\|");
            if (split.length == 2) {
                str = split[0];
                this.f25328f = split[1];
            }
            byte[] doFinal = cipher.doFinal(this.f25328f.getBytes());
            byte[] iv = cipher.getIV();
            if (doFinal != null && iv != null) {
                String encodeToString = Base64.encodeToString(doFinal, 0);
                String encodeToString2 = Base64.encodeToString(iv, 0);
                String encodeToString3 = Base64.encodeToString((encodeToString + FieldBuilder.SE + encodeToString2 + FieldBuilder.SE + str).getBytes(), 0);
                String newPpKey = PayPreferenceManager.getNewPpKey(this.f25329g);
                if (!TextUtils.isEmpty(newPpKey)) {
                    SharedPreferencesUtils.setParam(this.f25329g, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, newPpKey, encodeToString3);
                }
                this.f25325c.a(0, encodeToString);
                return;
            }
            this.f25325c.a(-2, "");
        } catch (BadPaddingException | IllegalBlockSizeException e3) {
            e3.printStackTrace();
            this.f25325c.a(-2, "");
        }
    }

    public void a(b bVar) {
        this.f25325c = bVar;
    }

    public void a() {
        CancellationSignal cancellationSignal = this.f25326d;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
            this.f25326d = null;
        }
    }

    public void a(int i) {
        if (i == 1) {
            b();
        } else if (i == 2) {
            c();
        }
    }
}
