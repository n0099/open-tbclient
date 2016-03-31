package com.baidu.tieba.pb.pb.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends Handler {
    final /* synthetic */ r dej;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(r rVar, Looper looper) {
        super(looper);
        this.dej = rVar;
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
                z = this.dej.ddZ;
                if (!z) {
                    anVar = this.dej.ddX;
                    if (anVar != null) {
                        anVar2 = this.dej.ddX;
                        if (anVar2.deA != null) {
                            anVar3 = this.dej.ddX;
                            if (anVar3.deu != null) {
                                anVar4 = this.dej.ddX;
                                if (anVar4.deD != null) {
                                    anVar5 = this.dej.ddX;
                                    if (anVar5.deF != null) {
                                        anVar6 = this.dej.ddX;
                                        if (anVar6.deA.getCurrentPosition() > 0) {
                                            anVar7 = this.dej.ddX;
                                            anVar7.deu.setVisibility(8);
                                            anVar8 = this.dej.ddX;
                                            anVar8.deD.setVisibility(8);
                                            anVar9 = this.dej.ddX;
                                            anVar9.deF.setVisibility(8);
                                            anVar10 = this.dej.ddX;
                                            this.dej.b((com.baidu.tieba.tbadkCore.data.s) message.obj, anVar10);
                                            r rVar = this.dej;
                                            anVar11 = this.dej.ddX;
                                            rVar.c(anVar11);
                                            return;
                                        }
                                        handler = this.dej.mHandler;
                                        Message obtainMessage = handler.obtainMessage(1);
                                        obtainMessage.obj = message.obj;
                                        handler2 = this.dej.mHandler;
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
