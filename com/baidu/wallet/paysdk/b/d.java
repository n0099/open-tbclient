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
/* loaded from: classes12.dex */
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
                    this.f53366e.setmCvv(strArr[0]);
                }
                if (l()) {
                    this.f53366e.setmValidDate(strArr[1].replaceAll("/", ""));
                }
                if (j()) {
                    this.f53366e.setmName(strArr[2]);
                } else if (this.f53366e.getmBankInfo() != null && this.f53366e.getmBankInfo().channel_info != null && this.f53366e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f53366e.getmBankInfo().channel_info.card_item_required.true_name)) {
                    this.f53366e.setmName(userName);
                } else {
                    this.f53366e.setmName("");
                }
                if (m()) {
                    this.f53366e.setmIdCard(strArr[3]);
                } else if (this.f53366e.getmBankInfo() != null && this.f53366e.getmBankInfo().channel_info != null && this.f53366e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f53366e.getmBankInfo().channel_info.card_item_required.certificate_code)) {
                    this.f53366e.setmIdCard(userId);
                } else {
                    this.f53366e.setmIdCard("");
                }
                if (TextUtils.isEmpty(strArr[4])) {
                    if (this.f53366e.getmBankInfo() != null && this.f53366e.getmBankInfo().channel_info != null && this.f53366e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f53366e.getmBankInfo().channel_info.card_item_required.mobile)) {
                        this.f53366e.setmPhone(str);
                    } else {
                        this.f53366e.setmPhone("");
                    }
                } else {
                    this.f53366e.setmPhone(strArr[4].replaceAll(" ", ""));
                }
                if (m()) {
                    if (this.f53372k) {
                        this.f53366e.setCertificateType(strArr[5]);
                    } else {
                        this.f53366e.setCertificateType("");
                    }
                } else if (this.f53372k) {
                    this.f53366e.setCertificateType(certificateType);
                } else {
                    this.f53366e.setCertificateType("");
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
            BindFastRequest bindFastRequest = this.f53366e;
            if (bindFastRequest != null) {
                if (bindFastRequest.getmBankInfo() != null && this.f53366e.getmBankInfo().channel_info != null && this.f53366e.getmBankInfo().channel_info.card_item_required != null) {
                    this.f53367f = "1".equals(this.f53366e.getmBankInfo().channel_info.card_item_required.valid_code);
                    boolean z = false;
                    this.f53368g = "1".equals(this.f53366e.getmBankInfo().channel_info.card_item_required.true_name) && !g();
                    this.f53369h = "1".equals(this.f53366e.getmBankInfo().channel_info.card_item_required.valid_date);
                    this.f53370i = "1".equals(this.f53366e.getmBankInfo().channel_info.card_item_required.certificate_code);
                    if ("1".equals(this.f53366e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()))) {
                        z = true;
                    }
                    this.f53371j = z;
                    this.f53372k = "1".equals(this.f53366e.getmBankInfo().channel_info.card_item_required.certificate_type);
                }
                if (this.f53365d != null) {
                    if (this.f53366e.getmBankInfo() != null) {
                        this.f53365d.updateBankTitleInfo(this.f53366e.getmBankInfo().card_info, true);
                    } else {
                        this.f53365d.updateBankTitleInfo(null, true);
                    }
                    BindFastRequest bindFastRequest2 = this.f53366e;
                    if (bindFastRequest2 != null && bindFastRequest2.getmBankInfo() != null) {
                        if ("11".equals(this.f53366e.getCardRequestType())) {
                            this.f53365d.updateBindCardProtocolFields(this.f53366e.getmBankInfo().protocol_platform_info);
                        } else {
                            this.f53365d.updateProtocolFields(this.f53366e.getmBankInfo().protocol_info);
                        }
                    } else {
                        this.f53365d.updateBindCardProtocolFields(null);
                        this.f53365d.updateProtocolFields(null);
                    }
                    this.f53365d.updateCardElement(this.f53367f, this.f53369h, this.f53368g, this.f53370i, this.f53371j);
                }
            }
        }
    }
}
