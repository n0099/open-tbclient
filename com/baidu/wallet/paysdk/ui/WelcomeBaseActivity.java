package com.baidu.wallet.paysdk.ui;

import android.os.Build;
import android.os.Bundle;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.core.utils.NFCUtil;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import java.io.Serializable;
/* loaded from: classes5.dex */
public abstract class WelcomeBaseActivity extends PayBaseBeanActivity {
    public PayRequest mPayReq = null;

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFlagPaySdk();
        if (bundle == null) {
            this.mPayReq = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        } else {
            Serializable serializable = bundle.getSerializable("mPayRequest");
            if (serializable != null && (serializable instanceof PayRequest)) {
                this.mPayReq = (PayRequest) serializable;
            }
            Serializable serializable2 = bundle.getSerializable("mPayResponse");
            if (serializable2 != null && (serializable2 instanceof DirectPayContentResponse)) {
                PayDataCache.getInstance().setPayResponse((DirectPayContentResponse) serializable2);
            }
        }
        if (this.mPayReq != null) {
            PayRequestCache.getInstance().addBeanRequestToCache(this.mPayReq.getRequestId(), this.mPayReq);
        } else {
            PayCallBackManager.callBackClientCancel(this, "WelcomeBaseActivity.onCreate().1");
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("mPayRequest", this.mPayReq);
        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        if (payResponse != null) {
            bundle.putSerializable("mPayResponse", payResponse);
        }
        super.onSaveInstanceState(bundle);
    }
}
