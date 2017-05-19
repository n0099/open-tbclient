package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private TextView aOS;
    private TextView auU;
    private HeadImageView cdt;
    private ShareFromPBMsgData dcQ;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public ShareFromPBView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(w.j.share_from_pb_view, this);
        setOrientation(1);
        this.auU = (TextView) findViewById(w.h.chat_title);
        this.cdt = (HeadImageView) findViewById(w.h.chat_group_img);
        this.aOS = (TextView) findViewById(w.h.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.auU.setTextColor(getContext().getResources().getColor(w.e.cp_cont_b));
            this.aOS.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            return;
        }
        this.auU.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.aOS.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dcQ = shareFromPBMsgData;
        wh();
    }

    private void wh() {
        this.auU.setText(this.dcQ.getTitle());
        this.cdt.setDefaultResource(w.g.icon_default_ba_120);
        this.cdt.setAutoChangeStyle(false);
        this.cdt.c(this.dcQ.getImageUrl(), 10, false);
        this.aOS.setText(this.dcQ.getContent());
    }
}
