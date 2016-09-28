package com.baidu.tieba.pb.pb.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends Handler {
    final /* synthetic */ e emY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(e eVar, Looper looper) {
        super(looper);
        this.emY = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        v vVar;
        v vVar2;
        v vVar3;
        v vVar4;
        v vVar5;
        Handler handler;
        Handler handler2;
        switch (message.what) {
            case 1:
                vVar = this.emY.emT;
                if (vVar != null) {
                    vVar2 = this.emY.emT;
                    if (vVar2.aMF != null) {
                        vVar3 = this.emY.emT;
                        if (vVar3.cRg != null) {
                            vVar4 = this.emY.emT;
                            if (vVar4.cRk != null) {
                                vVar5 = this.emY.emT;
                                if (vVar5.aMF.getCurrentPosition() <= 0) {
                                    handler = this.emY.mHandler;
                                    Message obtainMessage = handler.obtainMessage(1);
                                    obtainMessage.obj = message.obj;
                                    handler2 = this.emY.mHandler;
                                    handler2.sendMessageDelayed(obtainMessage, 50L);
                                    return;
                                }
                                this.emY.e(false, 1);
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
