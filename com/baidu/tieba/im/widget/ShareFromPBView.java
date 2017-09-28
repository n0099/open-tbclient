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
    private TextView aTm;
    private TextView awk;
    private HeadImageView cKi;
    private ShareFromPBMsgData dFM;

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
        this.awk = (TextView) findViewById(d.h.chat_title);
        this.cKi = (HeadImageView) findViewById(d.h.chat_group_img);
        this.aTm = (TextView) findViewById(d.h.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.awk.setTextColor(getContext().getResources().getColor(d.e.cp_cont_b));
            this.aTm.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            return;
        }
        this.awk.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.aTm.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dFM = shareFromPBMsgData;
        wn();
    }

    private void wn() {
        this.awk.setText(this.dFM.getTitle());
        this.cKi.setDefaultResource(d.g.icon_default_ba_120);
        this.cKi.setAutoChangeStyle(false);
        this.cKi.c(this.dFM.getImageUrl(), 10, false);
        this.aTm.setText(this.dFM.getContent());
    }
}
