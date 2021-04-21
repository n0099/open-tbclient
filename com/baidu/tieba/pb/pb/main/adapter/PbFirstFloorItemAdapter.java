package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.c.j.e.w;
import d.b.j0.d2.h.h;
import d.b.j0.d3.h0.m;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class PbFirstFloorItemAdapter extends d.b.c.j.e.a<h, PbFirstFloorItemViewHolder> {

    /* loaded from: classes3.dex */
    public class PbFirstFloorItemViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public TextView f19476e;

        /* renamed from: f  reason: collision with root package name */
        public ItemCardView f19477f;

        /* renamed from: g  reason: collision with root package name */
        public View f19478g;

        public PbFirstFloorItemViewHolder(View view) {
            super(view);
            ViewGroup viewGroup = (ViewGroup) view;
            this.f19478g = viewGroup.getChildAt(0);
            this.f19476e = (TextView) viewGroup.getChildAt(1);
            this.f19477f = (ItemCardView) viewGroup.getChildAt(2);
        }

        public void b() {
            SkinManager.setBackgroundColor(this.f19478g, R.color.CAM_X0203);
            SkinManager.setViewTextColor(this.f19476e, R.color.CAM_X0109);
            this.f19477f.b();
        }

        public void c(h hVar) {
            if (hVar != null) {
                this.f19476e.setText(PbFirstFloorItemAdapter.this.f43095e.getText(R.string.related_recommendation));
                this.f19477f.setData(hVar.f54249e, 17);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements w {
        public a(PbFirstFloorItemAdapter pbFirstFloorItemAdapter) {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (nVar instanceof h) {
                h hVar = (h) nVar;
                if (hVar.f54249e == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("itemID", String.valueOf(hVar.f54249e.item_id));
                hashMap.put("source", 9);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
                StatisticItem statisticItem = new StatisticItem("c14071");
                statisticItem.param("tid", hVar.f54250f);
                statisticItem.param("obj_locate", hVar.f54249e.item_id.longValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public PbFirstFloorItemAdapter(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, h hVar, PbFirstFloorItemViewHolder pbFirstFloorItemViewHolder) {
        j0(i, view, viewGroup, hVar, pbFirstFloorItemViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public PbFirstFloorItemViewHolder R(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(this.f43095e);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        int g2 = l.g(this.f43095e, R.dimen.M_W_X007);
        int g3 = l.g(this.f43095e, R.dimen.T_X09);
        int g4 = l.g(this.f43095e, R.dimen.M_H_X005);
        int g5 = l.g(this.f43095e, R.dimen.M_H_X003);
        View view = new View(this.f43095e);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.g(this.f43095e, R.dimen.tbds1));
        layoutParams.leftMargin = g2;
        layoutParams.rightMargin = g2;
        linearLayout.addView(view, layoutParams);
        TextView textView = new TextView(this.f43095e);
        textView.setTextSize(0, g3);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = g2;
        layoutParams2.topMargin = g4;
        layoutParams2.bottomMargin = g5;
        linearLayout.addView(textView, layoutParams2);
        ItemCardView itemCardView = new ItemCardView(this.f43095e);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = g2;
        layoutParams3.rightMargin = g2;
        layoutParams3.bottomMargin = g4;
        linearLayout.addView(itemCardView, layoutParams3);
        c0(new a(this));
        return new PbFirstFloorItemViewHolder(linearLayout);
    }

    public View j0(int i, View view, ViewGroup viewGroup, h hVar, PbFirstFloorItemViewHolder pbFirstFloorItemViewHolder) {
        if (hVar != null && hVar.f54249e != null) {
            pbFirstFloorItemViewHolder.c(hVar);
        }
        pbFirstFloorItemViewHolder.b();
        StatisticItem statisticItem = new StatisticItem("c14070");
        statisticItem.param("tid", hVar.f54250f);
        statisticItem.param("obj_locate", hVar.f54249e.item_id.longValue());
        TiebaStatic.log(statisticItem);
        return view;
    }
}
