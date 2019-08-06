package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes3.dex */
public class l extends v.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> fMh;
    private com.baidu.tieba.recapp.i iHm;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.fMh = eVar;
    }

    public void bKQ() {
        if (this.fMh != null) {
            this.fMh.bKQ();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.iHm = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.iHm == null) {
            return false;
        }
        return this.iHm.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.iHm == null) {
            return false;
        }
        return this.iHm.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.iHm != null) {
            this.iHm.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.iHm != null) {
            this.iHm.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.iHm == null) {
            return null;
        }
        return this.iHm.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.iHm == null ? "" : this.iHm.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.iHm == null) {
            return 0;
        }
        return (int) this.iHm.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.iHm != null) {
            return this.iHm.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.iHm != null) {
            this.iHm.autoPlay(i);
        }
    }

    public boolean ej(Context context) {
        if (this.iHm == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.iHm.getLocationInWindow(iArr);
        return iArr[1] + this.iHm.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.ah(context);
    }
}
