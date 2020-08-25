package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public final class ShareFromPBView extends LinearLayout {
    private HeadImageView izs;
    private ShareFromPBMsgData jAs;
    private TextView jcM;
    private TextView title;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public ShareFromPBView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_from_pb_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(R.id.chat_title);
        this.izs = (HeadImageView) findViewById(R.id.chat_group_img);
        this.jcM = (TextView) findViewById(R.id.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.jcM.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.jcM.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.jAs = shareFromPBMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.jAs.getTitle());
        this.izs.setPlaceHolder(1);
        this.izs.setAutoChangeStyle(false);
        this.izs.startLoad(this.jAs.getImageUrl(), 10, false);
        this.jcM.setText(this.jAs.getContent());
    }
}
