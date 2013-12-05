package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class aj extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbImageView f2656a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ImagePbImageView imagePbImageView) {
        this.f2656a = imagePbImageView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        Handler handler;
        Handler handler2;
        super.handleMessage(message);
        ImagePbImageView.a(this.f2656a);
        i = this.f2656a.n;
        if (i >= 0) {
            handler = this.f2656a.o;
            handler2 = this.f2656a.o;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 20L);
            this.f2656a.invalidate();
        }
    }
}
