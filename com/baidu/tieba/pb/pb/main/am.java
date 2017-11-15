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
public class am extends j.a {
    public View diE;
    public ImageView eRH;
    public TextView eRI;
    public TextView eRJ;
    public View mRootView;

    public am(View view) {
        super(view);
        if (view != null) {
            this.mRootView = view.findViewById(d.g.thread_praise_root);
            this.eRH = (ImageView) view.findViewById(d.g.view_main_thread_praise_state);
            this.eRI = (TextView) view.findViewById(d.g.view_main_thread_praise_num);
            this.eRJ = (TextView) view.findViewById(d.g.view_main_thread_praise_name_list);
            this.diE = view.findViewById(d.g.bottom_divider_line);
        }
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        if (lVar != null) {
            if (lVar.aQB()) {
                if (lVar.eHn == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.eRH, d.f.icon_floor_big_praised);
                } else if (lVar.eHn == 3) {
                    com.baidu.tbadk.core.util.aj.c(this.eRH, d.f.icon_floor_trample);
                } else if (lVar.eHn == 4) {
                    com.baidu.tbadk.core.util.aj.c(this.eRH, d.f.icon_floor_big_trample);
                } else {
                    com.baidu.tbadk.core.util.aj.c(this.eRH, d.f.icon_floor_bigpraised);
                }
            } else {
                com.baidu.tbadk.core.util.aj.c(this.eRH, d.f.icon_floor_bigpraise_n);
            }
            com.baidu.tbadk.core.util.aj.i(this.eRI, d.C0080d.cp_link_tip_c);
            com.baidu.tbadk.core.util.aj.i(this.eRJ, d.C0080d.cp_link_tip_c);
            this.eRH.setTag(d.g.pb_main_thread_praise_data, lVar);
            if (lVar.aQE()) {
                com.baidu.tbadk.core.util.aj.k(this.diE, d.C0080d.cp_bg_line_c);
                this.diE.setVisibility(0);
            } else {
                this.diE.setVisibility(8);
            }
            if (lVar.aQA() <= 0 || com.baidu.tbadk.core.util.v.v(lVar.aQC())) {
                this.eRI.setText(d.j.no_praise_tip);
                com.baidu.tbadk.core.util.aj.i(this.eRI, d.C0080d.cp_cont_f);
                this.eRJ.setVisibility(8);
                this.eRJ.setTag(false);
                this.eRI.setTag(false);
                return;
            }
            this.eRJ.setTag(true);
            this.eRI.setTag(true);
            this.eRJ.setVisibility(0);
            this.eRJ.setText(Html.fromHtml(lVar.h(this.eRJ), new Html.ImageGetter() { // from class: com.baidu.tieba.pb.pb.main.am.1
                @Override // android.text.Html.ImageGetter
                public Drawable getDrawable(String str) {
                    int parseInt = Integer.parseInt(str);
                    Drawable drawable = TbadkCoreApplication.getInst().getResources().getDrawable(d.f.praise_01);
                    try {
                        drawable = TbadkCoreApplication.getInst().getResources().getDrawable(parseInt);
                    } catch (Exception e) {
                    }
                    drawable.setBounds(0, 0, com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds36), com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.ds36));
                    return drawable;
                }
            }, null));
            this.eRI.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.count_main_thread_praise), com.baidu.tbadk.core.util.am.v(lVar.aQA())));
        }
    }
}
