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
    private TextView aSF;
    private TextView axR;
    private HeadImageView cCi;
    private ShareFromPBMsgData dBY;

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
        this.axR = (TextView) findViewById(d.h.chat_title);
        this.cCi = (HeadImageView) findViewById(d.h.chat_group_img);
        this.aSF = (TextView) findViewById(d.h.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.axR.setTextColor(getContext().getResources().getColor(d.e.cp_cont_b));
            this.aSF.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            return;
        }
        this.axR.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.aSF.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dBY = shareFromPBMsgData;
        wP();
    }

    private void wP() {
        this.axR.setText(this.dBY.getTitle());
        this.cCi.setDefaultResource(d.g.icon_default_ba_120);
        this.cCi.setAutoChangeStyle(false);
        this.cCi.c(this.dBY.getImageUrl(), 10, false);
        this.aSF.setText(this.dBY.getContent());
    }
}
