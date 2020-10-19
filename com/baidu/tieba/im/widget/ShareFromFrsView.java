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
    private TextView dNo;
    private HeadImageView iVJ;
    private ShareFromFrsMsgData iVM;
    private TextView jXN;
    private TextView jXO;
    private TextView jXP;
    private TextView jXQ;

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
        this.dNo = (TextView) findViewById(R.id.frs_name);
        this.iVJ = (HeadImageView) findViewById(R.id.frs_img);
        this.jXO = (TextView) findViewById(R.id.frs_member_num);
        this.jXQ = (TextView) findViewById(R.id.frs_post_num);
        this.jXN = (TextView) findViewById(R.id.frs_member_num_label);
        this.jXP = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.dNo.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.jXO.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.jXQ.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.jXN.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.jXP.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.dNo.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jXO.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jXQ.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jXN.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jXP.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.iVM = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.dNo.setText(getShortName(this.iVM.getName()));
        this.iVJ.setPlaceHolder(1);
        this.iVJ.setAutoChangeStyle(false);
        this.iVJ.startLoad(this.iVM.getImageUrl(), 10, false);
        this.jXO.setText(at.numFormatOver10000(this.iVM.getMemberNum()));
        this.jXQ.setText(at.numFormatOver10000(this.iVM.getPostNum()));
    }

    private String getShortName(String str) {
        return at.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
