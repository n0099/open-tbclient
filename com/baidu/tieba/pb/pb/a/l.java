package com.baidu.tieba.pb.pb.a;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ e elb;
    private final /* synthetic */ y elc;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.o eld;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.q ele;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(e eVar, y yVar, com.baidu.tbadk.widget.richText.o oVar, com.baidu.tieba.tbadkCore.data.q qVar) {
        this.elb = eVar;
        this.elc = yVar;
        this.eld = oVar;
        this.ele = qVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Handler handler;
        Handler handler2;
        if (this.elc != null && this.elc.aPh != null) {
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(0.0f, 0.0f);
            }
            this.elb.aMs();
            this.elb.c(this.eld);
            this.elb.a(this.elc, this.eld);
            handler = this.elb.mHandler;
            Message obtainMessage = handler.obtainMessage(1);
            obtainMessage.obj = this.ele;
            handler2 = this.elb.mHandler;
            handler2.sendMessage(obtainMessage);
        }
    }
}
