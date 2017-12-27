package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private TextView bKL;
    private Context context;
    private HeadImageView dQf;
    private ShareFromFrsMsgData dQi;
    private TextView eIh;
    private TextView eIi;
    private TextView eIj;
    private TextView eIk;

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
        LayoutInflater.from(getContext()).inflate(d.h.share_from_frs_view, this);
        this.bKL = (TextView) findViewById(d.g.frs_name);
        this.dQf = (HeadImageView) findViewById(d.g.frs_img);
        this.eIi = (TextView) findViewById(d.g.frs_member_num);
        this.eIk = (TextView) findViewById(d.g.frs_post_num);
        this.eIh = (TextView) findViewById(d.g.frs_member_num_label);
        this.eIj = (TextView) findViewById(d.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bKL.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_b));
            this.eIi.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_f));
            this.eIk.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_f));
            this.eIh.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_f));
            this.eIj.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_f));
            return;
        }
        this.bKL.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_g));
        this.eIi.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_g));
        this.eIk.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_g));
        this.eIh.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_g));
        this.eIj.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.dQi = shareFromFrsMsgData;
        DN();
    }

    private void DN() {
        this.bKL.setText(eg(this.dQi.getName()));
        this.dQf.setDefaultResource(d.f.icon_default_ba_120);
        this.dQf.setAutoChangeStyle(false);
        this.dQf.startLoad(this.dQi.getImageUrl(), 10, false);
        this.eIi.setText(am.G(this.dQi.getMemberNum()));
        this.eIk.setText(am.G(this.dQi.getPostNum()));
    }

    private String eg(String str) {
        return am.k(str, 8) + this.context.getString(d.j.forum);
    }
}
