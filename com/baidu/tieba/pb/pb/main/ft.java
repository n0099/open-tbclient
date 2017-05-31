package com.baidu.tieba.pb.pb.main;

import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ft extends z.a {
    public View cCZ;
    public ImageView esq;
    public TextView esr;
    public TextView ess;

    public ft(View view) {
        super(view);
        if (view != null) {
            this.esq = (ImageView) view.findViewById(w.h.view_main_thread_praise_state);
            this.esr = (TextView) view.findViewById(w.h.view_main_thread_praise_num);
            this.ess = (TextView) view.findViewById(w.h.view_main_thread_praise_name_list);
            this.cCZ = view.findViewById(w.h.bottom_divider_line);
        }
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        if (mVar != null) {
            if (mVar.aJe()) {
                if (mVar.ejg == 1) {
                    com.baidu.tbadk.core.util.aq.c(this.esq, w.g.icon_floor_big_praised);
                } else if (mVar.ejg == 3) {
                    com.baidu.tbadk.core.util.aq.c(this.esq, w.g.icon_floor_trample);
                } else if (mVar.ejg == 4) {
                    com.baidu.tbadk.core.util.aq.c(this.esq, w.g.icon_floor_big_trample);
                } else {
                    com.baidu.tbadk.core.util.aq.c(this.esq, w.g.icon_floor_bigpraised);
                }
            } else {
                com.baidu.tbadk.core.util.aq.c(this.esq, w.g.icon_floor_bigpraise_n);
            }
            com.baidu.tbadk.core.util.aq.i(this.esr, w.e.main_thread_praise_list_color);
            com.baidu.tbadk.core.util.aq.i(this.ess, w.e.main_thread_praise_list_color);
            this.esq.setTag(w.h.pb_main_thread_praise_data, mVar);
            if (mVar.aJh()) {
                com.baidu.tbadk.core.util.aq.k(this.cCZ, w.e.cp_bg_line_c);
                this.cCZ.setVisibility(0);
            } else {
                this.cCZ.setVisibility(8);
            }
            if (mVar.getPraiseNum() <= 0 || com.baidu.tbadk.core.util.x.r(mVar.aJf())) {
                this.esr.setText(w.l.no_praise_tip);
                com.baidu.tbadk.core.util.aq.i(this.esr, w.e.cp_cont_f);
                this.ess.setVisibility(8);
                this.ess.setTag(false);
                this.esr.setTag(false);
                return;
            }
            this.ess.setTag(true);
            this.esr.setTag(true);
            this.ess.setVisibility(0);
            this.ess.setText(Html.fromHtml(mVar.g(this.ess), new fu(this), null));
            this.esr.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.count_main_thread_praise), com.baidu.tbadk.core.util.au.u(mVar.getPraiseNum())));
        }
    }
}
