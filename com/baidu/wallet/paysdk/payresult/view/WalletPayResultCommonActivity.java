package com.baidu.wallet.paysdk.payresult.view;

import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.statusbar.ImmersiveStatusBarManager;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.ViewHelper;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.NFCUtil;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.Compliance;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.presenter.a;
import com.baidu.wallet.paysdk.payresult.presenter.b;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.paysdk.ui.widget.FeedbackDialog;
import com.baidu.wallet.paysdk.ui.widget.ImageViewDialog;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class WalletPayResultCommonActivity extends PayBaseBeanActivity implements View.OnClickListener, b.InterfaceC0255b {
    public static final int DIALOG_FEEDBACK = 74081;

    /* renamed from: b  reason: collision with root package name */
    public static final String f25325b = WalletPayResultCommonActivity.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public b.a f25326a;

    /* renamed from: c  reason: collision with root package name */
    public NetImageView f25327c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f25328d;

    /* renamed from: e  reason: collision with root package name */
    public View f25329e;

    /* renamed from: f  reason: collision with root package name */
    public View f25330f;

    /* renamed from: g  reason: collision with root package name */
    public View f25331g;
    public TextView mMainTip;
    public View mPayResultOrderAmountLayout;
    public TextView mPayResultOrderAmountText;
    public TextView mPayResultOrderPrefix;
    public TextView mPayResultPayType;
    public View mPayResultPayTypeGroup;
    public TextView mPayResultPayTypePrefix;
    public View mPayResultRealMoneyLayout;
    public TextView mPayResultRealMoneyText;
    public TextView mPayResultTotalDiscount;
    public View mPayResultTotalDiscountGroup;
    public TextView mPayResultTotalDiscountTip;
    public Button mPaySuccess;
    public ImageView mResultImg;
    public TextView mSubtitleView;
    public LinearLayout mpayResultDiscountType;
    public View mpayResultDiscountTypeGroup;
    public TextView mpayResultDiscountTypeTip;
    public String strRmbUnit = "";

    /* renamed from: h  reason: collision with root package name */
    public int f25332h = 0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f25333i = true;
    public boolean j = true;

    private void b() {
        a(findViewById(ResUtils.id(this, "root_layout")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (isFinishing()) {
            return;
        }
        this.f25326a.h();
    }

    private void d() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f25331g.getLayoutParams();
        if (this.f25333i) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mResultImg.getLayoutParams();
            layoutParams2.setMargins(0, DisplayUtils.dip2px(this, 100.0f), 0, 0);
            this.mResultImg.setLayoutParams(layoutParams2);
            findViewById(ResUtils.id(this, "pay_result_content_info_head_graw")).setVisibility(8);
            findViewById(ResUtils.id(this, "pay_result_content_info_foot_wave")).setVisibility(8);
            findViewById(ResUtils.id(this, "pay_result_content_info_white")).setBackgroundColor(ResUtils.getColor(this, "ebpay_f7f8fa"));
            layoutParams.height = DisplayUtils.dip2px(this, 230.0f);
            this.f25331g.setLayoutParams(layoutParams);
            return;
        }
        if (this.j) {
            this.f25330f.setVisibility(8);
            this.f25332h++;
        }
        int i2 = this.f25328d.getVisibility() == 0 ? 16 : 0;
        int dip2px = DisplayUtils.dip2px(this, 320 - (this.f25332h * 35));
        int displayHeight = (DisplayUtils.getDisplayHeight(this) - DisplayUtils.dip2px(this, 258.0f)) - i2;
        if (dip2px <= displayHeight) {
            dip2px = displayHeight;
        }
        layoutParams.height = dip2px;
        this.f25331g.setLayoutParams(layoutParams);
    }

    public boolean changePayResultMainInfo(int i2, int i3) {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC0255b
    public void finishPage() {
        finish();
    }

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC0255b
    public void initActionBar(String str) {
        BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(this, "bdactionbar"));
        if (bdActionBar != null) {
            bdActionBar.setTitle(ResUtils.string(this, str));
            bdActionBar.hideLeftZone();
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC0255b
    public void initViewElements() {
        this.mResultImg = (ImageView) findViewById(ResUtils.id(this, "payresult_maininfo_icon"));
        this.mMainTip = (TextView) findViewById(ResUtils.id(this, "payresult_maininfo_main_tip"));
        Button button = (Button) findViewById(ResUtils.id(this, "pay_success_bt"));
        this.mPaySuccess = button;
        button.setOnClickListener(this);
        this.mPaySuccess.setVisibility(0);
        this.f25331g = findViewById(ResUtils.id(this, "pay_result_content_info"));
        this.mPayResultPayTypeGroup = findViewById(ResUtils.id(this, "payresult_pay_type_group"));
        this.mPayResultPayType = (TextView) findViewById(ResUtils.id(this, "payresult_pay_type_info"));
        this.mPayResultPayTypePrefix = (TextView) findViewById(ResUtils.id(this, "payresult_pay_type_pfefix"));
        this.mPayResultOrderAmountLayout = findViewById(ResUtils.id(this, "payresult_order_amount_group"));
        this.mPayResultOrderPrefix = (TextView) findViewById(ResUtils.id(this, "payresult_order_amount_prefix"));
        this.mPayResultOrderAmountText = (TextView) findViewById(ResUtils.id(this, "payresult_order_amount"));
        this.mPayResultTotalDiscountGroup = findViewById(ResUtils.id(this, "payresult_discount_amount_group"));
        this.mPayResultTotalDiscount = (TextView) findViewById(ResUtils.id(this, "payresult_discount_amount"));
        this.mPayResultTotalDiscountTip = (TextView) findViewById(ResUtils.id(this, "payresult_discount_amount_tip"));
        this.mpayResultDiscountTypeGroup = findViewById(ResUtils.id(this, "payresult_discount_info_group"));
        this.mpayResultDiscountType = (LinearLayout) findViewById(ResUtils.id(this, "payresult_discount_info"));
        this.mpayResultDiscountTypeTip = (TextView) findViewById(ResUtils.id(this, "payresult_discount_info_tip"));
        this.mPayResultRealMoneyLayout = findViewById(ResUtils.id(this, "payresult_pay_info_group"));
        this.mPayResultRealMoneyText = (TextView) findViewById(ResUtils.id(this, "payresult_pay_info"));
        this.f25327c = (NetImageView) findViewById(ResUtils.id(this, "payresult_title"));
        this.f25327c.setImageResource(ResUtils.drawable(getApplicationContext(), "wallet_cashdesk_logo"));
        this.mSubtitleView = (TextView) findViewById(ResUtils.id(this, "payresult_maininfo_sub_tip"));
        this.f25328d = (TextView) findViewById(ResUtils.id(this, "authorize_text"));
        this.f25329e = findViewById(ResUtils.id(this, "statusbar_top"));
        this.f25330f = findViewById(ResUtils.id(this, "divider_line"));
        setTop();
    }

    public boolean isPayResultMoneyLayoutVisible() {
        return true;
    }

    public boolean isPayResultRealMoneyTextVisible() {
        return this.mPayResultRealMoneyLayout.getVisibility() == 0;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mPaySuccess) {
            PayStatisticsUtil.onEventWithValues(StatServiceEvent.RESULT_CLICK_BTN, this.f25326a.f());
            if (this.f25326a.j()) {
                FeedbackDialog feedbackDialog = new FeedbackDialog(getActivity());
                feedbackDialog.initDialog(this.f25326a.k());
                feedbackDialog.show();
                return;
            }
            finishWithoutAnim();
            this.f25326a.g();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setRequestedOrientation(1);
        super.onCreate(bundle);
        setContentView(ResUtils.layout(this, "wallet_cashdesk_pay_result_common_activity"));
        this.strRmbUnit = ResUtils.getString(this, "wallet_base_unit");
        a aVar = new a(this, this, bundle);
        this.f25326a = aVar;
        if (!aVar.a()) {
            PayCallBackManager.callBackClientCancel(this, "WalletPayResultCommonActivity.onCreate().1");
            finish();
            return;
        }
        if (this.f25326a.b()) {
            setFlagPaySdk();
        }
        if (!this.f25326a.a(bundle)) {
            PayCallBackManager.callBackClientCancel(this, "WalletPayResultCommonActivity.onCreate().2");
            finish();
        } else if (this.f25326a.c(bundle)) {
            d();
            b();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b.a aVar = this.f25326a;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f25326a.b(bundle);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC0255b
    public void setOKBtnText(String str) {
        this.mPaySuccess.setText(str);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC0255b
    public void setTitleLogo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f25327c.setImageUrl(str);
    }

    public void setTop() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.f25329e.setLayoutParams(new LinearLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(getActivity())));
        ImmersiveStatusBarManager.setTopBar(getActivity(), this.f25329e, isStatusbarTextColorBlack());
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC0255b
    public boolean showAuthDialog(Compliance compliance) {
        Compliance.AntiMoneyLaundering antiMoneyLaundering;
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        if (payRequest != null && TextUtils.equals(payRequest.getPayFrom(), BaiduPay.PAY_FROM_AUTHORIZE)) {
            LogUtil.e(WalletPayResultCommonActivity.class.getSimpleName(), payRequest.getPayFrom(), null);
            return false;
        } else if (compliance == null || (antiMoneyLaundering = compliance.anti_money_laundering) == null || antiMoneyLaundering.after_pay_identity != 1) {
            return false;
        } else {
            a(antiMoneyLaundering.auth_msg);
            return true;
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC0255b
    public void showAuthorizeMsg(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.mSubtitleView.getText())) {
                this.mSubtitleView.setVisibility(8);
            }
            this.f25328d.setVisibility(0);
            this.f25328d.setText(str);
            return;
        }
        this.f25328d.setVisibility(8);
    }

    public void showDiscountAmountInfo(String str, String str2, String str3) {
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC0255b
    public void showDiscountTypeInfo(String[][] strArr, String str, String str2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 5;
        layoutParams.gravity = 5;
        layoutParams.setMargins(0, DisplayUtils.dip2px(this, 15.0f), 0, 0);
        if (strArr != null) {
            this.f25333i = false;
            this.j = false;
            this.mpayResultDiscountTypeGroup.setVisibility(0);
            int i2 = 0;
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (strArr[i3].length > 1) {
                    if (TextUtils.equals(strArr[i3][0], "msg")) {
                        this.mpayResultDiscountTypeTip.setText(strArr[i3][1]);
                    } else {
                        i2++;
                        if (i3 == 0) {
                            a(strArr[i3][0], strArr[i3][1], layoutParams2);
                        } else {
                            this.f25332h--;
                            a(strArr[i3][0], strArr[i3][1], layoutParams);
                        }
                    }
                }
            }
            if (i2 >= 2) {
                this.mPayResultTotalDiscountGroup.setVisibility(0);
                this.mPayResultTotalDiscountTip.setText(str2);
                this.mPayResultTotalDiscount.setText(new SpannableString("-" + this.strRmbUnit + str));
                return;
            }
            this.f25332h++;
            this.mPayResultTotalDiscountGroup.setVisibility(8);
            return;
        }
        this.mPayResultTotalDiscountGroup.setVisibility(8);
        this.mpayResultDiscountTypeGroup.setVisibility(8);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC0255b
    public void showExpectedTime(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mSubtitleView.setText(str);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC0255b
    public void showMarketDialog(String str, final String str2) {
        final PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        final ImageViewDialog imageViewDialog = new ImageViewDialog(getActivity());
        imageViewDialog.initDialog(str, new ImageViewDialog.a() { // from class: com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity.2
            @Override // com.baidu.wallet.paysdk.ui.widget.ImageViewDialog.a
            public void a() {
                if (CheckUtils.isFastDoubleClick()) {
                    LogUtil.d(WalletPayResultCommonActivity.f25325b, "FAST CLICK ");
                    return;
                }
                BaiduWalletDelegate.getInstance().openH5Module(WalletPayResultCommonActivity.this.getActivity(), str2);
                PayRequest payRequest2 = payRequest;
                if (payRequest2 != null) {
                    PayStatisticsUtil.onEventWithValues(StatServiceEvent.EVENT_PAY_CROSS_MARKET_IMAGE_CLICK, Arrays.asList(payRequest2.mSpNO, str2));
                }
                imageViewDialog.dismiss();
            }

            @Override // com.baidu.wallet.paysdk.ui.widget.ImageViewDialog.a
            public void b() {
                PayRequest payRequest2 = payRequest;
                if (payRequest2 != null) {
                    PayStatisticsUtil.onEventWithValues(StatServiceEvent.EVENT_PAY_CROSS_MARKET_CLOSE_CLICK, Arrays.asList(payRequest2.mSpNO, str2));
                }
            }

            @Override // com.baidu.wallet.paysdk.ui.widget.ImageViewDialog.a
            public void c() {
                PayRequest payRequest2 = payRequest;
                if (payRequest2 != null) {
                    PayStatisticsUtil.onEventWithValues(StatServiceEvent.EVENT_PAY_CROSS_MARKET_BACK_CLICK, Arrays.asList(payRequest2.mSpNO, str2));
                }
            }
        });
        imageViewDialog.show();
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC0255b
    public void showPayResultMoneyLayoutVisible(boolean z) {
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC0255b
    public void showPayResultRealMoneyText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f25330f.setVisibility(0);
            this.mPayResultRealMoneyLayout.setVisibility(0);
            RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.75f);
            SpannableString spannableString = new SpannableString(this.strRmbUnit + str);
            spannableString.setSpan(relativeSizeSpan, 0, 1, 33);
            this.mPayResultRealMoneyText.setText(spannableString);
            this.f25333i = false;
            return;
        }
        this.f25330f.setVisibility(8);
        this.mPayResultRealMoneyLayout.setVisibility(8);
        this.f25332h += 2;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC0255b
    public void showPaySuccess(HashMap<String, String> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            this.mMainTip.setText(ResUtils.getString(this, hashMap.get("mainTip")));
            this.mResultImg.setImageDrawable(ResUtils.getDrawable(this, hashMap.get("statusDrawableName")));
            this.mPaySuccess.setText(ResUtils.getString(this, hashMap.get("okBtnText")));
            if (TextUtils.isEmpty(hashMap.get("update_phone_desc"))) {
                return;
            }
            this.mSubtitleView.setText(hashMap.get("update_phone_desc"));
            return;
        }
        PayCallBackManager.callBackClientCancel(this, "WalletPayResultCommonActivity.showPaySuccess().1");
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC0255b
    public void showPayTypeInfo(String[][] strArr, String str, String str2, String str3) {
        if (strArr != null && strArr.length > 0) {
            this.f25333i = false;
            this.j = false;
            this.mPayResultPayTypeGroup.setVisibility(0);
            if (strArr[0].length > 1) {
                this.mPayResultPayTypePrefix.setText(strArr[0][0]);
                this.mPayResultPayType.setText(strArr[0][1]);
                return;
            }
            return;
        }
        this.f25332h++;
        this.mPayResultPayTypeGroup.setVisibility(8);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC0255b
    public void showPaying(HashMap<String, String> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            this.mResultImg.setImageDrawable(ResUtils.getDrawable(this, hashMap.get("statusDrawableName")));
            this.mMainTip.setText(ResUtils.getString(this, hashMap.get("mainTip")));
            if (TextUtils.isEmpty(hashMap.get("update_phone_desc"))) {
                return;
            }
            this.mSubtitleView.setText(hashMap.get("update_phone_desc"));
            return;
        }
        PayCallBackManager.callBackClientCancel(this, "WalletPayResultCommonActivity.showPaying().1");
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC0255b
    public void showTotalAmountInfo(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            this.f25333i = false;
            this.j = false;
            this.mPayResultOrderAmountLayout.setVisibility(0);
            this.mPayResultOrderAmountText.setText(this.strRmbUnit + str);
            if (!TextUtils.isEmpty(str2)) {
                this.mPayResultOrderPrefix.setText(str2);
            }
            if (Float.valueOf(str3).floatValue() < Float.valueOf(str).floatValue()) {
                this.mPayResultOrderAmountText.getPaint().setFlags(16);
                return;
            } else {
                this.mPayResultOrderAmountText.getPaint().setFlags(1);
                return;
            }
        }
        this.mPayResultOrderAmountLayout.setVisibility(8);
        this.f25332h++;
    }

    private void a(final View view) {
        view.post(new Runnable() { // from class: com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity.1
            @Override // java.lang.Runnable
            public void run() {
                final int bottom = view.getBottom();
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                ofFloat.setDuration(500L);
                ofFloat.setInterpolator(new DecelerateInterpolator());
                ofFloat.start();
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        ViewHelper.setTranslationY(view, (-bottom) * floatValue);
                        if (floatValue <= 0.0f) {
                            WalletPayResultCommonActivity.this.c();
                        }
                    }
                });
            }
        });
    }

    private void a(String str, String str2, LinearLayout.LayoutParams layoutParams) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        View inflate = getLayoutInflater().inflate(ResUtils.layout(this, "wallet_cashdesk_discount_info_group"), (ViewGroup) null);
        ((TextView) inflate.findViewById(ResUtils.id(this, "payresult_discount_type"))).setText(str);
        ((TextView) inflate.findViewById(ResUtils.id(this, "payresult_discount_type_amount"))).setText("-" + this.strRmbUnit + str2);
        this.mpayResultDiscountType.addView(inflate, layoutParams);
    }

    private void a(final String str) {
        new Handler().post(new Runnable() { // from class: com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity.3
            @Override // java.lang.Runnable
            public void run() {
                final PromptDialog promptDialog = new PromptDialog(WalletPayResultCommonActivity.this.getActivity());
                promptDialog.setMessage(str);
                promptDialog.setCanceledOnTouchOutside(false);
                promptDialog.setCancelable(true);
                promptDialog.setPositiveBtn(ResUtils.string(WalletPayResultCommonActivity.this.getApplicationContext(), "wallet_hce_do_auth"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PromptDialog promptDialog2 = promptDialog;
                        if (promptDialog2 != null && promptDialog2.isShowing()) {
                            promptDialog.dismiss();
                        }
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, "1150");
                        StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_RESULT_RNAUTH_ENTER, StatHelper.getOrderNo());
                        BaiduPayDelegate.getInstance().doPayRNAuth(WalletPayResultCommonActivity.this.getActivity(), hashMap, new RNAuthCallBack() { // from class: com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity.3.1.1
                            @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                            public void onRNAuthResult(int i2, String str2) {
                                String orderNo = StatHelper.getOrderNo();
                                StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_RESULT_RNAUTH_RESULT, StatHelper.collectData(orderNo, i2 + "", str2));
                            }
                        });
                    }
                });
                promptDialog.setNegativeBtn(ResUtils.string(WalletPayResultCommonActivity.this.getApplicationContext(), "ebpay_cancel"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity.3.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PromptDialog promptDialog2 = promptDialog;
                        if (promptDialog2 == null || !promptDialog2.isShowing()) {
                            return;
                        }
                        promptDialog.dismiss();
                    }
                });
                promptDialog.show();
            }
        });
    }
}
