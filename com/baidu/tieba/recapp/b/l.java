package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes3.dex */
public class l extends q.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> dmu;
    private com.baidu.tieba.recapp.i fXk;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.dmu = eVar;
    }

    public void aLd() {
        if (this.dmu != null) {
            this.dmu.aLd();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.fXk = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.fXk == null) {
            return false;
        }
        return this.fXk.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.fXk == null) {
            return false;
        }
        return this.fXk.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.fXk != null) {
            this.fXk.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.fXk != null) {
            this.fXk.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.fXk == null) {
            return null;
        }
        return this.fXk.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.fXk == null ? "" : this.fXk.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.fXk == null) {
            return 0;
        }
        return (int) this.fXk.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.fXk != null) {
            return this.fXk.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.fXk != null) {
            this.fXk.autoPlay(i);
        }
    }

    public boolean bU(Context context) {
        if (this.fXk == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.fXk.getLocationInWindow(iArr);
        return iArr[1] + this.fXk.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.ah(context);
    }
}
