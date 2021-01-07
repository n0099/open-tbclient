package com.baidu.tieba.pb.videopb.viewholder;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class VideoPbEnterForumViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
    private bz alW;
    CardForumHeadLayout lXi;

    public VideoPbEnterForumViewHolder(View view) {
        super(view);
        this.lXi = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        if (this.lXi != null) {
            this.lXi.setOnClickListener(this.lXi);
            this.lXi.setAfterClickListener(this);
        }
    }

    public void setData(bz bzVar) {
        this.alW = bzVar;
        this.lXi.setData(bzVar);
    }

    public void bxP() {
        this.lXi.onChangeSkinType();
        ao.d(this.lXi, l.getDimens(this.itemView.getContext(), R.dimen.tbds10), R.color.CAM_X0206, R.color.CAM_X0206);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.alW != null) {
            TiebaStatic.log(new aq("c13399").dX("tid", this.alW.getTid()).w("fid", this.alW.getFid()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX(IntentConfig.NID, this.alW.bpP()));
        }
    }
}
