package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class l {
    private TextView aIM;
    private TextView aPi;
    private TextView bIw;
    private TextView bpf;
    private int status;

    public l(View view) {
        this.aPi = (TextView) view.findViewById(i.f.floating_chat_name);
        this.bIw = (TextView) view.findViewById(i.f.floating_chat_distance);
        this.bpf = (TextView) view.findViewById(i.f.floating_chat_time);
        this.aIM = (TextView) view.findViewById(i.f.floating_chat_add_friend);
    }

    public void ir(String str) {
        this.aPi.setText(str);
    }

    public void hu(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.aIM.setClickable(true);
                this.aIM.setVisibility(0);
                this.aIM.setText(i.C0057i.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.aIM.setVisibility(8);
                return;
            case 2:
                this.aIM.setVisibility(0);
                this.aIM.setText(i.C0057i.waiting);
                this.aIM.setClickable(false);
                this.aIM.setBackgroundResource(i.c.transparent);
                this.aIM.setText(i.C0057i.waiting);
                this.aIM.setTextColor(TbadkCoreApplication.m411getInst().getResources().getColor(i.c.cp_cont_d));
                return;
            case 4:
                this.aIM.setClickable(true);
                this.aIM.setVisibility(0);
                this.aIM.setText(i.C0057i.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void q(View.OnClickListener onClickListener) {
        this.aIM.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.aPi.setText(str);
        if (bVar != null) {
            if (bVar.yH() < 0 || bVar.yH() > 1) {
                this.bIw.setVisibility(8);
                this.bpf.setVisibility(8);
                return;
            }
            this.bIw.setVisibility(0);
            this.bpf.setVisibility(0);
            this.bIw.setText(TbadkCoreApplication.m411getInst().getResources().getString(i.C0057i.contact_yinshen));
            if (!StringUtils.isNull(bVar.getDistance()) && bVar.getTime() > 0) {
                this.bIw.setVisibility(0);
                this.bIw.setText(bVar.getDistance());
                this.bpf.setText(aq.l(bVar.getTime()));
                return;
            }
            this.bIw.setVisibility(8);
        }
    }
}
