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
    private HeadImageView cJW;
    private ShareFromFrsMsgData cJZ;
    private Context context;
    private TextView dFn;
    private TextView dFo;
    private TextView dFp;
    private TextView dFq;
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
        this.cJW = (HeadImageView) findViewById(d.h.frs_img);
        this.dFo = (TextView) findViewById(d.h.frs_member_num);
        this.dFq = (TextView) findViewById(d.h.frs_post_num);
        this.dFn = (TextView) findViewById(d.h.frs_member_num_label);
        this.dFp = (TextView) findViewById(d.h.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.name.setTextColor(getContext().getResources().getColor(d.e.cp_cont_b));
            this.dFo.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dFq.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dFn.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dFp.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            return;
        }
        this.name.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dFo.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dFq.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dFn.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dFp.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cJZ = shareFromFrsMsgData;
        wg();
    }

    private void wg() {
        this.name.setText(dR(this.cJZ.getName()));
        this.cJW.setDefaultResource(d.g.icon_default_ba_120);
        this.cJW.setAutoChangeStyle(false);
        this.cJW.c(this.cJZ.getImageUrl(), 10, false);
        this.dFo.setText(am.y(this.cJZ.getMemberNum()));
        this.dFq.setText(am.y(this.cJZ.getPostNum()));
    }

    private String dR(String str) {
        return am.j(str, 8) + this.context.getString(d.l.forum);
    }
}
