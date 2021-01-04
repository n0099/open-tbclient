package com.baidu.ufosdk.screencapedt;

import android.content.Intent;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
import java.io.ByteArrayOutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f5685a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ScreenCapEditActivity f5686b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ScreenCapEditActivity screenCapEditActivity, int i) {
        this.f5686b = screenCapEditActivity;
        this.f5685a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ByteArrayOutputStream byteArrayOutputStream;
        Intent intent = new Intent();
        intent.setClass(this.f5686b, FeedbackEditActivity.class);
        byteArrayOutputStream = this.f5686b.J;
        intent.putExtra("shot", byteArrayOutputStream.toByteArray());
        intent.putExtra("extend_feedback_channel", this.f5685a);
        intent.putExtra("feedback_channel", this.f5685a);
        this.f5686b.startActivity(intent);
        this.f5686b.finish();
    }
}
