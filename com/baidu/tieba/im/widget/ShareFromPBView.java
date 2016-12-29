package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private TextView aKd;
    private TextView apY;
    private HeadImageView bRF;
    private ShareFromPBMsgData cYs;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public ShareFromPBView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(r.h.share_from_pb_view, this);
        setOrientation(1);
        this.apY = (TextView) findViewById(r.g.chat_title);
        this.bRF = (HeadImageView) findViewById(r.g.chat_group_img);
        this.aKd = (TextView) findViewById(r.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.apY.setTextColor(getContext().getResources().getColor(r.d.cp_cont_b));
            this.aKd.setTextColor(getContext().getResources().getColor(r.d.cp_cont_f));
            return;
        }
        this.apY.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
        this.aKd.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.cYs = shareFromPBMsgData;
        wg();
    }

    private void wg() {
        this.apY.setText(this.cYs.getTitle());
        this.bRF.setDefaultResource(r.f.icon_default_ba_120);
        this.bRF.setAutoChangeStyle(false);
        this.bRF.c(this.cYs.getImageUrl(), 10, false);
        this.aKd.setText(this.cYs.getContent());
    }
}
