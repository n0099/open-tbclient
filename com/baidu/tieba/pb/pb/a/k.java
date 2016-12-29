package com.baidu.tieba.pb.pb.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    final /* synthetic */ d dXu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(d dVar, Looper looper) {
        super(looper);
        this.dXu = dVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        s sVar;
        s sVar2;
        s sVar3;
        s sVar4;
        s sVar5;
        Handler handler;
        Handler handler2;
        switch (message.what) {
            case 1:
                sVar = this.dXu.dXm;
                if (sVar != null) {
                    sVar2 = this.dXu.dXm;
                    if (sVar2.aNV != null) {
                        sVar3 = this.dXu.dXm;
                        if (sVar3.cBJ != null) {
                            sVar4 = this.dXu.dXm;
                            if (sVar4.cBN != null) {
                                sVar5 = this.dXu.dXm;
                                if (sVar5.aNV.getCurrentPosition() <= 0) {
                                    handler = this.dXu.mHandler;
                                    Message obtainMessage = handler.obtainMessage(1);
                                    obtainMessage.obj = message.obj;
                                    handler2 = this.dXu.mHandler;
                                    handler2.sendMessageDelayed(obtainMessage, 50L);
                                    return;
                                }
                                this.dXu.e(false, 1);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
