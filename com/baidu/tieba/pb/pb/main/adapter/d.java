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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
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
    /* renamed from: cs */
    public a c(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        int dimens = l.getDimens(this.mContext, R.dimen.M_W_X007);
        CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.mContext);
        cardForumHeadLayout.setPadding(0, l.getDimens(this.mContext, R.dimen.tbds32), 0, l.getDimens(this.mContext, R.dimen.tbds13));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = dimens;
        layoutParams.rightMargin = dimens;
        frameLayout.addView(cardForumHeadLayout, layoutParams);
        View view = new View(this.mContext);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.getDimens(this.mContext, R.dimen.tbds1));
        layoutParams2.leftMargin = dimens;
        layoutParams2.rightMargin = dimens;
        frameLayout.addView(view, layoutParams2);
        ImageView imageView = new ImageView(this.mContext);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(l.getDimens(this.mContext, R.dimen.tbds42), l.getDimens(this.mContext, R.dimen.tbds42));
        layoutParams3.gravity = 21;
        layoutParams3.rightMargin = dimens;
        frameLayout.addView(imageView, layoutParams3);
        View view2 = new View(this.mContext);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, l.getDimens(this.mContext, R.dimen.tbds1));
        layoutParams4.leftMargin = dimens;
        layoutParams4.rightMargin = dimens;
        layoutParams4.gravity = 80;
        frameLayout.addView(view2, layoutParams4);
        return new a(frameLayout);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (hVar != null) {
            aVar.a(hVar);
        }
        aVar.bvt();
        return view;
    }

    /* loaded from: classes22.dex */
    public class a extends af.a implements View.OnClickListener {
        View bNf;
        View eOv;
        ImageView jAB;
        CardForumHeadLayout lRX;
        private h lRY;

        public a(View view) {
            super(view);
            this.lRX = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
            if (this.lRX != null) {
                this.lRX.setOnClickListener(this.lRX);
                this.lRX.setAfterClickListener(this);
            }
            this.eOv = ((ViewGroup) view).getChildAt(1);
            this.jAB = (ImageView) ((ViewGroup) view).getChildAt(2);
            this.bNf = ((ViewGroup) view).getChildAt(3);
        }

        public void a(h hVar) {
            if (hVar != null) {
                this.lRY = hVar;
                this.bNf.setVisibility(hVar.lBI ? 0 : 8);
                if (getView() != null) {
                    getView().setPadding(0, 0, 0, hVar.lBI ? l.getDimens(d.this.mContext, R.dimen.tbds42) : 0);
                }
                this.lRX.setData(hVar.forumName, hVar.lBH, hVar.postNum, hVar.memberNum);
            }
        }

        public void bvt() {
            WebPManager.a(this.jAB, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0107, null);
            ap.setBackgroundColor(this.eOv, R.color.CAM_X0203);
            ap.setBackgroundColor(this.bNf, R.color.CAM_X0203);
            this.lRX.onChangeSkinType();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ar("c13698").dY("tid", this.lRY.tid).dY("fid", this.lRY.fid).w("uid", TbadkCoreApplication.getCurrentAccountId()));
        }
    }
}
