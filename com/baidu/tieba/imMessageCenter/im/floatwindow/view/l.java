package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class l {
    private TextView aGp;
    private TextView aLD;
    private TextView cbg;
    private TextView cvV;
    private int status;

    public l(View view) {
        this.aGp = (TextView) view.findViewById(t.g.floating_chat_name);
        this.cvV = (TextView) view.findViewById(t.g.floating_chat_distance);
        this.cbg = (TextView) view.findViewById(t.g.floating_chat_time);
        this.aLD = (TextView) view.findViewById(t.g.floating_chat_add_friend);
    }

    public void ke(String str) {
        this.aGp.setText(str);
    }

    public void jS(int i) {
        this.status = i;
        switch (i) {
            case 0:
                this.aLD.setClickable(true);
                this.aLD.setVisibility(0);
                this.aLD.setText(t.j.frs_recommend_friend_item_add);
                return;
            case 1:
            case 3:
                this.aLD.setVisibility(8);
                return;
            case 2:
                this.aLD.setVisibility(0);
                this.aLD.setText(t.j.waiting);
                this.aLD.setClickable(false);
                this.aLD.setBackgroundResource(t.d.transparent);
                this.aLD.setText(t.j.waiting);
                this.aLD.setTextColor(TbadkCoreApplication.m11getInst().getResources().getColor(t.d.cp_cont_d));
                return;
            case 4:
                this.aLD.setClickable(true);
                this.aLD.setVisibility(0);
                this.aLD.setText(t.j.add_friend_agree_button);
                return;
            default:
                return;
        }
    }

    public void q(View.OnClickListener onClickListener) {
        this.aLD.setOnClickListener(onClickListener);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.aGp.setText(str);
        if (bVar != null) {
            if (bVar.yX() < 0 || bVar.yX() > 1) {
                this.cvV.setVisibility(8);
                this.cbg.setVisibility(8);
                return;
            }
            this.cvV.setVisibility(0);
            this.cbg.setVisibility(0);
            this.cvV.setText(TbadkCoreApplication.m11getInst().getResources().getString(t.j.contact_yinshen));
            if (!StringUtils.isNull(bVar.getDistance()) && bVar.getTime() > 0) {
                this.cvV.setVisibility(0);
                this.cvV.setText(bVar.getDistance());
                this.cbg.setText(ay.w(bVar.getTime()));
                return;
            }
            this.cvV.setVisibility(8);
        }
    }
}
