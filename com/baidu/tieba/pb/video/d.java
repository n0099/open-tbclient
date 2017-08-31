package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d {
    public TextView abe;
    public TextView eXC;
    public TextView eXD;
    public View mRootView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.abe = (TextView) this.mRootView.findViewById(d.h.view_video_title);
            this.eXC = (TextView) this.mRootView.findViewById(d.h.pb_video_replay_num);
            this.eXD = (TextView) this.mRootView.findViewById(d.h.pb_video_play_count);
        }
    }

    public void ac(bj bjVar) {
        if (bjVar != null && bjVar.rS() != null) {
            this.abe.setText(bjVar.getTitle());
            this.eXC.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.pb_video_header_replay_num), am.w(bjVar.rt())));
            this.eXD.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.pb_video_header_play_count), am.w(bjVar.rS().play_count.intValue())));
            Ba();
        }
    }

    public void Ba() {
        aj.c(this.abe, d.e.cp_cont_b, 1);
        aj.c(this.eXC, d.e.cp_cont_f, 1);
        aj.c(this.eXD, d.e.cp_cont_f, 1);
    }
}
