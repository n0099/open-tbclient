package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes13.dex */
public class l extends v.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> gFU;
    private com.baidu.tieba.recapp.i jGv;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.gFU = eVar;
    }

    public void ccj() {
        if (this.gFU != null) {
            this.gFU.ccj();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.jGv = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.jGv == null) {
            return false;
        }
        return this.jGv.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.jGv == null) {
            return false;
        }
        return this.jGv.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.jGv != null) {
            this.jGv.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.jGv != null) {
            this.jGv.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.jGv == null) {
            return null;
        }
        return this.jGv.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.jGv == null ? "" : this.jGv.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.jGv == null) {
            return 0;
        }
        return (int) this.jGv.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.jGv != null) {
            return this.jGv.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.jGv != null) {
            this.jGv.autoPlay(i);
        }
    }

    public boolean fo(Context context) {
        if (this.jGv == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.jGv.getLocationInWindow(iArr);
        return iArr[1] + this.jGv.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.getEquipmentHeight(context);
    }
}
