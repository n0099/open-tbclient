package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes3.dex */
public class d extends q.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> dwQ;
    private com.baidu.tieba.recapp.i gjF;

    public d(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.dwQ = eVar;
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.gjF = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.gjF == null) {
            return false;
        }
        return this.gjF.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.gjF == null) {
            return false;
        }
        return this.gjF.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.gjF != null) {
            this.gjF.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.gjF != null) {
            this.gjF.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.gjF == null) {
            return null;
        }
        return this.gjF.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.gjF == null ? "" : this.gjF.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.gjF == null) {
            return 0;
        }
        return (int) this.gjF.getCurrentPosition();
    }
}
