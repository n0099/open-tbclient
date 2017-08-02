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
    private TextView aRs;
    private TextView awz;
    private HeadImageView cyQ;
    private ShareFromPBMsgData dyK;

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
        this.awz = (TextView) findViewById(d.h.chat_title);
        this.cyQ = (HeadImageView) findViewById(d.h.chat_group_img);
        this.aRs = (TextView) findViewById(d.h.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.awz.setTextColor(getContext().getResources().getColor(d.e.cp_cont_b));
            this.aRs.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            return;
        }
        this.awz.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.aRs.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dyK = shareFromPBMsgData;
        wG();
    }

    private void wG() {
        this.awz.setText(this.dyK.getTitle());
        this.cyQ.setDefaultResource(d.g.icon_default_ba_120);
        this.cyQ.setAutoChangeStyle(false);
        this.cyQ.c(this.dyK.getImageUrl(), 10, false);
        this.aRs.setText(this.dyK.getContent());
    }
}
