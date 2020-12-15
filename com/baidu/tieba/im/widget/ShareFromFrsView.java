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
    private HeadImageView jCu;
    private ShareFromFrsMsgData jCx;
    private TextView kEr;
    private TextView kEs;
    private TextView kEt;
    private TextView kEu;

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
        this.jCu = (HeadImageView) findViewById(R.id.frs_img);
        this.kEs = (TextView) findViewById(R.id.frs_member_num);
        this.kEu = (TextView) findViewById(R.id.frs_post_num);
        this.kEr = (TextView) findViewById(R.id.frs_member_num_label);
        this.kEt = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.egV.setTextColor(getContext().getResources().getColor(R.color.CAM_X0105));
            this.kEs.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kEu.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kEr.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kEt.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            return;
        }
        this.egV.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kEs.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kEu.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kEr.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kEt.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.jCx = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.egV.setText(getShortName(this.jCx.getName()));
        this.jCu.setPlaceHolder(1);
        this.jCu.setAutoChangeStyle(false);
        this.jCu.startLoad(this.jCx.getImageUrl(), 10, false);
        this.kEs.setText(au.numFormatOver10000(this.jCx.getMemberNum()));
        this.kEu.setText(au.numFormatOver10000(this.jCx.getPostNum()));
    }

    private String getShortName(String str) {
        return au.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
