package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes13.dex */
public class l extends v.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> gFW;
    private com.baidu.tieba.recapp.i jGx;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.gFW = eVar;
    }

    public void ccl() {
        if (this.gFW != null) {
            this.gFW.ccl();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.jGx = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.jGx == null) {
            return false;
        }
        return this.jGx.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.jGx == null) {
            return false;
        }
        return this.jGx.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.jGx != null) {
            this.jGx.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.jGx != null) {
            this.jGx.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.jGx == null) {
            return null;
        }
        return this.jGx.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.jGx == null ? "" : this.jGx.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.jGx == null) {
            return 0;
        }
        return (int) this.jGx.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.jGx != null) {
            return this.jGx.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.jGx != null) {
            this.jGx.autoPlay(i);
        }
    }

    public boolean fo(Context context) {
        if (this.jGx == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.jGx.getLocationInWindow(iArr);
        return iArr[1] + this.jGx.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.getEquipmentHeight(context);
    }
}
