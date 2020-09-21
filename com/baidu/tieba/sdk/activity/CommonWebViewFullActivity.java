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
    private boolean lVH = false;
    private d lVI;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        k(getIntent());
        if (this.lVH) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        if (!isFinishing()) {
            this.lVI = new d(this, this, getIntent());
        }
    }

    private void k(Intent intent) {
        HashMap hS;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("tag_url");
            if (!TextUtils.isEmpty(stringExtra) && (hS = e.hS(stringExtra)) != null && hS.size() > 0) {
                try {
                    if (hS.containsKey("swiper")) {
                        this.lVH = Integer.valueOf((String) hS.get("swiper")).intValue() == 0;
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.lVI == null || !this.lVI.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lVI != null) {
            this.lVI.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.lVI != null) {
            this.lVI.onActivityResult(i, i2, intent);
        }
    }

    private void GE(int i) {
        getActivity().setResult(i, new Intent());
        getActivity().finish();
    }

    @Override // com.baidu.live.view.web.f
    public void eL(int i) {
        GE(i);
    }
}
