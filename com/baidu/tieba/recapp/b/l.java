package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes3.dex */
public class l extends v.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> fGt;
    private com.baidu.tieba.recapp.i izP;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.fGt = eVar;
    }

    public void bHU() {
        if (this.fGt != null) {
            this.fGt.bHU();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.izP = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.izP == null) {
            return false;
        }
        return this.izP.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.izP == null) {
            return false;
        }
        return this.izP.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.izP != null) {
            this.izP.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.izP != null) {
            this.izP.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.izP == null) {
            return null;
        }
        return this.izP.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.izP == null ? "" : this.izP.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.izP == null) {
            return 0;
        }
        return (int) this.izP.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.izP != null) {
            return this.izP.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.izP != null) {
            this.izP.autoPlay(i);
        }
    }

    public boolean eh(Context context) {
        if (this.izP == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.izP.getLocationInWindow(iArr);
        return iArr[1] + this.izP.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.ah(context);
    }
}
