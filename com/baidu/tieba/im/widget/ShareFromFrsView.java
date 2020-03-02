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
    private TextView cuh;
    private HeadImageView gQL;
    private ShareFromFrsMsgData gQO;
    private TextView hKJ;
    private TextView hKK;
    private TextView hKL;
    private TextView hKM;

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
        this.cuh = (TextView) findViewById(R.id.frs_name);
        this.gQL = (HeadImageView) findViewById(R.id.frs_img);
        this.hKK = (TextView) findViewById(R.id.frs_member_num);
        this.hKM = (TextView) findViewById(R.id.frs_post_num);
        this.hKJ = (TextView) findViewById(R.id.frs_member_num_label);
        this.hKL = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.cuh.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.hKK.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.hKM.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.hKJ.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.hKL.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.cuh.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hKK.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hKM.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hKJ.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hKL.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.gQO = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.cuh.setText(getShortName(this.gQO.getName()));
        this.gQL.setPlaceHolder(1);
        this.gQL.setAutoChangeStyle(false);
        this.gQL.startLoad(this.gQO.getImageUrl(), 10, false);
        this.hKK.setText(aq.numFormatOver10000(this.gQO.getMemberNum()));
        this.hKM.setText(aq.numFormatOver10000(this.gQO.getPostNum()));
    }

    private String getShortName(String str) {
        return aq.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
