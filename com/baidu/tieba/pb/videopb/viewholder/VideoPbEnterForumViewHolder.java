package com.baidu.tieba.pb.videopb.viewholder;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
/* loaded from: classes5.dex */
public class VideoPbEnterForumViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public CardForumHeadLayout f20113e;

    /* renamed from: f  reason: collision with root package name */
    public a2 f20114f;

    public VideoPbEnterForumViewHolder(View view) {
        super(view);
        CardForumHeadLayout cardForumHeadLayout = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        this.f20113e = cardForumHeadLayout;
        if (cardForumHeadLayout != null) {
            cardForumHeadLayout.setOnClickListener(cardForumHeadLayout);
            this.f20113e.setAfterClickListener(this);
        }
    }

    public void b() {
        this.f20113e.b();
        CardForumHeadLayout cardForumHeadLayout = this.f20113e;
        int g2 = l.g(this.itemView.getContext(), R.dimen.tbds10);
        int i = R.color.CAM_X0206;
        SkinManager.setBackgroundShapeDrawable(cardForumHeadLayout, g2, i, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f20114f != null) {
            TiebaStatic.log(new StatisticItem("c13399").param("tid", this.f20114f.w1()).param("fid", this.f20114f.c0()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("nid", this.f20114f.L0()));
        }
    }

    public void setData(a2 a2Var) {
        this.f20114f = a2Var;
        this.f20113e.setData(a2Var);
    }
}
