package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class l {
    private TextView aIZ;
    private TextView aPv;
    private TextView bJd;
    private TextView bpD;
    private int status;

    public l(View view) {
        this.aPv = (TextView) view.findViewById(i.f.floating_chat_name);
        this.bJd = (TextView) view.findViewById(i.f.floating_chat_distance);
        this.bpD = (TextView) view.findViewById(i.f.floating_chat_time);
        this.aIZ = (TextView) view.findViewById(i.f.floating_chat_add_friend);
    }

    public void iA(String str) {
        this.aPv.setText(str);
    }

    public void hE(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.aIZ.setClickable(true);
                this.aIZ.setVisibility(0);
                this.aIZ.setText(i.h.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.aIZ.setVisibility(8);
                return;
            case 2:
                this.aIZ.setVisibility(0);
                this.aIZ.setText(i.h.waiting);
                this.aIZ.setClickable(false);
                this.aIZ.setBackgroundResource(i.c.transparent);
                this.aIZ.setText(i.h.waiting);
                this.aIZ.setTextColor(TbadkCoreApplication.m411getInst().getResources().getColor(i.c.cp_cont_d));
                return;
            case 4:
                this.aIZ.setClickable(true);
                this.aIZ.setVisibility(0);
                this.aIZ.setText(i.h.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void p(View.OnClickListener onClickListener) {
        this.aIZ.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.aPv.setText(str);
        if (bVar != null) {
            if (bVar.yO() < 0 || bVar.yO() > 1) {
                this.bJd.setVisibility(8);
                this.bpD.setVisibility(8);
                return;
            }
            this.bJd.setVisibility(0);
            this.bpD.setVisibility(0);
            this.bJd.setText(TbadkCoreApplication.m411getInst().getResources().getString(i.h.contact_yinshen));
            if (!StringUtils.isNull(bVar.getDistance()) && bVar.getTime() > 0) {
                this.bJd.setVisibility(0);
                this.bJd.setText(bVar.getDistance());
                this.bpD.setText(aq.l(bVar.getTime()));
                return;
            }
            this.bJd.setVisibility(8);
        }
    }
}
