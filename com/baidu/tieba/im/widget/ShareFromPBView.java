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
    private TextView aCy;
    private TextView alt;
    private ShareFromPBMsgData bIL;
    private HeadImageView bdx;

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
        this.alt = (TextView) findViewById(i.f.chat_title);
        this.bdx = (HeadImageView) findViewById(i.f.chat_group_img);
        this.aCy = (TextView) findViewById(i.f.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.alt.setTextColor(getContext().getResources().getColor(i.c.cp_cont_b));
            this.aCy.setTextColor(getContext().getResources().getColor(i.c.cp_cont_f));
            return;
        }
        this.alt.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
        this.aCy.setTextColor(getContext().getResources().getColor(i.c.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.bIL = shareFromPBMsgData;
        vw();
    }

    private void vw() {
        this.alt.setText(this.bIL.getTitle());
        this.bdx.setDefaultResource(i.e.icon_default_ba_120);
        this.bdx.setAutoChangeStyle(false);
        this.bdx.d(this.bIL.getImageUrl(), 10, false);
        this.aCy.setText(this.bIL.getContent());
    }
}
