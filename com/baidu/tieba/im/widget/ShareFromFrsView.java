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
    private TextView cqf;
    private HeadImageView gOJ;
    private ShareFromFrsMsgData gOM;
    private TextView hII;
    private TextView hIJ;
    private TextView hIK;
    private TextView hIL;

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
        this.cqf = (TextView) findViewById(R.id.frs_name);
        this.gOJ = (HeadImageView) findViewById(R.id.frs_img);
        this.hIJ = (TextView) findViewById(R.id.frs_member_num);
        this.hIL = (TextView) findViewById(R.id.frs_post_num);
        this.hII = (TextView) findViewById(R.id.frs_member_num_label);
        this.hIK = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.cqf.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.hIJ.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.hIL.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.hII.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.hIK.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.cqf.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hIJ.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hIL.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hII.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hIK.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.gOM = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.cqf.setText(getShortName(this.gOM.getName()));
        this.gOJ.setPlaceHolder(1);
        this.gOJ.setAutoChangeStyle(false);
        this.gOJ.startLoad(this.gOM.getImageUrl(), 10, false);
        this.hIJ.setText(aq.numFormatOver10000(this.gOM.getMemberNum()));
        this.hIL.setText(aq.numFormatOver10000(this.gOM.getPostNum()));
    }

    private String getShortName(String str) {
        return aq.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
