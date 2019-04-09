package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes3.dex */
public class l extends v.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> fpX;
    private com.baidu.tieba.recapp.i ihb;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.fpX = eVar;
    }

    public void bAh() {
        if (this.fpX != null) {
            this.fpX.bAh();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.ihb = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.ihb == null) {
            return false;
        }
        return this.ihb.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.ihb == null) {
            return false;
        }
        return this.ihb.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.ihb != null) {
            this.ihb.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.ihb != null) {
            this.ihb.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.ihb == null) {
            return null;
        }
        return this.ihb.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.ihb == null ? "" : this.ihb.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.ihb == null) {
            return 0;
        }
        return (int) this.ihb.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.ihb != null) {
            return this.ihb.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.ihb != null) {
            this.ihb.autoPlay(i);
        }
    }

    public boolean er(Context context) {
        if (this.ihb == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.ihb.getLocationInWindow(iArr);
        return iArr[1] + this.ihb.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.aQ(context);
    }
}
