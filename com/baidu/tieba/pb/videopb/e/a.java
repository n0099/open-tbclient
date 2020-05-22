package com.baidu.tieba.pb.videopb.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a extends aa.a implements View.OnClickListener {
    private bk ahg;
    CardForumHeadLayout jTR;

    public a(View view) {
        super(view);
        this.jTR = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        if (this.jTR != null) {
            this.jTR.setOnClickListener(this.jTR);
            this.jTR.setAfterClickListener(this);
        }
    }

    public void setData(bk bkVar) {
        this.ahg = bkVar;
        this.jTR.setData(bkVar);
    }

    public void aWq() {
        this.jTR.onChangeSkinType();
        am.c(this.jTR, l.getDimens(this.itemView.getContext(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ahg != null) {
            TiebaStatic.log(new an("c13399").dh("tid", this.ahg.getTid()).s("fid", this.ahg.getFid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("nid", this.ahg.getNid()));
        }
    }
}
