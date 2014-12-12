package com.baidu.tieba.shareSDK;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ WriteShareActivity bNV;
    private Activity mActivity;

    public p(WriteShareActivity writeShareActivity, Activity activity) {
        this.bNV = writeShareActivity;
        this.mActivity = null;
        this.mActivity = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mActivity != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new ShareSDKResultMessage(false));
            com.baidu.tbadk.core.b.b.a(this.mActivity, Constants.MEDIA_INFO, false);
            this.mActivity.finish();
        }
    }
}
