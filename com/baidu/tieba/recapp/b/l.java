package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
/* loaded from: classes26.dex */
public class l extends af.a implements com.baidu.tieba.play.e {
    com.baidu.tieba.lego.card.view.e<?> jqD;
    private com.baidu.tieba.recapp.j mIe;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.jqD = eVar;
    }

    public void dec() {
        if (this.jqD != null) {
            this.jqD.dec();
        }
    }

    public void a(com.baidu.tieba.recapp.j jVar) {
        this.mIe = jVar;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.mIe == null) {
            return false;
        }
        return this.mIe.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.mIe == null) {
            return false;
        }
        return this.mIe.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.mIe != null) {
            this.mIe.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.mIe != null) {
            this.mIe.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.mIe == null) {
            return null;
        }
        return this.mIe.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.mIe == null ? "" : this.mIe.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.mIe == null) {
            return 0;
        }
        return (int) this.mIe.getCurrentPosition();
    }

    public void release() {
        if (this.mIe != null) {
            this.mIe.release();
        }
    }

    public int getPlayStatus() {
        if (this.mIe != null) {
            return this.mIe.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.mIe != null) {
            this.mIe.autoPlay(i);
        }
    }

    public boolean canPlay() {
        if (this.mIe == null) {
            return false;
        }
        return this.mIe.canPlay();
    }
}
