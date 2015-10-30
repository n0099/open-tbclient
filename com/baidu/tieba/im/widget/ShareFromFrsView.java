package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private TextView aDl;
    private TextView bIM;
    private TextView bIN;
    private TextView bIO;
    private TextView bIP;
    private HeadImageView bdI;
    private ShareFromFrsMsgData bdL;
    private Context context;

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
        LayoutInflater.from(getContext()).inflate(i.g.share_from_frs_view, this);
        this.aDl = (TextView) findViewById(i.f.frs_name);
        this.bdI = (HeadImageView) findViewById(i.f.frs_img);
        this.bIN = (TextView) findViewById(i.f.frs_member_num);
        this.bIP = (TextView) findViewById(i.f.frs_post_num);
        this.bIM = (TextView) findViewById(i.f.frs_member_num_label);
        this.bIO = (TextView) findViewById(i.f.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aDl.setTextColor(getContext().getResources().getColor(i.c.cp_cont_b));
            this.bIN.setTextColor(getContext().getResources().getColor(i.c.cp_cont_f));
            this.bIP.setTextColor(getContext().getResources().getColor(i.c.cp_cont_f));
            this.bIM.setTextColor(getContext().getResources().getColor(i.c.cp_cont_f));
            this.bIO.setTextColor(getContext().getResources().getColor(i.c.cp_cont_f));
            return;
        }
        this.aDl.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
        this.bIN.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
        this.bIP.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
        this.bIM.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
        this.bIO.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bdL = shareFromFrsMsgData;
        vt();
    }

    private void vt() {
        this.aDl.setText(dq(this.bdL.getName()));
        this.bdI.setDefaultResource(i.e.icon_default_ba_120);
        this.bdI.setAutoChangeStyle(false);
        this.bdI.d(this.bdL.getImageUrl(), 10, false);
        this.bIN.setText(as.q(this.bdL.getMemberNum()));
        this.bIP.setText(as.q(this.bdL.getPostNum()));
    }

    private String dq(String str) {
        return String.valueOf(as.i(str, 8)) + this.context.getString(i.h.forum);
    }
}
