package com.baidu.tieba.imMessageCenter.im.floatwindow.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a btI;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, Looper looper) {
        super(looper);
        this.btI = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        b bVar;
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                c cVar = (c) message.obj;
                if (!cVar.execute()) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = cVar;
                    bVar = this.btI.btH;
                    bVar.sendMessage(obtain);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
