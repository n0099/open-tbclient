package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes3.dex */
public class l extends q.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> dRA;
    private com.baidu.tieba.recapp.i gDC;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.dRA = eVar;
    }

    public void aXe() {
        if (this.dRA != null) {
            this.dRA.aXe();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.gDC = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.gDC == null) {
            return false;
        }
        return this.gDC.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.gDC == null) {
            return false;
        }
        return this.gDC.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.gDC != null) {
            this.gDC.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.gDC != null) {
            this.gDC.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.gDC == null) {
            return null;
        }
        return this.gDC.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.gDC == null ? "" : this.gDC.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.gDC == null) {
            return 0;
        }
        return (int) this.gDC.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.gDC != null) {
            return this.gDC.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.gDC != null) {
            this.gDC.autoPlay(i);
        }
    }

    public boolean cX(Context context) {
        if (this.gDC == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.gDC.getLocationInWindow(iArr);
        return iArr[1] + this.gDC.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.aQ(context);
    }
}
