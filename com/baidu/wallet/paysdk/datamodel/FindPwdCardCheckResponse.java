package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class FindPwdCardCheckResponse implements IBeanResponse {
    public Card[] bind_card_arr;

    /* loaded from: classes5.dex */
    public static class Card implements NoProguard, Serializable {
        public String account_no;
        public String bank_code;
        public String bank_name;
        public String bank_url;
        public int card_type;
        public String find_pwd_by_sms;
        public String mobile_ec;
        public String unsupport_find_pwd_msg;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    public boolean enableAddBondCards() {
        return true;
    }

    public CardData.BondCard[] getBondCards() {
        Card[] cardArr = this.bind_card_arr;
        if (cardArr == null) {
            return null;
        }
        CardData.BondCard[] bondCardArr = new CardData.BondCard[cardArr.length];
        int i = 0;
        while (true) {
            Card[] cardArr2 = this.bind_card_arr;
            if (i >= cardArr2.length) {
                return bondCardArr;
            }
            Card card = cardArr2[i];
            CardData.BondCard bondCard = new CardData.BondCard();
            bondCard.account_no = card.account_no;
            bondCard.bank_code = card.bank_code;
            bondCard.card_type = card.card_type;
            bondCard.bank_name = card.bank_name;
            bondCard.bank_url = card.bank_url;
            String str = card.mobile_ec;
            bondCard.mobile_ec = str;
            if (!TextUtils.isEmpty(str)) {
                bondCard.mobile = SafePay.unicodeDecode(SafePay.getInstance().localDecryptProxy(card.mobile_ec));
            }
            bondCard.find_pwd_by_sms = card.find_pwd_by_sms;
            bondCard.unsupport_find_pwd_msg = card.unsupport_find_pwd_msg;
            bondCardArr[i] = bondCard;
            i++;
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
