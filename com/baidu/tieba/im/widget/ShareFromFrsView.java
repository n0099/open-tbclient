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
    private TextView dVL;
    private HeadImageView jig;
    private ShareFromFrsMsgData jij;
    private TextView kkn;
    private TextView kko;
    private TextView kkp;
    private TextView kkq;

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
        this.dVL = (TextView) findViewById(R.id.frs_name);
        this.jig = (HeadImageView) findViewById(R.id.frs_img);
        this.kko = (TextView) findViewById(R.id.frs_member_num);
        this.kkq = (TextView) findViewById(R.id.frs_post_num);
        this.kkn = (TextView) findViewById(R.id.frs_member_num_label);
        this.kkp = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.dVL.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.kko.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.kkq.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.kkn.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.kkp.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.dVL.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.kko.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.kkq.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.kkn.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.kkp.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.jij = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.dVL.setText(getShortName(this.jij.getName()));
        this.jig.setPlaceHolder(1);
        this.jig.setAutoChangeStyle(false);
        this.jig.startLoad(this.jij.getImageUrl(), 10, false);
        this.kko.setText(at.numFormatOver10000(this.jij.getMemberNum()));
        this.kkq.setText(at.numFormatOver10000(this.jij.getPostNum()));
    }

    private String getShortName(String str) {
        return at.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
