package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private TextView aKM;
    private HeadImageView cmv;
    private ShareFromPBMsgData dty;
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
        LayoutInflater.from(getContext()).inflate(r.h.share_from_pb_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(r.g.chat_title);
        this.cmv = (HeadImageView) findViewById(r.g.chat_group_img);
        this.aKM = (TextView) findViewById(r.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(r.d.cp_cont_b));
            this.aKM.setTextColor(getContext().getResources().getColor(r.d.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
        this.aKM.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dty = shareFromPBMsgData;
        ww();
    }

    private void ww() {
        this.title.setText(this.dty.getTitle());
        this.cmv.setDefaultResource(r.f.icon_default_ba_120);
        this.cmv.setAutoChangeStyle(false);
        this.cmv.c(this.dty.getImageUrl(), 10, false);
        this.aKM.setText(this.dty.getContent());
    }
}
