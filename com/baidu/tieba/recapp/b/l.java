package com.baidu.tieba.recapp.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes3.dex */
public class l extends v.a implements com.baidu.tieba.play.f {
    com.baidu.tieba.lego.card.view.e<?> fGv;
    private com.baidu.tieba.recapp.i izQ;

    public l(com.baidu.tieba.lego.card.view.e<?> eVar) {
        super((View) eVar);
        this.fGv = eVar;
    }

    public void bHV() {
        if (this.fGv != null) {
            this.fGv.bHV();
        }
    }

    public void a(com.baidu.tieba.recapp.i iVar) {
        this.izQ = iVar;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.izQ == null) {
            return false;
        }
        return this.izQ.isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.izQ == null) {
            return false;
        }
        return this.izQ.isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isFullScreen() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.izQ != null) {
            this.izQ.startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.izQ != null) {
            this.izQ.stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.izQ == null) {
            return null;
        }
        return this.izQ.getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        return this.izQ == null ? "" : this.izQ.getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.izQ == null) {
            return 0;
        }
        return (int) this.izQ.getCurrentPosition();
    }

    public int getPlayStatus() {
        if (this.izQ != null) {
            return this.izQ.getPlayStatus();
        }
        return -2;
    }

    public void autoPlay(int i) {
        if (this.izQ != null) {
            this.izQ.autoPlay(i);
        }
    }

    public boolean eh(Context context) {
        if (this.izQ == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.izQ.getLocationInWindow(iArr);
        return iArr[1] + this.izQ.getHeight() >= 0 && iArr[1] <= com.baidu.adp.lib.util.l.ah(context);
    }
}
