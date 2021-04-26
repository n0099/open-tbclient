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
    public static final String f26143f = "a";

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<BaseActivity> f26144a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC0267b f26145b;

    /* renamed from: d  reason: collision with root package name */
    public PayRequest f26147d;

    /* renamed from: g  reason: collision with root package name */
    public IPayResultDataAdapter f26149g;

    /* renamed from: c  reason: collision with root package name */
    public int f26146c = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26148e = true;

    public a(b.InterfaceC0267b interfaceC0267b, BaseActivity baseActivity, Bundle bundle) {
        PayRequest payRequest;
        this.f26144a = new WeakReference<>(baseActivity);
        this.f26145b = interfaceC0267b;
        d(bundle);
        if (this.f26146c == 1 && (payRequest = this.f26147d) != null) {
            IPayResultDataAdapter a2 = com.baidu.wallet.paysdk.payresult.adapters.a.a(baseActivity, payRequest.getPayFrom());
            this.f26149g = a2;
            if (a2 == null) {
                this.f26149g = com.baidu.wallet.paysdk.payresult.adapters.a.a(this.f26144a.get(), this.f26146c);
                return;
            }
            return;
        }
        this.f26149g = com.baidu.wallet.paysdk.payresult.adapters.a.a(this.f26144a.get(), this.f26146c);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean b() {
        return this.f26149g.isBelongPaySdk();
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void c() {
        IPayResultDataAdapter iPayResultDataAdapter = this.f26149g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.clearDataOnDestroy();
        }
    }

    public void d() {
        this.f26145b.showExpectedTime(this.f26149g.getExpectedTime());
    }

    public void e() {
        PayResultContent payResultContent = this.f26149g.getPayResultContent();
        if (payResultContent != null) {
            this.f26145b.setTitleLogo(payResultContent.title_url);
            this.f26145b.showPayResultRealMoneyText(payResultContent.cash_amount);
            this.f26145b.showTotalAmountInfo(payResultContent.total_amount, payResultContent.order_prefix, payResultContent.cash_amount);
            this.f26145b.showDiscountTypeInfo(payResultContent.discount_info, payResultContent.discount_amount, payResultContent.discount_prefix);
            this.f26145b.showPayTypeInfo(payResultContent.paytype_info, payResultContent.discount_amount, payResultContent.cash_amount, payResultContent.total_amount);
            return;
        }
        this.f26145b.showPayResultMoneyLayoutVisible(false);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public ArrayList<String> f() {
        IPayResultDataAdapter iPayResultDataAdapter = this.f26149g;
        if (iPayResultDataAdapter == null) {
            return new ArrayList<>();
        }
        return iPayResultDataAdapter.getEventValue();
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void g() {
        IPayResultDataAdapter iPayResultDataAdapter = this.f26149g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.handleOKBtnOnclick();
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void h() {
        PayResultContent.CrossMarket crossMarket;
        IPayResultDataAdapter iPayResultDataAdapter = this.f26149g;
        if (iPayResultDataAdapter == null) {
            return;
        }
        if (iPayResultDataAdapter.getPayResultContent() != null) {
            this.f26145b.showAuthDialog(this.f26149g.getPayResultContent().compliance);
        }
        IPayResultDataAdapter iPayResultDataAdapter2 = this.f26149g;
        if (iPayResultDataAdapter2 == null || iPayResultDataAdapter2.getPayResultContent() == null || (crossMarket = this.f26149g.getPayResultContent().cross_market) == null || TextUtils.isEmpty(crossMarket.jump_url)) {
            return;
        }
        this.f26145b.showMarketDialog(crossMarket.pic_url, crossMarket.jump_url);
    }

    public void i() {
        PayResultContent payResultContent = this.f26149g.getPayResultContent();
        if (this.f26149g.isPaySuccess()) {
            this.f26145b.showPaySuccess(a(this.f26149g.getPaySuccessContents(), payResultContent));
        } else {
            this.f26145b.showPaying(a(this.f26149g.getPayingContents(), payResultContent));
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean j() {
        PayResultContent payResultContent;
        IPayResultDataAdapter iPayResultDataAdapter = this.f26149g;
        if (iPayResultDataAdapter == null || (payResultContent = iPayResultDataAdapter.getPayResultContent()) == null || payResultContent.feedback_info == null || !this.f26148e) {
            return false;
        }
        this.f26148e = false;
        return true;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public FeedbackDialog.a k() {
        FeedbackDialog.a aVar = new FeedbackDialog.a();
        IPayResultDataAdapter iPayResultDataAdapter = this.f26149g;
        if (iPayResultDataAdapter != null && iPayResultDataAdapter.getPayResultContent() != null) {
            aVar.f26876a = this.f26149g.getPayResultContent().feedback_info;
            aVar.f26877b = new FeedbackDialog.b() { // from class: com.baidu.wallet.paysdk.payresult.presenter.a.1
                @Override // com.baidu.wallet.paysdk.ui.widget.FeedbackDialog.b
                public void a(FeedbackDialog.c cVar) {
                    ab abVar = (ab) PayBeanFactory.getInstance().getBean((Context) a.this.f26144a.get(), PayBeanFactory.BEAN_ID_SAVE_FEEDBACK, a.f26143f);
                    abVar.a(a.this.f26149g.getPayResultContent().trans_no, cVar);
                    abVar.execBean();
                    a.this.f26145b.finishPage();
                    a.this.g();
                }

                @Override // com.baidu.wallet.paysdk.ui.widget.FeedbackDialog.b
                public void a() {
                    a.this.f26145b.finishPage();
                    a.this.g();
                }
            };
        }
        return aVar;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean a() {
        return this.f26149g != null;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void b(Bundle bundle) {
        bundle.putSerializable(BeanConstants.KEY_PAY_RESULT_TYPE, Integer.valueOf(this.f26146c));
        PayRequest payRequest = this.f26147d;
        if (payRequest != null) {
            bundle.putSerializable("mPayRequest", payRequest);
        }
        IPayResultDataAdapter iPayResultDataAdapter = this.f26149g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean a(Bundle bundle) {
        return this.f26149g.onCreateCheckInvalide(bundle);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean c(Bundle bundle) {
        String actionBarTextId = this.f26149g.getActionBarTextId();
        if (TextUtils.isEmpty(actionBarTextId)) {
            actionBarTextId = "bd_wallet_payresult_title";
        }
        this.f26145b.initActionBar(actionBarTextId);
        this.f26145b.initViewElements();
        i();
        e();
        d();
        this.f26145b.showAuthorizeMsg(this.f26149g.getAuthorizeMsg());
        if (this.f26149g.isShowLBSPayText()) {
            b.InterfaceC0267b interfaceC0267b = this.f26145b;
            interfaceC0267b.setOKBtnText(ResUtils.getString(this.f26144a.get(), "ebpay_confirm_ret_msg") + this.f26149g.getLBSPayText());
        }
        if (this.f26149g.showResultPage()) {
            return true;
        }
        g();
        this.f26145b.finishPage();
        return false;
    }

    public void d(Bundle bundle) {
        PayResultContent payResultContent;
        if (bundle != null) {
            this.f26146c = bundle.getInt(BeanConstants.KEY_PAY_RESULT_TYPE);
            this.f26147d = (PayRequest) bundle.getSerializable("mPayRequest");
        } else if (this.f26144a.get().getIntent() == null || this.f26144a.get().getIntent().getExtras() == null) {
        } else {
            int i2 = this.f26144a.get().getIntent().getExtras().getInt(BeanConstants.KEY_PAY_RESULT_TYPE);
            this.f26146c = i2;
            if (i2 == 5 && (payResultContent = (PayResultContent) this.f26144a.get().getIntent().getExtras().get(BeanConstants.KEY_PAY_RESULT_HCE_DATA)) != null) {
                PayDataCache.getInstance().setPayReslutContent(payResultContent);
                PayRequestCache.getInstance().addBeanRequestToCache(BeanConstants.REQUEST_ID_PAY, new PayRequest());
            }
            this.f26147d = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        }
    }

    private HashMap a(HashMap hashMap, PayResultContent payResultContent) {
        if (hashMap != null && payResultContent != null) {
            hashMap.put("update_phone_desc", payResultContent.subtitle_msg);
        }
        return hashMap;
    }
}
