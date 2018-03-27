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
    private TextView bMV;
    private Context context;
    private HeadImageView dZh;
    private ShareFromFrsMsgData dZk;
    private TextView eOv;
    private TextView eOw;
    private TextView eOx;
    private TextView eOy;

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
        this.bMV = (TextView) findViewById(d.g.frs_name);
        this.dZh = (HeadImageView) findViewById(d.g.frs_img);
        this.eOw = (TextView) findViewById(d.g.frs_member_num);
        this.eOy = (TextView) findViewById(d.g.frs_post_num);
        this.eOv = (TextView) findViewById(d.g.frs_member_num_label);
        this.eOx = (TextView) findViewById(d.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bMV.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_b));
            this.eOw.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_f));
            this.eOy.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_f));
            this.eOv.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_f));
            this.eOx.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_f));
            return;
        }
        this.bMV.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_g));
        this.eOw.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_g));
        this.eOy.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_g));
        this.eOv.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_g));
        this.eOx.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.dZk = shareFromFrsMsgData;
        Ea();
    }

    private void Ea() {
        this.bMV.setText(ew(this.dZk.getName()));
        this.dZh.setDefaultResource(d.f.icon_default_ba_120);
        this.dZh.setAutoChangeStyle(false);
        this.dZh.startLoad(this.dZk.getImageUrl(), 10, false);
        this.eOw.setText(am.H(this.dZk.getMemberNum()));
        this.eOy.setText(am.H(this.dZk.getPostNum()));
    }

    private String ew(String str) {
        return am.k(str, 8) + this.context.getString(d.j.forum);
    }
}
