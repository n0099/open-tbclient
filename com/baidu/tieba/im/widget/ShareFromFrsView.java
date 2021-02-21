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
    private HeadImageView jRB;
    private ShareFromFrsMsgData jRE;
    private TextView kNo;
    private TextView kNp;
    private TextView kNq;
    private TextView kNr;

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
        this.jRB = (HeadImageView) findViewById(R.id.frs_img);
        this.kNp = (TextView) findViewById(R.id.frs_member_num);
        this.kNr = (TextView) findViewById(R.id.frs_post_num);
        this.kNo = (TextView) findViewById(R.id.frs_member_num_label);
        this.kNq = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.enq.setTextColor(getContext().getResources().getColor(R.color.CAM_X0105));
            this.kNp.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kNr.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kNo.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.kNq.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            return;
        }
        this.enq.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kNp.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kNr.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kNo.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.kNq.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.jRE = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.enq.setText(getShortName(this.jRE.getName()));
        this.jRB.setPlaceHolder(1);
        this.jRB.setAutoChangeStyle(false);
        this.jRB.startLoad(this.jRE.getImageUrl(), 10, false);
        this.kNp.setText(au.numFormatOver10000(this.jRE.getMemberNum()));
        this.kNr.setText(au.numFormatOver10000(this.jRE.getPostNum()));
    }

    private String getShortName(String str) {
        return au.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
