package com.baidu.tieba.pb.pb.main;

import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class gc extends z.a {
    public View cKW;
    public ImageView eBB;
    public TextView eBC;
    public TextView eBD;
    public View mRootView;

    public gc(View view) {
        super(view);
        if (view != null) {
            this.mRootView = view.findViewById(w.h.thread_praise_root);
            this.eBB = (ImageView) view.findViewById(w.h.view_main_thread_praise_state);
            this.eBC = (TextView) view.findViewById(w.h.view_main_thread_praise_num);
            this.eBD = (TextView) view.findViewById(w.h.view_main_thread_praise_name_list);
            this.cKW = view.findViewById(w.h.bottom_divider_line);
        }
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        if (mVar != null) {
            if (mVar.aMY()) {
                if (mVar.ese == 1) {
                    com.baidu.tbadk.core.util.as.c(this.eBB, w.g.icon_floor_big_praised);
                } else if (mVar.ese == 3) {
                    com.baidu.tbadk.core.util.as.c(this.eBB, w.g.icon_floor_trample);
                } else if (mVar.ese == 4) {
                    com.baidu.tbadk.core.util.as.c(this.eBB, w.g.icon_floor_big_trample);
                } else {
                    com.baidu.tbadk.core.util.as.c(this.eBB, w.g.icon_floor_bigpraised);
                }
            } else {
                com.baidu.tbadk.core.util.as.c(this.eBB, w.g.icon_floor_bigpraise_n);
            }
            com.baidu.tbadk.core.util.as.i(this.eBC, w.e.main_thread_praise_list_color);
            com.baidu.tbadk.core.util.as.i(this.eBD, w.e.main_thread_praise_list_color);
            this.eBB.setTag(w.h.pb_main_thread_praise_data, mVar);
            if (mVar.aNb()) {
                com.baidu.tbadk.core.util.as.k(this.cKW, w.e.cp_bg_line_c);
                this.cKW.setVisibility(0);
            } else {
                this.cKW.setVisibility(8);
            }
            if (mVar.getPraiseNum() <= 0 || com.baidu.tbadk.core.util.z.t(mVar.aMZ())) {
                this.eBC.setText(w.l.no_praise_tip);
                com.baidu.tbadk.core.util.as.i(this.eBC, w.e.cp_cont_f);
                this.eBD.setVisibility(8);
                this.eBD.setTag(false);
                this.eBC.setTag(false);
                return;
            }
            this.eBD.setTag(true);
            this.eBC.setTag(true);
            this.eBD.setVisibility(0);
            this.eBD.setText(Html.fromHtml(mVar.g(this.eBD), new gd(this), null));
            this.eBC.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.count_main_thread_praise), com.baidu.tbadk.core.util.aw.u(mVar.getPraiseNum())));
        }
    }
}
