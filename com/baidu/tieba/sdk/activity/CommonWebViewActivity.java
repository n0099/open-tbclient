package com.baidu.tieba.sdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.view.web.d;
import com.baidu.live.view.web.e;
/* loaded from: classes6.dex */
public class CommonWebViewActivity extends BaseActivity<CommonWebViewActivity> implements e {
    private d iRA;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iRA = new d(this, this, getIntent());
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.iRA == null || !this.iRA.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.iRA != null) {
            this.iRA.onActivityResult(i, i2, intent);
        }
    }

    private void yh(int i) {
        Intent intent = new Intent();
        getActivity().setResult(-1, intent);
        intent.putExtra("resultCode", i);
        getActivity().finish();
    }

    @Override // com.baidu.live.view.web.e
    public void cs(int i) {
        yh(i);
    }
}
