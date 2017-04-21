package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private TextView aOz;
    private TextView auQ;
    private HeadImageView cgx;
    private ShareFromPBMsgData diO;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public ShareFromPBView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(w.j.share_from_pb_view, this);
        setOrientation(1);
        this.auQ = (TextView) findViewById(w.h.chat_title);
        this.cgx = (HeadImageView) findViewById(w.h.chat_group_img);
        this.aOz = (TextView) findViewById(w.h.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.auQ.setTextColor(getContext().getResources().getColor(w.e.cp_cont_b));
            this.aOz.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            return;
        }
        this.auQ.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.aOz.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.diO = shareFromPBMsgData;
        wU();
    }

    private void wU() {
        this.auQ.setText(this.diO.getTitle());
        this.cgx.setDefaultResource(w.g.icon_default_ba_120);
        this.cgx.setAutoChangeStyle(false);
        this.cgx.c(this.diO.getImageUrl(), 10, false);
        this.aOz.setText(this.diO.getContent());
    }
}
