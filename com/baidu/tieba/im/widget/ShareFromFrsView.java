package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private HeadImageView cCi;
    private ShareFromFrsMsgData cCl;
    private Context context;
    private TextView dBO;
    private TextView dBP;
    private TextView dBQ;
    private TextView dBR;
    private TextView name;

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
        LayoutInflater.from(getContext()).inflate(d.j.share_from_frs_view, this);
        this.name = (TextView) findViewById(d.h.frs_name);
        this.cCi = (HeadImageView) findViewById(d.h.frs_img);
        this.dBP = (TextView) findViewById(d.h.frs_member_num);
        this.dBR = (TextView) findViewById(d.h.frs_post_num);
        this.dBO = (TextView) findViewById(d.h.frs_member_num_label);
        this.dBQ = (TextView) findViewById(d.h.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.name.setTextColor(getContext().getResources().getColor(d.e.cp_cont_b));
            this.dBP.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dBR.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dBO.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dBQ.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            return;
        }
        this.name.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dBP.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dBR.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dBO.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dBQ.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cCl = shareFromFrsMsgData;
        wQ();
    }

    private void wQ() {
        this.name.setText(eh(this.cCl.getName()));
        this.cCi.setDefaultResource(d.g.icon_default_ba_120);
        this.cCi.setAutoChangeStyle(false);
        this.cCi.c(this.cCl.getImageUrl(), 10, false);
        this.dBP.setText(al.z(this.cCl.getMemberNum()));
        this.dBR.setText(al.z(this.cCl.getPostNum()));
    }

    private String eh(String str) {
        return al.j(str, 8) + this.context.getString(d.l.forum);
    }
}
