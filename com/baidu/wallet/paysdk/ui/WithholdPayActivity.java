package com.baidu.wallet.paysdk.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.datamodel.Withholding;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.dialog.PromptTipDialog;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.SwitchButton;
import com.baidu.wallet.statistics.api.StatisticManager;
import java.math.BigDecimal;
/* loaded from: classes5.dex */
public class WithholdPayActivity extends PayBaseActivity implements View.OnClickListener {
    public static final int DIALOG_WITHHOLD_TIP = 1;
    public static final String TAG = "WithholdPayActivity";

    /* renamed from: a  reason: collision with root package name */
    public TextView f25988a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f25989b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f25990c;

    /* renamed from: e  reason: collision with root package name */
    public TextView f25991e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25992f;

    /* renamed from: g  reason: collision with root package name */
    public NetImageView f25993g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25994h;
    public TextView i;
    public SwitchButton j;
    public LinearLayout k;
    public TextView l;
    public RelativeLayout m;
    public TextView n;
    public LinearLayout o;
    public CheckBox p;
    public TextView q;
    public boolean r = true;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public RelativeSizeSpan x;

    private void c() {
        if (TextUtils.isEmpty(this.u)) {
            return;
        }
        if (!NetworkUtils.isNetworkAvailable(this)) {
            GlobalUtils.toast(this, ResUtils.getString(this, "ebpay_no_network"));
        } else {
            startActivity(new Intent(getActivity(), WebViewActivity.class).putExtra("jump_url", this.u).putExtra("webview_title", "bd_wallet_withhold_protocal_title"));
        }
    }

