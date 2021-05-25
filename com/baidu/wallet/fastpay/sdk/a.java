package com.baidu.wallet.fastpay.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pay.PayCallBack;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.Constants;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.ResultPageStateListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.StatusCode;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.fastpay.FastPayCallBackManager;
import com.baidu.wallet.fastpay.beans.FastPayBeanFactory;
import com.baidu.wallet.fastpay.beans.d;
import com.baidu.wallet.fastpay.datamodel.GetOrderResponse;
import com.baidu.wallet.fastpay.datamodel.SimpleOrderInfo;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.ui.WalletMobileResultActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
@SuppressLint({"HandlerLeak", "UseSparseArrays", "StaticFieldLeak"})
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f23995a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Integer, b> f23996b;

    /* renamed from: c  reason: collision with root package name */
    public String f23997c;

    /* renamed from: d  reason: collision with root package name */
    public final String f23998d;

    /* loaded from: classes5.dex */
    public interface b {
        void onFastPayFail(int i2, int i3, C0233a c0233a);

        void onFastPaySuccess(int i2, int i3, Object obj);
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static a f24020a = new a();
    }

    public void b(int i2) {
        Map<Integer, b> map = this.f23996b;
        if (map == null || map.size() <= 0) {
            return;
        }
        this.f23996b.remove(Integer.valueOf(i2));
    }

    public a() {
        this.f23998d = "0";
        this.f23996b = new HashMap();
    }

    /* renamed from: com.baidu.wallet.fastpay.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0233a {

        /* renamed from: a  reason: collision with root package name */
        public int f24017a;

        /* renamed from: b  reason: collision with root package name */
        public String f24018b;

        /* renamed from: c  reason: collision with root package name */
        public SimpleOrderInfo f24019c;

        public C0233a() {
            this.f24018b = "";
            this.f24019c = null;
        }

        public C0233a(int i2, String str) {
            this();
            this.f24017a = i2;
            this.f24018b = str;
        }

        public C0233a(int i2, String str, SimpleOrderInfo simpleOrderInfo) {
            this(i2, str);
            this.f24019c = simpleOrderInfo;
        }
    }

    public b a(int i2) {
        Map<Integer, b> map = this.f23996b;
        if (map == null || map.size() <= 0) {
            return null;
        }
        return this.f23996b.get(Integer.valueOf(i2));
    }

    public static a a() {
        return c.f24020a;
    }

    public void a(Context context, int i2) {
        this.f23995a = context.getApplicationContext();
        this.f23997c = "BaiduWallet_APP_common_charge";
    }

    public void a(Context context, boolean z, int i2) {
        a(context, i2);
    }

    public boolean a(String str) {
        return Pattern.compile("^1[0-9]{10}$").matcher(str).matches();
    }

    public void a(d dVar, final int i2, String str, b bVar) {
        LogUtil.d("BaiduFastPay", "getChargeCards. mobile = " + str);
        this.f23996b.put(Integer.valueOf(i2), bVar);
        if (!a(str)) {
            LogUtil.d("BaiduFastPay", "getChargeCards. wrong mobile number.");
            FastPayCallBackManager.a(i2, 0, StatusCode.ERROR_CODE_LOCAL, ResUtils.getString(this.f23995a, "wallet_fp_wrong_number"), null);
            return;
        }
        dVar.a(str, this.f23997c);
        dVar.setResponseCallback(new IBeanResponseCallback() { // from class: com.baidu.wallet.fastpay.sdk.a.1
            @Override // com.baidu.apollon.beans.IBeanResponseCallback
            public void onBeanExecFailure(int i3, int i4, String str2) {
                if (45313 == i3 && i4 == -4) {
                    str2 = ResUtils.getString(a.this.f23995a, "wallet_fp_no_faces");
                }
                FastPayCallBackManager.a(i2, 0, i4, str2, null);
            }

            @Override // com.baidu.apollon.beans.IBeanResponseCallback
            public void onBeanExecSuccess(int i3, Object obj, String str2) {
                FastPayCallBackManager.a(i2, obj);
            }
        });
        dVar.execBean();
    }

    public void a(final int i2, final Map<String, String> map, final b bVar) {
        this.f23996b.put(Integer.valueOf(i2), bVar);
        final String str = map.get("key_mobile");
        if (!a(str)) {
            LogUtil.d("BaiduFastPay", "toCharge. wrong mobile number.");
            FastPayCallBackManager.a(i2, 0, StatusCode.ERROR_CODE_LOCAL, ResUtils.getString(this.f23995a, "wallet_fp_wrong_number"), null);
            return;
        }
        WalletLoginHelper.getInstance().verifyPassLogin(true, new LoginBackListenerProxy(this.f23995a, new ILoginBackListener() { // from class: com.baidu.wallet.fastpay.sdk.a.2
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i3, String str2) {
                FastPayCallBackManager.a(i2, 0, -5, ResUtils.getString(a.this.f23995a, "fp_not_login"), null);
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i3, String str2) {
                a.this.a(i2, (String) map.get("param_key_face_value"), str, (String) map.get(Constants.USER_TYPE_KEY), (String) map.get(Constants.TOKEN_VALUE_KEY), bVar);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i2, final String str, final String str2, final String str3, final String str4, b bVar) {
        com.baidu.wallet.fastpay.beans.b bVar2 = (com.baidu.wallet.fastpay.beans.b) FastPayBeanFactory.getInstance().getBean(this.f23995a, FastPayBeanFactory.BEAN_ID_GET_ORDER, "BaiduFastPay");
        bVar2.a(str2, str, "0", this.f23997c);
        bVar2.setResponseCallback(new IBeanResponseCallback() { // from class: com.baidu.wallet.fastpay.sdk.a.3
            @Override // com.baidu.apollon.beans.IBeanResponseCallback
            public void onBeanExecFailure(int i3, int i4, String str5) {
                FastPayCallBackManager.a(i2, 0, i4, str5, null);
            }

            @Override // com.baidu.apollon.beans.IBeanResponseCallback
            public void onBeanExecSuccess(int i3, Object obj, String str5) {
                GetOrderResponse getOrderResponse = (GetOrderResponse) obj;
                SimpleOrderInfo simpleOrderInfo = new SimpleOrderInfo();
                simpleOrderInfo.mFaceValue = str;
                simpleOrderInfo.mMobile = str2;
                simpleOrderInfo.mOrderNo = getOrderResponse.order_no;
                simpleOrderInfo.mOrderInfo = getOrderResponse.url;
                simpleOrderInfo.mPayDesc = getOrderResponse.pay_desc;
                simpleOrderInfo.mSpSuccpageRemainTime = getOrderResponse.redirect_sp_succpage_remain_time;
                simpleOrderInfo.init();
                a.this.a(i2, simpleOrderInfo, str3, str4);
                FastPayCallBackManager.a(i2, obj);
            }
        });
        bVar2.execBean();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i2, final SimpleOrderInfo simpleOrderInfo, String str, String str2) {
        if (simpleOrderInfo != null && !TextUtils.isEmpty(simpleOrderInfo.mOrderInfo)) {
            LogUtil.d("BaiduFastPay", "handleGetOrderInfoSuccess.");
            HashMap hashMap = new HashMap();
            hashMap.put(BaiduPay.PAY_FROM, BaiduPay.PAY_FROM_HUA_FEI);
            LogUtil.d("handleGetOrderInfoSuccess. token type = " + str + ", token = " + str2);
            BaiduPay.getInstance().doPay(this.f23995a, simpleOrderInfo.mOrderInfo, new PayCallBack() { // from class: com.baidu.wallet.fastpay.sdk.a.4
                @Override // com.baidu.android.pay.PayCallBack
                public boolean isHideLoadingDialog() {
                    return false;
                }

                @Override // com.baidu.android.pay.PayCallBack
                public void onPayResult(final int i3, String str3) {
                    if (i3 != 0 && i3 != 1) {
                        FastPayCallBackManager.a(i2, 1, i3, "", simpleOrderInfo);
                        return;
                    }
                    SimpleOrderInfo simpleOrderInfo2 = simpleOrderInfo;
                    if (simpleOrderInfo2 != null && !TextUtils.isEmpty(simpleOrderInfo2.mOrderNo) && simpleOrderInfo.isGotoResultActivity()) {
                        Context context = a.this.f23995a;
                        SimpleOrderInfo simpleOrderInfo3 = simpleOrderInfo;
                        WalletMobileResultActivity.gotoBusniessResultPage(context, true, simpleOrderInfo3.mOrderNo, simpleOrderInfo3.mPayDesc, i3 == 1, new ResultPageStateListener() { // from class: com.baidu.wallet.fastpay.sdk.a.4.1
                            @Override // com.baidu.wallet.api.ResultPageStateListener
                            public void onConfirm() {
                                FastPayCallBackManager.PayStateContent payStateContent = new FastPayCallBackManager.PayStateContent();
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                SimpleOrderInfo simpleOrderInfo4 = simpleOrderInfo;
                                payStateContent.order_no = simpleOrderInfo4.mOrderNo;
                                FastPayCallBackManager.a(i2, i3, simpleOrderInfo4, payStateContent);
                            }
                        });
                        return;
                    }
                    FastPayCallBackManager.PayStateContent payStateContent = new FastPayCallBackManager.PayStateContent();
                    SimpleOrderInfo simpleOrderInfo4 = simpleOrderInfo;
                    payStateContent.order_no = simpleOrderInfo4.mOrderNo;
                    FastPayCallBackManager.a(i2, i3, simpleOrderInfo4, payStateContent);
                }
            }, hashMap);
            return;
        }
        FastPayCallBackManager.a(i2, 1, -10, ResUtils.getString(this.f23995a, "fp_pay_cancel"), simpleOrderInfo);
    }
}
