package com.baidu.tieba.pb.videopb.viewholder;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class VideoPbEnterForumViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
    private cb akU;
    CardForumHeadLayout mbD;

    public VideoPbEnterForumViewHolder(View view) {
        super(view);
        this.mbD = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        if (this.mbD != null) {
            this.mbD.setOnClickListener(this.mbD);
            this.mbD.setAfterClickListener(this);
        }
    }

    public void setData(cb cbVar) {
        this.akU = cbVar;
        this.mbD.setData(cbVar);
    }

    public void bup() {
        this.mbD.onChangeSkinType();
        ap.d(this.mbD, l.getDimens(this.itemView.getContext(), R.dimen.tbds10), R.color.CAM_X0206, R.color.CAM_X0206);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.akU != null) {
            TiebaStatic.log(new ar("c13399").dR("tid", this.akU.getTid()).v("fid", this.akU.getFid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR(IntentConfig.NID, this.akU.bmo()));
        }
    }
}
