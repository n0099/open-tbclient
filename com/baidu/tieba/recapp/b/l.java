package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes3.dex */
public class l extends v.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> fNW;
    private com.baidu.tieba.recapp.i iJF;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.fNW = eVar;
    }

    public void bLD() {
        if (this.fNW != null) {
            this.fNW.bLD();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.iJF = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.iJF == null) {
            return false;
        }
        return this.iJF.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.iJF == null) {
            return false;
        }
        return this.iJF.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.iJF != null) {
            this.iJF.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.iJF != null) {
            this.iJF.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.iJF == null) {
            return null;
        }
        return this.iJF.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.iJF == null ? "" : this.iJF.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.iJF == null) {
            return 0;
        }
        return (int) this.iJF.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.iJF != null) {
            return this.iJF.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.iJF != null) {
            this.iJF.autoPlay(i);
        }
    }

    public boolean ek(Context context) {
        if (this.iJF == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.iJF.getLocationInWindow(iArr);
        return iArr[1] + this.iJF.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.ah(context);
    }
}
