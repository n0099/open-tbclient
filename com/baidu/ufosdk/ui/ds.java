package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes7.dex */
final class ds implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackListActivity f3745a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(FeedbackListActivity feedbackListActivity) {
        this.f3745a = feedbackListActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f3745a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext);
    }
}
