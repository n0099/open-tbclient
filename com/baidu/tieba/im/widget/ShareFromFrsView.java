package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private HeadImageView cAk;
    private ShareFromFrsMsgData cAn;
    private Context context;
    private TextView dzR;
    private TextView dzS;
    private TextView dzT;
    private TextView dzU;
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
        this.cAk = (HeadImageView) findViewById(d.h.frs_img);
        this.dzS = (TextView) findViewById(d.h.frs_member_num);
        this.dzU = (TextView) findViewById(d.h.frs_post_num);
        this.dzR = (TextView) findViewById(d.h.frs_member_num_label);
        this.dzT = (TextView) findViewById(d.h.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.name.setTextColor(getContext().getResources().getColor(d.e.cp_cont_b));
            this.dzS.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dzU.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dzR.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dzT.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            return;
        }
        this.name.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dzS.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dzU.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dzR.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dzT.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cAn = shareFromFrsMsgData;
        wP();
    }

    private void wP() {
        this.name.setText(ed(this.cAn.getName()));
        this.cAk.setDefaultResource(d.g.icon_default_ba_120);
        this.cAk.setAutoChangeStyle(false);
        this.cAk.c(this.cAn.getImageUrl(), 10, false);
        this.dzS.setText(al.z(this.cAn.getMemberNum()));
        this.dzU.setText(al.z(this.cAn.getPostNum()));
    }

    private String ed(String str) {
        return al.j(str, 8) + this.context.getString(d.l.forum);
    }
}
