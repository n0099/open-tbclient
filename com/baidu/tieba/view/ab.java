package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class ab extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbImageView f1806a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(ImagePbImageView imagePbImageView) {
        this.f1806a = imagePbImageView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        int i2;
        Handler handler;
        Handler handler2;
        super.handleMessage(message);
        ImagePbImageView imagePbImageView = this.f1806a;
        i = imagePbImageView.j;
        imagePbImageView.j = i - 1;
        i2 = this.f1806a.j;
        if (i2 >= 0) {
            handler = this.f1806a.k;
            handler2 = this.f1806a.k;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 20L);
            this.f1806a.invalidate();
        }
    }
}
