package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private TextView bmf;
    private Context context;
    private HeadImageView fQK;
    private ShareFromFrsMsgData fQN;
    private TextView gKV;
    private TextView gKW;
    private TextView gKX;
    private TextView gKY;

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
        this.bmf = (TextView) findViewById(R.id.frs_name);
        this.fQK = (HeadImageView) findViewById(R.id.frs_img);
        this.gKW = (TextView) findViewById(R.id.frs_member_num);
        this.gKY = (TextView) findViewById(R.id.frs_post_num);
        this.gKV = (TextView) findViewById(R.id.frs_member_num_label);
        this.gKX = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bmf.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.gKW.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gKY.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gKV.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gKX.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.bmf.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gKW.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gKY.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gKV.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gKX.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.fQN = shareFromFrsMsgData;
        Jf();
    }

    private void Jf() {
        this.bmf.setText(nV(this.fQN.getName()));
        this.fQK.setDefaultResource(R.drawable.icon_default_ba_120);
        this.fQK.setAutoChangeStyle(false);
        this.fQK.startLoad(this.fQN.getImageUrl(), 10, false);
        this.gKW.setText(ap.aL(this.fQN.getMemberNum()));
        this.gKY.setText(ap.aL(this.fQN.getPostNum()));
    }

    private String nV(String str) {
        return ap.i(str, 8) + this.context.getString(R.string.forum);
    }
}
