package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bb;
/* loaded from: classes.dex */
public class n {
    private TextView aBr;
    private TextView aHI;
    private TextView bbl;
    private TextView buG;
    private int status;

    public n(View view) {
        this.aHI = (TextView) view.findViewById(com.baidu.tieba.q.floating_chat_name);
        this.buG = (TextView) view.findViewById(com.baidu.tieba.q.floating_chat_distance);
        this.bbl = (TextView) view.findViewById(com.baidu.tieba.q.floating_chat_time);
        this.aBr = (TextView) view.findViewById(com.baidu.tieba.q.floating_chat_add_friend);
    }

    public void hO(String str) {
        this.aHI.setText(str);
    }

    public void gQ(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.aBr.setClickable(true);
                this.aBr.setVisibility(0);
                this.aBr.setText(com.baidu.tieba.t.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.aBr.setVisibility(8);
                return;
            case 2:
                this.aBr.setVisibility(0);
                this.aBr.setText(com.baidu.tieba.t.waiting);
                this.aBr.setClickable(false);
                this.aBr.setBackgroundResource(com.baidu.tieba.n.transparent);
                this.aBr.setText(com.baidu.tieba.t.waiting);
                this.aBr.setTextColor(TbadkCoreApplication.m411getInst().getResources().getColor(com.baidu.tieba.n.cp_cont_d));
                return;
            case 4:
                this.aBr.setClickable(true);
                this.aBr.setVisibility(0);
                this.aBr.setText(com.baidu.tieba.t.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void q(View.OnClickListener onClickListener) {
        this.aBr.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.aHI.setText(str);
        if (bVar != null) {
            if (bVar.xy() < 0 || bVar.xy() > 1) {
                this.buG.setVisibility(8);
                this.bbl.setVisibility(8);
                return;
            }
            this.buG.setVisibility(0);
            this.bbl.setVisibility(0);
            this.buG.setText(TbadkCoreApplication.m411getInst().getResources().getString(com.baidu.tieba.t.contact_yinshen));
            if (!StringUtils.isNull(bVar.getDistance()) && bVar.getTime() > 0) {
                this.buG.setVisibility(0);
                this.buG.setText(bVar.getDistance());
                this.bbl.setText(bb.n(bVar.getTime()));
                return;
            }
            this.buG.setVisibility(8);
        }
    }
}
