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
import d.b.c.e.p.l;
import d.b.c.j.e.a;
import d.b.i0.d2.h.g;
/* loaded from: classes3.dex */
public class PbFirstFloorEnterForumAdapter extends a<g, PbFirstFloorEnterForumViewHolder> {

    /* loaded from: classes3.dex */
    public class PbFirstFloorEnterForumViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public CardForumHeadLayout f19464e;

        /* renamed from: f  reason: collision with root package name */
        public View f19465f;

        /* renamed from: g  reason: collision with root package name */
        public View f19466g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f19467h;
        public g i;

        public PbFirstFloorEnterForumViewHolder(View view) {
            super(view);
            ViewGroup viewGroup = (ViewGroup) view;
            CardForumHeadLayout cardForumHeadLayout = (CardForumHeadLayout) viewGroup.getChildAt(0);
            this.f19464e = cardForumHeadLayout;
            if (cardForumHeadLayout != null) {
                cardForumHeadLayout.setOnClickListener(cardForumHeadLayout);
                this.f19464e.setAfterClickListener(this);
            }
            this.f19465f = viewGroup.getChildAt(1);
            this.f19467h = (ImageView) viewGroup.getChildAt(2);
            this.f19466g = viewGroup.getChildAt(3);
        }

        public void b() {
            WebPManager.setPureDrawable(this.f19467h, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0107, null);
            SkinManager.setBackgroundColor(this.f19465f, R.color.CAM_X0203);
            SkinManager.setBackgroundColor(this.f19466g, R.color.CAM_X0203);
            this.f19464e.b();
        }

        public void c(g gVar) {
            if (gVar != null) {
                this.i = gVar;
                this.f19466g.setVisibility(gVar.i ? 0 : 8);
                if (a() != null) {
                    a().setPadding(0, 0, 0, gVar.i ? l.g(PbFirstFloorEnterForumAdapter.this.f42855e, R.dimen.tbds42) : 0);
                }
                this.f19464e.setData(gVar.f53823e, gVar.f53824f, gVar.f53825g, gVar.f53826h);
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
    @Override // d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, g gVar, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        j0(i, view, viewGroup, gVar, pbFirstFloorEnterForumViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public PbFirstFloorEnterForumViewHolder R(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(this.f42855e);
        int g2 = l.g(this.f42855e, R.dimen.M_W_X007);
        CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.f42855e);
        cardForumHeadLayout.setPadding(0, l.g(this.f42855e, R.dimen.tbds32), 0, l.g(this.f42855e, R.dimen.tbds13));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = g2;
        layoutParams.rightMargin = g2;
        frameLayout.addView(cardForumHeadLayout, layoutParams);
        View view = new View(this.f42855e);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.g(this.f42855e, R.dimen.tbds1));
        layoutParams2.leftMargin = g2;
        layoutParams2.rightMargin = g2;
        frameLayout.addView(view, layoutParams2);
        ImageView imageView = new ImageView(this.f42855e);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(l.g(this.f42855e, R.dimen.tbds42), l.g(this.f42855e, R.dimen.tbds42));
        layoutParams3.gravity = 21;
        layoutParams3.rightMargin = g2;
        frameLayout.addView(imageView, layoutParams3);
        View view2 = new View(this.f42855e);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, l.g(this.f42855e, R.dimen.tbds1));
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
