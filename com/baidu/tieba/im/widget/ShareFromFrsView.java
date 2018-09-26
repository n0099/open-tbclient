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
    private TextView bCa;
    private Context context;
    private ShareFromFrsMsgData dRB;
    private HeadImageView dRy;
    private TextView eKr;
    private TextView eKs;
    private TextView eKt;
    private TextView eKu;

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
        this.bCa = (TextView) findViewById(e.g.frs_name);
        this.dRy = (HeadImageView) findViewById(e.g.frs_img);
        this.eKs = (TextView) findViewById(e.g.frs_member_num);
        this.eKu = (TextView) findViewById(e.g.frs_post_num);
        this.eKr = (TextView) findViewById(e.g.frs_member_num_label);
        this.eKt = (TextView) findViewById(e.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bCa.setTextColor(getContext().getResources().getColor(e.d.cp_cont_b));
            this.eKs.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.eKu.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.eKr.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.eKt.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            return;
        }
        this.bCa.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.eKs.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.eKu.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.eKr.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.eKt.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.dRB = shareFromFrsMsgData;
        Bp();
    }

    private void Bp() {
        this.bCa.setText(fg(this.dRB.getName()));
        this.dRy.setDefaultResource(e.f.icon_default_ba_120);
        this.dRy.setAutoChangeStyle(false);
        this.dRy.startLoad(this.dRB.getImageUrl(), 10, false);
        this.eKs.setText(ao.J(this.dRB.getMemberNum()));
        this.eKu.setText(ao.J(this.dRB.getPostNum()));
    }

    private String fg(String str) {
        return ao.o(str, 8) + this.context.getString(e.j.forum);
    }
}
