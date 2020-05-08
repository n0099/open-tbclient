package com.baidu.tieba.pb.videopb.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.y;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a extends y.a implements View.OnClickListener {
    private bj agC;
    CardForumHeadLayout jNd;

    public a(View view) {
        super(view);
        this.jNd = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        if (this.jNd != null) {
            this.jNd.setOnClickListener(this.jNd);
            this.jNd.setAfterClickListener(this);
        }
    }

    public void setData(bj bjVar) {
        this.agC = bjVar;
        this.jNd.setData(bjVar);
    }

    public void aQm() {
        this.jNd.onChangeSkinType();
        am.c(this.jNd, l.getDimens(this.itemView.getContext(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.agC != null) {
            TiebaStatic.log(new an("c13399").cI("tid", this.agC.getTid()).t("fid", this.agC.getFid()).cI("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }
}
