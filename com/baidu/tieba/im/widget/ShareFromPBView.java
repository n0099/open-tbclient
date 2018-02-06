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
    private TextView bMB;
    private HeadImageView dZc;
    private ShareFromPBMsgData eOC;
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
        LayoutInflater.from(getContext()).inflate(d.h.share_from_pb_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(d.g.chat_title);
        this.dZc = (HeadImageView) findViewById(d.g.chat_group_img);
        this.bMB = (TextView) findViewById(d.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_b));
            this.bMB.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_g));
        this.bMB.setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eOC = shareFromPBMsgData;
        Ea();
    }

    private void Ea() {
        this.title.setText(this.eOC.getTitle());
        this.dZc.setDefaultResource(d.f.icon_default_ba_120);
        this.dZc.setAutoChangeStyle(false);
        this.dZc.startLoad(this.eOC.getImageUrl(), 10, false);
        this.bMB.setText(this.eOC.getContent());
    }
}
