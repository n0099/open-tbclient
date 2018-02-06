package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes3.dex */
public abstract class ShareBaseActivity extends BaseActivity<ShareBaseActivity> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
    }

    public void j(int i, int i2, String str) {
        Intent intent = new Intent();
        intent.putExtra("extra_show_channel", i);
        intent.putExtra("extra_share_status", i2);
        intent.putExtra("share_to", String.valueOf(i));
        intent.putExtra("tid", str);
        setResult(-1, intent);
        finish();
    }
}