    private void d() {
        Drawable drawable = ResUtils.getDrawable(getActivity(), "wallet_base_cashdesk_order_btn_img_selector");
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.n.setCompoundDrawables(drawable, null, null, null);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i, Object obj, String str) {
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        WalletGlobalUtils.safeShowDialog(this, 18, "");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PayRequest payRequest;
        int id = view.getId();
        if (id == ResUtils.id(this, "tv_sp_action")) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_WITHHOLD_PROMPT_CLICK);
            if (TextUtils.isEmpty(this.s)) {
                return;
            }
            WalletGlobalUtils.safeShowDialog(this, 1, "");
        } else if (id == ResUtils.id(this, "tv_protocol_txt")) {
            c();
        } else if (id != ResUtils.id(this, "rl_auth_pay_button") || (payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)) == null) {
        } else {
            String str = this.j.isChecked() ? "1" : "0";
            payRequest.withholding_auth = str;
            StatisticManager.onEventWithValue(StatServiceEvent.EVENT_WITHHOLD_PAYMETHOD_CLICK, str);
            b();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i == 1) {
            return new PromptTipDialog(getActivity());
        }
        return super.onCreateDialog(i);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        if (i == 1) {
            PromptTipDialog promptTipDialog = (PromptTipDialog) dialog;
            promptTipDialog.setTitleMessage(ResUtils.getString(this, "bd_wallet_withhold_tips"));
            promptTipDialog.setMessage(this.s);
            promptTipDialog.setButtonMessage(ResUtils.getString(this, "ebpay_know"));
            return;
        }
        super.onPrepareDialog(i, dialog);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        refreshUI();
    }

    public void refreshUI() {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        if (payRequest == null || payRequest.withholding == null) {
            return;
        }
        String orderPrice = payRequest.getOrderPrice();
        String discountAmount = payRequest.getDiscountAmount();
        String discountMsg = payRequest.getDiscountMsg();
        boolean z = true;
        this.f25988a.setText(!TextUtils.isEmpty(orderPrice) ? String.format(this.v, StringUtils.fen2Yuan(orderPrice)) : "");
        try {
            bigDecimal = new BigDecimal(orderPrice);
        } catch (NumberFormatException unused) {
            bigDecimal = new BigDecimal("0");
        }
        try {
            bigDecimal2 = new BigDecimal(discountAmount);
        } catch (NumberFormatException unused2) {
            bigDecimal2 = new BigDecimal("0");
        }
        BigDecimal subtract = bigDecimal.subtract(bigDecimal2);
        boolean z2 = bigDecimal.compareTo(subtract) > 0;
        String bigDecimal3 = subtract.toString();
        if (z2) {
            this.f25988a.getPaint().setFlags(16);
        } else {
            this.f25988a.getPaint().setFlags(1);
        }
        if (payRequest.showCouponListEntry() && z2) {
            this.f25989b.setVisibility(0);
            TextView textView = this.f25990c;
            if (TextUtils.isEmpty(discountMsg)) {
                discountMsg = "";
            }
            textView.setText(discountMsg);
            this.f25991e.setText(!TextUtils.isEmpty(discountAmount) ? String.format(this.w, StringUtils.fen2Yuan(discountAmount)) : "");
        } else {
            this.f25989b.setVisibility(8);
        }
        String format = !TextUtils.isEmpty(bigDecimal3) ? String.format(this.v, StringUtils.fen2Yuan(bigDecimal3)) : "";
        if (format.length() > 0) {
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(this.x, 0, 1, 33);
            this.f25992f.setText(spannableString);
        } else {
            this.f25992f.setText(format);
        }
        if (!TextUtils.isEmpty(payRequest.withholding.sp_log_url)) {
            this.f25993g.setVisibility(0);
            this.f25993g.setImageUrl(payRequest.withholding.sp_log_url);
        } else {
            this.f25993g.setVisibility(8);
        }
        this.f25994h.setText(!TextUtils.isEmpty(payRequest.withholding.sp_company) ? payRequest.withholding.sp_company : "");
        this.i.setText(!TextUtils.isEmpty(payRequest.withholding.authorize_action_desc) ? payRequest.withholding.authorize_action_desc : "");
        Withholding.AgreementInfo[] agreementInfoArr = payRequest.withholding.agreement_info;
        if (agreementInfoArr != null && agreementInfoArr.length >= 1) {
            if (!TextUtils.isEmpty(agreementInfoArr[0].title)) {
                String str = payRequest.withholding.agreement_info[0].title;
                this.t = str;
                this.q.setText(str);
            }
            if (!TextUtils.isEmpty(payRequest.withholding.agreement_info[0].url)) {
                this.u = payRequest.withholding.agreement_info[0].url;
            }
        }
        String[] strArr = payRequest.withholding.authorize_desc;
        if (strArr != null && strArr.length >= 1 && !TextUtils.isEmpty(strArr[0])) {
            this.k.setVisibility(0);
            this.l.setText(payRequest.withholding.authorize_desc[0]);
        } else {
            this.k.setVisibility(8);
        }
        Withholding.DetailInfo detailInfo = payRequest.withholding.detail_info;
        if (detailInfo != null) {
            this.s = "";
            if (!TextUtils.isEmpty(detailInfo.introduce)) {
                this.s += payRequest.withholding.detail_info.introduce + "\n";
            }
            int i = 0;
            while (true) {
                String[] strArr2 = payRequest.withholding.detail_info.detail;
                if (i >= strArr2.length) {
                    break;
                }
                if (!TextUtils.isEmpty(strArr2[i])) {
                    this.s += "\n· " + payRequest.withholding.detail_info.detail[i];
                }
                i++;
            }
        }
        z = (TextUtils.isEmpty(payRequest.withholding.agreement_tag) || !"1".equals(payRequest.withholding.agreement_tag)) ? false : false;
        this.r = z;
        setProtocalCheck(z);
    }

    public void setAuthSwitch(boolean z) {
        this.j.setChecked(z);
        a(z, false);
    }

    public void setProtocalCheck(boolean z) {
        this.p.setChecked(z);
        this.m.setEnabled(z);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i) {
    }

    private void b() {
        startActivity(new Intent(this, OrderConfirmActivity.class));
    }

    private void a() {
        setContentView(ResUtils.layout(this, "wallet_base_withhold_pay_layout"));
        initActionBar("lbspay_title_new");
        this.f25988a = (TextView) findViewById(ResUtils.id(this, "tv_order_amount"));
        this.f25989b = (LinearLayout) findViewById(ResUtils.id(this, "ll_discount_panel"));
        this.f25991e = (TextView) findViewById(ResUtils.id(this, "tv_discount"));
        this.f25990c = (TextView) findViewById(ResUtils.id(this, "tv_discount_tips"));
        this.f25992f = (TextView) findViewById(ResUtils.id(this, "tv_pay_amount"));
        this.f25993g = (NetImageView) findViewById(ResUtils.id(this, "ni_sp_logo"));
        this.f25994h = (TextView) findViewById(ResUtils.id(this, "tv_sp_name"));
        this.i = (TextView) findViewById(ResUtils.id(this, "tv_sp_action"));
        this.j = (SwitchButton) findViewById(ResUtils.id(this, "sb_auth_switch"));
        this.k = (LinearLayout) findViewById(ResUtils.id(this, "ll_auth_desc_panel"));
        this.l = (TextView) findViewById(ResUtils.id(this, "tv_auth_desc"));
        this.m = (RelativeLayout) findViewById(ResUtils.id(this, "rl_auth_pay_button"));
        this.n = (TextView) findViewById(ResUtils.id(this, "tv_auth_pay_txt"));
        this.o = (LinearLayout) findViewById(ResUtils.id(this, "ll_protocol_panel"));
        this.p = (CheckBox) findViewById(ResUtils.id(this, "cb_protocol"));
        this.q = (TextView) findViewById(ResUtils.id(this, "tv_protocol_txt"));
        this.v = ResUtils.getString(this, "price_format");
        this.w = ResUtils.getString(this, "save_format");
        this.x = new RelativeSizeSpan(0.5f);
        this.i.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.j.setOnCheckedListener(new SwitchButton.a() { // from class: com.baidu.wallet.paysdk.ui.WithholdPayActivity.1
            @Override // com.baidu.wallet.paysdk.ui.widget.SwitchButton.a
            public void a(boolean z) {
                WithholdPayActivity.this.a(z, true);
                WithholdPayActivity.this.j.setChecked(z);
            }
        });
        this.p.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.wallet.paysdk.ui.WithholdPayActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                WithholdPayActivity.this.m.setEnabled(z);
            }
        });
        setAuthSwitch(true);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2) {
        if (z) {
            this.o.setVisibility(0);
            this.n.setText(ResUtils.getString(this, "bd_wallet_withhold_pay_button"));
            setProtocalCheck(this.r);
            if (z2) {
                StatisticManager.onEventWithValue(StatServiceEvent.EVENT_WITHHOLD_SWITCH_CHECK, "1");
                return;
            }
            return;
        }
        this.o.setVisibility(8);
        this.n.setText(ResUtils.getString(this, "ebpay_submit_pay"));
        this.m.setEnabled(true);
        if (z2) {
            StatisticManager.onEventWithValue(StatServiceEvent.EVENT_WITHHOLD_SWITCH_CHECK, "0");
        }
    }
}
