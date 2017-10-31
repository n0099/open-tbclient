package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.view.l;
/* loaded from: classes.dex */
public class d {
    public TextView faX;
    public TextView faY;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(d.g.view_video_title);
            this.faX = (TextView) this.mRootView.findViewById(d.g.pb_video_replay_num);
            this.faY = (TextView) this.mRootView.findViewById(d.g.pb_video_play_count);
        }
    }

    public void X(bh bhVar) {
        if (bhVar != null && bhVar.rL() != null) {
            bhVar.se();
            this.mTitleView.setOnTouchListener(new l(bhVar.rU()));
            this.mTitleView.setText(bhVar.rU());
            this.mTitleView.setLinkTextColor(aj.getColor(d.C0080d.cp_link_tip_c));
            this.faX.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.pb_video_header_replay_num), am.w(bhVar.rl())));
            this.faY.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.pb_video_header_play_count), am.w(bhVar.rL().play_count.intValue())));
            AB();
        }
    }

    public void AB() {
        aj.c(this.mTitleView, d.C0080d.cp_cont_b, 1);
        aj.c(this.faX, d.C0080d.cp_cont_f, 1);
        aj.c(this.faY, d.C0080d.cp_cont_f, 1);
    }
}
