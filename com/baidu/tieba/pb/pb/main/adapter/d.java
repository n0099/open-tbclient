package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.h;
/* loaded from: classes22.dex */
public class d extends com.baidu.adp.widget.ListView.a<h, a> {
    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cr */
    public a c(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.mContext);
        cardForumHeadLayout.setPadding(l.getDimens(this.mContext, R.dimen.tbds44), l.getDimens(this.mContext, R.dimen.tbds19), l.getDimens(this.mContext, R.dimen.tbds44), l.getDimens(this.mContext, R.dimen.tbds44));
        frameLayout.addView(cardForumHeadLayout, new FrameLayout.LayoutParams(-1, -2));
        View view = new View(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(this.mContext, R.dimen.tbds1));
        layoutParams.leftMargin = l.getDimens(this.mContext, R.dimen.tbds44);
        layoutParams.rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
        frameLayout.addView(view, layoutParams);
        ImageView imageView = new ImageView(this.mContext);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(this.mContext, R.dimen.tbds42), l.getDimens(this.mContext, R.dimen.tbds42));
        layoutParams2.gravity = 5;
        layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.tbds76);
        layoutParams2.rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
        frameLayout.addView(imageView, layoutParams2);
        View view2 = new View(this.mContext);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, l.getDimens(this.mContext, R.dimen.tbds1));
        layoutParams3.leftMargin = l.getDimens(this.mContext, R.dimen.tbds44);
        layoutParams3.rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
        layoutParams3.gravity = 80;
        frameLayout.addView(view2, layoutParams3);
        return new a(frameLayout);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (hVar != null) {
            aVar.a(hVar);
        }
        aVar.bqd();
        return view;
    }

    /* loaded from: classes22.dex */
    public class a extends af.a implements View.OnClickListener {
        View bEb;
        View eCZ;
        ImageView jgo;
        CardForumHeadLayout lxP;
        private h lxQ;

        public a(View view) {
            super(view);
            this.lxP = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
            if (this.lxP != null) {
                this.lxP.setOnClickListener(this.lxP);
                this.lxP.setAfterClickListener(this);
            }
            this.eCZ = ((ViewGroup) view).getChildAt(1);
            this.jgo = (ImageView) ((ViewGroup) view).getChildAt(2);
            this.bEb = ((ViewGroup) view).getChildAt(3);
        }

        public void a(h hVar) {
            if (hVar != null) {
                this.lxQ = hVar;
                this.bEb.setVisibility(hVar.lhT ? 0 : 8);
                if (getView() != null) {
                    getView().setPadding(0, 0, 0, hVar.lhT ? l.getDimens(d.this.mContext, R.dimen.tbds42) : 0);
                }
                this.lxP.setData(hVar.forumName, hVar.lhS, hVar.postNum, hVar.memberNum);
            }
        }

        public void bqd() {
            SvgManager.boN().a(this.jgo, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            ap.setBackgroundColor(this.eCZ, R.color.cp_bg_line_b);
            ap.setBackgroundColor(this.bEb, R.color.cp_bg_line_b);
            this.lxP.onChangeSkinType();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13698").dR("tid", this.lxQ.tid).dR("fid", this.lxQ.fid).w("uid", TbadkCoreApplication.getCurrentAccountId()));
        }
    }
}
