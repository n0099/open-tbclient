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
    private TextView epX;
    private HeadImageView jOW;
    private ShareFromFrsMsgData jOZ;
    private TextView kJA;
    private TextView kJB;
    private TextView kJC;
    private TextView kJD;

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
        this.epX = (TextView) findViewById(R.id.frs_name);
        this.jOW = (HeadImageView) findViewById(R.id.frs_img);
        this.kJB = (TextView) findViewById(R.id.frs_member_num);
        this.kJD = (TextView) findViewById(R.id.frs_post_num);
        this.kJA = (TextView) findViewById(R.id.frs_member_num_label);
        this.kJC = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.epX.setTextColor(getContext().getResources().getColor(R.color.CAM_X0105));
            this.kJB.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kJD.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kJA.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kJC.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            return;
        }
        this.epX.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kJB.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kJD.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kJA.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kJC.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.jOZ = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.epX.setText(getShortName(this.jOZ.getName()));
        this.jOW.setPlaceHolder(1);
        this.jOW.setAutoChangeStyle(false);
        this.jOW.startLoad(this.jOZ.getImageUrl(), 10, false);
        this.kJB.setText(at.numFormatOver10000(this.jOZ.getMemberNum()));
        this.kJD.setText(at.numFormatOver10000(this.jOZ.getPostNum()));
    }

    private String getShortName(String str) {
        return at.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
