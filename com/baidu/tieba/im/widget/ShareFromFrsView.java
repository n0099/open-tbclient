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
    private TextView bnr;
    private Context context;
    private HeadImageView fYq;
    private ShareFromFrsMsgData fYt;
    private TextView gTS;
    private TextView gTT;
    private TextView gTU;
    private TextView gTV;

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
        this.bnr = (TextView) findViewById(R.id.frs_name);
        this.fYq = (HeadImageView) findViewById(R.id.frs_img);
        this.gTT = (TextView) findViewById(R.id.frs_member_num);
        this.gTV = (TextView) findViewById(R.id.frs_post_num);
        this.gTS = (TextView) findViewById(R.id.frs_member_num_label);
        this.gTU = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bnr.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.gTT.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gTV.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gTS.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gTU.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.bnr.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gTT.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gTV.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gTS.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gTU.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.fYt = shareFromFrsMsgData;
        JW();
    }

    private void JW() {
        this.bnr.setText(op(this.fYt.getName()));
        this.fYq.setDefaultResource(R.drawable.icon_default_ba_120);
        this.fYq.setAutoChangeStyle(false);
        this.fYq.startLoad(this.fYt.getImageUrl(), 10, false);
        this.gTT.setText(aq.aM(this.fYt.getMemberNum()));
        this.gTV.setText(aq.aM(this.fYt.getPostNum()));
    }

    private String op(String str) {
        return aq.i(str, 8) + this.context.getString(R.string.forum);
    }
}
