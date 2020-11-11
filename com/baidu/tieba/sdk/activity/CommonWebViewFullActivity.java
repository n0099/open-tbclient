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
/* loaded from: classes4.dex */
public class CommonWebViewFullActivity extends BaseActivity<CommonWebViewFullActivity> implements f {
    private boolean mDQ = false;
    private d mDR;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        k(getIntent());
        if (this.mDQ) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        if (!isFinishing()) {
            this.mDR = new d(this, this, getIntent());
        }
    }

    private void k(Intent intent) {
        HashMap iR;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("tag_url");
            if (!TextUtils.isEmpty(stringExtra) && (iR = e.iR(stringExtra)) != null && iR.size() > 0) {
                try {
                    if (iR.containsKey("swiper")) {
                        this.mDQ = Integer.valueOf((String) iR.get("swiper")).intValue() == 0;
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mDR == null || !this.mDR.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mDR != null) {
            this.mDR.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.mDR != null) {
            this.mDR.onActivityResult(i, i2, intent);
        }
    }

    private void HQ(int i) {
        getActivity().setResult(i, new Intent());
        getActivity().finish();
    }

    @Override // com.baidu.live.view.web.f
    public void eX(int i) {
        HQ(i);
    }
}
