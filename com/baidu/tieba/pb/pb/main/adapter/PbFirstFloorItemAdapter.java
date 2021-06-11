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
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.n0.e2.h.h;
import d.a.n0.e3.h0.m;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class PbFirstFloorItemAdapter extends d.a.c.k.e.a<h, PbFirstFloorItemViewHolder> {

    /* loaded from: classes5.dex */
    public class PbFirstFloorItemViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public TextView f19233e;

        /* renamed from: f  reason: collision with root package name */
        public ItemCardView f19234f;

        /* renamed from: g  reason: collision with root package name */
        public View f19235g;

        public PbFirstFloorItemViewHolder(View view) {
            super(view);
            ViewGroup viewGroup = (ViewGroup) view;
            this.f19235g = viewGroup.getChildAt(0);
            this.f19233e = (TextView) viewGroup.getChildAt(1);
            this.f19234f = (ItemCardView) viewGroup.getChildAt(2);
        }

        public void b() {
            SkinManager.setBackgroundColor(this.f19235g, R.color.CAM_X0203);
            SkinManager.setViewTextColor(this.f19233e, R.color.CAM_X0109);
            this.f19234f.b();
        }

        public void c(h hVar) {
            if (hVar != null) {
                this.f19233e.setText(PbFirstFloorItemAdapter.this.f42909e.getText(R.string.related_recommendation));
                this.f19234f.setData(hVar.f56623e, 17);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements w {
        public a(PbFirstFloorItemAdapter pbFirstFloorItemAdapter) {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if (nVar instanceof h) {
                h hVar = (h) nVar;
                if (hVar.f56623e == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("itemID", String.valueOf(hVar.f56623e.item_id));
                hashMap.put("source", 9);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
                StatisticItem statisticItem = new StatisticItem("c14071");
                statisticItem.param("tid", hVar.f56624f);
                statisticItem.param("obj_locate", hVar.f56623e.item_id.longValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public PbFirstFloorItemAdapter(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, h hVar, PbFirstFloorItemViewHolder pbFirstFloorItemViewHolder) {
        h0(i2, view, viewGroup, hVar, pbFirstFloorItemViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public PbFirstFloorItemViewHolder Q(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(this.f42909e);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        int g2 = l.g(this.f42909e, R.dimen.M_W_X007);
        int g3 = l.g(this.f42909e, R.dimen.T_X09);
        int g4 = l.g(this.f42909e, R.dimen.M_H_X005);
        int g5 = l.g(this.f42909e, R.dimen.M_H_X003);
        View view = new View(this.f42909e);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.g(this.f42909e, R.dimen.tbds1));
        layoutParams.leftMargin = g2;
        layoutParams.rightMargin = g2;
        linearLayout.addView(view, layoutParams);
        TextView textView = new TextView(this.f42909e);
        textView.setTextSize(0, g3);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = g2;
        layoutParams2.topMargin = g4;
        layoutParams2.bottomMargin = g5;
        linearLayout.addView(textView, layoutParams2);
        ItemCardView itemCardView = new ItemCardView(this.f42909e);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = g2;
        layoutParams3.rightMargin = g2;
        layoutParams3.bottomMargin = g4;
        linearLayout.addView(itemCardView, layoutParams3);
        a0(new a(this));
        return new PbFirstFloorItemViewHolder(linearLayout);
    }

    public View h0(int i2, View view, ViewGroup viewGroup, h hVar, PbFirstFloorItemViewHolder pbFirstFloorItemViewHolder) {
        if (hVar != null && hVar.f56623e != null) {
            pbFirstFloorItemViewHolder.c(hVar);
        }
        pbFirstFloorItemViewHolder.b();
        StatisticItem statisticItem = new StatisticItem("c14070");
        statisticItem.param("tid", hVar.f56624f);
        statisticItem.param("obj_locate", hVar.f56623e.item_id.longValue());
        TiebaStatic.log(statisticItem);
        return view;
    }
}
