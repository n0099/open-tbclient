package com.baidu.tieba.pb.videopb.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a extends ad.a implements View.OnClickListener {
    private bu aiq;
    CardForumHeadLayout koN;

    public a(View view) {
        super(view);
        this.koN = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        if (this.koN != null) {
            this.koN.setOnClickListener(this.koN);
            this.koN.setAfterClickListener(this);
        }
    }

    public void setData(bu buVar) {
        this.aiq = buVar;
        this.koN.setData(buVar);
    }

    public void aYj() {
        this.koN.onChangeSkinType();
        an.c(this.koN, l.getDimens(this.itemView.getContext(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aiq != null) {
            TiebaStatic.log(new ao("c13399").dk("tid", this.aiq.getTid()).s("fid", this.aiq.getFid()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("nid", this.aiq.getNid()));
        }
    }
}
