package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    public TextView aaF;
    public RelativeLayout euB;
    public TextView euC;
    public TextView euD;
    public TextView euE;
    public TextView euF;
    public View mRootView;

    public a(View view) {
        if (view != null) {
            this.mRootView = view;
            this.aaF = (TextView) this.mRootView.findViewById(w.h.view_video_title);
            this.euB = (RelativeLayout) this.mRootView.findViewById(w.h.pb_header_video_location_container);
            this.euC = (TextView) this.mRootView.findViewById(w.h.pb_video_floor_name);
            this.euD = (TextView) this.mRootView.findViewById(w.h.pb_video_floor_reply_time);
            this.euE = (TextView) this.mRootView.findViewById(w.h.pb_video_floor_location_address);
            this.euF = (TextView) this.mRootView.findViewById(w.h.pb_video_play_count);
        }
    }

    public void F(bi biVar) {
        if (biVar != null && biVar.sF() != null) {
            this.euD.setText(au.q(biVar.getCreateTime()));
            this.euE.setText(biVar.getAddress());
            this.euF.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.count_video_play), au.t(biVar.sF().play_count.intValue())));
            this.aaF.setText(biVar.getTitle());
            Bn();
        }
    }

    public void Bn() {
        aq.c(this.aaF, w.e.cp_cont_b, 1);
        aq.c(this.euC, w.e.cp_cont_c, 1);
        aq.c(this.euD, w.e.cp_cont_c, 1);
        aq.c(this.euE, w.e.cp_cont_c, 1);
        aq.c(this.euF, w.e.cp_cont_c, 1);
    }
}
