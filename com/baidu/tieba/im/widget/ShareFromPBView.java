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
    private TextView aQj;
    private TextView avH;
    private HeadImageView crH;
    private ShareFromPBMsgData dqi;

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
        this.avH = (TextView) findViewById(w.h.chat_title);
        this.crH = (HeadImageView) findViewById(w.h.chat_group_img);
        this.aQj = (TextView) findViewById(w.h.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.avH.setTextColor(getContext().getResources().getColor(w.e.cp_cont_b));
            this.aQj.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            return;
        }
        this.avH.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.aQj.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dqi = shareFromPBMsgData;
        ww();
    }

    private void ww() {
        this.avH.setText(this.dqi.getTitle());
        this.crH.setDefaultResource(w.g.icon_default_ba_120);
        this.crH.setAutoChangeStyle(false);
        this.crH.c(this.dqi.getImageUrl(), 10, false);
        this.aQj.setText(this.dqi.getContent());
    }
}
