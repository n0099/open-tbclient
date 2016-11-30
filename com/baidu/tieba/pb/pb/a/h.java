package com.baidu.tieba.pb.pb.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.play.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements t.d {
    final /* synthetic */ e esY;
    private final /* synthetic */ t esZ;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.o eta;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.q etb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, t tVar, com.baidu.tbadk.widget.richText.o oVar, com.baidu.tieba.tbadkCore.data.q qVar) {
        this.esY = eVar;
        this.esZ = tVar;
        this.eta = oVar;
        this.etb = qVar;
    }

    @Override // com.baidu.tieba.play.t.d
    public void onPrepared(com.baidu.tieba.play.t tVar) {
        Handler handler;
        Handler handler2;
        if (this.esZ != null && this.esZ.aOE != null) {
            if (tVar != null) {
                tVar.setVolume(0.0f, 0.0f);
            }
            this.esY.JU();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PB_VIDEO_PALY_ADD_COUNT, this.eta));
            handler = this.esY.mHandler;
            Message obtainMessage = handler.obtainMessage(1);
            obtainMessage.obj = this.etb;
            handler2 = this.esY.mHandler;
            handler2.sendMessage(obtainMessage);
        }
    }
}
