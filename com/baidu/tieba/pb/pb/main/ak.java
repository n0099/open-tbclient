package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ak extends j.a {
    public View dau;
    public ImageView eIA;
    public TextView eIB;
    public TextView eIC;
    public View mRootView;

    public ak(View view) {
        super(view);
        if (view != null) {
            this.mRootView = view.findViewById(d.h.thread_praise_root);
            this.eIA = (ImageView) view.findViewById(d.h.view_main_thread_praise_state);
            this.eIB = (TextView) view.findViewById(d.h.view_main_thread_praise_num);
            this.eIC = (TextView) view.findViewById(d.h.view_main_thread_praise_name_list);
            this.dau = view.findViewById(d.h.bottom_divider_line);
        }
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        if (lVar != null) {
            if (lVar.aNA()) {
                if (lVar.eyR == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.eIA, d.g.icon_floor_big_praised);
                } else if (lVar.eyR == 3) {
                    com.baidu.tbadk.core.util.aj.c(this.eIA, d.g.icon_floor_trample);
                } else if (lVar.eyR == 4) {
                    com.baidu.tbadk.core.util.aj.c(this.eIA, d.g.icon_floor_big_trample);
                } else {
                    com.baidu.tbadk.core.util.aj.c(this.eIA, d.g.icon_floor_bigpraised);
                }
            } else {
                com.baidu.tbadk.core.util.aj.c(this.eIA, d.g.icon_floor_bigpraise_n);
            }
            com.baidu.tbadk.core.util.aj.i(this.eIB, d.e.cp_link_tip_c);
            com.baidu.tbadk.core.util.aj.i(this.eIC, d.e.cp_link_tip_c);
            this.eIA.setTag(d.h.pb_main_thread_praise_data, lVar);
            if (lVar.aND()) {
                com.baidu.tbadk.core.util.aj.k(this.dau, d.e.cp_bg_line_c);
                this.dau.setVisibility(0);
            } else {
                this.dau.setVisibility(8);
            }
            if (lVar.getPraiseNum() <= 0 || com.baidu.tbadk.core.util.v.u(lVar.aNB())) {
                this.eIB.setText(d.l.no_praise_tip);
                com.baidu.tbadk.core.util.aj.i(this.eIB, d.e.cp_cont_f);
                this.eIC.setVisibility(8);
                this.eIC.setTag(false);
                this.eIB.setTag(false);
                return;
            }
            this.eIC.setTag(true);
            this.eIB.setTag(true);
            this.eIC.setVisibility(0);
            this.eIC.setText(Html.fromHtml(lVar.h(this.eIC), new Html.ImageGetter() { // from class: com.baidu.tieba.pb.pb.main.ak.1
                @Override // android.text.Html.ImageGetter
                public Drawable getDrawable(String str) {
                    int parseInt = Integer.parseInt(str);
                    Drawable drawable = TbadkCoreApplication.getInst().getResources().getDrawable(d.g.praise_01);
                    try {
                        drawable = TbadkCoreApplication.getInst().getResources().getDrawable(parseInt);
                    } catch (Exception e) {
                    }
                    drawable.setBounds(0, 0, com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.f.ds36), com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.f.ds36));
                    return drawable;
                }
            }, null));
            this.eIB.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.count_main_thread_praise), com.baidu.tbadk.core.util.am.v(lVar.getPraiseNum())));
        }
    }
}
