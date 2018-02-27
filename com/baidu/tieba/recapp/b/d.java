package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.r;
/* loaded from: classes3.dex */
public class d extends r.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.e.k<?> dSf;
    private com.baidu.tieba.recapp.i gCh;

    public d(com.baidu.tieba.lego.card.e.k<?> kVar) {
        super((View) kVar);
        this.dSf = kVar;
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.gCh = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.gCh == null) {
            return false;
        }
        return this.gCh.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.gCh == null) {
            return false;
        }
        return this.gCh.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.gCh != null) {
            this.gCh.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.gCh != null) {
            this.gCh.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.gCh == null) {
            return null;
        }
        return this.gCh.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.gCh == null ? "" : this.gCh.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.gCh == null) {
            return 0;
        }
        return (int) this.gCh.getCurrentPosition();
    }
}
