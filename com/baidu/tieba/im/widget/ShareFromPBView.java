package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private HeadImageView ekN;
    private TextView eld;
    private ShareFromPBMsgData fdW;
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
        LayoutInflater.from(getContext()).inflate(e.h.share_from_pb_view, this);
        setOrientation(1);
        this.title = (TextView) findViewById(e.g.chat_title);
        this.ekN = (HeadImageView) findViewById(e.g.chat_group_img);
        this.eld = (TextView) findViewById(e.g.chat_group_desc);
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.title.setTextColor(getContext().getResources().getColor(e.d.cp_cont_b));
            this.eld.setTextColor(getContext().getResources().getColor(e.d.cp_cont_f));
            return;
        }
        this.title.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
        this.eld.setTextColor(getContext().getResources().getColor(e.d.cp_cont_g));
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.fdW = shareFromPBMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.fdW.getTitle());
        this.ekN.setDefaultResource(e.f.icon_default_ba_120);
        this.ekN.setAutoChangeStyle(false);
        this.ekN.startLoad(this.fdW.getImageUrl(), 10, false);
        this.eld.setText(this.fdW.getContent());
    }
}
