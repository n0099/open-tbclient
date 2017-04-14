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
    private TextView aOx;
    private TextView auO;
    private HeadImageView ceg;
    private ShareFromPBMsgData dgx;

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
        this.auO = (TextView) findViewById(w.h.chat_title);
        this.ceg = (HeadImageView) findViewById(w.h.chat_group_img);
        this.aOx = (TextView) findViewById(w.h.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.auO.setTextColor(getContext().getResources().getColor(w.e.cp_cont_b));
            this.aOx.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            return;
        }
        this.auO.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.aOx.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dgx = shareFromPBMsgData;
        wU();
    }

    private void wU() {
        this.auO.setText(this.dgx.getTitle());
        this.ceg.setDefaultResource(w.g.icon_default_ba_120);
        this.ceg.setAutoChangeStyle(false);
        this.ceg.c(this.dgx.getImageUrl(), 10, false);
        this.aOx.setText(this.dgx.getContent());
    }
}
