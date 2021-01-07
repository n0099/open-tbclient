package com.baidu.tieba.recapp.adapter;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.recapp.j;
/* loaded from: classes8.dex */
public class FrsAppLegoViewHolder extends TypeAdapter.ViewHolder implements com.baidu.tieba.play.e {
    private com.baidu.tieba.lego.card.view.e<?> jCZ;
    private j mNp;

    public FrsAppLegoViewHolder(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.jCZ = eVar;
    }

    public void a(j jVar) {
        this.mNp = jVar;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        if (this.mNp == null) {
            return false;
        }
        return this.mNp.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        if (this.mNp == null) {
            return false;
        }
        return this.mNp.isPlaying();
    }

    @Override // com.baidu.tieba.play.e
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
        if (this.mNp != null) {
            this.mNp.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.mNp != null) {
            this.mNp.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.mNp == null) {
            return null;
        }
        return this.mNp.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        return this.mNp == null ? "" : this.mNp.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.mNp == null) {
            return 0;
        }
        return (int) this.mNp.getCurrentPosition();
    }

    public void release() {
        if (this.mNp != null) {
            this.mNp.release();
        }
    }
}
