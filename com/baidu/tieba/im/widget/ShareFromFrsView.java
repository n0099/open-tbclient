package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private TextView aHI;
    private HeadImageView bWg;
    private ShareFromFrsMsgData bWj;
    private Context context;
    private TextView daA;
    private TextView daB;
    private TextView daC;
    private TextView daD;

    public ShareFromFrsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        initUI();
    }

    public ShareFromFrsView(Context context) {
        super(context);
        this.context = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(u.h.share_from_frs_view, this);
        this.aHI = (TextView) findViewById(u.g.frs_name);
        this.bWg = (HeadImageView) findViewById(u.g.frs_img);
        this.daB = (TextView) findViewById(u.g.frs_member_num);
        this.daD = (TextView) findViewById(u.g.frs_post_num);
        this.daA = (TextView) findViewById(u.g.frs_member_num_label);
        this.daC = (TextView) findViewById(u.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aHI.setTextColor(getContext().getResources().getColor(u.d.cp_cont_b));
            this.daB.setTextColor(getContext().getResources().getColor(u.d.cp_cont_f));
            this.daD.setTextColor(getContext().getResources().getColor(u.d.cp_cont_f));
            this.daA.setTextColor(getContext().getResources().getColor(u.d.cp_cont_f));
            this.daC.setTextColor(getContext().getResources().getColor(u.d.cp_cont_f));
            return;
        }
        this.aHI.setTextColor(getContext().getResources().getColor(u.d.cp_cont_g));
        this.daB.setTextColor(getContext().getResources().getColor(u.d.cp_cont_g));
        this.daD.setTextColor(getContext().getResources().getColor(u.d.cp_cont_g));
        this.daA.setTextColor(getContext().getResources().getColor(u.d.cp_cont_g));
        this.daC.setTextColor(getContext().getResources().getColor(u.d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bWj = shareFromFrsMsgData;
        uY();
    }

    private void uY() {
        this.aHI.setText(dC(this.bWj.getName()));
        this.bWg.setDefaultResource(u.f.icon_default_ba_120);
        this.bWg.setAutoChangeStyle(false);
        this.bWg.c(this.bWj.getImageUrl(), 10, false);
        this.daB.setText(ba.y(this.bWj.getMemberNum()));
        this.daD.setText(ba.y(this.bWj.getPostNum()));
    }

    private String dC(String str) {
        return String.valueOf(ba.j(str, 8)) + this.context.getString(u.j.forum);
    }
}
