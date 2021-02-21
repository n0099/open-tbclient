package com.baidu.tieba.recapp.adapter;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.recapp.k;
/* loaded from: classes8.dex */
public class FrsAppLegoViewHolder extends TypeAdapter.ViewHolder implements com.baidu.tieba.play.e {
    private com.baidu.tieba.lego.card.view.e<?> jEm;
    private k mSk;

    public FrsAppLegoViewHolder(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.jEm = eVar;
    }

    public void a(k kVar) {
        this.mSk = kVar;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.mSk == null) {
            return false;
        }
        return this.mSk.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.mSk == null) {
            return false;
        }
        return this.mSk.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.mSk != null) {
            this.mSk.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.mSk != null) {
            this.mSk.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.mSk == null) {
            return null;
        }
        return this.mSk.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.mSk == null ? "" : this.mSk.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.mSk == null) {
            return 0;
        }
        return (int) this.mSk.getCurrentPosition();
    }

    public void release() {
        if (this.mSk != null) {
            this.mSk.release();
        }
    }
}
