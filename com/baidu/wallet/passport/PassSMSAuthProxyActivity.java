package com.baidu.wallet.passport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.WalletApiExtListener;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
/* loaded from: classes5.dex */
public class PassSMSAuthProxyActivity extends BaseActivity {
    public static WalletApiExtListener.ThirdPartyLoginListener callback;
    public boolean PageStarted = false;

    public static void startPassSMSAuth(Activity activity, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        callback = thirdPartyLoginListener;
        activity.startActivity(new Intent(activity, PassSMSAuthProxyActivity.class));
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        window.setAttributes(attributes);
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        callback = null;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.PageStarted) {
            this.PageStarted = true;
            BaiduWalletDelegate.getInstance().openH5Module(this, SdkInitResponse.getInstance().getPassAuthUrl(this), false);
            return;
        }
        WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener = callback;
        if (thirdPartyLoginListener != null) {
            thirdPartyLoginListener.onCallSuccess(0, null);
        }
        callback = null;
        finish();
    }
}
