package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private TextView bwj;
    private Context context;
    private HeadImageView dKs;
    private ShareFromFrsMsgData dKv;
    private TextView eDe;
    private TextView eDf;
    private TextView eDg;
    private TextView eDh;

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
        this.bwj = (TextView) findViewById(d.g.frs_name);
        this.dKs = (HeadImageView) findViewById(d.g.frs_img);
        this.eDf = (TextView) findViewById(d.g.frs_member_num);
        this.eDh = (TextView) findViewById(d.g.frs_post_num);
        this.eDe = (TextView) findViewById(d.g.frs_member_num_label);
        this.eDg = (TextView) findViewById(d.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bwj.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_b));
            this.eDf.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_f));
            this.eDh.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_f));
            this.eDe.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_f));
            this.eDg.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_f));
            return;
        }
        this.bwj.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_g));
        this.eDf.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_g));
        this.eDh.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_g));
        this.eDe.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_g));
        this.eDg.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.dKv = shareFromFrsMsgData;
        Ar();
    }

    private void Ar() {
        this.bwj.setText(eO(this.dKv.getName()));
        this.dKs.setDefaultResource(d.f.icon_default_ba_120);
        this.dKs.setAutoChangeStyle(false);
        this.dKs.startLoad(this.dKv.getImageUrl(), 10, false);
        this.eDf.setText(ap.F(this.dKv.getMemberNum()));
        this.eDh.setText(ap.F(this.dKv.getPostNum()));
    }

    private String eO(String str) {
        return ap.j(str, 8) + this.context.getString(d.j.forum);
    }
}
