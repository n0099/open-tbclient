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
    private TextView aKu;
    private HeadImageView chq;
    private ShareFromPBMsgData dms;
    private TextView title;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public ShareFromPBView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(t.h.share_from_pb_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(t.g.chat_title);
        this.chq = (HeadImageView) findViewById(t.g.chat_group_img);
        this.aKu = (TextView) findViewById(t.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(t.d.cp_cont_b));
            this.aKu.setTextColor(getContext().getResources().getColor(t.d.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
        this.aKu.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dms = shareFromPBMsgData;
        wc();
    }

    private void wc() {
        this.title.setText(this.dms.getTitle());
        this.chq.setDefaultResource(t.f.icon_default_ba_120);
        this.chq.setAutoChangeStyle(false);
        this.chq.c(this.dms.getImageUrl(), 10, false);
        this.aKu.setText(this.dms.getContent());
    }
}
