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
import d.a.c.e.p.l;
import d.a.m0.r.q.a2;
/* loaded from: classes5.dex */
public class VideoPbEnterForumViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public CardForumHeadLayout f19509e;

    /* renamed from: f  reason: collision with root package name */
    public a2 f19510f;

    public VideoPbEnterForumViewHolder(View view) {
        super(view);
        CardForumHeadLayout cardForumHeadLayout = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        this.f19509e = cardForumHeadLayout;
        if (cardForumHeadLayout != null) {
            cardForumHeadLayout.setOnClickListener(cardForumHeadLayout);
            this.f19509e.setAfterClickListener(this);
        }
    }

    public void b() {
        this.f19509e.b();
        CardForumHeadLayout cardForumHeadLayout = this.f19509e;
        int g2 = l.g(this.itemView.getContext(), R.dimen.tbds10);
        int i2 = R.color.CAM_X0206;
        SkinManager.setBackgroundShapeDrawable(cardForumHeadLayout, g2, i2, i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f19510f != null) {
            TiebaStatic.log(new StatisticItem("c13399").param("tid", this.f19510f.y1()).param("fid", this.f19510f.c0()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("nid", this.f19510f.M0()));
        }
    }

    public void setData(a2 a2Var) {
        this.f19510f = a2Var;
        this.f19509e.setData(a2Var);
    }
}
