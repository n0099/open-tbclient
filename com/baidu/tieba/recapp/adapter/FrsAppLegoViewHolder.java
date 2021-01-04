package com.baidu.tieba.recapp.adapter;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.recapp.j;
/* loaded from: classes8.dex */
public class FrsAppLegoViewHolder extends TypeAdapter.ViewHolder implements com.baidu.tieba.play.e {
    private com.baidu.tieba.lego.card.view.e<?> jCZ;
    private j mNq;

    public FrsAppLegoViewHolder(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.jCZ = eVar;
    }

    public void a(j jVar) {
        this.mNq = jVar;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.mNq == null) {
            return false;
        }
        return this.mNq.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.mNq == null) {
            return false;
        }
        return this.mNq.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.mNq != null) {
            this.mNq.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.mNq != null) {
            this.mNq.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.mNq == null) {
            return null;
        }
        return this.mNq.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.mNq == null ? "" : this.mNq.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.mNq == null) {
            return 0;
        }
        return (int) this.mNq.getCurrentPosition();
    }

    public void release() {
        if (this.mNq != null) {
            this.mNq.release();
        }
    }
}
