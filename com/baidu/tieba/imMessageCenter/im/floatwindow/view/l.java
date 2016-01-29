package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class l {
    private TextView aHk;
    private TextView aMy;
    private TextView bQi;
    private TextView cks;
    private int status;

    public l(View view) {
        this.aHk = (TextView) view.findViewById(t.g.floating_chat_name);
        this.cks = (TextView) view.findViewById(t.g.floating_chat_distance);
        this.bQi = (TextView) view.findViewById(t.g.floating_chat_time);
        this.aMy = (TextView) view.findViewById(t.g.floating_chat_add_friend);
    }

    public void js(String str) {
        this.aHk.setText(str);
    }

    public void jI(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.aMy.setClickable(true);
                this.aMy.setVisibility(0);
                this.aMy.setText(t.j.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.aMy.setVisibility(8);
                return;
            case 2:
                this.aMy.setVisibility(0);
                this.aMy.setText(t.j.waiting);
                this.aMy.setClickable(false);
                this.aMy.setBackgroundResource(t.d.transparent);
                this.aMy.setText(t.j.waiting);
                this.aMy.setTextColor(TbadkCoreApplication.m411getInst().getResources().getColor(t.d.cp_cont_d));
                return;
            case 4:
                this.aMy.setClickable(true);
                this.aMy.setVisibility(0);
                this.aMy.setText(t.j.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void u(View.OnClickListener onClickListener) {
        this.aMy.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.aHk.setText(str);
        if (bVar != null) {
            if (bVar.AA() < 0 || bVar.AA() > 1) {
                this.cks.setVisibility(8);
                this.bQi.setVisibility(8);
                return;
            }
            this.cks.setVisibility(0);
            this.bQi.setVisibility(0);
            this.cks.setText(TbadkCoreApplication.m411getInst().getResources().getString(t.j.contact_yinshen));
            if (!StringUtils.isNull(bVar.getDistance()) && bVar.getTime() > 0) {
                this.cks.setVisibility(0);
                this.cks.setText(bVar.getDistance());
                this.bQi.setText(aw.s(bVar.getTime()));
                return;
            }
            this.cks.setVisibility(8);
        }
    }
}
