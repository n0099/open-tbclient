package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
/* loaded from: classes26.dex */
public class d extends af.a implements com.baidu.tieba.play.e {
    com.baidu.tieba.lego.card.view.e<?> jqB;
    private com.baidu.tieba.recapp.j mIb;

    public d(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.jqB = eVar;
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

    public boolean canPlay() {
        return this.mIb != null && this.mIb.canPlay();
    }

    public void autoPlay(int i) {
        if (this.mIb != null) {
            this.mIb.autoPlay(i);
        }
    }

    public int getPlayStatus() {
        if (this.mIb == null) {
            return -2;
        }
        return this.mIb.getPlayStatus();
    }
}
