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
    public static final String f25676f = "a";

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<BaseActivity> f25677a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC0267b f25678b;

    /* renamed from: d  reason: collision with root package name */
    public PayRequest f25680d;

    /* renamed from: g  reason: collision with root package name */
    public IPayResultDataAdapter f25682g;

    /* renamed from: c  reason: collision with root package name */
    public int f25679c = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25681e = true;

    public a(b.InterfaceC0267b interfaceC0267b, BaseActivity baseActivity, Bundle bundle) {
        PayRequest payRequest;
        this.f25677a = new WeakReference<>(baseActivity);
        this.f25678b = interfaceC0267b;
        d(bundle);
        if (this.f25679c == 1 && (payRequest = this.f25680d) != null) {
            IPayResultDataAdapter a2 = com.baidu.wallet.paysdk.payresult.adapters.a.a(baseActivity, payRequest.getPayFrom());
            this.f25682g = a2;
            if (a2 == null) {
                this.f25682g = com.baidu.wallet.paysdk.payresult.adapters.a.a(this.f25677a.get(), this.f25679c);
                return;
            }
            return;
        }
        this.f25682g = com.baidu.wallet.paysdk.payresult.adapters.a.a(this.f25677a.get(), this.f25679c);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean b() {
        return this.f25682g.isBelongPaySdk();
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void c() {
        IPayResultDataAdapter iPayResultDataAdapter = this.f25682g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.clearDataOnDestroy();
        }
    }

    public void d() {
        this.f25678b.showExpectedTime(this.f25682g.getExpectedTime());
    }

    public void e() {
        PayResultContent payResultContent = this.f25682g.getPayResultContent();
        if (payResultContent != null) {
            this.f25678b.setTitleLogo(payResultContent.title_url);
            this.f25678b.showPayResultRealMoneyText(payResultContent.cash_amount);
            this.f25678b.showTotalAmountInfo(payResultContent.total_amount, payResultContent.order_prefix, payResultContent.cash_amount);
            this.f25678b.showDiscountTypeInfo(payResultContent.discount_info, payResultContent.discount_amount, payResultContent.discount_prefix);
            this.f25678b.showPayTypeInfo(payResultContent.paytype_info, payResultContent.discount_amount, payResultContent.cash_amount, payResultContent.total_amount);
            return;
        }
        this.f25678b.showPayResultMoneyLayoutVisible(false);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public ArrayList<String> f() {
        IPayResultDataAdapter iPayResultDataAdapter = this.f25682g;
        if (iPayResultDataAdapter == null) {
            return new ArrayList<>();
        }
        return iPayResultDataAdapter.getEventValue();
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void g() {
        IPayResultDataAdapter iPayResultDataAdapter = this.f25682g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.handleOKBtnOnclick();
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void h() {
        PayResultContent.CrossMarket crossMarket;
        IPayResultDataAdapter iPayResultDataAdapter = this.f25682g;
        if (iPayResultDataAdapter == null) {
            return;
        }
        if (iPayResultDataAdapter.getPayResultContent() != null) {
            this.f25678b.showAuthDialog(this.f25682g.getPayResultContent().compliance);
        }
        IPayResultDataAdapter iPayResultDataAdapter2 = this.f25682g;
        if (iPayResultDataAdapter2 == null || iPayResultDataAdapter2.getPayResultContent() == null || (crossMarket = this.f25682g.getPayResultContent().cross_market) == null || TextUtils.isEmpty(crossMarket.jump_url)) {
            return;
        }
        this.f25678b.showMarketDialog(crossMarket.pic_url, crossMarket.jump_url);
    }

    public void i() {
        PayResultContent payResultContent = this.f25682g.getPayResultContent();
        if (this.f25682g.isPaySuccess()) {
            this.f25678b.showPaySuccess(a(this.f25682g.getPaySuccessContents(), payResultContent));
        } else {
            this.f25678b.showPaying(a(this.f25682g.getPayingContents(), payResultContent));
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean j() {
        PayResultContent payResultContent;
        IPayResultDataAdapter iPayResultDataAdapter = this.f25682g;
        if (iPayResultDataAdapter == null || (payResultContent = iPayResultDataAdapter.getPayResultContent()) == null || payResultContent.feedback_info == null || !this.f25681e) {
            return false;
        }
        this.f25681e = false;
        return true;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public FeedbackDialog.a k() {
        FeedbackDialog.a aVar = new FeedbackDialog.a();
        IPayResultDataAdapter iPayResultDataAdapter = this.f25682g;
        if (iPayResultDataAdapter != null && iPayResultDataAdapter.getPayResultContent() != null) {
            aVar.f26386a = this.f25682g.getPayResultContent().feedback_info;
            aVar.f26387b = new FeedbackDialog.b() { // from class: com.baidu.wallet.paysdk.payresult.presenter.a.1
                @Override // com.baidu.wallet.paysdk.ui.widget.FeedbackDialog.b
                public void a(FeedbackDialog.c cVar) {
                    ab abVar = (ab) PayBeanFactory.getInstance().getBean((Context) a.this.f25677a.get(), PayBeanFactory.BEAN_ID_SAVE_FEEDBACK, a.f25676f);
                    abVar.a(a.this.f25682g.getPayResultContent().trans_no, cVar);
                    abVar.execBean();
                    a.this.f25678b.finishPage();
                    a.this.g();
                }

                @Override // com.baidu.wallet.paysdk.ui.widget.FeedbackDialog.b
                public void a() {
                    a.this.f25678b.finishPage();
                    a.this.g();
                }
            };
        }
        return aVar;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean a() {
        return this.f25682g != null;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void b(Bundle bundle) {
        bundle.putSerializable(BeanConstants.KEY_PAY_RESULT_TYPE, Integer.valueOf(this.f25679c));
        PayRequest payRequest = this.f25680d;
        if (payRequest != null) {
            bundle.putSerializable("mPayRequest", payRequest);
        }
        IPayResultDataAdapter iPayResultDataAdapter = this.f25682g;
        if (iPayResultDataAdapter != null) {
            iPayResultDataAdapter.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean a(Bundle bundle) {
        return this.f25682g.onCreateCheckInvalide(bundle);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean c(Bundle bundle) {
        String actionBarTextId = this.f25682g.getActionBarTextId();
        if (TextUtils.isEmpty(actionBarTextId)) {
            actionBarTextId = "bd_wallet_payresult_title";
        }
        this.f25678b.initActionBar(actionBarTextId);
        this.f25678b.initViewElements();
        i();
        e();
        d();
        this.f25678b.showAuthorizeMsg(this.f25682g.getAuthorizeMsg());
        if (this.f25682g.isShowLBSPayText()) {
            b.InterfaceC0267b interfaceC0267b = this.f25678b;
            interfaceC0267b.setOKBtnText(ResUtils.getString(this.f25677a.get(), "ebpay_confirm_ret_msg") + this.f25682g.getLBSPayText());
        }
        if (this.f25682g.showResultPage()) {
            return true;
        }
        g();
        this.f25678b.finishPage();
        return false;
    }

    public void d(Bundle bundle) {
        PayResultContent payResultContent;
        if (bundle != null) {
            this.f25679c = bundle.getInt(BeanConstants.KEY_PAY_RESULT_TYPE);
            this.f25680d = (PayRequest) bundle.getSerializable("mPayRequest");
        } else if (this.f25677a.get().getIntent() == null || this.f25677a.get().getIntent().getExtras() == null) {
        } else {
            int i = this.f25677a.get().getIntent().getExtras().getInt(BeanConstants.KEY_PAY_RESULT_TYPE);
            this.f25679c = i;
            if (i == 5 && (payResultContent = (PayResultContent) this.f25677a.get().getIntent().getExtras().get(BeanConstants.KEY_PAY_RESULT_HCE_DATA)) != null) {
                PayDataCache.getInstance().setPayReslutContent(payResultContent);
                PayRequestCache.getInstance().addBeanRequestToCache(BeanConstants.REQUEST_ID_PAY, new PayRequest());
            }
            this.f25680d = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        }
    }

    private HashMap a(HashMap hashMap, PayResultContent payResultContent) {
        if (hashMap != null && payResultContent != null) {
            hashMap.put("update_phone_desc", payResultContent.subtitle_msg);
        }
        return hashMap;
    }
}
