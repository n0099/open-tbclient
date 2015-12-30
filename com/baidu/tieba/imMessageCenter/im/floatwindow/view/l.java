package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class l {
    private TextView aGr;
    private TextView aLt;
    private TextView bMg;
    private TextView cfS;
    private int status;

    public l(View view) {
        this.aGr = (TextView) view.findViewById(n.g.floating_chat_name);
        this.cfS = (TextView) view.findViewById(n.g.floating_chat_distance);
        this.bMg = (TextView) view.findViewById(n.g.floating_chat_time);
        this.aLt = (TextView) view.findViewById(n.g.floating_chat_add_friend);
    }

    public void jn(String str) {
        this.aGr.setText(str);
    }

    public void jk(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.aLt.setClickable(true);
                this.aLt.setVisibility(0);
                this.aLt.setText(n.j.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.aLt.setVisibility(8);
                return;
            case 2:
                this.aLt.setVisibility(0);
                this.aLt.setText(n.j.waiting);
                this.aLt.setClickable(false);
                this.aLt.setBackgroundResource(n.d.transparent);
                this.aLt.setText(n.j.waiting);
                this.aLt.setTextColor(TbadkCoreApplication.m411getInst().getResources().getColor(n.d.cp_cont_d));
                return;
            case 4:
                this.aLt.setClickable(true);
                this.aLt.setVisibility(0);
                this.aLt.setText(n.j.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void p(View.OnClickListener onClickListener) {
        this.aLt.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.aGr.setText(str);
        if (bVar != null) {
            if (bVar.zi() < 0 || bVar.zi() > 1) {
                this.cfS.setVisibility(8);
                this.bMg.setVisibility(8);
                return;
            }
            this.cfS.setVisibility(0);
            this.bMg.setVisibility(0);
            this.cfS.setText(TbadkCoreApplication.m411getInst().getResources().getString(n.j.contact_yinshen));
            if (!StringUtils.isNull(bVar.getDistance()) && bVar.getTime() > 0) {
                this.cfS.setVisibility(0);
                this.cfS.setText(bVar.getDistance());
                this.bMg.setText(ax.r(bVar.getTime()));
                return;
            }
            this.cfS.setVisibility(8);
        }
    }
}
