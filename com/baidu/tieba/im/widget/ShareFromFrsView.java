package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private TextView aHk;
    private HeadImageView brG;
    private ShareFromFrsMsgData brJ;
    private TextView cgM;
    private TextView cgN;
    private TextView cgO;
    private TextView cgP;
    private Context context;

    public ShareFromFrsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        qD();
    }

    public ShareFromFrsView(Context context) {
        super(context);
        this.context = context;
        qD();
    }

    private void qD() {
        LayoutInflater.from(getContext()).inflate(t.h.share_from_frs_view, this);
        this.aHk = (TextView) findViewById(t.g.frs_name);
        this.brG = (HeadImageView) findViewById(t.g.frs_img);
        this.cgN = (TextView) findViewById(t.g.frs_member_num);
        this.cgP = (TextView) findViewById(t.g.frs_post_num);
        this.cgM = (TextView) findViewById(t.g.frs_member_num_label);
        this.cgO = (TextView) findViewById(t.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.aHk.setTextColor(getContext().getResources().getColor(t.d.cp_cont_b));
            this.cgN.setTextColor(getContext().getResources().getColor(t.d.cp_cont_f));
            this.cgP.setTextColor(getContext().getResources().getColor(t.d.cp_cont_f));
            this.cgM.setTextColor(getContext().getResources().getColor(t.d.cp_cont_f));
            this.cgO.setTextColor(getContext().getResources().getColor(t.d.cp_cont_f));
            return;
        }
        this.aHk.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
        this.cgN.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
        this.cgP.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
        this.cgM.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
        this.cgO.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.brJ = shareFromFrsMsgData;
        wV();
    }

    private void wV() {
        this.aHk.setText(dA(this.brJ.getName()));
        this.brG.setDefaultResource(t.f.icon_default_ba_120);
        this.brG.setAutoChangeStyle(false);
        this.brG.d(this.brJ.getImageUrl(), 10, false);
        this.cgN.setText(aw.y(this.brJ.getMemberNum()));
        this.cgP.setText(aw.y(this.brJ.getPostNum()));
    }

    private String dA(String str) {
        return String.valueOf(aw.j(str, 8)) + this.context.getString(t.j.forum);
    }
}
