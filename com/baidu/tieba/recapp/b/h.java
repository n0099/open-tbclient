package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
/* loaded from: classes26.dex */
public class h extends af.a implements com.baidu.tieba.play.e {
    private com.baidu.tieba.lego.card.view.e<?> iWo;
    private com.baidu.tieba.recapp.h mnF;

    public h(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.iWo = eVar;
    }

    public void a(com.baidu.tieba.recapp.h hVar) {
        this.mnF = hVar;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.mnF == null) {
            return false;
        }
        return this.mnF.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.mnF == null) {
            return false;
        }
        return this.mnF.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.mnF != null) {
            this.mnF.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.mnF != null) {
            this.mnF.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.mnF == null) {
            return null;
        }
        return this.mnF.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.mnF == null ? "" : this.mnF.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.mnF == null) {
            return 0;
        }
        return (int) this.mnF.getCurrentPosition();
    }

    public void release() {
        if (this.mnF != null) {
            this.mnF.release();
        }
    }
}
