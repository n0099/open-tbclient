package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class l {
    private TextView aDa;
    private TextView aHR;
    private TextView bMi;
    private TextView bsE;
    private int status;

    public l(View view) {
        this.aDa = (TextView) view.findViewById(i.f.floating_chat_name);
        this.bMi = (TextView) view.findViewById(i.f.floating_chat_distance);
        this.bsE = (TextView) view.findViewById(i.f.floating_chat_time);
        this.aHR = (TextView) view.findViewById(i.f.floating_chat_add_friend);
    }

    public void iE(String str) {
        this.aDa.setText(str);
    }

    public void hK(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.aHR.setClickable(true);
                this.aHR.setVisibility(0);
                this.aHR.setText(i.h.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.aHR.setVisibility(8);
                return;
            case 2:
                this.aHR.setVisibility(0);
                this.aHR.setText(i.h.waiting);
                this.aHR.setClickable(false);
                this.aHR.setBackgroundResource(i.c.transparent);
                this.aHR.setText(i.h.waiting);
                this.aHR.setTextColor(TbadkCoreApplication.m411getInst().getResources().getColor(i.c.cp_cont_d));
                return;
            case 4:
                this.aHR.setClickable(true);
                this.aHR.setVisibility(0);
                this.aHR.setText(i.h.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void p(View.OnClickListener onClickListener) {
        this.aHR.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.aDa.setText(str);
        if (bVar != null) {
            if (bVar.yy() < 0 || bVar.yy() > 1) {
                this.bMi.setVisibility(8);
                this.bsE.setVisibility(8);
                return;
            }
            this.bMi.setVisibility(0);
            this.bsE.setVisibility(0);
            this.bMi.setText(TbadkCoreApplication.m411getInst().getResources().getString(i.h.contact_yinshen));
            if (!StringUtils.isNull(bVar.getDistance()) && bVar.getTime() > 0) {
                this.bMi.setVisibility(0);
                this.bMi.setText(bVar.getDistance());
                this.bsE.setText(ar.n(bVar.getTime()));
                return;
            }
            this.bMi.setVisibility(8);
        }
    }
}
