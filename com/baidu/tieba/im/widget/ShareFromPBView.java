package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private TextView aHe;
    private HeadImageView bWg;
    private ShareFromPBMsgData daK;
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
        LayoutInflater.from(getContext()).inflate(u.h.share_from_pb_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(u.g.chat_title);
        this.bWg = (HeadImageView) findViewById(u.g.chat_group_img);
        this.aHe = (TextView) findViewById(u.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(u.d.cp_cont_b));
            this.aHe.setTextColor(getContext().getResources().getColor(u.d.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(u.d.cp_cont_g));
        this.aHe.setTextColor(getContext().getResources().getColor(u.d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.daK = shareFromPBMsgData;
        uY();
    }

    private void uY() {
        this.title.setText(this.daK.getTitle());
        this.bWg.setDefaultResource(u.f.icon_default_ba_120);
        this.bWg.setAutoChangeStyle(false);
        this.bWg.c(this.daK.getImageUrl(), 10, false);
        this.aHe.setText(this.daK.getContent());
    }
}
