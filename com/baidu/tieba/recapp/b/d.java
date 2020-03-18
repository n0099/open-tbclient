package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes13.dex */
public class d extends v.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> gHg;
    private com.baidu.tieba.recapp.i jIi;

    public d(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.gHg = eVar;
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.jIi = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.jIi == null) {
            return false;
        }
        return this.jIi.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.jIi == null) {
            return false;
        }
        return this.jIi.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.jIi != null) {
            this.jIi.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.jIi != null) {
            this.jIi.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.jIi == null) {
            return null;
        }
        return this.jIi.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.jIi == null ? "" : this.jIi.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.jIi == null) {
            return 0;
        }
        return (int) this.jIi.getCurrentPosition();
    }
}
