package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes3.dex */
public class l extends q.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> dwQ;
    private com.baidu.tieba.recapp.i gjF;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.dwQ = eVar;
    }

    public void aPZ() {
        if (this.dwQ != null) {
            this.dwQ.aPZ();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.gjF = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.gjF == null) {
            return false;
        }
        return this.gjF.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.gjF == null) {
            return false;
        }
        return this.gjF.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.gjF != null) {
            this.gjF.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.gjF != null) {
            this.gjF.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.gjF == null) {
            return null;
        }
        return this.gjF.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.gjF == null ? "" : this.gjF.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.gjF == null) {
            return 0;
        }
        return (int) this.gjF.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.gjF != null) {
            return this.gjF.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.gjF != null) {
            this.gjF.autoPlay(i);
        }
    }

    public boolean cf(Context context) {
        if (this.gjF == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.gjF.getLocationInWindow(iArr);
        return iArr[1] + this.gjF.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.aj(context);
    }
}
