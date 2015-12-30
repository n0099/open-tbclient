package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private TextView aGr;
    private HeadImageView boJ;
    private ShareFromFrsMsgData boM;
    private TextView ccm;
    private TextView ccn;
    private TextView cco;
    private TextView ccp;
    private Context context;

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
        LayoutInflater.from(getContext()).inflate(n.h.share_from_frs_view, this);
        this.aGr = (TextView) findViewById(n.g.frs_name);
        this.boJ = (HeadImageView) findViewById(n.g.frs_img);
        this.ccn = (TextView) findViewById(n.g.frs_member_num);
        this.ccp = (TextView) findViewById(n.g.frs_post_num);
        this.ccm = (TextView) findViewById(n.g.frs_member_num_label);
        this.cco = (TextView) findViewById(n.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aGr.setTextColor(getContext().getResources().getColor(n.d.cp_cont_b));
            this.ccn.setTextColor(getContext().getResources().getColor(n.d.cp_cont_f));
            this.ccp.setTextColor(getContext().getResources().getColor(n.d.cp_cont_f));
            this.ccm.setTextColor(getContext().getResources().getColor(n.d.cp_cont_f));
            this.cco.setTextColor(getContext().getResources().getColor(n.d.cp_cont_f));
            return;
        }
        this.aGr.setTextColor(getContext().getResources().getColor(n.d.cp_cont_g));
        this.ccn.setTextColor(getContext().getResources().getColor(n.d.cp_cont_g));
        this.ccp.setTextColor(getContext().getResources().getColor(n.d.cp_cont_g));
        this.ccm.setTextColor(getContext().getResources().getColor(n.d.cp_cont_g));
        this.cco.setTextColor(getContext().getResources().getColor(n.d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.boM = shareFromFrsMsgData;
        vN();
    }

    private void vN() {
        this.aGr.setText(dD(this.boM.getName()));
        this.boJ.setDefaultResource(n.f.icon_default_ba_120);
        this.boJ.setAutoChangeStyle(false);
        this.boJ.d(this.boM.getImageUrl(), 10, false);
        this.ccn.setText(ax.x(this.boM.getMemberNum()));
        this.ccp.setText(ax.x(this.boM.getPostNum()));
    }

    private String dD(String str) {
        return String.valueOf(ax.i(str, 8)) + this.context.getString(n.j.forum);
    }
}
