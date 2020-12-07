package com.baidu.tieba.pb.videopb.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class a extends af.a implements View.OnClickListener {
    private by alu;
    CardForumHeadLayout lRV;

    public a(View view) {
        super(view);
        this.lRV = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        if (this.lRV != null) {
            this.lRV.setOnClickListener(this.lRV);
            this.lRV.setAfterClickListener(this);
        }
    }

    public void setData(by byVar) {
        this.alu = byVar;
        this.lRV.setData(byVar);
    }

    public void bvt() {
        this.lRV.onChangeSkinType();
        ap.d(this.lRV, l.getDimens(this.itemView.getContext(), R.dimen.tbds10), R.color.CAM_X0206, R.color.CAM_X0206);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.alu != null) {
            TiebaStatic.log(new ar("c13399").dY("tid", this.alu.getTid()).w("fid", this.alu.getFid()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("nid", this.alu.getNid()));
        }
    }
}
