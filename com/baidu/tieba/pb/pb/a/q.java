package com.baidu.tieba.pb.pb.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends Handler {
    final /* synthetic */ e elb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(e eVar, Looper looper) {
        super(looper);
        this.elb = eVar;
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
                yVar = this.elb.ekR;
                if (yVar != null) {
                    yVar2 = this.elb.ekR;
                    if (yVar2.aPh != null) {
                        yVar3 = this.elb.ekR;
                        if (yVar3.cQp != null) {
                            yVar4 = this.elb.ekR;
                            if (yVar4.cQt != null) {
                                yVar5 = this.elb.ekR;
                                if (yVar5.aPh.getCurrentPosition() <= 0) {
                                    handler = this.elb.mHandler;
                                    Message obtainMessage = handler.obtainMessage(1);
                                    obtainMessage.obj = message.obj;
                                    handler2 = this.elb.mHandler;
                                    handler2.sendMessageDelayed(obtainMessage, 50L);
                                    return;
                                }
                                this.elb.d(false, 1);
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
