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
    private TextView aKg;
    private HeadImageView bwO;
    private ShareFromFrsMsgData bwR;
    private Context context;
    private TextView crr;
    private TextView crs;
    private TextView crt;
    private TextView cru;

    public ShareFromFrsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        pU();
    }

    public ShareFromFrsView(Context context) {
        super(context);
        this.context = context;
        pU();
    }

    private void pU() {
        LayoutInflater.from(getContext()).inflate(t.h.share_from_frs_view, this);
        this.aKg = (TextView) findViewById(t.g.frs_name);
        this.bwO = (HeadImageView) findViewById(t.g.frs_img);
        this.crs = (TextView) findViewById(t.g.frs_member_num);
        this.cru = (TextView) findViewById(t.g.frs_post_num);
        this.crr = (TextView) findViewById(t.g.frs_member_num_label);
        this.crt = (TextView) findViewById(t.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aKg.setTextColor(getContext().getResources().getColor(t.d.cp_cont_b));
            this.crs.setTextColor(getContext().getResources().getColor(t.d.cp_cont_f));
            this.cru.setTextColor(getContext().getResources().getColor(t.d.cp_cont_f));
            this.crr.setTextColor(getContext().getResources().getColor(t.d.cp_cont_f));
            this.crt.setTextColor(getContext().getResources().getColor(t.d.cp_cont_f));
            return;
        }
        this.aKg.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
        this.crs.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
        this.cru.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
        this.crr.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
        this.crt.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bwR = shareFromFrsMsgData;
        xo();
    }

    private void xo() {
        this.aKg.setText(dD(this.bwR.getName()));
        this.bwO.setDefaultResource(t.f.icon_default_ba_120);
        this.bwO.setAutoChangeStyle(false);
        this.bwO.c(this.bwR.getImageUrl(), 10, false);
        this.crs.setText(ay.A(this.bwR.getMemberNum()));
        this.cru.setText(ay.A(this.bwR.getPostNum()));
    }

    private String dD(String str) {
        return String.valueOf(ay.j(str, 8)) + this.context.getString(t.j.forum);
    }
}
