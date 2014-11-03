package com.baidu.tieba.shareSDK;

import android.app.Activity;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ WriteShareActivity bJF;
    private Activity mActivity;

    public o(WriteShareActivity writeShareActivity, Activity activity) {
        this.bJF = writeShareActivity;
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
