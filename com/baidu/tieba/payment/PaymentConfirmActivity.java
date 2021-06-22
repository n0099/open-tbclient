package com.baidu.tieba.payment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
import com.baidu.tieba.payment.data.PayRequestData;
import com.baidu.tieba.payment.data.PayResultData;
import com.baidu.tieba.payment.data.PayVcodeInfoData;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
import com.baidu.tieba.payment.message.ResponsePaymentConfirmInfoMessage;
import com.baidu.tieba.payment.message.ResponsePaymentPayMessage;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import d.a.n0.r.s.a;
import java.net.URLEncoder;
/* loaded from: classes5.dex */
public class PaymentConfirmActivity extends BaseActivity<PaymentConfirmActivity> {
    public int currency;
    public String mClickZone;
    public long mNeedTbean;
    public boolean mPasswordFreeze;
    public PaymentConfirmModel<PaymentConfirmActivity> mPaymentConfirmModel;
    public d.a.o0.d2.c mPaymentConfirmView;
    public String mReferPage;
    public PaymentConfirmRequestData mRequestData;
    public String mUserId;
    public PaymentConfirmInfoData paymentConfirmInfoData;
    public boolean scoresEnough;
    public int mBookType = -1;
    public String mBookId = "";
    public HttpMessageListener mRequestPaymentConfirmInfoListener = new h(CmdConfigHttp.CMD_PAYMENT_CONFIRM_INFO);
    public HttpMessageListener mPayListener = new i(CmdConfigHttp.CMD_PAYMENT_PAY);
    public CustomMessageListener mBindPhoneListener = new j(2001359);
    public CustomMessageListener mBuyTbeanListener = new k(2001227);

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PaymentConfirmActivity paymentConfirmActivity = PaymentConfirmActivity.this;
            paymentConfirmActivity.goToUEGValidate(2270066, paymentConfirmActivity.getResources().getString(R.string.sapi_forget_password_title));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f18939e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f18940f;

