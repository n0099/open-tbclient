package com.baidu.tieba.pb.pb.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends Handler {
    final /* synthetic */ e dML;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(e eVar, Looper looper) {
        super(looper);
        this.dML = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        y yVar;
        y yVar2;
        y yVar3;
        y yVar4;
        y yVar5;
        Handler handler;
        Handler handler2;
        switch (message.what) {
            case 1:
                yVar = this.dML.dMD;
                if (yVar != null) {
                    yVar2 = this.dML.dMD;
                    if (yVar2.aJJ != null) {
                        yVar3 = this.dML.dMD;
                        if (yVar3.cBT != null) {
                            yVar4 = this.dML.dMD;
                            if (yVar4.cBX != null) {
                                yVar5 = this.dML.dMD;
                                if (yVar5.aJJ.getCurrentPosition() <= 0) {
                                    handler = this.dML.mHandler;
                                    Message obtainMessage = handler.obtainMessage(1);
                                    obtainMessage.obj = message.obj;
                                    handler2 = this.dML.mHandler;
                                    handler2.sendMessageDelayed(obtainMessage, 50L);
                                    return;
                                }
                                this.dML.d(false, 1);
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
