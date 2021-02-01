package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private Context context;
    private TextView enq;
    private HeadImageView jRn;
    private ShareFromFrsMsgData jRq;
    private TextView kNa;
    private TextView kNb;
    private TextView kNc;
    private TextView kNd;

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
        this.enq = (TextView) findViewById(R.id.frs_name);
        this.jRn = (HeadImageView) findViewById(R.id.frs_img);
        this.kNb = (TextView) findViewById(R.id.frs_member_num);
        this.kNd = (TextView) findViewById(R.id.frs_post_num);
        this.kNa = (TextView) findViewById(R.id.frs_member_num_label);
        this.kNc = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.enq.setTextColor(getContext().getResources().getColor(R.color.CAM_X0105));
            this.kNb.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kNd.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kNa.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kNc.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            return;
        }
        this.enq.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kNb.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kNd.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kNa.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kNc.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.jRq = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.enq.setText(getShortName(this.jRq.getName()));
        this.jRn.setPlaceHolder(1);
        this.jRn.setAutoChangeStyle(false);
        this.jRn.startLoad(this.jRq.getImageUrl(), 10, false);
        this.kNb.setText(au.numFormatOver10000(this.jRq.getMemberNum()));
        this.kNd.setText(au.numFormatOver10000(this.jRq.getPostNum()));
    }

    private String getShortName(String str) {
        return au.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
