package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private TextView aGR;
    private HeadImageView bUg;
    private ShareFromFrsMsgData bUj;
    private TextView cXD;
    private TextView cXE;
    private TextView cXF;
    private TextView cXG;
    private Context context;

    public ShareFromFrsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        nl();
    }

    public ShareFromFrsView(Context context) {
        super(context);
        this.context = context;
        nl();
    }

    private void nl() {
        LayoutInflater.from(getContext()).inflate(u.h.share_from_frs_view, this);
        this.aGR = (TextView) findViewById(u.g.frs_name);
        this.bUg = (HeadImageView) findViewById(u.g.frs_img);
        this.cXE = (TextView) findViewById(u.g.frs_member_num);
        this.cXG = (TextView) findViewById(u.g.frs_post_num);
        this.cXD = (TextView) findViewById(u.g.frs_member_num_label);
        this.cXF = (TextView) findViewById(u.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aGR.setTextColor(getContext().getResources().getColor(u.d.cp_cont_b));
            this.cXE.setTextColor(getContext().getResources().getColor(u.d.cp_cont_f));
            this.cXG.setTextColor(getContext().getResources().getColor(u.d.cp_cont_f));
            this.cXD.setTextColor(getContext().getResources().getColor(u.d.cp_cont_f));
            this.cXF.setTextColor(getContext().getResources().getColor(u.d.cp_cont_f));
            return;
        }
        this.aGR.setTextColor(getContext().getResources().getColor(u.d.cp_cont_g));
        this.cXE.setTextColor(getContext().getResources().getColor(u.d.cp_cont_g));
        this.cXG.setTextColor(getContext().getResources().getColor(u.d.cp_cont_g));
        this.cXD.setTextColor(getContext().getResources().getColor(u.d.cp_cont_g));
        this.cXF.setTextColor(getContext().getResources().getColor(u.d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bUj = shareFromFrsMsgData;
        uY();
    }

    private void uY() {
        this.aGR.setText(dD(this.bUj.getName()));
        this.bUg.setDefaultResource(u.f.icon_default_ba_120);
        this.bUg.setAutoChangeStyle(false);
        this.bUg.c(this.bUj.getImageUrl(), 10, false);
        this.cXE.setText(ba.D(this.bUj.getMemberNum()));
        this.cXG.setText(ba.D(this.bUj.getPostNum()));
    }

    private String dD(String str) {
        return String.valueOf(ba.j(str, 8)) + this.context.getString(u.j.forum);
    }
}
