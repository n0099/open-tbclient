package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes3.dex */
public class h extends v.a implements com.baidu.tieba.play.f {
    private com.baidu.tieba.lego.card.view.e<?> fGt;
    private com.baidu.tieba.recapp.i izP;

    public h(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.fGt = eVar;
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.izP = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.izP == null) {
            return false;
        }
        return this.izP.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.izP == null) {
            return false;
        }
        return this.izP.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.izP != null) {
            this.izP.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.izP != null) {
            this.izP.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.izP == null) {
            return null;
        }
        return this.izP.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.izP == null ? "" : this.izP.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.izP == null) {
            return 0;
        }
        return (int) this.izP.getCurrentPosition();
    }

    public void release() {
        if (this.izP != null) {
            this.izP.release();
        }
    }
}
