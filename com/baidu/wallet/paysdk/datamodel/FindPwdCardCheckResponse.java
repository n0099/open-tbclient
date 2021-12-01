package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.beans.IBeanResponse;
import com.dxmpay.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes12.dex */
public class FindPwdCardCheckResponse implements IBeanResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Card[] bind_card_arr;

    /* loaded from: classes12.dex */
    public static class Card implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String account_no;
        public String bank_code;
        public String bank_name;
        public String bank_url;
        public int card_type;
        public String find_pwd_by_sms;
        public String mobile_ec;
        public String unsupport_find_pwd_msg;

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

    public FindPwdCardCheckResponse() {
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

    @Override // com.dxmpay.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean enableAddBondCards() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public CardData.BondCard[] getBondCards() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) != null) {
            return (CardData.BondCard[]) invokeV.objValue;
        }
        Card[] cardArr = this.bind_card_arr;
        if (cardArr == null) {
            return null;
        }
        CardData.BondCard[] bondCardArr = new CardData.BondCard[cardArr.length];
        int i2 = 0;
        while (true) {
            Card[] cardArr2 = this.bind_card_arr;
            if (i2 >= cardArr2.length) {
                return bondCardArr;
            }
            Card card = cardArr2[i2];
            CardData.BondCard bondCard = new CardData.BondCard();
            bondCard.account_no = card.account_no;
            bondCard.bank_code = card.bank_code;
            bondCard.card_type = card.card_type;
            bondCard.bank_name = card.bank_name;
            bondCard.bank_url = card.bank_url;
            String str = card.mobile_ec;
            bondCard.mobile_ec = str;
            if (!TextUtils.isEmpty(str)) {
                bondCard.mobile = SecurePay.unicodeDecode(SecurePay.getInstance().localDecryptProxy(card.mobile_ec));
            }
            bondCard.find_pwd_by_sms = card.find_pwd_by_sms;
            bondCard.unsupport_find_pwd_msg = card.unsupport_find_pwd_msg;
            bondCardArr[i2] = bondCard;
            i2++;
        }
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
        }
    }
}
