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
    CardForumHeadLayout lRX;

    public a(View view) {
        super(view);
        this.lRX = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        if (this.lRX != null) {
            this.lRX.setOnClickListener(this.lRX);
            this.lRX.setAfterClickListener(this);
        }
    }

    public void setData(by byVar) {
        this.alu = byVar;
        this.lRX.setData(byVar);
    }

    public void bvt() {
        this.lRX.onChangeSkinType();
        ap.d(this.lRX, l.getDimens(this.itemView.getContext(), R.dimen.tbds10), R.color.CAM_X0206, R.color.CAM_X0206);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.alu != null) {
            TiebaStatic.log(new ar("c13399").dY("tid", this.alu.getTid()).w("fid", this.alu.getFid()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("nid", this.alu.getNid()));
        }
    }
}
