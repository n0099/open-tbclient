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
import d.a.m0.r.q.a2;
import d.a.m0.r.q.e;
import d.a.n0.e2.h.p;
import d.a.n0.e2.k.e.o;
import d.a.n0.e2.k.e.z0.c;
import d.a.n0.e2.o.i;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class PbFirstFloorCommentAndPraiseAdapter extends o<p, PbFirstFloorCommentAndPraiseViewHolder> {
    public static int w;
    public View.OnClickListener s;
    public c t;
    public final LinkedList<PbFirstFloorCommentAndPraiseViewHolder> u;
    public boolean v;

    /* loaded from: classes5.dex */
    public static class PbFirstFloorCommentAndPraiseViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public PbThreadCommentAndPraiseInfoLayout f19225a;

        /* renamed from: b  reason: collision with root package name */
        public View f19226b;

        /* renamed from: c  reason: collision with root package name */
        public int f19227c;

        public PbFirstFloorCommentAndPraiseViewHolder(View view) {
            super(view);
            if (view == null) {
                return;
            }
            this.f19225a = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
            e eVar = new e();
            eVar.f53670b = 4;
            eVar.f53676h = 7;
            eVar.f53671c = this.f19227c;
            eVar.f53674f = PbFirstFloorCommentAndPraiseAdapter.w;
            this.f19225a.setAgreeStatisticData(eVar);
            View findViewById = view.findViewById(R.id.bottom_divider_line);
            this.f19226b = findViewById;
            findViewById.setVisibility(0);
        }

        public void b(p pVar) {
            if (pVar != null && pVar.e() != null) {
                a2 e2 = pVar.e();
                if (e2.L() != null) {
                    e2.L().postId = e2.f0();
                }
                this.f19225a.U(e2, pVar.c());
                this.f19226b.setVisibility(pVar.h() ? 0 : 8);
                if (e2.D2() && e2.x1() != null) {
                    this.f19227c = 2;
                } else {
                    this.f19227c = 1;
                }
                if (pVar.f56650f) {
                    a().setPadding(0, 0, 0, l.g(a().getContext(), R.dimen.tbds32));
                }
                this.f19225a.showOperationMaskView(pVar.i());
            }
            c();
        }

        public void c() {
            SkinManager.setBackgroundColor(this.f19226b, R.color.CAM_X0203);
            this.f19225a.onChangeSkinType();
        }
    }

    public PbFirstFloorCommentAndPraiseAdapter(i iVar, BdUniqueId bdUniqueId) {
        super(iVar, bdUniqueId);
        this.u = new LinkedList<>();
        this.v = false;
        if (iVar != null && iVar.A() != null) {
            w = iVar.A().B0();
        }
        this.t = new c(iVar);
    }

    @Override // d.a.n0.e2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        q0(i2, view, viewGroup, (p) obj, (PbFirstFloorCommentAndPraiseViewHolder) viewHolder);
        return view;
    }

    public void i0(String str) {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        if (this.u.size() > 0) {
            Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.u.iterator();
            while (it.hasNext()) {
                PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.f19225a) != null) {
                    pbThreadCommentAndPraiseInfoLayout.Q(str);
                }
            }
        } else if (k0() == null) {
        } else {
            this.t.b(k0().L());
        }
    }

    public final String j0() {
        return this.m.A() != null ? this.m.A().getForumId() : "";
    }

    public final a2 k0() {
        if (this.m.A() == null || this.m.A().C0() == null) {
            return null;
        }
        return this.m.A().C0().L();
    }

    public final String l0() {
        a2 k0 = k0();
        return k0 != null ? k0.f0() : "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: m0 */
    public PbFirstFloorCommentAndPraiseViewHolder Q(ViewGroup viewGroup) {
        PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.f42909e).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
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
            if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.f19225a) != null) {
                pbThreadCommentAndPraiseInfoLayout.onDestroy();
            }
        }
    }

    public View q0(int i2, View view, ViewGroup viewGroup, p pVar, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        super.X(i2, view, viewGroup, pVar, pbFirstFloorCommentAndPraiseViewHolder);
        if (pVar != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
            pbFirstFloorCommentAndPraiseViewHolder.f19225a.setOnClickOutListener(this.s);
            pbFirstFloorCommentAndPraiseViewHolder.f19225a.setPostId(l0());
            pbFirstFloorCommentAndPraiseViewHolder.f19225a.setForumId(j0());
            pVar.l(this.v);
            pbFirstFloorCommentAndPraiseViewHolder.b(pVar);
        }
        return view;
    }

    public void s0(boolean z) {
        this.v = z;
    }

    public void t0(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }
}
