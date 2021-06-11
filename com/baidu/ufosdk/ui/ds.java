package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class ds implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackListActivity f22868a;

    public ds(FeedbackListActivity feedbackListActivity) {
        this.f22868a = feedbackListActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f22868a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext);
    }
}
