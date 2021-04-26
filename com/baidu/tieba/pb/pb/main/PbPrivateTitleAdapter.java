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
import d.a.c.e.p.l;
import d.a.i0.r.u.c;
import d.a.j0.d2.h.n;
import d.a.j0.d2.k.e.o;
import d.a.j0.d2.o.i;
/* loaded from: classes3.dex */
public class PbPrivateTitleAdapter extends o<n, PbPrivateTitleViewHolder> {

    /* loaded from: classes3.dex */
    public static class PbPrivateTitleViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f19913a;

        /* renamed from: b  reason: collision with root package name */
        public View f19914b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19915c;

        public PbPrivateTitleViewHolder(TbPageContext tbPageContext, View view) {
            super(view);
            this.f19913a = 3;
            if (view == null) {
                return;
            }
            this.f19914b = view.findViewById(R.id.background);
            this.f19915c = (TextView) view.findViewById(R.id.title);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tbPageContext.getResources().getString(R.string.pb_private_block_title));
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_barrules_careful12, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.d(l.g(tbPageContext.getContext(), R.dimen.tbds31));
            eMRichTextAnyIconSpan.c(l.g(tbPageContext.getContext(), R.dimen.M_W_X002));
            eMRichTextAnyIconSpan.a(0);
            spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
            this.f19915c.setText(spannableStringBuilder);
            b(TbadkCoreApplication.getInst().getSkinType());
        }

        public void b(int i2) {
            if (this.f19913a != i2) {
                c d2 = c.d(this.f19915c);
                d2.q(R.color.CAM_X0109);
                d2.v(R.string.F_X01);
                c d3 = c.d(this.f19914b);
                d3.k(R.string.J_X05);
                d3.f(R.color.CAM_X0204);
            }
            this.f19913a = i2;
        }
    }

    public PbPrivateTitleAdapter(i iVar) {
        super(iVar, n.f52050e);
    }

    @Override // d.a.j0.d2.k.e.o, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        h0(i2, view, viewGroup, (n) obj, (PbPrivateTitleViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public PbPrivateTitleViewHolder P(ViewGroup viewGroup) {
        return new PbPrivateTitleViewHolder(this.m.getPageContext(), LayoutInflater.from(this.f40319e).inflate(R.layout.pb_private_title_layout, viewGroup, false));
    }

    public View h0(int i2, View view, ViewGroup viewGroup, n nVar, PbPrivateTitleViewHolder pbPrivateTitleViewHolder) {
        super.W(i2, view, viewGroup, nVar, pbPrivateTitleViewHolder);
        pbPrivateTitleViewHolder.b(TbadkCoreApplication.getInst().getSkinType());
        return view;
    }
}
