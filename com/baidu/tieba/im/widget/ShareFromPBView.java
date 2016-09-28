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
    private TextView aJT;
    private HeadImageView cho;
    private ShareFromPBMsgData dnP;
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
        this.cho = (HeadImageView) findViewById(r.g.chat_group_img);
        this.aJT = (TextView) findViewById(r.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(r.d.cp_cont_b));
            this.aJT.setTextColor(getContext().getResources().getColor(r.d.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
        this.aJT.setTextColor(getContext().getResources().getColor(r.d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dnP = shareFromPBMsgData;
        ws();
    }

    private void ws() {
        this.title.setText(this.dnP.getTitle());
        this.cho.setDefaultResource(r.f.icon_default_ba_120);
        this.cho.setAutoChangeStyle(false);
        this.cho.c(this.dnP.getImageUrl(), 10, false);
        this.aJT.setText(this.dnP.getContent());
    }
}
