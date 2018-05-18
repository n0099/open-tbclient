package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes3.dex */
public class l extends q.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> dnz;
    private com.baidu.tieba.recapp.i fYn;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.dnz = eVar;
    }

    public void aLc() {
        if (this.dnz != null) {
            this.dnz.aLc();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.fYn = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.fYn == null) {
            return false;
        }
        return this.fYn.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.fYn == null) {
            return false;
        }
        return this.fYn.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.fYn != null) {
            this.fYn.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.fYn != null) {
            this.fYn.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.fYn == null) {
            return null;
        }
        return this.fYn.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.fYn == null ? "" : this.fYn.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.fYn == null) {
            return 0;
        }
        return (int) this.fYn.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.fYn != null) {
            return this.fYn.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.fYn != null) {
            this.fYn.autoPlay(i);
        }
    }

    public boolean bU(Context context) {
        if (this.fYn == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.fYn.getLocationInWindow(iArr);
        return iArr[1] + this.fYn.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.ah(context);
    }
}
