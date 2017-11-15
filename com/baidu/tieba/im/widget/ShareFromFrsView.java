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
    private TextView aTP;
    private HeadImageView cTC;
    private ShareFromFrsMsgData cTF;
    private Context context;
    private TextView dNg;
    private TextView dNh;
    private TextView dNi;
    private TextView dNj;

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
        this.aTP = (TextView) findViewById(d.g.frs_name);
        this.cTC = (HeadImageView) findViewById(d.g.frs_img);
        this.dNh = (TextView) findViewById(d.g.frs_member_num);
        this.dNj = (TextView) findViewById(d.g.frs_post_num);
        this.dNg = (TextView) findViewById(d.g.frs_member_num_label);
        this.dNi = (TextView) findViewById(d.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aTP.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_b));
            this.dNh.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_f));
            this.dNj.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_f));
            this.dNg.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_f));
            this.dNi.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_f));
            return;
        }
        this.aTP.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_g));
        this.dNh.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_g));
        this.dNj.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_g));
        this.dNg.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_g));
        this.dNi.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cTF = shareFromFrsMsgData;
        wn();
    }

    private void wn() {
        this.aTP.setText(dX(this.cTF.getName()));
        this.cTC.setDefaultResource(d.f.icon_default_ba_120);
        this.cTC.setAutoChangeStyle(false);
        this.cTC.startLoad(this.cTF.getImageUrl(), 10, false);
        this.dNh.setText(am.y(this.cTF.getMemberNum()));
        this.dNj.setText(am.y(this.cTF.getPostNum()));
    }

    private String dX(String str) {
        return am.j(str, 8) + this.context.getString(d.j.forum);
    }
}
