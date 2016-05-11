package com.baidu.tieba.pb.pb.a;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.view.at;
import com.baidu.tieba.pb.view.PbVideoControllerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ r dgC;
    private final /* synthetic */ an dgD;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s dgE;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.o dgF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(r rVar, an anVar, com.baidu.tbadk.widget.richText.o oVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.dgC = rVar;
        this.dgD = anVar;
        this.dgF = oVar;
        this.dgE = sVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Handler handler;
        Handler handler2;
        if (this.dgD != null && this.dgD.dgT != null && this.dgD.dgU != null) {
            int curProgress = this.dgD.dgU.getCurProgress();
            if (curProgress > 0) {
                float duration = curProgress * 1.0f * this.dgD.dgT.getDuration();
                PbVideoControllerView pbVideoControllerView = this.dgD.dgU;
                this.dgD.dgT.seekTo((int) (duration / 10000.0f));
            } else if (at.vD().vI()) {
                this.dgD.dgT.seekTo(0);
            }
            this.dgC.awc();
            this.dgC.c(this.dgF);
            this.dgC.a(this.dgD, this.dgF);
            handler = this.dgC.mHandler;
            Message obtainMessage = handler.obtainMessage(1);
            obtainMessage.obj = this.dgE;
            handler2 = this.dgC.mHandler;
            handler2.sendMessage(obtainMessage);
        }
    }
}
