package com.baidu.ufosdk.screencapedt;

import android.content.Intent;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
import java.io.ByteArrayOutputStream;
/* loaded from: classes5.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22985a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScreenCapEditActivity f22986b;

    public h(ScreenCapEditActivity screenCapEditActivity, int i) {
        this.f22986b = screenCapEditActivity;
        this.f22985a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ByteArrayOutputStream byteArrayOutputStream;
        Intent intent = new Intent();
        intent.setClass(this.f22986b, FeedbackEditActivity.class);
        byteArrayOutputStream = this.f22986b.J;
        intent.putExtra("shot", byteArrayOutputStream.toByteArray());
        intent.putExtra("extend_feedback_channel", this.f22985a);
        intent.putExtra("feedback_channel", this.f22985a);
        this.f22986b.startActivity(intent);
        this.f22986b.finish();
    }
}
