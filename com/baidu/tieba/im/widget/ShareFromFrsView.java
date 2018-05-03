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
    private HeadImageView dtN;
    private ShareFromFrsMsgData dtQ;
    private TextView eiY;
    private TextView eiZ;
    private TextView eja;
    private TextView ejb;

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
        this.dtN = (HeadImageView) findViewById(d.g.frs_img);
        this.eiZ = (TextView) findViewById(d.g.frs_member_num);
        this.ejb = (TextView) findViewById(d.g.frs_post_num);
        this.eiY = (TextView) findViewById(d.g.frs_member_num_label);
        this.eja = (TextView) findViewById(d.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.blN.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_b));
            this.eiZ.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_f));
            this.ejb.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_f));
            this.eiY.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_f));
            this.eja.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_f));
            return;
        }
        this.blN.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
        this.eiZ.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
        this.ejb.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
        this.eiY.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
        this.eja.setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.dtQ = shareFromFrsMsgData;
        wL();
    }

    private void wL() {
        this.blN.setText(eo(this.dtQ.getName()));
        this.dtN.setDefaultResource(d.f.icon_default_ba_120);
        this.dtN.setAutoChangeStyle(false);
        this.dtN.startLoad(this.dtQ.getImageUrl(), 10, false);
        this.eiZ.setText(an.z(this.dtQ.getMemberNum()));
        this.ejb.setText(an.z(this.dtQ.getPostNum()));
    }

    private String eo(String str) {
        return an.j(str, 8) + this.context.getString(d.k.forum);
    }
}
