package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.aa;
/* loaded from: classes13.dex */
public class l extends aa.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> hFt;
    private com.baidu.tieba.recapp.h kJR;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.hFt = eVar;
    }

    public void ctG() {
        if (this.hFt != null) {
            this.hFt.ctG();
        }
    }

    public void a(com.baidu.tieba.recapp.h hVar) {
        this.kJR = hVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.kJR == null) {
            return false;
        }
        return this.kJR.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.kJR == null) {
            return false;
        }
        return this.kJR.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.kJR != null) {
            this.kJR.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.kJR != null) {
            this.kJR.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.kJR == null) {
            return null;
        }
        return this.kJR.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.kJR == null ? "" : this.kJR.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.kJR == null) {
            return 0;
        }
        return (int) this.kJR.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.kJR != null) {
            return this.kJR.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.kJR != null) {
            this.kJR.autoPlay(i);
        }
    }

    public boolean fi(Context context) {
        if (this.kJR == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.kJR.getLocationInWindow(iArr);
        return iArr[1] + this.kJR.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.getEquipmentHeight(context);
    }
}
