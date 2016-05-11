package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public class a {
    private static a cuW;
    private final HandlerC0060a cuX = new HandlerC0060a(Looper.getMainLooper());

    private a() {
    }

    public static a ajO() {
        if (cuW == null) {
            cuW = new a();
        }
        return cuW;
    }

    public void a(b bVar) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = bVar;
        this.cuX.sendMessage(obtain);
    }

    /* renamed from: com.baidu.tieba.imMessageCenter.im.floatwindow.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class HandlerC0060a extends Handler {
        public HandlerC0060a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    b bVar = (b) message.obj;
                    if (!bVar.execute()) {
                        Message obtain = Message.obtain();
                        obtain.what = 1;
                        obtain.obj = bVar;
                        a.this.cuX.sendMessage(obtain);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
