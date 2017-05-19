package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class fj extends y.a {
    public View cwH;
    public ImageView emA;
    public TextView emB;
    public TextView emC;

    public fj(View view) {
        super(view);
        if (view != null) {
            this.emA = (ImageView) view.findViewById(w.h.view_main_thread_praise_state);
            this.emB = (TextView) view.findViewById(w.h.view_main_thread_praise_num);
            this.emC = (TextView) view.findViewById(w.h.view_main_thread_praise_name_list);
            this.cwH = view.findViewById(w.h.bottom_divider_line);
        }
    }

    public void b(com.baidu.tieba.pb.data.k kVar) {
        if (kVar != null) {
            if (kVar.aIl()) {
                com.baidu.tbadk.core.util.aq.c(this.emA, w.g.icon_floor_bigpraised);
            } else {
                com.baidu.tbadk.core.util.aq.c(this.emA, w.g.icon_floor_bigpraise_selector);
            }
            com.baidu.tbadk.core.util.aq.i(this.emB, w.e.main_thread_praise_list_color);
            com.baidu.tbadk.core.util.aq.i(this.emC, w.e.main_thread_praise_list_color);
            this.emA.setTag(w.h.pb_main_thread_praise_data, kVar);
            if (kVar.aIp()) {
                com.baidu.tbadk.core.util.aq.k(this.cwH, w.e.cp_bg_line_c);
                this.cwH.setVisibility(0);
            } else {
                this.cwH.setVisibility(8);
            }
            if (kVar.getPraiseNum() <= 0 || com.baidu.tbadk.core.util.x.r(kVar.aIm())) {
                this.emB.setText(w.l.no_praise_tip);
                this.emC.setVisibility(8);
                this.emC.setTag(false);
                this.emB.setTag(false);
                return;
            }
            this.emC.setTag(true);
            this.emB.setTag(true);
            this.emC.setVisibility(0);
            StringBuilder sb = new StringBuilder();
            sb.append(kVar.aIk());
            sb.append(TbadkCoreApplication.m9getInst().getString(w.l.etc));
            this.emC.setText(sb);
            this.emB.setText(String.format(TbadkCoreApplication.m9getInst().getString(w.l.count_main_thread_praise), com.baidu.tbadk.core.util.au.u(kVar.getPraiseNum())));
        }
    }
}
