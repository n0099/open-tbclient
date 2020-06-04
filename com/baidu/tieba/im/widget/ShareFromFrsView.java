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
    private Context context;
    private TextView dez;
    private HeadImageView hRL;
    private ShareFromFrsMsgData hRO;
    private TextView iLK;
    private TextView iLL;
    private TextView iLM;
    private TextView iLN;

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
        this.dez = (TextView) findViewById(R.id.frs_name);
        this.hRL = (HeadImageView) findViewById(R.id.frs_img);
        this.iLL = (TextView) findViewById(R.id.frs_member_num);
        this.iLN = (TextView) findViewById(R.id.frs_post_num);
        this.iLK = (TextView) findViewById(R.id.frs_member_num_label);
        this.iLM = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.dez.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.iLL.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.iLN.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.iLK.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.iLM.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.dez.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.iLL.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.iLN.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.iLK.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.iLM.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.hRO = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.dez.setText(getShortName(this.hRO.getName()));
        this.hRL.setPlaceHolder(1);
        this.hRL.setAutoChangeStyle(false);
        this.hRL.startLoad(this.hRO.getImageUrl(), 10, false);
        this.iLL.setText(aq.numFormatOver10000(this.hRO.getMemberNum()));
        this.iLN.setText(aq.numFormatOver10000(this.hRO.getPostNum()));
    }

    private String getShortName(String str) {
        return aq.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
