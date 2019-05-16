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
    private HeadImageView fQJ;
    private ShareFromFrsMsgData fQM;
    private TextView gKU;
    private TextView gKV;
    private TextView gKW;
    private TextView gKX;

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
        this.fQJ = (HeadImageView) findViewById(R.id.frs_img);
        this.gKV = (TextView) findViewById(R.id.frs_member_num);
        this.gKX = (TextView) findViewById(R.id.frs_post_num);
        this.gKU = (TextView) findViewById(R.id.frs_member_num_label);
        this.gKW = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bmf.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.gKV.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gKX.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gKU.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gKW.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.bmf.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gKV.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gKX.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gKU.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gKW.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.fQM = shareFromFrsMsgData;
        Jf();
    }

    private void Jf() {
        this.bmf.setText(nV(this.fQM.getName()));
        this.fQJ.setDefaultResource(R.drawable.icon_default_ba_120);
        this.fQJ.setAutoChangeStyle(false);
        this.fQJ.startLoad(this.fQM.getImageUrl(), 10, false);
        this.gKV.setText(ap.aL(this.fQM.getMemberNum()));
        this.gKX.setText(ap.aL(this.fQM.getPostNum()));
    }

    private String nV(String str) {
        return ap.i(str, 8) + this.context.getString(R.string.forum);
    }
}
