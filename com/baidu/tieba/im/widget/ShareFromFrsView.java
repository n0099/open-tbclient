package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private TextView bui;
    private Context context;
    private HeadImageView dEi;
    private ShareFromFrsMsgData dEl;
    private TextView evw;
    private TextView evx;
    private TextView evy;
    private TextView evz;

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
        LayoutInflater.from(getContext()).inflate(d.i.share_from_frs_view, this);
        this.bui = (TextView) findViewById(d.g.frs_name);
        this.dEi = (HeadImageView) findViewById(d.g.frs_img);
        this.evx = (TextView) findViewById(d.g.frs_member_num);
        this.evz = (TextView) findViewById(d.g.frs_post_num);
        this.evw = (TextView) findViewById(d.g.frs_member_num_label);
        this.evy = (TextView) findViewById(d.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bui.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_b));
            this.evx.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_f));
            this.evz.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_f));
            this.evw.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_f));
            this.evy.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_f));
            return;
        }
        this.bui.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_g));
        this.evx.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_g));
        this.evz.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_g));
        this.evw.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_g));
        this.evy.setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.dEl = shareFromFrsMsgData;
        Al();
    }

    private void Al() {
        this.bui.setText(eN(this.dEl.getName()));
        this.dEi.setDefaultResource(d.f.icon_default_ba_120);
        this.dEi.setAutoChangeStyle(false);
        this.dEi.startLoad(this.dEl.getImageUrl(), 10, false);
        this.evx.setText(ao.C(this.dEl.getMemberNum()));
        this.evz.setText(ao.C(this.dEl.getPostNum()));
    }

    private String eN(String str) {
        return ao.j(str, 8) + this.context.getString(d.k.forum);
    }
}
