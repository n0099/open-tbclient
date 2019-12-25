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
/* loaded from: classes6.dex */
public class a extends v.a implements View.OnClickListener {
    private bj Nl;
    CardForumHeadLayout iVV;

    public a(View view) {
        super(view);
        this.iVV = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        if (this.iVV != null) {
            this.iVV.setOnClickListener(this.iVV);
            this.iVV.setAfterClickListener(this);
        }
    }

    public void setData(bj bjVar) {
        this.Nl = bjVar;
        this.iVV.setData(bjVar);
    }

    public void aFd() {
        this.iVV.onChangeSkinType();
        am.c(this.iVV, l.getDimens(this.itemView.getContext(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Nl != null) {
            TiebaStatic.log(new an("c13399").cp("tid", this.Nl.getTid()).s("fid", this.Nl.getFid()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }
}
