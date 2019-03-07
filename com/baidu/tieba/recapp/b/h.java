package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes3.dex */
public class h extends v.a implements com.baidu.tieba.play.f {
    private com.baidu.tieba.lego.card.view.e<?> fqm;
    private com.baidu.tieba.recapp.i iht;

    public h(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.fqm = eVar;
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.iht = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.iht == null) {
            return false;
        }
        return this.iht.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.iht == null) {
            return false;
        }
        return this.iht.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.iht != null) {
            this.iht.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.iht != null) {
            this.iht.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.iht == null) {
            return null;
        }
        return this.iht.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.iht == null ? "" : this.iht.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.iht == null) {
            return 0;
        }
        return (int) this.iht.getCurrentPosition();
    }

    public void release() {
        if (this.iht != null) {
            this.iht.release();
        }
    }
}
