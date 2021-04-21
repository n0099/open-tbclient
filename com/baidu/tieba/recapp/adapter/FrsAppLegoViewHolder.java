package com.baidu.tieba.recapp.adapter;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import d.b.j0.j2.e;
import d.b.j0.s2.m;
/* loaded from: classes4.dex */
public class FrsAppLegoViewHolder extends TypeAdapter.ViewHolder implements e {

    /* renamed from: e  reason: collision with root package name */
    public m f20394e;

    public FrsAppLegoViewHolder(d.b.j0.j1.o.l.e<?> eVar) {
        super((View) eVar);
    }

    @Override // d.b.j0.j2.e
    public boolean D() {
        return false;
    }

    public void b() {
        m mVar = this.f20394e;
        if (mVar != null) {
            mVar.release();
        }
    }

    public void c(m mVar) {
        this.f20394e = mVar;
    }

    @Override // d.b.j0.j2.e
    public int getCurrentPosition() {
        m mVar = this.f20394e;
        if (mVar == null) {
            return 0;
        }
        return (int) mVar.getCurrentPosition();
    }

    @Override // d.b.j0.j2.e
    public String getPlayUrl() {
        m mVar = this.f20394e;
        return mVar == null ? "" : mVar.getPlayUrl();
    }

    @Override // d.b.j0.j2.e
    public View getVideoContainer() {
        m mVar = this.f20394e;
        if (mVar == null) {
            return null;
        }
        return mVar.getVideoContainer();
    }

    @Override // d.b.j0.j2.e
    public boolean isPlayStarted() {
        m mVar = this.f20394e;
        if (mVar == null) {
            return false;
        }
        return mVar.isPlayStarted();
    }

    @Override // d.b.j0.j2.e
    public boolean isPlaying() {
        m mVar = this.f20394e;
        if (mVar == null) {
            return false;
        }
        return mVar.isPlaying();
    }

    @Override // d.b.j0.j2.e
    public void startPlay() {
        m mVar = this.f20394e;
        if (mVar != null) {
            mVar.startPlay();
        }
    }

    @Override // d.b.j0.j2.e
    public void stopPlay() {
        m mVar = this.f20394e;
        if (mVar != null) {
            mVar.stopPlay();
        }
    }
}
