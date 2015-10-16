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
    private TextView aCJ;
    private TextView alu;
    private ShareFromPBMsgData bIW;
    private HeadImageView bdI;

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
        this.alu = (TextView) findViewById(i.f.chat_title);
        this.bdI = (HeadImageView) findViewById(i.f.chat_group_img);
        this.aCJ = (TextView) findViewById(i.f.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.alu.setTextColor(getContext().getResources().getColor(i.c.cp_cont_b));
            this.aCJ.setTextColor(getContext().getResources().getColor(i.c.cp_cont_f));
            return;
        }
        this.alu.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
        this.aCJ.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.bIW = shareFromPBMsgData;
        vw();
    }

    private void vw() {
        this.alu.setText(this.bIW.getTitle());
        this.bdI.setDefaultResource(i.e.icon_default_ba_120);
        this.bdI.setAutoChangeStyle(false);
        this.bdI.d(this.bIW.getImageUrl(), 10, false);
        this.aCJ.setText(this.bIW.getContent());
    }
}
