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
    private TextView aSn;
    private TextView axa;
    private HeadImageView cJs;
    private ShareFromPBMsgData dJx;

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
        this.axa = (TextView) findViewById(d.h.chat_title);
        this.cJs = (HeadImageView) findViewById(d.h.chat_group_img);
        this.aSn = (TextView) findViewById(d.h.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.axa.setTextColor(getContext().getResources().getColor(d.e.cp_cont_b));
            this.aSn.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            return;
        }
        this.axa.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.aSn.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dJx = shareFromPBMsgData;
        wO();
    }

    private void wO() {
        this.axa.setText(this.dJx.getTitle());
        this.cJs.setDefaultResource(d.g.icon_default_ba_120);
        this.cJs.setAutoChangeStyle(false);
        this.cJs.c(this.dJx.getImageUrl(), 10, false);
        this.aSn.setText(this.dJx.getContent());
    }
}
