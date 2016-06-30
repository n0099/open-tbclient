package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class l {
    private TextView aGR;
    private TextView aPb;
    private TextView cGC;
    private TextView dbl;
    private int status;

    public l(View view) {
        this.aGR = (TextView) view.findViewById(u.g.floating_chat_name);
        this.dbl = (TextView) view.findViewById(u.g.floating_chat_distance);
        this.cGC = (TextView) view.findViewById(u.g.floating_chat_time);
        this.aPb = (TextView) view.findViewById(u.g.floating_chat_add_friend);
    }

    public void lx(String str) {
        this.aGR.setText(str);
    }

    public void lu(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.aPb.setClickable(true);
                this.aPb.setVisibility(0);
                this.aPb.setText(u.j.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.aPb.setVisibility(8);
                return;
            case 2:
                this.aPb.setVisibility(0);
                this.aPb.setText(u.j.waiting);
                this.aPb.setClickable(false);
                this.aPb.setBackgroundResource(u.d.common_color_10022);
                this.aPb.setText(u.j.waiting);
                this.aPb.setTextColor(TbadkCoreApplication.m9getInst().getResources().getColor(u.d.cp_cont_d));
                return;
            case 4:
                this.aPb.setClickable(true);
                this.aPb.setVisibility(0);
                this.aPb.setText(u.j.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.aPb.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.aGR.setText(str);
        if (bVar != null) {
            if (bVar.zc() < 0 || bVar.zc() > 1) {
                this.dbl.setVisibility(8);
                this.cGC.setVisibility(8);
                return;
            }
            this.dbl.setVisibility(0);
            this.cGC.setVisibility(0);
            this.dbl.setText(TbadkCoreApplication.m9getInst().getResources().getString(u.j.contact_yinshen));
            if (!StringUtils.isNull(bVar.getDistance()) && bVar.getTime() > 0) {
                this.dbl.setVisibility(0);
                this.dbl.setText(bVar.getDistance());
                this.cGC.setText(ba.x(bVar.getTime()));
                return;
            }
            this.dbl.setVisibility(8);
        }
    }
}
