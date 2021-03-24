package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.base.datamodel.Withholding;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes5.dex */
public class DirectPayContentResponse implements IBeanResponse, Serializable {
    public static final String HIDDEN_ADD_BANKCARD_BTN = "0";
    public static final String SHOW_ADD_BANKCARD_BTN = "1";
    public static final long serialVersionUID = 1472548766280536579L;
    public ApplyCardEntrance[] apply_card_entrance;
    public Authorize authorize;
    public Withholding authorize_common_cashdesk;
    public String bank_card_detect_enabled;
    public String can_bind_card_flag = "1";
    public Map<String, String> cashdesk;
    public UserData.Misc misc;
    public PayData.DirectPayPay pay;
    public UserData.SP sp;
    public UserData.UserModel user;

    public boolean canUsePcPwdVerify() {
        UserData.UserModel userModel = this.user;
        return userModel != null && "1".equals(userModel.can_use_pcpwd_verify);
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        Authorize authorize;
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        PayData.DirectPayPay directPayPay2;
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        boolean z = true;
        if (payRequest == null) {
            return true;
        }
        if (BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom())) {
            return this.user != null;
        } else if (this.sp == null) {
            return (this.user == null || (directPayPay2 = this.pay) == null || directPayPay2.easypay == null) ? false : true;
        } else {
            boolean z2 = (this.user == null || (directPayPay = this.pay) == null || (easyPay = directPayPay.easypay) == null || easyPay.post_info == null) ? false : true;
            if (BaiduPay.PAY_FROM_AUTHORIZE.equals(payRequest.getPayFrom())) {
                return (z2 && (authorize = this.authorize) != null && authorize.isResonseValide()) ? false : false;
            }
            return z2;
        }
    }

    public CardData.BondCard[] getBondCards() {
        PayData.EasyPay easyPay;
        PayData.DirectPayPay directPayPay = this.pay;
        if (directPayPay == null || (easyPay = directPayPay.easypay) == null) {
            return null;
        }
        return easyPay.bind_card_arr;
    }

    public CardData.BondCard[] getBondDebitCards() {
        PayData.EasyPay easyPay;
        CardData.BondCard[] bondCardArr;
        PayData.DirectPayPay directPayPay = this.pay;
        if (directPayPay == null || (easyPay = directPayPay.easypay) == null || easyPay.bind_card_arr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CardData.BondCard bondCard : this.pay.easypay.bind_card_arr) {
            if (bondCard != null && bondCard.card_type == 2) {
                arrayList.add(bondCard);
            }
        }
        return (CardData.BondCard[]) arrayList.toArray(new CardData.BondCard[arrayList.size()]);
    }

    public String getDisplayName() {
        UserData.UserModel userModel = this.user;
        return (userModel == null || TextUtils.isEmpty(userModel.display_name)) ? "" : this.user.display_name;
    }

    public CardData.BondCard[] getEnableBondCards() {
        PayData.EasyPay easyPay;
        CardData.BondCard[] bondCardArr;
        PayData.DirectPayPay directPayPay = this.pay;
        if (directPayPay == null || (easyPay = directPayPay.easypay) == null || easyPay.bind_card_arr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CardData.BondCard bondCard : this.pay.easypay.bind_card_arr) {
            if (bondCard != null && bondCard.isCompled() && "1".equals(bondCard.card_state)) {
                arrayList.add(bondCard);
            }
        }
        return (CardData.BondCard[]) arrayList.toArray(new CardData.BondCard[arrayList.size()]);
    }

    public CardData.BondCard[] getEnableCardsForFindPWD() {
        PayData.EasyPay easyPay;
        CardData.BondCard[] bondCardArr;
        PayData.DirectPayPay directPayPay = this.pay;
        if (directPayPay == null || (easyPay = directPayPay.easypay) == null || easyPay.bind_card_arr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CardData.BondCard bondCard : this.pay.easypay.bind_card_arr) {
            if (bondCard != null && bondCard.getCanFindPWDBySms()) {
                arrayList.add(bondCard);
            }
        }
        return (CardData.BondCard[]) arrayList.toArray(new CardData.BondCard[arrayList.size()]);
    }

    public String getSpGoodsName() {
        UserData.SP sp = this.sp;
        return (sp == null || TextUtils.isEmpty(sp.goods_name)) ? "" : this.sp.goods_name;
    }

    public String getSpName() {
        UserData.SP sp = this.sp;
        return (sp == null || TextUtils.isEmpty(sp.sp_company)) ? "" : this.sp.sp_company;
    }

    public boolean hasBindCards() {
        PayData.EasyPay easyPay;
        CardData.BondCard[] bondCardArr;
        PayData.DirectPayPay directPayPay = this.pay;
        return (directPayPay == null || (easyPay = directPayPay.easypay) == null || (bondCardArr = easyPay.bind_card_arr) == null || bondCardArr.length <= 0) ? false : true;
    }

    public boolean hasBindDebits() {
        CardData.BondCard[] bondCardArr = this.pay.easypay.bind_card_arr;
        if (bondCardArr != null) {
            for (CardData.BondCard bondCard : bondCardArr) {
                if (bondCard != null && bondCard.card_type == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasEnableCards() {
        CardData.BondCard[] bondCardArr = this.pay.easypay.bind_card_arr;
        if (bondCardArr != null) {
            for (CardData.BondCard bondCard : bondCardArr) {
                if (bondCard != null && bondCard.isCompled() && "1".equals(bondCard.card_state)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasEnableDebits() {
        CardData.BondCard[] bondCardArr = this.pay.easypay.bind_card_arr;
        if (bondCardArr != null) {
            for (CardData.BondCard bondCard : bondCardArr) {
                if (bondCard != null && bondCard.card_type == 2 && bondCard.isCompled() && "1".equals(bondCard.card_state)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPwd() {
        return this.user.hasMobilePwd();
    }

    public boolean hasSupportCards() {
        CardData.BondCard[] bondCardArr = this.pay.easypay.bind_card_arr;
        if (bondCardArr != null) {
            for (CardData.BondCard bondCard : bondCardArr) {
                if (bondCard != null && "1".equals(bondCard.card_state)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isWithHoldingValidity() {
        Withholding withholding = this.authorize_common_cashdesk;
        return withholding != null && "1".equals(withholding.status);
    }

    public void setHasPwd() {
        this.user.setHasMobilePwd();
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        PayDataCache.getInstance().setPayResponse(this);
    }
}
