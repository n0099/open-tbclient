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
    private TextView bKx;
    private TextView blI;
    private HeadImageView dVo;
    private ShareFromPBMsgData eKn;

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
        this.blI = (TextView) findViewById(d.g.chat_title);
        this.dVo = (HeadImageView) findViewById(d.g.chat_group_img);
        this.bKx = (TextView) findViewById(d.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.blI.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_b));
            this.bKx.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_f));
            return;
        }
        this.blI.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_g));
        this.bKx.setTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eKn = shareFromPBMsgData;
        DG();
    }

    private void DG() {
        this.blI.setText(this.eKn.getTitle());
        this.dVo.setDefaultResource(d.f.icon_default_ba_120);
        this.dVo.setAutoChangeStyle(false);
        this.dVo.startLoad(this.eKn.getImageUrl(), 10, false);
        this.bKx.setText(this.eKn.getContent());
    }
}
