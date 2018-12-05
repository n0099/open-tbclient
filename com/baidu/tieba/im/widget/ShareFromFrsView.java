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
    private TextView bPh;
    private Context context;
    private HeadImageView ehq;
    private ShareFromFrsMsgData eht;
    private TextView fai;
    private TextView faj;
    private TextView fak;
    private TextView fal;

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
        this.bPh = (TextView) findViewById(e.g.frs_name);
        this.ehq = (HeadImageView) findViewById(e.g.frs_img);
        this.faj = (TextView) findViewById(e.g.frs_member_num);
        this.fal = (TextView) findViewById(e.g.frs_post_num);
        this.fai = (TextView) findViewById(e.g.frs_member_num_label);
        this.fak = (TextView) findViewById(e.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bPh.setTextColor(getContext().getResources().getColor(e.d.cp_cont_b));
            this.faj.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.fal.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.fai.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.fak.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            return;
        }
        this.bPh.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.faj.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.fal.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.fai.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.fak.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.eht = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.bPh.setText(fM(this.eht.getName()));
        this.ehq.setDefaultResource(e.f.icon_default_ba_120);
        this.ehq.setAutoChangeStyle(false);
        this.ehq.startLoad(this.eht.getImageUrl(), 10, false);
        this.faj.setText(ao.U(this.eht.getMemberNum()));
        this.fal.setText(ao.U(this.eht.getPostNum()));
    }

    private String fM(String str) {
        return ao.o(str, 8) + this.context.getString(e.j.forum);
    }
}
