package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes3.dex */
public class l extends v.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> fLt;
    private com.baidu.tieba.recapp.i iGi;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.fLt = eVar;
    }

    public void bKC() {
        if (this.fLt != null) {
            this.fLt.bKC();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.iGi = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.iGi == null) {
            return false;
        }
        return this.iGi.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.iGi == null) {
            return false;
        }
        return this.iGi.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.iGi != null) {
            this.iGi.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.iGi != null) {
            this.iGi.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.iGi == null) {
            return null;
        }
        return this.iGi.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.iGi == null ? "" : this.iGi.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.iGi == null) {
            return 0;
        }
        return (int) this.iGi.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.iGi != null) {
            return this.iGi.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.iGi != null) {
            this.iGi.autoPlay(i);
        }
    }

    public boolean ei(Context context) {
        if (this.iGi == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.iGi.getLocationInWindow(iArr);
        return iArr[1] + this.iGi.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.ah(context);
    }
}
