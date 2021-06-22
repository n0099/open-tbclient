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
import d.a.n0.r.u.c;
import d.a.o0.e2.h.n;
import d.a.o0.e2.k.e.o;
import d.a.o0.e2.o.i;
/* loaded from: classes5.dex */
public class PbPrivateTitleAdapter extends o<n, PbPrivateTitleViewHolder> {

    /* loaded from: classes5.dex */
    public static class PbPrivateTitleViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f19276a;

        /* renamed from: b  reason: collision with root package name */
        public View f19277b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19278c;

        public PbPrivateTitleViewHolder(TbPageContext tbPageContext, View view) {
            super(view);
            this.f19276a = 3;
            if (view == null) {
                return;
            }
            this.f19277b = view.findViewById(R.id.background);
            this.f19278c = (TextView) view.findViewById(R.id.title);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tbPageContext.getResources().getString(R.string.pb_private_block_title));
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_barrules_careful12, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.d(l.g(tbPageContext.getContext(), R.dimen.tbds31));
            eMRichTextAnyIconSpan.c(l.g(tbPageContext.getContext(), R.dimen.M_W_X002));
            eMRichTextAnyIconSpan.a(0);
            spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
            this.f19278c.setText(spannableStringBuilder);
            b(TbadkCoreApplication.getInst().getSkinType());
        }

        public void b(int i2) {
            if (this.f19276a != i2) {
                c d2 = c.d(this.f19278c);
                d2.s(R.color.CAM_X0109);
                d2.x(R.string.F_X01);
                c d3 = c.d(this.f19277b);
                d3.m(R.string.J_X05);
                d3.f(R.color.CAM_X0204);
            }
            this.f19276a = i2;
        }
    }

    public PbPrivateTitleAdapter(i iVar) {
        super(iVar, n.f56768e);
    }

    @Override // d.a.o0.e2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        i0(i2, view, viewGroup, (n) obj, (PbPrivateTitleViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public PbPrivateTitleViewHolder Q(ViewGroup viewGroup) {
        return new PbPrivateTitleViewHolder(this.m.getPageContext(), LayoutInflater.from(this.f43012e).inflate(R.layout.pb_private_title_layout, viewGroup, false));
    }

    public View i0(int i2, View view, ViewGroup viewGroup, n nVar, PbPrivateTitleViewHolder pbPrivateTitleViewHolder) {
        super.X(i2, view, viewGroup, nVar, pbPrivateTitleViewHolder);
        pbPrivateTitleViewHolder.b(TbadkCoreApplication.getInst().getSkinType());
        return view;
    }
}
