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
/* loaded from: classes7.dex */
public class a extends v.a implements View.OnClickListener {
    private bj Np;
    CardForumHeadLayout iZy;

    public a(View view) {
        super(view);
        this.iZy = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        if (this.iZy != null) {
            this.iZy.setOnClickListener(this.iZy);
            this.iZy.setAfterClickListener(this);
        }
    }

    public void setData(bj bjVar) {
        this.Np = bjVar;
        this.iZy.setData(bjVar);
    }

    public void aFw() {
        this.iZy.onChangeSkinType();
        am.c(this.iZy, l.getDimens(this.itemView.getContext(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Np != null) {
            TiebaStatic.log(new an("c13399").cp("tid", this.Np.getTid()).s("fid", this.Np.getFid()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }
}
