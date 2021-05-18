package com.baidu.ufosdk.screencapedt;

import android.content.Intent;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
import java.io.ByteArrayOutputStream;
/* loaded from: classes5.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22628a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScreenCapEditActivity f22629b;

    public h(ScreenCapEditActivity screenCapEditActivity, int i2) {
        this.f22629b = screenCapEditActivity;
        this.f22628a = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ByteArrayOutputStream byteArrayOutputStream;
        Intent intent = new Intent();
        intent.setClass(this.f22629b, FeedbackEditActivity.class);
        byteArrayOutputStream = this.f22629b.J;
        intent.putExtra("shot", byteArrayOutputStream.toByteArray());
        intent.putExtra("extend_feedback_channel", this.f22628a);
        intent.putExtra("feedback_channel", this.f22628a);
        this.f22629b.startActivity(intent);
        this.f22629b.finish();
    }
}
