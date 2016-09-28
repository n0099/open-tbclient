package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private TextView aKy;
    private HeadImageView cho;
    private ShareFromFrsMsgData chr;
    private Context context;
    private TextView dnE;
    private TextView dnF;
    private TextView dnG;
    private TextView dnH;

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
        this.aKy = (TextView) findViewById(r.g.frs_name);
        this.cho = (HeadImageView) findViewById(r.g.frs_img);
        this.dnF = (TextView) findViewById(r.g.frs_member_num);
        this.dnH = (TextView) findViewById(r.g.frs_post_num);
        this.dnE = (TextView) findViewById(r.g.frs_member_num_label);
        this.dnG = (TextView) findViewById(r.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aKy.setTextColor(getContext().getResources().getColor(r.d.cp_cont_b));
            this.dnF.setTextColor(getContext().getResources().getColor(r.d.cp_cont_f));
            this.dnH.setTextColor(getContext().getResources().getColor(r.d.cp_cont_f));
            this.dnE.setTextColor(getContext().getResources().getColor(r.d.cp_cont_f));
            this.dnG.setTextColor(getContext().getResources().getColor(r.d.cp_cont_f));
            return;
        }
        this.aKy.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
        this.dnF.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
        this.dnH.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
        this.dnE.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
        this.dnG.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.chr = shareFromFrsMsgData;
        ws();
    }

    private void ws() {
        this.aKy.setText(dH(this.chr.getName()));
        this.cho.setDefaultResource(r.f.icon_default_ba_120);
        this.cho.setAutoChangeStyle(false);
        this.cho.c(this.chr.getImageUrl(), 10, false);
        this.dnF.setText(az.z(this.chr.getMemberNum()));
        this.dnH.setText(az.z(this.chr.getPostNum()));
    }

    private String dH(String str) {
        return String.valueOf(az.j(str, 8)) + this.context.getString(r.j.forum);
    }
}
