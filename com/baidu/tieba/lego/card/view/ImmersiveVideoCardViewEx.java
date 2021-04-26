package com.baidu.tieba.lego.card.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
import d.a.j0.j1.o.l.a;
import d.a.j0.j1.o.l.o;
import d.a.j0.j2.d;
import d.a.j0.j2.e;
/* loaded from: classes4.dex */
public class ImmersiveVideoCardViewEx extends BaseCardView<ImmersiveVideoCardEx> implements e, d {
    public ViewGroup r;
    public o s;
    public a t;

    public ImmersiveVideoCardViewEx(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.a.j0.j2.e
    public boolean C() {
        return false;
    }

    public void J() {
        a aVar = this.t;
        if (aVar != null) {
            aVar.n();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: K */
    public void x(ImmersiveVideoCardEx immersiveVideoCardEx, int i2) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: L */
    public void y(ImmersiveVideoCardEx immersiveVideoCardEx) {
        if (immersiveVideoCardEx.getVideoInfo() == null) {
            return;
        }
        this.s.y(immersiveVideoCardEx.getShowExtra(), "feed");
        this.s.x(immersiveVideoCardEx.getVideoInfo(), immersiveVideoCardEx.getPage());
        boolean z = immersiveVideoCardEx.getVideoInfo().f18663i;
        this.s.u(z);
        this.s.t(z);
        this.t.u(z);
        setTag(this);
        J();
    }

    @Override // d.a.j0.j2.d
    public void b() {
        a aVar = this.t;
        if (aVar != null) {
            aVar.j();
        }
    }

    @Override // d.a.j0.j2.d
    public void c() {
        a aVar = this.t;
        if (aVar != null) {
            aVar.k();
        }
    }

    @Override // d.a.j0.j2.d
    public void d() {
        a aVar = this.t;
        if (aVar != null) {
            aVar.m();
        }
    }

    @Override // d.a.j0.j2.e
    public int getCurrentPosition() {
        o oVar = this.s;
        if (oVar != null) {
            return oVar.k();
        }
        return 0;
    }

    @Override // d.a.j0.j2.e
    public String getPlayUrl() {
        o oVar = this.s;
        if (oVar != null) {
            return oVar.m();
        }
        return null;
    }

    @Override // d.a.j0.j2.e
    public View getVideoContainer() {
        o oVar = this.s;
        if (oVar != null) {
            return oVar.n();
        }
        return null;
    }

    @Override // d.a.j0.j2.e
    public boolean isPlayStarted() {
        o oVar = this.s;
        return oVar != null && oVar.p();
    }

    @Override // d.a.j0.j2.e
    public boolean isPlaying() {
        o oVar = this.s;
        return oVar != null && oVar.q();
    }

    @Override // d.a.j0.j2.e
    public void startPlay() {
        o oVar = this.s;
        if (oVar != null) {
            oVar.v();
        }
    }

    @Override // d.a.j0.j2.e
    public void stopPlay() {
        o oVar = this.s;
        if (oVar != null) {
            oVar.w();
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View u() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.card_item_video_thread, (ViewGroup) null);
        this.r = viewGroup;
        this.s = new o(this.m, viewGroup.findViewById(R.id.layout_video_container));
        a aVar = new a(this.m, this.r);
        this.t = aVar;
        this.s.s(aVar);
        return this.r;
    }
}
