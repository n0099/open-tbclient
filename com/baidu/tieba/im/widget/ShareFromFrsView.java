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
    private ShareFromFrsMsgData cIB;
    private HeadImageView cIy;
    private Context context;
    private TextView dIr;
    private TextView dIs;
    private TextView dIt;
    private TextView dIu;
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
        this.cIy = (HeadImageView) findViewById(d.h.frs_img);
        this.dIs = (TextView) findViewById(d.h.frs_member_num);
        this.dIu = (TextView) findViewById(d.h.frs_post_num);
        this.dIr = (TextView) findViewById(d.h.frs_member_num_label);
        this.dIt = (TextView) findViewById(d.h.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.name.setTextColor(getContext().getResources().getColor(d.e.cp_cont_b));
            this.dIs.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dIu.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dIr.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dIt.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            return;
        }
        this.name.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dIs.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dIu.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dIr.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dIt.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cIB = shareFromFrsMsgData;
        wO();
    }

    private void wO() {
        this.name.setText(dZ(this.cIB.getName()));
        this.cIy.setDefaultResource(d.g.icon_default_ba_120);
        this.cIy.setAutoChangeStyle(false);
        this.cIy.c(this.cIB.getImageUrl(), 10, false);
        this.dIs.setText(am.y(this.cIB.getMemberNum()));
        this.dIu.setText(am.y(this.cIB.getPostNum()));
    }

    private String dZ(String str) {
        return am.j(str, 8) + this.context.getString(d.l.forum);
    }
}
