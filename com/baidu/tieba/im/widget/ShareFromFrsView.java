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
    private TextView eoT;
    private HeadImageView jTk;
    private ShareFromFrsMsgData jTn;
    private TextView kPq;
    private TextView kPr;
    private TextView kPs;
    private TextView kPt;

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
        this.eoT = (TextView) findViewById(R.id.frs_name);
        this.jTk = (HeadImageView) findViewById(R.id.frs_img);
        this.kPr = (TextView) findViewById(R.id.frs_member_num);
        this.kPt = (TextView) findViewById(R.id.frs_post_num);
        this.kPq = (TextView) findViewById(R.id.frs_member_num_label);
        this.kPs = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.eoT.setTextColor(getContext().getResources().getColor(R.color.CAM_X0105));
            this.kPr.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kPt.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kPq.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kPs.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            return;
        }
        this.eoT.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kPr.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kPt.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kPq.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kPs.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.jTn = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.eoT.setText(getShortName(this.jTn.getName()));
        this.jTk.setPlaceHolder(1);
        this.jTk.setAutoChangeStyle(false);
        this.jTk.startLoad(this.jTn.getImageUrl(), 10, false);
        this.kPr.setText(au.numFormatOver10000(this.jTn.getMemberNum()));
        this.kPt.setText(au.numFormatOver10000(this.jTn.getPostNum()));
    }

    private String getShortName(String str) {
        return au.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
