package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.r;
/* loaded from: classes3.dex */
public class d extends r.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.e.k<?> dSk;
    private com.baidu.tieba.recapp.i gCx;

    public d(com.baidu.tieba.lego.card.e.k<?> kVar) {
        super((View) kVar);
        this.dSk = kVar;
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.gCx = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.gCx == null) {
            return false;
        }
        return this.gCx.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.gCx == null) {
            return false;
        }
        return this.gCx.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.gCx != null) {
            this.gCx.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.gCx != null) {
            this.gCx.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.gCx == null) {
            return null;
        }
        return this.gCx.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.gCx == null ? "" : this.gCx.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.gCx == null) {
            return 0;
        }
        return (int) this.gCx.getCurrentPosition();
    }
}
