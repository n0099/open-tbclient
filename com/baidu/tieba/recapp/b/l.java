package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes3.dex */
public class l extends q.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> dCQ;
    private com.baidu.tieba.recapp.i goG;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.dCQ = eVar;
    }

    public void aRG() {
        if (this.dCQ != null) {
            this.dCQ.aRG();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.goG = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.goG == null) {
            return false;
        }
        return this.goG.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.goG == null) {
            return false;
        }
        return this.goG.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.goG != null) {
            this.goG.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.goG != null) {
            this.goG.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.goG == null) {
            return null;
        }
        return this.goG.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.goG == null ? "" : this.goG.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.goG == null) {
            return 0;
        }
        return (int) this.goG.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.goG != null) {
            return this.goG.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.goG != null) {
            this.goG.autoPlay(i);
        }
    }

    public boolean cf(Context context) {
        if (this.goG == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.goG.getLocationInWindow(iArr);
        return iArr[1] + this.goG.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.aj(context);
    }
}
