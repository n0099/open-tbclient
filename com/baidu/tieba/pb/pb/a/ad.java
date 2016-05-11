package com.baidu.tieba.pb.pb.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends Handler {
    final /* synthetic */ r dgC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(r rVar, Looper looper) {
        super(looper);
        this.dgC = rVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        an anVar;
        an anVar2;
        an anVar3;
        an anVar4;
        an anVar5;
        an anVar6;
        Handler handler;
        Handler handler2;
        an anVar7;
        an anVar8;
        an anVar9;
        an anVar10;
        an anVar11;
        switch (message.what) {
            case 1:
                z = this.dgC.dgt;
                if (!z) {
                    anVar = this.dgC.dgr;
                    if (anVar != null) {
                        anVar2 = this.dgC.dgr;
                        if (anVar2.dgT != null) {
                            anVar3 = this.dgC.dgr;
                            if (anVar3.dgN != null) {
                                anVar4 = this.dgC.dgr;
                                if (anVar4.dgW != null) {
                                    anVar5 = this.dgC.dgr;
                                    if (anVar5.dgY != null) {
                                        anVar6 = this.dgC.dgr;
                                        if (anVar6.dgT.getCurrentPosition() > 0) {
                                            anVar7 = this.dgC.dgr;
                                            anVar7.dgN.setVisibility(8);
                                            anVar8 = this.dgC.dgr;
                                            anVar8.dgW.setVisibility(8);
                                            anVar9 = this.dgC.dgr;
                                            anVar9.dgY.setVisibility(8);
                                            anVar10 = this.dgC.dgr;
                                            this.dgC.b((com.baidu.tieba.tbadkCore.data.s) message.obj, anVar10);
                                            r rVar = this.dgC;
                                            anVar11 = this.dgC.dgr;
                                            rVar.c(anVar11);
                                            return;
                                        }
                                        handler = this.dgC.mHandler;
                                        Message obtainMessage = handler.obtainMessage(1);
                                        obtainMessage.obj = message.obj;
                                        handler2 = this.dgC.mHandler;
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
