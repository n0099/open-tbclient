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
    private cb amn;
    CardForumHeadLayout mdU;

    public VideoPbEnterForumViewHolder(View view) {
        super(view);
        this.mdU = (CardForumHeadLayout) ((ViewGroup) view).getChildAt(0);
        if (this.mdU != null) {
            this.mdU.setOnClickListener(this.mdU);
            this.mdU.setAfterClickListener(this);
        }
    }

    public void setData(cb cbVar) {
        this.amn = cbVar;
        this.mdU.setData(cbVar);
    }

    public void bus() {
        this.mdU.onChangeSkinType();
        ap.d(this.mdU, l.getDimens(this.itemView.getContext(), R.dimen.tbds10), R.color.CAM_X0206, R.color.CAM_X0206);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.amn != null) {
            TiebaStatic.log(new ar("c13399").dR("tid", this.amn.getTid()).v("fid", this.amn.getFid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR(IntentConfig.NID, this.amn.bmq()));
        }
    }
}
