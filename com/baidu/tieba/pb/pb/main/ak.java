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
    public View deu;
    public ImageView eOW;
    public TextView eOX;
    public TextView eOY;
    public View mRootView;

    public ak(View view) {
        super(view);
        if (view != null) {
            this.mRootView = view.findViewById(d.h.thread_praise_root);
            this.eOW = (ImageView) view.findViewById(d.h.view_main_thread_praise_state);
            this.eOX = (TextView) view.findViewById(d.h.view_main_thread_praise_num);
            this.eOY = (TextView) view.findViewById(d.h.view_main_thread_praise_name_list);
            this.deu = view.findViewById(d.h.bottom_divider_line);
        }
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        if (lVar != null) {
            if (lVar.aPL()) {
                if (lVar.eFJ == 1) {
                    com.baidu.tbadk.core.util.aj.c(this.eOW, d.g.icon_floor_big_praised);
                } else if (lVar.eFJ == 3) {
                    com.baidu.tbadk.core.util.aj.c(this.eOW, d.g.icon_floor_trample);
                } else if (lVar.eFJ == 4) {
                    com.baidu.tbadk.core.util.aj.c(this.eOW, d.g.icon_floor_big_trample);
                } else {
                    com.baidu.tbadk.core.util.aj.c(this.eOW, d.g.icon_floor_bigpraised);
                }
            } else {
                com.baidu.tbadk.core.util.aj.c(this.eOW, d.g.icon_floor_bigpraise_n);
            }
            com.baidu.tbadk.core.util.aj.i(this.eOX, d.e.cp_link_tip_c);
            com.baidu.tbadk.core.util.aj.i(this.eOY, d.e.cp_link_tip_c);
            this.eOW.setTag(d.h.pb_main_thread_praise_data, lVar);
            if (lVar.aPO()) {
                com.baidu.tbadk.core.util.aj.k(this.deu, d.e.cp_bg_line_c);
                this.deu.setVisibility(0);
            } else {
                this.deu.setVisibility(8);
            }
            if (lVar.getPraiseNum() <= 0 || com.baidu.tbadk.core.util.v.v(lVar.aPM())) {
                this.eOX.setText(d.l.no_praise_tip);
                com.baidu.tbadk.core.util.aj.i(this.eOX, d.e.cp_cont_f);
                this.eOY.setVisibility(8);
                this.eOY.setTag(false);
                this.eOX.setTag(false);
                return;
            }
            this.eOY.setTag(true);
            this.eOX.setTag(true);
            this.eOY.setVisibility(0);
            this.eOY.setText(Html.fromHtml(lVar.h(this.eOY), new Html.ImageGetter() { // from class: com.baidu.tieba.pb.pb.main.ak.1
                @Override // android.text.Html.ImageGetter
                public Drawable getDrawable(String str) {
                    int parseInt = Integer.parseInt(str);
                    Drawable drawable = TbadkCoreApplication.getInst().getResources().getDrawable(d.g.praise_01);
                    try {
                        drawable = TbadkCoreApplication.getInst().getResources().getDrawable(parseInt);
                    } catch (Exception e) {
                    }
                    drawable.setBounds(0, 0, com.baidu.adp.lib.util.k.f(TbadkCoreApplication.getInst(), d.f.ds36), com.baidu.adp.lib.util.k.f(TbadkCoreApplication.getInst(), d.f.ds36));
                    return drawable;
                }
            }, null));
            this.eOX.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.count_main_thread_praise), com.baidu.tbadk.core.util.am.v(lVar.getPraiseNum())));
        }
    }
}
