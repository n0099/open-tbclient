package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private HeadImageView dHD;
    private TextView dHU;
    private ShareFromPBMsgData ezy;
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
        LayoutInflater.from(getContext()).inflate(d.i.share_from_pb_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(d.g.chat_title);
        this.dHD = (HeadImageView) findViewById(d.g.chat_group_img);
        this.dHU = (TextView) findViewById(d.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_b));
            this.dHU.setTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_g));
        this.dHU.setTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.ezy = shareFromPBMsgData;
        AB();
    }

    private void AB() {
        this.title.setText(this.ezy.getTitle());
        this.dHD.setDefaultResource(d.f.icon_default_ba_120);
        this.dHD.setAutoChangeStyle(false);
        this.dHD.startLoad(this.ezy.getImageUrl(), 10, false);
        this.dHU.setText(this.ezy.getContent());
    }
}
