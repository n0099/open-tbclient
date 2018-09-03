package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes3.dex */
public class l extends q.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> dCN;
    private com.baidu.tieba.recapp.i goJ;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.dCN = eVar;
    }

    public void aRD() {
        if (this.dCN != null) {
            this.dCN.aRD();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.goJ = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.goJ == null) {
            return false;
        }
        return this.goJ.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.goJ == null) {
            return false;
        }
        return this.goJ.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.goJ != null) {
            this.goJ.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.goJ != null) {
            this.goJ.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.goJ == null) {
            return null;
        }
        return this.goJ.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.goJ == null ? "" : this.goJ.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.goJ == null) {
            return 0;
        }
        return (int) this.goJ.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.goJ != null) {
            return this.goJ.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.goJ != null) {
            this.goJ.autoPlay(i);
        }
    }

    public boolean ce(Context context) {
        if (this.goJ == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.goJ.getLocationInWindow(iArr);
        return iArr[1] + this.goJ.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.aj(context);
    }
}
