package com.baidu.tieba.recapp.adapter;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.recapp.j;
/* loaded from: classes7.dex */
public class CardAppLegoViewHolder extends TypeAdapter.ViewHolder implements com.baidu.tieba.play.e {
    com.baidu.tieba.lego.card.view.e<?> jyt;
    private j mIK;

    public CardAppLegoViewHolder(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.jyt = eVar;
    }

    public void a(j jVar) {
        this.mIK = jVar;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.mIK == null) {
            return false;
        }
        return this.mIK.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.mIK == null) {
            return false;
        }
        return this.mIK.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.mIK != null) {
            this.mIK.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.mIK != null) {
            this.mIK.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.mIK == null) {
            return null;
        }
        return this.mIK.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.mIK == null ? "" : this.mIK.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.mIK == null) {
            return 0;
        }
        return (int) this.mIK.getCurrentPosition();
    }

    public boolean canPlay() {
        return this.mIK != null && this.mIK.canPlay();
    }

    public void autoPlay(int i) {
        if (this.mIK != null) {
            this.mIK.autoPlay(i);
        }
    }

    public int getPlayStatus() {
        if (this.mIK == null) {
            return -2;
        }
        return this.mIK.getPlayStatus();
    }
}
