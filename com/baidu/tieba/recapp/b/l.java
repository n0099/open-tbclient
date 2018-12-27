package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes3.dex */
public class l extends q.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> eca;
    private com.baidu.tieba.recapp.i gOL;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.eca = eVar;
    }

    public void aZg() {
        if (this.eca != null) {
            this.eca.aZg();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.gOL = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.gOL == null) {
            return false;
        }
        return this.gOL.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.gOL == null) {
            return false;
        }
        return this.gOL.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.gOL != null) {
            this.gOL.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.gOL != null) {
            this.gOL.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.gOL == null) {
            return null;
        }
        return this.gOL.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.gOL == null ? "" : this.gOL.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.gOL == null) {
            return 0;
        }
        return (int) this.gOL.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.gOL != null) {
            return this.gOL.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.gOL != null) {
            this.gOL.autoPlay(i);
        }
    }

    public boolean cW(Context context) {
        if (this.gOL == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.gOL.getLocationInWindow(iArr);
        return iArr[1] + this.gOL.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.aQ(context);
    }
}
