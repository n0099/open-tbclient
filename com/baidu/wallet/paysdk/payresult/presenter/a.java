package com.baidu.wallet.paysdk.payresult.presenter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.ab;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.payresult.presenter.b;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.FeedbackDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class a implements b.a {

    /* renamed from: f  reason: collision with root package name */
    public static final String f25502f = "a";

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<BaseActivity> f25503a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC0260b f25504b;

    /* renamed from: d  reason: collision with root package name */
    public PayRequest f25506d;

    /* renamed from: g  reason: collision with root package name */
    public IPayResultDataAdapter f25508g;

    /* renamed from: c  reason: collision with root package name */
    public int f25505c = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25507e = true;

    public a(b.InterfaceC0260b interfaceC0260b, BaseActivity baseActivity, Bundle bundle) {
        PayRequest payRequest;
        this.f25503a = new WeakReference<>(baseActivity);
        this.f25504b = interfaceC0260b;
        d(bundle);
        if (this.f25505c == 1 && (payRequest = this.f25506d) != null) {
            IPayResultDataAdapter a2 = com.baidu.wallet.paysdk.payresult.adapters.a.a(baseActivity, payRequest.getPayFrom());
            this.f25508g = a2;
            if (a2 == null) {
                this.f25508g = com.baidu.wallet.paysdk.payresult.adapters.a.a(this.f25503a.get(), this.f25505c);
                return;
            }
            return;
        }
        this.f25508g = com.baidu.wallet.paysdk.payresult.adapters.a.a(this.f25503a.get(), this.f25505c);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean b() {
        return this.f25508g.isBelongPaySdk();
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void c() {
        IPayResultDataAdapter iPayResultDataAdapter = this.f25508g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.clearDataOnDestroy();
        }
    }

    public void d() {
        this.f25504b.showExpectedTime(this.f25508g.getExpectedTime());
    }

    public void e() {
        PayResultContent payResultContent = this.f25508g.getPayResultContent();
        if (payResultContent != null) {
            this.f25504b.setTitleLogo(payResultContent.title_url);
            this.f25504b.showPayResultRealMoneyText(payResultContent.cash_amount);
            this.f25504b.showTotalAmountInfo(payResultContent.total_amount, payResultContent.order_prefix, payResultContent.cash_amount);
            this.f25504b.showDiscountTypeInfo(payResultContent.discount_info, payResultContent.discount_amount, payResultContent.discount_prefix);
            this.f25504b.showPayTypeInfo(payResultContent.paytype_info, payResultContent.discount_amount, payResultContent.cash_amount, payResultContent.total_amount);
            return;
        }
        this.f25504b.showPayResultMoneyLayoutVisible(false);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public ArrayList<String> f() {
        IPayResultDataAdapter iPayResultDataAdapter = this.f25508g;
        if (iPayResultDataAdapter == null) {
            return new ArrayList<>();
        }
        return iPayResultDataAdapter.getEventValue();
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void g() {
        IPayResultDataAdapter iPayResultDataAdapter = this.f25508g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.handleOKBtnOnclick();
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void h() {
        PayResultContent.CrossMarket crossMarket;
        IPayResultDataAdapter iPayResultDataAdapter = this.f25508g;
        if (iPayResultDataAdapter == null) {
            return;
        }
        if (iPayResultDataAdapter.getPayResultContent() != null) {
            this.f25504b.showAuthDialog(this.f25508g.getPayResultContent().compliance);
        }
        IPayResultDataAdapter iPayResultDataAdapter2 = this.f25508g;
        if (iPayResultDataAdapter2 == null || iPayResultDataAdapter2.getPayResultContent() == null || (crossMarket = this.f25508g.getPayResultContent().cross_market) == null || TextUtils.isEmpty(crossMarket.jump_url)) {
            return;
        }
        this.f25504b.showMarketDialog(crossMarket.pic_url, crossMarket.jump_url);
    }

    public void i() {
        PayResultContent payResultContent = this.f25508g.getPayResultContent();
        if (this.f25508g.isPaySuccess()) {
            this.f25504b.showPaySuccess(a(this.f25508g.getPaySuccessContents(), payResultContent));
        } else {
            this.f25504b.showPaying(a(this.f25508g.getPayingContents(), payResultContent));
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean j() {
        PayResultContent payResultContent;
        IPayResultDataAdapter iPayResultDataAdapter = this.f25508g;
        if (iPayResultDataAdapter == null || (payResultContent = iPayResultDataAdapter.getPayResultContent()) == null || payResultContent.feedback_info == null || !this.f25507e) {
            return false;
        }
        this.f25507e = false;
        return true;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public FeedbackDialog.a k() {
        FeedbackDialog.a aVar = new FeedbackDialog.a();
        IPayResultDataAdapter iPayResultDataAdapter = this.f25508g;
        if (iPayResultDataAdapter != null && iPayResultDataAdapter.getPayResultContent() != null) {
            aVar.f26235a = this.f25508g.getPayResultContent().feedback_info;
            aVar.f26236b = new FeedbackDialog.b() { // from class: com.baidu.wallet.paysdk.payresult.presenter.a.1
                @Override // com.baidu.wallet.paysdk.ui.widget.FeedbackDialog.b
                public void a(FeedbackDialog.c cVar) {
                    ab abVar = (ab) PayBeanFactory.getInstance().getBean((Context) a.this.f25503a.get(), PayBeanFactory.BEAN_ID_SAVE_FEEDBACK, a.f25502f);
                    abVar.a(a.this.f25508g.getPayResultContent().trans_no, cVar);
                    abVar.execBean();
                    a.this.f25504b.finishPage();
                    a.this.g();
                }

                @Override // com.baidu.wallet.paysdk.ui.widget.FeedbackDialog.b
                public void a() {
                    a.this.f25504b.finishPage();
                    a.this.g();
                }
            };
        }
        return aVar;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean a() {
        return this.f25508g != null;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void b(Bundle bundle) {
        bundle.putSerializable(BeanConstants.KEY_PAY_RESULT_TYPE, Integer.valueOf(this.f25505c));
        PayRequest payRequest = this.f25506d;
        if (payRequest != null) {
            bundle.putSerializable("mPayRequest", payRequest);
        }
        IPayResultDataAdapter iPayResultDataAdapter = this.f25508g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean a(Bundle bundle) {
        return this.f25508g.onCreateCheckInvalide(bundle);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean c(Bundle bundle) {
        String actionBarTextId = this.f25508g.getActionBarTextId();
        if (TextUtils.isEmpty(actionBarTextId)) {
            actionBarTextId = "bd_wallet_payresult_title";
        }
        this.f25504b.initActionBar(actionBarTextId);
        this.f25504b.initViewElements();
        i();
        e();
        d();
        this.f25504b.showAuthorizeMsg(this.f25508g.getAuthorizeMsg());
        if (this.f25508g.isShowLBSPayText()) {
            b.InterfaceC0260b interfaceC0260b = this.f25504b;
            interfaceC0260b.setOKBtnText(ResUtils.getString(this.f25503a.get(), "ebpay_confirm_ret_msg") + this.f25508g.getLBSPayText());
        }
        if (this.f25508g.showResultPage()) {
            return true;
        }
        g();
        this.f25504b.finishPage();
        return false;
    }

    public void d(Bundle bundle) {
        PayResultContent payResultContent;
        if (bundle != null) {
            this.f25505c = bundle.getInt(BeanConstants.KEY_PAY_RESULT_TYPE);
            this.f25506d = (PayRequest) bundle.getSerializable("mPayRequest");
        } else if (this.f25503a.get().getIntent() == null || this.f25503a.get().getIntent().getExtras() == null) {
        } else {
            int i2 = this.f25503a.get().getIntent().getExtras().getInt(BeanConstants.KEY_PAY_RESULT_TYPE);
            this.f25505c = i2;
            if (i2 == 5 && (payResultContent = (PayResultContent) this.f25503a.get().getIntent().getExtras().get(BeanConstants.KEY_PAY_RESULT_HCE_DATA)) != null) {
                PayDataCache.getInstance().setPayReslutContent(payResultContent);
                PayRequestCache.getInstance().addBeanRequestToCache(BeanConstants.REQUEST_ID_PAY, new PayRequest());
            }
            this.f25506d = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        }
    }

    private HashMap a(HashMap hashMap, PayResultContent payResultContent) {
        if (hashMap != null && payResultContent != null) {
            hashMap.put("update_phone_desc", payResultContent.subtitle_msg);
        }
        return hashMap;
    }
}
