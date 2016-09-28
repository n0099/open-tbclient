package com.baidu.tieba.pb.pb.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.play.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements e.d {
    final /* synthetic */ e emY;
    private final /* synthetic */ v emZ;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.o ena;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.q enb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar, v vVar, com.baidu.tbadk.widget.richText.o oVar, com.baidu.tieba.tbadkCore.data.q qVar) {
        this.emY = eVar;
        this.emZ = vVar;
        this.ena = oVar;
        this.enb = qVar;
    }

    @Override // com.baidu.tieba.play.e.d
    public void onPrepared(com.baidu.tieba.play.e eVar) {
        Handler handler;
        Handler handler2;
        if (this.emZ.aMF != null) {
            if (eVar != null) {
                eVar.setVolume(0.0f, 0.0f);
            }
            this.emY.Jt();
            this.emY.c(this.ena);
            this.emY.a(this.emZ, this.ena);
            handler = this.emY.mHandler;
            Message obtainMessage = handler.obtainMessage(1);
            obtainMessage.obj = this.enb;
            handler2 = this.emY.mHandler;
            handler2.sendMessage(obtainMessage);
        }
    }
}
