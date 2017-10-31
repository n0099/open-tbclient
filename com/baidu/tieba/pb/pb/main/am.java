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
    public View dik;
    public ImageView eRn;
    public TextView eRo;
    public TextView eRp;
    public View mRootView;

    public am(View view) {
        super(view);
        if (view != null) {
            this.mRootView = view.findViewById(d.g.thread_praise_root);
            this.eRn = (ImageView) view.findViewById(d.g.view_main_thread_praise_state);
            this.eRo = (TextView) view.findViewById(d.g.view_main_thread_praise_num);
            this.eRp = (TextView) view.findViewById(d.g.view_main_thread_praise_name_list);
            this.dik = view.findViewById(d.g.bottom_divider_line);
        }
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        if (lVar != null) {
            if (lVar.aQt()) {
                if (lVar.eGT == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.eRn, d.f.icon_floor_big_praised);
                } else if (lVar.eGT == 3) {
                    com.baidu.tbadk.core.util.aj.c(this.eRn, d.f.icon_floor_trample);
                } else if (lVar.eGT == 4) {
                    com.baidu.tbadk.core.util.aj.c(this.eRn, d.f.icon_floor_big_trample);
                } else {
                    com.baidu.tbadk.core.util.aj.c(this.eRn, d.f.icon_floor_bigpraised);
                }
            } else {
                com.baidu.tbadk.core.util.aj.c(this.eRn, d.f.icon_floor_bigpraise_n);
            }
            com.baidu.tbadk.core.util.aj.i(this.eRo, d.C0080d.cp_link_tip_c);
            com.baidu.tbadk.core.util.aj.i(this.eRp, d.C0080d.cp_link_tip_c);
            this.eRn.setTag(d.g.pb_main_thread_praise_data, lVar);
            if (lVar.aQw()) {
                com.baidu.tbadk.core.util.aj.k(this.dik, d.C0080d.cp_bg_line_c);
                this.dik.setVisibility(0);
            } else {
                this.dik.setVisibility(8);
            }
            if (lVar.aQs() <= 0 || com.baidu.tbadk.core.util.v.v(lVar.aQu())) {
                this.eRo.setText(d.j.no_praise_tip);
                com.baidu.tbadk.core.util.aj.i(this.eRo, d.C0080d.cp_cont_f);
                this.eRp.setVisibility(8);
                this.eRp.setTag(false);
                this.eRo.setTag(false);
                return;
            }
            this.eRp.setTag(true);
            this.eRo.setTag(true);
            this.eRp.setVisibility(0);
            this.eRp.setText(Html.fromHtml(lVar.h(this.eRp), new Html.ImageGetter() { // from class: com.baidu.tieba.pb.pb.main.am.1
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
            this.eRo.setText(String.format(TbadkCoreApplication.getInst().getString(d.j.count_main_thread_praise), com.baidu.tbadk.core.util.am.v(lVar.aQs())));
        }
    }
}
