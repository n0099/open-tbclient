package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes3.dex */
public class h extends v.a implements com.baidu.tieba.play.f {
    private com.baidu.tieba.lego.card.view.e<?> fLt;
    private com.baidu.tieba.recapp.i iGi;

    public h(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.fLt = eVar;
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.iGi = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.iGi == null) {
            return false;
        }
        return this.iGi.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.iGi == null) {
            return false;
        }
        return this.iGi.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.iGi != null) {
            this.iGi.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.iGi != null) {
            this.iGi.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.iGi == null) {
            return null;
        }
        return this.iGi.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.iGi == null ? "" : this.iGi.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.iGi == null) {
            return 0;
        }
        return (int) this.iGi.getCurrentPosition();
    }

    public void release() {
        if (this.iGi != null) {
            this.iGi.release();
        }
    }
}
