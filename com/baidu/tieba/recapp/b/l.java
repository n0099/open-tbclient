package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.y;
/* loaded from: classes13.dex */
public class l extends y.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> hqz;
    private com.baidu.tieba.recapp.h krT;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.hqz = eVar;
    }

    public void cng() {
        if (this.hqz != null) {
            this.hqz.cng();
        }
    }

    public void a(com.baidu.tieba.recapp.h hVar) {
        this.krT = hVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.krT == null) {
            return false;
        }
        return this.krT.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.krT == null) {
            return false;
        }
        return this.krT.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.krT != null) {
            this.krT.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.krT != null) {
            this.krT.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.krT == null) {
            return null;
        }
        return this.krT.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.krT == null ? "" : this.krT.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.krT == null) {
            return 0;
        }
        return (int) this.krT.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.krT != null) {
            return this.krT.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.krT != null) {
            this.krT.autoPlay(i);
        }
    }

    public boolean ff(Context context) {
        if (this.krT == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.krT.getLocationInWindow(iArr);
        return iArr[1] + this.krT.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.getEquipmentHeight(context);
    }
}
