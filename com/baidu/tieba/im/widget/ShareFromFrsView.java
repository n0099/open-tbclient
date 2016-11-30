package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private TextView aLq;
    private HeadImageView cmv;
    private ShareFromFrsMsgData cmy;
    private Context context;
    private TextView dtn;
    private TextView dto;
    private TextView dtp;
    private TextView dtq;

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
        this.aLq = (TextView) findViewById(r.g.frs_name);
        this.cmv = (HeadImageView) findViewById(r.g.frs_img);
        this.dto = (TextView) findViewById(r.g.frs_member_num);
        this.dtq = (TextView) findViewById(r.g.frs_post_num);
        this.dtn = (TextView) findViewById(r.g.frs_member_num_label);
        this.dtp = (TextView) findViewById(r.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aLq.setTextColor(getContext().getResources().getColor(r.d.cp_cont_b));
            this.dto.setTextColor(getContext().getResources().getColor(r.d.cp_cont_f));
            this.dtq.setTextColor(getContext().getResources().getColor(r.d.cp_cont_f));
            this.dtn.setTextColor(getContext().getResources().getColor(r.d.cp_cont_f));
            this.dtp.setTextColor(getContext().getResources().getColor(r.d.cp_cont_f));
            return;
        }
        this.aLq.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
        this.dto.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
        this.dtq.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
        this.dtn.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
        this.dtp.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cmy = shareFromFrsMsgData;
        ww();
    }

    private void ww() {
        this.aLq.setText(dJ(this.cmy.getName()));
        this.cmv.setDefaultResource(r.f.icon_default_ba_120);
        this.cmv.setAutoChangeStyle(false);
        this.cmv.c(this.cmy.getImageUrl(), 10, false);
        this.dto.setText(ax.y(this.cmy.getMemberNum()));
        this.dtq.setText(ax.y(this.cmy.getPostNum()));
    }

    private String dJ(String str) {
        return String.valueOf(ax.j(str, 8)) + this.context.getString(r.j.forum);
    }
}
