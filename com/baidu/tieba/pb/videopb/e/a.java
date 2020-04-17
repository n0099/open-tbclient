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
    private bj agz;
    CardForumHeadLayout jMZ;

    public a(View view) {
        super(view);
        this.jMZ = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        if (this.jMZ != null) {
            this.jMZ.setOnClickListener(this.jMZ);
            this.jMZ.setAfterClickListener(this);
        }
    }

    public void setData(bj bjVar) {
        this.agz = bjVar;
        this.jMZ.setData(bjVar);
    }

    public void aQp() {
        this.jMZ.onChangeSkinType();
        am.c(this.jMZ, l.getDimens(this.itemView.getContext(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.agz != null) {
            TiebaStatic.log(new an("c13399").cI("tid", this.agz.getTid()).t("fid", this.agz.getFid()).cI("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }
}
