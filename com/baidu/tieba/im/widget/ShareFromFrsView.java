package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private TextView bvD;
    private Context context;
    private HeadImageView dHD;
    private ShareFromFrsMsgData dHG;
    private TextView ezn;
    private TextView ezo;
    private TextView ezp;
    private TextView ezq;

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
        LayoutInflater.from(getContext()).inflate(d.i.share_from_frs_view, this);
        this.bvD = (TextView) findViewById(d.g.frs_name);
        this.dHD = (HeadImageView) findViewById(d.g.frs_img);
        this.ezo = (TextView) findViewById(d.g.frs_member_num);
        this.ezq = (TextView) findViewById(d.g.frs_post_num);
        this.ezn = (TextView) findViewById(d.g.frs_member_num_label);
        this.ezp = (TextView) findViewById(d.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bvD.setTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_b));
            this.ezo.setTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_f));
            this.ezq.setTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_f));
            this.ezn.setTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_f));
            this.ezp.setTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_f));
            return;
        }
        this.bvD.setTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_g));
        this.ezo.setTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_g));
        this.ezq.setTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_g));
        this.ezn.setTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_g));
        this.ezp.setTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.dHG = shareFromFrsMsgData;
        AB();
    }

    private void AB() {
        this.bvD.setText(eQ(this.dHG.getName()));
        this.dHD.setDefaultResource(d.f.icon_default_ba_120);
        this.dHD.setAutoChangeStyle(false);
        this.dHD.startLoad(this.dHG.getImageUrl(), 10, false);
        this.ezo.setText(ap.D(this.dHG.getMemberNum()));
        this.ezq.setText(ap.D(this.dHG.getPostNum()));
    }

    private String eQ(String str) {
        return ap.j(str, 8) + this.context.getString(d.k.forum);
    }
}
