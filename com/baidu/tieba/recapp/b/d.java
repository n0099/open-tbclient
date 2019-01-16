package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes3.dex */
public class d extends q.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> ecG;
    private com.baidu.tieba.recapp.i gPO;

    public d(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.ecG = eVar;
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.gPO = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.gPO == null) {
            return false;
        }
        return this.gPO.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.gPO == null) {
            return false;
        }
        return this.gPO.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.gPO != null) {
            this.gPO.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.gPO != null) {
            this.gPO.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.gPO == null) {
            return null;
        }
        return this.gPO.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.gPO == null ? "" : this.gPO.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.gPO == null) {
            return 0;
        }
        return (int) this.gPO.getCurrentPosition();
    }
}
