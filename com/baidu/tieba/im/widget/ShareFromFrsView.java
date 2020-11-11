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
    private TextView ebD;
    private HeadImageView joe;
    private ShareFromFrsMsgData joh;
    private TextView kqj;
    private TextView kqk;
    private TextView kql;
    private TextView kqm;

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
        this.ebD = (TextView) findViewById(R.id.frs_name);
        this.joe = (HeadImageView) findViewById(R.id.frs_img);
        this.kqk = (TextView) findViewById(R.id.frs_member_num);
        this.kqm = (TextView) findViewById(R.id.frs_post_num);
        this.kqj = (TextView) findViewById(R.id.frs_member_num_label);
        this.kql = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.ebD.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.kqk.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.kqm.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.kqj.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.kql.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.ebD.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.kqk.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.kqm.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.kqj.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.kql.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.joh = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.ebD.setText(getShortName(this.joh.getName()));
        this.joe.setPlaceHolder(1);
        this.joe.setAutoChangeStyle(false);
        this.joe.startLoad(this.joh.getImageUrl(), 10, false);
        this.kqk.setText(at.numFormatOver10000(this.joh.getMemberNum()));
        this.kqm.setText(at.numFormatOver10000(this.joh.getPostNum()));
    }

    private String getShortName(String str) {
        return at.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
