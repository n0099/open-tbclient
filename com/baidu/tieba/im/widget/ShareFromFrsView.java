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
    private TextView cuv;
    private HeadImageView gSe;
    private ShareFromFrsMsgData gSh;
    private TextView hMv;
    private TextView hMw;
    private TextView hMx;
    private TextView hMy;

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
        this.cuv = (TextView) findViewById(R.id.frs_name);
        this.gSe = (HeadImageView) findViewById(R.id.frs_img);
        this.hMw = (TextView) findViewById(R.id.frs_member_num);
        this.hMy = (TextView) findViewById(R.id.frs_post_num);
        this.hMv = (TextView) findViewById(R.id.frs_member_num_label);
        this.hMx = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.cuv.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.hMw.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.hMy.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.hMv.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.hMx.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.cuv.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hMw.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hMy.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hMv.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hMx.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.gSh = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.cuv.setText(getShortName(this.gSh.getName()));
        this.gSe.setPlaceHolder(1);
        this.gSe.setAutoChangeStyle(false);
        this.gSe.startLoad(this.gSh.getImageUrl(), 10, false);
        this.hMw.setText(aq.numFormatOver10000(this.gSh.getMemberNum()));
        this.hMy.setText(aq.numFormatOver10000(this.gSh.getPostNum()));
    }

    private String getShortName(String str) {
        return aq.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
