package com.baidu.tieba.recapp.adapter;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.recapp.j;
/* loaded from: classes8.dex */
public class FrsAppLegoViewHolder extends TypeAdapter.ViewHolder implements com.baidu.tieba.play.e {
    private com.baidu.tieba.lego.card.view.e<?> jDY;
    private j mRS;

    public FrsAppLegoViewHolder(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.jDY = eVar;
    }

    public void a(j jVar) {
        this.mRS = jVar;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.mRS == null) {
            return false;
        }
        return this.mRS.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.mRS == null) {
            return false;
        }
        return this.mRS.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.mRS != null) {
            this.mRS.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.mRS != null) {
            this.mRS.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.mRS == null) {
            return null;
        }
        return this.mRS.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.mRS == null ? "" : this.mRS.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.mRS == null) {
            return 0;
        }
        return (int) this.mRS.getCurrentPosition();
    }

    public void release() {
        if (this.mRS != null) {
            this.mRS.release();
        }
    }
}
