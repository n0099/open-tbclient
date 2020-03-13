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
    private TextView cui;
    private HeadImageView gQX;
    private ShareFromFrsMsgData gRa;
    private TextView hKV;
    private TextView hKW;
    private TextView hKX;
    private TextView hKY;

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
        this.cui = (TextView) findViewById(R.id.frs_name);
        this.gQX = (HeadImageView) findViewById(R.id.frs_img);
        this.hKW = (TextView) findViewById(R.id.frs_member_num);
        this.hKY = (TextView) findViewById(R.id.frs_post_num);
        this.hKV = (TextView) findViewById(R.id.frs_member_num_label);
        this.hKX = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.cui.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.hKW.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.hKY.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.hKV.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.hKX.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.cui.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hKW.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hKY.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hKV.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hKX.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.gRa = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.cui.setText(getShortName(this.gRa.getName()));
        this.gQX.setPlaceHolder(1);
        this.gQX.setAutoChangeStyle(false);
        this.gQX.startLoad(this.gRa.getImageUrl(), 10, false);
        this.hKW.setText(aq.numFormatOver10000(this.gRa.getMemberNum()));
        this.hKY.setText(aq.numFormatOver10000(this.gRa.getPostNum()));
    }

    private String getShortName(String str) {
        return aq.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
