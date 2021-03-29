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
import d.b.b.e.p.l;
import d.b.h0.r.u.c;
import d.b.i0.c2.h.n;
import d.b.i0.c2.k.e.m;
import d.b.i0.c2.o.b;
/* loaded from: classes4.dex */
public class PbPrivateTitleAdapter extends m<n, PbPrivateTitleViewHolder> {

    /* loaded from: classes4.dex */
    public static class PbPrivateTitleViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f19751a;

        /* renamed from: b  reason: collision with root package name */
        public View f19752b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19753c;

        public PbPrivateTitleViewHolder(TbPageContext tbPageContext, View view) {
            super(view);
            this.f19751a = 3;
            if (view == null) {
                return;
            }
            this.f19752b = view.findViewById(R.id.background);
            this.f19753c = (TextView) view.findViewById(R.id.title);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tbPageContext.getResources().getString(R.string.pb_private_block_title));
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_barrules_careful12, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.d(l.g(tbPageContext.getContext(), R.dimen.tbds31));
            eMRichTextAnyIconSpan.c(l.g(tbPageContext.getContext(), R.dimen.M_W_X002));
            eMRichTextAnyIconSpan.a(0);
            spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
            this.f19753c.setText(spannableStringBuilder);
            b(TbadkCoreApplication.getInst().getSkinType());
        }

        public void b(int i) {
            if (this.f19751a != i) {
                c a2 = c.a(this.f19753c);
                a2.n(R.color.CAM_X0109);
                a2.s(R.string.F_X01);
                c a3 = c.a(this.f19752b);
                a3.h(R.string.J_X05);
                a3.c(R.color.CAM_X0204);
            }
            this.f19751a = i;
        }
    }

    public PbPrivateTitleAdapter(b bVar) {
        super(bVar, n.f52453e);
    }

    @Override // d.b.i0.c2.k.e.m, d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        l0(i, view, viewGroup, (n) obj, (PbPrivateTitleViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public PbPrivateTitleViewHolder R(ViewGroup viewGroup) {
        return new PbPrivateTitleViewHolder(this.m.getPageContext(), LayoutInflater.from(this.f42358e).inflate(R.layout.pb_private_title_layout, viewGroup, false));
    }

    public View l0(int i, View view, ViewGroup viewGroup, n nVar, PbPrivateTitleViewHolder pbPrivateTitleViewHolder) {
        super.X(i, view, viewGroup, nVar, pbPrivateTitleViewHolder);
        pbPrivateTitleViewHolder.b(TbadkCoreApplication.getInst().getSkinType());
        return view;
    }
}
