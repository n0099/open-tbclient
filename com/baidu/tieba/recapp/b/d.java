package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes11.dex */
public class d extends v.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> gDV;
    private com.baidu.tieba.recapp.i jFE;

    public d(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.gDV = eVar;
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.jFE = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.jFE == null) {
            return false;
        }
        return this.jFE.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.jFE == null) {
            return false;
        }
        return this.jFE.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.jFE != null) {
            this.jFE.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.jFE != null) {
            this.jFE.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.jFE == null) {
            return null;
        }
        return this.jFE.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.jFE == null ? "" : this.jFE.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.jFE == null) {
            return 0;
        }
        return (int) this.jFE.getCurrentPosition();
    }
}
