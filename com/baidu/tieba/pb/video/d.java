package com.baidu.tieba.pb.video;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.view.l;
/* loaded from: classes.dex */
public class d {
    public TextView fim;
    public TextView fin;
    public View mRootView;
    public TextView mTitleView;

    public d(View view) {
        if (view != null) {
            this.mRootView = view;
            this.mTitleView = (TextView) this.mRootView.findViewById(d.g.view_video_title);
            this.fim = (TextView) this.mRootView.findViewById(d.g.pb_video_replay_num);
            this.fin = (TextView) this.mRootView.findViewById(d.g.pb_video_play_count);
        }
    }

    public void Y(bd bdVar) {
        if (bdVar != null && bdVar.rP() != null) {
            bdVar.sh();
            this.mTitleView.setOnTouchListener(new l(bdVar.rX()));
            this.mTitleView.setText(bdVar.rX());
            this.mTitleView.setLinkTextColor(aj.getColor(d.C0082d.cp_link_tip_c));
            this.fim.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.pb_video_header_replay_num), am.w(bdVar.rp())));
            this.fin.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.pb_video_header_play_count), am.w(bdVar.rP().play_count.intValue())));
            AX();
        }
    }

    public void AX() {
        aj.c(this.mTitleView, d.C0082d.cp_cont_b, 1);
        aj.c(this.fim, d.C0082d.cp_cont_f, 1);
        aj.c(this.fin, d.C0082d.cp_cont_f, 1);
    }
}
