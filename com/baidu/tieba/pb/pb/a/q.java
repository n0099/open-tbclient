package com.baidu.tieba.pb.pb.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends Handler {
    final /* synthetic */ e dYX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(e eVar, Looper looper) {
        super(looper);
        this.dYX = eVar;
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
                yVar = this.dYX.dYN;
                if (yVar != null) {
                    yVar2 = this.dYX.dYN;
                    if (yVar2.aKC != null) {
                        yVar3 = this.dYX.dYN;
                        if (yVar3.cEI != null) {
                            yVar4 = this.dYX.dYN;
                            if (yVar4.cEM != null) {
                                yVar5 = this.dYX.dYN;
                                if (yVar5.aKC.getCurrentPosition() <= 0) {
                                    handler = this.dYX.mHandler;
                                    Message obtainMessage = handler.obtainMessage(1);
                                    obtainMessage.obj = message.obj;
                                    handler2 = this.dYX.mHandler;
                                    handler2.sendMessageDelayed(obtainMessage, 50L);
                                    return;
                                }
                                this.dYX.e(false, 1);
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
