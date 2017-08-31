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
    public View ddy;
    public ImageView eOc;
    public TextView eOd;
    public TextView eOe;
    public View mRootView;

    public ak(View view) {
        super(view);
        if (view != null) {
            this.mRootView = view.findViewById(d.h.thread_praise_root);
            this.eOc = (ImageView) view.findViewById(d.h.view_main_thread_praise_state);
            this.eOd = (TextView) view.findViewById(d.h.view_main_thread_praise_num);
            this.eOe = (TextView) view.findViewById(d.h.view_main_thread_praise_name_list);
            this.ddy = view.findViewById(d.h.bottom_divider_line);
        }
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        if (lVar != null) {
            if (lVar.aPA()) {
                if (lVar.eEP == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.eOc, d.g.icon_floor_big_praised);
                } else if (lVar.eEP == 3) {
                    com.baidu.tbadk.core.util.aj.c(this.eOc, d.g.icon_floor_trample);
                } else if (lVar.eEP == 4) {
                    com.baidu.tbadk.core.util.aj.c(this.eOc, d.g.icon_floor_big_trample);
                } else {
                    com.baidu.tbadk.core.util.aj.c(this.eOc, d.g.icon_floor_bigpraised);
                }
            } else {
                com.baidu.tbadk.core.util.aj.c(this.eOc, d.g.icon_floor_bigpraise_n);
            }
            com.baidu.tbadk.core.util.aj.i(this.eOd, d.e.cp_link_tip_c);
            com.baidu.tbadk.core.util.aj.i(this.eOe, d.e.cp_link_tip_c);
            this.eOc.setTag(d.h.pb_main_thread_praise_data, lVar);
            if (lVar.aPD()) {
                com.baidu.tbadk.core.util.aj.k(this.ddy, d.e.cp_bg_line_c);
                this.ddy.setVisibility(0);
            } else {
                this.ddy.setVisibility(8);
            }
            if (lVar.getPraiseNum() <= 0 || com.baidu.tbadk.core.util.v.v(lVar.aPB())) {
                this.eOd.setText(d.l.no_praise_tip);
                com.baidu.tbadk.core.util.aj.i(this.eOd, d.e.cp_cont_f);
                this.eOe.setVisibility(8);
                this.eOe.setTag(false);
                this.eOd.setTag(false);
                return;
            }
            this.eOe.setTag(true);
            this.eOd.setTag(true);
            this.eOe.setVisibility(0);
            this.eOe.setText(Html.fromHtml(lVar.h(this.eOe), new Html.ImageGetter() { // from class: com.baidu.tieba.pb.pb.main.ak.1
                @Override // android.text.Html.ImageGetter
                public Drawable getDrawable(String str) {
                    int parseInt = Integer.parseInt(str);
                    Drawable drawable = TbadkCoreApplication.getInst().getResources().getDrawable(d.g.praise_01);
                    try {
                        drawable = TbadkCoreApplication.getInst().getResources().getDrawable(parseInt);
                    } catch (Exception e) {
                    }
                    drawable.setBounds(0, 0, com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds36), com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst(), d.f.ds36));
                    return drawable;
                }
            }, null));
            this.eOd.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.count_main_thread_praise), com.baidu.tbadk.core.util.am.v(lVar.getPraiseNum())));
        }
    }
}
