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
    private TextView bKT;
    private Context context;
    private HeadImageView dUT;
    private ShareFromFrsMsgData dUW;
    private TextView eJH;
    private TextView eJI;
    private TextView eJJ;
    private TextView eJK;

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
        this.bKT = (TextView) findViewById(d.g.frs_name);
        this.dUT = (HeadImageView) findViewById(d.g.frs_img);
        this.eJI = (TextView) findViewById(d.g.frs_member_num);
        this.eJK = (TextView) findViewById(d.g.frs_post_num);
        this.eJH = (TextView) findViewById(d.g.frs_member_num_label);
        this.eJJ = (TextView) findViewById(d.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bKT.setTextColor(getContext().getResources().getColor(d.C0107d.cp_cont_b));
            this.eJI.setTextColor(getContext().getResources().getColor(d.C0107d.cp_cont_f));
            this.eJK.setTextColor(getContext().getResources().getColor(d.C0107d.cp_cont_f));
            this.eJH.setTextColor(getContext().getResources().getColor(d.C0107d.cp_cont_f));
            this.eJJ.setTextColor(getContext().getResources().getColor(d.C0107d.cp_cont_f));
            return;
        }
        this.bKT.setTextColor(getContext().getResources().getColor(d.C0107d.cp_cont_g));
        this.eJI.setTextColor(getContext().getResources().getColor(d.C0107d.cp_cont_g));
        this.eJK.setTextColor(getContext().getResources().getColor(d.C0107d.cp_cont_g));
        this.eJH.setTextColor(getContext().getResources().getColor(d.C0107d.cp_cont_g));
        this.eJJ.setTextColor(getContext().getResources().getColor(d.C0107d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.dUW = shareFromFrsMsgData;
        DE();
    }

    private void DE() {
        this.bKT.setText(eg(this.dUW.getName()));
        this.dUT.setDefaultResource(d.f.icon_default_ba_120);
        this.dUT.setAutoChangeStyle(false);
        this.dUT.startLoad(this.dUW.getImageUrl(), 10, false);
        this.eJI.setText(am.H(this.dUW.getMemberNum()));
        this.eJK.setText(am.H(this.dUW.getPostNum()));
    }

    private String eg(String str) {
        return am.k(str, 8) + this.context.getString(d.j.forum);
    }
}
