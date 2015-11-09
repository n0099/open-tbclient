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
    private TextView aCf;
    private TextView bJh;
    private TextView bJi;
    private TextView bJj;
    private TextView bJk;
    private HeadImageView ben;
    private ShareFromFrsMsgData beq;
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
        this.aCf = (TextView) findViewById(i.f.frs_name);
        this.ben = (HeadImageView) findViewById(i.f.frs_img);
        this.bJi = (TextView) findViewById(i.f.frs_member_num);
        this.bJk = (TextView) findViewById(i.f.frs_post_num);
        this.bJh = (TextView) findViewById(i.f.frs_member_num_label);
        this.bJj = (TextView) findViewById(i.f.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aCf.setTextColor(getContext().getResources().getColor(i.c.cp_cont_b));
            this.bJi.setTextColor(getContext().getResources().getColor(i.c.cp_cont_f));
            this.bJk.setTextColor(getContext().getResources().getColor(i.c.cp_cont_f));
            this.bJh.setTextColor(getContext().getResources().getColor(i.c.cp_cont_f));
            this.bJj.setTextColor(getContext().getResources().getColor(i.c.cp_cont_f));
            return;
        }
        this.aCf.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
        this.bJi.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
        this.bJk.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
        this.bJh.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
        this.bJj.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.beq = shareFromFrsMsgData;
        vx();
    }

    private void vx() {
        this.aCf.setText(dq(this.beq.getName()));
        this.ben.setDefaultResource(i.e.icon_default_ba_120);
        this.ben.setAutoChangeStyle(false);
        this.ben.d(this.beq.getImageUrl(), 10, false);
        this.bJi.setText(as.q(this.beq.getMemberNum()));
        this.bJk.setText(as.q(this.beq.getPostNum()));
    }

    private String dq(String str) {
        return String.valueOf(as.i(str, 8)) + this.context.getString(i.h.forum);
    }
}
