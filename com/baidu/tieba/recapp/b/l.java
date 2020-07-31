package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.ad;
/* loaded from: classes20.dex */
public class l extends ad.a implements com.baidu.tieba.play.e {
    com.baidu.tieba.lego.card.view.e<?> hZs;
    private com.baidu.tieba.recapp.h lmi;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.hZs = eVar;
    }

    public void cBD() {
        if (this.hZs != null) {
            this.hZs.cBD();
        }
    }

    public void a(com.baidu.tieba.recapp.h hVar) {
        this.lmi = hVar;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.lmi == null) {
            return false;
        }
        return this.lmi.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.lmi == null) {
            return false;
        }
        return this.lmi.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.lmi != null) {
            this.lmi.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.lmi != null) {
            this.lmi.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.lmi == null) {
            return null;
        }
        return this.lmi.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.lmi == null ? "" : this.lmi.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.lmi == null) {
            return 0;
        }
        return (int) this.lmi.getCurrentPosition();
    }

    public void release() {
        if (this.lmi != null) {
            this.lmi.release();
        }
    }

    public int getPlayStatus() {
        if (this.lmi != null) {
            return this.lmi.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.lmi != null) {
            this.lmi.autoPlay(i);
        }
    }

    public boolean canPlay() {
        if (this.lmi == null) {
            return false;
        }
        return this.lmi.canPlay();
    }
}
