package com.baidu.tieba.write.shareSDK;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ WriteShareActivity cvN;
    private Activity mActivity;

    public p(WriteShareActivity writeShareActivity, Activity activity) {
        this.cvN = writeShareActivity;
        this.mActivity = null;
        this.mActivity = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mActivity != null) {
            this.cvN.setResult(0);
            com.baidu.tbadk.core.c.b.a(this.mActivity, 200, false);
            this.mActivity.finish();
        }
    }
}
