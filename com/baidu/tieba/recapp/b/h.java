package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes3.dex */
public class h extends q.a implements com.baidu.tieba.play.f {
    private com.baidu.tieba.lego.card.view.e<?> dSG;
    private com.baidu.tieba.recapp.i gFd;

    public h(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.dSG = eVar;
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.gFd = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.gFd == null) {
            return false;
        }
        return this.gFd.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.gFd == null) {
            return false;
        }
        return this.gFd.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.gFd != null) {
            this.gFd.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.gFd != null) {
            this.gFd.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.gFd == null) {
            return null;
        }
        return this.gFd.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.gFd == null ? "" : this.gFd.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.gFd == null) {
            return 0;
        }
        return (int) this.gFd.getCurrentPosition();
    }

    public void release() {
        if (this.gFd != null) {
            this.gFd.release();
        }
    }
}
