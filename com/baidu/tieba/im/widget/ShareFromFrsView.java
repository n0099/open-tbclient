package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private Context context;
    private TextView dpg;
    private HeadImageView ilp;
    private ShareFromFrsMsgData ils;
    private TextView jlj;
    private TextView jlk;
    private TextView jll;
    private TextView jlm;

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
        this.dpg = (TextView) findViewById(R.id.frs_name);
        this.ilp = (HeadImageView) findViewById(R.id.frs_img);
        this.jlk = (TextView) findViewById(R.id.frs_member_num);
        this.jlm = (TextView) findViewById(R.id.frs_post_num);
        this.jlj = (TextView) findViewById(R.id.frs_member_num_label);
        this.jll = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.dpg.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.jlk.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.jlm.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.jlj.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.jll.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.dpg.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jlk.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jlm.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jlj.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jll.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.ils = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.dpg.setText(getShortName(this.ils.getName()));
        this.ilp.setPlaceHolder(1);
        this.ilp.setAutoChangeStyle(false);
        this.ilp.startLoad(this.ils.getImageUrl(), 10, false);
        this.jlk.setText(as.numFormatOver10000(this.ils.getMemberNum()));
        this.jlm.setText(as.numFormatOver10000(this.ils.getPostNum()));
    }

    private String getShortName(String str) {
        return as.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
