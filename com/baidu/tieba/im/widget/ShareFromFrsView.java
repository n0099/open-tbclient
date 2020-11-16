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
    private TextView dZV;
    private HeadImageView joQ;
    private ShareFromFrsMsgData joT;
    private TextView kqT;
    private TextView kqU;
    private TextView kqV;
    private TextView kqW;

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
        this.dZV = (TextView) findViewById(R.id.frs_name);
        this.joQ = (HeadImageView) findViewById(R.id.frs_img);
        this.kqU = (TextView) findViewById(R.id.frs_member_num);
        this.kqW = (TextView) findViewById(R.id.frs_post_num);
        this.kqT = (TextView) findViewById(R.id.frs_member_num_label);
        this.kqV = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.dZV.setTextColor(getContext().getResources().getColor(R.color.CAM_X0105));
            this.kqU.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kqW.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kqT.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kqV.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            return;
        }
        this.dZV.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kqU.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kqW.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kqT.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kqV.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.joT = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.dZV.setText(getShortName(this.joT.getName()));
        this.joQ.setPlaceHolder(1);
        this.joQ.setAutoChangeStyle(false);
        this.joQ.startLoad(this.joT.getImageUrl(), 10, false);
        this.kqU.setText(au.numFormatOver10000(this.joT.getMemberNum()));
        this.kqW.setText(au.numFormatOver10000(this.joT.getPostNum()));
    }

    private String getShortName(String str) {
        return au.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
