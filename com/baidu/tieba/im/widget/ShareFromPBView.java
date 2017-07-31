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
    private TextView aSE;
    private TextView axQ;
    private HeadImageView cAk;
    private ShareFromPBMsgData dAb;

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
        this.axQ = (TextView) findViewById(d.h.chat_title);
        this.cAk = (HeadImageView) findViewById(d.h.chat_group_img);
        this.aSE = (TextView) findViewById(d.h.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.axQ.setTextColor(getContext().getResources().getColor(d.e.cp_cont_b));
            this.aSE.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            return;
        }
        this.axQ.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.aSE.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dAb = shareFromPBMsgData;
        wP();
    }

    private void wP() {
        this.axQ.setText(this.dAb.getTitle());
        this.cAk.setDefaultResource(d.g.icon_default_ba_120);
        this.cAk.setAutoChangeStyle(false);
        this.cAk.c(this.dAb.getImageUrl(), 10, false);
        this.aSE.setText(this.dAb.getContent());
    }
}
