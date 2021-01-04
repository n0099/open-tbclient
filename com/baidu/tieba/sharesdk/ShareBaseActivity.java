package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes8.dex */
public abstract class ShareBaseActivity extends BaseActivity<ShareBaseActivity> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
    }

    public void a(int i, int i2, Bundle bundle, String str) {
        Intent intent = new Intent();
        intent.putExtra("extra_show_channel", i);
        intent.putExtra("extra_share_status", i2);
        intent.putExtra("share_to", String.valueOf(i));
        if (bundle != null) {
            intent.putExtra("tid", bundle.getString("tid"));
            intent.putExtra("pid", bundle.getString("pid"));
            intent.putExtra("source", bundle.getInt("source"));
        } else {
            intent.putExtra("tid", (String) null);
            intent.putExtra("pid", (String) null);
            intent.putExtra("source", 0);
        }
        intent.putExtra("complete_id", str);
        setResult(-1, intent);
        finish();
    }
}
