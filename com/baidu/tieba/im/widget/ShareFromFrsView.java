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
    private TextView bKH;
    private Context context;
    private HeadImageView dZt;
    private ShareFromFrsMsgData dZw;
    private TextView eSa;
    private TextView eSb;
    private TextView eSc;
    private TextView eSd;

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
        this.bKH = (TextView) findViewById(e.g.frs_name);
        this.dZt = (HeadImageView) findViewById(e.g.frs_img);
        this.eSb = (TextView) findViewById(e.g.frs_member_num);
        this.eSd = (TextView) findViewById(e.g.frs_post_num);
        this.eSa = (TextView) findViewById(e.g.frs_member_num_label);
        this.eSc = (TextView) findViewById(e.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bKH.setTextColor(getContext().getResources().getColor(e.d.cp_cont_b));
            this.eSb.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.eSd.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.eSa.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.eSc.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            return;
        }
        this.bKH.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.eSb.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.eSd.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.eSa.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.eSc.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.dZw = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.bKH.setText(fu(this.dZw.getName()));
        this.dZt.setDefaultResource(e.f.icon_default_ba_120);
        this.dZt.setAutoChangeStyle(false);
        this.dZt.startLoad(this.dZw.getImageUrl(), 10, false);
        this.eSb.setText(ao.L(this.dZw.getMemberNum()));
        this.eSd.setText(ao.L(this.dZw.getPostNum()));
    }

    private String fu(String str) {
        return ao.o(str, 8) + this.context.getString(e.j.forum);
    }
}
