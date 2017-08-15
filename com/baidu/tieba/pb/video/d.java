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
    public TextView abZ;
    public TextView eYQ;
    public TextView eYR;
    public View mRootView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.abZ = (TextView) this.mRootView.findViewById(d.h.view_video_title);
            this.eYQ = (TextView) this.mRootView.findViewById(d.h.pb_video_replay_num);
            this.eYR = (TextView) this.mRootView.findViewById(d.h.pb_video_play_count);
        }
    }

    public void W(bl blVar) {
        if (blVar != null && blVar.rW() != null) {
            this.abZ.setText(blVar.getTitle());
            this.eYQ.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.pb_video_header_replay_num), al.x(blVar.rx())));
            this.eYR.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.pb_video_header_play_count), al.x(blVar.rW().play_count.intValue())));
            Bf();
        }
    }

    public void Bf() {
        ai.c(this.abZ, d.e.cp_cont_b, 1);
        ai.c(this.eYQ, d.e.cp_cont_f, 1);
        ai.c(this.eYR, d.e.cp_cont_f, 1);
    }
}
