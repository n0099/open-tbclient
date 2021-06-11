package com.baidu.wallet.paysdk.storage;

import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.router.LocalRouter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class PayDataCache {
    public static final String PAY_TYPE_BALANCE = "balance";
    public static final String PAY_TYPE_COMPOSITE = "composite";
    public static final String PAY_TYPE_CREDITPAY = "credit_pay";
    public static final String PAY_TYPE_EASYPAY = "easypay";

    /* renamed from: a  reason: collision with root package name */
    public PayResultContent f25588a;

    /* renamed from: b  reason: collision with root package name */
    public DirectPayContentResponse f25589b;

    /* renamed from: c  reason: collision with root package name */
    public H5ResultParams f25590c;

    /* renamed from: d  reason: collision with root package name */
    public DirectPayContentResponse f25591d;

    /* renamed from: e  reason: collision with root package name */
    public DirectPayContentResponse f25592e;

    /* renamed from: f  reason: collision with root package name */
    public DirectPayContentResponse f25593f;

    /* renamed from: g  reason: collision with root package name */
    public DirectPayContentResponse f25594g;

    /* renamed from: h  reason: collision with root package name */
    public DirectPayContentResponse f25595h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f25596i;
    public String j;
    public String k;
    public String l;
    public boolean m;
    public String n;
    public String[][] o;
    public final List<RestNameValuePair> p;
    public String q;
    public IBeanResponse r;

    /* renamed from: com.baidu.wallet.paysdk.storage.PayDataCache$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25597a;

        static {
            int[] iArr = new int[PayRequestCache.BindCategory.values().length];
            f25597a = iArr;
            try {
                iArr[PayRequestCache.BindCategory.Initiative.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25597a[PayRequestCache.BindCategory.Pwd.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static PayDataCache f25598a = new PayDataCache(null);
    }

    /* loaded from: classes5.dex */
    public static class b<A, B> {

        /* renamed from: a  reason: collision with root package name */
        public final A f25599a;

        /* renamed from: b  reason: collision with root package name */
        public final B f25600b;

        public b(A a2, B b2) {
            this.f25599a = a2;
            this.f25600b = b2;
        }
    }

    public /* synthetic */ PayDataCache(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static PayDataCache getInstance() {
        return a.f25598a;
    }

    public b<Boolean, String> canUseBalance() {
        UserData.UserModel userModel;
        PayData.DirectPayPay directPayPay;
        PayData.DirectPayBalance directPayBalance;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        if (directPayContentResponse != null && (directPayPay = directPayContentResponse.pay) != null && (directPayBalance = directPayPay.balance) != null) {
            return new b<>(Boolean.valueOf(directPayBalance.enough == 1), this.f25589b.pay.balance.disabled_msg);
        }
        DirectPayContentResponse directPayContentResponse2 = this.f25589b;
        if (directPayContentResponse2 != null && (userModel = directPayContentResponse2.user) != null) {
            return new b<>(Boolean.valueOf("1".equals(userModel.balance_support_status)), this.f25589b.user.balance_unsupport_reason);
        }
        return new b<>(Boolean.FALSE, "");
    }

    public b<Boolean, String> canUseCredit() {
        PayData.DirectPayPay directPayPay;
        PayData.CreditPay creditPay;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        if (directPayContentResponse != null && (directPayPay = directPayContentResponse.pay) != null && (creditPay = directPayPay.credit_pay) != null) {
            return new b<>(Boolean.valueOf("1".equals(creditPay.status)), this.f25589b.pay.credit_pay.disable_msg);
        }
        return new b<>(Boolean.FALSE, "");
    }

    public boolean canUseEasypay() {
        PayData.DirectPayPay directPayPay;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || directPayPay.easypay == null) ? false : true;
    }

    public void cleanDetainmentDesc() {
        PayData.DirectPayPay directPayPay;
        PayData.Detainment detainment;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        if (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (detainment = directPayPay.detainment) == null) {
            return;
        }
        detainment.desc = "";
    }

    public boolean enableAddBondCards() {
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return directPayContentResponse != null && "1".equals(directPayContentResponse.can_bind_card_flag);
    }

    public boolean enableAddBondCardsVerify() {
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (easyPay = directPayPay.easypay) == null || !"1".equals(easyPay.can_bind_card_flag)) ? false : true;
    }

    public String[][] getAccountBankCard() {
        return this.o;
    }

    public String getAvailableCreditAmount() {
        PayData.DirectPayPay directPayPay;
        PayData.CreditPay creditPay;
        PayData.CreditInfo creditInfo;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (creditPay = directPayPay.credit_pay) == null || (creditInfo = creditPay.credit_info) == null || TextUtils.isEmpty(creditInfo.available_credit)) ? "0" : this.f25589b.pay.credit_pay.credit_info.available_credit;
    }

    public PayData.DirectPayBalance getBalance() {
        PayData.DirectPayPay directPayPay;
        PayData.DirectPayBalance directPayBalance;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        if (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (directPayBalance = directPayPay.balance) == null) {
            return null;
        }
        return directPayBalance;
    }

    public String getBalanceJumpUrl() {
        PayData.DirectPayPay directPayPay;
        PayData.DirectPayBalance directPayBalance;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (directPayBalance = directPayPay.balance) == null) ? "" : directPayBalance.balance_jump_url;
    }

    public List<RestNameValuePair> getBalancePayPostInfo() {
        PayData.DirectPayPay directPayPay;
        PayData.DirectPayBalance directPayBalance;
        Map<String, String> map;
        ArrayList arrayList = new ArrayList();
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        if (directPayContentResponse != null && (directPayPay = directPayContentResponse.pay) != null && (directPayBalance = directPayPay.balance) != null && (map = directPayBalance.post_info) != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new RestNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        return arrayList;
    }

    public String getBalanceUnSupportReason() {
        UserData.UserModel userModel;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null || !"0".equals(userModel.balance_support_status)) ? "" : this.f25589b.user.balance_unsupport_reason;
    }

    public CardData.BondCard[] getBondCards() {
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        if (directPayContentResponse != null) {
            return directPayContentResponse.getBondCards();
        }
        return null;
    }

    public String getCanAmount() {
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return (directPayContentResponse == null || directPayContentResponse.user == null || !hasCanAmount()) ? "" : this.f25589b.user.getCanAmount();
    }

    public String getCertificateType() {
        UserData.UserModel userModel;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) ? "" : userModel.certificate_type;
    }

    public String getCreditPayDispayName() {
        PayData.DirectPayPay directPayPay;
        PayData.CreditPay creditPay;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (creditPay = directPayPay.credit_pay) == null || TextUtils.isEmpty(creditPay.display_name)) ? "" : this.f25589b.pay.credit_pay.display_name;
    }

    public List<RestNameValuePair> getCreditPayPostInfo() {
        PayData.DirectPayPay directPayPay;
        PayData.CreditPay creditPay;
        Map<String, String> map;
        ArrayList arrayList = new ArrayList();
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        if (directPayContentResponse != null && (directPayPay = directPayContentResponse.pay) != null && (creditPay = directPayPay.credit_pay) != null && (map = creditPay.post_info) != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new RestNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        return arrayList;
    }

    public String getDefaultPayType() {
        PayData.DirectPayPay directPayPay;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        if (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null) {
            return null;
        }
        return directPayPay.default_pay_type_display;
    }

    public String getDetainmentDesc() {
        PayData.DirectPayPay directPayPay;
        PayData.Detainment detainment;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (detainment = directPayPay.detainment) == null) ? "" : detainment.desc;
    }

    public UserData.UserModel.FingerprintMsg getFingerprintMsg() {
        UserData.UserModel userModel;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        if (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null || userModel.getFingerprintMsg() == null) {
            return null;
        }
        return this.f25589b.user.getFingerprintMsg();
    }

    public String getFormatUserName() {
        String userName = getUserName();
        if (hasMobilePwd() || TextUtils.isEmpty(userName)) {
            return userName;
        }
        return "*" + userName.charAt(userName.length() - 1);
    }

    public H5ResultParams getH5ResultParams() {
        return this.f25590c;
    }

    public String getInsideTransOrder() {
        UserData.Misc misc;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return (directPayContentResponse == null || (misc = directPayContentResponse.misc) == null) ? "" : misc.getInsideTransOrder();
    }

    public String getOrderExtraInfo() {
        return this.q;
    }

    public List<RestNameValuePair> getPayPostInfo() {
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        Map<String, String> map;
        ArrayList arrayList = new ArrayList();
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        if (directPayContentResponse != null && (directPayPay = directPayContentResponse.pay) != null && (easyPay = directPayPay.easypay) != null && (map = easyPay.post_info) != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new RestNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        return arrayList;
    }

    public DirectPayContentResponse getPayResponse() {
        return this.f25589b;
    }

    public String getPaySessionInfo() {
        PayData.DirectPayPay directPayPay;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || TextUtils.isEmpty(directPayPay.session_info)) ? "" : this.f25589b.pay.session_info;
    }

    public PayResultContent getPayStateContent() {
        return this.f25588a;
    }

    public List<RestNameValuePair> getPrePayRequestParams() {
        return this.p;
    }

    public String getPureSign() {
        Authorize authorize;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return (directPayContentResponse == null || (authorize = directPayContentResponse.authorize) == null || TextUtils.isEmpty(authorize.pure_sign)) ? "" : this.f25589b.authorize.pure_sign;
    }

    public String getRemotePayHostName() {
        return this.j;
    }

    public String getRemotePkg() {
        return this.k;
    }

    public String getRemoteWhereToBackAct() {
        return this.l;
    }

    public String getSelectedCardNo() {
        PayData.DirectPayPay directPayPay;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || TextUtils.isEmpty(directPayPay.selected_card_no)) ? "" : this.f25589b.pay.selected_card_no;
    }

    public String getSellerUserId() {
        UserData.SP sp;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return (directPayContentResponse == null || (sp = directPayContentResponse.sp) == null) ? "" : sp.getSellerUserId();
    }

    public List<RestNameValuePair> getSessionData() {
        Map<String, String> map;
        ArrayList arrayList = new ArrayList();
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        if (directPayContentResponse != null && (map = directPayContentResponse.cashdesk) != null && map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new RestNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        return arrayList;
    }

    public String getSignSuccessTips() {
        return this.n;
    }

    public String getSpGoodsName() {
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return directPayContentResponse != null ? directPayContentResponse.getSpGoodsName() : "";
    }

    public String getSpName() {
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return directPayContentResponse != null ? directPayContentResponse.getSpName() : "";
    }

    public String getTotalBalance() {
        UserData.UserModel userModel;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) ? "0" : userModel.getCanAmount();
    }

    public IBeanResponse getTransferAccountConfig() {
        return this.r;
    }

    public String getUserId() {
        UserData.UserModel userModel;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) ? "" : userModel.certificate_code;
    }

    public UserData.UserModel getUserInfo() {
        UserData.UserModel userModel;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        if (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) {
            return null;
        }
        return userModel;
    }

    public String getUserName() {
        UserData.UserModel userModel;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) ? "" : userModel.true_name;
    }

    public boolean hasBondCards() {
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        if (directPayContentResponse != null) {
            return directPayContentResponse.hasBindCards();
        }
        return false;
    }

    public boolean hasCanAmount() {
        UserData.UserModel userModel;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        if (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) {
            return false;
        }
        return userModel.hasCanAmount();
    }

    public boolean hasCreditPay() {
        PayData.DirectPayPay directPayPay;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || directPayPay.credit_pay == null) ? false : true;
    }

    public boolean hasEnableCardsForFindPWD() {
        CardData.BondCard[] enableCardsForFindPWD;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return (directPayContentResponse == null || (enableCardsForFindPWD = directPayContentResponse.getEnableCardsForFindPWD()) == null || enableCardsForFindPWD.length <= 0) ? false : true;
    }

    public boolean hasMobilePwd() {
        UserData.UserModel userModel;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        if (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) {
            return false;
        }
        return userModel.hasMobilePwd();
    }

    public boolean isBalanceEnough() {
        PayData.DirectPayPay directPayPay;
        PayData.DirectPayBalance directPayBalance;
        DirectPayContentResponse directPayContentResponse = this.f25595h;
        return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (directPayBalance = directPayPay.balance) == null || directPayBalance.enough != 1) ? false : true;
    }

    public boolean isBalanceSupport() {
        UserData.UserModel userModel;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        if (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) {
            return false;
        }
        return userModel.isSupportBalance();
    }

    public boolean isFromPreCashier() {
        return this.m;
    }

    public boolean isPassFree() {
        UserData.UserModel userModel;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        if (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) {
            return false;
        }
        return "0".equals(userModel.need_pay_password);
    }

    public boolean isRemotePay() {
        return this.f25596i;
    }

    public boolean isShowCreditPay() {
        PayData.DirectPayPay directPayPay;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        return (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || directPayPay.credit_pay == null) ? false : true;
    }

    public boolean isShowDetection() {
        if (LocalRouter.getInstance(BaiduWalletDelegate.getInstance().getAppContext()).isProviderExisted("bankdetection")) {
            DirectPayContentResponse directPayContentResponse = this.f25589b;
            return directPayContentResponse == null || !"0".equals(directPayContentResponse.bank_card_detect_enabled);
        }
        return false;
    }

    public boolean needCalcPayment() {
        UserData.SP sp;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        if (directPayContentResponse == null || (sp = directPayContentResponse.sp) == null) {
            return false;
        }
        return !TextUtils.isEmpty(sp.seller_user_id);
    }

    public boolean oneKeyPayForCredit() {
        PayData.DirectPayPay directPayPay;
        PayData.CreditPay creditPay;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        if (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (creditPay = directPayPay.credit_pay) == null) {
            return false;
        }
        return "1".equals(creditPay.status);
    }

    public void resetFromPrecashier() {
        this.m = false;
    }

    public void setAccountBankCard(String[][] strArr) {
        this.o = strArr;
    }

    public void setCurrentPayRequest(PayRequestCache.BindCategory bindCategory) {
        int i2 = AnonymousClass1.f25597a[bindCategory.ordinal()];
        if (i2 == 1) {
            this.f25589b = this.f25592e;
        } else if (i2 != 2) {
            this.f25589b = this.f25594g;
        } else {
            this.f25589b = this.f25591d;
        }
    }

    public void setFromPreCashier() {
        this.m = true;
    }

    public void setH5ResultParams(H5ResultParams h5ResultParams) {
        this.f25590c = h5ResultParams;
    }

    public void setHasPwd() {
        UserData.UserModel userModel;
        DirectPayContentResponse directPayContentResponse = this.f25589b;
        if (directPayContentResponse == null || (userModel = directPayContentResponse.user) == null) {
            return;
        }
        userModel.setHasMobilePwd();
    }

    public void setIsRemotePay(boolean z) {
        this.f25596i = z;
    }

    public void setOrderExtraInfo(String str) {
        this.q = str;
    }

    public void setPayReslutContent(PayResultContent payResultContent) {
        this.f25588a = payResultContent;
    }

    public void setPayResponse(DirectPayContentResponse directPayContentResponse) {
        PayData.DirectPayPay directPayPay;
        if (directPayContentResponse instanceof CardAddResponse) {
            int i2 = ((CardAddResponse) directPayContentResponse).request_type;
            if (4 == i2) {
                this.f25591d = directPayContentResponse;
            } else if (11 == i2) {
                this.f25592e = directPayContentResponse;
            } else if (12 == i2) {
                this.f25593f = directPayContentResponse;
            } else {
                this.f25594g = directPayContentResponse;
            }
        } else {
            this.f25594g = directPayContentResponse;
        }
        this.f25589b = directPayContentResponse;
        if (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || directPayPay.balance == null) {
            return;
        }
        this.f25595h = directPayContentResponse;
    }

    public void setPrePayRequestParams(List<RestNameValuePair> list) {
        this.p.clear();
        this.p.addAll(list);
    }

    public void setRemotePayHostName(String str) {
        this.j = str;
    }

    public void setRemotePkg(String str) {
        this.k = str;
    }

    public void setRemoteWhereToBackAct(String str) {
        this.l = str;
    }

    public void setSessionData(Map<String, String> map) {
        if (this.f25589b == null || map == null || map.size() <= 0) {
            return;
        }
        this.f25589b.cashdesk = map;
    }

    public void setSignSuccessTips(String str) {
        this.n = str;
    }

    public void setTransferAccountConfig(IBeanResponse iBeanResponse) {
        this.r = iBeanResponse;
    }

    public PayDataCache() {
        this.f25596i = false;
        this.m = false;
        this.n = "";
        this.p = new ArrayList();
    }
}
