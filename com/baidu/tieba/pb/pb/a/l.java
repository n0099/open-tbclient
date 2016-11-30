package com.baidu.tieba.pb.pb.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Handler {
    final /* synthetic */ e esY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(e eVar, Looper looper) {
        super(looper);
        this.esY = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        t tVar;
        t tVar2;
        t tVar3;
        t tVar4;
        t tVar5;
        Handler handler;
        Handler handler2;
        switch (message.what) {
            case 1:
                tVar = this.esY.esQ;
                if (tVar != null) {
                    tVar2 = this.esY.esQ;
                    if (tVar2.aOE != null) {
                        tVar3 = this.esY.esQ;
                        if (tVar3.cWB != null) {
                            tVar4 = this.esY.esQ;
                            if (tVar4.cWF != null) {
                                tVar5 = this.esY.esQ;
                                if (tVar5.aOE.getCurrentPosition() <= 0) {
                                    handler = this.esY.mHandler;
                                    Message obtainMessage = handler.obtainMessage(1);
                                    obtainMessage.obj = message.obj;
                                    handler2 = this.esY.mHandler;
                                    handler2.sendMessageDelayed(obtainMessage, 50L);
                                    return;
                                }
                                this.esY.e(false, 1);
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
