package com.baidu.wallet.paysdk.ui.base;

import android.os.Bundle;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.statistics.impl.SensorsSyncHttpImpl;
import com.baidu.wallet.statistics.impl.StatConfig;
import d.e.a.a.a;
/* loaded from: classes5.dex */
public class DxmPayBaseActivity extends BaseActivity {
    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        a.g(this, StatConfig.getInstance(this));
        a.x(new SensorsSyncHttpImpl());
        super.onCreate(bundle);
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
