package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private TextView aGp;
    private HeadImageView bwA;
    private ShareFromFrsMsgData bwD;
    private Context context;
    private TextView cso;
    private TextView csp;
    private TextView csq;
    private TextView csr;

    public ShareFromFrsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        nq();
    }

    public ShareFromFrsView(Context context) {
        super(context);
        this.context = context;
        nq();
    }

    private void nq() {
        LayoutInflater.from(getContext()).inflate(t.h.share_from_frs_view, this);
        this.aGp = (TextView) findViewById(t.g.frs_name);
        this.bwA = (HeadImageView) findViewById(t.g.frs_img);
        this.csp = (TextView) findViewById(t.g.frs_member_num);
        this.csr = (TextView) findViewById(t.g.frs_post_num);
        this.cso = (TextView) findViewById(t.g.frs_member_num_label);
        this.csq = (TextView) findViewById(t.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aGp.setTextColor(getContext().getResources().getColor(t.d.cp_cont_b));
            this.csp.setTextColor(getContext().getResources().getColor(t.d.cp_cont_f));
            this.csr.setTextColor(getContext().getResources().getColor(t.d.cp_cont_f));
            this.cso.setTextColor(getContext().getResources().getColor(t.d.cp_cont_f));
            this.csq.setTextColor(getContext().getResources().getColor(t.d.cp_cont_f));
            return;
        }
        this.aGp.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
        this.csp.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
        this.csr.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
        this.cso.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
        this.csq.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bwD = shareFromFrsMsgData;
        uY();
    }

    private void uY() {
        this.aGp.setText(dA(this.bwD.getName()));
        this.bwA.setDefaultResource(t.f.icon_default_ba_120);
        this.bwA.setAutoChangeStyle(false);
        this.bwA.c(this.bwD.getImageUrl(), 10, false);
        this.csp.setText(ay.B(this.bwD.getMemberNum()));
        this.csr.setText(ay.B(this.bwD.getPostNum()));
    }

    private String dA(String str) {
        return String.valueOf(ay.j(str, 8)) + this.context.getString(t.j.forum);
    }
}
