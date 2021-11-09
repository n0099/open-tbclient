package com.baidu.wallet.paysdk.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.apollon.utils.ResUtils;
/* loaded from: classes10.dex */
public class e extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    @Override // com.baidu.wallet.paysdk.b.b
    public void a(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr) == null) {
            if (strArr.length > 1) {
                if (PayDataCache.getInstance().hasMobilePwd()) {
                    this.f59520a.a("", strArr[0]);
                } else {
                    CardData.BondCard bondCard = this.f59524e.mBondCard;
                    if (bondCard != null) {
                        this.f59520a.a(strArr[0], bondCard.account_no);
                    } else {
                        this.f59520a.a(strArr[0], "");
                    }
                }
            }
            this.f59520a.a("repair_card_info");
            super.a(strArr);
        }
    }

    @Override // com.baidu.wallet.paysdk.b.b
    public void b(String... strArr) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr) == null) {
            CardData.BondCard bondCard = this.f59524e.getmBondCard();
            if (bondCard != null) {
                str2 = bondCard.true_name;
                str3 = bondCard.certificate_code;
                str = bondCard.mobile;
            } else {
                str = "";
                str2 = str;
                str3 = str2;
            }
            if (strArr.length >= 5) {
                if (k()) {
                    this.f59524e.setmCvv(strArr[0]);
                }
                if (l()) {
                    this.f59524e.setmValidDate(strArr[1].replaceAll("/", ""));
                }
                if (j()) {
                    this.f59524e.setmName(strArr[2]);
                } else {
                    this.f59524e.setmName(str2);
                }
                if (m()) {
                    this.f59524e.setmIdCard(strArr[3]);
                } else {
                    this.f59524e.setmIdCard(str3);
                }
                if (n()) {
                    this.f59524e.setmPhone(strArr[4].replaceAll(" ", ""));
                } else {
                    this.f59524e.setmPhone(str);
                }
            }
            super.b(strArr);
        }
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return !TextUtils.isEmpty(PayDataCache.getInstance().hasMobilePwd() ? PayDataCache.getInstance().getFormatUserName() : "");
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            CardData.BondCard bondCard = this.f59524e.mBondCard;
            if (bondCard == null) {
                this.f59523d.finish();
                return super.p();
            }
            String last4Num = bondCard.getLast4Num();
            if (PayDataCache.getInstance().hasMobilePwd()) {
                if (this.f59524e.mBondCard.card_type == 2) {
                    return this.f59524e.mBondCard.bank_name + " " + ResUtils.getString(this.f59523d, "wallet_base_mode_debit") + " " + ResUtils.getString(this.f59523d, "ebpay_last_nums") + last4Num;
                }
                return this.f59524e.mBondCard.bank_name + " " + ResUtils.getString(this.f59523d, "wallet_base_mode_credit") + " " + ResUtils.getString(this.f59523d, "ebpay_last_nums") + last4Num;
            }
            return String.format(ResUtils.getString(this.f59523d, "ebpay_hint_last4num"), last4Num);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? !PayDataCache.getInstance().hasMobilePwd() : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            BindFastRequest bindFastRequest = this.f59524e;
            if (bindFastRequest != null) {
                if (bindFastRequest.getmBankInfo() != null && this.f59524e.getmBankInfo().channel_info != null && this.f59524e.getmBankInfo().channel_info.card_item_required != null) {
                    this.f59525f = "1".equals(this.f59524e.getmBankInfo().channel_info.card_item_required.valid_code);
                    this.f59526g = "1".equals(this.f59524e.getmBankInfo().channel_info.card_item_required.true_name);
                    this.f59527h = "1".equals(this.f59524e.getmBankInfo().channel_info.card_item_required.valid_date);
                    this.f59528i = "1".equals(this.f59524e.getmBankInfo().channel_info.card_item_required.certificate_code);
                    this.j = "1".equals(this.f59524e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()));
                }
                if (this.f59523d != null) {
                    if (this.f59524e.getmBankInfo() != null) {
                        this.f59523d.updateBankTitleInfo(this.f59524e.getmBankInfo().card_info, true);
                    } else {
                        this.f59523d.updateBankTitleInfo(null, true);
                    }
                    if (this.f59524e.getmBankInfo() != null) {
                        if ("11".equals(this.f59524e.getCardRequestType())) {
                            this.f59523d.updateBindCardProtocolFields(this.f59524e.getmBankInfo().protocol_platform_info);
                        } else {
                            this.f59523d.updateProtocolFields(this.f59524e.getmBankInfo().protocol_info);
                        }
                    } else {
                        this.f59523d.updateBindCardProtocolFields(null);
                        this.f59523d.updateProtocolFields(null);
                    }
                    this.f59523d.updateCardElement(this.f59525f, this.f59527h, this.f59526g, this.f59528i, this.j);
                }
            }
        }
    }
}
