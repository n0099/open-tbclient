package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.b.j.e.a;
import d.b.i0.c2.h.g;
/* loaded from: classes4.dex */
public class PbFirstFloorEnterForumAdapter extends a<g, PbFirstFloorEnterForumViewHolder> {

    /* loaded from: classes4.dex */
    public class PbFirstFloorEnterForumViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public CardForumHeadLayout f19778e;

        /* renamed from: f  reason: collision with root package name */
        public View f19779f;

        /* renamed from: g  reason: collision with root package name */
        public View f19780g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f19781h;
        public g i;

        public PbFirstFloorEnterForumViewHolder(View view) {
            super(view);
            ViewGroup viewGroup = (ViewGroup) view;
            CardForumHeadLayout cardForumHeadLayout = (CardForumHeadLayout) viewGroup.getChildAt(0);
            this.f19778e = cardForumHeadLayout;
            if (cardForumHeadLayout != null) {
                cardForumHeadLayout.setOnClickListener(cardForumHeadLayout);
                this.f19778e.setAfterClickListener(this);
            }
            this.f19779f = viewGroup.getChildAt(1);
            this.f19781h = (ImageView) viewGroup.getChildAt(2);
            this.f19780g = viewGroup.getChildAt(3);
        }

        public void b() {
            WebPManager.setPureDrawable(this.f19781h, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0107, null);
            SkinManager.setBackgroundColor(this.f19779f, R.color.CAM_X0203);
            SkinManager.setBackgroundColor(this.f19780g, R.color.CAM_X0203);
            this.f19778e.b();
        }

        public void c(g gVar) {
            if (gVar != null) {
                this.i = gVar;
                this.f19780g.setVisibility(gVar.i ? 0 : 8);
                if (a() != null) {
                    a().setPadding(0, 0, 0, gVar.i ? l.g(PbFirstFloorEnterForumAdapter.this.f42357e, R.dimen.tbds42) : 0);
                }
                this.f19778e.setData(gVar.f52427e, gVar.f52428f, gVar.f52429g, gVar.f52430h);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c13698").param("tid", this.i.k).param("fid", this.i.j).param("uid", TbadkCoreApplication.getCurrentAccountId()));
        }
    }

    public PbFirstFloorEnterForumAdapter(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, g gVar, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        j0(i, view, viewGroup, gVar, pbFirstFloorEnterForumViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public PbFirstFloorEnterForumViewHolder R(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(this.f42357e);
        int g2 = l.g(this.f42357e, R.dimen.M_W_X007);
        CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.f42357e);
        cardForumHeadLayout.setPadding(0, l.g(this.f42357e, R.dimen.tbds32), 0, l.g(this.f42357e, R.dimen.tbds13));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = g2;
        layoutParams.rightMargin = g2;
        frameLayout.addView(cardForumHeadLayout, layoutParams);
        View view = new View(this.f42357e);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.g(this.f42357e, R.dimen.tbds1));
        layoutParams2.leftMargin = g2;
        layoutParams2.rightMargin = g2;
        frameLayout.addView(view, layoutParams2);
        ImageView imageView = new ImageView(this.f42357e);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(l.g(this.f42357e, R.dimen.tbds42), l.g(this.f42357e, R.dimen.tbds42));
        layoutParams3.gravity = 21;
        layoutParams3.rightMargin = g2;
        frameLayout.addView(imageView, layoutParams3);
        View view2 = new View(this.f42357e);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, l.g(this.f42357e, R.dimen.tbds1));
        layoutParams4.leftMargin = g2;
        layoutParams4.rightMargin = g2;
        layoutParams4.gravity = 80;
        frameLayout.addView(view2, layoutParams4);
        return new PbFirstFloorEnterForumViewHolder(frameLayout);
    }

    public View j0(int i, View view, ViewGroup viewGroup, g gVar, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        if (gVar != null) {
            pbFirstFloorEnterForumViewHolder.c(gVar);
        }
        pbFirstFloorEnterForumViewHolder.b();
        return view;
    }
}
