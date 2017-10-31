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
    private TextView aTH;
    private HeadImageView cTi;
    private ShareFromFrsMsgData cTl;
    private Context context;
    private TextView dNb;
    private TextView dNc;
    private TextView dNd;
    private TextView dNe;

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
        this.aTH = (TextView) findViewById(d.g.frs_name);
        this.cTi = (HeadImageView) findViewById(d.g.frs_img);
        this.dNc = (TextView) findViewById(d.g.frs_member_num);
        this.dNe = (TextView) findViewById(d.g.frs_post_num);
        this.dNb = (TextView) findViewById(d.g.frs_member_num_label);
        this.dNd = (TextView) findViewById(d.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aTH.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_b));
            this.dNc.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_f));
            this.dNe.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_f));
            this.dNb.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_f));
            this.dNd.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_f));
            return;
        }
        this.aTH.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_g));
        this.dNc.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_g));
        this.dNe.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_g));
        this.dNb.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_g));
        this.dNd.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cTl = shareFromFrsMsgData;
        wn();
    }

    private void wn() {
        this.aTH.setText(dX(this.cTl.getName()));
        this.cTi.setDefaultResource(d.f.icon_default_ba_120);
        this.cTi.setAutoChangeStyle(false);
        this.cTi.startLoad(this.cTl.getImageUrl(), 10, false);
        this.dNc.setText(am.y(this.cTl.getMemberNum()));
        this.dNe.setText(am.y(this.cTl.getPostNum()));
    }

    private String dX(String str) {
        return am.j(str, 8) + this.context.getString(d.j.forum);
    }
}
