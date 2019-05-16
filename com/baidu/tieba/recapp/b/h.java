package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes3.dex */
public class h extends v.a implements com.baidu.tieba.play.f {
    private com.baidu.tieba.lego.card.view.e<?> fGs;
    private com.baidu.tieba.recapp.i izN;

    public h(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.fGs = eVar;
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.izN = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.izN == null) {
            return false;
        }
        return this.izN.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.izN == null) {
            return false;
        }
        return this.izN.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.izN != null) {
            this.izN.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.izN != null) {
            this.izN.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.izN == null) {
            return null;
        }
        return this.izN.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.izN == null ? "" : this.izN.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.izN == null) {
            return 0;
        }
        return (int) this.izN.getCurrentPosition();
    }

    public void release() {
        if (this.izN != null) {
            this.izN.release();
        }
    }
}
