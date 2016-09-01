package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class l {
    private TextView aKZ;
    private TextView aVp;
    private TextView cUW;
    private TextView dpQ;
    private int status;

    public l(View view) {
        this.aKZ = (TextView) view.findViewById(t.g.floating_chat_name);
        this.dpQ = (TextView) view.findViewById(t.g.floating_chat_distance);
        this.cUW = (TextView) view.findViewById(t.g.floating_chat_time);
        this.aVp = (TextView) view.findViewById(t.g.floating_chat_add_friend);
    }

    public void mn(String str) {
        this.aKZ.setText(str);
    }

    public void md(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.aVp.setClickable(true);
                this.aVp.setVisibility(0);
                this.aVp.setText(t.j.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.aVp.setVisibility(8);
                return;
            case 2:
                this.aVp.setVisibility(0);
                this.aVp.setText(t.j.waiting);
                this.aVp.setClickable(false);
                this.aVp.setBackgroundResource(t.d.common_color_10022);
                this.aVp.setText(t.j.waiting);
                this.aVp.setTextColor(TbadkCoreApplication.m9getInst().getResources().getColor(t.d.cp_cont_d));
                return;
            case 4:
                this.aVp.setClickable(true);
                this.aVp.setVisibility(0);
                this.aVp.setText(t.j.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void p(View.OnClickListener onClickListener) {
        this.aVp.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.aKZ.setText(str);
        if (bVar != null) {
            if (bVar.Ar() < 0 || bVar.Ar() > 1) {
                this.dpQ.setVisibility(8);
                this.cUW.setVisibility(8);
                return;
            }
            this.dpQ.setVisibility(0);
            this.cUW.setVisibility(0);
            this.dpQ.setText(TbadkCoreApplication.m9getInst().getResources().getString(t.j.contact_yinshen));
            if (!StringUtils.isNull(bVar.Aq()) && bVar.getTime() > 0) {
                this.dpQ.setVisibility(0);
                this.dpQ.setText(bVar.Aq());
                this.cUW.setText(ba.r(bVar.getTime()));
                return;
            }
            this.dpQ.setVisibility(8);
        }
    }
}
