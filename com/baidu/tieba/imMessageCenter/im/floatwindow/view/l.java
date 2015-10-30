package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class l {
    private TextView aDl;
    private TextView aIc;
    private TextView bMt;
    private TextView bsP;
    private int status;

    public l(View view) {
        this.aDl = (TextView) view.findViewById(i.f.floating_chat_name);
        this.bMt = (TextView) view.findViewById(i.f.floating_chat_distance);
        this.bsP = (TextView) view.findViewById(i.f.floating_chat_time);
        this.aIc = (TextView) view.findViewById(i.f.floating_chat_add_friend);
    }

    public void iE(String str) {
        this.aDl.setText(str);
    }

    public void hK(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.aIc.setClickable(true);
                this.aIc.setVisibility(0);
                this.aIc.setText(i.h.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.aIc.setVisibility(8);
                return;
            case 2:
                this.aIc.setVisibility(0);
                this.aIc.setText(i.h.waiting);
                this.aIc.setClickable(false);
                this.aIc.setBackgroundResource(i.c.transparent);
                this.aIc.setText(i.h.waiting);
                this.aIc.setTextColor(TbadkCoreApplication.m411getInst().getResources().getColor(i.c.cp_cont_d));
                return;
            case 4:
                this.aIc.setClickable(true);
                this.aIc.setVisibility(0);
                this.aIc.setText(i.h.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void p(View.OnClickListener onClickListener) {
        this.aIc.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.aDl.setText(str);
        if (bVar != null) {
            if (bVar.yv() < 0 || bVar.yv() > 1) {
                this.bMt.setVisibility(8);
                this.bsP.setVisibility(8);
                return;
            }
            this.bMt.setVisibility(0);
            this.bsP.setVisibility(0);
            this.bMt.setText(TbadkCoreApplication.m411getInst().getResources().getString(i.h.contact_yinshen));
            if (!StringUtils.isNull(bVar.getDistance()) && bVar.getTime() > 0) {
                this.bMt.setVisibility(0);
                this.bMt.setText(bVar.getDistance());
                this.bsP.setText(as.l(bVar.getTime()));
                return;
            }
            this.bMt.setVisibility(8);
        }
    }
}
