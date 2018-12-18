package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes3.dex */
public class l extends q.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> dZj;
    private com.baidu.tieba.recapp.i gLT;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.dZj = eVar;
    }

    public void aYs() {
        if (this.dZj != null) {
            this.dZj.aYs();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.gLT = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.gLT == null) {
            return false;
        }
        return this.gLT.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.gLT == null) {
            return false;
        }
        return this.gLT.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.gLT != null) {
            this.gLT.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.gLT != null) {
            this.gLT.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.gLT == null) {
            return null;
        }
        return this.gLT.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.gLT == null ? "" : this.gLT.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.gLT == null) {
            return 0;
        }
        return (int) this.gLT.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.gLT != null) {
            return this.gLT.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.gLT != null) {
            this.gLT.autoPlay(i);
        }
    }

    public boolean cW(Context context) {
        if (this.gLT == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.gLT.getLocationInWindow(iArr);
        return iArr[1] + this.gLT.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.aQ(context);
    }
}
