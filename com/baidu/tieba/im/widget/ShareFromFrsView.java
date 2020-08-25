package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ShareFromFrsView extends LinearLayout {
    private Context context;
    private TextView dzi;
    private HeadImageView izs;
    private ShareFromFrsMsgData izv;
    private TextView jAi;
    private TextView jAj;
    private TextView jAk;
    private TextView jAl;

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
        this.dzi = (TextView) findViewById(R.id.frs_name);
        this.izs = (HeadImageView) findViewById(R.id.frs_img);
        this.jAj = (TextView) findViewById(R.id.frs_member_num);
        this.jAl = (TextView) findViewById(R.id.frs_post_num);
        this.jAi = (TextView) findViewById(R.id.frs_member_num_label);
        this.jAk = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.dzi.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.jAj.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.jAl.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.jAi.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.jAk.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.dzi.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jAj.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jAl.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jAi.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jAk.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.izv = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.dzi.setText(getShortName(this.izv.getName()));
        this.izs.setPlaceHolder(1);
        this.izs.setAutoChangeStyle(false);
        this.izs.startLoad(this.izv.getImageUrl(), 10, false);
        this.jAj.setText(at.numFormatOver10000(this.izv.getMemberNum()));
        this.jAl.setText(at.numFormatOver10000(this.izv.getPostNum()));
    }

    private String getShortName(String str) {
        return at.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
