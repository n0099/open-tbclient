package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bb;
/* loaded from: classes.dex */
public class n {
    private TextView aBq;
    private TextView aHH;
    private TextView bbk;
    private TextView buF;
    private int status;

    public n(View view) {
        this.aHH = (TextView) view.findViewById(com.baidu.tieba.q.floating_chat_name);
        this.buF = (TextView) view.findViewById(com.baidu.tieba.q.floating_chat_distance);
        this.bbk = (TextView) view.findViewById(com.baidu.tieba.q.floating_chat_time);
        this.aBq = (TextView) view.findViewById(com.baidu.tieba.q.floating_chat_add_friend);
    }

    public void hO(String str) {
        this.aHH.setText(str);
    }

    public void gQ(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.aBq.setClickable(true);
                this.aBq.setVisibility(0);
                this.aBq.setText(com.baidu.tieba.t.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.aBq.setVisibility(8);
                return;
            case 2:
                this.aBq.setVisibility(0);
                this.aBq.setText(com.baidu.tieba.t.waiting);
                this.aBq.setClickable(false);
                this.aBq.setBackgroundResource(com.baidu.tieba.n.transparent);
                this.aBq.setText(com.baidu.tieba.t.waiting);
                this.aBq.setTextColor(TbadkCoreApplication.m411getInst().getResources().getColor(com.baidu.tieba.n.cp_cont_d));
                return;
            case 4:
                this.aBq.setClickable(true);
                this.aBq.setVisibility(0);
                this.aBq.setText(com.baidu.tieba.t.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void q(View.OnClickListener onClickListener) {
        this.aBq.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.aHH.setText(str);
        if (bVar != null) {
            if (bVar.xx() < 0 || bVar.xx() > 1) {
                this.buF.setVisibility(8);
                this.bbk.setVisibility(8);
                return;
            }
            this.buF.setVisibility(0);
            this.bbk.setVisibility(0);
            this.buF.setText(TbadkCoreApplication.m411getInst().getResources().getString(com.baidu.tieba.t.contact_yinshen));
            if (!StringUtils.isNull(bVar.getDistance()) && bVar.getTime() > 0) {
                this.buF.setVisibility(0);
                this.buF.setText(bVar.getDistance());
                this.bbk.setText(bb.n(bVar.getTime()));
                return;
            }
            this.buF.setVisibility(8);
        }
    }
}
