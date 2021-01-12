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
    private TextView eli;
    private HeadImageView jKq;
    private ShareFromFrsMsgData jKt;
    private TextView kEV;
    private TextView kEW;
    private TextView kEX;
    private TextView kEY;

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
        this.eli = (TextView) findViewById(R.id.frs_name);
        this.jKq = (HeadImageView) findViewById(R.id.frs_img);
        this.kEW = (TextView) findViewById(R.id.frs_member_num);
        this.kEY = (TextView) findViewById(R.id.frs_post_num);
        this.kEV = (TextView) findViewById(R.id.frs_member_num_label);
        this.kEX = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.eli.setTextColor(getContext().getResources().getColor(R.color.CAM_X0105));
            this.kEW.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kEY.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kEV.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kEX.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            return;
        }
        this.eli.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kEW.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kEY.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kEV.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kEX.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.jKt = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.eli.setText(getShortName(this.jKt.getName()));
        this.jKq.setPlaceHolder(1);
        this.jKq.setAutoChangeStyle(false);
        this.jKq.startLoad(this.jKt.getImageUrl(), 10, false);
        this.kEW.setText(at.numFormatOver10000(this.jKt.getMemberNum()));
        this.kEY.setText(at.numFormatOver10000(this.jKt.getPostNum()));
    }

    private String getShortName(String str) {
        return at.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
