package com.baidu.tieba.sdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.view.web.d;
import com.baidu.live.view.web.e;
/* loaded from: classes2.dex */
public class CommonWebViewActivity extends BaseActivity<CommonWebViewActivity> implements e {
    private d jOD;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jOD = new d(this, this, getIntent());
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.jOD == null || !this.jOD.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jOD != null) {
            this.jOD.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.jOD != null) {
            this.jOD.onActivityResult(i, i2, intent);
        }
    }

    private void AH(int i) {
        getActivity().setResult(i, new Intent());
        getActivity().finish();
    }

    @Override // com.baidu.live.view.web.e
    public void cI(int i) {
        AH(i);
    }
}
