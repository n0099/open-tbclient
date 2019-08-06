package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private TextView bmT;
    private Context context;
    private ShareFromFrsMsgData fWC;
    private HeadImageView fWz;
    private TextView gRZ;
    private TextView gSa;
    private TextView gSb;
    private TextView gSc;

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
        LayoutInflater.from(getContext()).inflate(R.layout.share_from_frs_view, this);
        this.bmT = (TextView) findViewById(R.id.frs_name);
        this.fWz = (HeadImageView) findViewById(R.id.frs_img);
        this.gSa = (TextView) findViewById(R.id.frs_member_num);
        this.gSc = (TextView) findViewById(R.id.frs_post_num);
        this.gRZ = (TextView) findViewById(R.id.frs_member_num_label);
        this.gSb = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bmT.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.gSa.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gSc.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gRZ.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gSb.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.bmT.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gSa.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gSc.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gRZ.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gSb.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.fWC = shareFromFrsMsgData;
        JS();
    }

    private void JS() {
        this.bmT.setText(om(this.fWC.getName()));
        this.fWz.setDefaultResource(R.drawable.icon_default_ba_120);
        this.fWz.setAutoChangeStyle(false);
        this.fWz.startLoad(this.fWC.getImageUrl(), 10, false);
        this.gSa.setText(aq.aM(this.fWC.getMemberNum()));
        this.gSc.setText(aq.aM(this.fWC.getPostNum()));
    }

    private String om(String str) {
        return aq.i(str, 8) + this.context.getString(R.string.forum);
    }
}
