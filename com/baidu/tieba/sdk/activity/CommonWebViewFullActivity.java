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
    private boolean mSo = false;
    private d mSq;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        k(getIntent());
        if (this.mSo) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        if (!isFinishing()) {
            this.mSq = new d(this, this, getIntent());
        }
    }

    private void k(Intent intent) {
        HashMap jp;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("tag_url");
            if (!TextUtils.isEmpty(stringExtra) && (jp = e.jp(stringExtra)) != null && jp.size() > 0) {
                try {
                    if (jp.containsKey("swiper")) {
                        this.mSo = Integer.valueOf((String) jp.get("swiper")).intValue() == 0;
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mSq == null || !this.mSq.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mSq != null) {
            this.mSq.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.mSq != null) {
            this.mSq.onActivityResult(i, i2, intent);
        }
    }

    private void Jf(int i) {
        getActivity().setResult(i, new Intent());
        getActivity().finish();
    }

    @Override // com.baidu.live.view.web.f
    public void fr(int i) {
        Jf(i);
    }
}
