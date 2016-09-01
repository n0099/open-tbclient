package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private TextView aKZ;
    private HeadImageView chq;
    private ShareFromFrsMsgData cht;
    private Context context;
    private TextView dmh;
    private TextView dmi;
    private TextView dmj;
    private TextView dmk;

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
        LayoutInflater.from(getContext()).inflate(t.h.share_from_frs_view, this);
        this.aKZ = (TextView) findViewById(t.g.frs_name);
        this.chq = (HeadImageView) findViewById(t.g.frs_img);
        this.dmi = (TextView) findViewById(t.g.frs_member_num);
        this.dmk = (TextView) findViewById(t.g.frs_post_num);
        this.dmh = (TextView) findViewById(t.g.frs_member_num_label);
        this.dmj = (TextView) findViewById(t.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aKZ.setTextColor(getContext().getResources().getColor(t.d.cp_cont_b));
            this.dmi.setTextColor(getContext().getResources().getColor(t.d.cp_cont_f));
            this.dmk.setTextColor(getContext().getResources().getColor(t.d.cp_cont_f));
            this.dmh.setTextColor(getContext().getResources().getColor(t.d.cp_cont_f));
            this.dmj.setTextColor(getContext().getResources().getColor(t.d.cp_cont_f));
            return;
        }
        this.aKZ.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
        this.dmi.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
        this.dmk.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
        this.dmh.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
        this.dmj.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cht = shareFromFrsMsgData;
        wc();
    }

    private void wc() {
        this.aKZ.setText(dE(this.cht.getName()));
        this.chq.setDefaultResource(t.f.icon_default_ba_120);
        this.chq.setAutoChangeStyle(false);
        this.chq.c(this.cht.getImageUrl(), 10, false);
        this.dmi.setText(ba.y(this.cht.getMemberNum()));
        this.dmk.setText(ba.y(this.cht.getPostNum()));
    }

    private String dE(String str) {
        return String.valueOf(ba.j(str, 8)) + this.context.getString(t.j.forum);
    }
}
