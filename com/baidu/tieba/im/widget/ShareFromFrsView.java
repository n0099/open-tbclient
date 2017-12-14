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
    private TextView aWS;
    private Context context;
    private TextView dVZ;
    private TextView dWa;
    private TextView dWb;
    private TextView dWc;
    private HeadImageView ddR;
    private ShareFromFrsMsgData ddU;

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
        this.aWS = (TextView) findViewById(d.g.frs_name);
        this.ddR = (HeadImageView) findViewById(d.g.frs_img);
        this.dWa = (TextView) findViewById(d.g.frs_member_num);
        this.dWc = (TextView) findViewById(d.g.frs_post_num);
        this.dVZ = (TextView) findViewById(d.g.frs_member_num_label);
        this.dWb = (TextView) findViewById(d.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aWS.setTextColor(getContext().getResources().getColor(d.C0096d.cp_cont_b));
            this.dWa.setTextColor(getContext().getResources().getColor(d.C0096d.cp_cont_f));
            this.dWc.setTextColor(getContext().getResources().getColor(d.C0096d.cp_cont_f));
            this.dVZ.setTextColor(getContext().getResources().getColor(d.C0096d.cp_cont_f));
            this.dWb.setTextColor(getContext().getResources().getColor(d.C0096d.cp_cont_f));
            return;
        }
        this.aWS.setTextColor(getContext().getResources().getColor(d.C0096d.cp_cont_g));
        this.dWa.setTextColor(getContext().getResources().getColor(d.C0096d.cp_cont_g));
        this.dWc.setTextColor(getContext().getResources().getColor(d.C0096d.cp_cont_g));
        this.dVZ.setTextColor(getContext().getResources().getColor(d.C0096d.cp_cont_g));
        this.dWb.setTextColor(getContext().getResources().getColor(d.C0096d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.ddU = shareFromFrsMsgData;
        wp();
    }

    private void wp() {
        this.aWS.setText(dZ(this.ddU.getName()));
        this.ddR.setDefaultResource(d.f.icon_default_ba_120);
        this.ddR.setAutoChangeStyle(false);
        this.ddR.startLoad(this.ddU.getImageUrl(), 10, false);
        this.dWa.setText(am.y(this.ddU.getMemberNum()));
        this.dWc.setText(am.y(this.ddU.getPostNum()));
    }

    private String dZ(String str) {
        return am.j(str, 8) + this.context.getString(d.j.forum);
    }
}
