package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes10.dex */
public class l extends v.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> gAL;
    private com.baidu.tieba.recapp.i jBX;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.gAL = eVar;
    }

    public void bZz() {
        if (this.gAL != null) {
            this.gAL.bZz();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.jBX = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.jBX == null) {
            return false;
        }
        return this.jBX.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.jBX == null) {
            return false;
        }
        return this.jBX.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.jBX != null) {
            this.jBX.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.jBX != null) {
            this.jBX.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.jBX == null) {
            return null;
        }
        return this.jBX.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.jBX == null ? "" : this.jBX.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.jBX == null) {
            return 0;
        }
        return (int) this.jBX.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.jBX != null) {
            return this.jBX.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.jBX != null) {
            this.jBX.autoPlay(i);
        }
    }

    public boolean fo(Context context) {
        if (this.jBX == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.jBX.getLocationInWindow(iArr);
        return iArr[1] + this.jBX.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.getEquipmentHeight(context);
    }
}
