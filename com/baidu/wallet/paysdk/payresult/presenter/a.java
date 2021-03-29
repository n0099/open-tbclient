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
    public static final String f25677f = "a";

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<BaseActivity> f25678a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC0268b f25679b;

    /* renamed from: d  reason: collision with root package name */
    public PayRequest f25681d;

    /* renamed from: g  reason: collision with root package name */
    public IPayResultDataAdapter f25683g;

    /* renamed from: c  reason: collision with root package name */
    public int f25680c = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25682e = true;

    public a(b.InterfaceC0268b interfaceC0268b, BaseActivity baseActivity, Bundle bundle) {
        PayRequest payRequest;
        this.f25678a = new WeakReference<>(baseActivity);
        this.f25679b = interfaceC0268b;
        d(bundle);
        if (this.f25680c == 1 && (payRequest = this.f25681d) != null) {
            IPayResultDataAdapter a2 = com.baidu.wallet.paysdk.payresult.adapters.a.a(baseActivity, payRequest.getPayFrom());
            this.f25683g = a2;
            if (a2 == null) {
                this.f25683g = com.baidu.wallet.paysdk.payresult.adapters.a.a(this.f25678a.get(), this.f25680c);
                return;
            }
            return;
        }
        this.f25683g = com.baidu.wallet.paysdk.payresult.adapters.a.a(this.f25678a.get(), this.f25680c);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean b() {
        return this.f25683g.isBelongPaySdk();
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void c() {
        IPayResultDataAdapter iPayResultDataAdapter = this.f25683g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.clearDataOnDestroy();
        }
    }

    public void d() {
        this.f25679b.showExpectedTime(this.f25683g.getExpectedTime());
    }

    public void e() {
        PayResultContent payResultContent = this.f25683g.getPayResultContent();
        if (payResultContent != null) {
            this.f25679b.setTitleLogo(payResultContent.title_url);
            this.f25679b.showPayResultRealMoneyText(payResultContent.cash_amount);
            this.f25679b.showTotalAmountInfo(payResultContent.total_amount, payResultContent.order_prefix, payResultContent.cash_amount);
            this.f25679b.showDiscountTypeInfo(payResultContent.discount_info, payResultContent.discount_amount, payResultContent.discount_prefix);
            this.f25679b.showPayTypeInfo(payResultContent.paytype_info, payResultContent.discount_amount, payResultContent.cash_amount, payResultContent.total_amount);
            return;
        }
        this.f25679b.showPayResultMoneyLayoutVisible(false);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public ArrayList<String> f() {
        IPayResultDataAdapter iPayResultDataAdapter = this.f25683g;
        if (iPayResultDataAdapter == null) {
            return new ArrayList<>();
        }
        return iPayResultDataAdapter.getEventValue();
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void g() {
        IPayResultDataAdapter iPayResultDataAdapter = this.f25683g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.handleOKBtnOnclick();
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void h() {
        PayResultContent.CrossMarket crossMarket;
        IPayResultDataAdapter iPayResultDataAdapter = this.f25683g;
        if (iPayResultDataAdapter == null) {
            return;
        }
        if (iPayResultDataAdapter.getPayResultContent() != null) {
            this.f25679b.showAuthDialog(this.f25683g.getPayResultContent().compliance);
        }
        IPayResultDataAdapter iPayResultDataAdapter2 = this.f25683g;
        if (iPayResultDataAdapter2 == null || iPayResultDataAdapter2.getPayResultContent() == null || (crossMarket = this.f25683g.getPayResultContent().cross_market) == null || TextUtils.isEmpty(crossMarket.jump_url)) {
            return;
        }
        this.f25679b.showMarketDialog(crossMarket.pic_url, crossMarket.jump_url);
    }

    public void i() {
        PayResultContent payResultContent = this.f25683g.getPayResultContent();
        if (this.f25683g.isPaySuccess()) {
            this.f25679b.showPaySuccess(a(this.f25683g.getPaySuccessContents(), payResultContent));
        } else {
            this.f25679b.showPaying(a(this.f25683g.getPayingContents(), payResultContent));
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean j() {
        PayResultContent payResultContent;
        IPayResultDataAdapter iPayResultDataAdapter = this.f25683g;
        if (iPayResultDataAdapter == null || (payResultContent = iPayResultDataAdapter.getPayResultContent()) == null || payResultContent.feedback_info == null || !this.f25682e) {
            return false;
        }
        this.f25682e = false;
        return true;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public FeedbackDialog.a k() {
        FeedbackDialog.a aVar = new FeedbackDialog.a();
        IPayResultDataAdapter iPayResultDataAdapter = this.f25683g;
        if (iPayResultDataAdapter != null && iPayResultDataAdapter.getPayResultContent() != null) {
            aVar.f26387a = this.f25683g.getPayResultContent().feedback_info;
            aVar.f26388b = new FeedbackDialog.b() { // from class: com.baidu.wallet.paysdk.payresult.presenter.a.1
                @Override // com.baidu.wallet.paysdk.ui.widget.FeedbackDialog.b
                public void a(FeedbackDialog.c cVar) {
                    ab abVar = (ab) PayBeanFactory.getInstance().getBean((Context) a.this.f25678a.get(), PayBeanFactory.BEAN_ID_SAVE_FEEDBACK, a.f25677f);
                    abVar.a(a.this.f25683g.getPayResultContent().trans_no, cVar);
                    abVar.execBean();
                    a.this.f25679b.finishPage();
                    a.this.g();
                }

                @Override // com.baidu.wallet.paysdk.ui.widget.FeedbackDialog.b
                public void a() {
                    a.this.f25679b.finishPage();
                    a.this.g();
                }
            };
        }
        return aVar;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean a() {
        return this.f25683g != null;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void b(Bundle bundle) {
        bundle.putSerializable(BeanConstants.KEY_PAY_RESULT_TYPE, Integer.valueOf(this.f25680c));
        PayRequest payRequest = this.f25681d;
        if (payRequest != null) {
            bundle.putSerializable("mPayRequest", payRequest);
        }
        IPayResultDataAdapter iPayResultDataAdapter = this.f25683g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean a(Bundle bundle) {
        return this.f25683g.onCreateCheckInvalide(bundle);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean c(Bundle bundle) {
        String actionBarTextId = this.f25683g.getActionBarTextId();
        if (TextUtils.isEmpty(actionBarTextId)) {
            actionBarTextId = "bd_wallet_payresult_title";
        }
        this.f25679b.initActionBar(actionBarTextId);
        this.f25679b.initViewElements();
        i();
        e();
        d();
        this.f25679b.showAuthorizeMsg(this.f25683g.getAuthorizeMsg());
        if (this.f25683g.isShowLBSPayText()) {
            b.InterfaceC0268b interfaceC0268b = this.f25679b;
            interfaceC0268b.setOKBtnText(ResUtils.getString(this.f25678a.get(), "ebpay_confirm_ret_msg") + this.f25683g.getLBSPayText());
        }
        if (this.f25683g.showResultPage()) {
            return true;
        }
        g();
        this.f25679b.finishPage();
        return false;
    }

    public void d(Bundle bundle) {
        PayResultContent payResultContent;
        if (bundle != null) {
            this.f25680c = bundle.getInt(BeanConstants.KEY_PAY_RESULT_TYPE);
            this.f25681d = (PayRequest) bundle.getSerializable("mPayRequest");
        } else if (this.f25678a.get().getIntent() == null || this.f25678a.get().getIntent().getExtras() == null) {
        } else {
            int i = this.f25678a.get().getIntent().getExtras().getInt(BeanConstants.KEY_PAY_RESULT_TYPE);
            this.f25680c = i;
            if (i == 5 && (payResultContent = (PayResultContent) this.f25678a.get().getIntent().getExtras().get(BeanConstants.KEY_PAY_RESULT_HCE_DATA)) != null) {
                PayDataCache.getInstance().setPayReslutContent(payResultContent);
                PayRequestCache.getInstance().addBeanRequestToCache(BeanConstants.REQUEST_ID_PAY, new PayRequest());
            }
            this.f25681d = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        }
    }

    private HashMap a(HashMap hashMap, PayResultContent payResultContent) {
        if (hashMap != null && payResultContent != null) {
            hashMap.put("update_phone_desc", payResultContent.subtitle_msg);
        }
        return hashMap;
    }
}
