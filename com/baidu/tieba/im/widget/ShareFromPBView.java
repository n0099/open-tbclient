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
    private TextView aOh;
    private TextView auy;
    private HeadImageView cfG;
    private ShareFromPBMsgData dhY;

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
        this.auy = (TextView) findViewById(w.h.chat_title);
        this.cfG = (HeadImageView) findViewById(w.h.chat_group_img);
        this.aOh = (TextView) findViewById(w.h.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.auy.setTextColor(getContext().getResources().getColor(w.e.cp_cont_b));
            this.aOh.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            return;
        }
        this.auy.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.aOh.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dhY = shareFromPBMsgData;
        wy();
    }

    private void wy() {
        this.auy.setText(this.dhY.getTitle());
        this.cfG.setDefaultResource(w.g.icon_default_ba_120);
        this.cfG.setAutoChangeStyle(false);
        this.cfG.c(this.dhY.getImageUrl(), 10, false);
        this.aOh.setText(this.dhY.getContent());
    }
}
