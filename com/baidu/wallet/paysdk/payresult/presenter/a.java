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
    public static final String f25420f = "a";

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<BaseActivity> f25421a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC0257b f25422b;

    /* renamed from: d  reason: collision with root package name */
    public PayRequest f25424d;

    /* renamed from: g  reason: collision with root package name */
    public IPayResultDataAdapter f25426g;

    /* renamed from: c  reason: collision with root package name */
    public int f25423c = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25425e = true;

    public a(b.InterfaceC0257b interfaceC0257b, BaseActivity baseActivity, Bundle bundle) {
        PayRequest payRequest;
        this.f25421a = new WeakReference<>(baseActivity);
        this.f25422b = interfaceC0257b;
        d(bundle);
        if (this.f25423c == 1 && (payRequest = this.f25424d) != null) {
            IPayResultDataAdapter a2 = com.baidu.wallet.paysdk.payresult.adapters.a.a(baseActivity, payRequest.getPayFrom());
            this.f25426g = a2;
            if (a2 == null) {
                this.f25426g = com.baidu.wallet.paysdk.payresult.adapters.a.a(this.f25421a.get(), this.f25423c);
                return;
            }
            return;
        }
        this.f25426g = com.baidu.wallet.paysdk.payresult.adapters.a.a(this.f25421a.get(), this.f25423c);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean b() {
        return this.f25426g.isBelongPaySdk();
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void c() {
        IPayResultDataAdapter iPayResultDataAdapter = this.f25426g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.clearDataOnDestroy();
        }
    }

    public void d() {
        this.f25422b.showExpectedTime(this.f25426g.getExpectedTime());
    }

    public void e() {
        PayResultContent payResultContent = this.f25426g.getPayResultContent();
        if (payResultContent != null) {
            this.f25422b.setTitleLogo(payResultContent.title_url);
            this.f25422b.showPayResultRealMoneyText(payResultContent.cash_amount);
            this.f25422b.showTotalAmountInfo(payResultContent.total_amount, payResultContent.order_prefix, payResultContent.cash_amount);
            this.f25422b.showDiscountTypeInfo(payResultContent.discount_info, payResultContent.discount_amount, payResultContent.discount_prefix);
            this.f25422b.showPayTypeInfo(payResultContent.paytype_info, payResultContent.discount_amount, payResultContent.cash_amount, payResultContent.total_amount);
            return;
        }
        this.f25422b.showPayResultMoneyLayoutVisible(false);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public ArrayList<String> f() {
        IPayResultDataAdapter iPayResultDataAdapter = this.f25426g;
        if (iPayResultDataAdapter == null) {
            return new ArrayList<>();
        }
        return iPayResultDataAdapter.getEventValue();
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void g() {
        IPayResultDataAdapter iPayResultDataAdapter = this.f25426g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.handleOKBtnOnclick();
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void h() {
        PayResultContent.CrossMarket crossMarket;
        IPayResultDataAdapter iPayResultDataAdapter = this.f25426g;
        if (iPayResultDataAdapter == null) {
            return;
        }
        if (iPayResultDataAdapter.getPayResultContent() != null) {
            this.f25422b.showAuthDialog(this.f25426g.getPayResultContent().compliance);
        }
        IPayResultDataAdapter iPayResultDataAdapter2 = this.f25426g;
        if (iPayResultDataAdapter2 == null || iPayResultDataAdapter2.getPayResultContent() == null || (crossMarket = this.f25426g.getPayResultContent().cross_market) == null || TextUtils.isEmpty(crossMarket.jump_url)) {
            return;
        }
        this.f25422b.showMarketDialog(crossMarket.pic_url, crossMarket.jump_url);
    }

    public void i() {
        PayResultContent payResultContent = this.f25426g.getPayResultContent();
        if (this.f25426g.isPaySuccess()) {
            this.f25422b.showPaySuccess(a(this.f25426g.getPaySuccessContents(), payResultContent));
        } else {
            this.f25422b.showPaying(a(this.f25426g.getPayingContents(), payResultContent));
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean j() {
        PayResultContent payResultContent;
        IPayResultDataAdapter iPayResultDataAdapter = this.f25426g;
        if (iPayResultDataAdapter == null || (payResultContent = iPayResultDataAdapter.getPayResultContent()) == null || payResultContent.feedback_info == null || !this.f25425e) {
            return false;
        }
        this.f25425e = false;
        return true;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public FeedbackDialog.a k() {
        FeedbackDialog.a aVar = new FeedbackDialog.a();
        IPayResultDataAdapter iPayResultDataAdapter = this.f25426g;
        if (iPayResultDataAdapter != null && iPayResultDataAdapter.getPayResultContent() != null) {
            aVar.f26153a = this.f25426g.getPayResultContent().feedback_info;
            aVar.f26154b = new FeedbackDialog.b() { // from class: com.baidu.wallet.paysdk.payresult.presenter.a.1
                @Override // com.baidu.wallet.paysdk.ui.widget.FeedbackDialog.b
                public void a(FeedbackDialog.c cVar) {
                    ab abVar = (ab) PayBeanFactory.getInstance().getBean((Context) a.this.f25421a.get(), PayBeanFactory.BEAN_ID_SAVE_FEEDBACK, a.f25420f);
                    abVar.a(a.this.f25426g.getPayResultContent().trans_no, cVar);
                    abVar.execBean();
                    a.this.f25422b.finishPage();
                    a.this.g();
                }

                @Override // com.baidu.wallet.paysdk.ui.widget.FeedbackDialog.b
                public void a() {
                    a.this.f25422b.finishPage();
                    a.this.g();
                }
            };
        }
        return aVar;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean a() {
        return this.f25426g != null;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void b(Bundle bundle) {
        bundle.putSerializable(BeanConstants.KEY_PAY_RESULT_TYPE, Integer.valueOf(this.f25423c));
        PayRequest payRequest = this.f25424d;
        if (payRequest != null) {
            bundle.putSerializable("mPayRequest", payRequest);
        }
        IPayResultDataAdapter iPayResultDataAdapter = this.f25426g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean a(Bundle bundle) {
        return this.f25426g.onCreateCheckInvalide(bundle);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean c(Bundle bundle) {
        String actionBarTextId = this.f25426g.getActionBarTextId();
        if (TextUtils.isEmpty(actionBarTextId)) {
            actionBarTextId = "bd_wallet_payresult_title";
        }
        this.f25422b.initActionBar(actionBarTextId);
        this.f25422b.initViewElements();
        i();
        e();
        d();
        this.f25422b.showAuthorizeMsg(this.f25426g.getAuthorizeMsg());
        if (this.f25426g.isShowLBSPayText()) {
            b.InterfaceC0257b interfaceC0257b = this.f25422b;
            interfaceC0257b.setOKBtnText(ResUtils.getString(this.f25421a.get(), "ebpay_confirm_ret_msg") + this.f25426g.getLBSPayText());
        }
        if (this.f25426g.showResultPage()) {
            return true;
        }
        g();
        this.f25422b.finishPage();
        return false;
    }

    public void d(Bundle bundle) {
        PayResultContent payResultContent;
        if (bundle != null) {
            this.f25423c = bundle.getInt(BeanConstants.KEY_PAY_RESULT_TYPE);
            this.f25424d = (PayRequest) bundle.getSerializable("mPayRequest");
        } else if (this.f25421a.get().getIntent() == null || this.f25421a.get().getIntent().getExtras() == null) {
        } else {
            int i2 = this.f25421a.get().getIntent().getExtras().getInt(BeanConstants.KEY_PAY_RESULT_TYPE);
            this.f25423c = i2;
            if (i2 == 5 && (payResultContent = (PayResultContent) this.f25421a.get().getIntent().getExtras().get(BeanConstants.KEY_PAY_RESULT_HCE_DATA)) != null) {
                PayDataCache.getInstance().setPayReslutContent(payResultContent);
                PayRequestCache.getInstance().addBeanRequestToCache(BeanConstants.REQUEST_ID_PAY, new PayRequest());
            }
            this.f25424d = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        }
    }

    private HashMap a(HashMap hashMap, PayResultContent payResultContent) {
        if (hashMap != null && payResultContent != null) {
            hashMap.put("update_phone_desc", payResultContent.subtitle_msg);
        }
        return hashMap;
    }
}
