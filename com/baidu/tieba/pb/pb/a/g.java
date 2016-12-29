package com.baidu.tieba.pb.pb.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.play.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements t.d {
    final /* synthetic */ d dXu;
    private final /* synthetic */ s dXv;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.n dXw;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.q dXx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, s sVar, com.baidu.tbadk.widget.richText.n nVar, com.baidu.tieba.tbadkCore.data.q qVar) {
        this.dXu = dVar;
        this.dXv = sVar;
        this.dXw = nVar;
        this.dXx = qVar;
    }

    @Override // com.baidu.tieba.play.t.d
    public void onPrepared(com.baidu.tieba.play.t tVar) {
        Handler handler;
        Handler handler2;
        if (this.dXv != null && this.dXv.aNV != null) {
            if (tVar != null) {
                tVar.setVolume(0.0f, 0.0f);
            }
            this.dXu.Jn();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PB_VIDEO_PALY_ADD_COUNT, this.dXw));
            handler = this.dXu.mHandler;
            Message obtainMessage = handler.obtainMessage(1);
            obtainMessage.obj = this.dXx;
            handler2 = this.dXu.mHandler;
            handler2.sendMessage(obtainMessage);
        }
    }
}
