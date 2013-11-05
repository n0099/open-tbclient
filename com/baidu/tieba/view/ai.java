package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class ai extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbImageView f2505a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ImagePbImageView imagePbImageView) {
        this.f2505a = imagePbImageView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        Handler handler;
        Handler handler2;
        super.handleMessage(message);
        ImagePbImageView.a(this.f2505a);
        i = this.f2505a.j;
        if (i >= 0) {
            handler = this.f2505a.k;
            handler2 = this.f2505a.k;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 20L);
            this.f2505a.invalidate();
        }
    }
}
