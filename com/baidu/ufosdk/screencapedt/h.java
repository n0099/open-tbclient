package com.baidu.ufosdk.screencapedt;

import android.content.Intent;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
import java.io.ByteArrayOutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f3731a;
    final /* synthetic */ ScreenCapEditActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ScreenCapEditActivity screenCapEditActivity, int i) {
        this.b = screenCapEditActivity;
        this.f3731a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ByteArrayOutputStream byteArrayOutputStream;
        Intent intent = new Intent();
        intent.setClass(this.b, FeedbackEditActivity.class);
        byteArrayOutputStream = this.b.J;
        intent.putExtra("shot", byteArrayOutputStream.toByteArray());
        intent.putExtra("extend_feedback_channel", this.f3731a);
        intent.putExtra("feedback_channel", this.f3731a);
        this.b.startActivity(intent);
        this.b.finish();
    }
}
