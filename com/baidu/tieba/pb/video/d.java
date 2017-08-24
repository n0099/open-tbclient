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
    public TextView eYS;
    public TextView eYT;
    public View mRootView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.abZ = (TextView) this.mRootView.findViewById(d.h.view_video_title);
            this.eYS = (TextView) this.mRootView.findViewById(d.h.pb_video_replay_num);
            this.eYT = (TextView) this.mRootView.findViewById(d.h.pb_video_play_count);
        }
    }

    public void W(bl blVar) {
        if (blVar != null && blVar.rX() != null) {
            this.abZ.setText(blVar.getTitle());
            this.eYS.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.pb_video_header_replay_num), al.x(blVar.ry())));
            this.eYT.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.pb_video_header_play_count), al.x(blVar.rX().play_count.intValue())));
            Bf();
        }
    }

    public void Bf() {
        ai.c(this.abZ, d.e.cp_cont_b, 1);
        ai.c(this.eYS, d.e.cp_cont_f, 1);
        ai.c(this.eYT, d.e.cp_cont_f, 1);
    }
}
