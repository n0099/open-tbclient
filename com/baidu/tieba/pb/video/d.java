package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class d {
    public TextView aab;
    public RelativeLayout esB;
    public TextView esC;
    public TextView esD;
    public TextView esE;
    public TextView esF;
    public View mRootView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.aab = (TextView) this.mRootView.findViewById(w.h.view_video_title);
            this.esB = (RelativeLayout) this.mRootView.findViewById(w.h.pb_header_video_location_container);
            this.esC = (TextView) this.mRootView.findViewById(w.h.pb_video_floor_name);
            this.esD = (TextView) this.mRootView.findViewById(w.h.pb_video_floor_reply_time);
            this.esE = (TextView) this.mRootView.findViewById(w.h.pb_video_floor_location_address);
            this.esF = (TextView) this.mRootView.findViewById(w.h.pb_video_play_count);
        }
    }

    public void J(bk bkVar) {
        if (bkVar != null && bkVar.rP() != null) {
            this.esD.setText(au.q(bkVar.getCreateTime()));
            this.esE.setText(bkVar.getAddress());
            this.esF.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.count_video_play), au.t(bkVar.rP().play_count.intValue())));
            this.aab.setText(bkVar.getTitle());
            Ay();
        }
    }

    public void Ay() {
        aq.c(this.aab, w.e.cp_cont_b, 1);
        aq.c(this.esC, w.e.cp_cont_c, 1);
        aq.c(this.esD, w.e.cp_cont_c, 1);
        aq.c(this.esE, w.e.cp_cont_c, 1);
        aq.c(this.esF, w.e.cp_cont_c, 1);
    }
}
