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
    private bz ale;
    CardForumHeadLayout lSE;

    public VideoPbEnterForumViewHolder(View view) {
        super(view);
        this.lSE = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        if (this.lSE != null) {
            this.lSE.setOnClickListener(this.lSE);
            this.lSE.setAfterClickListener(this);
        }
    }

    public void setData(bz bzVar) {
        this.ale = bzVar;
        this.lSE.setData(bzVar);
    }

    public void btV() {
        this.lSE.onChangeSkinType();
        ao.d(this.lSE, l.getDimens(this.itemView.getContext(), R.dimen.tbds10), R.color.CAM_X0206, R.color.CAM_X0206);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ale != null) {
            TiebaStatic.log(new aq("c13399").dW("tid", this.ale.getTid()).w("fid", this.ale.getFid()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW(IntentConfig.NID, this.ale.blV()));
        }
    }
}
