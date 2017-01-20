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
    private TextView aIK;
    private TextView apd;
    private HeadImageView bYk;
    private ShareFromPBMsgData dfH;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public ShareFromPBView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(r.j.share_from_pb_view, this);
        setOrientation(1);
        this.apd = (TextView) findViewById(r.h.chat_title);
        this.bYk = (HeadImageView) findViewById(r.h.chat_group_img);
        this.aIK = (TextView) findViewById(r.h.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.apd.setTextColor(getContext().getResources().getColor(r.e.cp_cont_b));
            this.aIK.setTextColor(getContext().getResources().getColor(r.e.cp_cont_f));
            return;
        }
        this.apd.setTextColor(getContext().getResources().getColor(r.e.cp_cont_g));
        this.aIK.setTextColor(getContext().getResources().getColor(r.e.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dfH = shareFromPBMsgData;
        wb();
    }

    private void wb() {
        this.apd.setText(this.dfH.getTitle());
        this.bYk.setDefaultResource(r.g.icon_default_ba_120);
        this.bYk.setAutoChangeStyle(false);
        this.bYk.c(this.dfH.getImageUrl(), 10, false);
        this.aIK.setText(this.dfH.getContent());
    }
}
