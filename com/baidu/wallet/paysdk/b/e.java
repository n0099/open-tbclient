package com.baidu.wallet.paysdk.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
/* loaded from: classes5.dex */
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
                return;
            }
        }
        LogUtil.d(j.q, "init Controller : 补全不支付的业务控制");
    }

    @Override // com.baidu.wallet.paysdk.b.b
    public void a(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr) == null) {
            if (strArr.length > 1) {
                if (PayDataCache.getInstance().hasMobilePwd()) {
                    this.f25906a.a("", strArr[0]);
                } else {
                    CardData.BondCard bondCard = this.f25910e.mBondCard;
                    if (bondCard != null) {
                        this.f25906a.a(strArr[0], bondCard.account_no);
                    } else {
                        this.f25906a.a(strArr[0], "");
                    }
                }
            }
            this.f25906a.a("repair_card_info");
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
            CardData.BondCard bondCard = this.f25910e.getmBondCard();
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
                    this.f25910e.setmCvv(strArr[0]);
                }
                if (l()) {
                    this.f25910e.setmValidDate(strArr[1].replaceAll("/", ""));
                }
                if (j()) {
                    this.f25910e.setmName(strArr[2]);
                } else {
                    this.f25910e.setmName(str2);
                }
                if (m()) {
                    this.f25910e.setmIdCard(strArr[3]);
                } else {
                    this.f25910e.setmIdCard(str3);
                }
                if (n()) {
                    this.f25910e.setmPhone(strArr[4].replaceAll(" ", ""));
                } else {
                    this.f25910e.setmPhone(str);
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
            CardData.BondCard bondCard = this.f25910e.mBondCard;
            if (bondCard == null) {
                this.f25909d.finish();
                return super.p();
            }
            String last4Num = bondCard.getLast4Num();
            if (PayDataCache.getInstance().hasMobilePwd()) {
                if (this.f25910e.mBondCard.card_type == 2) {
                    return this.f25910e.mBondCard.bank_name + " " + ResUtils.getString(this.f25909d, "wallet_base_mode_debit") + " " + ResUtils.getString(this.f25909d, "ebpay_last_nums") + last4Num;
                }
                return this.f25910e.mBondCard.bank_name + " " + ResUtils.getString(this.f25909d, "wallet_base_mode_credit") + " " + ResUtils.getString(this.f25909d, "ebpay_last_nums") + last4Num;
            }
            return String.format(ResUtils.getString(this.f25909d, "ebpay_hint_last4num"), last4Num);
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
            BindFastRequest bindFastRequest = this.f25910e;
            if (bindFastRequest != null) {
                if (bindFastRequest.getmBankInfo() != null && this.f25910e.getmBankInfo().channel_info != null && this.f25910e.getmBankInfo().channel_info.card_item_required != null) {
                    this.f25911f = "1".equals(this.f25910e.getmBankInfo().channel_info.card_item_required.valid_code);
                    this.f25912g = "1".equals(this.f25910e.getmBankInfo().channel_info.card_item_required.true_name);
                    this.f25913h = "1".equals(this.f25910e.getmBankInfo().channel_info.card_item_required.valid_date);
                    this.f25914i = "1".equals(this.f25910e.getmBankInfo().channel_info.card_item_required.certificate_code);
                    this.j = "1".equals(this.f25910e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()));
                }
                if (this.f25909d != null) {
                    if (this.f25910e.getmBankInfo() != null) {
                        this.f25909d.updateBankTitleInfo(this.f25910e.getmBankInfo().card_info, true);
                    } else {
                        this.f25909d.updateBankTitleInfo(null, true);
                    }
                    if (this.f25910e.getmBankInfo() != null) {
                        this.f25909d.updateProtocolFields(this.f25910e.getmBankInfo().protocol_info);
                    } else {
                        this.f25909d.updateProtocolFields(null);
                    }
                    this.f25909d.updateCardElement(this.f25911f, this.f25913h, this.f25912g, this.f25914i, this.j);
                }
            }
        }
    }
}
