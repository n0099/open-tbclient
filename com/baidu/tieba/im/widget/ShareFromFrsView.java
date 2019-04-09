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
    private Context context;
    private TextView dfp;
    private HeadImageView fzN;
    private ShareFromFrsMsgData fzQ;
    private TextView gtH;
    private TextView gtI;
    private TextView gtJ;
    private TextView gtK;

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
        this.dfp = (TextView) findViewById(d.g.frs_name);
        this.fzN = (HeadImageView) findViewById(d.g.frs_img);
        this.gtI = (TextView) findViewById(d.g.frs_member_num);
        this.gtK = (TextView) findViewById(d.g.frs_post_num);
        this.gtH = (TextView) findViewById(d.g.frs_member_num_label);
        this.gtJ = (TextView) findViewById(d.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.dfp.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_b));
            this.gtI.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_f));
            this.gtK.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_f));
            this.gtH.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_f));
            this.gtJ.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_f));
            return;
        }
        this.dfp.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_g));
        this.gtI.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_g));
        this.gtK.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_g));
        this.gtH.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_g));
        this.gtJ.setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.fzQ = shareFromFrsMsgData;
        GP();
    }

    private void GP() {
        this.dfp.setText(mN(this.fzQ.getName()));
        this.fzN.setDefaultResource(d.f.icon_default_ba_120);
        this.fzN.setAutoChangeStyle(false);
        this.fzN.startLoad(this.fzQ.getImageUrl(), 10, false);
        this.gtI.setText(ap.ax(this.fzQ.getMemberNum()));
        this.gtK.setText(ap.ax(this.fzQ.getPostNum()));
    }

    private String mN(String str) {
        return ap.o(str, 8) + this.context.getString(d.j.forum);
    }
}
