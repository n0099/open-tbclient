package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes13.dex */
public class h extends v.a implements com.baidu.tieba.play.f {
    private com.baidu.tieba.lego.card.view.e<?> gGi;
    private com.baidu.tieba.recapp.i jGJ;

    public h(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.gGi = eVar;
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.jGJ = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.jGJ == null) {
            return false;
        }
        return this.jGJ.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.jGJ == null) {
            return false;
        }
        return this.jGJ.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.jGJ != null) {
            this.jGJ.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.jGJ != null) {
            this.jGJ.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.jGJ == null) {
            return null;
        }
        return this.jGJ.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.jGJ == null ? "" : this.jGJ.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.jGJ == null) {
            return 0;
        }
        return (int) this.jGJ.getCurrentPosition();
    }

    public void release() {
        if (this.jGJ != null) {
            this.jGJ.release();
        }
    }
}
