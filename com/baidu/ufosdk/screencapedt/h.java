package com.baidu.ufosdk.screencapedt;

import android.content.Intent;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
import java.io.ByteArrayOutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f5403a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ScreenCapEditActivity f5404b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ScreenCapEditActivity screenCapEditActivity, int i) {
        this.f5404b = screenCapEditActivity;
        this.f5403a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ByteArrayOutputStream byteArrayOutputStream;
        Intent intent = new Intent();
        intent.setClass(this.f5404b, FeedbackEditActivity.class);
        byteArrayOutputStream = this.f5404b.J;
        intent.putExtra("shot", byteArrayOutputStream.toByteArray());
        intent.putExtra("extend_feedback_channel", this.f5403a);
        intent.putExtra("feedback_channel", this.f5403a);
        this.f5404b.startActivity(intent);
        this.f5404b.finish();
    }
}
