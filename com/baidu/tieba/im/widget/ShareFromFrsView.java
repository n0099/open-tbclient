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
    private Context context;
    private HeadImageView cyQ;
    private ShareFromFrsMsgData cyT;
    private TextView dyA;
    private TextView dyB;
    private TextView dyC;
    private TextView dyz;
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
        this.cyQ = (HeadImageView) findViewById(d.h.frs_img);
        this.dyA = (TextView) findViewById(d.h.frs_member_num);
        this.dyC = (TextView) findViewById(d.h.frs_post_num);
        this.dyz = (TextView) findViewById(d.h.frs_member_num_label);
        this.dyB = (TextView) findViewById(d.h.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.name.setTextColor(getContext().getResources().getColor(d.e.cp_cont_b));
            this.dyA.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dyC.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dyz.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            this.dyB.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            return;
        }
        this.name.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dyA.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dyC.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dyz.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.dyB.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cyT = shareFromFrsMsgData;
        wG();
    }

    private void wG() {
        this.name.setText(dX(this.cyT.getName()));
        this.cyQ.setDefaultResource(d.g.icon_default_ba_120);
        this.cyQ.setAutoChangeStyle(false);
        this.cyQ.c(this.cyT.getImageUrl(), 10, false);
        this.dyA.setText(al.z(this.cyT.getMemberNum()));
        this.dyC.setText(al.z(this.cyT.getPostNum()));
    }

    private String dX(String str) {
        return al.j(str, 8) + this.context.getString(d.l.forum);
    }
}
