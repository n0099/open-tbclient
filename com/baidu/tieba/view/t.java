package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class t extends Handler {
    final /* synthetic */ ImagePbImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ImagePbImageView imagePbImageView) {
        this.a = imagePbImageView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        int i2;
        Handler handler;
        Handler handler2;
        super.handleMessage(message);
        ImagePbImageView imagePbImageView = this.a;
        i = imagePbImageView.g;
        imagePbImageView.g = i - 1;
        i2 = this.a.g;
        if (i2 >= 0) {
            handler = this.a.h;
            handler2 = this.a.h;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 20L);
            this.a.invalidate();
        }
    }
}
