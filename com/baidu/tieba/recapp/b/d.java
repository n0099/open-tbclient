package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes3.dex */
public class d extends q.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> dmr;
    private com.baidu.tieba.recapp.i fXh;

    public d(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.dmr = eVar;
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.fXh = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.fXh == null) {
            return false;
        }
        return this.fXh.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.fXh == null) {
            return false;
        }
        return this.fXh.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.fXh != null) {
            this.fXh.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.fXh != null) {
            this.fXh.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.fXh == null) {
            return null;
        }
        return this.fXh.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.fXh == null ? "" : this.fXh.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.fXh == null) {
            return 0;
        }
        return (int) this.fXh.getCurrentPosition();
    }
}
