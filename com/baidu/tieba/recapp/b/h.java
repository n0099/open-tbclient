package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes3.dex */
public class h extends v.a implements com.baidu.tieba.play.f {
    private com.baidu.tieba.lego.card.view.e<?> fql;
    private com.baidu.tieba.recapp.i iho;

    public h(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.fql = eVar;
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.iho = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.iho == null) {
            return false;
        }
        return this.iho.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.iho == null) {
            return false;
        }
        return this.iho.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.iho != null) {
            this.iho.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.iho != null) {
            this.iho.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.iho == null) {
            return null;
        }
        return this.iho.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.iho == null ? "" : this.iho.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.iho == null) {
            return 0;
        }
        return (int) this.iho.getCurrentPosition();
    }

    public void release() {
        if (this.iho != null) {
            this.iho.release();
        }
    }
}
