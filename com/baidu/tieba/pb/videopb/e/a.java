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
    private bw akp;
    CardForumHeadLayout llm;

    public a(View view) {
        super(view);
        this.llm = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        if (this.llm != null) {
            this.llm.setOnClickListener(this.llm);
            this.llm.setAfterClickListener(this);
        }
    }

    public void setData(bw bwVar) {
        this.akp = bwVar;
        this.llm.setData(bwVar);
    }

    public void bok() {
        this.llm.onChangeSkinType();
        ap.c(this.llm, l.getDimens(this.itemView.getContext(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.akp != null) {
            TiebaStatic.log(new aq("c13399").dK("tid", this.akp.getTid()).u("fid", this.akp.getFid()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("nid", this.akp.getNid()));
        }
    }
}
