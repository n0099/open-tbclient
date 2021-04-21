package com.baidu.tieba.pb.pb.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.e;
import d.b.j0.d2.h.p;
import d.b.j0.d2.k.e.o;
import d.b.j0.d2.k.e.y0.c;
import d.b.j0.d2.o.i;
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
        public PbThreadCommentAndPraiseInfoLayout f19469a;

        /* renamed from: b  reason: collision with root package name */
        public View f19470b;

        /* renamed from: c  reason: collision with root package name */
        public int f19471c;

        public PbFirstFloorCommentAndPraiseViewHolder(View view) {
            super(view);
            if (view == null) {
                return;
            }
            this.f19469a = (PbThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_func_layout);
            e eVar = new e();
            eVar.f51506b = 4;
            eVar.f51512h = 7;
            eVar.f51507c = this.f19471c;
            eVar.f51510f = PbFirstFloorCommentAndPraiseAdapter.w;
            this.f19469a.setAgreeStatisticData(eVar);
            View findViewById = view.findViewById(R.id.bottom_divider_line);
            this.f19470b = findViewById;
            findViewById.setVisibility(0);
        }

        public void b(p pVar) {
            if (pVar != null && pVar.f() != null) {
                a2 f2 = pVar.f();
                if (f2.L() != null) {
                    f2.L().postId = f2.f0();
                }
                this.f19469a.W(f2, pVar.e());
                this.f19470b.setVisibility(pVar.j() ? 0 : 8);
                if (f2.z2() && f2.u1() != null) {
                    this.f19471c = 2;
                } else {
                    this.f19471c = 1;
                }
                if (pVar.f54275f) {
                    a().setPadding(0, 0, 0, l.g(a().getContext(), R.dimen.tbds32));
                }
                this.f19469a.showOperationMaskView(pVar.k());
            }
            c();
        }

        public void c() {
            SkinManager.setBackgroundColor(this.f19470b, R.color.CAM_X0203);
            this.f19469a.onChangeSkinType();
        }
    }

    public PbFirstFloorCommentAndPraiseAdapter(i iVar, BdUniqueId bdUniqueId) {
        super(iVar, bdUniqueId);
        this.u = new LinkedList<>();
        this.v = false;
        if (iVar != null && iVar.L() != null) {
            w = iVar.L().x0();
        }
        this.t = new c(iVar);
    }

    @Override // d.b.j0.d2.k.e.o, d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        r0(i, view, viewGroup, (p) obj, (PbFirstFloorCommentAndPraiseViewHolder) viewHolder);
        return view;
    }

    public void l0(String str) {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        if (this.u.size() > 0) {
            Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.u.iterator();
            while (it.hasNext()) {
                PbFirstFloorCommentAndPraiseViewHolder next = it.next();
                if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.f19469a) != null) {
                    pbThreadCommentAndPraiseInfoLayout.S(str);
                }
            }
        } else if (n0() == null) {
        } else {
            this.t.b(n0().L());
        }
    }

    public final String m0() {
        return this.m.L() != null ? this.m.L().getForumId() : "";
    }

    public final a2 n0() {
        if (this.m.L() == null || this.m.L().y0() == null) {
            return null;
        }
        return this.m.L().y0().L();
    }

    public final String o0() {
        a2 n0 = n0();
        return n0 != null ? n0.f0() : "";
    }

    public void onDestroy() {
        q0();
        c cVar = this.t;
        if (cVar != null) {
            cVar.d();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: p0 */
    public PbFirstFloorCommentAndPraiseViewHolder R(ViewGroup viewGroup) {
        PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder = new PbFirstFloorCommentAndPraiseViewHolder(LayoutInflater.from(this.f43095e).inflate(R.layout.layout_pb_thread_praise_item, viewGroup, false));
        this.u.add(pbFirstFloorCommentAndPraiseViewHolder);
        return pbFirstFloorCommentAndPraiseViewHolder;
    }

    public final void q0() {
        PbThreadCommentAndPraiseInfoLayout pbThreadCommentAndPraiseInfoLayout;
        Iterator<PbFirstFloorCommentAndPraiseViewHolder> it = this.u.iterator();
        while (it.hasNext()) {
            PbFirstFloorCommentAndPraiseViewHolder next = it.next();
            if (next != null && (pbThreadCommentAndPraiseInfoLayout = next.f19469a) != null) {
                pbThreadCommentAndPraiseInfoLayout.onDestroy();
            }
        }
    }

    public View r0(int i, View view, ViewGroup viewGroup, p pVar, PbFirstFloorCommentAndPraiseViewHolder pbFirstFloorCommentAndPraiseViewHolder) {
        super.X(i, view, viewGroup, pVar, pbFirstFloorCommentAndPraiseViewHolder);
        if (pVar != null && pbFirstFloorCommentAndPraiseViewHolder != null) {
            pbFirstFloorCommentAndPraiseViewHolder.f19469a.setOnClickOutListener(this.s);
            pbFirstFloorCommentAndPraiseViewHolder.f19469a.setPostId(o0());
            pbFirstFloorCommentAndPraiseViewHolder.f19469a.setForumId(m0());
            pVar.n(this.v);
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
