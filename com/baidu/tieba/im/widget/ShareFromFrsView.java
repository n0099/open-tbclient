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
    private TextView cug;
    private HeadImageView gQJ;
    private ShareFromFrsMsgData gQM;
    private TextView hKH;
    private TextView hKI;
    private TextView hKJ;
    private TextView hKK;

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
        this.cug = (TextView) findViewById(R.id.frs_name);
        this.gQJ = (HeadImageView) findViewById(R.id.frs_img);
        this.hKI = (TextView) findViewById(R.id.frs_member_num);
        this.hKK = (TextView) findViewById(R.id.frs_post_num);
        this.hKH = (TextView) findViewById(R.id.frs_member_num_label);
        this.hKJ = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.cug.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.hKI.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.hKK.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.hKH.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.hKJ.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.cug.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hKI.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hKK.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hKH.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.hKJ.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.gQM = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.cug.setText(getShortName(this.gQM.getName()));
        this.gQJ.setPlaceHolder(1);
        this.gQJ.setAutoChangeStyle(false);
        this.gQJ.startLoad(this.gQM.getImageUrl(), 10, false);
        this.hKI.setText(aq.numFormatOver10000(this.gQM.getMemberNum()));
        this.hKK.setText(aq.numFormatOver10000(this.gQM.getPostNum()));
    }

    private String getShortName(String str) {
        return aq.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
