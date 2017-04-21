package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private ShareFromFrsMsgData cgA;
    private HeadImageView cgx;
    private Context context;
    private TextView diD;
    private TextView diE;
    private TextView diF;
    private TextView diG;
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
        LayoutInflater.from(getContext()).inflate(w.j.share_from_frs_view, this);
        this.name = (TextView) findViewById(w.h.frs_name);
        this.cgx = (HeadImageView) findViewById(w.h.frs_img);
        this.diE = (TextView) findViewById(w.h.frs_member_num);
        this.diG = (TextView) findViewById(w.h.frs_post_num);
        this.diD = (TextView) findViewById(w.h.frs_member_num_label);
        this.diF = (TextView) findViewById(w.h.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.name.setTextColor(getContext().getResources().getColor(w.e.cp_cont_b));
            this.diE.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            this.diG.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            this.diD.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            this.diF.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            return;
        }
        this.name.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.diE.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.diG.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.diD.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.diF.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cgA = shareFromFrsMsgData;
        wU();
    }

    private void wU() {
        this.name.setText(dF(this.cgA.getName()));
        this.cgx.setDefaultResource(w.g.icon_default_ba_120);
        this.cgx.setAutoChangeStyle(false);
        this.cgx.c(this.cgA.getImageUrl(), 10, false);
        this.diE.setText(au.w(this.cgA.getMemberNum()));
        this.diG.setText(au.w(this.cgA.getPostNum()));
    }

    private String dF(String str) {
        return String.valueOf(au.j(str, 8)) + this.context.getString(w.l.forum);
    }
}
