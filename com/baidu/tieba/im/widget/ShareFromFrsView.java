package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private Context context;
    private HeadImageView crH;
    private ShareFromFrsMsgData crK;
    private TextView dpX;
    private TextView dpY;
    private TextView dpZ;
    private TextView dqa;
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
        this.crH = (HeadImageView) findViewById(w.h.frs_img);
        this.dpY = (TextView) findViewById(w.h.frs_member_num);
        this.dqa = (TextView) findViewById(w.h.frs_post_num);
        this.dpX = (TextView) findViewById(w.h.frs_member_num_label);
        this.dpZ = (TextView) findViewById(w.h.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.name.setTextColor(getContext().getResources().getColor(w.e.cp_cont_b));
            this.dpY.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            this.dqa.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            this.dpX.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            this.dpZ.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            return;
        }
        this.name.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.dpY.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.dqa.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.dpX.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.dpZ.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.crK = shareFromFrsMsgData;
        ww();
    }

    private void ww() {
        this.name.setText(dU(this.crK.getName()));
        this.crH.setDefaultResource(w.g.icon_default_ba_120);
        this.crH.setAutoChangeStyle(false);
        this.crH.c(this.crK.getImageUrl(), 10, false);
        this.dpY.setText(aw.y(this.crK.getMemberNum()));
        this.dqa.setText(aw.y(this.crK.getPostNum()));
    }

    private String dU(String str) {
        return String.valueOf(aw.j(str, 8)) + this.context.getString(w.l.forum);
    }
}
