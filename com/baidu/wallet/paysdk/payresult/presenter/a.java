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
    public static final String f25317f = "a";

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<BaseActivity> f25318a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC0255b f25319b;

    /* renamed from: d  reason: collision with root package name */
    public PayRequest f25321d;

    /* renamed from: g  reason: collision with root package name */
    public IPayResultDataAdapter f25323g;

    /* renamed from: c  reason: collision with root package name */
    public int f25320c = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25322e = true;

    public a(b.InterfaceC0255b interfaceC0255b, BaseActivity baseActivity, Bundle bundle) {
        PayRequest payRequest;
        this.f25318a = new WeakReference<>(baseActivity);
        this.f25319b = interfaceC0255b;
        d(bundle);
        if (this.f25320c == 1 && (payRequest = this.f25321d) != null) {
            IPayResultDataAdapter a2 = com.baidu.wallet.paysdk.payresult.adapters.a.a(baseActivity, payRequest.getPayFrom());
            this.f25323g = a2;
            if (a2 == null) {
                this.f25323g = com.baidu.wallet.paysdk.payresult.adapters.a.a(this.f25318a.get(), this.f25320c);
                return;
            }
            return;
        }
        this.f25323g = com.baidu.wallet.paysdk.payresult.adapters.a.a(this.f25318a.get(), this.f25320c);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean b() {
        return this.f25323g.isBelongPaySdk();
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void c() {
        IPayResultDataAdapter iPayResultDataAdapter = this.f25323g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.clearDataOnDestroy();
        }
    }

    public void d() {
        this.f25319b.showExpectedTime(this.f25323g.getExpectedTime());
    }

    public void e() {
        PayResultContent payResultContent = this.f25323g.getPayResultContent();
        if (payResultContent != null) {
            this.f25319b.setTitleLogo(payResultContent.title_url);
            this.f25319b.showPayResultRealMoneyText(payResultContent.cash_amount);
            this.f25319b.showTotalAmountInfo(payResultContent.total_amount, payResultContent.order_prefix, payResultContent.cash_amount);
            this.f25319b.showDiscountTypeInfo(payResultContent.discount_info, payResultContent.discount_amount, payResultContent.discount_prefix);
            this.f25319b.showPayTypeInfo(payResultContent.paytype_info, payResultContent.discount_amount, payResultContent.cash_amount, payResultContent.total_amount);
            return;
        }
        this.f25319b.showPayResultMoneyLayoutVisible(false);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public ArrayList<String> f() {
        IPayResultDataAdapter iPayResultDataAdapter = this.f25323g;
        if (iPayResultDataAdapter == null) {
            return new ArrayList<>();
        }
        return iPayResultDataAdapter.getEventValue();
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void g() {
        IPayResultDataAdapter iPayResultDataAdapter = this.f25323g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.handleOKBtnOnclick();
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void h() {
        PayResultContent.CrossMarket crossMarket;
        IPayResultDataAdapter iPayResultDataAdapter = this.f25323g;
        if (iPayResultDataAdapter == null) {
            return;
        }
        if (iPayResultDataAdapter.getPayResultContent() != null) {
            this.f25319b.showAuthDialog(this.f25323g.getPayResultContent().compliance);
        }
        IPayResultDataAdapter iPayResultDataAdapter2 = this.f25323g;
        if (iPayResultDataAdapter2 == null || iPayResultDataAdapter2.getPayResultContent() == null || (crossMarket = this.f25323g.getPayResultContent().cross_market) == null || TextUtils.isEmpty(crossMarket.jump_url)) {
            return;
        }
        this.f25319b.showMarketDialog(crossMarket.pic_url, crossMarket.jump_url);
    }

    public void i() {
        PayResultContent payResultContent = this.f25323g.getPayResultContent();
        if (this.f25323g.isPaySuccess()) {
            this.f25319b.showPaySuccess(a(this.f25323g.getPaySuccessContents(), payResultContent));
        } else {
            this.f25319b.showPaying(a(this.f25323g.getPayingContents(), payResultContent));
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean j() {
        PayResultContent payResultContent;
        IPayResultDataAdapter iPayResultDataAdapter = this.f25323g;
        if (iPayResultDataAdapter == null || (payResultContent = iPayResultDataAdapter.getPayResultContent()) == null || payResultContent.feedback_info == null || !this.f25322e) {
            return false;
        }
        this.f25322e = false;
        return true;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public FeedbackDialog.a k() {
        FeedbackDialog.a aVar = new FeedbackDialog.a();
        IPayResultDataAdapter iPayResultDataAdapter = this.f25323g;
        if (iPayResultDataAdapter != null && iPayResultDataAdapter.getPayResultContent() != null) {
            aVar.f26050a = this.f25323g.getPayResultContent().feedback_info;
            aVar.f26051b = new FeedbackDialog.b() { // from class: com.baidu.wallet.paysdk.payresult.presenter.a.1
                @Override // com.baidu.wallet.paysdk.ui.widget.FeedbackDialog.b
                public void a(FeedbackDialog.c cVar) {
                    ab abVar = (ab) PayBeanFactory.getInstance().getBean((Context) a.this.f25318a.get(), PayBeanFactory.BEAN_ID_SAVE_FEEDBACK, a.f25317f);
                    abVar.a(a.this.f25323g.getPayResultContent().trans_no, cVar);
                    abVar.execBean();
                    a.this.f25319b.finishPage();
                    a.this.g();
                }

                @Override // com.baidu.wallet.paysdk.ui.widget.FeedbackDialog.b
                public void a() {
                    a.this.f25319b.finishPage();
                    a.this.g();
                }
            };
        }
        return aVar;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean a() {
        return this.f25323g != null;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void b(Bundle bundle) {
        bundle.putSerializable(BeanConstants.KEY_PAY_RESULT_TYPE, Integer.valueOf(this.f25320c));
        PayRequest payRequest = this.f25321d;
        if (payRequest != null) {
            bundle.putSerializable("mPayRequest", payRequest);
        }
        IPayResultDataAdapter iPayResultDataAdapter = this.f25323g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean a(Bundle bundle) {
        return this.f25323g.onCreateCheckInvalide(bundle);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean c(Bundle bundle) {
        String actionBarTextId = this.f25323g.getActionBarTextId();
        if (TextUtils.isEmpty(actionBarTextId)) {
            actionBarTextId = "bd_wallet_payresult_title";
        }
        this.f25319b.initActionBar(actionBarTextId);
        this.f25319b.initViewElements();
        i();
        e();
        d();
        this.f25319b.showAuthorizeMsg(this.f25323g.getAuthorizeMsg());
        if (this.f25323g.isShowLBSPayText()) {
            b.InterfaceC0255b interfaceC0255b = this.f25319b;
            interfaceC0255b.setOKBtnText(ResUtils.getString(this.f25318a.get(), "ebpay_confirm_ret_msg") + this.f25323g.getLBSPayText());
        }
        if (this.f25323g.showResultPage()) {
            return true;
        }
        g();
        this.f25319b.finishPage();
        return false;
    }

    public void d(Bundle bundle) {
        PayResultContent payResultContent;
        if (bundle != null) {
            this.f25320c = bundle.getInt(BeanConstants.KEY_PAY_RESULT_TYPE);
            this.f25321d = (PayRequest) bundle.getSerializable("mPayRequest");
        } else if (this.f25318a.get().getIntent() == null || this.f25318a.get().getIntent().getExtras() == null) {
        } else {
            int i2 = this.f25318a.get().getIntent().getExtras().getInt(BeanConstants.KEY_PAY_RESULT_TYPE);
            this.f25320c = i2;
            if (i2 == 5 && (payResultContent = (PayResultContent) this.f25318a.get().getIntent().getExtras().get(BeanConstants.KEY_PAY_RESULT_HCE_DATA)) != null) {
                PayDataCache.getInstance().setPayReslutContent(payResultContent);
                PayRequestCache.getInstance().addBeanRequestToCache(BeanConstants.REQUEST_ID_PAY, new PayRequest());
            }
            this.f25321d = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        }
    }

    private HashMap a(HashMap hashMap, PayResultContent payResultContent) {
        if (hashMap != null && payResultContent != null) {
            hashMap.put("update_phone_desc", payResultContent.subtitle_msg);
        }
        return hashMap;
    }
}
