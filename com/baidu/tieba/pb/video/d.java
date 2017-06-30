package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d {
    public TextView aab;
    public TextView eJl;
    public TextView eJm;
    public View mRootView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.aab = (TextView) this.mRootView.findViewById(w.h.view_video_title);
            this.eJl = (TextView) this.mRootView.findViewById(w.h.pb_video_replay_num);
            this.eJm = (TextView) this.mRootView.findViewById(w.h.pb_video_play_count);
        }
    }

    public void Q(bm bmVar) {
        if (bmVar != null && bmVar.rI() != null) {
            this.aab.setText(bmVar.getTitle());
            this.eJl.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.pb_video_header_replay_num), aw.w(bmVar.rj())));
            this.eJm.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.pb_video_header_play_count), aw.w(bmVar.rI().play_count.intValue())));
            AM();
        }
    }

    public void AM() {
        as.c(this.aab, w.e.cp_cont_b, 1);
        as.c(this.eJl, w.e.cp_cont_f, 1);
        as.c(this.eJm, w.e.cp_cont_f, 1);
    }
}
