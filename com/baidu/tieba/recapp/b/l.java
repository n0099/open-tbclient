package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes3.dex */
public class l extends q.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> dmr;
    private com.baidu.tieba.recapp.i fXh;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.dmr = eVar;
    }

    public void aLd() {
        if (this.dmr != null) {
            this.dmr.aLd();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.fXh = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.fXh == null) {
            return false;
        }
        return this.fXh.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.fXh == null) {
            return false;
        }
        return this.fXh.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.fXh != null) {
            this.fXh.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.fXh != null) {
            this.fXh.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.fXh == null) {
            return null;
        }
        return this.fXh.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.fXh == null ? "" : this.fXh.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.fXh == null) {
            return 0;
        }
        return (int) this.fXh.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.fXh != null) {
            return this.fXh.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.fXh != null) {
            this.fXh.autoPlay(i);
        }
    }

    public boolean bU(Context context) {
        if (this.fXh == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.fXh.getLocationInWindow(iArr);
        return iArr[1] + this.fXh.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.ah(context);
    }
}
