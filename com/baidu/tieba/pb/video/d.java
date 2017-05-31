package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d {
    public TextView aaa;
    public TextView ezN;
    public TextView ezO;
    public View mRootView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.aaa = (TextView) this.mRootView.findViewById(w.h.view_video_title);
            this.ezN = (TextView) this.mRootView.findViewById(w.h.pb_video_replay_num);
            this.ezO = (TextView) this.mRootView.findViewById(w.h.pb_video_play_count);
        }
    }

    public void P(bl blVar) {
        if (blVar != null && blVar.rL() != null) {
            this.aaa.setText(blVar.getTitle());
            this.ezN.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.pb_video_header_replay_num), au.v(blVar.rn())));
            this.ezO.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.pb_video_header_play_count), au.v(blVar.rL().play_count.intValue())));
            Ar();
        }
    }

    public void Ar() {
        aq.c(this.aaa, w.e.cp_cont_b, 1);
        aq.c(this.ezN, w.e.cp_cont_f, 1);
        aq.c(this.ezO, w.e.cp_cont_f, 1);
    }
}
