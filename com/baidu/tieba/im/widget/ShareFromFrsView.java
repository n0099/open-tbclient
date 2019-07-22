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
    private TextView bmT;
    private Context context;
    private HeadImageView fVJ;
    private ShareFromFrsMsgData fVM;
    private TextView gRh;
    private TextView gRi;
    private TextView gRj;
    private TextView gRk;

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
        this.bmT = (TextView) findViewById(R.id.frs_name);
        this.fVJ = (HeadImageView) findViewById(R.id.frs_img);
        this.gRi = (TextView) findViewById(R.id.frs_member_num);
        this.gRk = (TextView) findViewById(R.id.frs_post_num);
        this.gRh = (TextView) findViewById(R.id.frs_member_num_label);
        this.gRj = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.bmT.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.gRi.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gRk.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gRh.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.gRj.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.bmT.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gRi.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gRk.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gRh.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gRj.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.fVM = shareFromFrsMsgData;
        JS();
    }

    private void JS() {
        this.bmT.setText(om(this.fVM.getName()));
        this.fVJ.setDefaultResource(R.drawable.icon_default_ba_120);
        this.fVJ.setAutoChangeStyle(false);
        this.fVJ.startLoad(this.fVM.getImageUrl(), 10, false);
        this.gRi.setText(aq.aM(this.fVM.getMemberNum()));
        this.gRk.setText(aq.aM(this.fVM.getPostNum()));
    }

    private String om(String str) {
        return aq.i(str, 8) + this.context.getString(R.string.forum);
    }
}
