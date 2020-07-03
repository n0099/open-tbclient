package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.ad;
/* loaded from: classes13.dex */
public class d extends ad.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> hTt;
    private com.baidu.tieba.recapp.h leU;

    public d(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.hTt = eVar;
    }

    public void a(com.baidu.tieba.recapp.h hVar) {
        this.leU = hVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.leU == null) {
            return false;
        }
        return this.leU.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.leU == null) {
            return false;
        }
        return this.leU.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.leU != null) {
            this.leU.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.leU != null) {
            this.leU.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.leU == null) {
            return null;
        }
        return this.leU.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.leU == null ? "" : this.leU.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.leU == null) {
            return 0;
        }
        return (int) this.leU.getCurrentPosition();
    }
}
