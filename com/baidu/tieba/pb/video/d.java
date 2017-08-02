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
    public TextView aaA;
    public TextView eVL;
    public TextView eVM;
    public View mRootView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.aaA = (TextView) this.mRootView.findViewById(d.h.view_video_title);
            this.eVL = (TextView) this.mRootView.findViewById(d.h.pb_video_replay_num);
            this.eVM = (TextView) this.mRootView.findViewById(d.h.pb_video_play_count);
        }
    }

    public void W(bl blVar) {
        if (blVar != null && blVar.rM() != null) {
            this.aaA.setText(blVar.getTitle());
            this.eVL.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.pb_video_header_replay_num), al.x(blVar.rn())));
            this.eVM.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.pb_video_header_play_count), al.x(blVar.rM().play_count.intValue())));
            AX();
        }
    }

    public void AX() {
        ai.c(this.aaA, d.e.cp_cont_b, 1);
        ai.c(this.eVL, d.e.cp_cont_f, 1);
        ai.c(this.eVM, d.e.cp_cont_f, 1);
    }
}
