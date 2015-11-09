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
    private TextView aBD;
    private TextView alz;
    private ShareFromPBMsgData bJr;
    private HeadImageView ben;

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
        this.alz = (TextView) findViewById(i.f.chat_title);
        this.ben = (HeadImageView) findViewById(i.f.chat_group_img);
        this.aBD = (TextView) findViewById(i.f.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.alz.setTextColor(getContext().getResources().getColor(i.c.cp_cont_b));
            this.aBD.setTextColor(getContext().getResources().getColor(i.c.cp_cont_f));
            return;
        }
        this.alz.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
        this.aBD.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.bJr = shareFromPBMsgData;
        vx();
    }

    private void vx() {
        this.alz.setText(this.bJr.getTitle());
        this.ben.setDefaultResource(i.e.icon_default_ba_120);
        this.ben.setAutoChangeStyle(false);
        this.ben.d(this.bJr.getImageUrl(), 10, false);
        this.aBD.setText(this.bJr.getContent());
    }
}
