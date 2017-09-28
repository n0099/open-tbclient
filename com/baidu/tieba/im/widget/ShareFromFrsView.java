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
    private HeadImageView cKi;
    private ShareFromFrsMsgData cKl;
    private Context context;
    private TextView dFB;
    private TextView dFC;
    private TextView dFD;
    private TextView dFE;
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
        LayoutInflater.from(getContext()).inflate(d.j.share_from_frs_view, this);
        this.name = (TextView) findViewById(d.h.frs_name);
        this.cKi = (HeadImageView) findViewById(d.h.frs_img);
        this.dFC = (TextView) findViewById(d.h.frs_member_num);
        this.dFE = (TextView) findViewById(d.h.frs_post_num);
        this.dFB = (TextView) findViewById(d.h.frs_member_num_label);
        this.dFD = (TextView) findViewById(d.h.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.name.setTextColor(getContext().getResources().getColor(d.e.cp_cont_b));
            this.dFC.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dFE.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dFB.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dFD.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            return;
        }
        this.name.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dFC.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dFE.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dFB.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dFD.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cKl = shareFromFrsMsgData;
        wn();
    }

    private void wn() {
        this.name.setText(dS(this.cKl.getName()));
        this.cKi.setDefaultResource(d.g.icon_default_ba_120);
        this.cKi.setAutoChangeStyle(false);
        this.cKi.c(this.cKl.getImageUrl(), 10, false);
        this.dFC.setText(am.x(this.cKl.getMemberNum()));
        this.dFE.setText(am.x(this.cKl.getPostNum()));
    }

    private String dS(String str) {
        return am.j(str, 8) + this.context.getString(d.l.forum);
    }
}
