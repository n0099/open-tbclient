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
    private TextView cpT;
    private HeadImageView gLv;
    private ShareFromFrsMsgData gLy;
    private TextView hFf;
    private TextView hFg;
    private TextView hFh;
    private TextView hFi;

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
        this.cpT = (TextView) findViewById(R.id.frs_name);
        this.gLv = (HeadImageView) findViewById(R.id.frs_img);
        this.hFg = (TextView) findViewById(R.id.frs_member_num);
        this.hFi = (TextView) findViewById(R.id.frs_post_num);
        this.hFf = (TextView) findViewById(R.id.frs_member_num_label);
        this.hFh = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.cpT.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.hFg.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.hFi.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.hFf.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.hFh.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.cpT.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hFg.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hFi.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hFf.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hFh.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.gLy = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.cpT.setText(getShortName(this.gLy.getName()));
        this.gLv.setPlaceHolder(1);
        this.gLv.setAutoChangeStyle(false);
        this.gLv.startLoad(this.gLy.getImageUrl(), 10, false);
        this.hFg.setText(aq.numFormatOver10000(this.gLy.getMemberNum()));
        this.hFi.setText(aq.numFormatOver10000(this.gLy.getPostNum()));
    }

    private String getShortName(String str) {
        return aq.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
