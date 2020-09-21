package com.baidu.ufosdk.screencapedt;

import android.content.Intent;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
import java.io.ByteArrayOutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public final class h implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ ScreenCapEditActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ScreenCapEditActivity screenCapEditActivity, int i) {
        this.b = screenCapEditActivity;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ByteArrayOutputStream byteArrayOutputStream;
        Intent intent = new Intent();
        intent.setClass(this.b, FeedbackEditActivity.class);
        byteArrayOutputStream = this.b.J;
        intent.putExtra("shot", byteArrayOutputStream.toByteArray());
        intent.putExtra("extend_feedback_channel", this.a);
        intent.putExtra("feedback_channel", this.a);
        this.b.startActivity(intent);
        this.b.finish();
    }
}
