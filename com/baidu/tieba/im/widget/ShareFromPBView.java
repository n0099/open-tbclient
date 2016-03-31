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
    private TextView aJE;
    private TextView apE;
    private HeadImageView bwO;
    private ShareFromPBMsgData crB;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        pU();
    }

    public ShareFromPBView(Context context) {
        super(context);
        pU();
    }

    private void pU() {
        LayoutInflater.from(getContext()).inflate(t.h.share_from_pb_view, this);
        setOrientation(1);
        this.apE = (TextView) findViewById(t.g.chat_title);
        this.bwO = (HeadImageView) findViewById(t.g.chat_group_img);
        this.aJE = (TextView) findViewById(t.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.apE.setTextColor(getContext().getResources().getColor(t.d.cp_cont_b));
            this.aJE.setTextColor(getContext().getResources().getColor(t.d.cp_cont_f));
            return;
        }
        this.apE.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
        this.aJE.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.crB = shareFromPBMsgData;
        xo();
    }

    private void xo() {
        this.apE.setText(this.crB.getTitle());
        this.bwO.setDefaultResource(t.f.icon_default_ba_120);
        this.bwO.setAutoChangeStyle(false);
        this.bwO.c(this.crB.getImageUrl(), 10, false);
        this.aJE.setText(this.crB.getContent());
    }
}
