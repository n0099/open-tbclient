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
import d.a.c.k.e.a;
import d.a.o0.e2.h.g;
/* loaded from: classes5.dex */
public class PbFirstFloorEnterForumAdapter extends a<g, PbFirstFloorEnterForumViewHolder> {

    /* loaded from: classes5.dex */
    public class PbFirstFloorEnterForumViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public CardForumHeadLayout f19310e;

        /* renamed from: f  reason: collision with root package name */
        public View f19311f;

        /* renamed from: g  reason: collision with root package name */
        public View f19312g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f19313h;

        /* renamed from: i  reason: collision with root package name */
        public g f19314i;

        public PbFirstFloorEnterForumViewHolder(View view) {
            super(view);
            ViewGroup viewGroup = (ViewGroup) view;
            CardForumHeadLayout cardForumHeadLayout = (CardForumHeadLayout) viewGroup.getChildAt(0);
            this.f19310e = cardForumHeadLayout;
            if (cardForumHeadLayout != null) {
                cardForumHeadLayout.setOnClickListener(cardForumHeadLayout);
                this.f19310e.setAfterClickListener(this);
            }
            this.f19311f = viewGroup.getChildAt(1);
            this.f19313h = (ImageView) viewGroup.getChildAt(2);
            this.f19312g = viewGroup.getChildAt(3);
        }

        public void b() {
            WebPManager.setPureDrawable(this.f19313h, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0107, null);
            SkinManager.setBackgroundColor(this.f19311f, R.color.CAM_X0203);
            SkinManager.setBackgroundColor(this.f19312g, R.color.CAM_X0203);
            this.f19310e.b();
        }

        public void c(g gVar) {
            if (gVar != null) {
                this.f19314i = gVar;
                this.f19312g.setVisibility(gVar.f56746i ? 0 : 8);
                if (a() != null) {
                    a().setPadding(0, 0, 0, gVar.f56746i ? l.g(PbFirstFloorEnterForumAdapter.this.f43012e, R.dimen.tbds42) : 0);
                }
                this.f19310e.setData(gVar.f56742e, gVar.f56743f, gVar.f56744g, gVar.f56745h);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c13698").param("tid", this.f19314i.k).param("fid", this.f19314i.j).param("uid", TbadkCoreApplication.getCurrentAccountId()));
        }
    }

    public PbFirstFloorEnterForumAdapter(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, g gVar, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        h0(i2, view, viewGroup, gVar, pbFirstFloorEnterForumViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public PbFirstFloorEnterForumViewHolder Q(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(this.f43012e);
        int g2 = l.g(this.f43012e, R.dimen.M_W_X007);
        CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.f43012e);
        cardForumHeadLayout.setPadding(0, l.g(this.f43012e, R.dimen.tbds32), 0, l.g(this.f43012e, R.dimen.tbds13));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = g2;
        layoutParams.rightMargin = g2;
        frameLayout.addView(cardForumHeadLayout, layoutParams);
        View view = new View(this.f43012e);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.g(this.f43012e, R.dimen.tbds1));
        layoutParams2.leftMargin = g2;
        layoutParams2.rightMargin = g2;
        frameLayout.addView(view, layoutParams2);
        ImageView imageView = new ImageView(this.f43012e);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(l.g(this.f43012e, R.dimen.tbds42), l.g(this.f43012e, R.dimen.tbds42));
        layoutParams3.gravity = 21;
        layoutParams3.rightMargin = g2;
        frameLayout.addView(imageView, layoutParams3);
        View view2 = new View(this.f43012e);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, l.g(this.f43012e, R.dimen.tbds1));
        layoutParams4.leftMargin = g2;
        layoutParams4.rightMargin = g2;
        layoutParams4.gravity = 80;
        frameLayout.addView(view2, layoutParams4);
        return new PbFirstFloorEnterForumViewHolder(frameLayout);
    }

    public View h0(int i2, View view, ViewGroup viewGroup, g gVar, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        if (gVar != null) {
            pbFirstFloorEnterForumViewHolder.c(gVar);
        }
        pbFirstFloorEnterForumViewHolder.b();
        return view;
    }
}
