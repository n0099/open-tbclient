package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
/* loaded from: classes25.dex */
public class l extends af.a implements com.baidu.tieba.play.e {
    com.baidu.tieba.lego.card.view.e<?> iuZ;
    private com.baidu.tieba.recapp.h lLQ;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.iuZ = eVar;
    }

    public void cQc() {
        if (this.iuZ != null) {
            this.iuZ.cQc();
        }
    }

    public void a(com.baidu.tieba.recapp.h hVar) {
        this.lLQ = hVar;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.lLQ == null) {
            return false;
        }
        return this.lLQ.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.lLQ == null) {
            return false;
        }
        return this.lLQ.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.lLQ != null) {
            this.lLQ.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.lLQ != null) {
            this.lLQ.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.lLQ == null) {
            return null;
        }
        return this.lLQ.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.lLQ == null ? "" : this.lLQ.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.lLQ == null) {
            return 0;
        }
        return (int) this.lLQ.getCurrentPosition();
    }

    public void release() {
        if (this.lLQ != null) {
            this.lLQ.release();
        }
    }

    public int getPlayStatus() {
        if (this.lLQ != null) {
            return this.lLQ.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.lLQ != null) {
            this.lLQ.autoPlay(i);
        }
    }

    public boolean canPlay() {
        if (this.lLQ == null) {
            return false;
        }
        return this.lLQ.canPlay();
    }
}
