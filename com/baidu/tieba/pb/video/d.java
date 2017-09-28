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
    public TextView abf;
    public TextView eSF;
    public TextView eSG;
    public View mRootView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.abf = (TextView) this.mRootView.findViewById(d.h.view_video_title);
            this.eSF = (TextView) this.mRootView.findViewById(d.h.pb_video_replay_num);
            this.eSG = (TextView) this.mRootView.findViewById(d.h.pb_video_play_count);
        }
    }

    public void X(bh bhVar) {
        if (bhVar != null && bhVar.rM() != null) {
            this.abf.setText(bhVar.getTitle());
            this.eSF.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.pb_video_header_replay_num), am.v(bhVar.rn())));
            this.eSG.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.pb_video_header_play_count), am.v(bhVar.rM().play_count.intValue())));
            Ay();
        }
    }

    public void Ay() {
        aj.c(this.abf, d.e.cp_cont_b, 1);
        aj.c(this.eSF, d.e.cp_cont_f, 1);
        aj.c(this.eSG, d.e.cp_cont_f, 1);
    }
}
