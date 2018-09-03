package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private TextView bwl;
    private Context context;
    private HeadImageView dKo;
    private ShareFromFrsMsgData dKr;
    private TextView eDa;
    private TextView eDb;
    private TextView eDc;
    private TextView eDd;

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
        LayoutInflater.from(getContext()).inflate(f.h.share_from_frs_view, this);
        this.bwl = (TextView) findViewById(f.g.frs_name);
        this.dKo = (HeadImageView) findViewById(f.g.frs_img);
        this.eDb = (TextView) findViewById(f.g.frs_member_num);
        this.eDd = (TextView) findViewById(f.g.frs_post_num);
        this.eDa = (TextView) findViewById(f.g.frs_member_num_label);
        this.eDc = (TextView) findViewById(f.g.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bwl.setTextColor(getContext().getResources().getColor(f.d.cp_cont_b));
            this.eDb.setTextColor(getContext().getResources().getColor(f.d.cp_cont_f));
            this.eDd.setTextColor(getContext().getResources().getColor(f.d.cp_cont_f));
            this.eDa.setTextColor(getContext().getResources().getColor(f.d.cp_cont_f));
            this.eDc.setTextColor(getContext().getResources().getColor(f.d.cp_cont_f));
            return;
        }
        this.bwl.setTextColor(getContext().getResources().getColor(f.d.cp_cont_g));
        this.eDb.setTextColor(getContext().getResources().getColor(f.d.cp_cont_g));
        this.eDd.setTextColor(getContext().getResources().getColor(f.d.cp_cont_g));
        this.eDa.setTextColor(getContext().getResources().getColor(f.d.cp_cont_g));
        this.eDc.setTextColor(getContext().getResources().getColor(f.d.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.dKr = shareFromFrsMsgData;
        Ap();
    }

    private void Ap() {
        this.bwl.setText(eO(this.dKr.getName()));
        this.dKo.setDefaultResource(f.C0146f.icon_default_ba_120);
        this.dKo.setAutoChangeStyle(false);
        this.dKo.startLoad(this.dKr.getImageUrl(), 10, false);
        this.eDb.setText(ap.F(this.dKr.getMemberNum()));
        this.eDd.setText(ap.F(this.dKr.getPostNum()));
    }

    private String eO(String str) {
        return ap.j(str, 8) + this.context.getString(f.j.forum);
    }
}
