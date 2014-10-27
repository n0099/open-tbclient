package com.baidu.tieba.shareSDK;

import android.app.Activity;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ WriteShareActivity bJq;
    private Activity mActivity;

    public n(WriteShareActivity writeShareActivity, Activity activity) {
        this.bJq = writeShareActivity;
        this.mActivity = null;
        this.mActivity = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mActivity != null) {
            com.baidu.tbadk.core.b.b.a(this.mActivity, Constants.MEDIA_INFO, false);
            this.mActivity.finish();
        }
    }
}
