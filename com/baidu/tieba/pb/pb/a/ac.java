package com.baidu.tieba.pb.pb.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends Handler {
    final /* synthetic */ q cKS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(q qVar, Looper looper) {
        super(looper);
        this.cKS = qVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        am amVar;
        am amVar2;
        am amVar3;
        am amVar4;
        am amVar5;
        am amVar6;
        Handler handler;
        Handler handler2;
        am amVar7;
        am amVar8;
        am amVar9;
        am amVar10;
        am amVar11;
        switch (message.what) {
            case 1:
                z = this.cKS.cKH;
                if (!z) {
                    amVar = this.cKS.cKF;
                    if (amVar != null) {
                        amVar2 = this.cKS.cKF;
                        if (amVar2.cLk != null) {
                            amVar3 = this.cKS.cKF;
                            if (amVar3.cLd != null) {
                                amVar4 = this.cKS.cKF;
                                if (amVar4.cLn != null) {
                                    amVar5 = this.cKS.cKF;
                                    if (amVar5.cLp != null) {
                                        amVar6 = this.cKS.cKF;
                                        if (amVar6.cLk.getCurrentPosition() > 0) {
                                            amVar7 = this.cKS.cKF;
                                            amVar7.cLd.setVisibility(8);
                                            amVar8 = this.cKS.cKF;
                                            amVar8.cLn.setVisibility(8);
                                            amVar9 = this.cKS.cKF;
                                            amVar9.cLp.setVisibility(8);
                                            amVar10 = this.cKS.cKF;
                                            this.cKS.b((com.baidu.tieba.tbadkCore.data.r) message.obj, amVar10);
                                            q qVar = this.cKS;
                                            amVar11 = this.cKS.cKF;
                                            qVar.c(amVar11);
                                            return;
                                        }
                                        handler = this.cKS.mHandler;
                                        Message obtainMessage = handler.obtainMessage(1);
                                        obtainMessage.obj = message.obj;
                                        handler2 = this.cKS.mHandler;
                                        handler2.sendMessageDelayed(obtainMessage, 50L);
                                        return;
                                    }
                                    return;
                                }
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
