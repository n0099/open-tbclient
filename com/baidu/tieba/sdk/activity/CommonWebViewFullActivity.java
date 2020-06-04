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
/* loaded from: classes3.dex */
public class CommonWebViewFullActivity extends BaseActivity<CommonWebViewFullActivity> implements f {
    private boolean kTX = false;
    private d kTY;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        k(getIntent());
        if (this.kTX) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        if (!isFinishing()) {
            this.kTY = new d(this, this, getIntent());
        }
    }

    private void k(Intent intent) {
        HashMap fT;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("tag_url");
            if (!TextUtils.isEmpty(stringExtra) && (fT = e.fT(stringExtra)) != null && fT.size() > 0) {
                try {
                    if (fT.containsKey("swiper")) {
                        this.kTX = Integer.valueOf((String) fT.get("swiper")).intValue() == 0;
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.kTY == null || !this.kTY.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kTY != null) {
            this.kTY.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.kTY != null) {
            this.kTY.onActivityResult(i, i2, intent);
        }
    }

    private void Ck(int i) {
        getActivity().setResult(i, new Intent());
        getActivity().finish();
    }

    @Override // com.baidu.live.view.web.f
    public void dv(int i) {
        Ck(i);
    }
}
