package com.baidu.tieba.recapp.adapter;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import d.a.o0.k2.e;
import d.a.o0.t2.n;
/* loaded from: classes5.dex */
public class FrsAppLegoViewHolder extends TypeAdapter.ViewHolder implements e {

    /* renamed from: e  reason: collision with root package name */
    public n f20300e;

    public FrsAppLegoViewHolder(d.a.o0.k1.o.l.e<?> eVar) {
        super((View) eVar);
    }

    @Override // d.a.o0.k2.e
    public boolean C() {
        return false;
    }

    public void b() {
        n nVar = this.f20300e;
        if (nVar != null) {
            nVar.release();
        }
    }

    public void c(n nVar) {
        this.f20300e = nVar;
    }

    @Override // d.a.o0.k2.e
    public int getCurrentPosition() {
        n nVar = this.f20300e;
        if (nVar == null) {
            return 0;
        }
        return (int) nVar.getCurrentPosition();
    }

    @Override // d.a.o0.k2.e
    public String getPlayUrl() {
        n nVar = this.f20300e;
        return nVar == null ? "" : nVar.getPlayUrl();
    }

    @Override // d.a.o0.k2.e
    public View getVideoContainer() {
        n nVar = this.f20300e;
        if (nVar == null) {
            return null;
        }
        return nVar.getVideoContainer();
    }

    @Override // d.a.o0.k2.e
    public boolean isPlayStarted() {
        n nVar = this.f20300e;
        if (nVar == null) {
            return false;
        }
        return nVar.isPlayStarted();
    }

    @Override // d.a.o0.k2.e
    public boolean isPlaying() {
        n nVar = this.f20300e;
        if (nVar == null) {
            return false;
        }
        return nVar.isPlaying();
    }

    @Override // d.a.o0.k2.e
    public void startPlay() {
        n nVar = this.f20300e;
        if (nVar != null) {
            nVar.startPlay();
        }
    }

    @Override // d.a.o0.k2.e
    public void stopPlay() {
        n nVar = this.f20300e;
        if (nVar != null) {
            nVar.stopPlay();
        }
    }
}
