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
/* loaded from: classes13.dex */
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
                    this.f53949e.setmCvv(strArr[0]);
                }
                if (l()) {
                    this.f53949e.setmValidDate(strArr[1].replaceAll("/", ""));
                }
                if (j()) {
                    this.f53949e.setmName(strArr[2]);
                } else if (this.f53949e.getmBankInfo() != null && this.f53949e.getmBankInfo().channel_info != null && this.f53949e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f53949e.getmBankInfo().channel_info.card_item_required.true_name)) {
                    this.f53949e.setmName(userName);
                } else {
                    this.f53949e.setmName("");
                }
                if (m()) {
                    this.f53949e.setmIdCard(strArr[3]);
                } else if (this.f53949e.getmBankInfo() != null && this.f53949e.getmBankInfo().channel_info != null && this.f53949e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f53949e.getmBankInfo().channel_info.card_item_required.certificate_code)) {
                    this.f53949e.setmIdCard(userId);
                } else {
                    this.f53949e.setmIdCard("");
                }
                if (TextUtils.isEmpty(strArr[4])) {
                    if (this.f53949e.getmBankInfo() != null && this.f53949e.getmBankInfo().channel_info != null && this.f53949e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f53949e.getmBankInfo().channel_info.card_item_required.mobile)) {
                        this.f53949e.setmPhone(str);
                    } else {
                        this.f53949e.setmPhone("");
                    }
                } else {
                    this.f53949e.setmPhone(strArr[4].replaceAll(" ", ""));
                }
                if (m()) {
                    if (this.f53955k) {
                        this.f53949e.setCertificateType(strArr[5]);
                    } else {
                        this.f53949e.setCertificateType("");
                    }
                } else if (this.f53955k) {
                    this.f53949e.setCertificateType(certificateType);
                } else {
                    this.f53949e.setCertificateType("");
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
            BindFastRequest bindFastRequest = this.f53949e;
            if (bindFastRequest != null && bindFastRequest.getmBankInfo() != null && !TextUtils.isEmpty(this.f53949e.getmBankInfo().getOneCentsDesc())) {
                return this.f53949e.getmBankInfo().getOneCentsDesc();
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
            BindFastRequest bindFastRequest = this.f53949e;
            if (bindFastRequest != null && bindFastRequest.getmBankInfo() != null && this.f53949e.getmBankInfo().channel_info != null && this.f53949e.getmBankInfo().channel_info.card_item_required != null) {
                this.f53950f = "1".equals(this.f53949e.getmBankInfo().channel_info.card_item_required.valid_code);
                boolean z = false;
                this.f53951g = "1".equals(this.f53949e.getmBankInfo().channel_info.card_item_required.true_name) && !g();
                this.f53952h = "1".equals(this.f53949e.getmBankInfo().channel_info.card_item_required.valid_date);
                this.f53953i = ("1".equals(this.f53949e.getmBankInfo().channel_info.card_item_required.certificate_code) && TextUtils.isEmpty(PayDataCache.getInstance().getUserId())) || !((!"1".equals(this.f53949e.getmBankInfo().channel_info.card_item_required.certificate_code) || TextUtils.isEmpty(PayDataCache.getInstance().getUserId()) || a(PayDataCache.getInstance().getCertificateType(), v())) && (!"1".equals(this.f53949e.getmBankInfo().channel_info.card_item_required.certificate_code) || TextUtils.isEmpty(PayDataCache.getInstance().getUserId()) || !a(PayDataCache.getInstance().getCertificateType(), v()) || a(w()) == null || "1".equals(a(w()).b())));
                if ("1".equals(this.f53949e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()))) {
                    z = true;
                }
                this.f53954j = z;
                this.f53955k = "1".equals(this.f53949e.getmBankInfo().channel_info.card_item_required.certificate_type);
            }
            if (this.f53948d != null) {
                BindFastRequest bindFastRequest2 = this.f53949e;
                if (bindFastRequest2 != null && bindFastRequest2.getmBankInfo() != null) {
                    this.f53948d.updateBankTitleInfo(this.f53949e.getmBankInfo().card_info, true);
                } else {
                    this.f53948d.updateBankTitleInfo(null, true);
                }
                BindFastRequest bindFastRequest3 = this.f53949e;
                if (bindFastRequest3 != null && bindFastRequest3.getmBankInfo() != null) {
                    if ("11".equals(this.f53949e.getCardRequestType())) {
                        this.f53948d.updateBindCardProtocolFields(this.f53949e.getmBankInfo().protocol_platform_info);
                    } else {
                        this.f53948d.updateProtocolFields(this.f53949e.getmBankInfo().protocol_info);
                    }
                } else {
                    this.f53948d.updateBindCardProtocolFields(null);
                    this.f53948d.updateProtocolFields(null);
                }
                this.f53948d.updateCardElement(this.f53950f, this.f53952h, this.f53951g, this.f53953i, this.f53954j);
            }
        }
    }
}
