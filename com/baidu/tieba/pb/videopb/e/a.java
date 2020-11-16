package com.baidu.tieba.pb.videopb.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class a extends af.a implements View.OnClickListener {
    private bx akt;
    CardForumHeadLayout lEe;

    public a(View view) {
        super(view);
        this.lEe = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        if (this.lEe != null) {
            this.lEe.setOnClickListener(this.lEe);
            this.lEe.setAfterClickListener(this);
        }
    }

    public void setData(bx bxVar) {
        this.akt = bxVar;
        this.lEe.setData(bxVar);
    }

    public void brT() {
        this.lEe.onChangeSkinType();
        ap.c(this.lEe, l.getDimens(this.itemView.getContext(), R.dimen.tbds10), R.color.CAM_X0206, R.color.CAM_X0206);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.akt != null) {
            TiebaStatic.log(new ar("c13399").dR("tid", this.akt.getTid()).w("fid", this.akt.getFid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("nid", this.akt.getNid()));
        }
    }
}
