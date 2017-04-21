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
    public TextView aaG;
    public RelativeLayout ewR;
    public TextView ewS;
    public TextView ewT;
    public TextView ewU;
    public TextView ewV;
    public View mRootView;

    public a(View view) {
        if (view != null) {
            this.mRootView = view;
            this.aaG = (TextView) this.mRootView.findViewById(w.h.view_video_title);
            this.ewR = (RelativeLayout) this.mRootView.findViewById(w.h.pb_header_video_location_container);
            this.ewS = (TextView) this.mRootView.findViewById(w.h.pb_video_floor_name);
            this.ewT = (TextView) this.mRootView.findViewById(w.h.pb_video_floor_reply_time);
            this.ewU = (TextView) this.mRootView.findViewById(w.h.pb_video_floor_location_address);
            this.ewV = (TextView) this.mRootView.findViewById(w.h.pb_video_play_count);
        }
    }

    public void F(bi biVar) {
        if (biVar != null && biVar.sF() != null) {
            this.ewT.setText(au.q(biVar.getCreateTime()));
            this.ewU.setText(biVar.getAddress());
            this.ewV.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.count_video_play), au.t(biVar.sF().play_count.intValue())));
            this.aaG.setText(biVar.getTitle());
            Bn();
        }
    }

    public void Bn() {
        aq.c(this.aaG, w.e.cp_cont_b, 1);
        aq.c(this.ewS, w.e.cp_cont_c, 1);
        aq.c(this.ewT, w.e.cp_cont_c, 1);
        aq.c(this.ewU, w.e.cp_cont_c, 1);
        aq.c(this.ewV, w.e.cp_cont_c, 1);
    }
}
