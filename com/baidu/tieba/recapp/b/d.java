package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
/* loaded from: classes26.dex */
public class d extends af.a implements com.baidu.tieba.play.e {
    com.baidu.tieba.lego.card.view.e<?> iJS;
    private com.baidu.tieba.recapp.h mbh;

    public d(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.iJS = eVar;
    }

    public void a(com.baidu.tieba.recapp.h hVar) {
        this.mbh = hVar;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.mbh == null) {
            return false;
        }
        return this.mbh.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.mbh == null) {
            return false;
        }
        return this.mbh.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.mbh != null) {
            this.mbh.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.mbh != null) {
            this.mbh.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.mbh == null) {
            return null;
        }
        return this.mbh.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.mbh == null ? "" : this.mbh.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.mbh == null) {
            return 0;
        }
        return (int) this.mbh.getCurrentPosition();
    }
}
