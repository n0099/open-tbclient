package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
/* loaded from: classes20.dex */
public class d extends af.a implements com.baidu.tieba.play.e {
    com.baidu.tieba.lego.card.view.e<?> inD;
    private com.baidu.tieba.recapp.h lCL;

    public d(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.inD = eVar;
    }

    public void a(com.baidu.tieba.recapp.h hVar) {
        this.lCL = hVar;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.lCL == null) {
            return false;
        }
        return this.lCL.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.lCL == null) {
            return false;
        }
        return this.lCL.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.lCL != null) {
            this.lCL.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.lCL != null) {
            this.lCL.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.lCL == null) {
            return null;
        }
        return this.lCL.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.lCL == null ? "" : this.lCL.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.lCL == null) {
            return 0;
        }
        return (int) this.lCL.getCurrentPosition();
    }
}
