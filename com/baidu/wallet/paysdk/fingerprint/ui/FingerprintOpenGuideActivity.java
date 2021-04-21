package com.baidu.wallet.paysdk.fingerprint.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.fingerprint.FingerprintCallback;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.payresult.presenter.CashierDeskPayResult;
import com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.statistics.api.StatisticManager;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class FingerprintOpenGuideActivity extends HalfScreenBaseActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public TextView f25335a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f25336b;

    /* renamed from: c  reason: collision with root package name */
    public Button f25337c;

    /* renamed from: e  reason: collision with root package name */
    public TextView f25338e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25339f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25340g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25341h;
    public PayController.PayResultWrapper i;

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity
    public void addContentView() {
        this.mContentView = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_fingerprint_open_guide"), null);
        this.mContentView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.mHalfScreenContainer.addView(this.mContentView);
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (CheckUtils.isFastDoubleClick()) {
            return;
        }
        if (view == this.f25337c) {
            final PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            final IFingerprintPay fingerprintPay = WalletFingerprint.getInstance(getActivity()).getFingerprintPay(WalletFingerprint.FpType.SYSTEM_FINGERPRINT);
            if (payRequest == null || fingerprintPay == null) {
                return;
            }
            fingerprintPay.open(getActivity(), new FingerprintCallback() { // from class: com.baidu.wallet.paysdk.fingerprint.ui.FingerprintOpenGuideActivity.3
                @Override // com.baidu.wallet.paysdk.fingerprint.FingerprintCallback
                public void onAuthorizeResult(IFingerprintPay.Action action, int i, String str) {
                    if (i == 0) {
                        int i2 = payRequest.FP_Guide_Strategy;
                        if (i2 == 1) {
                            StatisticManager.onEvent(StatServiceEvent.EVENT_FP_OPEN_SUCCESS);
                            GlobalUtils.toast(FingerprintOpenGuideActivity.this.getActivity(), ResUtils.getString(FingerprintOpenGuideActivity.this.getActivity(), "wallet_fp_open_success"));
                        } else if (i2 == 2) {
                            GlobalUtils.toast(FingerprintOpenGuideActivity.this.getActivity(), ResUtils.getString(FingerprintOpenGuideActivity.this.getActivity(), "wallet_fp_reopen_success"));
                            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FP_REOPEN_SUCCESS);
                        } else if (i2 == 3) {
                            GlobalUtils.toast(FingerprintOpenGuideActivity.this.getActivity(), ResUtils.getString(FingerprintOpenGuideActivity.this.getActivity(), "wallet_fp_upgrade_success"));
                            StatisticManager.onEvent(StatServiceEvent.EVENT_FP_UPGRADE_SUCCESS);
                        }
                        FingerprintOpenGuideActivity.this.f25337c.postDelayed(new Runnable() { // from class: com.baidu.wallet.paysdk.fingerprint.ui.FingerprintOpenGuideActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                FingerprintOpenGuideActivity.this.c();
                            }
                        }, 2000L);
                        FingerprintOpenGuideActivity.this.f25337c.setClickable(false);
                        FingerprintOpenGuideActivity.this.mRightTxt.setClickable(false);
                    } else if (i == 2) {
                        if (TextUtils.isEmpty(str)) {
                            int i3 = payRequest.FP_Guide_Strategy;
                            if (i3 == 1) {
                                StatisticManager.onEvent(StatServiceEvent.EVENT_FP_OPEN_FAILED);
                                str = ResUtils.getString(FingerprintOpenGuideActivity.this.getActivity(), "wallet_fp_open_failed");
                            } else if (i3 == 2) {
                                str = ResUtils.getString(FingerprintOpenGuideActivity.this.getActivity(), "wallet_fp_reopen_failed");
                                StatisticManager.onEvent(StatServiceEvent.EVENT_FP_REOPEN_FAILED);
                            } else if (i3 != 3) {
                                str = "";
                            } else {
                                str = ResUtils.getString(FingerprintOpenGuideActivity.this.getActivity(), "wallet_fp_upgrade_failed");
                                StatisticManager.onEvent(StatServiceEvent.EVENT_FP_UPGRADE_FAILED);
                            }
                        }
                        GlobalUtils.toast(FingerprintOpenGuideActivity.this.getActivity(), str);
                        FingerprintOpenGuideActivity.this.f25337c.postDelayed(new Runnable() { // from class: com.baidu.wallet.paysdk.fingerprint.ui.FingerprintOpenGuideActivity.3.2
                            @Override // java.lang.Runnable
                            public void run() {
                                FingerprintOpenGuideActivity.this.c();
                            }
                        }, 2000L);
                        FingerprintOpenGuideActivity.this.f25337c.setClickable(false);
                        FingerprintOpenGuideActivity.this.mRightTxt.setClickable(false);
                    } else if (i == 1) {
                        int i4 = payRequest.FP_Guide_Strategy;
                        if (i4 == 1) {
                            StatisticManager.onEvent(StatServiceEvent.EVENT_FP_OPEN_CANCLE);
                        } else if (i4 == 2) {
                            StatisticManager.onEvent(StatServiceEvent.EVENT_FP_REOPEN_CANCLE);
                        } else if (i4 == 3) {
                            StatisticManager.onEvent(StatServiceEvent.EVENT_FP_UPGRADE_CANCLE);
                        }
                    }
                    fingerprintPay.destory();
                }
            });
        } else if (view == this.mRightTxt) {
            c();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable("payresultwrapper");
            if (serializable instanceof PayController.PayResultWrapper) {
                this.i = (PayController.PayResultWrapper) serializable;
            }
        } else {
            Intent intent = getIntent();
            if (intent != null && (intent.getSerializableExtra("payresultwrapper") instanceof PayController.PayResultWrapper)) {
                this.i = (PayController.PayResultWrapper) intent.getSerializableExtra("payresultwrapper");
            }
        }
        if (this.i == null) {
            PayBaseBeanActivity.exitEbpay();
            finish();
        }
        a();
        b();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("payresultwrapper", this.i);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i) {
    }

    private void a() {
        this.mLeftImg.setVisibility(4);
        this.f25335a = (TextView) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_title"));
        this.f25336b = (TextView) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_subtitle"));
        this.f25338e = (TextView) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_hint1"));
        this.f25339f = (TextView) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_hint2"));
        this.mRightTxt.setTextColor(ResUtils.getColor(this, "wallet_base_primary_color"));
        this.mRightTxt.setText(ResUtils.getString(this, "wallet_base_skip"));
        this.mRightTxt.setOnClickListener(this);
        Button button = (Button) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_open_btn"));
        this.f25337c = button;
        button.setOnClickListener(this);
        this.f25340g = (TextView) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_protocol_prefix"));
        this.f25341h = (TextView) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_protocol_msg"));
    }

    private void b() {
        String str;
        String str2;
        String string;
        String string2;
        String string3;
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        final UserData.UserModel.FingerprintMsg fingerprintMsg = PayDataCache.getInstance().getFingerprintMsg();
        if (payRequest != null) {
            int i = payRequest.FP_Guide_Strategy;
            String str3 = "";
            String[] strArr = null;
            if (i == 1) {
                StatisticManager.onEvent(StatServiceEvent.EVENT_FP_SHOW_GUIDE_OPEN_SYSTEM);
                if (fingerprintMsg != null && fingerprintMsg.getOpen() != null && !TextUtils.isEmpty(fingerprintMsg.getOpen().getTitle())) {
                    string3 = fingerprintMsg.getOpen().getTitle();
                } else {
                    string3 = ResUtils.getString(this, "bd_wallet_fingerprint_open_guide");
                }
                str3 = string3;
                if (fingerprintMsg != null && fingerprintMsg.getOpen() != null && !TextUtils.isEmpty(fingerprintMsg.getOpen().getSubtitle())) {
                    str = fingerprintMsg.getOpen().getSubtitle();
                } else {
                    str = ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_subtitle");
                }
                String string4 = ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_btn");
                String[] strArr2 = fingerprintMsg != null ? fingerprintMsg.getOpen().hints : new String[]{ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_hint0"), ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_hint1")};
                if (fingerprintMsg != null && fingerprintMsg.getOpen() != null && fingerprintMsg.getOpen().getFingerprintProtocol() != null && !TextUtils.isEmpty(fingerprintMsg.getOpen().getFingerprintProtocol().getFingerprintProtocolPrefix()) && !TextUtils.isEmpty(fingerprintMsg.getOpen().getFingerprintProtocol().getFingerprintProtocolMsg()) && !TextUtils.isEmpty(fingerprintMsg.getOpen().getFingerprintProtocol().getFingerprintProtocolUrl())) {
                    this.f25340g.setText(fingerprintMsg.getOpen().getFingerprintProtocol().getFingerprintProtocolPrefix());
                    this.f25341h.setText(fingerprintMsg.getOpen().getFingerprintProtocol().getFingerprintProtocolMsg());
                    this.f25341h.setVisibility(0);
                    this.f25340g.setVisibility(0);
                    this.f25341h.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.fingerprint.ui.FingerprintOpenGuideActivity.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BaiduWalletDelegate.getInstance().openH5Module(FingerprintOpenGuideActivity.this, fingerprintMsg.getOpen().getFingerprintProtocol().getFingerprintProtocolUrl(), false);
                        }
                    });
                } else {
                    this.f25341h.setVisibility(8);
                    this.f25340g.setVisibility(8);
                }
                str2 = string4;
                strArr = strArr2;
            } else if (i == 2) {
                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FP_SHOW_REOPEN_SYSTEM);
                if (fingerprintMsg != null && fingerprintMsg.getReopen() != null && !TextUtils.isEmpty(fingerprintMsg.getOpen().getTitle())) {
                    string2 = fingerprintMsg.getReopen().getTitle();
                } else {
                    string2 = ResUtils.getString(this, "bd_wallet_fingerprint_reopen_guide");
                }
                str3 = string2;
                if (fingerprintMsg != null && fingerprintMsg.getReopen() != null && !TextUtils.isEmpty(fingerprintMsg.getOpen().getSubtitle())) {
                    str = fingerprintMsg.getReopen().getSubtitle();
                } else {
                    str = ResUtils.getString(this, "bd_wallet_fingerprint_reopen_guide_subtitle");
                }
                String string5 = ResUtils.getString(this, "bd_wallet_fingerprint_reopen_guide_btn");
                if (fingerprintMsg != null && fingerprintMsg.getReopen() != null && fingerprintMsg.getReopen().getFingerprintProtocol() != null && !TextUtils.isEmpty(fingerprintMsg.getReopen().getFingerprintProtocol().getFingerprintProtocolPrefix()) && !TextUtils.isEmpty(fingerprintMsg.getReopen().getFingerprintProtocol().getFingerprintProtocolMsg()) && !TextUtils.isEmpty(fingerprintMsg.getReopen().getFingerprintProtocol().getFingerprintProtocolUrl())) {
                    this.f25340g.setText(fingerprintMsg.getReopen().getFingerprintProtocol().getFingerprintProtocolPrefix());
                    this.f25341h.setText(fingerprintMsg.getReopen().getFingerprintProtocol().getFingerprintProtocolMsg());
                    this.f25341h.setVisibility(0);
                    this.f25340g.setVisibility(0);
                    this.f25341h.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.fingerprint.ui.FingerprintOpenGuideActivity.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BaiduWalletDelegate.getInstance().openH5Module(FingerprintOpenGuideActivity.this, fingerprintMsg.getReopen().getFingerprintProtocol().getFingerprintProtocolUrl(), false);
                        }
                    });
                } else {
                    this.f25341h.setVisibility(8);
                    this.f25340g.setVisibility(8);
                }
                str2 = string5;
            } else if (i == 3) {
                StatisticManager.onEvent(StatServiceEvent.EVENT_FP_SHOW_UPGRADE_SYSTEM);
                if (fingerprintMsg != null && fingerprintMsg.getUpdate() != null && !TextUtils.isEmpty(fingerprintMsg.getOpen().getTitle())) {
                    string = fingerprintMsg.getUpdate().getTitle();
                } else {
                    string = ResUtils.getString(this, "bd_wallet_fingerprint_upgrade_guide");
                }
                str3 = string;
                if (fingerprintMsg != null && fingerprintMsg.getUpdate() != null && !TextUtils.isEmpty(fingerprintMsg.getOpen().getSubtitle())) {
                    str = fingerprintMsg.getUpdate().getSubtitle();
                } else {
                    str = ResUtils.getString(this, "bd_wallet_fingerprint_upgrade_guide_subtitle");
                }
                str2 = ResUtils.getString(this, "bd_wallet_fingerprint_upgrade_guide_btn");
            } else {
                str = "";
                str2 = str;
            }
            this.f25335a.setText(str3);
            this.f25336b.setText(str);
            this.f25337c.setText(str2);
            if (strArr != null && strArr.length > 0) {
                this.f25338e.setVisibility(0);
                this.f25339f.setVisibility(0);
                if (strArr.length == 1) {
                    this.f25338e.setText(!TextUtils.isEmpty(strArr[0]) ? strArr[0] : ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_hint0"));
                    this.f25339f.setText(ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_hint1"));
                    return;
                } else if (strArr.length >= 2) {
                    this.f25338e.setText(!TextUtils.isEmpty(strArr[0]) ? strArr[0] : ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_hint0"));
                    this.f25339f.setText(!TextUtils.isEmpty(strArr[1]) ? strArr[1] : ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_hint1"));
                    return;
                } else {
                    return;
                }
            }
            this.f25338e.setVisibility(8);
            this.f25339f.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        PayController.PayResultWrapper payResultWrapper = this.i;
        if (payResultWrapper.payResult == 0) {
            PayResultContent payResultContent = payResultWrapper.payResultContent;
            if (payResultContent != null) {
                payResultContent.isPaySuccess = true;
            }
            PayDataCache.getInstance().setPayReslutContent(payResultContent);
            H5ResultParams h5ResultParams = PayDataCache.getInstance().getH5ResultParams();
            if (h5ResultParams != null && h5ResultParams.toShowH5ResultPage()) {
                CashierDeskPayResult cashierDeskPayResult = new CashierDeskPayResult(getActivity(), h5ResultParams);
                cashierDeskPayResult.beforeShow();
                cashierDeskPayResult.show();
                return;
            }
            PayDataCache.getInstance().setPayReslutContent(payResultContent);
            Bundle bundle = new Bundle();
            bundle.putInt(BeanConstants.KEY_PAY_RESULT_TYPE, this.i.payResultType);
            startActivityWithExtras(bundle, WalletPayResultCommonActivity.class);
            PayBaseBeanActivity.exitEbpay();
        }
    }
}
