package com.baidu.wallet.paysdk.storage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.router.LocalRouter;
import com.dxmpay.apollon.beans.IBeanResponse;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.datamodel.UserData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class PayDataCache {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PAY_TYPE_BALANCE = "balance";
    public static final String PAY_TYPE_COMPOSITE = "composite";
    public static final String PAY_TYPE_CREDITPAY = "credit_pay";
    public static final String PAY_TYPE_EASYPAY = "easypay";
    public transient /* synthetic */ FieldHolder $fh;
    public PayResultContent a;

    /* renamed from: b  reason: collision with root package name */
    public DirectPayContentResponse f52357b;

    /* renamed from: c  reason: collision with root package name */
    public H5ResultParams f52358c;

    /* renamed from: d  reason: collision with root package name */
    public DirectPayContentResponse f52359d;

    /* renamed from: e  reason: collision with root package name */
    public DirectPayContentResponse f52360e;

    /* renamed from: f  reason: collision with root package name */
    public DirectPayContentResponse f52361f;

    /* renamed from: g  reason: collision with root package name */
    public DirectPayContentResponse f52362g;

    /* renamed from: h  reason: collision with root package name */
    public DirectPayContentResponse f52363h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52364i;

    /* renamed from: j  reason: collision with root package name */
    public String f52365j;
    public String k;
    public String l;
    public boolean m;
    public boolean n;
    public String o;
    public String[][] p;
    public final List<RestNameValuePair> q;
    public String r;
    public String s;
    public IBeanResponse t;

    /* renamed from: com.baidu.wallet.paysdk.storage.PayDataCache$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1102022795, "Lcom/baidu/wallet/paysdk/storage/PayDataCache$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1102022795, "Lcom/baidu/wallet/paysdk/storage/PayDataCache$1;");
                    return;
                }
            }
            int[] iArr = new int[PayRequestCache.BindCategory.values().length];
            a = iArr;
            try {
                iArr[PayRequestCache.BindCategory.Initiative.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PayRequestCache.BindCategory.Pwd.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static PayDataCache a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1102021307, "Lcom/baidu/wallet/paysdk/storage/PayDataCache$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1102021307, "Lcom/baidu/wallet/paysdk/storage/PayDataCache$a;");
                    return;
                }
            }
            a = new PayDataCache(null);
        }
    }

    /* loaded from: classes2.dex */
    public static class b<A, B> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final A a;

        /* renamed from: b  reason: collision with root package name */
        public final B f52366b;

        public b(A a, B b2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a, b2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a;
            this.f52366b = b2;
        }
    }

    public /* synthetic */ PayDataCache(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static PayDataCache getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a : (PayDataCache) invokeV.objValue;
    }

    public b<Boolean, String> canUseBalance() {
        InterceptResult invokeV;
        UserData.UserModel userModel;
        PayData.DirectPayPay directPayPay;
        PayData.DirectPayBalance directPayBalance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            if (directPayContentResponse != null && (directPayPay = directPayContentResponse.pay) != null && (directPayBalance = directPayPay.balance) != null) {
                return new b<>(Boolean.valueOf(directPayBalance.enough == 1), this.f52357b.pay.balance.disabled_msg);
            }
            DirectPayContentResponse directPayContentResponse2 = this.f52357b;
            if (directPayContentResponse2 != null && (userModel = directPayContentResponse2.user) != null) {
                return new b<>(Boolean.valueOf("1".equals(userModel.balance_support_status)), this.f52357b.user.balance_unsupport_reason);
            }
            return new b<>(Boolean.FALSE, "");
        }
        return (b) invokeV.objValue;
    }

    public b<Boolean, String> canUseCredit() {
        InterceptResult invokeV;
        PayData.DirectPayPay directPayPay;
        PayData.CreditPay creditPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            if (directPayContentResponse != null && (directPayPay = directPayContentResponse.pay) != null && (creditPay = directPayPay.credit_pay) != null) {
                return new b<>(Boolean.valueOf("1".equals(creditPay.status)), this.f52357b.pay.credit_pay.disable_msg);
            }
            return new b<>(Boolean.FALSE, "");
        }
        return (b) invokeV.objValue;
    }

    public boolean canUseEasypay() {
        InterceptResult invokeV;
        PayData.DirectPayPay directPayPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || directPayPay.easypay == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void cleanDetainmentDesc() {
        DirectPayContentResponse directPayContentResponse;
        PayData.DirectPayPay directPayPay;
        PayData.Detainment detainment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (directPayContentResponse = this.f52357b) == null || (directPayPay = directPayContentResponse.pay) == null || (detainment = directPayPay.detainment) == null) {
            return;
        }
        detainment.desc = "";
    }

    public boolean enableAddBondCards() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return directPayContentResponse != null && "1".equals(directPayContentResponse.can_bind_card_flag);
        }
        return invokeV.booleanValue;
    }

    public boolean enableAddBondCardsVerify() {
        InterceptResult invokeV;
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (easyPay = directPayPay.easypay) == null || !"1".equals(easyPay.can_bind_card_flag)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public String[][] getAccountBankCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.p : (String[][]) invokeV.objValue;
    }

    public String getAvailableCreditAmount() {
        InterceptResult invokeV;
        PayData.DirectPayPay directPayPay;
        PayData.CreditPay creditPay;
        PayData.CreditInfo creditInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (creditPay = directPayPay.credit_pay) == null || (creditInfo = creditPay.credit_info) == null || TextUtils.isEmpty(creditInfo.available_credit)) ? "0" : this.f52357b.pay.credit_pay.credit_info.available_credit;
        }
        return (String) invokeV.objValue;
    }

    public PayData.DirectPayBalance getBalance() {
        InterceptResult invokeV;
        PayData.DirectPayPay directPayPay;
        PayData.DirectPayBalance directPayBalance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            if (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (directPayBalance = directPayPay.balance) == null) {
                return null;
            }
            return directPayBalance;
        }
        return (PayData.DirectPayBalance) invokeV.objValue;
    }

    public String getBalanceJumpUrl() {
        InterceptResult invokeV;
        PayData.DirectPayPay directPayPay;
        PayData.DirectPayBalance directPayBalance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (directPayBalance = directPayPay.balance) == null) ? "" : directPayBalance.balance_jump_url;
        }
        return (String) invokeV.objValue;
    }

    public List<RestNameValuePair> getBalancePayPostInfo() {
        InterceptResult invokeV;
        PayData.DirectPayPay directPayPay;
        PayData.DirectPayBalance directPayBalance;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArrayList arrayList = new ArrayList();
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            if (directPayContentResponse != null && (directPayPay = directPayContentResponse.pay) != null && (directPayBalance = directPayPay.balance) != null && (map = directPayBalance.post_info) != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    arrayList.add(new RestNameValuePair(entry.getKey(), entry.getValue()));
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public String getBalanceUnSupportReason() {
        InterceptResult invokeV;
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null || !"0".equals(userModel.balance_support_status)) ? "" : this.f52357b.user.balance_unsupport_reason;
        }
        return (String) invokeV.objValue;
    }

    public CardData.BondCard[] getBondCards() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            if (directPayContentResponse != null) {
                return directPayContentResponse.getBondCards();
            }
            return null;
        }
        return (CardData.BondCard[]) invokeV.objValue;
    }

    public String getCanAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return (directPayContentResponse == null || directPayContentResponse.user == null || !hasCanAmount()) ? "" : this.f52357b.user.getCanAmount();
        }
        return (String) invokeV.objValue;
    }

    public String getCertificateType() {
        InterceptResult invokeV;
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) ? "" : userModel.certificate_type;
        }
        return (String) invokeV.objValue;
    }

    public String getCreditPayDispayName() {
        InterceptResult invokeV;
        PayData.DirectPayPay directPayPay;
        PayData.CreditPay creditPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (creditPay = directPayPay.credit_pay) == null || TextUtils.isEmpty(creditPay.display_name)) ? "" : this.f52357b.pay.credit_pay.display_name;
        }
        return (String) invokeV.objValue;
    }

    public List<RestNameValuePair> getCreditPayPostInfo() {
        InterceptResult invokeV;
        PayData.DirectPayPay directPayPay;
        PayData.CreditPay creditPay;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ArrayList arrayList = new ArrayList();
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            if (directPayContentResponse != null && (directPayPay = directPayContentResponse.pay) != null && (creditPay = directPayPay.credit_pay) != null && (map = creditPay.post_info) != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    arrayList.add(new RestNameValuePair(entry.getKey(), entry.getValue()));
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public String getDefaultPayType() {
        InterceptResult invokeV;
        PayData.DirectPayPay directPayPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            if (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null) {
                return null;
            }
            return directPayPay.default_pay_type_display;
        }
        return (String) invokeV.objValue;
    }

    public String getDetainmentDesc() {
        InterceptResult invokeV;
        PayData.DirectPayPay directPayPay;
        PayData.Detainment detainment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (detainment = directPayPay.detainment) == null) ? "" : detainment.desc;
        }
        return (String) invokeV.objValue;
    }

    public UserData.UserModel.FingerprintMsg getFingerprintMsg() {
        InterceptResult invokeV;
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            if (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null || userModel.getFingerprintMsg() == null) {
                return null;
            }
            return this.f52357b.user.getFingerprintMsg();
        }
        return (UserData.UserModel.FingerprintMsg) invokeV.objValue;
    }

    public String getFormatUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            String userName = getUserName();
            if (hasMobilePwd() || TextUtils.isEmpty(userName)) {
                return userName;
            }
            return "*" + userName.charAt(userName.length() - 1);
        }
        return (String) invokeV.objValue;
    }

    public H5ResultParams getH5ResultParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f52358c : (H5ResultParams) invokeV.objValue;
    }

    public String getInsideTransOrder() {
        InterceptResult invokeV;
        UserData.Misc misc;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return (directPayContentResponse == null || (misc = directPayContentResponse.misc) == null) ? "" : misc.getInsideTransOrder();
        }
        return (String) invokeV.objValue;
    }

    public String getOrderExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.r : (String) invokeV.objValue;
    }

    public List<RestNameValuePair> getPayPostInfo() {
        InterceptResult invokeV;
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            ArrayList arrayList = new ArrayList();
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            if (directPayContentResponse != null && (directPayPay = directPayContentResponse.pay) != null && (easyPay = directPayPay.easypay) != null && (map = easyPay.post_info) != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    arrayList.add(new RestNameValuePair(entry.getKey(), entry.getValue()));
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public DirectPayContentResponse getPayResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f52357b : (DirectPayContentResponse) invokeV.objValue;
    }

    public String getPaySessionInfo() {
        InterceptResult invokeV;
        PayData.DirectPayPay directPayPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || TextUtils.isEmpty(directPayPay.session_info)) ? "" : this.f52357b.pay.session_info;
        }
        return (String) invokeV.objValue;
    }

    public PayResultContent getPayStateContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.a : (PayResultContent) invokeV.objValue;
    }

    public List<RestNameValuePair> getPrePayRequestParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.q : (List) invokeV.objValue;
    }

    public String getPureSign() {
        InterceptResult invokeV;
        Authorize authorize;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return (directPayContentResponse == null || (authorize = directPayContentResponse.authorize) == null || TextUtils.isEmpty(authorize.pure_sign)) ? "" : this.f52357b.authorize.pure_sign;
        }
        return (String) invokeV.objValue;
    }

    public String getRemotePayHostName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f52365j : (String) invokeV.objValue;
    }

    public String getRemotePkg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public String getRemoteWhereToBackAct() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public String getSelectedCardNo() {
        InterceptResult invokeV;
        PayData.DirectPayPay directPayPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || TextUtils.isEmpty(directPayPay.selected_card_no)) ? "" : this.f52357b.pay.selected_card_no;
        }
        return (String) invokeV.objValue;
    }

    public String getSellerUserId() {
        InterceptResult invokeV;
        UserData.SP sp;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return (directPayContentResponse == null || (sp = directPayContentResponse.sp) == null) ? "" : sp.getSellerUserId();
        }
        return (String) invokeV.objValue;
    }

    public List<RestNameValuePair> getSessionData() {
        InterceptResult invokeV;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            ArrayList arrayList = new ArrayList();
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            if (directPayContentResponse != null && (map = directPayContentResponse.cashdesk) != null && map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    arrayList.add(new RestNameValuePair(entry.getKey(), entry.getValue()));
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public String getSignSuccessTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public String getSpGoodsName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return directPayContentResponse != null ? directPayContentResponse.getSpGoodsName() : "";
        }
        return (String) invokeV.objValue;
    }

    public String getSpName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return directPayContentResponse != null ? directPayContentResponse.getSpName() : "";
        }
        return (String) invokeV.objValue;
    }

    public String getTotalBalance() {
        InterceptResult invokeV;
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) ? "0" : userModel.getCanAmount();
        }
        return (String) invokeV.objValue;
    }

    public IBeanResponse getTransferAccountConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.t : (IBeanResponse) invokeV.objValue;
    }

    public String getUserId() {
        InterceptResult invokeV;
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) ? "" : userModel.certificate_code;
        }
        return (String) invokeV.objValue;
    }

    public UserData.UserModel getUserInfo() {
        InterceptResult invokeV;
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            if (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) {
                return null;
            }
            return userModel;
        }
        return (UserData.UserModel) invokeV.objValue;
    }

    public String getUserName() {
        InterceptResult invokeV;
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) ? "" : userModel.true_name;
        }
        return (String) invokeV.objValue;
    }

    public String getmWxAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public boolean hasBondCards() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            if (directPayContentResponse != null) {
                return directPayContentResponse.hasBindCards();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasCanAmount() {
        InterceptResult invokeV;
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            if (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) {
                return false;
            }
            return userModel.hasCanAmount();
        }
        return invokeV.booleanValue;
    }

    public boolean hasCreditPay() {
        InterceptResult invokeV;
        PayData.DirectPayPay directPayPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || directPayPay.credit_pay == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean hasEnableCardsForFindPWD() {
        InterceptResult invokeV;
        CardData.BondCard[] enableCardsForFindPWD;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return (directPayContentResponse == null || (enableCardsForFindPWD = directPayContentResponse.getEnableCardsForFindPWD()) == null || enableCardsForFindPWD.length <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean hasMobilePwd() {
        InterceptResult invokeV;
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            if (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) {
                return false;
            }
            return userModel.hasMobilePwd();
        }
        return invokeV.booleanValue;
    }

    public boolean isBalanceEnough() {
        InterceptResult invokeV;
        PayData.DirectPayPay directPayPay;
        PayData.DirectPayBalance directPayBalance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52363h;
            return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (directPayBalance = directPayPay.balance) == null || directPayBalance.enough != 1) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean isBalanceSupport() {
        InterceptResult invokeV;
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            if (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) {
                return false;
            }
            return userModel.isSupportBalance();
        }
        return invokeV.booleanValue;
    }

    public boolean isFromPreCashier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public boolean isPassFree() {
        InterceptResult invokeV;
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            if (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) {
                return false;
            }
            return "0".equals(userModel.need_pay_password);
        }
        return invokeV.booleanValue;
    }

    public boolean isPaySettingOpenFingerprintPay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean isRemotePay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.f52364i : invokeV.booleanValue;
    }

    public boolean isShowCreditPay() {
        InterceptResult invokeV;
        PayData.DirectPayPay directPayPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || directPayPay.credit_pay == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowDetection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            if (LocalRouter.getInstance(BaiduWalletDelegate.getInstance().getAppContext()).isProviderExisted("bankdetection")) {
                DirectPayContentResponse directPayContentResponse = this.f52357b;
                return directPayContentResponse == null || !"0".equals(directPayContentResponse.bank_card_detect_enabled);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean needCalcPayment() {
        InterceptResult invokeV;
        UserData.SP sp;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            if (directPayContentResponse == null || (sp = directPayContentResponse.sp) == null) {
                return false;
            }
            return !TextUtils.isEmpty(sp.seller_user_id);
        }
        return invokeV.booleanValue;
    }

    public boolean oneKeyPayForCredit() {
        InterceptResult invokeV;
        PayData.DirectPayPay directPayPay;
        PayData.CreditPay creditPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            DirectPayContentResponse directPayContentResponse = this.f52357b;
            if (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (creditPay = directPayPay.credit_pay) == null) {
                return false;
            }
            return "1".equals(creditPay.status);
        }
        return invokeV.booleanValue;
    }

    public void resetFromPrecashier() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            this.m = false;
        }
    }

    public void setAccountBankCard(String[][] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, strArr) == null) {
            this.p = strArr;
        }
    }

    public void setCurrentPayRequest(PayRequestCache.BindCategory bindCategory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, bindCategory) == null) {
            int i2 = AnonymousClass1.a[bindCategory.ordinal()];
            if (i2 == 1) {
                this.f52357b = this.f52360e;
            } else if (i2 != 2) {
                this.f52357b = this.f52362g;
            } else {
                this.f52357b = this.f52359d;
            }
        }
    }

    public void setFromPreCashier() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            this.m = true;
        }
    }

    public void setH5ResultParams(H5ResultParams h5ResultParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, h5ResultParams) == null) {
            this.f52358c = h5ResultParams;
        }
    }

    public void setHasPwd() {
        DirectPayContentResponse directPayContentResponse;
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048641, this) == null) || (directPayContentResponse = this.f52357b) == null || (userModel = directPayContentResponse.user) == null) {
            return;
        }
        userModel.setHasMobilePwd();
    }

    public void setIsRemotePay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.f52364i = z;
        }
    }

    public void setOrderExtraInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, str) == null) {
            this.r = str;
        }
    }

    public void setPayReslutContent(PayResultContent payResultContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, payResultContent) == null) {
            this.a = payResultContent;
        }
    }

    public void setPayResponse(DirectPayContentResponse directPayContentResponse) {
        PayData.DirectPayPay directPayPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, directPayContentResponse) == null) {
            if (directPayContentResponse instanceof CardAddResponse) {
                int i2 = ((CardAddResponse) directPayContentResponse).request_type;
                if (4 == i2) {
                    this.f52359d = directPayContentResponse;
                } else if (11 == i2) {
                    this.f52360e = directPayContentResponse;
                } else if (12 == i2) {
                    this.f52361f = directPayContentResponse;
                } else {
                    this.f52362g = directPayContentResponse;
                }
            } else {
                this.f52362g = directPayContentResponse;
            }
            this.f52357b = directPayContentResponse;
            if (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || directPayPay.balance == null) {
                return;
            }
            this.f52363h = directPayContentResponse;
        }
    }

    public void setPaySettingOpenFingerprintPay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            this.n = z;
        }
    }

    public void setPrePayRequestParams(List<RestNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, list) == null) {
            this.q.clear();
            this.q.addAll(list);
        }
    }

    public void setRemotePayHostName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, str) == null) {
            this.f52365j = str;
        }
    }

    public void setRemotePkg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, str) == null) {
            this.k = str;
        }
    }

    public void setRemoteWhereToBackAct(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, str) == null) {
            this.l = str;
        }
    }

    public void setSessionData(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048651, this, map) == null) || this.f52357b == null || map == null || map.size() <= 0) {
            return;
        }
        this.f52357b.cashdesk = map;
    }

    public void setSignSuccessTips(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, str) == null) {
            this.o = str;
        }
    }

    public void setTransferAccountConfig(IBeanResponse iBeanResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, iBeanResponse) == null) {
            this.t = iBeanResponse;
        }
    }

    public void setmWxAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, str) == null) {
            this.s = str;
        }
    }

    public PayDataCache() {
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
        this.f52364i = false;
        this.m = false;
        this.n = false;
        this.o = "";
        this.q = new ArrayList();
    }
}
