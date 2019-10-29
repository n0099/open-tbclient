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
    private TextView bGd;
    private Context context;
    private HeadImageView fXL;
    private ShareFromFrsMsgData fXO;
    private TextView gRS;
    private TextView gRT;
    private TextView gRU;
    private TextView gRV;

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
        this.bGd = (TextView) findViewById(R.id.frs_name);
        this.fXL = (HeadImageView) findViewById(R.id.frs_img);
        this.gRT = (TextView) findViewById(R.id.frs_member_num);
        this.gRV = (TextView) findViewById(R.id.frs_post_num);
        this.gRS = (TextView) findViewById(R.id.frs_member_num_label);
        this.gRU = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bGd.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.gRT.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gRV.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gRS.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gRU.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.bGd.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gRT.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gRV.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gRS.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gRU.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.fXO = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.bGd.setText(getShortName(this.fXO.getName()));
        this.fXL.setDefaultResource(R.drawable.icon_default_ba_120);
        this.fXL.setAutoChangeStyle(false);
        this.fXL.startLoad(this.fXO.getImageUrl(), 10, false);
        this.gRT.setText(aq.numFormatOver10000(this.fXO.getMemberNum()));
        this.gRV.setText(aq.numFormatOver10000(this.fXO.getPostNum()));
    }

    private String getShortName(String str) {
        return aq.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
