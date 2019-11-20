package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private HeadImageView fWU;
    private ShareFromPBMsgData gRl;
    private TextView gvP;
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
        this.fWU = (HeadImageView) findViewById(R.id.chat_group_img);
        this.gvP = (TextView) findViewById(R.id.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(R.color.cp_cont_b));
            this.gvP.setTextColor(getContext().getResources().getColor(R.color.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
        this.gvP.setTextColor(getContext().getResources().getColor(R.color.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.gRl = shareFromPBMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.gRl.getTitle());
        this.fWU.setDefaultResource(R.drawable.icon_default_ba_120);
        this.fWU.setAutoChangeStyle(false);
        this.fWU.startLoad(this.gRl.getImageUrl(), 10, false);
        this.gvP.setText(this.gRl.getContent());
    }
}
