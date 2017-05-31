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
    private TextView aOR;
    private TextView auE;
    private HeadImageView cjH;
    private ShareFromPBMsgData dim;

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
        this.auE = (TextView) findViewById(w.h.chat_title);
        this.cjH = (HeadImageView) findViewById(w.h.chat_group_img);
        this.aOR = (TextView) findViewById(w.h.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.auE.setTextColor(getContext().getResources().getColor(w.e.cp_cont_b));
            this.aOR.setTextColor(getContext().getResources().getColor(w.e.cp_cont_f));
            return;
        }
        this.auE.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
        this.aOR.setTextColor(getContext().getResources().getColor(w.e.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dim = shareFromPBMsgData;
        we();
    }

    private void we() {
        this.auE.setText(this.dim.getTitle());
        this.cjH.setDefaultResource(w.g.icon_default_ba_120);
        this.cjH.setAutoChangeStyle(false);
        this.cjH.c(this.dim.getImageUrl(), 10, false);
        this.aOR.setText(this.dim.getContent());
    }
}
