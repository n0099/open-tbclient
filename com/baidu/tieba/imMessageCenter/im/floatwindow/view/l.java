package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class l {
    private TextView aKg;
    private TextView aPt;
    private TextView caB;
    private TextView cuY;
    private int status;

    public l(View view) {
        this.aKg = (TextView) view.findViewById(t.g.floating_chat_name);
        this.cuY = (TextView) view.findViewById(t.g.floating_chat_distance);
        this.caB = (TextView) view.findViewById(t.g.floating_chat_time);
        this.aPt = (TextView) view.findViewById(t.g.floating_chat_add_friend);
    }

    public void kb(String str) {
        this.aKg.setText(str);
    }

    public void ko(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.aPt.setClickable(true);
                this.aPt.setVisibility(0);
                this.aPt.setText(t.j.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.aPt.setVisibility(8);
                return;
            case 2:
                this.aPt.setVisibility(0);
                this.aPt.setText(t.j.waiting);
                this.aPt.setClickable(false);
                this.aPt.setBackgroundResource(t.d.transparent);
                this.aPt.setText(t.j.waiting);
                this.aPt.setTextColor(TbadkCoreApplication.m411getInst().getResources().getColor(t.d.cp_cont_d));
                return;
            case 4:
                this.aPt.setClickable(true);
                this.aPt.setVisibility(0);
                this.aPt.setText(t.j.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void u(View.OnClickListener onClickListener) {
        this.aPt.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.aKg.setText(str);
        if (bVar != null) {
            if (bVar.Bd() < 0 || bVar.Bd() > 1) {
                this.cuY.setVisibility(8);
                this.caB.setVisibility(8);
                return;
            }
            this.cuY.setVisibility(0);
            this.caB.setVisibility(0);
            this.cuY.setText(TbadkCoreApplication.m411getInst().getResources().getString(t.j.contact_yinshen));
            if (!StringUtils.isNull(bVar.getDistance()) && bVar.getTime() > 0) {
                this.cuY.setVisibility(0);
                this.cuY.setText(bVar.getDistance());
                this.caB.setText(ay.v(bVar.getTime()));
                return;
            }
            this.cuY.setVisibility(8);
        }
    }
}
