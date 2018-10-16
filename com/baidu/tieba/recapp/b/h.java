package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes3.dex */
public class h extends q.a implements com.baidu.tieba.play.f {
    private com.baidu.tieba.lego.card.view.e<?> dRz;
    private com.baidu.tieba.recapp.i gDB;

    public h(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.dRz = eVar;
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.gDB = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.gDB == null) {
            return false;
        }
        return this.gDB.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.gDB == null) {
            return false;
        }
        return this.gDB.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.gDB != null) {
            this.gDB.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.gDB != null) {
            this.gDB.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.gDB == null) {
            return null;
        }
        return this.gDB.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.gDB == null ? "" : this.gDB.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.gDB == null) {
            return 0;
        }
        return (int) this.gDB.getCurrentPosition();
    }

    public void release() {
        if (this.gDB != null) {
            this.gDB.release();
        }
    }
}
