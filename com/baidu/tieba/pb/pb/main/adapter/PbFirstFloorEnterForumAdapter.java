package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.h;
/* loaded from: classes2.dex */
public class PbFirstFloorEnterForumAdapter extends com.baidu.adp.widget.ListView.a<h, PbFirstFloorEnterForumViewHolder> {
    public PbFirstFloorEnterForumAdapter(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cE */
    public PbFirstFloorEnterForumViewHolder e(ViewGroup viewGroup) {
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
        return new PbFirstFloorEnterForumViewHolder(frameLayout);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        if (hVar != null) {
            pbFirstFloorEnterForumViewHolder.a(hVar);
        }
        pbFirstFloorEnterForumViewHolder.btV();
        return view;
    }

    /* loaded from: classes2.dex */
    public class PbFirstFloorEnterForumViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
        View bNg;
        View bPy;
        ImageView jIu;
        CardForumHeadLayout lSE;
        private h lSF;

        public PbFirstFloorEnterForumViewHolder(View view) {
            super(view);
            this.lSE = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
            if (this.lSE != null) {
                this.lSE.setOnClickListener(this.lSE);
                this.lSE.setAfterClickListener(this);
            }
            this.bPy = ((ViewGroup) view).getChildAt(1);
            this.jIu = (ImageView) ((ViewGroup) view).getChildAt(2);
            this.bNg = ((ViewGroup) view).getChildAt(3);
        }

        public void a(h hVar) {
            if (hVar != null) {
                this.lSF = hVar;
                this.bNg.setVisibility(hVar.lCi ? 0 : 8);
                if (getView() != null) {
                    getView().setPadding(0, 0, 0, hVar.lCi ? l.getDimens(PbFirstFloorEnterForumAdapter.this.mContext, R.dimen.tbds42) : 0);
                }
                this.lSE.setData(hVar.forumName, hVar.lCh, hVar.postNum, hVar.memberNum);
            }
        }

        public void btV() {
            WebPManager.a(this.jIu, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0107, null);
            ao.setBackgroundColor(this.bPy, R.color.CAM_X0203);
            ao.setBackgroundColor(this.bNg, R.color.CAM_X0203);
            this.lSE.onChangeSkinType();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new aq("c13698").dW("tid", this.lSF.tid).dW("fid", this.lSF.fid).w("uid", TbadkCoreApplication.getCurrentAccountId()));
        }
    }
}
