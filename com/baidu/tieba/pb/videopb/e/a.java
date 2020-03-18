package com.baidu.tieba.pb.videopb.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a extends v.a implements View.OnClickListener {
    private bj NR;
    CardForumHeadLayout jcR;

    public a(View view) {
        super(view);
        this.jcR = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        if (this.jcR != null) {
            this.jcR.setOnClickListener(this.jcR);
            this.jcR.setAfterClickListener(this);
        }
    }

    public void setData(bj bjVar) {
        this.NR = bjVar;
        this.jcR.setData(bjVar);
    }

    public void aHS() {
        this.jcR.onChangeSkinType();
        am.c(this.jcR, l.getDimens(this.itemView.getContext(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.NR != null) {
            TiebaStatic.log(new an("c13399").cx("tid", this.NR.getTid()).s("fid", this.NR.getFid()).cx("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }
}
