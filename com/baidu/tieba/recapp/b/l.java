package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
/* loaded from: classes20.dex */
public class l extends af.a implements com.baidu.tieba.play.e {
    com.baidu.tieba.lego.card.view.e<?> inJ;
    private com.baidu.tieba.recapp.h lCW;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.inJ = eVar;
    }

    public void cMw() {
        if (this.inJ != null) {
            this.inJ.cMw();
        }
    }

    public void a(com.baidu.tieba.recapp.h hVar) {
        this.lCW = hVar;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.lCW == null) {
            return false;
        }
        return this.lCW.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.lCW == null) {
            return false;
        }
        return this.lCW.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.lCW != null) {
            this.lCW.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.lCW != null) {
            this.lCW.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.lCW == null) {
            return null;
        }
        return this.lCW.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.lCW == null ? "" : this.lCW.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.lCW == null) {
            return 0;
        }
        return (int) this.lCW.getCurrentPosition();
    }

    public void release() {
        if (this.lCW != null) {
            this.lCW.release();
        }
    }

    public int getPlayStatus() {
        if (this.lCW != null) {
            return this.lCW.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.lCW != null) {
            this.lCW.autoPlay(i);
        }
    }

    public boolean canPlay() {
        if (this.lCW == null) {
            return false;
        }
        return this.lCW.canPlay();
    }
}
