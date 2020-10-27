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
/* loaded from: classes22.dex */
public class a extends af.a implements View.OnClickListener {
    private bw akq;
    CardForumHeadLayout lxP;

    public a(View view) {
        super(view);
        this.lxP = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        if (this.lxP != null) {
            this.lxP.setOnClickListener(this.lxP);
            this.lxP.setAfterClickListener(this);
        }
    }

    public void setData(bw bwVar) {
        this.akq = bwVar;
        this.lxP.setData(bwVar);
    }

    public void bqd() {
        this.lxP.onChangeSkinType();
        ap.c(this.lxP, l.getDimens(this.itemView.getContext(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.akq != null) {
            TiebaStatic.log(new aq("c13399").dR("tid", this.akq.getTid()).w("fid", this.akq.getFid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("nid", this.akq.getNid()));
        }
    }
}
