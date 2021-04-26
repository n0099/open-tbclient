package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.e;
import d.a.j0.d2.h.p;
import d.a.j0.d2.k.e.o;
import d.a.j0.d2.k.e.y0.c;
import d.a.j0.d2.o.i;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class PbFirstFloorCommentAndPraiseAdapter extends o<p, PbFirstFloorCommentAndPraiseViewHolder> {
    public static int w;
    public View.OnClickListener s;
    public c t;
    public final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> u;
    public boolean v;

    /* loaded from: classes3.dex */
    public static class PbFirstFloorCommentAndPraiseViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public PbThreadCommentAndPraiseInfoLayout f19940a;

        /* renamed from: b  reason: collision with root package name */
        public View f19941b;

        /* renamed from: c  reason: collision with root package name */
        public int f19942c;

        public PbFirstFloorCommentAndPraiseViewHolder(View view) {
            super(view);
            if (view == null) {
                return;
            }
            this.f19940a = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
            e eVar = new e();
            eVar.f49131b = 4;
            eVar.f49137h = 7;
            eVar.f49132c = this.f19942c;
            eVar.f49135f = PbFirstFloorCommentAndPraiseAdapter.w;
            this.f19940a.setAgreeStatisticData(eVar);
            View findViewById = view.findViewById(R.id.bottom_divider_line);
            this.f19941b = findViewById;
            findViewById.setVisibility(0);
        }

        public void b(p pVar) {
            if (pVar != null && pVar.f() != null) {
                a2 f2 = pVar.f();
                if (f2.L() != null) {
                    f2.L().postId = f2.f0();
                }
                this.f19940a.V(f2, pVar.e());
                this.f19941b.setVisibility(pVar.i() ? 0 : 8);
                if (f2.z2() && f2.u1() != null) {
                    this.f19942c = 2;
                } else {
                    this.f19942c = 1;
                }
                if (pVar.f52057f) {
                    a().setPadding(0, 0, 0, l.g(a().getContext(), R.dimen.tbds32));
                }
                this.f19940a.showOperationMaskView(pVar.k());
            }
            c();
        }

        public void c() {
            SkinManager.setBackgroundColor(this.f19941b, R.color.CAM_X0203);
            this.f19940a.onChangeSkinType();
        }
    }

    public PbFirstFloorCommentAndPraiseAdapter(i iVar, BdUniqueId bdUniqueId) {
        super(iVar, bdUniqueId);
        this.u = new LinkedList<>();
        this.v = false;
        if (iVar != null && iVar.z() != null) {
            w = iVar.z().x0();
        }
        this.t = new c(iVar);
    }

    @Override // d.a.j0.d2.k.e.o, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        q0(i2, view, viewGroup, (p) obj, (PbFirstFloorCommentAndPraiseViewHolder) viewHolder);
        return view;
    }

    public void h0(String str) {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        if (this.u.size() > 0) {
            Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.u.iterator();
            while (it.hasNext()) {
                PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.f19940a) != null) {
                    pbThreadCommentAndPraiseInfoLayout.Q(str);
                }
            }
        } else if (j0() == null) {
        } else {
            this.t.b(j0().L());
        }
    }

    public final String i0() {
        return this.m.z() != null ? this.m.z().getForumId() : "";
    }

    public final a2 j0() {
        if (this.m.z() == null || this.m.z().y0() == null) {
            return null;
        }
        return this.m.z().y0().L();
    }

    public final String m0() {
        a2 j0 = j0();
        return j0 != null ? j0.f0() : "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: n0 */
    public PbFirstFloorCommentAndPraiseViewHolder P(ViewGroup viewGroup) {
        PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.f40319e).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.u.add(pbFirstFloorCommentAndPraiseViewHolder);
        return pbFirstFloorCommentAndPraiseViewHolder;
    }

    public void onDestroy() {
        p0();
        c cVar = this.t;
        if (cVar != null) {
            cVar.d();
        }
    }

    public final void p0() {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.u.iterator();
        while (it.hasNext()) {
            PbFirstFloorCommentAndPraiseViewHolder next = it.next();
            if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.f19940a) != null) {
                pbThreadCommentAndPraiseInfoLayout.onDestroy();
            }
        }
    }

    public View q0(int i2, View view, ViewGroup viewGroup, p pVar, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        super.W(i2, view, viewGroup, pVar, pbFirstFloorCommentAndPraiseViewHolder);
        if (pVar != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
            pbFirstFloorCommentAndPraiseViewHolder.f19940a.setOnClickOutListener(this.s);
            pbFirstFloorCommentAndPraiseViewHolder.f19940a.setPostId(m0());
            pbFirstFloorCommentAndPraiseViewHolder.f19940a.setForumId(i0());
            pVar.m(this.v);
            pbFirstFloorCommentAndPraiseViewHolder.b(pVar);
        }
        return view;
    }

    public void r0(boolean z) {
        this.v = z;
    }

    public void t0(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }
}
