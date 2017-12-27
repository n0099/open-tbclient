package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.view.m;
/* loaded from: classes2.dex */
public class d {
    public TextView fWm;
    public TextView fWn;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(d.g.view_video_title);
            this.fWm = (TextView) this.mRootView.findViewById(d.g.pb_video_replay_num);
            this.fWn = (TextView) this.mRootView.findViewById(d.g.pb_video_play_count);
        }
    }

    public void Z(be beVar) {
        if (beVar != null && beVar.zp() != null) {
            beVar.zH();
            this.mTitleView.setOnTouchListener(new m(beVar.zx()));
            this.mTitleView.setText(beVar.zx());
            this.mTitleView.setLinkTextColor(aj.getColor(d.C0108d.cp_link_tip_c));
            this.fWm.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.pb_video_header_replay_num), am.E(beVar.yP())));
            this.fWn.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.pb_video_header_play_count), am.E(beVar.zp().play_count.intValue())));
            IA();
        }
    }

    public void IA() {
        aj.e(this.mTitleView, d.C0108d.cp_cont_b, 1);
        aj.e(this.fWm, d.C0108d.cp_cont_f, 1);
        aj.e(this.fWn, d.C0108d.cp_cont_f, 1);
    }
}
