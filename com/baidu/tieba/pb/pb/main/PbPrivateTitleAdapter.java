package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.h0.r.u.c;
import d.b.i0.d2.h.n;
import d.b.i0.d2.k.e.o;
import d.b.i0.d2.o.i;
/* loaded from: classes3.dex */
public class PbPrivateTitleAdapter extends o<n, PbPrivateTitleViewHolder> {

    /* loaded from: classes3.dex */
    public static class PbPrivateTitleViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f19436a;

        /* renamed from: b  reason: collision with root package name */
        public View f19437b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19438c;

        public PbPrivateTitleViewHolder(TbPageContext tbPageContext, View view) {
            super(view);
            this.f19436a = 3;
            if (view == null) {
                return;
            }
            this.f19437b = view.findViewById(R.id.background);
            this.f19438c = (TextView) view.findViewById(R.id.title);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tbPageContext.getResources().getString(R.string.pb_private_block_title));
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_barrules_careful12, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.d(l.g(tbPageContext.getContext(), R.dimen.tbds31));
            eMRichTextAnyIconSpan.c(l.g(tbPageContext.getContext(), R.dimen.M_W_X002));
            eMRichTextAnyIconSpan.a(0);
            spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
            this.f19438c.setText(spannableStringBuilder);
            b(TbadkCoreApplication.getInst().getSkinType());
        }

        public void b(int i) {
            if (this.f19436a != i) {
                c d2 = c.d(this.f19438c);
                d2.q(R.color.CAM_X0109);
                d2.v(R.string.F_X01);
                c d3 = c.d(this.f19437b);
                d3.k(R.string.J_X05);
                d3.f(R.color.CAM_X0204);
            }
            this.f19436a = i;
        }
    }

    public PbPrivateTitleAdapter(i iVar) {
        super(iVar, n.f53848e);
    }

    @Override // d.b.i0.d2.k.e.o, d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        l0(i, view, viewGroup, (n) obj, (PbPrivateTitleViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public PbPrivateTitleViewHolder R(ViewGroup viewGroup) {
        return new PbPrivateTitleViewHolder(this.m.getPageContext(), LayoutInflater.from(this.f42855e).inflate(R.layout.pb_private_title_layout, viewGroup, false));
    }

    public View l0(int i, View view, ViewGroup viewGroup, n nVar, PbPrivateTitleViewHolder pbPrivateTitleViewHolder) {
        super.X(i, view, viewGroup, nVar, pbPrivateTitleViewHolder);
        pbPrivateTitleViewHolder.b(TbadkCoreApplication.getInst().getSkinType());
        return view;
    }
}
