package com.baidu.wallet.paysdk.payresult.adapters;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.paysdk.a.b;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class BasePayResultAdapter implements IPayResultDataAdapter {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<BaseActivity> f25668a;

    /* renamed from: b  reason: collision with root package name */
    public PayRequest f25669b;

    /* renamed from: c  reason: collision with root package name */
    public PayResultContent f25670c;
    public HashMap<String, String> contents = new HashMap<>();

    public BasePayResultAdapter(BaseActivity baseActivity) {
        this.f25668a = new WeakReference<>(baseActivity);
    }

    public void a(String str) {
        EventBus eventBus = EventBus.getInstance();
        eventBus.getClass();
        EventBus.getInstance().post(new EventBus.Event(str, null));
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public void clearDataOnDestroy() {
        PayDataCache.getInstance().setPayReslutContent(null);
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public String getActionBarTextId() {
        return null;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public String getAuthorizeMsg() {
        return this.f25670c.authorize_msg;
    }

    public ArrayList<String> getCouponContent() {
        PayResultContent payResultContent = this.f25670c;
        if (payResultContent == null || TextUtils.isEmpty(payResultContent.coupon_msg)) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.f25670c.coupon_msg);
        arrayList.add(this.f25670c.coupon_find_prompt);
        return arrayList;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public ArrayList<String> getEventValue() {
        ArrayList<String> arrayList = new ArrayList<>();
        PayRequest payRequest = this.f25669b;
        arrayList.add(payRequest != null ? payRequest.mSpNO : "");
        PayRequest payRequest2 = this.f25669b;
        arrayList.add(payRequest2 != null ? payRequest2.mOrderNo : "");
        return arrayList;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public String getExpectedTime() {
        return null;
    }

    public String getFpOpenMsg() {
        return this.f25670c.fp_open_or_update_msg;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public String getLBSPayText() {
        return isShowLBSPayText() ? this.f25669b.mRemotePayHostName : "";
    }

    public ArrayList<String> getOKBtnOnClickEventValue() {
        ArrayList<String> arrayList = new ArrayList<>();
        PayRequest payRequest = this.f25669b;
        arrayList.add(payRequest != null ? payRequest.mSpNO : "");
        PayRequest payRequest2 = this.f25669b;
        arrayList.add(payRequest2 != null ? payRequest2.mOrderNo : "");
        return arrayList;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public PayResultContent getPayResultContent() {
        return this.f25670c;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPaySuccessContents() {
        PayRequest payRequest;
        this.contents.clear();
        PayResultContent payResultContent = this.f25670c;
        if (payResultContent == null || (payRequest = this.f25669b) == null) {
            return null;
        }
        if (payResultContent.isPaySuccess) {
            if (!TextUtils.isEmpty(payRequest.withholding_auth) && this.f25669b.withholding_auth.equals("1")) {
                this.contents.put("mainTip", "bd_wallet_withhold_success");
            } else {
                this.contents.put("mainTip", "ebpay_pay_success");
            }
            this.contents.put("statusDrawableName", "wallet_base_result_main_success");
            this.contents.put("okBtnText", "ebpay_result_btn_success");
            this.contents.put("payDetailInfo", this.f25670c.pay_detail_info);
        }
        return this.contents;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPayingContents() {
        this.contents.clear();
        PayResultContent payResultContent = this.f25670c;
        if (payResultContent == null || this.f25669b == null) {
            return null;
        }
        if (!payResultContent.isPaySuccess) {
            this.contents.put("statusDrawableName", "wallet_base_result_paying");
            this.contents.put("mainTip", b.a() ? "ebpay_sign_paying" : "ebpay_pay_paying");
            this.contents.put("errorMsg", this.f25670c.mErrorMsg);
        }
        return this.contents;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public void handleOKBtnOnclick() {
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean isBelongPaySdk() {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean isPaySuccess() {
        PayResultContent payResultContent = this.f25670c;
        if (payResultContent == null || this.f25669b == null) {
            return false;
        }
        return payResultContent.isPaySuccess;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean isShowLBSPayText() {
        return PayDataCache.getInstance().isRemotePay() && !TextUtils.isEmpty(this.f25669b.mRemotePayHostName);
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean onCreateCheckInvalide(Bundle bundle) {
        if (bundle != null) {
            this.f25670c = (PayResultContent) bundle.getSerializable("mPayModle");
            this.f25669b = (PayRequest) bundle.getSerializable("mPayRequest");
            return true;
        }
        this.f25670c = PayDataCache.getInstance().getPayStateContent();
        this.f25669b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        return true;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public void onSaveInstanceState(Bundle bundle) {
        PayResultContent payResultContent = this.f25670c;
        if (payResultContent != null) {
            bundle.putSerializable("mPayModle", payResultContent);
        }
        PayRequest payRequest = this.f25669b;
        if (payRequest != null) {
            bundle.putSerializable("mPayRequest", payRequest);
        }
    }

    public boolean showCashbackDetail() {
        PayResultContent payResultContent = this.f25670c;
        return (payResultContent == null || payResultContent.payResultCashbackDetail == null) ? false : true;
    }

    public boolean showMonkeylayout() {
        PayResultContent payResultContent = this.f25670c;
        if (payResultContent != null) {
            if (TextUtils.isEmpty(payResultContent.total_amount) && TextUtils.isEmpty(this.f25670c.cash_amount) && TextUtils.isEmpty(this.f25670c.discount_amount)) {
                String[][] strArr = this.f25670c.paytype_info;
                return strArr != null && strArr.length > 0;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean showResultPage() {
        PayResultContent payResultContent = this.f25670c;
        return (payResultContent == null || "0".equalsIgnoreCase(payResultContent.redirect_sp_succpage_remain_time)) ? false : true;
    }

    public void a(String str, String str2) {
        EventBus eventBus = EventBus.getInstance();
        eventBus.getClass();
        EventBus.getInstance().post(new EventBus.Event(str, str2));
    }
}
