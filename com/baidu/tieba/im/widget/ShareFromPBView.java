package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private TextView aMb;
    private TextView amV;
    private HeadImageView bFF;
    private ShareFromPBMsgData bFG;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public ShareFromPBView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(i.g.share_from_pb_view, this);
        setOrientation(1);
        this.amV = (TextView) findViewById(i.f.chat_title);
        this.bFF = (HeadImageView) findViewById(i.f.chat_group_img);
        this.aMb = (TextView) findViewById(i.f.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.amV.setTextColor(getContext().getResources().getColor(i.c.cp_cont_b));
            this.aMb.setTextColor(getContext().getResources().getColor(i.c.cp_cont_f));
            return;
        }
        this.amV.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
        this.aMb.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.bFG = shareFromPBMsgData;
        vE();
    }

    private void vE() {
        this.amV.setText(this.bFG.getTitle());
        this.bFF.setDefaultResource(i.e.icon_default_ba_120);
        this.bFF.setAutoChangeStyle(false);
        this.bFF.d(this.bFG.getImageUrl(), 10, false);
        this.aMb.setText(this.bFG.getContent());
    }
}
