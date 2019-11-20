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
    private TextView bFm;
    private Context context;
    private HeadImageView fWU;
    private ShareFromFrsMsgData fWX;
    private TextView gRb;
    private TextView gRc;
    private TextView gRd;
    private TextView gRe;

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
        this.bFm = (TextView) findViewById(R.id.frs_name);
        this.fWU = (HeadImageView) findViewById(R.id.frs_img);
        this.gRc = (TextView) findViewById(R.id.frs_member_num);
        this.gRe = (TextView) findViewById(R.id.frs_post_num);
        this.gRb = (TextView) findViewById(R.id.frs_member_num_label);
        this.gRd = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bFm.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.gRc.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gRe.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gRb.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gRd.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.bFm.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gRc.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gRe.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gRb.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gRd.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.fWX = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.bFm.setText(getShortName(this.fWX.getName()));
        this.fWU.setDefaultResource(R.drawable.icon_default_ba_120);
        this.fWU.setAutoChangeStyle(false);
        this.fWU.startLoad(this.fWX.getImageUrl(), 10, false);
        this.gRc.setText(aq.numFormatOver10000(this.fWX.getMemberNum()));
        this.gRe.setText(aq.numFormatOver10000(this.fWX.getPostNum()));
    }

    private String getShortName(String str) {
        return aq.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
