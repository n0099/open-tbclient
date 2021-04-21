package com.baidu.ufosdk.screencapedt;

import android.content.Intent;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
import java.io.ByteArrayOutputStream;
/* loaded from: classes5.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22679a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScreenCapEditActivity f22680b;

    public h(ScreenCapEditActivity screenCapEditActivity, int i) {
        this.f22680b = screenCapEditActivity;
        this.f22679a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ByteArrayOutputStream byteArrayOutputStream;
        Intent intent = new Intent();
        intent.setClass(this.f22680b, FeedbackEditActivity.class);
        byteArrayOutputStream = this.f22680b.J;
        intent.putExtra("shot", byteArrayOutputStream.toByteArray());
        intent.putExtra("extend_feedback_channel", this.f22679a);
        intent.putExtra("feedback_channel", this.f22679a);
        this.f22680b.startActivity(intent);
        this.f22680b.finish();
    }
}
