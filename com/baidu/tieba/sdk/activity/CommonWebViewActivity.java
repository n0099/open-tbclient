package com.baidu.tieba.sdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.view.web.d;
import com.baidu.live.view.web.e;
import com.baidu.live.view.web.f;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class CommonWebViewActivity extends BaseActivity<CommonWebViewActivity> implements f {
    private boolean ncY = false;
    private d ncZ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        k(getIntent());
        if (this.ncY) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        if (!isFinishing()) {
            this.ncZ = new d(this, this, getIntent());
        }
    }

    private void k(Intent intent) {
        HashMap ix;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("tag_url");
            if (!TextUtils.isEmpty(stringExtra) && (ix = e.ix(stringExtra)) != null && ix.size() > 0) {
                try {
                    if (ix.containsKey("swiper")) {
                        this.ncY = Integer.valueOf((String) ix.get("swiper")).intValue() == 0;
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.ncZ == null || !this.ncZ.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.ncZ != null) {
            this.ncZ.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ncZ != null) {
            this.ncZ.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.ncZ != null) {
            this.ncZ.onActivityResult(i, i2, intent);
        }
    }

    private void HK(int i) {
        getActivity().setResult(i, new Intent());
        getActivity().finish();
    }

    @Override // com.baidu.live.view.web.f
    public void fp(int i) {
        HK(i);
    }
}
