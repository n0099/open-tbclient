package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class z extends Handler {
    final /* synthetic */ ImageViewDrawer a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(ImageViewDrawer imageViewDrawer) {
        this.a = imageViewDrawer;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        int i2;
        Handler handler;
        Handler handler2;
        super.handleMessage(message);
        ImageViewDrawer imageViewDrawer = this.a;
        i = imageViewDrawer.b;
        imageViewDrawer.b = i - 1;
        i2 = this.a.b;
        if (i2 >= 0) {
            handler = this.a.f;
            handler2 = this.a.f;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 15L);
            this.a.invalidate();
        }
    }
}
