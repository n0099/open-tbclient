package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.g;
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.widget.ListView.a<g, a> {
    public d(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cc */
    public a b(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.mContext);
        cardForumHeadLayout.setPadding(l.getDimens(this.mContext, R.dimen.tbds44), l.getDimens(this.mContext, R.dimen.tbds19), l.getDimens(this.mContext, R.dimen.tbds44), l.getDimens(this.mContext, R.dimen.tbds54));
        frameLayout.addView(cardForumHeadLayout, new FrameLayout.LayoutParams(-1, -2));
        View view = new View(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(this.mContext, R.dimen.tbds1));
        layoutParams.leftMargin = l.getDimens(this.mContext, R.dimen.tbds44);
        layoutParams.rightMargin = l.getDimens(this.mContext, R.dimen.tbds44);
        frameLayout.addView(view, layoutParams);
        ImageView imageView = new ImageView(this.mContext);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(l.getDimens(this.mContext, R.dimen.tbds52), l.getDimens(this.mContext, R.dimen.tbds52));
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
    public View a(int i, View view, ViewGroup viewGroup, g gVar, a aVar) {
        if (gVar != null) {
            aVar.a(gVar);
        }
        aVar.aWr();
        return view;
    }

    /* loaded from: classes9.dex */
    public class a extends aa.a implements View.OnClickListener {
        View dJr;
        ImageView hQb;
        View hxk;
        CardForumHeadLayout jUX;
        private g jUY;

        public a(View view) {
            super(view);
            this.jUX = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
            if (this.jUX != null) {
                this.jUX.setOnClickListener(this.jUX);
                this.jUX.setAfterClickListener(this);
            }
            this.dJr = ((ViewGroup) view).getChildAt(1);
            this.hQb = (ImageView) ((ViewGroup) view).getChildAt(2);
            this.hxk = ((ViewGroup) view).getChildAt(3);
        }

        public void a(g gVar) {
            if (gVar != null) {
                this.jUY = gVar;
                this.hxk.setVisibility(gVar.jFY ? 0 : 8);
                if (getView() != null) {
                    getView().setPadding(0, 0, 0, gVar.jFY ? l.getDimens(d.this.mContext, R.dimen.tbds42) : 0);
                }
                this.jUX.setData(gVar.forumName, gVar.jFX, gVar.postNum, gVar.memberNum);
            }
        }

        public void aWr() {
            SvgManager.aUW().a(this.hQb, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            am.setBackgroundColor(this.dJr, R.color.cp_bg_line_b);
            am.setBackgroundColor(this.hxk, R.color.cp_bg_line_b);
            this.jUX.onChangeSkinType();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new an("c13698").dh("tid", this.jUY.tid).dh("fid", this.jUY.fid).s("uid", TbadkCoreApplication.getCurrentAccountId()));
        }
    }
}
