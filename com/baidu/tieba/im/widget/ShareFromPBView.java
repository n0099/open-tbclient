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
    private TextView aTl;
    private TextView awD;
    private HeadImageView cTC;
    private ShareFromPBMsgData dNr;

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
        this.awD = (TextView) findViewById(d.g.chat_title);
        this.cTC = (HeadImageView) findViewById(d.g.chat_group_img);
        this.aTl = (TextView) findViewById(d.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.awD.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_b));
            this.aTl.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_f));
            return;
        }
        this.awD.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_g));
        this.aTl.setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dNr = shareFromPBMsgData;
        wn();
    }

    private void wn() {
        this.awD.setText(this.dNr.getTitle());
        this.cTC.setDefaultResource(d.f.icon_default_ba_120);
        this.cTC.setAutoChangeStyle(false);
        this.cTC.startLoad(this.dNr.getImageUrl(), 10, false);
        this.aTl.setText(this.dNr.getContent());
    }
}
