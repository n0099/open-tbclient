package com.baidu.tieba.pb.pb.a;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ e dYX;
    private final /* synthetic */ y dYY;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.o dYZ;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s dZa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(e eVar, y yVar, com.baidu.tbadk.widget.richText.o oVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.dYX = eVar;
        this.dYY = yVar;
        this.dYZ = oVar;
        this.dZa = sVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Handler handler;
        Handler handler2;
        if (this.dYY != null && this.dYY.aKC != null) {
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(0.0f, 0.0f);
            }
            this.dYX.aHA();
            this.dYX.c(this.dYZ);
            this.dYX.a(this.dYY, this.dYZ);
            handler = this.dYX.mHandler;
            Message obtainMessage = handler.obtainMessage(1);
            obtainMessage.obj = this.dZa;
            handler2 = this.dYX.mHandler;
            handler2.sendMessage(obtainMessage);
        }
    }
}
