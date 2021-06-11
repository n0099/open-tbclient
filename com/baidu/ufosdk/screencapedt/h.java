package com.baidu.ufosdk.screencapedt;

import android.content.Intent;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
import java.io.ByteArrayOutputStream;
/* loaded from: classes5.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22660a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScreenCapEditActivity f22661b;

    public h(ScreenCapEditActivity screenCapEditActivity, int i2) {
        this.f22661b = screenCapEditActivity;
        this.f22660a = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ByteArrayOutputStream byteArrayOutputStream;
        Intent intent = new Intent();
        intent.setClass(this.f22661b, FeedbackEditActivity.class);
        byteArrayOutputStream = this.f22661b.J;
        intent.putExtra("shot", byteArrayOutputStream.toByteArray());
        intent.putExtra("extend_feedback_channel", this.f22660a);
        intent.putExtra("feedback_channel", this.f22660a);
        this.f22661b.startActivity(intent);
        this.f22661b.finish();
    }
}
