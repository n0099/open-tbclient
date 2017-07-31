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
public class an extends j.a {
    public View cUT;
    public ImageView eNW;
    public TextView eNX;
    public TextView eNY;
    public View mRootView;

    public an(View view) {
        super(view);
        if (view != null) {
            this.mRootView = view.findViewById(d.h.thread_praise_root);
            this.eNW = (ImageView) view.findViewById(d.h.view_main_thread_praise_state);
            this.eNX = (TextView) view.findViewById(d.h.view_main_thread_praise_num);
            this.eNY = (TextView) view.findViewById(d.h.view_main_thread_praise_name_list);
            this.cUT = view.findViewById(d.h.bottom_divider_line);
        }
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        if (mVar != null) {
            if (mVar.aPM()) {
                if (mVar.eEA == 1) {
                    com.baidu.tbadk.core.util.ai.c(this.eNW, d.g.icon_floor_big_praised);
                } else if (mVar.eEA == 3) {
                    com.baidu.tbadk.core.util.ai.c(this.eNW, d.g.icon_floor_trample);
                } else if (mVar.eEA == 4) {
                    com.baidu.tbadk.core.util.ai.c(this.eNW, d.g.icon_floor_big_trample);
                } else {
                    com.baidu.tbadk.core.util.ai.c(this.eNW, d.g.icon_floor_bigpraised);
                }
            } else {
                com.baidu.tbadk.core.util.ai.c(this.eNW, d.g.icon_floor_bigpraise_n);
            }
            com.baidu.tbadk.core.util.ai.i(this.eNX, d.e.cp_link_tip_c);
            com.baidu.tbadk.core.util.ai.i(this.eNY, d.e.cp_link_tip_c);
            this.eNW.setTag(d.h.pb_main_thread_praise_data, mVar);
            if (mVar.aPP()) {
                com.baidu.tbadk.core.util.ai.k(this.cUT, d.e.cp_bg_line_c);
                this.cUT.setVisibility(0);
            } else {
                this.cUT.setVisibility(8);
            }
            if (mVar.getPraiseNum() <= 0 || com.baidu.tbadk.core.util.u.v(mVar.aPN())) {
                this.eNX.setText(d.l.no_praise_tip);
                com.baidu.tbadk.core.util.ai.i(this.eNX, d.e.cp_cont_f);
                this.eNY.setVisibility(8);
                this.eNY.setTag(false);
                this.eNX.setTag(false);
                return;
            }
            this.eNY.setTag(true);
            this.eNX.setTag(true);
            this.eNY.setVisibility(0);
            this.eNY.setText(Html.fromHtml(mVar.g(this.eNY), new Html.ImageGetter() { // from class: com.baidu.tieba.pb.pb.main.an.1
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
            this.eNX.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.count_main_thread_praise), com.baidu.tbadk.core.util.al.v(mVar.getPraiseNum())));
        }
    }
}
