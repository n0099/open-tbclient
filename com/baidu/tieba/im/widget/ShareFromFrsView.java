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
    private TextView bPk;
    private Context context;
    private HeadImageView ekh;
    private ShareFromFrsMsgData ekk;
    private TextView fcZ;
    private TextView fda;
    private TextView fdb;
    private TextView fdc;

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
        this.bPk = (TextView) findViewById(e.g.frs_name);
        this.ekh = (HeadImageView) findViewById(e.g.frs_img);
        this.fda = (TextView) findViewById(e.g.frs_member_num);
        this.fdc = (TextView) findViewById(e.g.frs_post_num);
        this.fcZ = (TextView) findViewById(e.g.frs_member_num_label);
        this.fdb = (TextView) findViewById(e.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bPk.setTextColor(getContext().getResources().getColor(e.d.cp_cont_b));
            this.fda.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.fdc.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.fcZ.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            this.fdb.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            return;
        }
        this.bPk.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.fda.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.fdc.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.fcZ.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.fdb.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.ekk = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.bPk.setText(fN(this.ekk.getName()));
        this.ekh.setDefaultResource(e.f.icon_default_ba_120);
        this.ekh.setAutoChangeStyle(false);
        this.ekh.startLoad(this.ekk.getImageUrl(), 10, false);
        this.fda.setText(ao.V(this.ekk.getMemberNum()));
        this.fdc.setText(ao.V(this.ekk.getPostNum()));
    }

    private String fN(String str) {
        return ao.o(str, 8) + this.context.getString(e.j.forum);
    }
}
