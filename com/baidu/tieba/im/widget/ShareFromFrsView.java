package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private TextView bPV;
    private Context context;
    private HeadImageView ekN;
    private ShareFromFrsMsgData ekQ;
    private TextView fdM;
    private TextView fdN;
    private TextView fdO;
    private TextView fdP;

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
        LayoutInflater.from(getContext()).inflate(e.h.share_from_frs_view, this);
        this.bPV = (TextView) findViewById(e.g.frs_name);
        this.ekN = (HeadImageView) findViewById(e.g.frs_img);
        this.fdN = (TextView) findViewById(e.g.frs_member_num);
        this.fdP = (TextView) findViewById(e.g.frs_post_num);
        this.fdM = (TextView) findViewById(e.g.frs_member_num_label);
        this.fdO = (TextView) findViewById(e.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bPV.setTextColor(getContext().getResources().getColor(e.d.cp_cont_b));
            this.fdN.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.fdP.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.fdM.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.fdO.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            return;
        }
        this.bPV.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.fdN.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.fdP.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.fdM.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.fdO.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.ekQ = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.bPV.setText(ga(this.ekQ.getName()));
        this.ekN.setDefaultResource(e.f.icon_default_ba_120);
        this.ekN.setAutoChangeStyle(false);
        this.ekN.startLoad(this.ekQ.getImageUrl(), 10, false);
        this.fdN.setText(ao.V(this.ekQ.getMemberNum()));
        this.fdP.setText(ao.V(this.ekQ.getPostNum()));
    }

    private String ga(String str) {
        return ao.o(str, 8) + this.context.getString(e.j.forum);
    }
}
