package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private HeadImageView bYk;
    private ShareFromFrsMsgData bYn;
    private Context context;
    private TextView dfw;
    private TextView dfx;
    private TextView dfy;
    private TextView dfz;
    private TextView name;

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
        LayoutInflater.from(getContext()).inflate(r.j.share_from_frs_view, this);
        this.name = (TextView) findViewById(r.h.frs_name);
        this.bYk = (HeadImageView) findViewById(r.h.frs_img);
        this.dfx = (TextView) findViewById(r.h.frs_member_num);
        this.dfz = (TextView) findViewById(r.h.frs_post_num);
        this.dfw = (TextView) findViewById(r.h.frs_member_num_label);
        this.dfy = (TextView) findViewById(r.h.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.name.setTextColor(getContext().getResources().getColor(r.e.cp_cont_b));
            this.dfx.setTextColor(getContext().getResources().getColor(r.e.cp_cont_f));
            this.dfz.setTextColor(getContext().getResources().getColor(r.e.cp_cont_f));
            this.dfw.setTextColor(getContext().getResources().getColor(r.e.cp_cont_f));
            this.dfy.setTextColor(getContext().getResources().getColor(r.e.cp_cont_f));
            return;
        }
        this.name.setTextColor(getContext().getResources().getColor(r.e.cp_cont_g));
        this.dfx.setTextColor(getContext().getResources().getColor(r.e.cp_cont_g));
        this.dfz.setTextColor(getContext().getResources().getColor(r.e.cp_cont_g));
        this.dfw.setTextColor(getContext().getResources().getColor(r.e.cp_cont_g));
        this.dfy.setTextColor(getContext().getResources().getColor(r.e.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bYn = shareFromFrsMsgData;
        wb();
    }

    private void wb() {
        this.name.setText(dF(this.bYn.getName()));
        this.bYk.setDefaultResource(r.g.icon_default_ba_120);
        this.bYk.setAutoChangeStyle(false);
        this.bYk.c(this.bYn.getImageUrl(), 10, false);
        this.dfx.setText(at.w(this.bYn.getMemberNum()));
        this.dfz.setText(at.w(this.bYn.getPostNum()));
    }

    private String dF(String str) {
        return String.valueOf(at.j(str, 8)) + this.context.getString(r.l.forum);
    }
}
