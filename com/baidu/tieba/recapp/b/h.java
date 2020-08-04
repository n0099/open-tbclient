package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.ad;
/* loaded from: classes20.dex */
public class h extends ad.a implements com.baidu.tieba.play.e {
    private com.baidu.tieba.lego.card.view.e<?> hZu;
    private com.baidu.tieba.recapp.h lmk;

    public h(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.hZu = eVar;
    }

    public void a(com.baidu.tieba.recapp.h hVar) {
        this.lmk = hVar;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.lmk == null) {
            return false;
        }
        return this.lmk.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.lmk == null) {
            return false;
        }
        return this.lmk.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.lmk != null) {
            this.lmk.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.lmk != null) {
            this.lmk.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.lmk == null) {
            return null;
        }
        return this.lmk.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.lmk == null ? "" : this.lmk.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.lmk == null) {
            return 0;
        }
        return (int) this.lmk.getCurrentPosition();
    }

    public void release() {
        if (this.lmk != null) {
            this.lmk.release();
        }
    }
}
