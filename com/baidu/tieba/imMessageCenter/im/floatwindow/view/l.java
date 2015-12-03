package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class l {
    private TextView aER;
    private TextView aJV;
    private TextView bIz;
    private TextView cbS;
    private int status;

    public l(View view) {
        this.aER = (TextView) view.findViewById(n.f.floating_chat_name);
        this.cbS = (TextView) view.findViewById(n.f.floating_chat_distance);
        this.bIz = (TextView) view.findViewById(n.f.floating_chat_time);
        this.aJV = (TextView) view.findViewById(n.f.floating_chat_add_friend);
    }

    public void ja(String str) {
        this.aER.setText(str);
    }

    public void iL(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.aJV.setClickable(true);
                this.aJV.setVisibility(0);
                this.aJV.setText(n.i.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.aJV.setVisibility(8);
                return;
            case 2:
                this.aJV.setVisibility(0);
                this.aJV.setText(n.i.waiting);
                this.aJV.setClickable(false);
                this.aJV.setBackgroundResource(n.c.transparent);
                this.aJV.setText(n.i.waiting);
                this.aJV.setTextColor(TbadkCoreApplication.m411getInst().getResources().getColor(n.c.cp_cont_d));
                return;
            case 4:
                this.aJV.setClickable(true);
                this.aJV.setVisibility(0);
                this.aJV.setText(n.i.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void p(View.OnClickListener onClickListener) {
        this.aJV.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.aER.setText(str);
        if (bVar != null) {
            if (bVar.zw() < 0 || bVar.zw() > 1) {
                this.cbS.setVisibility(8);
                this.bIz.setVisibility(8);
                return;
            }
            this.cbS.setVisibility(0);
            this.bIz.setVisibility(0);
            this.cbS.setText(TbadkCoreApplication.m411getInst().getResources().getString(n.i.contact_yinshen));
            if (!StringUtils.isNull(bVar.getDistance()) && bVar.getTime() > 0) {
                this.cbS.setVisibility(0);
                this.cbS.setText(bVar.getDistance());
                this.bIz.setText(ax.r(bVar.getTime()));
                return;
            }
            this.cbS.setVisibility(8);
        }
    }
}
