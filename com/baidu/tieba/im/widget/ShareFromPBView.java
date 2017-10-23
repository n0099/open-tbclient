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
    private TextView aSZ;
    private TextView avY;
    private HeadImageView cJW;
    private ShareFromPBMsgData dFy;

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
        this.avY = (TextView) findViewById(d.h.chat_title);
        this.cJW = (HeadImageView) findViewById(d.h.chat_group_img);
        this.aSZ = (TextView) findViewById(d.h.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.avY.setTextColor(getContext().getResources().getColor(d.e.cp_cont_b));
            this.aSZ.setTextColor(getContext().getResources().getColor(d.e.cp_cont_f));
            return;
        }
        this.avY.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
        this.aSZ.setTextColor(getContext().getResources().getColor(d.e.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dFy = shareFromPBMsgData;
        wg();
    }

    private void wg() {
        this.avY.setText(this.dFy.getTitle());
        this.cJW.setDefaultResource(d.g.icon_default_ba_120);
        this.cJW.setAutoChangeStyle(false);
        this.cJW.c(this.dFy.getImageUrl(), 10, false);
        this.aSZ.setText(this.dFy.getContent());
    }
}
