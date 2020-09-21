package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private Context context;
    private TextView dBn;
    private HeadImageView iGT;
    private ShareFromFrsMsgData iGW;
    private TextView jIQ;
    private TextView jIR;
    private TextView jIS;
    private TextView jIT;

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
        this.dBn = (TextView) findViewById(R.id.frs_name);
        this.iGT = (HeadImageView) findViewById(R.id.frs_img);
        this.jIR = (TextView) findViewById(R.id.frs_member_num);
        this.jIT = (TextView) findViewById(R.id.frs_post_num);
        this.jIQ = (TextView) findViewById(R.id.frs_member_num_label);
        this.jIS = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.dBn.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.jIR.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.jIT.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.jIQ.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.jIS.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.dBn.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jIR.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jIT.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jIQ.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jIS.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.iGW = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.dBn.setText(getShortName(this.iGW.getName()));
        this.iGT.setPlaceHolder(1);
        this.iGT.setAutoChangeStyle(false);
        this.iGT.startLoad(this.iGW.getImageUrl(), 10, false);
        this.jIR.setText(at.numFormatOver10000(this.iGW.getMemberNum()));
        this.jIT.setText(at.numFormatOver10000(this.iGW.getPostNum()));
    }

    private String getShortName(String str) {
        return at.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
