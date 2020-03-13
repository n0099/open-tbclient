package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes13.dex */
public class l extends v.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> gGi;
    private com.baidu.tieba.recapp.i jGJ;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.gGi = eVar;
    }

    public void ccm() {
        if (this.gGi != null) {
            this.gGi.ccm();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.jGJ = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.jGJ == null) {
            return false;
        }
        return this.jGJ.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.jGJ == null) {
            return false;
        }
        return this.jGJ.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.jGJ != null) {
            this.jGJ.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.jGJ != null) {
            this.jGJ.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.jGJ == null) {
            return null;
        }
        return this.jGJ.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.jGJ == null ? "" : this.jGJ.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.jGJ == null) {
            return 0;
        }
        return (int) this.jGJ.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.jGJ != null) {
            return this.jGJ.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.jGJ != null) {
            this.jGJ.autoPlay(i);
        }
    }

    public boolean fo(Context context) {
        if (this.jGJ == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.jGJ.getLocationInWindow(iArr);
        return iArr[1] + this.jGJ.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.getEquipmentHeight(context);
    }
}
