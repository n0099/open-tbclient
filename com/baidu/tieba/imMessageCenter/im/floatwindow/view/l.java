package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class l {
    private TextView aHI;
    private TextView aPV;
    private TextView cJr;
    private TextView dei;
    private int status;

    public l(View view) {
        this.aHI = (TextView) view.findViewById(u.g.floating_chat_name);
        this.dei = (TextView) view.findViewById(u.g.floating_chat_distance);
        this.cJr = (TextView) view.findViewById(u.g.floating_chat_time);
        this.aPV = (TextView) view.findViewById(u.g.floating_chat_add_friend);
    }

    public void lE(String str) {
        this.aHI.setText(str);
    }

    public void lA(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.aPV.setClickable(true);
                this.aPV.setVisibility(0);
                this.aPV.setText(u.j.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.aPV.setVisibility(8);
                return;
            case 2:
                this.aPV.setVisibility(0);
                this.aPV.setText(u.j.waiting);
                this.aPV.setClickable(false);
                this.aPV.setBackgroundResource(u.d.common_color_10022);
                this.aPV.setText(u.j.waiting);
                this.aPV.setTextColor(TbadkCoreApplication.m10getInst().getResources().getColor(u.d.cp_cont_d));
                return;
            case 4:
                this.aPV.setClickable(true);
                this.aPV.setVisibility(0);
                this.aPV.setText(u.j.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.aPV.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.aHI.setText(str);
        if (bVar != null) {
            if (bVar.zc() < 0 || bVar.zc() > 1) {
                this.dei.setVisibility(8);
                this.cJr.setVisibility(8);
                return;
            }
            this.dei.setVisibility(0);
            this.cJr.setVisibility(0);
            this.dei.setText(TbadkCoreApplication.m10getInst().getResources().getString(u.j.contact_yinshen));
            if (!StringUtils.isNull(bVar.getDistance()) && bVar.getTime() > 0) {
                this.dei.setVisibility(0);
                this.dei.setText(bVar.getDistance());
                this.cJr.setText(ba.s(bVar.getTime()));
                return;
            }
            this.dei.setVisibility(8);
        }
    }
}
