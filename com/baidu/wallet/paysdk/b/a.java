package com.baidu.wallet.paysdk.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.wallet.base.datamodel.UserData;
/* loaded from: classes2.dex */
public class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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
                this.a.a(strArr[0], "");
            }
            this.a.a(QueryResponse.Options.BIND_CARD);
            super.a(strArr);
        }
    }

    @Override // com.baidu.wallet.paysdk.b.b
    public void b(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr) == null) {
            String userName = PayDataCache.getInstance().getUserName();
            String userId = PayDataCache.getInstance().getUserId();
            String certificateType = PayDataCache.getInstance().getCertificateType();
            UserData.UserModel userInfo = PayDataCache.getInstance().getUserInfo();
            String str = (userInfo == null || TextUtils.isEmpty(userInfo.mobile_number)) ? "" : userInfo.mobile_number;
            if (strArr.length >= 6) {
                if (k()) {
                    this.f52100e.setmCvv(strArr[0]);
                }
                if (l()) {
                    this.f52100e.setmValidDate(strArr[1].replaceAll("/", ""));
                }
                if (j()) {
                    this.f52100e.setmName(strArr[2]);
                } else if (this.f52100e.getmBankInfo() != null && this.f52100e.getmBankInfo().channel_info != null && this.f52100e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f52100e.getmBankInfo().channel_info.card_item_required.true_name)) {
                    this.f52100e.setmName(userName);
                } else {
                    this.f52100e.setmName("");
                }
                if (m()) {
                    this.f52100e.setmIdCard(strArr[3]);
                } else if (this.f52100e.getmBankInfo() != null && this.f52100e.getmBankInfo().channel_info != null && this.f52100e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f52100e.getmBankInfo().channel_info.card_item_required.certificate_code)) {
                    this.f52100e.setmIdCard(userId);
                } else {
                    this.f52100e.setmIdCard("");
                }
                if (TextUtils.isEmpty(strArr[4])) {
                    if (this.f52100e.getmBankInfo() != null && this.f52100e.getmBankInfo().channel_info != null && this.f52100e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f52100e.getmBankInfo().channel_info.card_item_required.mobile)) {
                        this.f52100e.setmPhone(str);
                    } else {
                        this.f52100e.setmPhone("");
                    }
                } else {
                    this.f52100e.setmPhone(strArr[4].replaceAll(" ", ""));
                }
                if (m()) {
                    if (this.k) {
                        this.f52100e.setCertificateType(strArr[5]);
                    } else {
                        this.f52100e.setCertificateType("");
                    }
                } else if (this.k) {
                    this.f52100e.setCertificateType(certificateType);
                } else {
                    this.f52100e.setCertificateType("");
                }
            }
            super.b(strArr);
        }
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BindFastRequest bindFastRequest = this.f52100e;
            if (bindFastRequest != null && bindFastRequest.getmBankInfo() != null && !TextUtils.isEmpty(this.f52100e.getmBankInfo().getOneCentsDesc())) {
                return this.f52100e.getmBankInfo().getOneCentsDesc();
            }
            return super.c();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            BindFastRequest bindFastRequest = this.f52100e;
            if (bindFastRequest != null && bindFastRequest.getmBankInfo() != null && this.f52100e.getmBankInfo().channel_info != null && this.f52100e.getmBankInfo().channel_info.card_item_required != null) {
                this.f52101f = "1".equals(this.f52100e.getmBankInfo().channel_info.card_item_required.valid_code);
                boolean z = false;
                this.f52102g = "1".equals(this.f52100e.getmBankInfo().channel_info.card_item_required.true_name) && !g();
                this.f52103h = "1".equals(this.f52100e.getmBankInfo().channel_info.card_item_required.valid_date);
                this.f52104i = ("1".equals(this.f52100e.getmBankInfo().channel_info.card_item_required.certificate_code) && TextUtils.isEmpty(PayDataCache.getInstance().getUserId())) || !((!"1".equals(this.f52100e.getmBankInfo().channel_info.card_item_required.certificate_code) || TextUtils.isEmpty(PayDataCache.getInstance().getUserId()) || a(PayDataCache.getInstance().getCertificateType(), v())) && (!"1".equals(this.f52100e.getmBankInfo().channel_info.card_item_required.certificate_code) || TextUtils.isEmpty(PayDataCache.getInstance().getUserId()) || !a(PayDataCache.getInstance().getCertificateType(), v()) || a(w()) == null || "1".equals(a(w()).b())));
                if ("1".equals(this.f52100e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()))) {
                    z = true;
                }
                this.f52105j = z;
                this.k = "1".equals(this.f52100e.getmBankInfo().channel_info.card_item_required.certificate_type);
            }
            if (this.f52099d != null) {
                BindFastRequest bindFastRequest2 = this.f52100e;
                if (bindFastRequest2 != null && bindFastRequest2.getmBankInfo() != null) {
                    this.f52099d.updateBankTitleInfo(this.f52100e.getmBankInfo().card_info, true);
                } else {
                    this.f52099d.updateBankTitleInfo(null, true);
                }
                BindFastRequest bindFastRequest3 = this.f52100e;
                if (bindFastRequest3 != null && bindFastRequest3.getmBankInfo() != null) {
                    if ("11".equals(this.f52100e.getCardRequestType())) {
                        this.f52099d.updateBindCardProtocolFields(this.f52100e.getmBankInfo().protocol_platform_info);
                    } else {
                        this.f52099d.updateProtocolFields(this.f52100e.getmBankInfo().protocol_info);
                    }
                } else {
                    this.f52099d.updateBindCardProtocolFields(null);
                    this.f52099d.updateProtocolFields(null);
                }
                this.f52099d.updateCardElement(this.f52101f, this.f52103h, this.f52102g, this.f52104i, this.f52105j);
            }
        }
    }
}
