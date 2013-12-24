package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class aj extends Handler {
    final /* synthetic */ ImagePbImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ImagePbImageView imagePbImageView) {
        this.a = imagePbImageView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        Handler handler;
        Handler handler2;
        super.handleMessage(message);
        ImagePbImageView.a(this.a);
        i = this.a.n;
        if (i >= 0) {
            handler = this.a.o;
            handler2 = this.a.o;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 20L);
            this.a.invalidate();
        }
    }
}
