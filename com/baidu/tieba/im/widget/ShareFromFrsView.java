package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private TextView aDa;
    private TextView bIB;
    private TextView bIC;
    private TextView bID;
    private TextView bIE;
    private ShareFromFrsMsgData bdA;
    private HeadImageView bdx;
    private Context context;

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
        LayoutInflater.from(getContext()).inflate(i.g.share_from_frs_view, this);
        this.aDa = (TextView) findViewById(i.f.frs_name);
        this.bdx = (HeadImageView) findViewById(i.f.frs_img);
        this.bIC = (TextView) findViewById(i.f.frs_member_num);
        this.bIE = (TextView) findViewById(i.f.frs_post_num);
        this.bIB = (TextView) findViewById(i.f.frs_member_num_label);
        this.bID = (TextView) findViewById(i.f.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aDa.setTextColor(getContext().getResources().getColor(i.c.cp_cont_b));
            this.bIC.setTextColor(getContext().getResources().getColor(i.c.cp_cont_f));
            this.bIE.setTextColor(getContext().getResources().getColor(i.c.cp_cont_f));
            this.bIB.setTextColor(getContext().getResources().getColor(i.c.cp_cont_f));
            this.bID.setTextColor(getContext().getResources().getColor(i.c.cp_cont_f));
            return;
        }
        this.aDa.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
        this.bIC.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
        this.bIE.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
        this.bIB.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
        this.bID.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bdA = shareFromFrsMsgData;
        vw();
    }

    private void vw() {
        this.aDa.setText(dp(this.bdA.getName()));
        this.bdx.setDefaultResource(i.e.icon_default_ba_120);
        this.bdx.setAutoChangeStyle(false);
        this.bdx.d(this.bdA.getImageUrl(), 10, false);
        this.bIC.setText(ar.s(this.bdA.getMemberNum()));
        this.bIE.setText(ar.s(this.bdA.getPostNum()));
    }

    private String dp(String str) {
        return String.valueOf(ar.i(str, 8)) + this.context.getString(i.h.forum);
    }
}
