package com.baidu.tieba.recapp.adapter;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import d.a.n0.k2.e;
import d.a.n0.t2.n;
/* loaded from: classes5.dex */
public class PbAppLegoViewHolder extends TypeAdapter.ViewHolder implements e {

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.k1.o.l.e<?> f20219e;

    /* renamed from: f  reason: collision with root package name */
    public n f20220f;

    public PbAppLegoViewHolder(d.a.n0.k1.o.l.e<?> eVar) {
        super((View) eVar);
        this.f20219e = eVar;
    }

    @Override // d.a.n0.k2.e
    public boolean C() {
        return false;
    }

    public void b(int i2) {
        n nVar = this.f20220f;
        if (nVar != null) {
            nVar.autoPlay(i2);
        }
    }

    public boolean c() {
        n nVar = this.f20220f;
        if (nVar == null) {
            return false;
        }
        return nVar.canPlay();
    }

    public int d() {
        n nVar = this.f20220f;
        if (nVar != null) {
            return nVar.getPlayStatus();
        }
        return -2;
    }

    public void e() {
        n nVar = this.f20220f;
        if (nVar != null) {
            nVar.release();
        }
    }

    public void f(n nVar) {
        this.f20220f = nVar;
    }

    @Override // d.a.n0.k2.e
    public int getCurrentPosition() {
        n nVar = this.f20220f;
        if (nVar == null) {
            return 0;
        }
        return (int) nVar.getCurrentPosition();
    }

    @Override // d.a.n0.k2.e
    public String getPlayUrl() {
        n nVar = this.f20220f;
        return nVar == null ? "" : nVar.getPlayUrl();
    }

    @Override // d.a.n0.k2.e
    public View getVideoContainer() {
        n nVar = this.f20220f;
        if (nVar == null) {
            return null;
        }
        return nVar.getVideoContainer();
    }

    public void h() {
        d.a.n0.k1.o.l.e<?> eVar = this.f20219e;
        if (eVar != null) {
            eVar.h();
        }
    }

    @Override // d.a.n0.k2.e
    public boolean isPlayStarted() {
        n nVar = this.f20220f;
        if (nVar == null) {
            return false;
        }
        return nVar.isPlayStarted();
    }

    @Override // d.a.n0.k2.e
    public boolean isPlaying() {
        n nVar = this.f20220f;
        if (nVar == null) {
            return false;
        }
        return nVar.isPlaying();
    }

    @Override // d.a.n0.k2.e
    public void startPlay() {
        n nVar = this.f20220f;
        if (nVar != null) {
            nVar.startPlay();
        }
    }

    @Override // d.a.n0.k2.e
    public void stopPlay() {
        n nVar = this.f20220f;
        if (nVar != null) {
            nVar.stopPlay();
        }
    }
}
