package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes21.dex */
final class ds implements Runnable {
    final /* synthetic */ FeedbackListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(FeedbackListActivity feedbackListActivity) {
        this.a = feedbackListActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext);
    }
}
