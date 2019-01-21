package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes3.dex */
public class l extends q.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> ecH;
    private com.baidu.tieba.recapp.i gPP;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.ecH = eVar;
    }

    public void aZG() {
        if (this.ecH != null) {
            this.ecH.aZG();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.gPP = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.gPP == null) {
            return false;
        }
        return this.gPP.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.gPP == null) {
            return false;
        }
        return this.gPP.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.gPP != null) {
            this.gPP.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.gPP != null) {
            this.gPP.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.gPP == null) {
            return null;
        }
        return this.gPP.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.gPP == null ? "" : this.gPP.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.gPP == null) {
            return 0;
        }
        return (int) this.gPP.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.gPP != null) {
            return this.gPP.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.gPP != null) {
            this.gPP.autoPlay(i);
        }
    }

    public boolean cW(Context context) {
        if (this.gPP == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.gPP.getLocationInWindow(iArr);
        return iArr[1] + this.gPP.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.aQ(context);
    }
}