        public b(int i2, String str) {
            this.f18939e = i2;
            this.f18940f = str;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
            PaymentConfirmActivity.this.goToUEGValidate(this.f18939e, this.f18940f);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f18943e;

        public d(String str) {
            this.f18943e = str;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PaymentConfirmActivity.this.getPageContext().getPageActivity(), PaymentConfirmActivity.this.getResources().getString(R.string.payment_dilaog_error_button), this.f18943e, true, true, true)));
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {
        public e() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
            PaymentConfirmActivity.this.closeActivity();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements CompoundButton.OnCheckedChangeListener {
        public f() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            d.a.n0.r.d0.b.j().t(PaymentConfirmActivity.this.generateSharedPkey("payment_confirm_show"), !z);
            if (z) {
                return;
            }
            d.a.n0.r.d0.b.j().v(PaymentConfirmActivity.this.generateSharedPkey("payment_confirm_notshow_count"), 0);
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PaymentConfirmActivity.this.mPasswordFreeze) {
                PaymentConfirmActivity.this.showPasswordInputDialog(0, null);
            } else if (PaymentConfirmActivity.this.scoresEnough) {
                d.a.o0.d2.d.a("c10292");
                PaymentConfirmActivity.this.goToPayment();
            } else {
                d.a.o0.d2.d.a("c10293");
                PaymentConfirmActivity.this.goToBuyTdouActivity();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends HttpMessageListener {
        public h(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PaymentConfirmActivity paymentConfirmActivity = PaymentConfirmActivity.this;
            paymentConfirmActivity.hideLoadingView(paymentConfirmActivity.mPaymentConfirmView.k());
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof ResponsePaymentConfirmInfoMessage)) {
                return;
            }
            ResponsePaymentConfirmInfoMessage responsePaymentConfirmInfoMessage = (ResponsePaymentConfirmInfoMessage) httpResponsedMessage;
            PaymentConfirmActivity.this.paymentConfirmInfoData = responsePaymentConfirmInfoMessage.getPaymentConfirmInfoData();
            if (!responsePaymentConfirmInfoMessage.hasError() && PaymentConfirmActivity.this.paymentConfirmInfoData != null) {
                PaymentConfirmActivity paymentConfirmActivity2 = PaymentConfirmActivity.this;
                paymentConfirmActivity2.scoresEnough = paymentConfirmActivity2.caculateScoresEnough(paymentConfirmActivity2.paymentConfirmInfoData);
                PaymentConfirmActivity.this.mPaymentConfirmView.f(PaymentConfirmActivity.this.paymentConfirmInfoData, PaymentConfirmActivity.this.scoresEnough);
                PaymentConfirmActivity paymentConfirmActivity3 = PaymentConfirmActivity.this;
                paymentConfirmActivity3.handleSkip(paymentConfirmActivity3.paymentConfirmInfoData, PaymentConfirmActivity.this.scoresEnough);
            } else if (responsePaymentConfirmInfoMessage.getError() == 1) {
                Intent intent = new Intent();
                intent.putExtra(DealIntentService.KEY_CLASS, 32);
                intent.putExtra(PaymentConfirmActivityConfig.REQUEST_PARAMS, PaymentConfirmActivity.this.mRequestData);
                intent.putExtra(MemberPayStatistic.REFER_PAGE, PaymentConfirmActivity.this.mReferPage);
                intent.putExtra(MemberPayStatistic.CLICK_ZONE, PaymentConfirmActivity.this.mClickZone);
                TbadkCoreApplication.setIntent(intent);
                ReloginManager.g().f(null);
                PaymentConfirmActivity.this.closeActivity();
            } else {
                String errorString = responsePaymentConfirmInfoMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = PaymentConfirmActivity.this.getResources().getString(R.string.neterror);
                }
                PaymentConfirmActivity.this.showToast(errorString);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends HttpMessageListener {
        public i(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PayResultData.UnusualInfo describe;
            PayVcodeInfoData vcode;
            String string;
            PaymentConfirmActivity.this.closeLoadingDialog();
            PaymentConfirmActivity.this.mPaymentConfirmView.h(true);
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof ResponsePaymentPayMessage)) {
                return;
            }
            ResponsePaymentPayMessage responsePaymentPayMessage = (ResponsePaymentPayMessage) httpResponsedMessage;
            if (!responsePaymentPayMessage.hasError()) {
                int error = responsePaymentPayMessage.getError();
                if (error == 0) {
                    d.a.o0.d2.d.a("c10294");
                    PayResultData payRequestDataData = responsePaymentPayMessage.getPayRequestDataData();
                    if (payRequestDataData != null && payRequestDataData.getDescribe() != null && payRequestDataData.getDescribe().getWord() != null) {
                        string = payRequestDataData.getDescribe().getWord();
                    } else {
                        string = PaymentConfirmActivity.this.getString(R.string.exchange_success);
                    }
                    new d.a.n0.r.f0.c().c(string);
                    if (!TextUtils.isEmpty(PaymentConfirmActivity.this.mBookId)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001419));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001420, PaymentConfirmActivity.this.mBookId));
                    }
                    if (PaymentConfirmActivity.this.mRequestData != null) {
                        PaymentConfirmActivity paymentConfirmActivity = PaymentConfirmActivity.this;
                        paymentConfirmActivity.sendSuccessMessage(paymentConfirmActivity.mRequestData.getOrder_id());
                    }
                    PaymentConfirmActivity.this.closeActivity();
                    return;
                } else if (error == 2270018) {
                    PayResultData payRequestDataData2 = responsePaymentPayMessage.getPayRequestDataData();
                    if (payRequestDataData2 != null) {
                        PaymentConfirmActivity.this.showPasswordInputDialog(5, payRequestDataData2.getPubkey());
                        return;
                    }
                    return;
                } else if (error == 2150040) {
                    PayResultData payRequestDataData3 = responsePaymentPayMessage.getPayRequestDataData();
                    if (payRequestDataData3 == null || (vcode = payRequestDataData3.getVcode()) == null) {
                        return;
                    }
                    PaymentConfirmActivity.this.goToVcodeActivity(vcode);
                    return;
                } else if (error == 2) {
                    PayResultData payRequestDataData4 = responsePaymentPayMessage.getPayRequestDataData();
                    if (payRequestDataData4 != null) {
                        PaymentConfirmActivity.this.showPasswordInputDialog(5 - payRequestDataData4.getWrongtime(), payRequestDataData4.getPubkey());
                        return;
                    }
                    return;
                } else if (error == 2190005) {
                    PaymentConfirmActivity.this.mPasswordFreeze = true;
                    PaymentConfirmActivity.this.showPasswordInputDialog(0, null);
                    return;
                } else if (error == 2270066 || error == 2270040 || error == 2270041 || error == 2270042) {
                    PaymentConfirmActivity.this.showUEGDialog(error);
                    return;
                } else {
                    PayResultData payRequestDataData5 = responsePaymentPayMessage.getPayRequestDataData();
                    if (payRequestDataData5 != null && (describe = payRequestDataData5.getDescribe()) != null) {
                        String word = describe.getWord();
                        String url = describe.getUrl();
                        if (!StringUtils.isNull(word) && !StringUtils.isNull(url)) {
                            PaymentConfirmActivity.this.showOtherErrorDialog(word, url);
                            return;
                        }
                    }
                    d.a.n0.r.f0.c cVar = new d.a.n0.r.f0.c();
                    String errorString = responsePaymentPayMessage.getErrorString();
                    if (StringUtils.isNull(errorString)) {
                        errorString = PaymentConfirmActivity.this.getResources().getString(R.string.plugin_pay_error);
                    }
                    cVar.b(errorString);
                    return;
                }
            }
            PaymentConfirmActivity.this.showToast(R.string.neterror);
        }
    }

    /* loaded from: classes5.dex */
    public class j extends CustomMessageListener {
        public j(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (!StringUtils.isNull(str)) {
                PaymentConfirmActivity.this.goToPayment(null, null, null, null, str, false);
            } else {
                PaymentConfirmActivity.this.goToPayment(null, null, null, null, null, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public k(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.o0.e3.h0.g)) {
                return;
            }
            PaymentConfirmActivity.this.mNeedTbean -= d.a.c.e.m.b.d(((d.a.o0.e3.h0.g) customResponsedMessage.getData()).a(), 0);
            if (PaymentConfirmActivity.this.mNeedTbean <= 0) {
                PaymentConfirmActivity.this.scoresEnough = true;
                PaymentConfirmInfoData.GoodsInfo goods_info = PaymentConfirmActivity.this.paymentConfirmInfoData.getGoods_info();
                if (goods_info != null) {
                    PaymentConfirmActivity.this.mPaymentConfirmView.x(goods_info.getTdou_num(), goods_info.getCurrency());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements a.e {
        public l() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class m implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f18953e;

        public m(String str) {
            this.f18953e = str;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
            String l = PaymentConfirmActivity.this.mPaymentConfirmView.l();
            if (StringUtils.isNull(l)) {
                return;
            }
            PaymentConfirmActivity.this.goToPayment(this.f18953e, l, null, null, null, false);
        }
    }

    /* loaded from: classes5.dex */
    public class n implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.a f18955e;

        public n(d.a.n0.r.s.a aVar) {
            this.f18955e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.f18955e.setYesBtnClickable(!StringUtils.isNull(editable.toString()));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean caculateScoresEnough(PaymentConfirmInfoData paymentConfirmInfoData) {
        PaymentConfirmInfoData.UserInfo.UserScores parr_scores;
        PaymentConfirmInfoData.UserInfo user_info = paymentConfirmInfoData.getUser_info();
        PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
        if (user_info != null && goods_info != null && (parr_scores = user_info.getParr_scores()) != null) {
            long scores_total = parr_scores.getScores_total();
            long tdou_num = goods_info.getTdou_num();
            if (scores_total - tdou_num >= 0) {
                return true;
            }
            this.mNeedTbean = tdou_num - scores_total;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String generateSharedPkey(String str) {
        return str + this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToBuyTdouActivity() {
        CurrencyJumpHelper.gotoBuyTBeanPage(getPageContext().getPageActivity(), (float) this.mNeedTbean, this.mReferPage, this.mClickZone);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToPayment(String str, String str2, String str3, String str4, String str5, boolean z) {
        PaymentConfirmInfoData.OrderInfo order_info;
        PaymentConfirmInfoData paymentConfirmInfoData = this.paymentConfirmInfoData;
        if (paymentConfirmInfoData == null || (order_info = paymentConfirmInfoData.getOrder_info()) == null) {
            return;
        }
        showLoadingDialog(getResources().getString(R.string.payment_confirm_pay_loading));
        this.mPaymentConfirmView.h(false);
        PayRequestData payRequestData = new PayRequestData();
        payRequestData.setOrderId(order_info.getOrder_id());
        payRequestData.setSceneId(order_info.getScene_id());
        payRequestData.setOpenId(order_info.getOpen_id());
        payRequestData.setTbs(this.paymentConfirmInfoData.getTbs());
        if (!StringUtils.isNull(str2)) {
            payRequestData.setPassword(URLEncoder.encode(d.a.o0.d2.e.a.a(str2, str)));
        }
        if (!StringUtils.isNull(str3)) {
            payRequestData.setCaptchaVcodeStr(str3);
        }
        if (!StringUtils.isNull(str4)) {
            payRequestData.setCaptchaInputStr(str4);
        }
        if (!StringUtils.isNull(str5)) {
            payRequestData.setBindId(str5);
        }
        if (z) {
            payRequestData.setMobileCheck("1");
        }
        this.mPaymentConfirmModel.w(payRequestData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToUEGValidate(int i2, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), str, TbConfig.WEB_URL_TDOU_UEG + i2, true, true, true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToVcodeActivity(PayVcodeInfoData payVcodeInfoData) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PayVcodeActivityConfig(getPageContext().getPageActivity(), payVcodeInfoData.getCaptcha_vcode_str(), payVcodeInfoData.getVcode_pic_url(), 230017)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleSkip(PaymentConfirmInfoData paymentConfirmInfoData, boolean z) {
        PaymentConfirmInfoData.OrderInfo order_info;
        PaymentConfirmInfoData.OrderInfo.Cpath cpath;
        if (paymentConfirmInfoData != null && (order_info = paymentConfirmInfoData.getOrder_info()) != null && (cpath = order_info.getCpath()) != null) {
            if (z) {
                if (cpath.getPay_cashier() == 1) {
                    goToPayment();
                    return true;
                }
            } else if (cpath.getGettdou_cashier() == 1) {
                goToBuyTdouActivity();
                return true;
            }
            if (cpath.getTip_exist() == 1 && !d.a.n0.r.d0.b.j().g(generateSharedPkey("payment_confirm_show"), true)) {
                int k2 = d.a.n0.r.d0.b.j().k(generateSharedPkey("payment_confirm_notshow_count"), 0);
                if (k2 < cpath.getTip_days()) {
                    d.a.n0.r.d0.b.j().v(generateSharedPkey("payment_confirm_notshow_count"), k2 + 1);
                    if (z) {
                        goToPayment();
                        return true;
                    }
                    goToBuyTdouActivity();
                    return true;
                } else if (k2 != 0) {
                    this.mPaymentConfirmView.m().setChecked(false);
                }
            }
        }
        return false;
    }

    private void initData() {
        try {
            Intent intent = getIntent();
            this.mRequestData = (PaymentConfirmRequestData) intent.getSerializableExtra(PaymentConfirmActivityConfig.REQUEST_PARAMS);
            this.mBookType = intent.getIntExtra("book_type", -1);
            this.mBookId = intent.getStringExtra("book_id");
            this.mReferPage = getIntent().getStringExtra(MemberPayStatistic.REFER_PAGE);
            this.mClickZone = getIntent().getStringExtra(MemberPayStatistic.CLICK_ZONE);
            this.currency = this.mRequestData.getCurrency();
        } catch (Exception e2) {
            e2.printStackTrace();
            closeActivity();
        }
        this.mPaymentConfirmModel = new PaymentConfirmModel<>(getPageContext());
    }

    private void initUI() {
        this.mPaymentConfirmView = new d.a.o0.d2.c(this, this.mBookType == 2, this.currency);
        this.mPaymentConfirmView.m().setChecked(!d.a.n0.r.d0.b.j().g(generateSharedPkey("payment_confirm_show"), true));
        this.mPaymentConfirmView.m().setOnCheckedChangeListener(new f());
        this.mPaymentConfirmView.q().setOnClickListener(new g());
    }

    private void loadPaymentConfirmData() {
        if (d.a.c.e.p.l.D()) {
            showLoadingView(this.mPaymentConfirmView.k(), false);
            this.mPaymentConfirmModel.z(this.mRequestData);
            return;
        }
        showNetRefreshViewNoClick(this.mPaymentConfirmView.k(), getResources().getString(R.string.neterror));
    }

    private void register() {
        this.mPaymentConfirmModel.x();
        this.mPaymentConfirmModel.y();
        registerListener(this.mRequestPaymentConfirmInfoListener);
        this.mPayListener.setSelfListener(true);
        registerListener(this.mPayListener);
        registerListener(this.mBindPhoneListener);
        registerListener(this.mBuyTbeanListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSuccessMessage(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001367, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOtherErrorDialog(String str, String str2) {
        new d.a.n0.r.s.a(getPageContext().getPageActivity()).setMessage(str).setNegativeButton(R.string.cancel, new e()).setPositiveButton(R.string.payment_dilaog_error_button, new d(str2)).create(getPageContext()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPasswordInputDialog(int i2, String str) {
        ViewGroup p = this.mPaymentConfirmView.p();
        this.mPaymentConfirmView.u();
        this.mPaymentConfirmView.w(i2);
        this.mPaymentConfirmView.e();
        d.a.n0.r.s.a create = new d.a.n0.r.s.a(getPageContext().getPageActivity()).setContentView(p).setPositiveButton(R.string.push_commit, new m(str)).setNegativeButton(R.string.cancel, new l()).create(getPageContext());
        if (i2 <= 0) {
            create.setYesBtnClickable(false);
            this.mPaymentConfirmView.g(false);
        } else {
            create.setYesBtnClickable(true);
            this.mPaymentConfirmView.g(true);
        }
        if (this.mPaymentConfirmView.n() != null) {
            if (StringUtils.isNull(this.mPaymentConfirmView.l())) {
                create.setYesBtnClickable(false);
            }
            this.mPaymentConfirmView.n().addTextChangedListener(new n(create));
        }
        if (this.mPaymentConfirmView.o() != null) {
            this.mPaymentConfirmView.o().setOnClickListener(new a());
        }
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUEGDialog(int i2) {
        String string;
        String str;
        String string2;
        String str2;
        String string3;
        String string4;
        String str3 = "";
        if (i2 != 2270066) {
            switch (i2) {
                case 2270040:
                    if (CurrencySwitchUtil.isYyIsConvert(this.currency)) {
                        string3 = getResources().getString(R.string.payment_ybean_dilaog_error_recommend_bunding_phone);
                    } else {
                        string3 = getResources().getString(R.string.payment_dilaog_error_recommend_bunding_phone);
                    }
                    str = string3;
                    string2 = getResources().getString(R.string.bunding_phone);
                    break;
                case 2270041:
                    if (CurrencySwitchUtil.isYyIsConvert(this.currency)) {
                        string4 = getResources().getString(R.string.payment_ybean_dilaog_error_bunding_phone);
                    } else {
                        string4 = getResources().getString(R.string.payment_dilaog_error_bunding_phone);
                    }
                    str = string4;
                    string2 = getResources().getString(R.string.bunding_phone);
                    break;
                case 2270042:
                    str = getResources().getString(R.string.payment_dilaog_error_message_validate);
                    string2 = getResources().getString(R.string.msg_validate);
                    break;
                default:
                    str2 = "";
                    break;
            }
            new d.a.n0.r.s.a(getPageContext().getPageActivity()).setMessage(str2).setNegativeButton(R.string.cancel, new c()).setPositiveButton(str3, new b(i2, str3)).create(getPageContext()).show();
        }
        if (CurrencySwitchUtil.isYyIsConvert(this.currency)) {
            string = getResources().getString(R.string.payment_ybean_dilaog_error_bunding_password);
        } else {
            string = getResources().getString(R.string.payment_dilaog_error_bunding_password);
        }
        str = string;
        string2 = getResources().getString(R.string.setup_password);
        String str4 = str;
        str3 = string2;
        str2 = str4;
        new d.a.n0.r.s.a(getPageContext().getPageActivity()).setMessage(str2).setNegativeButton(R.string.cancel, new c()).setPositiveButton(str3, new b(i2, str3)).create(getPageContext()).show();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 230017 && intent != null) {
            goToPayment(null, null, intent.getStringExtra(PayVcodeActivityConfig.VCODE_MD5), intent.getStringExtra(PayVcodeActivityConfig.VCODE_RESULT), null, false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mPaymentConfirmView.onChangeSkinType(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        initUI();
        register();
        loadPaymentConfirmData();
        d.a.o0.d2.d.a("c10291");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToPayment() {
        goToPayment(null, null, null, null, null, false);
    }
}
