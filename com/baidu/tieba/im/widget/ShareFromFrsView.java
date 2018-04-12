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
    private TextView blN;
    private Context context;
    private HeadImageView dtQ;
    private ShareFromFrsMsgData dtT;
    private TextView ejb;
    private TextView ejc;
    private TextView ejd;
    private TextView eje;

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
        this.blN = (TextView) findViewById(d.g.frs_name);
        this.dtQ = (HeadImageView) findViewById(d.g.frs_img);
        this.ejc = (TextView) findViewById(d.g.frs_member_num);
        this.eje = (TextView) findViewById(d.g.frs_post_num);
        this.ejb = (TextView) findViewById(d.g.frs_member_num_label);
        this.ejd = (TextView) findViewById(d.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.blN.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_b));
            this.ejc.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_f));
            this.eje.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_f));
            this.ejb.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_f));
            this.ejd.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_f));
            return;
        }
        this.blN.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
        this.ejc.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
        this.eje.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
        this.ejb.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
        this.ejd.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.dtT = shareFromFrsMsgData;
        wL();
    }

    private void wL() {
        this.blN.setText(eo(this.dtT.getName()));
        this.dtQ.setDefaultResource(d.f.icon_default_ba_120);
        this.dtQ.setAutoChangeStyle(false);
        this.dtQ.startLoad(this.dtT.getImageUrl(), 10, false);
        this.ejc.setText(an.z(this.dtT.getMemberNum()));
        this.eje.setText(an.z(this.dtT.getPostNum()));
    }

    private String eo(String str) {
        return an.j(str, 8) + this.context.getString(d.k.forum);
    }
}
