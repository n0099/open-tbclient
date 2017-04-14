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
    private HeadImageView ceg;
    private ShareFromFrsMsgData cej;
    private Context context;
    private TextView dgm;
    private TextView dgn;
    private TextView dgo;
    private TextView dgp;
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
        this.ceg = (HeadImageView) findViewById(w.h.frs_img);
        this.dgn = (TextView) findViewById(w.h.frs_member_num);
        this.dgp = (TextView) findViewById(w.h.frs_post_num);
        this.dgm = (TextView) findViewById(w.h.frs_member_num_label);
        this.dgo = (TextView) findViewById(w.h.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.name.setTextColor(getContext().getResources().getColor(w.e.cp_cont_b));
            this.dgn.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            this.dgp.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            this.dgm.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            this.dgo.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            return;
        }
        this.name.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.dgn.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.dgp.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.dgm.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.dgo.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cej = shareFromFrsMsgData;
        wU();
    }

    private void wU() {
        this.name.setText(dF(this.cej.getName()));
        this.ceg.setDefaultResource(w.g.icon_default_ba_120);
        this.ceg.setAutoChangeStyle(false);
        this.ceg.c(this.cej.getImageUrl(), 10, false);
        this.dgn.setText(au.w(this.cej.getMemberNum()));
        this.dgp.setText(au.w(this.cej.getPostNum()));
    }

    private String dF(String str) {
        return String.valueOf(au.j(str, 8)) + this.context.getString(w.l.forum);
    }
}
