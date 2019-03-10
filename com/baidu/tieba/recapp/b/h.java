package com.baidu.tieba.recapp.b;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes3.dex */
public class h extends v.a implements com.baidu.tieba.play.f {
    private com.baidu.tieba.lego.card.view.e<?> fqm;
    private com.baidu.tieba.recapp.i ihu;

    public h(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.fqm = eVar;
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.ihu = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.ihu == null) {
            return false;
        }
        return this.ihu.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.ihu == null) {
            return false;
        }
        return this.ihu.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.ihu != null) {
            this.ihu.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.ihu != null) {
            this.ihu.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.ihu == null) {
            return null;
        }
        return this.ihu.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.ihu == null ? "" : this.ihu.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.ihu == null) {
            return 0;
        }
        return (int) this.ihu.getCurrentPosition();
    }

    public void release() {
        if (this.ihu != null) {
            this.ihu.release();
        }
    }
}
