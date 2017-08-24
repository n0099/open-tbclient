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
    public View cWS;
    public ImageView ePR;
    public TextView ePS;
    public TextView ePT;
    public View mRootView;

    public an(View view) {
        super(view);
        if (view != null) {
            this.mRootView = view.findViewById(d.h.thread_praise_root);
            this.ePR = (ImageView) view.findViewById(d.h.view_main_thread_praise_state);
            this.ePS = (TextView) view.findViewById(d.h.view_main_thread_praise_num);
            this.ePT = (TextView) view.findViewById(d.h.view_main_thread_praise_name_list);
            this.cWS = view.findViewById(d.h.bottom_divider_line);
        }
    }

    public void b(com.baidu.tieba.pb.data.m mVar) {
        if (mVar != null) {
            if (mVar.aQo()) {
                if (mVar.eGw == 1) {
                    com.baidu.tbadk.core.util.ai.c(this.ePR, d.g.icon_floor_big_praised);
                } else if (mVar.eGw == 3) {
                    com.baidu.tbadk.core.util.ai.c(this.ePR, d.g.icon_floor_trample);
                } else if (mVar.eGw == 4) {
                    com.baidu.tbadk.core.util.ai.c(this.ePR, d.g.icon_floor_big_trample);
                } else {
                    com.baidu.tbadk.core.util.ai.c(this.ePR, d.g.icon_floor_bigpraised);
                }
            } else {
                com.baidu.tbadk.core.util.ai.c(this.ePR, d.g.icon_floor_bigpraise_n);
            }
            com.baidu.tbadk.core.util.ai.i(this.ePS, d.e.cp_link_tip_c);
            com.baidu.tbadk.core.util.ai.i(this.ePT, d.e.cp_link_tip_c);
            this.ePR.setTag(d.h.pb_main_thread_praise_data, mVar);
            if (mVar.aQr()) {
                com.baidu.tbadk.core.util.ai.k(this.cWS, d.e.cp_bg_line_c);
                this.cWS.setVisibility(0);
            } else {
                this.cWS.setVisibility(8);
            }
            if (mVar.getPraiseNum() <= 0 || com.baidu.tbadk.core.util.u.v(mVar.aQp())) {
                this.ePS.setText(d.l.no_praise_tip);
                com.baidu.tbadk.core.util.ai.i(this.ePS, d.e.cp_cont_f);
                this.ePT.setVisibility(8);
                this.ePT.setTag(false);
                this.ePS.setTag(false);
                return;
            }
            this.ePT.setTag(true);
            this.ePS.setTag(true);
            this.ePT.setVisibility(0);
            this.ePT.setText(Html.fromHtml(mVar.h(this.ePT), new Html.ImageGetter() { // from class: com.baidu.tieba.pb.pb.main.an.1
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
            this.ePS.setText(String.format(TbadkCoreApplication.getInst().getString(d.l.count_main_thread_praise), com.baidu.tbadk.core.util.al.v(mVar.getPraiseNum())));
        }
    }
}
