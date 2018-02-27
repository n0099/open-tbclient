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
    private TextView bMS;
    private Context context;
    private HeadImageView dYQ;
    private ShareFromFrsMsgData dYT;
    private TextView eOf;
    private TextView eOg;
    private TextView eOh;
    private TextView eOi;

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
        this.bMS = (TextView) findViewById(d.g.frs_name);
        this.dYQ = (HeadImageView) findViewById(d.g.frs_img);
        this.eOg = (TextView) findViewById(d.g.frs_member_num);
        this.eOi = (TextView) findViewById(d.g.frs_post_num);
        this.eOf = (TextView) findViewById(d.g.frs_member_num_label);
        this.eOh = (TextView) findViewById(d.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bMS.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_b));
            this.eOg.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_f));
            this.eOi.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_f));
            this.eOf.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_f));
            this.eOh.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_f));
            return;
        }
        this.bMS.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_g));
        this.eOg.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_g));
        this.eOi.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_g));
        this.eOf.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_g));
        this.eOh.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.dYT = shareFromFrsMsgData;
        DZ();
    }

    private void DZ() {
        this.bMS.setText(ew(this.dYT.getName()));
        this.dYQ.setDefaultResource(d.f.icon_default_ba_120);
        this.dYQ.setAutoChangeStyle(false);
        this.dYQ.startLoad(this.dYT.getImageUrl(), 10, false);
        this.eOg.setText(am.H(this.dYT.getMemberNum()));
        this.eOi.setText(am.H(this.dYT.getPostNum()));
    }

    private String ew(String str) {
        return am.k(str, 8) + this.context.getString(d.j.forum);
    }
}
