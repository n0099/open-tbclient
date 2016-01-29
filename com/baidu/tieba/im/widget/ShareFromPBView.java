package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private TextView aGI;
    private TextView apm;
    private HeadImageView brG;
    private ShareFromPBMsgData cgW;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        qD();
    }

    public ShareFromPBView(Context context) {
        super(context);
        qD();
    }

    private void qD() {
        LayoutInflater.from(getContext()).inflate(t.h.share_from_pb_view, this);
        setOrientation(1);
        this.apm = (TextView) findViewById(t.g.chat_title);
        this.brG = (HeadImageView) findViewById(t.g.chat_group_img);
        this.aGI = (TextView) findViewById(t.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.apm.setTextColor(getContext().getResources().getColor(t.d.cp_cont_b));
            this.aGI.setTextColor(getContext().getResources().getColor(t.d.cp_cont_f));
            return;
        }
        this.apm.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
        this.aGI.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.cgW = shareFromPBMsgData;
        wV();
    }

    private void wV() {
        this.apm.setText(this.cgW.getTitle());
        this.brG.setDefaultResource(t.f.icon_default_ba_120);
        this.brG.setAutoChangeStyle(false);
        this.brG.d(this.cgW.getImageUrl(), 10, false);
        this.aGI.setText(this.cgW.getContent());
    }
}
