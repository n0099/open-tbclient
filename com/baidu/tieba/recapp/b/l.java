package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes13.dex */
public class l extends v.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> gHg;
    private com.baidu.tieba.recapp.i jIi;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.gHg = eVar;
    }

    public void ccF() {
        if (this.gHg != null) {
            this.gHg.ccF();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.jIi = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.jIi == null) {
            return false;
        }
        return this.jIi.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.jIi == null) {
            return false;
        }
        return this.jIi.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.jIi != null) {
            this.jIi.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.jIi != null) {
            this.jIi.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.jIi == null) {
            return null;
        }
        return this.jIi.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.jIi == null ? "" : this.jIi.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.jIi == null) {
            return 0;
        }
        return (int) this.jIi.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.jIi != null) {
            return this.jIi.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.jIi != null) {
            this.jIi.autoPlay(i);
        }
    }

    public boolean fn(Context context) {
        if (this.jIi == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.jIi.getLocationInWindow(iArr);
        return iArr[1] + this.jIi.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.getEquipmentHeight(context);
    }
}
