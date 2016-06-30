package com.baidu.tieba.pb.pb.a;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ e dML;
    private final /* synthetic */ y dMM;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.o dMN;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s dMO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(e eVar, y yVar, com.baidu.tbadk.widget.richText.o oVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.dML = eVar;
        this.dMM = yVar;
        this.dMN = oVar;
        this.dMO = sVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Handler handler;
        Handler handler2;
        if (this.dMM != null && this.dMM.aJJ != null) {
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(0.0f, 0.0f);
            }
            this.dML.aEq();
            this.dML.c(this.dMN);
            this.dML.a(this.dMM, this.dMN);
            handler = this.dML.mHandler;
            Message obtainMessage = handler.obtainMessage(1);
            obtainMessage.obj = this.dMO;
            handler2 = this.dML.mHandler;
            handler2.sendMessage(obtainMessage);
        }
    }
}
