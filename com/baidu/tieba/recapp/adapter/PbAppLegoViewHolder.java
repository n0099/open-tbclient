package com.baidu.tieba.recapp.adapter;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import d.b.j0.j2.e;
import d.b.j0.s2.m;
/* loaded from: classes4.dex */
public class PbAppLegoViewHolder extends TypeAdapter.ViewHolder implements e {

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.j1.o.l.e<?> f20395e;

    /* renamed from: f  reason: collision with root package name */
    public m f20396f;

    public PbAppLegoViewHolder(d.b.j0.j1.o.l.e<?> eVar) {
        super((View) eVar);
        this.f20395e = eVar;
    }

    @Override // d.b.j0.j2.e
    public boolean D() {
        return false;
    }

    public void b(int i) {
        m mVar = this.f20396f;
        if (mVar != null) {
            mVar.autoPlay(i);
        }
    }

    public boolean c() {
        m mVar = this.f20396f;
        if (mVar == null) {
            return false;
        }
        return mVar.canPlay();
    }

    public int d() {
        m mVar = this.f20396f;
        if (mVar != null) {
            return mVar.getPlayStatus();
        }
        return -2;
    }

    public void e() {
        m mVar = this.f20396f;
        if (mVar != null) {
            mVar.release();
        }
    }

    public void f(m mVar) {
        this.f20396f = mVar;
    }

    @Override // d.b.j0.j2.e
    public int getCurrentPosition() {
        m mVar = this.f20396f;
        if (mVar == null) {
            return 0;
        }
        return (int) mVar.getCurrentPosition();
    }

    @Override // d.b.j0.j2.e
    public String getPlayUrl() {
        m mVar = this.f20396f;
        return mVar == null ? "" : mVar.getPlayUrl();
    }

    @Override // d.b.j0.j2.e
    public View getVideoContainer() {
        m mVar = this.f20396f;
        if (mVar == null) {
            return null;
        }
        return mVar.getVideoContainer();
    }

    public void h() {
        d.b.j0.j1.o.l.e<?> eVar = this.f20395e;
        if (eVar != null) {
            eVar.k();
        }
    }

    @Override // d.b.j0.j2.e
    public boolean isPlayStarted() {
        m mVar = this.f20396f;
        if (mVar == null) {
            return false;
        }
        return mVar.isPlayStarted();
    }

    @Override // d.b.j0.j2.e
    public boolean isPlaying() {
        m mVar = this.f20396f;
        if (mVar == null) {
            return false;
        }
        return mVar.isPlaying();
    }

    @Override // d.b.j0.j2.e
    public void startPlay() {
        m mVar = this.f20396f;
        if (mVar != null) {
            mVar.startPlay();
        }
    }

    @Override // d.b.j0.j2.e
    public void stopPlay() {
        m mVar = this.f20396f;
        if (mVar != null) {
            mVar.stopPlay();
        }
    }
}
