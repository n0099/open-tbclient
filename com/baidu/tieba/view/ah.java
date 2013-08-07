package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class ah extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageViewDrawer f1812a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ImageViewDrawer imageViewDrawer) {
        this.f1812a = imageViewDrawer;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        int i2;
        Handler handler;
        Handler handler2;
        super.handleMessage(message);
        ImageViewDrawer imageViewDrawer = this.f1812a;
        i = imageViewDrawer.b;
        imageViewDrawer.b = i - 1;
        i2 = this.f1812a.b;
        if (i2 >= 0) {
            handler = this.f1812a.g;
            handler2 = this.f1812a.g;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 15L);
            this.f1812a.invalidate();
        }
    }
}
