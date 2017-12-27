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
    private TextView bKh;
    private TextView blr;
    private HeadImageView dQf;
    private ShareFromPBMsgData eIs;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public ShareFromPBView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.share_from_pb_view, this);
        setOrientation(1);
        this.blr = (TextView) findViewById(d.g.chat_title);
        this.dQf = (HeadImageView) findViewById(d.g.chat_group_img);
        this.bKh = (TextView) findViewById(d.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.blr.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_b));
            this.bKh.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_f));
            return;
        }
        this.blr.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_g));
        this.bKh.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eIs = shareFromPBMsgData;
        DN();
    }

    private void DN() {
        this.blr.setText(this.eIs.getTitle());
        this.dQf.setDefaultResource(d.f.icon_default_ba_120);
        this.dQf.setAutoChangeStyle(false);
        this.dQf.startLoad(this.eIs.getImageUrl(), 10, false);
        this.bKh.setText(this.eIs.getContent());
    }
}
