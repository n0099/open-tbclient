package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.r;
/* loaded from: classes3.dex */
public class l extends r.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.e.k<?> dSr;
    private com.baidu.tieba.recapp.i gCw;

    public l(com.baidu.tieba.lego.card.e.k<?> kVar) {
        super((View) kVar);
        this.dSr = kVar;
    }

    public void aQd() {
        if (this.dSr != null) {
            this.dSr.aQd();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.gCw = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.gCw == null) {
            return false;
        }
        return this.gCw.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.gCw == null) {
            return false;
        }
        return this.gCw.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.gCw != null) {
            this.gCw.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.gCw != null) {
            this.gCw.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.gCw == null) {
            return null;
        }
        return this.gCw.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.gCw == null ? "" : this.gCw.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.gCw == null) {
            return 0;
        }
        return (int) this.gCw.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.gCw != null) {
            return this.gCw.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.gCw != null) {
            this.gCw.autoPlay(i);
        }
    }

    public boolean cg(Context context) {
        if (this.gCw == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.gCw.getLocationInWindow(iArr);
        return iArr[1] + this.gCw.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.aq(context);
    }
}
