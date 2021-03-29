package com.baidu.tieba.recapp.adapter;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import d.b.i0.i2.e;
import d.b.i0.r2.k;
/* loaded from: classes5.dex */
public class FrsAppLegoViewHolder extends TypeAdapter.ViewHolder implements e {

    /* renamed from: e  reason: collision with root package name */
    public k f20694e;

    public FrsAppLegoViewHolder(d.b.i0.i1.o.l.e<?> eVar) {
        super((View) eVar);
    }

    @Override // d.b.i0.i2.e
    public boolean D() {
        return false;
    }

    public void b() {
        k kVar = this.f20694e;
        if (kVar != null) {
            kVar.release();
        }
    }

    public void c(k kVar) {
        this.f20694e = kVar;
    }

    @Override // d.b.i0.i2.e
    public int getCurrentPosition() {
        k kVar = this.f20694e;
        if (kVar == null) {
            return 0;
        }
        return (int) kVar.getCurrentPosition();
    }

    @Override // d.b.i0.i2.e
    public String getPlayUrl() {
        k kVar = this.f20694e;
        return kVar == null ? "" : kVar.getPlayUrl();
    }

    @Override // d.b.i0.i2.e
    public View getVideoContainer() {
        k kVar = this.f20694e;
        if (kVar == null) {
            return null;
        }
        return kVar.getVideoContainer();
    }

    @Override // d.b.i0.i2.e
    public boolean isPlayStarted() {
        k kVar = this.f20694e;
        if (kVar == null) {
            return false;
        }
        return kVar.isPlayStarted();
    }

    @Override // d.b.i0.i2.e
    public boolean isPlaying() {
        k kVar = this.f20694e;
        if (kVar == null) {
            return false;
        }
        return kVar.isPlaying();
    }

    @Override // d.b.i0.i2.e
    public void startPlay() {
        k kVar = this.f20694e;
        if (kVar != null) {
            kVar.startPlay();
        }
    }

    @Override // d.b.i0.i2.e
    public void stopPlay() {
        k kVar = this.f20694e;
        if (kVar != null) {
            kVar.stopPlay();
        }
    }
}
