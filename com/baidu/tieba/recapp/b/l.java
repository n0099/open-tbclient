package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes3.dex */
public class l extends v.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> fNp;
    private com.baidu.tieba.recapp.i iIw;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.fNp = eVar;
    }

    public void bIn() {
        if (this.fNp != null) {
            this.fNp.bIn();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.iIw = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.iIw == null) {
            return false;
        }
        return this.iIw.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.iIw == null) {
            return false;
        }
        return this.iIw.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.iIw != null) {
            this.iIw.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.iIw != null) {
            this.iIw.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.iIw == null) {
            return null;
        }
        return this.iIw.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.iIw == null ? "" : this.iIw.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.iIw == null) {
            return 0;
        }
        return (int) this.iIw.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.iIw != null) {
            return this.iIw.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.iIw != null) {
            this.iIw.autoPlay(i);
        }
    }

    public boolean dW(Context context) {
        if (this.iIw == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.iIw.getLocationInWindow(iArr);
        return iArr[1] + this.iIw.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.getEquipmentHeight(context);
    }
}
