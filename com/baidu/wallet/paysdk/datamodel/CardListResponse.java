package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class CardListResponse implements IBeanResponse, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ApplyCardEntrance[] apply_card_entrance;
    public Card[] bind_card_arr;
    public Misc card_bind_misc_info;
    public User user;

    /* loaded from: classes6.dex */
    public static class Card implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String account_index;
        public String avail_amount;
        public String background_url;
        public String bank_code;
        public String bank_name;
        public String bank_url;
        public String bind_time;
        public String card_detail_url;
        public String card_no;
        public String card_type;
        public String type_name;
        public String usage_desc;

        public Card() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class Misc implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String bank_card_detect_enabled;
        public String bind_card_limit_msg;
        public String can_bind_card_flag;

        public Misc() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class User implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String has_pwd;

        public User() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public CardListResponse() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private DirectPayContentResponse toCacheResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            if (payResponse == null) {
                payResponse = new DirectPayContentResponse();
            }
            payResponse.apply_card_entrance = this.apply_card_entrance;
            Misc misc = this.card_bind_misc_info;
            if (misc != null) {
                payResponse.bank_card_detect_enabled = misc.bank_card_detect_enabled;
                payResponse.can_bind_card_flag = misc.can_bind_card_flag;
            }
            if (this.user != null) {
                if (payResponse.user == null) {
                    payResponse.user = new UserData.UserModel();
                }
                payResponse.user.has_mobile_password = "1".equals(this.user.has_pwd) ? 1 : 0;
            }
            Card[] cardArr = this.bind_card_arr;
            if (cardArr != null && cardArr.length > 0) {
                if (payResponse.pay == null) {
                    payResponse.pay = new PayData.DirectPayPay();
                }
                PayData.DirectPayPay directPayPay = payResponse.pay;
                if (directPayPay.easypay == null) {
                    directPayPay.easypay = new PayData.EasyPay();
                }
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                while (true) {
                    Card[] cardArr2 = this.bind_card_arr;
                    if (i2 >= cardArr2.length) {
                        break;
                    }
                    Card card = cardArr2[i2];
                    if (card != null) {
                        CardData.BondCard bondCard = new CardData.BondCard();
                        String str = card.bank_code;
                        bondCard.account_bank_code = str;
                        bondCard.bank_code = str;
                        bondCard.bank_url = card.bank_url;
                        bondCard.background_url = card.background_url;
                        bondCard.bind_time = card.bind_time;
                        if ("2".equals(card.card_type)) {
                            bondCard.card_type = 2;
                        } else if ("1".equals(card.card_type)) {
                            bondCard.card_type = 1;
                        }
                        bondCard.type_name = card.type_name;
                        bondCard.unbund_card_enabled = 1;
                        arrayList.add(bondCard);
                    }
                    i2++;
                }
                if (arrayList.size() > 0) {
                    payResponse.pay.easypay.bind_card_arr = new CardData.BondCard[arrayList.size()];
                    arrayList.toArray(payResponse.pay.easypay.bind_card_arr);
                }
            }
            return payResponse;
        }
        return (DirectPayContentResponse) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.user == null || this.card_bind_misc_info == null) ? false : true : invokeV.booleanValue;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            PayDataCache.getInstance().setPayResponse(toCacheResponse());
        }
    }
}
