package com.baidu.tieba.recapp.adapter;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.recapp.j;
/* loaded from: classes7.dex */
public class FrsAppLegoViewHolder extends TypeAdapter.ViewHolder implements com.baidu.tieba.play.e {
    private com.baidu.tieba.lego.card.view.e<?> jyt;
    private j mIK;

    public FrsAppLegoViewHolder(com.baidu.tieba.lego.card.view.e<?> eVar) {
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

    public void release() {
        if (this.mIK != null) {
            this.mIK.release();
        }
    }
}
