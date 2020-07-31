package com.baidu.tieba.pb.videopb.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class a extends ad.a implements View.OnClickListener {
    private bv aii;
    CardForumHeadLayout kxL;

    public a(View view) {
        super(view);
        this.kxL = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        if (this.kxL != null) {
            this.kxL.setOnClickListener(this.kxL);
            this.kxL.setAfterClickListener(this);
        }
    }

    public void setData(bv bvVar) {
        this.aii = bvVar;
        this.kxL.setData(bvVar);
    }

    public void bci() {
        this.kxL.onChangeSkinType();
        ao.c(this.kxL, l.getDimens(this.itemView.getContext(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aii != null) {
            TiebaStatic.log(new ap("c13399").dn("tid", this.aii.getTid()).t("fid", this.aii.getFid()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("nid", this.aii.getNid()));
        }
    }
}
