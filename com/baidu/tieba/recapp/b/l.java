package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
/* loaded from: classes26.dex */
public class l extends af.a implements com.baidu.tieba.play.e {
    com.baidu.tieba.lego.card.view.e<?> jcl;
    private com.baidu.tieba.recapp.h mtD;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.jcl = eVar;
    }

    public void cZu() {
        if (this.jcl != null) {
            this.jcl.cZu();
        }
    }

    public void a(com.baidu.tieba.recapp.h hVar) {
        this.mtD = hVar;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.mtD == null) {
            return false;
        }
        return this.mtD.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.mtD == null) {
            return false;
        }
        return this.mtD.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.mtD != null) {
            this.mtD.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.mtD != null) {
            this.mtD.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.mtD == null) {
            return null;
        }
        return this.mtD.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.mtD == null ? "" : this.mtD.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.mtD == null) {
            return 0;
        }
        return (int) this.mtD.getCurrentPosition();
    }

    public void release() {
        if (this.mtD != null) {
            this.mtD.release();
        }
    }

    public int getPlayStatus() {
        if (this.mtD != null) {
            return this.mtD.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.mtD != null) {
            this.mtD.autoPlay(i);
        }
    }

    public boolean canPlay() {
        if (this.mtD == null) {
            return false;
        }
        return this.mtD.canPlay();
    }
}
