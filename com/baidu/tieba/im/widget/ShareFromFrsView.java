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
    private TextView bNf;
    private Context context;
    private HeadImageView dZc;
    private ShareFromFrsMsgData dZf;
    private TextView eOr;
    private TextView eOs;
    private TextView eOt;
    private TextView eOu;

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
        this.bNf = (TextView) findViewById(d.g.frs_name);
        this.dZc = (HeadImageView) findViewById(d.g.frs_img);
        this.eOs = (TextView) findViewById(d.g.frs_member_num);
        this.eOu = (TextView) findViewById(d.g.frs_post_num);
        this.eOr = (TextView) findViewById(d.g.frs_member_num_label);
        this.eOt = (TextView) findViewById(d.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bNf.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_b));
            this.eOs.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_f));
            this.eOu.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_f));
            this.eOr.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_f));
            this.eOt.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_f));
            return;
        }
        this.bNf.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_g));
        this.eOs.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_g));
        this.eOu.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_g));
        this.eOr.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_g));
        this.eOt.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.dZf = shareFromFrsMsgData;
        Ea();
    }

    private void Ea() {
        this.bNf.setText(ew(this.dZf.getName()));
        this.dZc.setDefaultResource(d.f.icon_default_ba_120);
        this.dZc.setAutoChangeStyle(false);
        this.dZc.startLoad(this.dZf.getImageUrl(), 10, false);
        this.eOs.setText(am.H(this.dZf.getMemberNum()));
        this.eOu.setText(am.H(this.dZf.getPostNum()));
    }

    private String ew(String str) {
        return am.k(str, 8) + this.context.getString(d.j.forum);
    }
}
