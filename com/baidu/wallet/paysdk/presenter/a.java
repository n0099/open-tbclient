package com.baidu.wallet.paysdk.presenter;

import android.text.TextUtils;
import android.view.View;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.AuthorizeSignActivity;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
/* loaded from: classes5.dex */
public class a implements View.OnClickListener, e {

    /* renamed from: a  reason: collision with root package name */
    public AuthorizeSignActivity f25453a;

    /* renamed from: b  reason: collision with root package name */
    public int f25454b = 1;

    public a(AuthorizeSignActivity authorizeSignActivity) {
        this.f25453a = authorizeSignActivity;
    }

    private void h() {
        StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_BIND_CARD_ENTER, StatHelper.getOrderNo());
        StatHelper.cachePayType(0);
        StatHelper.cachePayWay(4);
        if (PayDataCache.getInstance().hasMobilePwd()) {
            PasswordController.getPassWordInstance().checkPwd(this.f25453a.getActivity(), BeanConstants.FROM_BIND_PAY, new PasswordController.IPwdListener() { // from class: com.baidu.wallet.paysdk.presenter.a.2
                @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                public void onFail(int i2, String str) {
                    PayRequestCache.getInstance().removeBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
                }

                @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                public void onSucceed(String str) {
                    PayRequestCache.getInstance().removeBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
                    BaiduPay.getInstance().bindCardAuth(a.this.f25453a.getActivity(), false);
                    StatisticManager.onEventWithValue(StatServiceEvent.EVENT_AuthorizePay_ClickNext, StatServiceEvent.VALUE_AuthorizePay_ClickNext_NewCard);
                }
            });
            return;
        }
        BaiduPay.getInstance().bindCardAuth(this.f25453a.getActivity(), false);
        StatisticManager.onEventWithValue(StatServiceEvent.EVENT_AuthorizePay_ClickNext, StatServiceEvent.VALUE_AuthorizePay_ClickNext_NewCard);
    }

    @Override // com.baidu.wallet.paysdk.presenter.e
    public void a() {
        AuthorizeSignActivity authorizeSignActivity = this.f25453a;
        if (authorizeSignActivity == null) {
            return;
        }
        authorizeSignActivity.initCardList();
        this.f25453a.setSelectCardListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.presenter.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.wallet.paysdk.a.b.a(a.this.f25453a.getActivity(), null);
            }
        });
        this.f25453a.initNextButton(this);
    }

    @Override // com.baidu.wallet.paysdk.presenter.e
    public void a(boolean z) {
    }

    @Override // com.baidu.wallet.paysdk.presenter.e
    public void b() {
        AuthorizeSignActivity authorizeSignActivity = this.f25453a;
        if (authorizeSignActivity == null) {
            return;
        }
        authorizeSignActivity.updateProtocolFields();
        this.f25453a.updateNextButton();
        AuthorizeSignActivity authorizeSignActivity2 = this.f25453a;
        authorizeSignActivity2.updateSelBankInfo(authorizeSignActivity2.getPayRequest().mBondCard);
        DirectPayContentResponse payResponse = this.f25453a.getPayResponse();
        if (payResponse == null || payResponse.authorize == null || !f()) {
            return;
        }
        this.f25453a.updateHintText(payResponse.authorize.extra.fee_tip);
    }

    @Override // com.baidu.wallet.paysdk.presenter.e
    public boolean c() {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.presenter.e
    public boolean d() {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.presenter.e
    public boolean e() {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.presenter.e
    public boolean f() {
        Authorize authorize;
        Authorize.Extra extra;
        DirectPayContentResponse payResponse = this.f25453a.getPayResponse();
        return (payResponse == null || (authorize = payResponse.authorize) == null || (extra = authorize.extra) == null || TextUtils.isEmpty(extra.fee_tip)) ? false : true;
    }

    @Override // com.baidu.wallet.paysdk.presenter.e
    public int g() {
        return this.f25454b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f25453a != null && view.getId() == ResUtils.id(this.f25453a.getApplicationContext(), "sign_next_btn")) {
            PayRequest payRequest = this.f25453a.getPayRequest();
            CardData.BondCard selectedCard = this.f25453a.getSelectedCard();
            StatHelper.cacheHasPwd(PayDataCache.getInstance().hasMobilePwd());
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(3);
            if (selectedCard == null) {
                h();
            } else if (selectedCard.isCompled()) {
                if (CheckUtils.isFastDoubleClick()) {
                    return;
                }
                if (payRequest != null) {
                    payRequest.mBondCard = selectedCard;
                }
                BaiduPay.getInstance().directAuth(this.f25453a.getActivity(), selectedCard);
                StatisticManager.onEventWithValue(StatServiceEvent.EVENT_AuthorizePay_ClickNext, StatServiceEvent.VALUE_AuthorizePay_ClickNext_BoundCard);
            } else {
                if (payRequest != null) {
                    payRequest.mBondCard = selectedCard;
                }
                a(selectedCard);
            }
        }
    }

    private void a(final CardData.BondCard bondCard) {
        if (PayDataCache.getInstance().hasMobilePwd()) {
            PasswordController.getPassWordInstance().checkPwd(this.f25453a.getActivity(), BeanConstants.FROM_COMPLETE_PAY, new PasswordController.IPwdListener() { // from class: com.baidu.wallet.paysdk.presenter.a.3
                @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                public void onFail(int i2, String str) {
                    PayRequestCache.getInstance().removeBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
                }

                @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                public void onSucceed(String str) {
                    PayRequestCache.getInstance().removeBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
                    BaiduPay.getInstance().completeCardAuth(a.this.f25453a.getActivity(), bondCard);
                    StatisticManager.onEventWithValue(StatServiceEvent.EVENT_AuthorizePay_ClickNext, StatServiceEvent.VALUE_AuthorizePay_ClickNext_CompleteCard);
                }
            });
            return;
        }
        BaiduPay.getInstance().completeCardAuth(this.f25453a.getActivity(), bondCard);
        StatisticManager.onEventWithValue(StatServiceEvent.EVENT_AuthorizePay_ClickNext, StatServiceEvent.VALUE_AuthorizePay_ClickNext_CompleteCard);
    }
}
