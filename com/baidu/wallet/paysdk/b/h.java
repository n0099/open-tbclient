package com.baidu.wallet.paysdk.b;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.core.utils.StringUtils;
/* loaded from: classes8.dex */
public class h extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PayRequest r;

    public h() {
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
        this.r = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !d() : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (com.baidu.wallet.paysdk.a.b.c() || !d()) ? "" : ResUtils.getString(this.f62618d, "wallet_bindcard_addnewcard_tip") : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b
    public void a(String... strArr) {
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, strArr) == null) {
            BindFastRequest bindFastRequest = this.f62619e;
            if (bindFastRequest != null) {
                bindFastRequest.setCalcPaymentResponse(null);
            }
            if (strArr.length > 1) {
                this.f62615a.a(strArr[0], "");
            }
            DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            if (payResponse != null && (directPayPay = payResponse.pay) != null && (easyPay = directPayPay.easypay) != null) {
                this.f62615a.a(easyPay.getService());
            }
            super.a(strArr);
        }
    }

    @Override // com.baidu.wallet.paysdk.b.b
    public void b(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, strArr) == null) {
            String userName = PayDataCache.getInstance().getUserName();
            String userId = PayDataCache.getInstance().getUserId();
            String certificateType = PayDataCache.getInstance().getCertificateType();
            UserData.UserModel userInfo = PayDataCache.getInstance().getUserInfo();
            String str = (userInfo == null || TextUtils.isEmpty(userInfo.mobile_number)) ? "" : userInfo.mobile_number;
            if (strArr.length >= 6) {
                if (k()) {
                    this.f62619e.setmCvv(strArr[0]);
                }
                if (l()) {
                    this.f62619e.setmValidDate(strArr[1].replaceAll("/", ""));
                }
                if (j()) {
                    this.f62619e.setmName(strArr[2]);
                } else if (this.f62619e.getmBankInfo() != null && this.f62619e.getmBankInfo().channel_info != null && this.f62619e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f62619e.getmBankInfo().channel_info.card_item_required.true_name)) {
                    this.f62619e.setmName(userName);
                } else {
                    this.f62619e.setmName("");
                }
                if (m()) {
                    this.f62619e.setmIdCard(strArr[3]);
                } else if (this.f62619e.getmBankInfo() != null && this.f62619e.getmBankInfo().channel_info != null && this.f62619e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f62619e.getmBankInfo().channel_info.card_item_required.certificate_code)) {
                    this.f62619e.setmIdCard(userId);
                } else {
                    this.f62619e.setmIdCard("");
                }
                if (TextUtils.isEmpty(strArr[4])) {
                    if (this.f62619e.getmBankInfo() != null && this.f62619e.getmBankInfo().channel_info != null && this.f62619e.getmBankInfo().channel_info.card_item_required != null && "1".equals(this.f62619e.getmBankInfo().channel_info.card_item_required.mobile)) {
                        this.f62619e.setmPhone(str);
                    } else {
                        this.f62619e.setmPhone("");
                    }
                } else {
                    this.f62619e.setmPhone(strArr[4].replaceAll(" ", ""));
                }
                if (m()) {
                    if (this.k) {
                        this.f62619e.setCertificateType(strArr[5]);
                    } else {
                        this.f62619e.setCertificateType("");
                    }
                } else if (this.k) {
                    this.f62619e.setCertificateType(certificateType);
                } else {
                    this.f62619e.setCertificateType("");
                }
            }
            super.b(strArr);
        }
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BindFastRequest bindFastRequest = this.f62619e;
            if (bindFastRequest != null && bindFastRequest.getmBankInfo() != null && !TextUtils.isEmpty(this.f62619e.getmBankInfo().getOneCentsDesc())) {
                return this.f62619e.getmBankInfo().getOneCentsDesc();
            }
            return super.c();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (i()) {
                return false;
            }
            if (this.f62619e.getmBindFrom() == 6 && com.baidu.wallet.paysdk.a.b.c() && !PayDataCache.getInstance().hasBondCards()) {
                return true;
            }
            if (this.f62619e.getmBindFrom() != 0 || PayDataCache.getInstance().hasMobilePwd() || PayDataCache.getInstance().getBondCards() == null || PayDataCache.getInstance().getBondCards().length > 0) {
                return super.d();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PayRequest payRequest = this.r;
            if (payRequest == null || !payRequest.showCouponListEntry()) {
                return super.e();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (!com.baidu.wallet.paysdk.a.b.b() || PayDataCache.getInstance().hasBondCards()) {
                return super.i();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public void o() {
        PayRequest payRequest;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (payRequest = this.r) == null) {
            return;
        }
        String needToPayAmount = payRequest.getNeedToPayAmount();
        String orderPrice = this.r.getOrderPrice();
        String discountAmount = this.r.getDiscountAmount();
        String randomDiscountMsg = this.r.getRandomDiscountMsg();
        boolean z = (TextUtils.isEmpty(StringUtils.fen2Yuan(discountAmount)) || StringUtils.fen2Yuan(discountAmount).equals("0.00")) ? false : true;
        SpannableString spannableString = new SpannableString(ResUtils.getString(this.f62618d, "dxm_wallet_base_unit") + StringUtils.fen2Yuan(orderPrice));
        if (z) {
            spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
        }
        String str = "-" + ResUtils.getString(this.f62618d, "dxm_wallet_base_unit") + StringUtils.fen2Yuan(discountAmount);
        if (z) {
            this.f62618d.updateDiscountTxt(this.r.getGoodsName(), spannableString, this.r.getDiscountMsg(), str, StringUtils.fen2Yuan(needToPayAmount));
        } else if (this.r.showCouponListEntry()) {
            this.f62618d.updateDiscountTxt(this.r.getGoodsName(), null, this.r.getDiscountMsg(), str, StringUtils.fen2Yuan(needToPayAmount));
        } else {
            this.f62618d.updateDiscountTxt(this.r.getGoodsName(), null, randomDiscountMsg, null, StringUtils.fen2Yuan(needToPayAmount));
        }
        this.f62618d.updateDiscountTitle(this.r.title_url);
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.a();
            BindFastRequest bindFastRequest = this.f62619e;
            if (bindFastRequest != null) {
                if (bindFastRequest.getmBankInfo() != null && this.f62619e.getmBankInfo().channel_info != null && this.f62619e.getmBankInfo().channel_info.card_item_required != null) {
                    this.f62620f = "1".equals(this.f62619e.getmBankInfo().channel_info.card_item_required.valid_code);
                    boolean z = false;
                    this.f62621g = "1".equals(this.f62619e.getmBankInfo().channel_info.card_item_required.true_name) && !g();
                    this.f62622h = "1".equals(this.f62619e.getmBankInfo().channel_info.card_item_required.valid_date);
                    this.f62623i = ("1".equals(this.f62619e.getmBankInfo().channel_info.card_item_required.certificate_code) && TextUtils.isEmpty(PayDataCache.getInstance().getUserId())) || !((!"1".equals(this.f62619e.getmBankInfo().channel_info.card_item_required.certificate_code) || TextUtils.isEmpty(PayDataCache.getInstance().getUserId()) || a(PayDataCache.getInstance().getCertificateType(), v())) && (!"1".equals(this.f62619e.getmBankInfo().channel_info.card_item_required.certificate_code) || TextUtils.isEmpty(PayDataCache.getInstance().getUserId()) || !a(PayDataCache.getInstance().getCertificateType(), v()) || a(w()) == null || "1".equals(a(w()).b())));
                    if ("1".equals(this.f62619e.getmBankInfo().channel_info.card_item_required.mobile) && (u() == null || !"1".equals(u().b()))) {
                        z = true;
                    }
                    this.f62624j = z;
                    this.k = "1".equals(this.f62619e.getmBankInfo().channel_info.card_item_required.certificate_type);
                }
                BindFastRequest bindFastRequest2 = this.f62619e;
                if (bindFastRequest2 != null && bindFastRequest2.getmBankInfo() != null && this.f62619e.getmBankInfo().channel_info != null) {
                    BindFastRequest bindFastRequest3 = this.f62619e;
                    bindFastRequest3.setCalcPaymentResponse(bindFastRequest3.getmBankInfo().channel_info.mkt_info);
                } else {
                    this.f62619e.setCalcPaymentResponse(null);
                }
                if (this.f62618d != null) {
                    if (this.f62619e.getmBankInfo() != null) {
                        this.f62618d.updateBankCouponDesc(this.f62619e.getmBankInfo().getCardInfoCouponDesc());
                        this.f62618d.updateBankTitleInfo(this.f62619e.getmBankInfo().card_info, true);
                    } else {
                        this.f62618d.updateBankTitleInfo(null, true);
                        this.f62618d.updateBankCouponDesc("");
                    }
                    BindFastRequest bindFastRequest4 = this.f62619e;
                    if (bindFastRequest4 != null && bindFastRequest4.getmBankInfo() != null) {
                        if ("11".equals(this.f62619e.getCardRequestType())) {
                            this.f62618d.updateBindCardProtocolFields(this.f62619e.getmBankInfo().protocol_platform_info);
                        } else {
                            this.f62618d.updateProtocolFields(this.f62619e.getmBankInfo().protocol_info);
                        }
                    } else {
                        this.f62618d.updateBindCardProtocolFields(null);
                        this.f62618d.updateProtocolFields(null);
                    }
                    this.f62618d.updateCardElement(this.f62620f, this.f62622h, this.f62621g, this.f62623i, this.f62624j);
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (d() || i()) ? false : true : invokeV.booleanValue;
    }

    private String[] b(int i2) {
        InterceptResult invokeI;
        Authorize authorize;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            String[] strArr = new String[2];
            String string = ResUtils.getString(this.f62618d, "bd_wallet_withhold_title");
            if (i2 == 0) {
                DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
                if (payResponse != null && (authorize = payResponse.authorize) != null && !TextUtils.isEmpty(authorize.top_title)) {
                    string = payResponse.authorize.top_title;
                } else {
                    string = ResUtils.getString(this.f62618d, "bd_wallet_withhold_title");
                }
            } else if (i2 == 1) {
                string = ResUtils.getString(this.f62618d, "bd_wallet_bind_card_second");
            }
            String string2 = ResUtils.getString(this.f62618d, "ebpay_pay_checkcard");
            if (i2 == 0) {
                string2 = ResUtils.getString(this.f62618d, "ebpay_pay_checkcard");
            } else if (i2 == 1) {
                string2 = ResUtils.getString(this.f62618d, "dxm_ebpay_pay_next");
            }
            strArr[0] = string;
            strArr[1] = string2;
            return strArr;
        }
        return (String[]) invokeI.objValue;
    }

    @Override // com.baidu.wallet.paysdk.b.b, com.baidu.wallet.paysdk.b.j
    public String[] a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (com.baidu.wallet.paysdk.a.b.a() && (PayDataCache.getInstance().getBondCards() == null || PayDataCache.getInstance().getBondCards().length <= 0)) {
                return b(i2);
            }
            if (!PayDataCache.getInstance().hasMobilePwd() && PayDataCache.getInstance().getBondCards() != null && PayDataCache.getInstance().getBondCards().length <= 0) {
                String[] strArr = new String[2];
                String string = ResUtils.getString(this.f62618d, "bd_wallet_bind_card_first_pay");
                if (i2 == 0) {
                    string = ResUtils.getString(this.f62618d, "bd_wallet_bind_card_first_pay");
                } else if (i2 == 1) {
                    string = ResUtils.getString(this.f62618d, "bd_wallet_bind_card_second");
                }
                String string2 = ResUtils.getString(this.f62618d, "ebpay_pay_checkcard");
                if (i2 == 0) {
                    string2 = ResUtils.getString(this.f62618d, "ebpay_pay_checkcard");
                } else if (i2 == 1) {
                    string2 = ResUtils.getString(this.f62618d, "dxm_ebpay_pay_next");
                }
                strArr[0] = string;
                strArr[1] = string2;
                return strArr;
            }
            return super.a(i2);
        }
        return (String[]) invokeI.objValue;
    }
}
