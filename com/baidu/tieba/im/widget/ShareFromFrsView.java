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
    private TextView cTr;
    private Context context;
    private HeadImageView hCf;
    private ShareFromFrsMsgData hCi;
    private TextView iwl;
    private TextView iwm;
    private TextView iwn;
    private TextView iwo;

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
        this.cTr = (TextView) findViewById(R.id.frs_name);
        this.hCf = (HeadImageView) findViewById(R.id.frs_img);
        this.iwm = (TextView) findViewById(R.id.frs_member_num);
        this.iwo = (TextView) findViewById(R.id.frs_post_num);
        this.iwl = (TextView) findViewById(R.id.frs_member_num_label);
        this.iwn = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.cTr.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.iwm.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.iwo.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.iwl.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.iwn.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.cTr.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.iwm.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.iwo.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.iwl.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.iwn.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.hCi = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.cTr.setText(getShortName(this.hCi.getName()));
        this.hCf.setPlaceHolder(1);
        this.hCf.setAutoChangeStyle(false);
        this.hCf.startLoad(this.hCi.getImageUrl(), 10, false);
        this.iwm.setText(aq.numFormatOver10000(this.hCi.getMemberNum()));
        this.iwo.setText(aq.numFormatOver10000(this.hCi.getPostNum()));
    }

    private String getShortName(String str) {
        return aq.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
