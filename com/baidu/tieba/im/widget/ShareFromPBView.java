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
    private TextView bKp;
    private TextView blA;
    private HeadImageView dUT;
    private ShareFromPBMsgData eJS;

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
        this.blA = (TextView) findViewById(d.g.chat_title);
        this.dUT = (HeadImageView) findViewById(d.g.chat_group_img);
        this.bKp = (TextView) findViewById(d.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.blA.setTextColor(getContext().getResources().getColor(d.C0107d.cp_cont_b));
            this.bKp.setTextColor(getContext().getResources().getColor(d.C0107d.cp_cont_f));
            return;
        }
        this.blA.setTextColor(getContext().getResources().getColor(d.C0107d.cp_cont_g));
        this.bKp.setTextColor(getContext().getResources().getColor(d.C0107d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eJS = shareFromPBMsgData;
        DE();
    }

    private void DE() {
        this.blA.setText(this.eJS.getTitle());
        this.dUT.setDefaultResource(d.f.icon_default_ba_120);
        this.dUT.setAutoChangeStyle(false);
        this.dUT.startLoad(this.eJS.getImageUrl(), 10, false);
        this.bKp.setText(this.eJS.getContent());
    }
}
