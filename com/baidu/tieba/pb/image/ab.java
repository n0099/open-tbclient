package com.baidu.tieba.pb.image;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
final class ab extends Handler {
    final /* synthetic */ ImagePbImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(ImagePbImageView imagePbImageView) {
        this.a = imagePbImageView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
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
            handler = this.a.o;
            handler2 = this.a.o;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 20L);
            this.a.invalidate();
        }
    }
}
