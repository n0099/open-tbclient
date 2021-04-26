package com.baidu.ufosdk.screencapedt;

import android.content.Intent;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
import java.io.ByteArrayOutputStream;
/* loaded from: classes5.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f23383a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScreenCapEditActivity f23384b;

    public h(ScreenCapEditActivity screenCapEditActivity, int i2) {
        this.f23384b = screenCapEditActivity;
        this.f23383a = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ByteArrayOutputStream byteArrayOutputStream;
        Intent intent = new Intent();
        intent.setClass(this.f23384b, FeedbackEditActivity.class);
        byteArrayOutputStream = this.f23384b.J;
        intent.putExtra("shot", byteArrayOutputStream.toByteArray());
        intent.putExtra("extend_feedback_channel", this.f23383a);
        intent.putExtra("feedback_channel", this.f23383a);
        this.f23384b.startActivity(intent);
        this.f23384b.finish();
    }
}
