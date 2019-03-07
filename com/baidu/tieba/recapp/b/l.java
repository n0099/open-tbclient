package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes3.dex */
public class l extends v.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> fqm;
    private com.baidu.tieba.recapp.i iht;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.fqm = eVar;
    }

    public void bAk() {
        if (this.fqm != null) {
            this.fqm.bAk();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.iht = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.iht == null) {
            return false;
        }
        return this.iht.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.iht == null) {
            return false;
        }
        return this.iht.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.iht != null) {
            this.iht.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.iht != null) {
            this.iht.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.iht == null) {
            return null;
        }
        return this.iht.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.iht == null ? "" : this.iht.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.iht == null) {
            return 0;
        }
        return (int) this.iht.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.iht != null) {
            return this.iht.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.iht != null) {
            this.iht.autoPlay(i);
        }
    }

    public boolean es(Context context) {
        if (this.iht == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.iht.getLocationInWindow(iArr);
        return iArr[1] + this.iht.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.aQ(context);
    }
}
