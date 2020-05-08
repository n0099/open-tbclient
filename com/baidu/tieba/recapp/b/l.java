package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.y;
/* loaded from: classes13.dex */
public class l extends y.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> hqF;
    private com.baidu.tieba.recapp.h krX;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.hqF = eVar;
    }

    public void cnd() {
        if (this.hqF != null) {
            this.hqF.cnd();
        }
    }

    public void a(com.baidu.tieba.recapp.h hVar) {
        this.krX = hVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.krX == null) {
            return false;
        }
        return this.krX.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.krX == null) {
            return false;
        }
        return this.krX.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.krX != null) {
            this.krX.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.krX != null) {
            this.krX.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.krX == null) {
            return null;
        }
        return this.krX.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.krX == null ? "" : this.krX.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.krX == null) {
            return 0;
        }
        return (int) this.krX.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.krX != null) {
            return this.krX.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.krX != null) {
            this.krX.autoPlay(i);
        }
    }

    public boolean eT(Context context) {
        if (this.krX == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.krX.getLocationInWindow(iArr);
        return iArr[1] + this.krX.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.getEquipmentHeight(context);
    }
}
