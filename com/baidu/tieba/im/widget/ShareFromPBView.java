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
    private TextView aGn;
    private HeadImageView bUg;
    private ShareFromPBMsgData cXN;
    private TextView title;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        nl();
    }

    public ShareFromPBView(Context context) {
        super(context);
        nl();
    }

    private void nl() {
        LayoutInflater.from(getContext()).inflate(u.h.share_from_pb_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(u.g.chat_title);
        this.bUg = (HeadImageView) findViewById(u.g.chat_group_img);
        this.aGn = (TextView) findViewById(u.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(u.d.cp_cont_b));
            this.aGn.setTextColor(getContext().getResources().getColor(u.d.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(u.d.cp_cont_g));
        this.aGn.setTextColor(getContext().getResources().getColor(u.d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.cXN = shareFromPBMsgData;
        uY();
    }

    private void uY() {
        this.title.setText(this.cXN.getTitle());
        this.bUg.setDefaultResource(u.f.icon_default_ba_120);
        this.bUg.setAutoChangeStyle(false);
        this.bUg.c(this.cXN.getImageUrl(), 10, false);
        this.aGn.setText(this.cXN.getContent());
    }
}
