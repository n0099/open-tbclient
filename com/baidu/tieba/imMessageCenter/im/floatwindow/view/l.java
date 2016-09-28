package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class l {
    private TextView aKy;
    private TextView aVY;
    private TextView cWq;
    private TextView drn;
    private int status;

    public l(View view) {
        this.aKy = (TextView) view.findViewById(r.g.floating_chat_name);
        this.drn = (TextView) view.findViewById(r.g.floating_chat_distance);
        this.cWq = (TextView) view.findViewById(r.g.floating_chat_time);
        this.aVY = (TextView) view.findViewById(r.g.floating_chat_add_friend);
    }

    public void mA(String str) {
        this.aKy.setText(str);
    }

    public void ml(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.aVY.setClickable(true);
                this.aVY.setVisibility(0);
                this.aVY.setText(r.j.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.aVY.setVisibility(8);
                return;
            case 2:
                this.aVY.setVisibility(0);
                this.aVY.setText(r.j.waiting);
                this.aVY.setClickable(false);
                this.aVY.setBackgroundResource(r.d.common_color_10022);
                this.aVY.setText(r.j.waiting);
                this.aVY.setTextColor(TbadkCoreApplication.m9getInst().getResources().getColor(r.d.cp_cont_d));
                return;
            case 4:
                this.aVY.setClickable(true);
                this.aVY.setVisibility(0);
                this.aVY.setText(r.j.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void o(View.OnClickListener onClickListener) {
        this.aVY.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.aKy.setText(str);
        if (bVar != null) {
            if (bVar.Au() < 0 || bVar.Au() > 1) {
                this.drn.setVisibility(8);
                this.cWq.setVisibility(8);
                return;
            }
            this.drn.setVisibility(0);
            this.cWq.setVisibility(0);
            this.drn.setText(TbadkCoreApplication.m9getInst().getResources().getString(r.j.contact_yinshen));
            if (!StringUtils.isNull(bVar.At()) && bVar.getTime() > 0) {
                this.drn.setVisibility(0);
                this.drn.setText(bVar.At());
                this.cWq.setText(az.r(bVar.getTime()));
                return;
            }
            this.drn.setVisibility(8);
        }
    }
}
