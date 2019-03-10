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
    private Context context;
    private TextView dfo;
    private HeadImageView fAa;
    private ShareFromFrsMsgData fAd;
    private TextView gtU;
    private TextView gtV;
    private TextView gtW;
    private TextView gtX;

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
        this.dfo = (TextView) findViewById(d.g.frs_name);
        this.fAa = (HeadImageView) findViewById(d.g.frs_img);
        this.gtV = (TextView) findViewById(d.g.frs_member_num);
        this.gtX = (TextView) findViewById(d.g.frs_post_num);
        this.gtU = (TextView) findViewById(d.g.frs_member_num_label);
        this.gtW = (TextView) findViewById(d.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.dfo.setTextColor(getContext().getResources().getColor(d.C0236d.cp_cont_b));
            this.gtV.setTextColor(getContext().getResources().getColor(d.C0236d.cp_cont_f));
            this.gtX.setTextColor(getContext().getResources().getColor(d.C0236d.cp_cont_f));
            this.gtU.setTextColor(getContext().getResources().getColor(d.C0236d.cp_cont_f));
            this.gtW.setTextColor(getContext().getResources().getColor(d.C0236d.cp_cont_f));
            return;
        }
        this.dfo.setTextColor(getContext().getResources().getColor(d.C0236d.cp_cont_g));
        this.gtV.setTextColor(getContext().getResources().getColor(d.C0236d.cp_cont_g));
        this.gtX.setTextColor(getContext().getResources().getColor(d.C0236d.cp_cont_g));
        this.gtU.setTextColor(getContext().getResources().getColor(d.C0236d.cp_cont_g));
        this.gtW.setTextColor(getContext().getResources().getColor(d.C0236d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.fAd = shareFromFrsMsgData;
        GR();
    }

    private void GR() {
        this.dfo.setText(mM(this.fAd.getName()));
        this.fAa.setDefaultResource(d.f.icon_default_ba_120);
        this.fAa.setAutoChangeStyle(false);
        this.fAa.startLoad(this.fAd.getImageUrl(), 10, false);
        this.gtV.setText(ap.ax(this.fAd.getMemberNum()));
        this.gtX.setText(ap.ax(this.fAd.getPostNum()));
    }

    private String mM(String str) {
        return ap.o(str, 8) + this.context.getString(d.j.forum);
    }
}
