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
    public static final String f25654a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f25655b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f25656c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f25657d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f25658e;

    /* renamed from: f  reason: collision with root package name */
    public Button f25659f;

    /* renamed from: g  reason: collision with root package name */
    public Button f25660g;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.wallet.paysdk.fingerprint.a.a f25661h;
    public FingerprintCallback i;
    public int j;
    public IFingerprintPay.Action k;
    public String l;

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        this.f25656c = activity;
        super.onAttach(activity);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, ResUtils.style(this.f25656c, "EbpayPromptDialog"));
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        getDialog().requestWindowFeature(1);
        LayoutInflater from = LayoutInflater.from(this.f25656c);
        this.f25655b = from;
        ViewGroup viewGroup2 = (ViewGroup) from.inflate(ResUtils.layout(this.f25656c, "wallet_cashdesk_fingerprint_dialog"), (ViewGroup) null);
        this.f25657d = viewGroup2;
        this.f25659f = (Button) viewGroup2.findViewById(ResUtils.id(this.f25656c, "negative_btn"));
        this.f25660g = (Button) this.f25657d.findViewById(ResUtils.id(this.f25656c, "positive_btn"));
        this.f25658e = (TextView) this.f25657d.findViewById(ResUtils.id(this.f25656c, "fingerprint_title"));
        getDialog().setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.f25659f.setVisibility(8);
        this.f25660g.setVisibility(0);
        a(this.f25660g);
        this.f25660g.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.fingerprint.ui.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StatHelper.cachePayWay(1);
                a.this.b();
                a.this.f25661h.a();
                if (a.this.i != null) {
                    a.this.i.onAuthorizeResult(a.this.k, 1, "cancle");
                }
                a.this.dismissAllowingStateLoss();
            }
        });
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        Activity activity = this.f25656c;
        if (activity instanceof NonePayingProcess) {
            string = ResUtils.getString(activity, "wallet_fp_open_content");
        } else if (payRequest != null && payRequest.FP_Guide_Strategy == 3) {
            string = ResUtils.getString(activity, "wallet_fp_upgrade_content");
        } else if (payRequest != null && payRequest.FP_Guide_Strategy == 2) {
            string = ResUtils.getString(this.f25656c, "wallet_fp_reopen_content");
        } else if (payRequest != null && payRequest.FP_Guide_Strategy == 1) {
            string = ResUtils.getString(this.f25656c, "wallet_fp_open_content");
        } else {
            string = ResUtils.getString(this.f25656c, "wallet_fp_bdwallet_fingerprintpay");
        }
        this.f25658e.setText(string);
        return this.f25657d;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f25656c = null;
        com.baidu.wallet.paysdk.fingerprint.a.a aVar = this.f25661h;
        if (aVar != null) {
            aVar.d();
            this.f25661h = null;
        }
        this.f25657d = null;
        this.i = null;
        this.f25655b = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        this.f25661h.a();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.f25661h.a(this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.j == 1) {
            final com.baidu.wallet.paysdk.fingerprint.bean.a aVar = (com.baidu.wallet.paysdk.fingerprint.bean.a) FingerprintBeanFactory.getInstance().getBean((Context) this.f25656c, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE, f25654a);
            aVar.a(this.l);
            aVar.setResponseCallback(new IBeanResponseCallback() { // from class: com.baidu.wallet.paysdk.fingerprint.ui.a.4
                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                public void onBeanExecFailure(int i, int i2, String str) {
                    LogUtil.d(a.f25654a, "close system fingerprint failed!");
                    aVar.destroyBean();
                    StatisticManager.onEvent(StatServiceEvent.EVENT_FP_CLOSE_SYSTEM_FAILED_AFTER_GET_OTPTOKEN);
                }

                @Override // com.baidu.apollon.beans.IBeanResponseCallback
                public void onBeanExecSuccess(int i, Object obj, String str) {
                    LogUtil.d(a.f25654a, "close system fingerprint success!");
                    aVar.destroyBean();
                }
            });
            aVar.execBean();
        }
    }

    public static a a(Activity activity, int i, String str, FingerprintCallback fingerprintCallback) throws KeyStoreException {
        a aVar = new a();
        if (i == 1 && TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(" operaterData cannot be null when openning fingerprintpay !");
        }
        if (i == 1) {
            aVar.k = IFingerprintPay.Action.OPEN;
            aVar.l = SafePay.getInstance().localDecrypt(str.split("\\|")[0]);
        } else {
            aVar.k = IFingerprintPay.Action.VERIFY;
        }
        com.baidu.wallet.paysdk.fingerprint.a.a aVar2 = new com.baidu.wallet.paysdk.fingerprint.a.a(activity.getApplicationContext());
        aVar.f25661h = aVar2;
        aVar2.a(aVar);
        aVar.f25661h.a(str);
        aVar.j = i;
        aVar.i = fingerprintCallback;
        aVar.f25656c = activity;
        return aVar;
    }

    private void a(Button button) {
        View findViewById = this.f25657d.findViewById(ResUtils.id(button.getContext(), "btn_line"));
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
    public void a(int i, String str) {
        if (i == 0) {
            FingerprintCallback fingerprintCallback = this.i;
            if (fingerprintCallback != null) {
                fingerprintCallback.onAuthorizeResult(this.k, 0, str);
            }
            dismissAllowingStateLoss();
        } else if (i == -3) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_FP_FINGERPRINT_CHANGED);
            b();
            this.f25661h.a();
            FingerprintCallback fingerprintCallback2 = this.i;
            if (fingerprintCallback2 != null) {
                fingerprintCallback2.onAuthorizeResult(this.k, 2, str);
            }
            dismissAllowingStateLoss();
        } else if (i == -6 || i == -4) {
            if (i == -4) {
                StatisticManager.onEvent(StatServiceEvent.EVENT_FP_VERIFY_ERROR_3_TIMES_AUTO_CHANGETO_PWDPAY);
            } else {
                StatisticManager.onEvent(StatServiceEvent.EVENT_FP_VERIFY_ERROR_SETDISABLE_SERVAL_SECONDS);
            }
            b();
            this.f25661h.a();
            FingerprintCallback fingerprintCallback3 = this.i;
            if (fingerprintCallback3 != null) {
                fingerprintCallback3.onAuthorizeResult(this.k, 2, str);
            }
            dismissAllowingStateLoss();
        } else if (i == -1) {
            if (this.i != null) {
                b();
                this.i.onAuthorizeResult(this.k, 2, "");
            }
            this.f25661h.a();
            dismissAllowingStateLoss();
        } else if (i == -5) {
            if (this.j == 1) {
                this.f25660g.setVisibility(8);
            } else {
                this.f25660g.setVisibility(0);
                this.f25660g.setText(ResUtils.getString(this.f25656c, "wallet_cashdesk_pwd_pay"));
            }
            this.f25659f.setVisibility(0);
            a(this.f25659f);
            this.f25658e.setVisibility(0);
            this.f25658e.setText(str);
            AnimUtils.startSharkAnim(this.f25658e);
            this.f25660g.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.fingerprint.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FP_ERROR_FP_CLICK_PWDPAY);
                    a.this.f25661h.a();
                    if (a.this.i != null) {
                        a.this.i.onAuthorizeResult(a.this.k, 3, "");
                    }
                    a.this.dismissAllowingStateLoss();
                }
            });
            this.f25659f.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.fingerprint.ui.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.b();
                    a.this.f25661h.a();
                    if (a.this.i != null) {
                        a.this.i.onAuthorizeResult(a.this.k, 1, "");
                    }
                    a.this.dismissAllowingStateLoss();
                }
            });
        } else {
            b();
            FingerprintCallback fingerprintCallback4 = this.i;
            if (fingerprintCallback4 != null) {
                fingerprintCallback4.onAuthorizeResult(this.k, 2, "");
            }
            this.f25661h.a();
            dismissAllowingStateLoss();
        }
    }
}
