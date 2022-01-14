package com.baidu.wallet.paysdk.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.apollon.utils.ResUtils;
/* loaded from: classes13.dex */
public class g extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public g() {
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

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                BindFastRequest bindFastRequest = this.f51888e;
                if (bindFastRequest.mBondCard != null) {
                    ErrorContentResponse errorContentResponse = bindFastRequest.mCardInfoUpdateContent;
                    if (errorContentResponse != null && !TextUtils.isEmpty(errorContentResponse.need_send_sms)) {
                        return this.f51888e.mCardInfoUpdateContent.isNeedSendSms();
                    }
                    return this.f51888e.mBondCard.isNeedSendSms();
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b
    public void a(String... strArr) {
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr) == null) {
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
            DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            if (payResponse != null && (directPayPay = payResponse.pay) != null && (easyPay = directPayPay.easypay) != null) {
                this.a.a(easyPay.getService());
            }
            super.a(strArr);
        }
    }

    @Override // com.baidu.wallet.paysdk.b.b
    public void b(String... strArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, strArr) == null) {
            CardData.BondCard bondCard = this.f51888e.getmBondCard();
            if (s()) {
                Boolean valueOf = Boolean.valueOf(bondCard != null && PayDataCache.getInstance().hasMobilePwd());
                if (valueOf.booleanValue()) {
                    this.f51888e.setmBankCard(bondCard.account_no);
                    this.f51888e.setBankType(bondCard.card_type);
                }
                if (bondCard != null && !TextUtils.isEmpty(bondCard.bank_code)) {
                    this.f51888e.mBankNo = bondCard.bank_code;
                }
                str2 = (valueOf.booleanValue() && bondCard.hasName()) ? bondCard.true_name : "";
                str3 = (valueOf.booleanValue() && bondCard.hasId()) ? bondCard.certificate_code : "";
                if (bondCard != null && !TextUtils.isEmpty(bondCard.account_bank_code)) {
                    this.f51888e.setChannelNo(bondCard.account_bank_code);
                }
                str4 = (!this.n && valueOf.booleanValue() && bondCard.hasMobile()) ? bondCard.mobile : "";
                str5 = (!this.m && valueOf.booleanValue() && bondCard.hasCvv()) ? bondCard.verify_code : "";
                str = (!this.l && valueOf.booleanValue() && bondCard.hasDate()) ? bondCard.valid_date : "";
            } else {
                if (5 <= strArr.length && TextUtils.isDigitsOnly(strArr[4])) {
                    str4 = strArr[4];
                } else if (bondCard != null) {
                    str4 = bondCard.mobile;
                } else {
                    str = "";
                    str2 = str;
                    str3 = str2;
                    str4 = str3;
                    str5 = str4;
                }
                str = "";
                str2 = str;
                str3 = str2;
                str5 = str3;
            }
            if (strArr.length >= 6) {
                if (k()) {
                    this.f51888e.setmCvv(strArr[0]);
                } else if (!TextUtils.isEmpty(str5)) {
                    this.f51888e.setmCvv(str5);
                }
                if (l()) {
                    this.f51888e.setmValidDate(strArr[1].replaceAll("/", ""));
                } else if (!TextUtils.isEmpty(str)) {
                    this.f51888e.setmValidDate(str);
                }
                if (j()) {
                    this.f51888e.setmName(strArr[2]);
                } else if (!TextUtils.isEmpty(str2)) {
                    this.f51888e.setmName(str2);
                }
                if (m()) {
                    this.f51888e.setmIdCard(strArr[3]);
                } else if (!TextUtils.isEmpty(str3)) {
                    this.f51888e.setmIdCard(str3);
                }
                if (n()) {
                    this.f51888e.setmPhone(strArr[4].replaceAll(" ", ""));
                } else if (!TextUtils.isEmpty(str4)) {
                    this.f51888e.setmPhone(str4);
                }
                if (!this.k && TextUtils.isEmpty(strArr[5])) {
                    this.f51888e.setCertificateType("");
                } else {
                    this.f51888e.setCertificateType(strArr[5]);
                }
            }
            super.b(strArr);
        }
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            CardData.BondCard bondCard = this.f51888e.mBondCard;
            if (bondCard == null || !"1".equals(bondCard.need_true_name)) {
                return !TextUtils.isEmpty(PayDataCache.getInstance().hasMobilePwd() ? PayDataCache.getInstance().getFormatUserName() : "");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            CardData.BondCard bondCard = this.f51888e.mBondCard;
            if (bondCard == null) {
                this.f51887d.finish();
                return super.p();
            }
            String last4Num = bondCard.getLast4Num();
            if (s()) {
                if (this.f51888e.mBondCard.card_type == 2) {
                    return this.f51888e.mBondCard.bank_name + " " + ResUtils.getString(this.f51887d, "wallet_base_mode_debit") + " " + ResUtils.getString(this.f51887d, "ebpay_last_nums") + last4Num;
                }
                return this.f51888e.mBondCard.bank_name + " " + ResUtils.getString(this.f51887d, "wallet_base_mode_credit") + " " + ResUtils.getString(this.f51887d, "ebpay_last_nums") + last4Num;
            } else if (PayDataCache.getInstance().hasMobilePwd()) {
                if (this.f51888e.mBondCard.card_type == 2) {
                    return this.f51888e.mBondCard.bank_name + " " + ResUtils.getString(this.f51887d, "wallet_base_mode_debit") + " " + ResUtils.getString(this.f51887d, "ebpay_last_nums") + last4Num;
                }
                return this.f51888e.mBondCard.bank_name + " " + ResUtils.getString(this.f51887d, "wallet_base_mode_credit") + " " + ResUtils.getString(this.f51887d, "ebpay_last_nums") + last4Num;
            } else if (this.f51888e.mBondCard.card_type == 2) {
                return this.f51888e.mBondCard.bank_name + " " + ResUtils.getString(this.f51887d, "wallet_base_mode_debit") + " " + ResUtils.getString(this.f51887d, "ebpay_last_nums") + last4Num;
            } else {
                return this.f51888e.mBondCard.bank_name + " " + ResUtils.getString(this.f51887d, "wallet_base_mode_credit") + " " + ResUtils.getString(this.f51887d, "ebpay_last_nums") + last4Num;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (s() || PayDataCache.getInstance().hasMobilePwd()) ? false : true : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public GetCardInfoResponse.CertificateTypeInfo[] v() {
        InterceptResult invokeV;
        GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BindFastRequest bindFastRequest = this.f51888e;
            GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr2 = null;
            if (bindFastRequest != null) {
                if (bindFastRequest.getmBankInfo() != null && this.f51888e.getmBankInfo().channel_info != null) {
                    certificateTypeInfoArr2 = this.f51888e.getmBankInfo().channel_info.certificate_type_info;
                } else {
                    ErrorContentResponse errorContentResponse = this.f51888e.mCardInfoUpdateContent;
                    if (errorContentResponse == null || (certificateTypeInfoArr = errorContentResponse.certificate_type_info) == null) {
                        if (this.f51888e.getmBondCard() != null) {
                            certificateTypeInfoArr = this.f51888e.getmBondCard().certificate_type_info;
                        }
                    }
                    certificateTypeInfoArr2 = certificateTypeInfoArr;
                }
            }
            if (certificateTypeInfoArr2 == null || certificateTypeInfoArr2.length == 0) {
                GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo = new GetCardInfoResponse.CertificateTypeInfo();
                certificateTypeInfo.type = "1";
                certificateTypeInfo.description = ResUtils.getString(this.f51887d, "ebpay_certificate");
                return new GetCardInfoResponse.CertificateTypeInfo[]{certificateTypeInfo};
            }
            return certificateTypeInfoArr2;
        }
        return (GetCardInfoResponse.CertificateTypeInfo[]) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.a();
            BindFastRequest bindFastRequest = this.f51888e;
            if (bindFastRequest != null) {
                boolean z = false;
                if (bindFastRequest.getmBankInfo() != null && this.f51888e.getmBankInfo().channel_info != null && this.f51888e.getmBankInfo().channel_info.card_item_required != null) {
                    this.f51889f = "1".equals(this.f51888e.getmBankInfo().channel_info.card_item_required.valid_code);
                    this.f51890g = "1".equals(this.f51888e.getmBankInfo().channel_info.card_item_required.true_name);
                    this.f51891h = "1".equals(this.f51888e.getmBankInfo().channel_info.card_item_required.valid_date);
                    this.f51892i = "1".equals(this.f51888e.getmBankInfo().channel_info.card_item_required.certificate_code);
                    this.f51893j = "1".equals(this.f51888e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()));
                    this.k = "1".equals(this.f51888e.getmBankInfo().channel_info.card_item_required.certificate_type);
                } else {
                    CardData.BondCard bondCard = this.f51888e.mBondCard;
                    if (bondCard != null) {
                        this.f51889f = !bondCard.hasCvv();
                        this.f51890g = !this.f51888e.mBondCard.hasName();
                        this.f51891h = !this.f51888e.mBondCard.hasDate();
                        this.f51892i = !this.f51888e.mBondCard.hasId();
                        this.f51893j = !this.f51888e.mBondCard.hasMobile();
                        this.k = !this.f51888e.mBondCard.hasIdType();
                    }
                }
                if (this.f51888e.getmBondCard() != null) {
                    this.f51889f = this.f51889f || "1".equals(this.f51888e.getmBondCard().need_cvv2);
                    this.f51891h = (this.f51891h || "1".equals(this.f51888e.getmBondCard().need_valid_date)) ? true : true;
                }
            }
            if (this.f51887d != null) {
                if (q()) {
                    if (this.f51888e.getmBankInfo() != null) {
                        this.f51887d.updateBankTitleInfo(this.f51888e.getmBankInfo().card_info, true);
                    } else {
                        this.f51887d.updateBankTitleInfo(null, true);
                    }
                } else {
                    this.f51887d.updateBankTitleInfo(null, true);
                }
                this.f51887d.updateCardElement(this.f51889f, this.f51891h, this.f51890g, this.f51892i, this.f51893j);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public String[] a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            String[] strArr = new String[2];
            String string = ResUtils.getString(this.f51887d, "ebpay_title_complete_info_for_pay");
            if (i2 == 0) {
                string = ResUtils.getString(this.f51887d, "ebpay_title_complete_info_for_pay");
            } else if (i2 == 1) {
                string = ResUtils.getString(this.f51887d, "ebpay_title_complete_info_for_pay");
            }
            String string2 = ResUtils.getString(this.f51887d, "ebpay_pay_checkcard");
            if (i2 == 0) {
                string2 = ResUtils.getString(this.f51887d, "ebpay_pay_checkcard");
            } else if (i2 == 1) {
                string2 = ResUtils.getString(this.f51887d, "dxm_ebpay_pay_next");
            }
            strArr[0] = string;
            strArr[1] = string2;
            return strArr;
        }
        return (String[]) invokeI.objValue;
    }
}
