package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d {
    public TextView aaS;
    public TextView eSr;
    public TextView eSs;
    public View mRootView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.aaS = (TextView) this.mRootView.findViewById(d.h.view_video_title);
            this.eSr = (TextView) this.mRootView.findViewById(d.h.pb_video_replay_num);
            this.eSs = (TextView) this.mRootView.findViewById(d.h.pb_video_play_count);
        }
    }

    public void X(bh bhVar) {
        if (bhVar != null && bhVar.rF() != null) {
            this.aaS.setText(bhVar.getTitle());
            this.eSr.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.pb_video_header_replay_num), am.w(bhVar.rg())));
            this.eSs.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.pb_video_header_play_count), am.w(bhVar.rF().play_count.intValue())));
            As();
        }
    }

    public void As() {
        aj.c(this.aaS, d.e.cp_cont_b, 1);
        aj.c(this.eSr, d.e.cp_cont_f, 1);
        aj.c(this.eSs, d.e.cp_cont_f, 1);
    }
}
