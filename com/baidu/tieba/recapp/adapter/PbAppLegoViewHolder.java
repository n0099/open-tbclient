package com.baidu.tieba.recapp.adapter;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.recapp.k;
/* loaded from: classes7.dex */
public class PbAppLegoViewHolder extends TypeAdapter.ViewHolder implements com.baidu.tieba.play.e {
    com.baidu.tieba.lego.card.view.e<?> jFV;
    private k mUs;

    public PbAppLegoViewHolder(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.jFV = eVar;
    }

    public void dck() {
        if (this.jFV != null) {
            this.jFV.dck();
        }
    }

    public void a(k kVar) {
        this.mUs = kVar;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.mUs == null) {
            return false;
        }
        return this.mUs.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.mUs == null) {
            return false;
        }
        return this.mUs.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.mUs != null) {
            this.mUs.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.mUs != null) {
            this.mUs.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.mUs == null) {
            return null;
        }
        return this.mUs.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.mUs == null ? "" : this.mUs.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.mUs == null) {
            return 0;
        }
        return (int) this.mUs.getCurrentPosition();
    }

    public void release() {
        if (this.mUs != null) {
            this.mUs.release();
        }
    }

    public int getPlayStatus() {
        if (this.mUs != null) {
            return this.mUs.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.mUs != null) {
            this.mUs.autoPlay(i);
        }
    }

    public boolean canPlay() {
        if (this.mUs == null) {
            return false;
        }
        return this.mUs.canPlay();
    }
}
