package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private TextView aKH;
    private HeadImageView bRF;
    private ShareFromFrsMsgData bRI;
    private TextView cYh;
    private TextView cYi;
    private TextView cYj;
    private TextView cYk;
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
        LayoutInflater.from(getContext()).inflate(r.h.share_from_frs_view, this);
        this.aKH = (TextView) findViewById(r.g.frs_name);
        this.bRF = (HeadImageView) findViewById(r.g.frs_img);
        this.cYi = (TextView) findViewById(r.g.frs_member_num);
        this.cYk = (TextView) findViewById(r.g.frs_post_num);
        this.cYh = (TextView) findViewById(r.g.frs_member_num_label);
        this.cYj = (TextView) findViewById(r.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aKH.setTextColor(getContext().getResources().getColor(r.d.cp_cont_b));
            this.cYi.setTextColor(getContext().getResources().getColor(r.d.cp_cont_f));
            this.cYk.setTextColor(getContext().getResources().getColor(r.d.cp_cont_f));
            this.cYh.setTextColor(getContext().getResources().getColor(r.d.cp_cont_f));
            this.cYj.setTextColor(getContext().getResources().getColor(r.d.cp_cont_f));
            return;
        }
        this.aKH.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
        this.cYi.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
        this.cYk.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
        this.cYh.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
        this.cYj.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bRI = shareFromFrsMsgData;
        wg();
    }

    private void wg() {
        this.aKH.setText(dH(this.bRI.getName()));
        this.bRF.setDefaultResource(r.f.icon_default_ba_120);
        this.bRF.setAutoChangeStyle(false);
        this.bRF.c(this.bRI.getImageUrl(), 10, false);
        this.cYi.setText(av.y(this.bRI.getMemberNum()));
        this.cYk.setText(av.y(this.bRI.getPostNum()));
    }

    private String dH(String str) {
        return String.valueOf(av.j(str, 8)) + this.context.getString(r.j.forum);
    }
}
