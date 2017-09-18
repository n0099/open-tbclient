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
    private HeadImageView cJs;
    private ShareFromFrsMsgData cJv;
    private Context context;
    private TextView dJm;
    private TextView dJn;
    private TextView dJo;
    private TextView dJp;
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
        LayoutInflater.from(getContext()).inflate(d.j.share_from_frs_view, this);
        this.name = (TextView) findViewById(d.h.frs_name);
        this.cJs = (HeadImageView) findViewById(d.h.frs_img);
        this.dJn = (TextView) findViewById(d.h.frs_member_num);
        this.dJp = (TextView) findViewById(d.h.frs_post_num);
        this.dJm = (TextView) findViewById(d.h.frs_member_num_label);
        this.dJo = (TextView) findViewById(d.h.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.name.setTextColor(getContext().getResources().getColor(d.e.cp_cont_b));
            this.dJn.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dJp.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dJm.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dJo.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            return;
        }
        this.name.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dJn.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dJp.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dJm.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dJo.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cJv = shareFromFrsMsgData;
        wO();
    }

    private void wO() {
        this.name.setText(dZ(this.cJv.getName()));
        this.cJs.setDefaultResource(d.g.icon_default_ba_120);
        this.cJs.setAutoChangeStyle(false);
        this.cJs.c(this.cJv.getImageUrl(), 10, false);
        this.dJn.setText(am.y(this.cJv.getMemberNum()));
        this.dJp.setText(am.y(this.cJv.getPostNum()));
    }

    private String dZ(String str) {
        return am.j(str, 8) + this.context.getString(d.l.forum);
    }
}
