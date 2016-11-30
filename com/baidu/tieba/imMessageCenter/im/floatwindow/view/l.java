package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class l {
    private TextView aLq;
    private TextView aYk;
    private TextView dcb;
    private TextView dwU;
    private int status;

    public l(View view) {
        this.aLq = (TextView) view.findViewById(r.g.floating_chat_name);
        this.dwU = (TextView) view.findViewById(r.g.floating_chat_distance);
        this.dcb = (TextView) view.findViewById(r.g.floating_chat_time);
        this.aYk = (TextView) view.findViewById(r.g.floating_chat_add_friend);
    }

    public void mN(String str) {
        this.aLq.setText(str);
    }

    public void mt(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.aYk.setClickable(true);
                this.aYk.setVisibility(0);
                this.aYk.setText(r.j.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.aYk.setVisibility(8);
                return;
            case 2:
                this.aYk.setVisibility(0);
                this.aYk.setText(r.j.waiting);
                this.aYk.setClickable(false);
                this.aYk.setBackgroundResource(r.d.common_color_10022);
                this.aYk.setText(r.j.waiting);
                this.aYk.setTextColor(TbadkCoreApplication.m9getInst().getResources().getColor(r.d.cp_cont_d));
                return;
            case 4:
                this.aYk.setClickable(true);
                this.aYk.setVisibility(0);
                this.aYk.setText(r.j.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void q(View.OnClickListener onClickListener) {
        this.aYk.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.aLq.setText(str);
        if (bVar != null) {
            if (bVar.AB() < 0 || bVar.AB() > 1) {
                this.dwU.setVisibility(8);
                this.dcb.setVisibility(8);
                return;
            }
            this.dwU.setVisibility(0);
            this.dcb.setVisibility(0);
            this.dwU.setText(TbadkCoreApplication.m9getInst().getResources().getString(r.j.contact_yinshen));
            if (!StringUtils.isNull(bVar.AA()) && bVar.getTime() > 0) {
                this.dwU.setVisibility(0);
                this.dwU.setText(bVar.AA());
                this.dcb.setText(ax.q(bVar.getTime()));
                return;
            }
            this.dwU.setVisibility(8);
        }
    }
}
