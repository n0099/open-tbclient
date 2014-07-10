package com.baidu.tieba.pb.image;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class ab extends Handler {
    final /* synthetic */ ImagePbImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(ImagePbImageView imagePbImageView) {
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
        i = imagePbImageView.n;
        imagePbImageView.n = i - 1;
        i2 = this.a.n;
        if (i2 >= 0) {
            handler = this.a.p;
            handler2 = this.a.p;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 20L);
            this.a.invalidate();
        }
    }
}
