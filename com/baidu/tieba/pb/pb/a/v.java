package com.baidu.tieba.pb.pb.a;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.pb.view.PbVideoControllerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ r dej;
    private final /* synthetic */ an dek;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s del;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.n dem;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(r rVar, an anVar, com.baidu.tbadk.widget.richText.n nVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.dej = rVar;
        this.dek = anVar;
        this.dem = nVar;
        this.del = sVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Handler handler;
        Handler handler2;
        if (this.dek != null && this.dek.deA != null && this.dek.deB != null) {
            int curProgress = this.dek.deB.getCurProgress();
            if (curProgress > 0) {
                float duration = curProgress * 1.0f * this.dek.deA.getDuration();
                PbVideoControllerView pbVideoControllerView = this.dek.deB;
                this.dek.deA.seekTo((int) (duration / 10000.0f));
            }
            this.dej.avT();
            this.dej.c(this.dem);
            this.dej.a(this.dek, this.dem);
            handler = this.dej.mHandler;
            Message obtainMessage = handler.obtainMessage(1);
            obtainMessage.obj = this.del;
            handler2 = this.dej.mHandler;
            handler2.sendMessage(obtainMessage);
        }
    }
}
