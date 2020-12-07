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
    private TextView egV;
    private HeadImageView jCs;
    private ShareFromFrsMsgData jCv;
    private TextView kEp;
    private TextView kEq;
    private TextView kEr;
    private TextView kEs;

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
        this.egV = (TextView) findViewById(R.id.frs_name);
        this.jCs = (HeadImageView) findViewById(R.id.frs_img);
        this.kEq = (TextView) findViewById(R.id.frs_member_num);
        this.kEs = (TextView) findViewById(R.id.frs_post_num);
        this.kEp = (TextView) findViewById(R.id.frs_member_num_label);
        this.kEr = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.egV.setTextColor(getContext().getResources().getColor(R.color.CAM_X0105));
            this.kEq.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kEs.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kEp.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kEr.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            return;
        }
        this.egV.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kEq.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kEs.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kEp.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kEr.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.jCv = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.egV.setText(getShortName(this.jCv.getName()));
        this.jCs.setPlaceHolder(1);
        this.jCs.setAutoChangeStyle(false);
        this.jCs.startLoad(this.jCv.getImageUrl(), 10, false);
        this.kEq.setText(au.numFormatOver10000(this.jCv.getMemberNum()));
        this.kEs.setText(au.numFormatOver10000(this.jCv.getPostNum()));
    }

    private String getShortName(String str) {
        return au.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
