package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private TextView bmc;
    private Context context;
    private HeadImageView duV;
    private ShareFromFrsMsgData duY;
    private TextView ekf;
    private TextView ekg;
    private TextView ekh;
    private TextView eki;

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
        this.bmc = (TextView) findViewById(d.g.frs_name);
        this.duV = (HeadImageView) findViewById(d.g.frs_img);
        this.ekg = (TextView) findViewById(d.g.frs_member_num);
        this.eki = (TextView) findViewById(d.g.frs_post_num);
        this.ekf = (TextView) findViewById(d.g.frs_member_num_label);
        this.ekh = (TextView) findViewById(d.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bmc.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_b));
            this.ekg.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_f));
            this.eki.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_f));
            this.ekf.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_f));
            this.ekh.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_f));
            return;
        }
        this.bmc.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
        this.ekg.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
        this.eki.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
        this.ekf.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
        this.ekh.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.duY = shareFromFrsMsgData;
        wK();
    }

    private void wK() {
        this.bmc.setText(eo(this.duY.getName()));
        this.duV.setDefaultResource(d.f.icon_default_ba_120);
        this.duV.setAutoChangeStyle(false);
        this.duV.startLoad(this.duY.getImageUrl(), 10, false);
        this.ekg.setText(an.z(this.duY.getMemberNum()));
        this.eki.setText(an.z(this.duY.getPostNum()));
    }

    private String eo(String str) {
        return an.j(str, 8) + this.context.getString(d.k.forum);
    }
}
