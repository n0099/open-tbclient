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
    private TextView aWW;
    private Context context;
    private TextView dWd;
    private TextView dWe;
    private TextView dWf;
    private TextView dWg;
    private HeadImageView ddV;
    private ShareFromFrsMsgData ddY;

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
        this.aWW = (TextView) findViewById(d.g.frs_name);
        this.ddV = (HeadImageView) findViewById(d.g.frs_img);
        this.dWe = (TextView) findViewById(d.g.frs_member_num);
        this.dWg = (TextView) findViewById(d.g.frs_post_num);
        this.dWd = (TextView) findViewById(d.g.frs_member_num_label);
        this.dWf = (TextView) findViewById(d.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aWW.setTextColor(getContext().getResources().getColor(d.C0095d.cp_cont_b));
            this.dWe.setTextColor(getContext().getResources().getColor(d.C0095d.cp_cont_f));
            this.dWg.setTextColor(getContext().getResources().getColor(d.C0095d.cp_cont_f));
            this.dWd.setTextColor(getContext().getResources().getColor(d.C0095d.cp_cont_f));
            this.dWf.setTextColor(getContext().getResources().getColor(d.C0095d.cp_cont_f));
            return;
        }
        this.aWW.setTextColor(getContext().getResources().getColor(d.C0095d.cp_cont_g));
        this.dWe.setTextColor(getContext().getResources().getColor(d.C0095d.cp_cont_g));
        this.dWg.setTextColor(getContext().getResources().getColor(d.C0095d.cp_cont_g));
        this.dWd.setTextColor(getContext().getResources().getColor(d.C0095d.cp_cont_g));
        this.dWf.setTextColor(getContext().getResources().getColor(d.C0095d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.ddY = shareFromFrsMsgData;
        wp();
    }

    private void wp() {
        this.aWW.setText(dZ(this.ddY.getName()));
        this.ddV.setDefaultResource(d.f.icon_default_ba_120);
        this.ddV.setAutoChangeStyle(false);
        this.ddV.startLoad(this.ddY.getImageUrl(), 10, false);
        this.dWe.setText(am.y(this.ddY.getMemberNum()));
        this.dWg.setText(am.y(this.ddY.getPostNum()));
    }

    private String dZ(String str) {
        return am.j(str, 8) + this.context.getString(d.j.forum);
    }
}
