package com.baidu.tieba.write.shareSDK;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ WriteShareActivity cwd;
    private Activity mActivity;

    public p(WriteShareActivity writeShareActivity, Activity activity) {
        this.cwd = writeShareActivity;
        this.mActivity = null;
        this.mActivity = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mActivity != null) {
            this.cwd.setResult(0);
            com.baidu.tbadk.core.c.b.a(this.mActivity, 200, false);
            this.mActivity.finish();
        }
    }
}
