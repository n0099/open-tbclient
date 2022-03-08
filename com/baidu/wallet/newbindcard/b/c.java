package com.baidu.wallet.newbindcard.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.newbindcard.ui.NewBindCardMainActivity;
import com.baidu.wallet.newbindcard.ui.NewCheckSmsActivity;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.g;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.datamodel.CheckCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Map;
/* loaded from: classes6.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public BindFastRequest f50379c;

    /* renamed from: d  reason: collision with root package name */
    public String f50380d;

    /* renamed from: e  reason: collision with root package name */
    public GetCardInfoResponse.CardItemRequired f50381e;

    /* renamed from: f  reason: collision with root package name */
    public CardAddResponse f50382f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(NewBindCardMainActivity newBindCardMainActivity) {
        super(newBindCardMainActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newBindCardMainActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((NewBindCardMainActivity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.wallet.newbindcard.b.a
    public void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            BindFastRequest bindReq = NewBindCardEntry.getInstance().getBindReq();
            this.f50379c = bindReq;
            if (bindReq == null) {
                NewBindCardEntry.getInstance().newBindCardCallback(StatHelper.SENSOR_ERR_2, "NewBindCardMainActivity bindFastRequest is null", false);
                this.f50371b.finishWithoutAnim();
                return;
            }
            CardAddResponse cardAddResponse = CardAddResponse.getInstance();
            this.f50382f = cardAddResponse;
            if (cardAddResponse == null) {
                NewBindCardEntry.getInstance().newBindCardCallback(StatHelper.SENSOR_ERR_2, "NewBindCardMainActivity mCardAddResponse is null", false);
                this.f50371b.finishWithoutAnim();
                return;
            }
            if (this.f50379c.getmBankInfo() != null && this.f50379c.getmBankInfo().channel_info != null) {
                this.f50381e = this.f50379c.getmBankInfo().channel_info.card_item_required;
            }
            this.f50380d = this.f50371b.getIntent().getStringExtra(NewBindCardMainActivity.BIND_CARD_NUMBER);
        }
    }

    @Override // com.baidu.wallet.newbindcard.b.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            BindFastRequest bindFastRequest = this.f50379c;
            if (bindFastRequest != null && bindFastRequest.getmBankInfo() != null) {
                GetCardInfoResponse.CardInfo cardInfo = this.f50379c.getmBankInfo().card_info;
                if (cardInfo != null && !TextUtils.isEmpty(cardInfo.bank_logourl) && !TextUtils.isEmpty(cardInfo.bank_name) && !TextUtils.isEmpty(cardInfo.type_name)) {
                    this.f50371b.initBankCardInfo(cardInfo.bank_logourl, cardInfo.bank_name, cardInfo.type_name);
                    return;
                } else {
                    this.f50371b.initBankCardInfo(null, null, null);
                    return;
                }
            }
            this.f50371b.initBankCardInfo(null, null, null);
        }
    }

    @Override // com.baidu.wallet.newbindcard.b.a
    public void c() {
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            CardAddResponse cardAddResponse = this.f50382f;
            if (cardAddResponse != null && (userModel = cardAddResponse.user) != null) {
                this.f50371b.initBindCardUi(userModel.true_name, userModel.display_flag);
            } else {
                this.f50371b.initBindCardUi(null, null);
            }
        }
    }

    @Override // com.baidu.wallet.newbindcard.b.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            BindFastRequest bindFastRequest = this.f50379c;
            if (bindFastRequest != null && bindFastRequest.getmBankInfo() != null && this.f50379c.getmBankInfo().channel_info != null) {
                this.f50371b.initCardDateAndCvv2(this.f50379c.getmBankInfo().channel_info.card_item_required);
                return;
            }
            this.f50371b.initCardDateAndCvv2(null);
        }
    }

    @Override // com.baidu.wallet.newbindcard.b.a
    public void e() {
        BindFastRequest bindFastRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            CardAddResponse cardAddResponse = this.f50382f;
            if (cardAddResponse != null && cardAddResponse.user != null && (bindFastRequest = this.f50379c) != null && bindFastRequest.getmBankInfo() != null && this.f50379c.getmBankInfo().channel_info != null && this.f50379c.getmBankInfo().channel_info.certificate_type_info != null && this.f50379c.getmBankInfo().channel_info.certificate_type_info.length > 0) {
                this.f50371b.setCertificateType(this.f50382f.user.certificate_type, this.f50379c.getmBankInfo().channel_info.certificate_type_info);
            } else {
                this.f50371b.setCertificateType(null, null);
            }
        }
    }

    @Override // com.baidu.wallet.newbindcard.b.a
    public void f() {
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            CardAddResponse cardAddResponse = this.f50382f;
            if (cardAddResponse != null && (userModel = cardAddResponse.user) != null && !TextUtils.isEmpty(userModel.certificate_code)) {
                this.f50371b.setCertificateCode(this.f50382f.user.certificate_code);
            } else {
                this.f50371b.setCertificateCode(null);
            }
        }
    }

    @Override // com.baidu.wallet.newbindcard.b.a
    public void g() {
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            CardAddResponse cardAddResponse = this.f50382f;
            if (cardAddResponse != null && (userModel = cardAddResponse.user) != null && !TextUtils.isEmpty(userModel.mobile)) {
                this.f50371b.setUserPhone(this.f50382f.user.mobile);
            } else {
                this.f50371b.setUserPhone(null);
            }
        }
    }

    @Override // com.baidu.wallet.newbindcard.b.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            BindFastRequest bindFastRequest = this.f50379c;
            if (bindFastRequest != null && bindFastRequest.getmBankInfo() != null && this.f50379c.getmBankInfo().protocol_platform_info != null) {
                this.f50371b.setBindCardProtocol(this.f50379c.getmBankInfo().protocol_platform_info);
            } else {
                this.f50371b.setBindCardProtocol(null);
            }
        }
    }

    @Override // com.baidu.wallet.newbindcard.b.a
    public void i() {
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            CardAddResponse cardAddResponse = this.f50382f;
            if (cardAddResponse != null && (userModel = cardAddResponse.user) != null) {
                this.f50371b.setPhoneTip(userModel.mobile, userModel.has_mobile_password);
            } else {
                this.f50371b.setPhoneTip(null, 0);
            }
        }
    }

    @Override // com.baidu.wallet.newbindcard.b.a
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f50379c = null;
            this.f50381e = null;
            this.f50380d = null;
            this.f50382f = null;
            super.j();
        }
    }

    @Override // com.baidu.wallet.newbindcard.b.a
    public void a(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, obj, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this.f50371b, -2);
            if (i2 == 5) {
                CheckCardInfoResponse checkCardInfoResponse = (CheckCardInfoResponse) obj;
                int i3 = 0;
                this.f50379c.setmNeedSms((1 == checkCardInfoResponse.send_sms_by_bfb || "1".equals(checkCardInfoResponse.need_verify_sms)) ? 1 : 1);
                Map<String, String> map = checkCardInfoResponse.cashdesk;
                if (map != null && map.size() > 0) {
                    PayDataCache.getInstance().setSessionData(checkCardInfoResponse.cashdesk);
                }
                if (!TextUtils.isEmpty(checkCardInfoResponse.channel_no)) {
                    this.f50379c.setChannelNo(checkCardInfoResponse.channel_no);
                }
                this.f50379c.setRegEx(checkCardInfoResponse.sms_pattern);
                this.f50379c.setSmsLength(checkCardInfoResponse.sms_length);
                this.f50379c.setSmsType(checkCardInfoResponse.sms_type);
                this.f50379c.setSendSmsphone(checkCardInfoResponse.send_sms_phone);
                this.f50371b.startActivityWithoutAnim(new Intent(this.f50371b, NewCheckSmsActivity.class));
            }
        }
    }

    @Override // com.baidu.wallet.newbindcard.b.a
    public void a(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this.f50371b, -2);
            this.f50371b.handleFailure(i2, i3, str);
        }
    }

    @Override // com.baidu.wallet.newbindcard.b.a
    public void a() {
        NewBindCardMainActivity newBindCardMainActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (newBindCardMainActivity = this.f50371b) == null) {
            return;
        }
        newBindCardMainActivity.setFlagActiveBindCard();
    }

    @Override // com.baidu.wallet.newbindcard.b.a
    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            WalletGlobalUtils.safeShowDialog(this.f50371b, -2, "");
            g gVar = (g) PayBeanFactory.getInstance().getBean((Context) this.f50371b, 5, NewBindCardMainActivity.BEAN_TAG);
            BindFastRequest bindFastRequest = this.f50379c;
            if (bindFastRequest != null) {
                bindFastRequest.setmBankCard(this.f50380d);
                GetCardInfoResponse.CardItemRequired cardItemRequired = this.f50381e;
                if (cardItemRequired != null) {
                    if ("1".equals(cardItemRequired.true_name)) {
                        this.f50379c.setmName(str);
                    } else {
                        this.f50379c.setmName("");
                    }
                    if ("1".equals(this.f50381e.certificate_type)) {
                        this.f50379c.setCertificateType(str2);
                    } else {
                        this.f50379c.setCertificateType("");
                    }
                    if ("1".equals(this.f50381e.certificate_code)) {
                        this.f50379c.setmIdCard(str3);
                    } else {
                        this.f50379c.setmIdCard("");
                    }
                    if ("1".equals(this.f50381e.mobile)) {
                        this.f50379c.setmPhone(str4);
                    } else {
                        this.f50379c.setmPhone("");
                    }
                    if ("1".equals(this.f50381e.valid_date)) {
                        this.f50379c.setmValidDate(str5);
                    } else {
                        this.f50379c.setmValidDate("");
                    }
                    if ("1".equals(this.f50381e.valid_code)) {
                        this.f50379c.setmCvv(str6);
                    } else {
                        this.f50379c.setmCvv("");
                    }
                }
            }
            gVar.a(this.f50379c);
            gVar.setResponseCallback(this);
            gVar.execBean();
        }
    }
}
