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
/* loaded from: classes21.dex */
public class a extends af.a implements View.OnClickListener {
    private bw ajX;
    CardForumHeadLayout kVZ;

    public a(View view) {
        super(view);
        this.kVZ = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        if (this.kVZ != null) {
            this.kVZ.setOnClickListener(this.kVZ);
            this.kVZ.setAfterClickListener(this);
        }
    }

    public void setData(bw bwVar) {
        this.ajX = bwVar;
        this.kVZ.setData(bwVar);
    }

    public void blA() {
        this.kVZ.onChangeSkinType();
        ap.c(this.kVZ, l.getDimens(this.itemView.getContext(), R.dimen.tbds10), R.color.cp_bg_line_g, R.color.cp_bg_line_g);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ajX != null) {
            TiebaStatic.log(new aq("c13399").dF("tid", this.ajX.getTid()).u("fid", this.ajX.getFid()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("nid", this.ajX.getNid()));
        }
    }
}
