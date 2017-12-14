package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.view.l;
/* loaded from: classes.dex */
public class d {
    public TextView fjl;
    public TextView fjm;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(d.g.view_video_title);
            this.fjl = (TextView) this.mRootView.findViewById(d.g.pb_video_replay_num);
            this.fjm = (TextView) this.mRootView.findViewById(d.g.pb_video_play_count);
        }
    }

    public void aa(bd bdVar) {
        if (bdVar != null && bdVar.rN() != null) {
            bdVar.sf();
            this.mTitleView.setOnTouchListener(new l(bdVar.rV()));
            this.mTitleView.setText(bdVar.rV());
            this.mTitleView.setLinkTextColor(aj.getColor(d.C0096d.cp_link_tip_c));
            this.fjl.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.pb_video_header_replay_num), am.w(bdVar.rn())));
            this.fjm.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.pb_video_header_play_count), am.w(bdVar.rN().play_count.intValue())));
            AY();
        }
    }

    public void AY() {
        aj.c(this.mTitleView, d.C0096d.cp_cont_b, 1);
        aj.c(this.fjl, d.C0096d.cp_cont_f, 1);
        aj.c(this.fjm, d.C0096d.cp_cont_f, 1);
    }
}
