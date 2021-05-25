package com.baidu.wallet.paysdk.payresult.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.z;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class CashierDeskPayResult extends H5PayResultProcess implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public String f25314a;

    /* renamed from: b  reason: collision with root package name */
    public H5LifeCycleCallback f25315b = null;

    /* loaded from: classes5.dex */
    public enum PayScenario {
        BankcardPay,
        BalancedPay
    }

    public CashierDeskPayResult(Context context, H5ResultParams h5ResultParams) {
        this.mContext = context;
        this.mH5 = h5ResultParams;
    }

    private String a() {
        H5ResultParams h5ResultParams;
        List<RestNameValuePair> b2;
        if (this.mContext == null || (h5ResultParams = this.mH5) == null || TextUtils.isEmpty(h5ResultParams.pay_result_url)) {
            return null;
        }
        if (PayScenario.BalancedPay == this.mH5.pay_scenario) {
            b2 = c();
        } else {
            b2 = b();
        }
        if (b2 == null) {
            return null;
        }
        if (!TextUtils.isEmpty(this.mH5.pay_result_params)) {
            for (String str : this.mH5.pay_result_params.split("&")) {
                String[] split = str.split("=");
                b2.add(new RestNameValuePair(split[0], split[1]));
            }
        }
        b2.add(new RestNameValuePair(ETAG.KEY_STATISTICS_SEESIONID, NetworkBean.SessionCache.getInstance().getSessionId(null)));
        String processedParams = H5PayResultProcess.getProcessedParams(b2, "UTF-8");
        if (TextUtils.isEmpty(processedParams)) {
            return null;
        }
        return this.mH5.pay_result_url + "?is_from_sdk=1&result_type=cashdesk&order_query=" + processedParams;
    }

    private List<RestNameValuePair> b() {
        z zVar = (z) PayBeanFactory.getInstance().getBean(this.mContext, 12, "CashierDeskPayResult");
        List<RestNameValuePair> generateRequestParam = zVar.generateRequestParam();
        BeanManager.getInstance().removeBean(zVar);
        if (generateRequestParam != null) {
            Iterator<RestNameValuePair> it = generateRequestParam.iterator();
            boolean z = false;
            while (!z && it.hasNext()) {
                RestNameValuePair next = it.next();
                if (next != null && "sign".equals(next.getName())) {
                    it.remove();
                    z = true;
                }
            }
        }
        return generateRequestParam;
    }

    private List<RestNameValuePair> c() {
        PayResultContent payStateContent = PayDataCache.getInstance().getPayStateContent();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair(ETAG.KEY_STATISTICS_SEESIONID, NetworkBean.SessionCache.getInstance().getSessionId(null)));
        arrayList.add(new RestNameValuePair("name", "get_balance_pay_trans_state"));
        arrayList.add(new RestNameValuePair("order_no", payStateContent.order_no));
        return arrayList;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.H5PayResultProcess
    public void afterShow() {
        PayDataCache.getInstance().setH5ResultParams(null);
        if (this.mContext == null) {
            return;
        }
        PayResultContent payStateContent = PayDataCache.getInstance().getPayStateContent();
        PayCallBackManager.callBackClientSuccess(this.mContext, payStateContent == null ? "" : payStateContent.notify);
        PayDataCache.getInstance().setPayReslutContent(null);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.H5PayResultProcess
    public void beforeShow() {
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.H5PayResultProcess
    public void show() {
        this.f25314a = a();
        PayRequestCache.getInstance().removeBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        if (this.f25314a == null) {
            afterShow();
            return;
        }
        if (this.f25315b == null) {
            H5LifeCycleCallback h5LifeCycleCallback = new H5LifeCycleCallback() { // from class: com.baidu.wallet.paysdk.payresult.presenter.CashierDeskPayResult.1
                @Override // com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    pop();
                    CashierDeskPayResult.this.afterShow();
                }
            };
            this.f25315b = h5LifeCycleCallback;
            h5LifeCycleCallback.push();
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("with_anim", false);
        bundle.putBoolean("show_share", false);
        bundle.putString("url", this.f25314a);
        bundle.putParcelable("lifecycleLsnr", this.f25315b);
        BaiduWalletDelegate.getInstance().openH5Module(this.mContext, bundle);
        PayBaseBeanActivity.exitEbpay();
    }
}
