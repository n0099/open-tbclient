package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private TextView aFL;
    private HeadImageView bwA;
    private ShareFromPBMsgData csy;
    private TextView title;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        nq();
    }

    public ShareFromPBView(Context context) {
        super(context);
        nq();
    }

    private void nq() {
        LayoutInflater.from(getContext()).inflate(t.h.share_from_pb_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(t.g.chat_title);
        this.bwA = (HeadImageView) findViewById(t.g.chat_group_img);
        this.aFL = (TextView) findViewById(t.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(t.d.cp_cont_b));
            this.aFL.setTextColor(getContext().getResources().getColor(t.d.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
        this.aFL.setTextColor(getContext().getResources().getColor(t.d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.csy = shareFromPBMsgData;
        uX();
    }

    private void uX() {
        this.title.setText(this.csy.getTitle());
        this.bwA.setDefaultResource(t.f.icon_default_ba_120);
        this.bwA.setAutoChangeStyle(false);
        this.bwA.c(this.csy.getImageUrl(), 10, false);
        this.aFL.setText(this.csy.getContent());
    }
}
