package com.baidu.tieba.recapp.adapter;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import d.b.i0.i2.e;
import d.b.i0.r2.k;
/* loaded from: classes5.dex */
public class PbAppLegoViewHolder extends TypeAdapter.ViewHolder implements e {

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.i1.o.l.e<?> f20695e;

    /* renamed from: f  reason: collision with root package name */
    public k f20696f;

    public PbAppLegoViewHolder(d.b.i0.i1.o.l.e<?> eVar) {
        super((View) eVar);
        this.f20695e = eVar;
    }

    @Override // d.b.i0.i2.e
    public boolean D() {
        return false;
    }

    public void b(int i) {
        k kVar = this.f20696f;
        if (kVar != null) {
            kVar.autoPlay(i);
        }
    }

    public boolean c() {
        k kVar = this.f20696f;
        if (kVar == null) {
            return false;
        }
        return kVar.canPlay();
    }

    public int d() {
        k kVar = this.f20696f;
        if (kVar != null) {
            return kVar.getPlayStatus();
        }
        return -2;
    }

    public void e() {
        k kVar = this.f20696f;
        if (kVar != null) {
            kVar.release();
        }
    }

    public void f(k kVar) {
        this.f20696f = kVar;
    }

    @Override // d.b.i0.i2.e
    public int getCurrentPosition() {
        k kVar = this.f20696f;
        if (kVar == null) {
            return 0;
        }
        return (int) kVar.getCurrentPosition();
    }

    @Override // d.b.i0.i2.e
    public String getPlayUrl() {
        k kVar = this.f20696f;
        return kVar == null ? "" : kVar.getPlayUrl();
    }

    @Override // d.b.i0.i2.e
    public View getVideoContainer() {
        k kVar = this.f20696f;
        if (kVar == null) {
            return null;
        }
        return kVar.getVideoContainer();
    }

    public void h() {
        d.b.i0.i1.o.l.e<?> eVar = this.f20695e;
        if (eVar != null) {
            eVar.k();
        }
    }

    @Override // d.b.i0.i2.e
    public boolean isPlayStarted() {
        k kVar = this.f20696f;
        if (kVar == null) {
            return false;
        }
        return kVar.isPlayStarted();
    }

    @Override // d.b.i0.i2.e
    public boolean isPlaying() {
        k kVar = this.f20696f;
        if (kVar == null) {
            return false;
        }
        return kVar.isPlaying();
    }

    @Override // d.b.i0.i2.e
    public void startPlay() {
        k kVar = this.f20696f;
        if (kVar != null) {
            kVar.startPlay();
        }
    }

    @Override // d.b.i0.i2.e
    public void stopPlay() {
        k kVar = this.f20696f;
        if (kVar != null) {
            kVar.stopPlay();
        }
    }
}
