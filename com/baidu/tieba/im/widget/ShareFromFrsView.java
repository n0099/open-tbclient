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
    private TextView bLb;
    private Context context;
    private HeadImageView dVo;
    private ShareFromFrsMsgData dVr;
    private TextView eKc;
    private TextView eKd;
    private TextView eKe;
    private TextView eKf;

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
        this.bLb = (TextView) findViewById(d.g.frs_name);
        this.dVo = (HeadImageView) findViewById(d.g.frs_img);
        this.eKd = (TextView) findViewById(d.g.frs_member_num);
        this.eKf = (TextView) findViewById(d.g.frs_post_num);
        this.eKc = (TextView) findViewById(d.g.frs_member_num_label);
        this.eKe = (TextView) findViewById(d.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bLb.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_b));
            this.eKd.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_f));
            this.eKf.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_f));
            this.eKc.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_f));
            this.eKe.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_f));
            return;
        }
        this.bLb.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_g));
        this.eKd.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_g));
        this.eKf.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_g));
        this.eKc.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_g));
        this.eKe.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.dVr = shareFromFrsMsgData;
        DG();
    }

    private void DG() {
        this.bLb.setText(ek(this.dVr.getName()));
        this.dVo.setDefaultResource(d.f.icon_default_ba_120);
        this.dVo.setAutoChangeStyle(false);
        this.dVo.startLoad(this.dVr.getImageUrl(), 10, false);
        this.eKd.setText(am.H(this.dVr.getMemberNum()));
        this.eKf.setText(am.H(this.dVr.getPostNum()));
    }

    private String ek(String str) {
        return am.k(str, 8) + this.context.getString(d.j.forum);
    }
}
