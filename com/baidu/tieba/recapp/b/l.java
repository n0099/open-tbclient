package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
/* loaded from: classes26.dex */
public class l extends af.a implements com.baidu.tieba.play.e {
    com.baidu.tieba.lego.card.view.e<?> jqB;
    private com.baidu.tieba.recapp.j mIb;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.jqB = eVar;
    }

    public void deb() {
        if (this.jqB != null) {
            this.jqB.deb();
        }
    }

    public void a(com.baidu.tieba.recapp.j jVar) {
        this.mIb = jVar;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.mIb == null) {
            return false;
        }
        return this.mIb.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.mIb == null) {
            return false;
        }
        return this.mIb.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.mIb != null) {
            this.mIb.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.mIb != null) {
            this.mIb.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.mIb == null) {
            return null;
        }
        return this.mIb.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.mIb == null ? "" : this.mIb.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.mIb == null) {
            return 0;
        }
        return (int) this.mIb.getCurrentPosition();
    }

    public void release() {
        if (this.mIb != null) {
            this.mIb.release();
        }
    }

    public int getPlayStatus() {
        if (this.mIb != null) {
            return this.mIb.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.mIb != null) {
            this.mIb.autoPlay(i);
        }
    }

    public boolean canPlay() {
        if (this.mIb == null) {
            return false;
        }
        return this.mIb.canPlay();
    }
}
