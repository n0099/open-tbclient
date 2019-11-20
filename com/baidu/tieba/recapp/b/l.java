package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes3.dex */
public class l extends v.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> fMy;
    private com.baidu.tieba.recapp.i iHF;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.fMy = eVar;
    }

    public void bIl() {
        if (this.fMy != null) {
            this.fMy.bIl();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.iHF = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.iHF == null) {
            return false;
        }
        return this.iHF.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.iHF == null) {
            return false;
        }
        return this.iHF.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.iHF != null) {
            this.iHF.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.iHF != null) {
            this.iHF.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.iHF == null) {
            return null;
        }
        return this.iHF.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.iHF == null ? "" : this.iHF.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.iHF == null) {
            return 0;
        }
        return (int) this.iHF.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.iHF != null) {
            return this.iHF.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.iHF != null) {
            this.iHF.autoPlay(i);
        }
    }

    public boolean dW(Context context) {
        if (this.iHF == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.iHF.getLocationInWindow(iArr);
        return iArr[1] + this.iHF.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.getEquipmentHeight(context);
    }
}
