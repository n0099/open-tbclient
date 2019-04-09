package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes3.dex */
public class h extends v.a implements com.baidu.tieba.play.f {
    private com.baidu.tieba.lego.card.view.e<?> fpX;
    private com.baidu.tieba.recapp.i ihb;

    public h(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.fpX = eVar;
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.ihb = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.ihb == null) {
            return false;
        }
        return this.ihb.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.ihb == null) {
            return false;
        }
        return this.ihb.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.ihb != null) {
            this.ihb.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.ihb != null) {
            this.ihb.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.ihb == null) {
            return null;
        }
        return this.ihb.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.ihb == null ? "" : this.ihb.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.ihb == null) {
            return 0;
        }
        return (int) this.ihb.getCurrentPosition();
    }

    public void release() {
        if (this.ihb != null) {
            this.ihb.release();
        }
    }
}
