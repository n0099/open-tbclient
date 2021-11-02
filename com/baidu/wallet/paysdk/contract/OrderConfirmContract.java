package com.baidu.wallet.paysdk.contract;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.presenter.BasePresenter;
import java.io.Serializable;
/* loaded from: classes10.dex */
public interface OrderConfirmContract {

    /* loaded from: classes10.dex */
    public interface Presenter extends BasePresenter {

        /* loaded from: classes10.dex */
        public static class OrderConfirmViewData implements Serializable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
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
            public boolean isOTP;
            public boolean isShowRedDot;
            public String needPayAmount;
            public String orderPrice;
            public String payTyeDesc;
            public String randomDiscountMsg;
            public boolean showDiscount;
            public String spName;
            public String title_url;

            public OrderConfirmViewData() {
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
                this.isOTP = true;
            }
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
