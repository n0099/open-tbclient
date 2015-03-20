package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bd;
/* loaded from: classes.dex */
public class n {
    private TextView aFs;
    private TextView aYn;
    private TextView azx;
    private TextView brD;
    private int status;

    public n(View view) {
        this.aFs = (TextView) view.findViewById(com.baidu.tieba.v.floating_chat_name);
        this.brD = (TextView) view.findViewById(com.baidu.tieba.v.floating_chat_distance);
        this.aYn = (TextView) view.findViewById(com.baidu.tieba.v.floating_chat_time);
        this.azx = (TextView) view.findViewById(com.baidu.tieba.v.floating_chat_add_friend);
    }

    public void hi(String str) {
        this.aFs.setText(str);
    }

    public void gx(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.azx.setClickable(true);
                this.azx.setVisibility(0);
                this.azx.setText(com.baidu.tieba.y.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.azx.setVisibility(8);
                return;
            case 2:
                this.azx.setVisibility(0);
                this.azx.setText(com.baidu.tieba.y.waiting);
                this.azx.setClickable(false);
                this.azx.setBackgroundResource(com.baidu.tieba.s.transparent);
                this.azx.setText(com.baidu.tieba.y.waiting);
                this.azx.setTextColor(TbadkCoreApplication.m411getInst().getResources().getColor(com.baidu.tieba.s.cp_cont_d));
                return;
            case 4:
                this.azx.setClickable(true);
                this.azx.setVisibility(0);
                this.azx.setText(com.baidu.tieba.y.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void q(View.OnClickListener onClickListener) {
        this.azx.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.aFs.setText(str);
        if (bVar != null) {
            if (bVar.wE() < 0 || bVar.wE() > 1) {
                this.brD.setVisibility(8);
                this.aYn.setVisibility(8);
                return;
            }
            this.brD.setVisibility(0);
            this.aYn.setVisibility(0);
            this.brD.setText(TbadkCoreApplication.m411getInst().getResources().getString(com.baidu.tieba.y.contact_yinshen));
            if (!StringUtils.isNull(bVar.getDistance()) && bVar.getTime() > 0) {
                this.brD.setVisibility(0);
                this.brD.setText(bVar.getDistance());
                this.aYn.setText(bd.m(bVar.getTime()));
                return;
            }
            this.brD.setVisibility(8);
        }
    }
}
