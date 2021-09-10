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
/* loaded from: classes8.dex */
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
                this.f62352a.a(strArr[0], "");
            }
            this.f62352a.a("find_password");
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
                    this.f62356e.setmCvv(strArr[0]);
                }
                if (l()) {
                    this.f62356e.setmValidDate(strArr[1].replaceAll("/", ""));
                }
                if (j()) {
                    this.f62356e.setmName(strArr[2]);
                } else if (this.f62356e.getmBankInfo() != null && this.f62356e.getmBankInfo().channel_info != null && this.f62356e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f62356e.getmBankInfo().channel_info.card_item_required.true_name)) {
                    this.f62356e.setmName(userName);
                } else {
                    this.f62356e.setmName("");
                }
                if (m()) {
                    this.f62356e.setmIdCard(strArr[3]);
                } else if (this.f62356e.getmBankInfo() != null && this.f62356e.getmBankInfo().channel_info != null && this.f62356e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f62356e.getmBankInfo().channel_info.card_item_required.certificate_code)) {
                    this.f62356e.setmIdCard(userId);
                } else {
                    this.f62356e.setmIdCard("");
                }
                if (TextUtils.isEmpty(strArr[4])) {
                    if (this.f62356e.getmBankInfo() != null && this.f62356e.getmBankInfo().channel_info != null && this.f62356e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f62356e.getmBankInfo().channel_info.card_item_required.mobile)) {
                        this.f62356e.setmPhone(str);
                    } else {
                        this.f62356e.setmPhone("");
                    }
                } else {
                    this.f62356e.setmPhone(strArr[4].replaceAll(" ", ""));
                }
                if (m()) {
                    if (this.k) {
                        this.f62356e.setCertificateType(strArr[5]);
                    } else {
                        this.f62356e.setCertificateType("");
                    }
                } else if (this.k) {
                    this.f62356e.setCertificateType(certificateType);
                } else {
                    this.f62356e.setCertificateType("");
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
            BindFastRequest bindFastRequest = this.f62356e;
            if (bindFastRequest != null) {
                if (bindFastRequest.getmBankInfo() != null && this.f62356e.getmBankInfo().channel_info != null && this.f62356e.getmBankInfo().channel_info.card_item_required != null) {
                    this.f62357f = "1".equals(this.f62356e.getmBankInfo().channel_info.card_item_required.valid_code);
                    boolean z = false;
                    this.f62358g = "1".equals(this.f62356e.getmBankInfo().channel_info.card_item_required.true_name) && !g();
                    this.f62359h = "1".equals(this.f62356e.getmBankInfo().channel_info.card_item_required.valid_date);
                    this.f62360i = "1".equals(this.f62356e.getmBankInfo().channel_info.card_item_required.certificate_code);
                    if ("1".equals(this.f62356e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()))) {
                        z = true;
                    }
                    this.f62361j = z;
                    this.k = "1".equals(this.f62356e.getmBankInfo().channel_info.card_item_required.certificate_type);
                }
                if (this.f62355d != null) {
                    if (this.f62356e.getmBankInfo() != null) {
                        this.f62355d.updateBankTitleInfo(this.f62356e.getmBankInfo().card_info, true);
                    } else {
                        this.f62355d.updateBankTitleInfo(null, true);
                    }
                    BindFastRequest bindFastRequest2 = this.f62356e;
                    if (bindFastRequest2 != null && bindFastRequest2.getmBankInfo() != null) {
                        this.f62355d.updateProtocolFields(this.f62356e.getmBankInfo().protocol_info);
                    } else {
                        this.f62355d.updateProtocolFields(null);
                    }
                    this.f62355d.updateCardElement(this.f62357f, this.f62359h, this.f62358g, this.f62360i, this.f62361j);
                }
            }
        }
    }
}
