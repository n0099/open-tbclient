package com.baidu.tieba.pb.videopb.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class a extends af.a implements View.OnClickListener {
    private bw ajz;
    CardForumHeadLayout kNz;

    public a(View view) {
        super(view);
        this.kNz = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        if (this.kNz != null) {
            this.kNz.setOnClickListener(this.kNz);
            this.kNz.setAfterClickListener(this);
        }
    }

    public void setData(bw bwVar) {
        this.ajz = bwVar;
        this.kNz.setData(bwVar);
    }

    public void bkF() {
        this.kNz.onChangeSkinType();
        ap.c(this.kNz, l.getDimens(this.itemView.getContext(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ajz != null) {
            TiebaStatic.log(new aq("c13399").dD("tid", this.ajz.getTid()).u("fid", this.ajz.getFid()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("nid", this.ajz.getNid()));
        }
    }
}
