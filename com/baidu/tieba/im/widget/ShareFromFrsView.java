package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private HeadImageView cdt;
    private ShareFromFrsMsgData cdw;
    private Context context;
    private TextView dcF;
    private TextView dcG;
    private TextView dcH;
    private TextView dcI;
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
        LayoutInflater.from(getContext()).inflate(w.j.share_from_frs_view, this);
        this.name = (TextView) findViewById(w.h.frs_name);
        this.cdt = (HeadImageView) findViewById(w.h.frs_img);
        this.dcG = (TextView) findViewById(w.h.frs_member_num);
        this.dcI = (TextView) findViewById(w.h.frs_post_num);
        this.dcF = (TextView) findViewById(w.h.frs_member_num_label);
        this.dcH = (TextView) findViewById(w.h.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.name.setTextColor(getContext().getResources().getColor(w.e.cp_cont_b));
            this.dcG.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            this.dcI.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            this.dcF.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            this.dcH.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            return;
        }
        this.name.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.dcG.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.dcI.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.dcF.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.dcH.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cdw = shareFromFrsMsgData;
        wh();
    }

    private void wh() {
        this.name.setText(dD(this.cdw.getName()));
        this.cdt.setDefaultResource(w.g.icon_default_ba_120);
        this.cdt.setAutoChangeStyle(false);
        this.cdt.c(this.cdw.getImageUrl(), 10, false);
        this.dcG.setText(au.x(this.cdw.getMemberNum()));
        this.dcI.setText(au.x(this.cdw.getPostNum()));
    }

    private String dD(String str) {
        return String.valueOf(au.j(str, 8)) + this.context.getString(w.l.forum);
    }
}
