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
    private TextView dfk;
    private ShareFromFrsMsgData fAc;
    private HeadImageView fzZ;
    private TextView gtT;
    private TextView gtU;
    private TextView gtV;
    private TextView gtW;

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
        this.dfk = (TextView) findViewById(d.g.frs_name);
        this.fzZ = (HeadImageView) findViewById(d.g.frs_img);
        this.gtU = (TextView) findViewById(d.g.frs_member_num);
        this.gtW = (TextView) findViewById(d.g.frs_post_num);
        this.gtT = (TextView) findViewById(d.g.frs_member_num_label);
        this.gtV = (TextView) findViewById(d.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.dfk.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_b));
            this.gtU.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_f));
            this.gtW.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_f));
            this.gtT.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_f));
            this.gtV.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_f));
            return;
        }
        this.dfk.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_g));
        this.gtU.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_g));
        this.gtW.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_g));
        this.gtT.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_g));
        this.gtV.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.fAc = shareFromFrsMsgData;
        GR();
    }

    private void GR() {
        this.dfk.setText(mM(this.fAc.getName()));
        this.fzZ.setDefaultResource(d.f.icon_default_ba_120);
        this.fzZ.setAutoChangeStyle(false);
        this.fzZ.startLoad(this.fAc.getImageUrl(), 10, false);
        this.gtU.setText(ap.ax(this.fAc.getMemberNum()));
        this.gtW.setText(ap.ax(this.fAc.getPostNum()));
    }

    private String mM(String str) {
        return ap.o(str, 8) + this.context.getString(d.j.forum);
    }
}
