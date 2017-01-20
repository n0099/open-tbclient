package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a {
    public TextView Ve;
    public RelativeLayout etj;
    public TextView etk;
    public TextView etl;
    public TextView etm;
    public TextView etn;
    public View mRootView;

    public a(View view) {
        if (view != null) {
            this.mRootView = view;
            this.Ve = (TextView) this.mRootView.findViewById(r.h.view_video_title);
            this.etj = (RelativeLayout) this.mRootView.findViewById(r.h.pb_header_video_location_container);
            this.etk = (TextView) this.mRootView.findViewById(r.h.pb_video_floor_name);
            this.etl = (TextView) this.mRootView.findViewById(r.h.pb_video_floor_reply_time);
            this.etm = (TextView) this.mRootView.findViewById(r.h.pb_video_floor_location_address);
            this.etn = (TextView) this.mRootView.findViewById(r.h.pb_video_play_count);
        }
    }

    public void H(bh bhVar) {
        if (bhVar != null && bhVar.rN() != null) {
            this.etl.setText(at.r(bhVar.getCreateTime()));
            this.etm.setText(bhVar.getAddress());
            this.etn.setText(String.format(TbadkCoreApplication.m9getInst().getString(r.l.count_video_play), at.u(bhVar.rN().play_count.intValue())));
            this.Ve.setText(bhVar.getTitle());
            lJ();
        }
    }

    public void lJ() {
        ap.c(this.Ve, r.e.cp_cont_b, 1);
        ap.c(this.etk, r.e.cp_cont_c, 1);
        ap.c(this.etl, r.e.cp_cont_c, 1);
        ap.c(this.etm, r.e.cp_cont_c, 1);
        ap.c(this.etn, r.e.cp_cont_c, 1);
    }
}
