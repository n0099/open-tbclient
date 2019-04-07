package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes3.dex */
public class l extends v.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> fpX;
    private com.baidu.tieba.recapp.i iha;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.fpX = eVar;
    }

    public void bAh() {
        if (this.fpX != null) {
            this.fpX.bAh();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.iha = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.iha == null) {
            return false;
        }
        return this.iha.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.iha == null) {
            return false;
        }
        return this.iha.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.iha != null) {
            this.iha.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.iha != null) {
            this.iha.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.iha == null) {
            return null;
        }
        return this.iha.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.iha == null ? "" : this.iha.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.iha == null) {
            return 0;
        }
        return (int) this.iha.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.iha != null) {
            return this.iha.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.iha != null) {
            this.iha.autoPlay(i);
        }
    }

    public boolean er(Context context) {
        if (this.iha == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.iha.getLocationInWindow(iArr);
        return iArr[1] + this.iha.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.aQ(context);
    }
}
