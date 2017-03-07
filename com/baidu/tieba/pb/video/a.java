package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    public TextView aap;
    public TextView ewA;
    public RelativeLayout eww;
    public TextView ewx;
    public TextView ewy;
    public TextView ewz;
    public View mRootView;

    public a(View view) {
        if (view != null) {
            this.mRootView = view;
            this.aap = (TextView) this.mRootView.findViewById(w.h.view_video_title);
            this.eww = (RelativeLayout) this.mRootView.findViewById(w.h.pb_header_video_location_container);
            this.ewx = (TextView) this.mRootView.findViewById(w.h.pb_video_floor_name);
            this.ewy = (TextView) this.mRootView.findViewById(w.h.pb_video_floor_reply_time);
            this.ewz = (TextView) this.mRootView.findViewById(w.h.pb_video_floor_location_address);
            this.ewA = (TextView) this.mRootView.findViewById(w.h.pb_video_play_count);
        }
    }

    public void I(bj bjVar) {
        if (bjVar != null && bjVar.sh() != null) {
            this.ewy.setText(au.q(bjVar.getCreateTime()));
            this.ewz.setText(bjVar.getAddress());
            this.ewA.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.count_video_play), au.t(bjVar.sh().play_count.intValue())));
            this.aap.setText(bjVar.getTitle());
            AO();
        }
    }

    public void AO() {
        aq.c(this.aap, w.e.cp_cont_b, 1);
        aq.c(this.ewx, w.e.cp_cont_c, 1);
        aq.c(this.ewy, w.e.cp_cont_c, 1);
        aq.c(this.ewz, w.e.cp_cont_c, 1);
        aq.c(this.ewA, w.e.cp_cont_c, 1);
    }
}
