package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d {
    public TextView abX;
    public TextView eWX;
    public TextView eWY;
    public View mRootView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.abX = (TextView) this.mRootView.findViewById(d.h.view_video_title);
            this.eWX = (TextView) this.mRootView.findViewById(d.h.pb_video_replay_num);
            this.eWY = (TextView) this.mRootView.findViewById(d.h.pb_video_play_count);
        }
    }

    public void W(bl blVar) {
        if (blVar != null && blVar.rW() != null) {
            this.abX.setText(blVar.getTitle());
            this.eWX.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.pb_video_header_replay_num), al.x(blVar.rx())));
            this.eWY.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.pb_video_header_play_count), al.x(blVar.rW().play_count.intValue())));
            Bf();
        }
    }

    public void Bf() {
        ai.c(this.abX, d.e.cp_cont_b, 1);
        ai.c(this.eWX, d.e.cp_cont_f, 1);
        ai.c(this.eWY, d.e.cp_cont_f, 1);
    }
}
