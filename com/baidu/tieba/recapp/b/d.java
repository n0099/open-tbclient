package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes11.dex */
public class d extends v.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> gDV;
    private com.baidu.tieba.recapp.i jFz;

    public d(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.gDV = eVar;
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.jFz = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.jFz == null) {
            return false;
        }
        return this.jFz.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.jFz == null) {
            return false;
        }
        return this.jFz.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.jFz != null) {
            this.jFz.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.jFz != null) {
            this.jFz.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.jFz == null) {
            return null;
        }
        return this.jFz.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.jFz == null ? "" : this.jFz.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.jFz == null) {
            return 0;
        }
        return (int) this.jFz.getCurrentPosition();
    }
}
