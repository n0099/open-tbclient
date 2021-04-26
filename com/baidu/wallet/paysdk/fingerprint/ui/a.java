package com.baidu.wallet.paysdk.fingerprint.ui;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.AnimUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.fingerprint.FingerprintCallback;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.NonePayingProcess;
import com.baidu.wallet.paysdk.fingerprint.b;
import com.baidu.wallet.paysdk.fingerprint.bean.FingerprintBeanFactory;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.security.KeyStoreException;
@RequiresApi(api = 23)
/* loaded from: classes5.dex */
public class a extends DialogFragment implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f26120a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f26121b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f26122c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f26123d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26124e;

    /* renamed from: f  reason: collision with root package name */
    public Button f26125f;

    /* renamed from: g  reason: collision with root package name */
    public Button f26126g;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.wallet.paysdk.fingerprint.a.a f26127h;

    /* renamed from: i  reason: collision with root package name */
    public FingerprintCallback f26128i;
    public int j;
    public IFingerprintPay.Action k;
    public String l;

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        this.f26122c = activity;
        super.onAttach(activity);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, ResUtils.style(this.f26122c, "EbpayPromptDialog"));
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        getDialog().requestWindowFeature(1);
        LayoutInflater from = LayoutInflater.from(this.f26122c);
        this.f26121b = from;
        ViewGroup viewGroup2 = (ViewGroup) from.inflate(ResUtils.layout(this.f26122c, "wallet_cashdesk_fingerprint_dialog"), (ViewGroup) null);
        this.f26123d = viewGroup2;
        this.f26125f = (Button) viewGroup2.findViewById(ResUtils.id(this.f26122c, "negative_btn"));
        this.f26126g = (Button) this.f26123d.findViewById(ResUtils.id(this.f26122c, "positive_btn"));
        this.f26124e = (TextView) this.f26123d.findViewById(ResUtils.id(this.f26122c, "fingerprint_title"));
        getDialog().setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.f26125f.setVisibility(8);
        this.f26126g.setVisibility(0);
        a(this.f26126g);
        this.f26126g.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.fingerprint.ui.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StatHelper.cachePayWay(1);
                a.this.b();
                a.this.f26127h.a();
                if (a.this.f26128i != null) {
                    a.this.f26128i.onAuthorizeResult(a.this.k, 1, "cancle");
                }
                a.this.dismissAllowingStateLoss();
            }
        });
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        Activity activity = this.f26122c;
        if (activity instanceof NonePayingProcess) {
            string = ResUtils.getString(activity, "wallet_fp_open_content");
        } else if (payRequest != null && payRequest.FP_Guide_Strategy == 3) {
            string = ResUtils.getString(activity, "wallet_fp_upgrade_content");
        } else if (payRequest != null && payRequest.FP_Guide_Strategy == 2) {
            string = ResUtils.getString(this.f26122c, "wallet_fp_reopen_content");
        } else if (payRequest != null && payRequest.FP_Guide_Strategy == 1) {
            string = ResUtils.getString(this.f26122c, "wallet_fp_open_content");
        } else {
            string = ResUtils.getString(this.f26122c, "wallet_fp_bdwallet_fingerprintpay");
        }
        this.f26124e.setText(string);
        return this.f26123d;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f26122c = null;
        com.baidu.wallet.paysdk.fingerprint.a.a aVar = this.f26127h;
        if (aVar != null) {
            aVar.d();
            this.f26127h = null;
        }
        this.f26123d = null;
        this.f26128i = null;
        this.f26121b = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        this.f26127h.a();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.f26127h.a(this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.j == 1) {
            final com.baidu.wallet.paysdk.fingerprint.bean.a aVar = (com.baidu.wallet.paysdk.fingerprint.bean.a) FingerprintBeanFactory.getInstance().getBean((Context) this.f26122c, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE, f26120a);
            aVar.a(this.l);
            aVar.setResponseCallback(new IBeanResponseCallback() { // from class: com.baidu.wallet.paysdk.fingerprint.ui.a.4
                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                public void onBeanExecFailure(int i2, int i3, String str) {
                    LogUtil.d(a.f26120a, "close system fingerprint failed!");
                    aVar.destroyBean();
                    StatisticManager.onEvent(StatServiceEvent.EVENT_FP_CLOSE_SYSTEM_FAILED_AFTER_GET_OTPTOKEN);
                }

                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                public void onBeanExecSuccess(int i2, Object obj, String str) {
                    LogUtil.d(a.f26120a, "close system fingerprint success!");
                    aVar.destroyBean();
                }
            });
            aVar.execBean();
        }
    }

    public static a a(Activity activity, int i2, String str, FingerprintCallback fingerprintCallback) throws KeyStoreException {
        a aVar = new a();
        if (i2 == 1 && TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(" operaterData cannot be null when openning fingerprintpay !");
        }
        if (i2 == 1) {
            aVar.k = IFingerprintPay.Action.OPEN;
            aVar.l = SafePay.getInstance().localDecrypt(str.split("\\|")[0]);
        } else {
            aVar.k = IFingerprintPay.Action.VERIFY;
        }
        com.baidu.wallet.paysdk.fingerprint.a.a aVar2 = new com.baidu.wallet.paysdk.fingerprint.a.a(activity.getApplicationContext());
        aVar.f26127h = aVar2;
        aVar2.a(aVar);
        aVar.f26127h.a(str);
        aVar.j = i2;
        aVar.f26128i = fingerprintCallback;
        aVar.f26122c = activity;
        return aVar;
    }

    private void a(Button button) {
        View findViewById = this.f26123d.findViewById(ResUtils.id(button.getContext(), "btn_line"));
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        button.setBackgroundDrawable(ResUtils.getDrawable(button.getContext(), "wallet_base_dialog_btn_selector"));
        button.setText("取消");
        TextPaint paint = button.getPaint();
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
    }

    @Override // com.baidu.wallet.paysdk.fingerprint.b
    public void a(int i2, String str) {
        if (i2 == 0) {
            FingerprintCallback fingerprintCallback = this.f26128i;
            if (fingerprintCallback != null) {
                fingerprintCallback.onAuthorizeResult(this.k, 0, str);
            }
            dismissAllowingStateLoss();
        } else if (i2 == -3) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_FP_FINGERPRINT_CHANGED);
            b();
            this.f26127h.a();
            FingerprintCallback fingerprintCallback2 = this.f26128i;
            if (fingerprintCallback2 != null) {
                fingerprintCallback2.onAuthorizeResult(this.k, 2, str);
            }
            dismissAllowingStateLoss();
        } else if (i2 == -6 || i2 == -4) {
            if (i2 == -4) {
                StatisticManager.onEvent(StatServiceEvent.EVENT_FP_VERIFY_ERROR_3_TIMES_AUTO_CHANGETO_PWDPAY);
            } else {
                StatisticManager.onEvent(StatServiceEvent.EVENT_FP_VERIFY_ERROR_SETDISABLE_SERVAL_SECONDS);
            }
            b();
            this.f26127h.a();
            FingerprintCallback fingerprintCallback3 = this.f26128i;
            if (fingerprintCallback3 != null) {
                fingerprintCallback3.onAuthorizeResult(this.k, 2, str);
            }
            dismissAllowingStateLoss();
        } else if (i2 == -1) {
            if (this.f26128i != null) {
                b();
                this.f26128i.onAuthorizeResult(this.k, 2, "");
            }
            this.f26127h.a();
            dismissAllowingStateLoss();
        } else if (i2 == -5) {
            if (this.j == 1) {
                this.f26126g.setVisibility(8);
            } else {
                this.f26126g.setVisibility(0);
                this.f26126g.setText(ResUtils.getString(this.f26122c, "wallet_cashdesk_pwd_pay"));
            }
            this.f26125f.setVisibility(0);
            a(this.f26125f);
            this.f26124e.setVisibility(0);
            this.f26124e.setText(str);
            AnimUtils.startSharkAnim(this.f26124e);
            this.f26126g.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.fingerprint.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FP_ERROR_FP_CLICK_PWDPAY);
                    a.this.f26127h.a();
                    if (a.this.f26128i != null) {
                        a.this.f26128i.onAuthorizeResult(a.this.k, 3, "");
                    }
                    a.this.dismissAllowingStateLoss();
                }
            });
            this.f26125f.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.fingerprint.ui.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.b();
                    a.this.f26127h.a();
                    if (a.this.f26128i != null) {
                        a.this.f26128i.onAuthorizeResult(a.this.k, 1, "");
                    }
                    a.this.dismissAllowingStateLoss();
                }
            });
        } else {
            b();
            FingerprintCallback fingerprintCallback4 = this.f26128i;
            if (fingerprintCallback4 != null) {
                fingerprintCallback4.onAuthorizeResult(this.k, 2, "");
            }
            this.f26127h.a();
            dismissAllowingStateLoss();
        }
    }
}
