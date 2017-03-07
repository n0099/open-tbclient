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
    private HeadImageView cfG;
    private ShareFromFrsMsgData cfJ;
    private Context context;
    private TextView dhN;
    private TextView dhO;
    private TextView dhP;
    private TextView dhQ;
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
        this.cfG = (HeadImageView) findViewById(w.h.frs_img);
        this.dhO = (TextView) findViewById(w.h.frs_member_num);
        this.dhQ = (TextView) findViewById(w.h.frs_post_num);
        this.dhN = (TextView) findViewById(w.h.frs_member_num_label);
        this.dhP = (TextView) findViewById(w.h.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.name.setTextColor(getContext().getResources().getColor(w.e.cp_cont_b));
            this.dhO.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            this.dhQ.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            this.dhN.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            this.dhP.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            return;
        }
        this.name.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.dhO.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.dhQ.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.dhN.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.dhP.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cfJ = shareFromFrsMsgData;
        wy();
    }

    private void wy() {
        this.name.setText(dz(this.cfJ.getName()));
        this.cfG.setDefaultResource(w.g.icon_default_ba_120);
        this.cfG.setAutoChangeStyle(false);
        this.cfG.c(this.cfJ.getImageUrl(), 10, false);
        this.dhO.setText(au.w(this.cfJ.getMemberNum()));
        this.dhQ.setText(au.w(this.cfJ.getPostNum()));
    }

    private String dz(String str) {
        return String.valueOf(au.j(str, 8)) + this.context.getString(w.l.forum);
    }
}
