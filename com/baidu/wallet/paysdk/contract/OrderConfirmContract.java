package com.baidu.wallet.paysdk.contract;

import com.baidu.wallet.paysdk.presenter.BasePresenter;
import java.io.Serializable;
/* loaded from: classes5.dex */
public interface OrderConfirmContract {

    /* loaded from: classes5.dex */
    public interface Presenter extends BasePresenter {

        /* loaded from: classes5.dex */
        public static class OrderConfirmViewData implements Serializable {
            public String cardTip;
            public String channelDiscountDesc;
            public String confirmBtnMsg;
            public String currentAccount;
            public String discountAmount;
            public String discountDesc;
            public String goodsName;
            public boolean hasAvailablePayType;
            public boolean highlight;
            public boolean isFingerprintPay;
            public boolean isOTP = true;
            public boolean isShowRedDot;
            public String needPayAmount;
            public String orderPrice;
            public String payTyeDesc;
            public String randomDiscountMsg;
            public boolean showDiscount;
            public String spName;
            public String title_url;
        }

        void changePwdMode();

        void clickCoupon();

        void clickPayway();

        void closeOrderComfirmPage();

        void getViewData();

        void gotoPayUsePwd(boolean z, String str);

        void onFpCheckError();

        void onFpCheckSucces(String str);

        void quitCashDesk();

        void startFingerprintListening();
    }
}
