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
    private TextView dez;
    private HeadImageView hQY;
    private ShareFromFrsMsgData hRb;
    private TextView iKX;
    private TextView iKY;
    private TextView iKZ;
    private TextView iLa;

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
        this.dez = (TextView) findViewById(R.id.frs_name);
        this.hQY = (HeadImageView) findViewById(R.id.frs_img);
        this.iKY = (TextView) findViewById(R.id.frs_member_num);
        this.iLa = (TextView) findViewById(R.id.frs_post_num);
        this.iKX = (TextView) findViewById(R.id.frs_member_num_label);
        this.iKZ = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.dez.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.iKY.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.iLa.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.iKX.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.iKZ.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.dez.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.iKY.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.iLa.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.iKX.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.iKZ.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.hRb = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.dez.setText(getShortName(this.hRb.getName()));
        this.hQY.setPlaceHolder(1);
        this.hQY.setAutoChangeStyle(false);
        this.hQY.startLoad(this.hRb.getImageUrl(), 10, false);
        this.iKY.setText(aq.numFormatOver10000(this.hRb.getMemberNum()));
        this.iLa.setText(aq.numFormatOver10000(this.hRb.getPostNum()));
    }

    private String getShortName(String str) {
        return aq.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
