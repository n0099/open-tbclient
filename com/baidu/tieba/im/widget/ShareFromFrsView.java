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
    private TextView cTw;
    private Context context;
    private HeadImageView hCl;
    private ShareFromFrsMsgData hCo;
    private TextView iwr;
    private TextView iws;
    private TextView iwt;
    private TextView iwu;

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
        this.cTw = (TextView) findViewById(R.id.frs_name);
        this.hCl = (HeadImageView) findViewById(R.id.frs_img);
        this.iws = (TextView) findViewById(R.id.frs_member_num);
        this.iwu = (TextView) findViewById(R.id.frs_post_num);
        this.iwr = (TextView) findViewById(R.id.frs_member_num_label);
        this.iwt = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.cTw.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.iws.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.iwu.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.iwr.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.iwt.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.cTw.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.iws.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.iwu.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.iwr.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.iwt.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.hCo = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.cTw.setText(getShortName(this.hCo.getName()));
        this.hCl.setPlaceHolder(1);
        this.hCl.setAutoChangeStyle(false);
        this.hCl.startLoad(this.hCo.getImageUrl(), 10, false);
        this.iws.setText(aq.numFormatOver10000(this.hCo.getMemberNum()));
        this.iwu.setText(aq.numFormatOver10000(this.hCo.getPostNum()));
    }

    private String getShortName(String str) {
        return aq.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
