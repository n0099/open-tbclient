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
    public CountDownTimer f25364d;

    public PayResultAdapter(BaseActivity baseActivity) {
        super(baseActivity);
        this.f25361a = new WeakReference<>(baseActivity);
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public void handleOKBtnOnclick() {
        PayResultContent payResultContent = this.f25363c;
        if (payResultContent != null) {
            if (payResultContent.isPaySuccess) {
                PayRequest payRequest = this.f25362b;
                if (payRequest != null && BeanConstants.PAY_FROM_B_SAO_C.equals(payRequest.mPayFrom)) {
                    GlobalUtils.hideKeyboard(this.f25361a.get().getActivity());
                    a(BeanConstants.EV_SCANCODE_EXIT, this.f25363c.notify);
                    return;
                }
                PayCallBackManager.callBackClientSuccess(this.f25361a.get().getActivity(), this.f25363c.notify);
                return;
            }
            PayCallBackManager.callBackClientPaying(this.f25361a.get().getActivity());
            return;
        }
        PayCallBackManager.callBackClientPaying(this.f25361a.get().getActivity());
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean onCreateCheckInvalide(Bundle bundle) {
        PayRequest payRequest;
        super.onCreateCheckInvalide(bundle);
        if (this.f25363c == null || (payRequest = this.f25362b) == null) {
            return false;
        }
        if (!BeanConstants.PAY_FROM_B_SAO_C.equals(payRequest.mPayFrom) || BaiduPay.getInstance().getScanCallback() == null) {
            return true;
        }
        CountDownTimer countDownTimer = this.f25364d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f25364d = null;
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(3000L, 1000L) { // from class: com.baidu.wallet.paysdk.payresult.adapters.PayResultAdapter.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                GlobalUtils.hideKeyboard(PayResultAdapter.this.f25361a.get().getActivity());
                PayResultAdapter payResultAdapter = PayResultAdapter.this;
                payResultAdapter.a(BeanConstants.EV_SCANCODE_EXIT, payResultAdapter.f25363c.notify);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        };
        this.f25364d = countDownTimer2;
        countDownTimer2.start();
        return true;
    }
}
