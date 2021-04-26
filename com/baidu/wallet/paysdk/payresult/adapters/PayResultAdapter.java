package com.baidu.wallet.paysdk.payresult.adapters;

import android.os.Bundle;
import android.os.CountDownTimer;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class PayResultAdapter extends BasePayResultAdapter {

    /* renamed from: d  reason: collision with root package name */
    public CountDownTimer f26137d;

    public PayResultAdapter(BaseActivity baseActivity) {
        super(baseActivity);
        this.f26134a = new WeakReference<>(baseActivity);
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public void handleOKBtnOnclick() {
        PayResultContent payResultContent = this.f26136c;
        if (payResultContent != null) {
            if (payResultContent.isPaySuccess) {
                PayRequest payRequest = this.f26135b;
                if (payRequest != null && BeanConstants.PAY_FROM_B_SAO_C.equals(payRequest.mPayFrom)) {
                    GlobalUtils.hideKeyboard(this.f26134a.get().getActivity());
                    a(BeanConstants.EV_SCANCODE_EXIT, this.f26136c.notify);
                    return;
                }
                PayCallBackManager.callBackClientSuccess(this.f26134a.get().getActivity(), this.f26136c.notify);
                return;
            }
            PayCallBackManager.callBackClientPaying(this.f26134a.get().getActivity());
            return;
        }
        PayCallBackManager.callBackClientPaying(this.f26134a.get().getActivity());
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean onCreateCheckInvalide(Bundle bundle) {
        PayRequest payRequest;
        super.onCreateCheckInvalide(bundle);
        if (this.f26136c == null || (payRequest = this.f26135b) == null) {
            return false;
        }
        if (!BeanConstants.PAY_FROM_B_SAO_C.equals(payRequest.mPayFrom) || BaiduPay.getInstance().getScanCallback() == null) {
            return true;
        }
        CountDownTimer countDownTimer = this.f26137d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f26137d = null;
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(3000L, 1000L) { // from class: com.baidu.wallet.paysdk.payresult.adapters.PayResultAdapter.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                GlobalUtils.hideKeyboard(PayResultAdapter.this.f26134a.get().getActivity());
                PayResultAdapter payResultAdapter = PayResultAdapter.this;
                payResultAdapter.a(BeanConstants.EV_SCANCODE_EXIT, payResultAdapter.f26136c.notify);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        };
        this.f26137d = countDownTimer2;
        countDownTimer2.start();
        return true;
    }
}
