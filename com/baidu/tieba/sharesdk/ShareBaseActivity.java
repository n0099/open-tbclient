package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes5.dex */
public abstract class ShareBaseActivity extends BaseActivity<ShareBaseActivity> {
    public void finishWithResult(int i2, int i3, Bundle bundle, String str) {
        Intent intent = new Intent();
        intent.putExtra("extra_show_channel", i2);
        intent.putExtra("extra_share_status", i3);
        intent.putExtra("share_to", String.valueOf(i2));
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        }
    }
}
