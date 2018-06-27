package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes3.dex */
public class h extends q.a implements com.baidu.tieba.play.f {
    private com.baidu.tieba.lego.card.view.e<?> dAe;
    private com.baidu.tieba.recapp.i gnw;

    public h(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.dAe = eVar;
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.gnw = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.gnw == null) {
            return false;
        }
        return this.gnw.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.gnw == null) {
            return false;
        }
        return this.gnw.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.gnw != null) {
            this.gnw.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.gnw != null) {
            this.gnw.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.gnw == null) {
            return null;
        }
        return this.gnw.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.gnw == null ? "" : this.gnw.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.gnw == null) {
            return 0;
        }
        return (int) this.gnw.getCurrentPosition();
    }

    public void release() {
        if (this.gnw != null) {
            this.gnw.release();
        }
    }
}
