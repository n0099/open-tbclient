package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes3.dex */
public class h extends v.a implements com.baidu.tieba.play.f {
    private com.baidu.tieba.lego.card.view.e<?> fMh;
    private com.baidu.tieba.recapp.i iHm;

    public h(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.fMh = eVar;
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.iHm = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.iHm == null) {
            return false;
        }
        return this.iHm.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.iHm == null) {
            return false;
        }
        return this.iHm.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.iHm != null) {
            this.iHm.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.iHm != null) {
            this.iHm.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.iHm == null) {
            return null;
        }
        return this.iHm.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.iHm == null ? "" : this.iHm.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.iHm == null) {
            return 0;
        }
        return (int) this.iHm.getCurrentPosition();
    }

    public void release() {
        if (this.iHm != null) {
            this.iHm.release();
        }
    }
}
