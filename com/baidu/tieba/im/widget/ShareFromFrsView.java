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
    private TextView aWQ;
    private Context context;
    private TextView dUU;
    private TextView dUV;
    private TextView dUW;
    private TextView dUX;
    private HeadImageView dcK;
    private ShareFromFrsMsgData dcN;

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
        this.aWQ = (TextView) findViewById(d.g.frs_name);
        this.dcK = (HeadImageView) findViewById(d.g.frs_img);
        this.dUV = (TextView) findViewById(d.g.frs_member_num);
        this.dUX = (TextView) findViewById(d.g.frs_post_num);
        this.dUU = (TextView) findViewById(d.g.frs_member_num_label);
        this.dUW = (TextView) findViewById(d.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aWQ.setTextColor(getContext().getResources().getColor(d.C0082d.cp_cont_b));
            this.dUV.setTextColor(getContext().getResources().getColor(d.C0082d.cp_cont_f));
            this.dUX.setTextColor(getContext().getResources().getColor(d.C0082d.cp_cont_f));
            this.dUU.setTextColor(getContext().getResources().getColor(d.C0082d.cp_cont_f));
            this.dUW.setTextColor(getContext().getResources().getColor(d.C0082d.cp_cont_f));
            return;
        }
        this.aWQ.setTextColor(getContext().getResources().getColor(d.C0082d.cp_cont_g));
        this.dUV.setTextColor(getContext().getResources().getColor(d.C0082d.cp_cont_g));
        this.dUX.setTextColor(getContext().getResources().getColor(d.C0082d.cp_cont_g));
        this.dUU.setTextColor(getContext().getResources().getColor(d.C0082d.cp_cont_g));
        this.dUW.setTextColor(getContext().getResources().getColor(d.C0082d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.dcN = shareFromFrsMsgData;
        wr();
    }

    private void wr() {
        this.aWQ.setText(dZ(this.dcN.getName()));
        this.dcK.setDefaultResource(d.f.icon_default_ba_120);
        this.dcK.setAutoChangeStyle(false);
        this.dcK.startLoad(this.dcN.getImageUrl(), 10, false);
        this.dUV.setText(am.y(this.dcN.getMemberNum()));
        this.dUX.setText(am.y(this.dcN.getPostNum()));
    }

    private String dZ(String str) {
        return am.j(str, 8) + this.context.getString(d.j.forum);
    }
}
