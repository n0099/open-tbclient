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
    private bw ajx;
    CardForumHeadLayout kNs;

    public a(View view) {
        super(view);
        this.kNs = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        if (this.kNs != null) {
            this.kNs.setOnClickListener(this.kNs);
            this.kNs.setAfterClickListener(this);
        }
    }

    public void setData(bw bwVar) {
        this.ajx = bwVar;
        this.kNs.setData(bwVar);
    }

    public void bkF() {
        this.kNs.onChangeSkinType();
        ap.c(this.kNs, l.getDimens(this.itemView.getContext(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ajx != null) {
            TiebaStatic.log(new aq("c13399").dD("tid", this.ajx.getTid()).u("fid", this.ajx.getFid()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("nid", this.ajx.getNid()));
        }
    }
}
