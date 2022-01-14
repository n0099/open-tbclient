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
/* loaded from: classes13.dex */
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
                    this.a.a("", strArr[0]);
                } else {
                    CardData.BondCard bondCard = this.f51888e.mBondCard;
                    if (bondCard != null) {
                        this.a.a(strArr[0], bondCard.account_no);
                    } else {
                        this.a.a(strArr[0], "");
                    }
                }
            }
            this.a.a("repair_card_info");
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
            CardData.BondCard bondCard = this.f51888e.getmBondCard();
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
                    this.f51888e.setmCvv(strArr[0]);
                }
                if (l()) {
                    this.f51888e.setmValidDate(strArr[1].replaceAll("/", ""));
                }
                if (j()) {
                    this.f51888e.setmName(strArr[2]);
                } else {
                    this.f51888e.setmName(str2);
                }
                if (m()) {
                    this.f51888e.setmIdCard(strArr[3]);
                } else {
                    this.f51888e.setmIdCard(str3);
                }
                if (n()) {
                    this.f51888e.setmPhone(strArr[4].replaceAll(" ", ""));
                } else {
                    this.f51888e.setmPhone(str);
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
            CardData.BondCard bondCard = this.f51888e.mBondCard;
            if (bondCard == null) {
                this.f51887d.finish();
                return super.p();
            }
            String last4Num = bondCard.getLast4Num();
            if (PayDataCache.getInstance().hasMobilePwd()) {
                if (this.f51888e.mBondCard.card_type == 2) {
                    return this.f51888e.mBondCard.bank_name + " " + ResUtils.getString(this.f51887d, "wallet_base_mode_debit") + " " + ResUtils.getString(this.f51887d, "ebpay_last_nums") + last4Num;
                }
                return this.f51888e.mBondCard.bank_name + " " + ResUtils.getString(this.f51887d, "wallet_base_mode_credit") + " " + ResUtils.getString(this.f51887d, "ebpay_last_nums") + last4Num;
            }
            return String.format(ResUtils.getString(this.f51887d, "ebpay_hint_last4num"), last4Num);
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
            BindFastRequest bindFastRequest = this.f51888e;
            if (bindFastRequest != null) {
                if (bindFastRequest.getmBankInfo() != null && this.f51888e.getmBankInfo().channel_info != null && this.f51888e.getmBankInfo().channel_info.card_item_required != null) {
                    this.f51889f = "1".equals(this.f51888e.getmBankInfo().channel_info.card_item_required.valid_code);
                    this.f51890g = "1".equals(this.f51888e.getmBankInfo().channel_info.card_item_required.true_name);
                    this.f51891h = "1".equals(this.f51888e.getmBankInfo().channel_info.card_item_required.valid_date);
                    this.f51892i = "1".equals(this.f51888e.getmBankInfo().channel_info.card_item_required.certificate_code);
                    this.f51893j = "1".equals(this.f51888e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()));
                }
                if (this.f51887d != null) {
                    if (this.f51888e.getmBankInfo() != null) {
                        this.f51887d.updateBankTitleInfo(this.f51888e.getmBankInfo().card_info, true);
                    } else {
                        this.f51887d.updateBankTitleInfo(null, true);
                    }
                    if (this.f51888e.getmBankInfo() != null) {
                        if ("11".equals(this.f51888e.getCardRequestType())) {
                            this.f51887d.updateBindCardProtocolFields(this.f51888e.getmBankInfo().protocol_platform_info);
                        } else {
                            this.f51887d.updateProtocolFields(this.f51888e.getmBankInfo().protocol_info);
                        }
                    } else {
                        this.f51887d.updateBindCardProtocolFields(null);
                        this.f51887d.updateProtocolFields(null);
                    }
                    this.f51887d.updateCardElement(this.f51889f, this.f51891h, this.f51890g, this.f51892i, this.f51893j);
                }
            }
        }
    }
}
