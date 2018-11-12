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
    private TextView bLs;
    private Context context;
    private TextView eTt;
    private TextView eTu;
    private TextView eTv;
    private TextView eTw;
    private HeadImageView eaN;
    private ShareFromFrsMsgData eaQ;

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
        this.bLs = (TextView) findViewById(e.g.frs_name);
        this.eaN = (HeadImageView) findViewById(e.g.frs_img);
        this.eTu = (TextView) findViewById(e.g.frs_member_num);
        this.eTw = (TextView) findViewById(e.g.frs_post_num);
        this.eTt = (TextView) findViewById(e.g.frs_member_num_label);
        this.eTv = (TextView) findViewById(e.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bLs.setTextColor(getContext().getResources().getColor(e.d.cp_cont_b));
            this.eTu.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.eTw.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.eTt.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.eTv.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            return;
        }
        this.bLs.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.eTu.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.eTw.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.eTt.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.eTv.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.eaQ = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.bLs.setText(fu(this.eaQ.getName()));
        this.eaN.setDefaultResource(e.f.icon_default_ba_120);
        this.eaN.setAutoChangeStyle(false);
        this.eaN.startLoad(this.eaQ.getImageUrl(), 10, false);
        this.eTu.setText(ao.N(this.eaQ.getMemberNum()));
        this.eTw.setText(ao.N(this.eaQ.getPostNum()));
    }

    private String fu(String str) {
        return ao.o(str, 8) + this.context.getString(e.j.forum);
    }
}
