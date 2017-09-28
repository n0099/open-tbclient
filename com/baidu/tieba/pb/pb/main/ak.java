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
    public View daI;
    public ImageView eIO;
    public TextView eIP;
    public TextView eIQ;
    public View mRootView;

    public ak(View view) {
        super(view);
        if (view != null) {
            this.mRootView = view.findViewById(d.h.thread_praise_root);
            this.eIO = (ImageView) view.findViewById(d.h.view_main_thread_praise_state);
            this.eIP = (TextView) view.findViewById(d.h.view_main_thread_praise_num);
            this.eIQ = (TextView) view.findViewById(d.h.view_main_thread_praise_name_list);
            this.daI = view.findViewById(d.h.bottom_divider_line);
        }
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        if (lVar != null) {
            if (lVar.aNF()) {
                if (lVar.ezf == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.eIO, d.g.icon_floor_big_praised);
                } else if (lVar.ezf == 3) {
                    com.baidu.tbadk.core.util.aj.c(this.eIO, d.g.icon_floor_trample);
                } else if (lVar.ezf == 4) {
                    com.baidu.tbadk.core.util.aj.c(this.eIO, d.g.icon_floor_big_trample);
                } else {
                    com.baidu.tbadk.core.util.aj.c(this.eIO, d.g.icon_floor_bigpraised);
                }
            } else {
                com.baidu.tbadk.core.util.aj.c(this.eIO, d.g.icon_floor_bigpraise_n);
            }
            com.baidu.tbadk.core.util.aj.i(this.eIP, d.e.cp_link_tip_c);
            com.baidu.tbadk.core.util.aj.i(this.eIQ, d.e.cp_link_tip_c);
            this.eIO.setTag(d.h.pb_main_thread_praise_data, lVar);
            if (lVar.aNI()) {
                com.baidu.tbadk.core.util.aj.k(this.daI, d.e.cp_bg_line_c);
                this.daI.setVisibility(0);
            } else {
                this.daI.setVisibility(8);
            }
            if (lVar.getPraiseNum() <= 0 || com.baidu.tbadk.core.util.v.u(lVar.aNG())) {
                this.eIP.setText(d.l.no_praise_tip);
                com.baidu.tbadk.core.util.aj.i(this.eIP, d.e.cp_cont_f);
                this.eIQ.setVisibility(8);
                this.eIQ.setTag(false);
                this.eIP.setTag(false);
                return;
            }
            this.eIQ.setTag(true);
            this.eIP.setTag(true);
            this.eIQ.setVisibility(0);
            this.eIQ.setText(Html.fromHtml(lVar.h(this.eIQ), new Html.ImageGetter() { // from class: com.baidu.tieba.pb.pb.main.ak.1
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
            this.eIP.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.count_main_thread_praise), com.baidu.tbadk.core.util.am.u(lVar.getPraiseNum())));
        }
    }
}
