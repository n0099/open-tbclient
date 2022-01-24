package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.datamodel.Withholding;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.beans.IBeanResponse;
import com.dxmpay.wallet.base.datamodel.UserData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes2.dex */
public class DirectPayContentResponse implements IBeanResponse, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HIDDEN_ADD_BANKCARD_BTN = "0";
    public static final String SHOW_ADD_BANKCARD_BTN = "1";
    public static final long serialVersionUID = 1472548766280536579L;
    public transient /* synthetic */ FieldHolder $fh;
    public ApplyCardEntrance[] apply_card_entrance;
    public Authorize authorize;
    public Withholding authorize_common_cashdesk;
    public String bank_card_detect_enabled;
    public String can_bind_card_flag;
    public Map<String, String> cashdesk;
    public UserData.Misc misc;
    public PayData.DirectPayPay pay;
    public UserData.SP sp;
    public UserData.UserModel user;

    public DirectPayContentResponse() {
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
        this.can_bind_card_flag = "1";
    }

    public boolean canUsePcPwdVerify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            UserData.UserModel userModel = this.user;
            return userModel != null && "1".equals(userModel.can_use_pcpwd_verify);
        }
        return invokeV.booleanValue;
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        InterceptResult invokeV;
        Authorize authorize;
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        PayData.DirectPayPay directPayPay2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public CardData.BondCard[] getBondCards() {
        InterceptResult invokeV;
        PayData.EasyPay easyPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PayData.DirectPayPay directPayPay = this.pay;
            if (directPayPay == null || (easyPay = directPayPay.easypay) == null) {
                return null;
            }
            return easyPay.bind_card_arr;
        }
        return (CardData.BondCard[]) invokeV.objValue;
    }

    public CardData.BondCard[] getBondDebitCards() {
        InterceptResult invokeV;
        PayData.EasyPay easyPay;
        CardData.BondCard[] bondCardArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
        return (CardData.BondCard[]) invokeV.objValue;
    }

    public String getDisplayName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            UserData.UserModel userModel = this.user;
            return (userModel == null || TextUtils.isEmpty(userModel.display_name)) ? "" : this.user.display_name;
        }
        return (String) invokeV.objValue;
    }

    public CardData.BondCard[] getEnableBondCards() {
        InterceptResult invokeV;
        PayData.EasyPay easyPay;
        CardData.BondCard[] bondCardArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
        return (CardData.BondCard[]) invokeV.objValue;
    }

    public CardData.BondCard[] getEnableCardsForFindPWD() {
        InterceptResult invokeV;
        PayData.EasyPay easyPay;
        CardData.BondCard[] bondCardArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
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
        return (CardData.BondCard[]) invokeV.objValue;
    }

    public String getSpGoodsName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            UserData.SP sp = this.sp;
            return (sp == null || TextUtils.isEmpty(sp.goods_name)) ? "" : this.sp.goods_name;
        }
        return (String) invokeV.objValue;
    }

    public String getSpName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            UserData.SP sp = this.sp;
            return (sp == null || TextUtils.isEmpty(sp.sp_company)) ? "" : this.sp.sp_company;
        }
        return (String) invokeV.objValue;
    }

    public boolean hasBindCards() {
        InterceptResult invokeV;
        PayData.EasyPay easyPay;
        CardData.BondCard[] bondCardArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PayData.DirectPayPay directPayPay = this.pay;
            return (directPayPay == null || (easyPay = directPayPay.easypay) == null || (bondCardArr = easyPay.bind_card_arr) == null || bondCardArr.length <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean hasBindDebits() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public boolean hasEnableCards() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public boolean hasEnableDebits() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public boolean hasPwd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.user.hasMobilePwd() : invokeV.booleanValue;
    }

    public boolean hasSupportCards() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public boolean isWithHoldingValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            Withholding withholding = this.authorize_common_cashdesk;
            return withholding != null && "1".equals(withholding.status);
        }
        return invokeV.booleanValue;
    }

    public void setHasPwd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.user.setHasMobilePwd();
        }
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
            PayDataCache.getInstance().setPayResponse(this);
        }
    }
}
