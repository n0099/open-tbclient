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
    private TextView bPW;
    private Context context;
    private HeadImageView ekO;
    private ShareFromFrsMsgData ekR;
    private TextView fdN;
    private TextView fdO;
    private TextView fdP;
    private TextView fdQ;

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
        this.bPW = (TextView) findViewById(e.g.frs_name);
        this.ekO = (HeadImageView) findViewById(e.g.frs_img);
        this.fdO = (TextView) findViewById(e.g.frs_member_num);
        this.fdQ = (TextView) findViewById(e.g.frs_post_num);
        this.fdN = (TextView) findViewById(e.g.frs_member_num_label);
        this.fdP = (TextView) findViewById(e.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bPW.setTextColor(getContext().getResources().getColor(e.d.cp_cont_b));
            this.fdO.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.fdQ.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.fdN.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.fdP.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            return;
        }
        this.bPW.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.fdO.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.fdQ.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.fdN.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.fdP.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.ekR = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.bPW.setText(ga(this.ekR.getName()));
        this.ekO.setDefaultResource(e.f.icon_default_ba_120);
        this.ekO.setAutoChangeStyle(false);
        this.ekO.startLoad(this.ekR.getImageUrl(), 10, false);
        this.fdO.setText(ao.V(this.ekR.getMemberNum()));
        this.fdQ.setText(ao.V(this.ekR.getPostNum()));
    }

    private String ga(String str) {
        return ao.o(str, 8) + this.context.getString(e.j.forum);
    }
}
