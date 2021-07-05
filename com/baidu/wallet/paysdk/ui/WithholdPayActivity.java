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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes6.dex */
public class WithholdPayActivity extends PayBaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DIALOG_WITHHOLD_TIP = 1;
    public static final String TAG = "WithholdPayActivity";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f26682a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f26683b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26684c;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26685e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f26686f;

    /* renamed from: g  reason: collision with root package name */
    public NetImageView f26687g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f26688h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f26689i;
    public SwitchButton j;
    public LinearLayout k;
    public TextView l;
    public RelativeLayout m;
    public TextView n;
    public LinearLayout o;
    public CheckBox p;
    public TextView q;
    public boolean r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public RelativeSizeSpan x;

    public WithholdPayActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = true;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || TextUtils.isEmpty(this.u)) {
            return;
        }
        if (!NetworkUtils.isNetworkAvailable(this)) {
            GlobalUtils.toast(this, ResUtils.getString(this, "ebpay_no_network"));
        } else {
            startActivity(new Intent(getActivity(), WebViewActivity.class).putExtra("jump_url", this.u).putExtra("webview_title", "bd_wallet_withhold_protocal_title"));
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            Drawable drawable = ResUtils.getDrawable(getActivity(), "wallet_base_cashdesk_order_btn_img_selector");
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.n.setCompoundDrawables(drawable, null, null, null);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, obj, str) == null) {
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            WalletGlobalUtils.safeShowDialog(this, 18, "");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PayRequest payRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
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
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            a();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 == 1) {
                return new PromptTipDialog(getActivity());
            }
            return super.onCreateDialog(i2);
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, dialog) == null) {
            if (i2 == 1) {
                PromptTipDialog promptTipDialog = (PromptTipDialog) dialog;
                promptTipDialog.setTitleMessage(ResUtils.getString(this, "bd_wallet_withhold_tips"));
                promptTipDialog.setMessage(this.s);
                promptTipDialog.setButtonMessage(ResUtils.getString(this, "ebpay_know"));
                return;
            }
            super.onPrepareDialog(i2, dialog);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            refreshUI();
        }
    }

    public void refreshUI() {
        PayRequest payRequest;
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)) == null || payRequest.withholding == null) {
            return;
        }
        String orderPrice = payRequest.getOrderPrice();
        String discountAmount = payRequest.getDiscountAmount();
        String discountMsg = payRequest.getDiscountMsg();
        boolean z = true;
        this.f26682a.setText(!TextUtils.isEmpty(orderPrice) ? String.format(this.v, StringUtils.fen2Yuan(orderPrice)) : "");
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
            this.f26682a.getPaint().setFlags(16);
        } else {
            this.f26682a.getPaint().setFlags(1);
        }
        if (payRequest.showCouponListEntry() && z2) {
            this.f26683b.setVisibility(0);
            TextView textView = this.f26684c;
            if (TextUtils.isEmpty(discountMsg)) {
                discountMsg = "";
            }
            textView.setText(discountMsg);
            this.f26685e.setText(!TextUtils.isEmpty(discountAmount) ? String.format(this.w, StringUtils.fen2Yuan(discountAmount)) : "");
        } else {
            this.f26683b.setVisibility(8);
        }
        String format = !TextUtils.isEmpty(bigDecimal3) ? String.format(this.v, StringUtils.fen2Yuan(bigDecimal3)) : "";
        if (format.length() > 0) {
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(this.x, 0, 1, 33);
            this.f26686f.setText(spannableString);
        } else {
            this.f26686f.setText(format);
        }
        if (!TextUtils.isEmpty(payRequest.withholding.sp_log_url)) {
            this.f26687g.setVisibility(0);
            this.f26687g.setImageUrl(payRequest.withholding.sp_log_url);
        } else {
            this.f26687g.setVisibility(8);
        }
        this.f26688h.setText(!TextUtils.isEmpty(payRequest.withholding.sp_company) ? payRequest.withholding.sp_company : "");
        this.f26689i.setText(!TextUtils.isEmpty(payRequest.withholding.authorize_action_desc) ? payRequest.withholding.authorize_action_desc : "");
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
            int i2 = 0;
            while (true) {
                String[] strArr2 = payRequest.withholding.detail_info.detail;
                if (i2 >= strArr2.length) {
                    break;
                }
                if (!TextUtils.isEmpty(strArr2[i2])) {
                    this.s += "\n· " + payRequest.withholding.detail_info.detail[i2];
                }
                i2++;
            }
        }
        z = (TextUtils.isEmpty(payRequest.withholding.agreement_tag) || !"1".equals(payRequest.withholding.agreement_tag)) ? false : false;
        this.r = z;
        setProtocalCheck(z);
    }

    public void setAuthSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.j.setChecked(z);
            a(z, false);
        }
    }

    public void setProtocalCheck(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.p.setChecked(z);
            this.m.setEnabled(z);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)}) == null) {
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            startActivity(new Intent(this, OrderConfirmActivity.class));
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            setContentView(ResUtils.layout(this, "wallet_base_withhold_pay_layout"));
            initActionBar("lbspay_title_new");
            this.f26682a = (TextView) findViewById(ResUtils.id(this, "tv_order_amount"));
            this.f26683b = (LinearLayout) findViewById(ResUtils.id(this, "ll_discount_panel"));
            this.f26685e = (TextView) findViewById(ResUtils.id(this, "tv_discount"));
            this.f26684c = (TextView) findViewById(ResUtils.id(this, "tv_discount_tips"));
            this.f26686f = (TextView) findViewById(ResUtils.id(this, "tv_pay_amount"));
            this.f26687g = (NetImageView) findViewById(ResUtils.id(this, "ni_sp_logo"));
            this.f26688h = (TextView) findViewById(ResUtils.id(this, "tv_sp_name"));
            this.f26689i = (TextView) findViewById(ResUtils.id(this, "tv_sp_action"));
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
            this.f26689i.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.j.setOnCheckedListener(new SwitchButton.a(this) { // from class: com.baidu.wallet.paysdk.ui.WithholdPayActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ WithholdPayActivity f26690a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f26690a = this;
                }

                @Override // com.baidu.wallet.paysdk.ui.widget.SwitchButton.a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        this.f26690a.a(z, true);
                        this.f26690a.j.setChecked(z);
                    }
                }
            });
            this.p.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: com.baidu.wallet.paysdk.ui.WithholdPayActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ WithholdPayActivity f26691a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f26691a = this;
                }

                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, compoundButton, z) == null) {
                        this.f26691a.m.setEnabled(z);
                    }
                }
            });
            setAuthSwitch(true);
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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
}
