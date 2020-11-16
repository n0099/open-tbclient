package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
/* loaded from: classes25.dex */
public class l extends af.a implements com.baidu.tieba.play.e {
    com.baidu.tieba.lego.card.view.e<?> jcY;
    private com.baidu.tieba.recapp.i mtT;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.jcY = eVar;
    }

    public void cYQ() {
        if (this.jcY != null) {
            this.jcY.cYQ();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.mtT = iVar;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.mtT == null) {
            return false;
        }
        return this.mtT.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.mtT == null) {
            return false;
        }
        return this.mtT.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.mtT != null) {
            this.mtT.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.mtT != null) {
            this.mtT.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.mtT == null) {
            return null;
        }
        return this.mtT.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.mtT == null ? "" : this.mtT.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.mtT == null) {
            return 0;
        }
        return (int) this.mtT.getCurrentPosition();
    }

    public void release() {
        if (this.mtT != null) {
            this.mtT.release();
        }
    }

    public int getPlayStatus() {
        if (this.mtT != null) {
            return this.mtT.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.mtT != null) {
            this.mtT.autoPlay(i);
        }
    }

    public boolean canPlay() {
        if (this.mtT == null) {
            return false;
        }
        return this.mtT.canPlay();
    }
}
