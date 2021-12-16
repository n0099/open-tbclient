package com.baidu.wallet.paysdk.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.wallet.base.datamodel.UserData;
/* loaded from: classes13.dex */
public class d extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public com.baidu.wallet.paysdk.datamodel.a a(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, certificateTypeInfo)) == null) {
            return null;
        }
        return (com.baidu.wallet.paysdk.datamodel.a) invokeL.objValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b
    public void a(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, strArr) == null) {
            if (strArr.length > 1) {
                this.a.a(strArr[0], "");
            }
            this.a.a("find_password");
            super.a(strArr);
        }
    }

    @Override // com.baidu.wallet.paysdk.b.b
    public void b(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, strArr) == null) {
            String userName = PayDataCache.getInstance().getUserName();
            String userId = PayDataCache.getInstance().getUserId();
            String certificateType = PayDataCache.getInstance().getCertificateType();
            UserData.UserModel userInfo = PayDataCache.getInstance().getUserInfo();
            String str = (userInfo == null || TextUtils.isEmpty(userInfo.mobile_number)) ? "" : userInfo.mobile_number;
            if (strArr.length >= 6) {
                if (k()) {
                    this.f53946e.setmCvv(strArr[0]);
                }
                if (l()) {
                    this.f53946e.setmValidDate(strArr[1].replaceAll("/", ""));
                }
                if (j()) {
                    this.f53946e.setmName(strArr[2]);
                } else if (this.f53946e.getmBankInfo() != null && this.f53946e.getmBankInfo().channel_info != null && this.f53946e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f53946e.getmBankInfo().channel_info.card_item_required.true_name)) {
                    this.f53946e.setmName(userName);
                } else {
                    this.f53946e.setmName("");
                }
                if (m()) {
                    this.f53946e.setmIdCard(strArr[3]);
                } else if (this.f53946e.getmBankInfo() != null && this.f53946e.getmBankInfo().channel_info != null && this.f53946e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f53946e.getmBankInfo().channel_info.card_item_required.certificate_code)) {
                    this.f53946e.setmIdCard(userId);
                } else {
                    this.f53946e.setmIdCard("");
                }
                if (TextUtils.isEmpty(strArr[4])) {
                    if (this.f53946e.getmBankInfo() != null && this.f53946e.getmBankInfo().channel_info != null && this.f53946e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f53946e.getmBankInfo().channel_info.card_item_required.mobile)) {
                        this.f53946e.setmPhone(str);
                    } else {
                        this.f53946e.setmPhone("");
                    }
                } else {
                    this.f53946e.setmPhone(strArr[4].replaceAll(" ", ""));
                }
                if (m()) {
                    if (this.f53952k) {
                        this.f53946e.setCertificateType(strArr[5]);
                    } else {
                        this.f53946e.setCertificateType("");
                    }
                } else if (this.f53952k) {
                    this.f53946e.setCertificateType(certificateType);
                } else {
                    this.f53946e.setCertificateType("");
                }
            }
            super.b(strArr);
        }
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? !TextUtils.isEmpty(h()) : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public com.baidu.wallet.paysdk.datamodel.a u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (com.baidu.wallet.paysdk.datamodel.a) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.a();
            BindFastRequest bindFastRequest = this.f53946e;
            if (bindFastRequest != null) {
                if (bindFastRequest.getmBankInfo() != null && this.f53946e.getmBankInfo().channel_info != null && this.f53946e.getmBankInfo().channel_info.card_item_required != null) {
                    this.f53947f = "1".equals(this.f53946e.getmBankInfo().channel_info.card_item_required.valid_code);
                    boolean z = false;
                    this.f53948g = "1".equals(this.f53946e.getmBankInfo().channel_info.card_item_required.true_name) && !g();
                    this.f53949h = "1".equals(this.f53946e.getmBankInfo().channel_info.card_item_required.valid_date);
                    this.f53950i = "1".equals(this.f53946e.getmBankInfo().channel_info.card_item_required.certificate_code);
                    if ("1".equals(this.f53946e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()))) {
                        z = true;
                    }
                    this.f53951j = z;
                    this.f53952k = "1".equals(this.f53946e.getmBankInfo().channel_info.card_item_required.certificate_type);
                }
                if (this.f53945d != null) {
                    if (this.f53946e.getmBankInfo() != null) {
                        this.f53945d.updateBankTitleInfo(this.f53946e.getmBankInfo().card_info, true);
                    } else {
                        this.f53945d.updateBankTitleInfo(null, true);
                    }
                    BindFastRequest bindFastRequest2 = this.f53946e;
                    if (bindFastRequest2 != null && bindFastRequest2.getmBankInfo() != null) {
                        if ("11".equals(this.f53946e.getCardRequestType())) {
                            this.f53945d.updateBindCardProtocolFields(this.f53946e.getmBankInfo().protocol_platform_info);
                        } else {
                            this.f53945d.updateProtocolFields(this.f53946e.getmBankInfo().protocol_info);
                        }
                    } else {
                        this.f53945d.updateBindCardProtocolFields(null);
                        this.f53945d.updateProtocolFields(null);
                    }
                    this.f53945d.updateCardElement(this.f53947f, this.f53949h, this.f53948g, this.f53950i, this.f53951j);
                }
            }
        }
    }
}
