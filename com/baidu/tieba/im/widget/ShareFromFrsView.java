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
/* loaded from: classes.dex */
public class ShareFromFrsView extends LinearLayout {
    private Context context;
    private TextView dzm;
    private ShareFromFrsMsgData izB;
    private HeadImageView izy;
    private TextView jAo;
    private TextView jAp;
    private TextView jAq;
    private TextView jAr;

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
        this.dzm = (TextView) findViewById(R.id.frs_name);
        this.izy = (HeadImageView) findViewById(R.id.frs_img);
        this.jAp = (TextView) findViewById(R.id.frs_member_num);
        this.jAr = (TextView) findViewById(R.id.frs_post_num);
        this.jAo = (TextView) findViewById(R.id.frs_member_num_label);
        this.jAq = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.dzm.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.jAp.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.jAr.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.jAo.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            this.jAq.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.dzm.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jAp.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jAr.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jAo.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jAq.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.izB = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.dzm.setText(getShortName(this.izB.getName()));
        this.izy.setPlaceHolder(1);
        this.izy.setAutoChangeStyle(false);
        this.izy.startLoad(this.izB.getImageUrl(), 10, false);
        this.jAp.setText(at.numFormatOver10000(this.izB.getMemberNum()));
        this.jAr.setText(at.numFormatOver10000(this.izB.getPostNum()));
    }

    private String getShortName(String str) {
        return at.cutString(str, 8) + this.context.getString(R.string.forum);
    }
}
