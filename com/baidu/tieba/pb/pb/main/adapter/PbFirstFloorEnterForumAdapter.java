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
import d.a.c.e.p.l;
import d.a.c.j.e.a;
import d.a.j0.d2.h.g;
/* loaded from: classes3.dex */
public class PbFirstFloorEnterForumAdapter extends a<g, PbFirstFloorEnterForumViewHolder> {

    /* loaded from: classes3.dex */
    public class PbFirstFloorEnterForumViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public CardForumHeadLayout f19943e;

        /* renamed from: f  reason: collision with root package name */
        public View f19944f;

        /* renamed from: g  reason: collision with root package name */
        public View f19945g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f19946h;

        /* renamed from: i  reason: collision with root package name */
        public g f19947i;

        public PbFirstFloorEnterForumViewHolder(View view) {
            super(view);
            ViewGroup viewGroup = (ViewGroup) view;
            CardForumHeadLayout cardForumHeadLayout = (CardForumHeadLayout) viewGroup.getChildAt(0);
            this.f19943e = cardForumHeadLayout;
            if (cardForumHeadLayout != null) {
                cardForumHeadLayout.setOnClickListener(cardForumHeadLayout);
                this.f19943e.setAfterClickListener(this);
            }
            this.f19944f = viewGroup.getChildAt(1);
            this.f19946h = (ImageView) viewGroup.getChildAt(2);
            this.f19945g = viewGroup.getChildAt(3);
        }

        public void b() {
            WebPManager.setPureDrawable(this.f19946h, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0107, null);
            SkinManager.setBackgroundColor(this.f19944f, R.color.CAM_X0203);
            SkinManager.setBackgroundColor(this.f19945g, R.color.CAM_X0203);
            this.f19943e.b();
        }

        public void c(g gVar) {
            if (gVar != null) {
                this.f19947i = gVar;
                this.f19945g.setVisibility(gVar.f52028i ? 0 : 8);
                if (a() != null) {
                    a().setPadding(0, 0, 0, gVar.f52028i ? l.g(PbFirstFloorEnterForumAdapter.this.f40319e, R.dimen.tbds42) : 0);
                }
                this.f19943e.setData(gVar.f52024e, gVar.f52025f, gVar.f52026g, gVar.f52027h);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c13698").param("tid", this.f19947i.k).param("fid", this.f19947i.j).param("uid", TbadkCoreApplication.getCurrentAccountId()));
        }
    }

    public PbFirstFloorEnterForumAdapter(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, g gVar, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        g0(i2, view, viewGroup, gVar, pbFirstFloorEnterForumViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public PbFirstFloorEnterForumViewHolder P(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(this.f40319e);
        int g2 = l.g(this.f40319e, R.dimen.M_W_X007);
        CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.f40319e);
        cardForumHeadLayout.setPadding(0, l.g(this.f40319e, R.dimen.tbds32), 0, l.g(this.f40319e, R.dimen.tbds13));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = g2;
        layoutParams.rightMargin = g2;
        frameLayout.addView(cardForumHeadLayout, layoutParams);
        View view = new View(this.f40319e);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.g(this.f40319e, R.dimen.tbds1));
        layoutParams2.leftMargin = g2;
        layoutParams2.rightMargin = g2;
        frameLayout.addView(view, layoutParams2);
        ImageView imageView = new ImageView(this.f40319e);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(l.g(this.f40319e, R.dimen.tbds42), l.g(this.f40319e, R.dimen.tbds42));
        layoutParams3.gravity = 21;
        layoutParams3.rightMargin = g2;
        frameLayout.addView(imageView, layoutParams3);
        View view2 = new View(this.f40319e);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, l.g(this.f40319e, R.dimen.tbds1));
        layoutParams4.leftMargin = g2;
        layoutParams4.rightMargin = g2;
        layoutParams4.gravity = 80;
        frameLayout.addView(view2, layoutParams4);
        return new PbFirstFloorEnterForumViewHolder(frameLayout);
    }

    public View g0(int i2, View view, ViewGroup viewGroup, g gVar, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        if (gVar != null) {
            pbFirstFloorEnterForumViewHolder.c(gVar);
        }
        pbFirstFloorEnterForumViewHolder.b();
        return view;
    }
}
