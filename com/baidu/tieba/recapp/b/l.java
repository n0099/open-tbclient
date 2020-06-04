package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.aa;
/* loaded from: classes13.dex */
public class l extends aa.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> hGg;
    private com.baidu.tieba.recapp.h kLa;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.hGg = eVar;
    }

    public void ctP() {
        if (this.hGg != null) {
            this.hGg.ctP();
        }
    }

    public void a(com.baidu.tieba.recapp.h hVar) {
        this.kLa = hVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.kLa == null) {
            return false;
        }
        return this.kLa.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.kLa == null) {
            return false;
        }
        return this.kLa.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.kLa != null) {
            this.kLa.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.kLa != null) {
            this.kLa.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.kLa == null) {
            return null;
        }
        return this.kLa.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.kLa == null ? "" : this.kLa.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.kLa == null) {
            return 0;
        }
        return (int) this.kLa.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.kLa != null) {
            return this.kLa.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.kLa != null) {
            this.kLa.autoPlay(i);
        }
    }

    public boolean fi(Context context) {
        if (this.kLa == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.kLa.getLocationInWindow(iArr);
        return iArr[1] + this.kLa.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.getEquipmentHeight(context);
    }
}
