package com.baidu.tieba.pb.pb.a;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.view.PbVideoControllerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ q cKS;
    private final /* synthetic */ am cKT;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.r cKU;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.m cKV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(q qVar, am amVar, com.baidu.tbadk.widget.richText.m mVar, com.baidu.tieba.tbadkCore.data.r rVar) {
        this.cKS = qVar;
        this.cKT = amVar;
        this.cKV = mVar;
        this.cKU = rVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Handler handler;
        Handler handler2;
        if (this.cKT != null && this.cKT.cLk != null && this.cKT.cLl != null) {
            int curProgress = this.cKT.cLl.getCurProgress();
            if (curProgress > 0) {
                float duration = curProgress * 1.0f * this.cKT.cLk.getDuration();
                PbVideoControllerView pbVideoControllerView = this.cKT.cLl;
                this.cKT.cLk.seekTo((int) (duration / 10000.0f));
            }
            this.cKS.apc();
            this.cKS.c(this.cKV);
            this.cKS.a(this.cKT, this.cKV);
            handler = this.cKS.mHandler;
            Message obtainMessage = handler.obtainMessage(1);
            obtainMessage.obj = this.cKU;
            handler2 = this.cKS.mHandler;
            handler2.sendMessage(obtainMessage);
        }
    }
}
