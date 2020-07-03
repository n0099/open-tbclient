package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private Context context;
    private TextView djl;
    private HeadImageView ifn;
    private ShareFromFrsMsgData ifq;
    private TextView jcM;
    private TextView jcN;
    private TextView jcO;
    private TextView jcP;

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
        this.djl = (TextView) findViewById(R.id.frs_name);
        this.ifn = (HeadImageView) findViewById(R.id.frs_img);
        this.jcN = (TextView) findViewById(R.id.frs_member_num);
        this.jcP = (TextView) findViewById(R.id.frs_post_num);
        this.jcM = (TextView) findViewById(R.id.frs_member_num_label);
        this.jcO = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.djl.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.jcN.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.jcP.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.jcM.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.jcO.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.djl.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jcN.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jcP.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jcM.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jcO.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.ifq = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.djl.setText(getShortName(this.ifq.getName()));
        this.ifn.setPlaceHolder(1);
        this.ifn.setAutoChangeStyle(false);
        this.ifn.startLoad(this.ifq.getImageUrl(), 10, false);
        this.jcN.setText(ar.numFormatOver10000(this.ifq.getMemberNum()));
        this.jcP.setText(ar.numFormatOver10000(this.ifq.getPostNum()));
    }

    private String getShortName(String str) {
        return ar.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
