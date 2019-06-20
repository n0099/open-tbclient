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
    private HeadImageView fQM;
    private ShareFromFrsMsgData fQP;
    private TextView gKX;
    private TextView gKY;
    private TextView gKZ;
    private TextView gLa;

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
        this.fQM = (HeadImageView) findViewById(R.id.frs_img);
        this.gKY = (TextView) findViewById(R.id.frs_member_num);
        this.gLa = (TextView) findViewById(R.id.frs_post_num);
        this.gKX = (TextView) findViewById(R.id.frs_member_num_label);
        this.gKZ = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bmf.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.gKY.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gLa.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gKX.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gKZ.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.bmf.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gKY.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gLa.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gKX.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gKZ.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.fQP = shareFromFrsMsgData;
        Jf();
    }

    private void Jf() {
        this.bmf.setText(nU(this.fQP.getName()));
        this.fQM.setDefaultResource(R.drawable.icon_default_ba_120);
        this.fQM.setAutoChangeStyle(false);
        this.fQM.startLoad(this.fQP.getImageUrl(), 10, false);
        this.gKY.setText(ap.aL(this.fQP.getMemberNum()));
        this.gLa.setText(ap.aL(this.fQP.getPostNum()));
    }

    private String nU(String str) {
        return ap.i(str, 8) + this.context.getString(R.string.forum);
    }
}
