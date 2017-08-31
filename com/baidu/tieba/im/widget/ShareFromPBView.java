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
    private TextView aSq;
    private TextView axd;
    private HeadImageView cIy;
    private ShareFromPBMsgData dIC;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public ShareFromPBView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.j.share_from_pb_view, this);
        setOrientation(1);
        this.axd = (TextView) findViewById(d.h.chat_title);
        this.cIy = (HeadImageView) findViewById(d.h.chat_group_img);
        this.aSq = (TextView) findViewById(d.h.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.axd.setTextColor(getContext().getResources().getColor(d.e.cp_cont_b));
            this.aSq.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            return;
        }
        this.axd.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.aSq.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dIC = shareFromPBMsgData;
        wO();
    }

    private void wO() {
        this.axd.setText(this.dIC.getTitle());
        this.cIy.setDefaultResource(d.g.icon_default_ba_120);
        this.cIy.setAutoChangeStyle(false);
        this.cIy.c(this.dIC.getImageUrl(), 10, false);
        this.aSq.setText(this.dIC.getContent());
    }
}
