package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bd;
/* loaded from: classes.dex */
public class n {
    private TextView aFA;
    private TextView aYD;
    private TextView azF;
    private TextView brT;
    private int status;

    public n(View view) {
        this.aFA = (TextView) view.findViewById(com.baidu.tieba.v.floating_chat_name);
        this.brT = (TextView) view.findViewById(com.baidu.tieba.v.floating_chat_distance);
        this.aYD = (TextView) view.findViewById(com.baidu.tieba.v.floating_chat_time);
        this.azF = (TextView) view.findViewById(com.baidu.tieba.v.floating_chat_add_friend);
    }

    public void hl(String str) {
        this.aFA.setText(str);
    }

    public void gz(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.azF.setClickable(true);
                this.azF.setVisibility(0);
                this.azF.setText(com.baidu.tieba.y.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.azF.setVisibility(8);
                return;
            case 2:
                this.azF.setVisibility(0);
                this.azF.setText(com.baidu.tieba.y.waiting);
                this.azF.setClickable(false);
                this.azF.setBackgroundResource(com.baidu.tieba.s.transparent);
                this.azF.setText(com.baidu.tieba.y.waiting);
                this.azF.setTextColor(TbadkCoreApplication.m411getInst().getResources().getColor(com.baidu.tieba.s.cp_cont_d));
                return;
            case 4:
                this.azF.setClickable(true);
                this.azF.setVisibility(0);
                this.azF.setText(com.baidu.tieba.y.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.azF.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.aFA.setText(str);
        if (bVar != null) {
            if (bVar.wK() < 0 || bVar.wK() > 1) {
                this.brT.setVisibility(8);
                this.aYD.setVisibility(8);
                return;
            }
            this.brT.setVisibility(0);
            this.aYD.setVisibility(0);
            this.brT.setText(TbadkCoreApplication.m411getInst().getResources().getString(com.baidu.tieba.y.contact_yinshen));
            if (!StringUtils.isNull(bVar.getDistance()) && bVar.getTime() > 0) {
                this.brT.setVisibility(0);
                this.brT.setText(bVar.getDistance());
                this.aYD.setText(bd.m(bVar.getTime()));
                return;
            }
            this.brT.setVisibility(8);
        }
    }
}
