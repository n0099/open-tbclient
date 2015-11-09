package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class l {
    private TextView aCf;
    private TextView aGW;
    private TextView bMO;
    private TextView btt;
    private int status;

    public l(View view) {
        this.aCf = (TextView) view.findViewById(i.f.floating_chat_name);
        this.bMO = (TextView) view.findViewById(i.f.floating_chat_distance);
        this.btt = (TextView) view.findViewById(i.f.floating_chat_time);
        this.aGW = (TextView) view.findViewById(i.f.floating_chat_add_friend);
    }

    public void iG(String str) {
        this.aCf.setText(str);
    }

    public void hX(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.aGW.setClickable(true);
                this.aGW.setVisibility(0);
                this.aGW.setText(i.h.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.aGW.setVisibility(8);
                return;
            case 2:
                this.aGW.setVisibility(0);
                this.aGW.setText(i.h.waiting);
                this.aGW.setClickable(false);
                this.aGW.setBackgroundResource(i.c.transparent);
                this.aGW.setText(i.h.waiting);
                this.aGW.setTextColor(TbadkCoreApplication.m411getInst().getResources().getColor(i.c.cp_cont_d));
                return;
            case 4:
                this.aGW.setClickable(true);
                this.aGW.setVisibility(0);
                this.aGW.setText(i.h.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void p(View.OnClickListener onClickListener) {
        this.aGW.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.aCf.setText(str);
        if (bVar != null) {
            if (bVar.yA() < 0 || bVar.yA() > 1) {
                this.bMO.setVisibility(8);
                this.btt.setVisibility(8);
                return;
            }
            this.bMO.setVisibility(0);
            this.btt.setVisibility(0);
            this.bMO.setText(TbadkCoreApplication.m411getInst().getResources().getString(i.h.contact_yinshen));
            if (!StringUtils.isNull(bVar.getDistance()) && bVar.getTime() > 0) {
                this.bMO.setVisibility(0);
                this.bMO.setText(bVar.getDistance());
                this.btt.setText(as.l(bVar.getTime()));
                return;
            }
            this.bMO.setVisibility(8);
        }
    }
}
