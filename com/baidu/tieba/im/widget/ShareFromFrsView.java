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
    private TextView aER;
    private TextView bYm;
    private TextView bYn;
    private TextView bYo;
    private TextView bYp;
    private HeadImageView bkS;
    private ShareFromFrsMsgData bkV;
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
        LayoutInflater.from(getContext()).inflate(n.g.share_from_frs_view, this);
        this.aER = (TextView) findViewById(n.f.frs_name);
        this.bkS = (HeadImageView) findViewById(n.f.frs_img);
        this.bYn = (TextView) findViewById(n.f.frs_member_num);
        this.bYp = (TextView) findViewById(n.f.frs_post_num);
        this.bYm = (TextView) findViewById(n.f.frs_member_num_label);
        this.bYo = (TextView) findViewById(n.f.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aER.setTextColor(getContext().getResources().getColor(n.c.cp_cont_b));
            this.bYn.setTextColor(getContext().getResources().getColor(n.c.cp_cont_f));
            this.bYp.setTextColor(getContext().getResources().getColor(n.c.cp_cont_f));
            this.bYm.setTextColor(getContext().getResources().getColor(n.c.cp_cont_f));
            this.bYo.setTextColor(getContext().getResources().getColor(n.c.cp_cont_f));
            return;
        }
        this.aER.setTextColor(getContext().getResources().getColor(n.c.cp_cont_g));
        this.bYn.setTextColor(getContext().getResources().getColor(n.c.cp_cont_g));
        this.bYp.setTextColor(getContext().getResources().getColor(n.c.cp_cont_g));
        this.bYm.setTextColor(getContext().getResources().getColor(n.c.cp_cont_g));
        this.bYo.setTextColor(getContext().getResources().getColor(n.c.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bkV = shareFromFrsMsgData;
        wd();
    }

    private void wd() {
        this.aER.setText(dA(this.bkV.getName()));
        this.bkS.setDefaultResource(n.e.icon_default_ba_120);
        this.bkS.setAutoChangeStyle(false);
        this.bkS.d(this.bkV.getImageUrl(), 10, false);
        this.bYn.setText(ax.w(this.bkV.getMemberNum()));
        this.bYp.setText(ax.w(this.bkV.getPostNum()));
    }

    private String dA(String str) {
        return String.valueOf(ax.i(str, 8)) + this.context.getString(n.i.forum);
    }
}
